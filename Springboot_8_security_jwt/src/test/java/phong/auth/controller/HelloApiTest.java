package phong.auth.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jayway.jsonpath.JsonPath;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import phong.auth.account.LoginRequest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@RunWith(SpringJUnit4ClassRunner.class)
//@WebMvcTest(JwtRestController.class)
//@SpringBootTest
//@TestConfiguration
//@RunWith(MockitoJUnitRunner.class)

//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = App.class)
//@WebMvcTest(JwtRestController.class)

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloApiTest {
    //    @Autowired
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;


//    @MockBean
//    AccountRepository accountRepository;
//
//    @MockBean
//    CustomUserDetailsService customUserDetailsService;
//
//    @MockBean
//    JwtTokenProvider jwtTokenProvider;
//
//    @MockBean
//    JwtRestController jwtRestController;

    @Spy
    LoginRequest loginRequest, loginRequestFail;

    String requestJson, requestJsonFail;

    @Before
    public void config() throws JsonProcessingException {
        MockitoAnnotations.openMocks(this);

        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();

        loginRequest = new LoginRequest("admin", "password");
        loginRequestFail = new LoginRequest("wrong-user", "wrong-password");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

        requestJson = ow.writeValueAsString(loginRequest);
        requestJsonFail = ow.writeValueAsString(loginRequestFail);
    }


    @Test
    public void testFailHelloForbidden() throws Exception {
        mvc.perform(get("/api/v1/hello")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }

    @Test
    public void testPassLoginOk() throws Exception {
        mvc.perform(post("/api/v1/login")
                        .content(requestJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testPassHelloAuth() throws Exception {
        MvcResult result = mvc.perform(post("/api/v1/login")
                        .content(requestJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.type", is("Bearer")))
                .andExpect(jsonPath("$.token", notNullValue()))
                .andReturn();

        String token = JsonPath.read(result.getResponse().getContentAsString(), "$.token");

        mvc.perform(get("/api/v1/hello")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("hello"));
    }

    @Test
    public void testFailLoginBadRequest() throws Exception {
        mvc.perform(post("/api/v1/login")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testFailLoginUnauthorized() throws Exception {
        mvc.perform(post("/api/v1/login")
                        .content(requestJsonFail)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }


}

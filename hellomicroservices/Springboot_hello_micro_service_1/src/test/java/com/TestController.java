package com;

import com.controller.ServiceToServiceController;
import com.model.DataModel;
import com.service.DataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ServiceToServiceController.class)
@ImportAutoConfiguration(RefreshAutoConfiguration.class)
//@SpringBootTest
public class TestController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DataService dataService;

    @Before
    public void setup() {
        Mockito.when(dataService.getDataModel()).thenReturn(new DataModel(100L, "mock_data"));
    }

    @Test
    public void testController() throws Exception {
        mockMvc.perform(get("/v1/data").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.id", is(100)));
    }

}

package com.auth.controller;

import com.auth.Utils;
import com.auth.jwt.JwtProvider;
import com.auth.model.CustomUserDetails;
import com.auth.model.CustomUser;
import com.auth.model.CustomUserRequest;
import com.auth.model.CustomUserResponse;
import com.auth.service.CustomUserRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
//@RequestMapping("/v1")
public class SecurityController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    CustomUserRequestService customUserRequestService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signup")
    public ResponseEntity<CustomUserResponse> signup(HttpServletRequest request, @RequestBody CustomUserRequest customUserRequest) {

        System.out.println("signup...");

        CustomUser customUser = new CustomUser();
        customUser.setUsername(customUserRequest.getUsername());
        customUser.setPassword(Utils.passwordEncode(customUserRequest.getPassword()));

        CustomUser savedCustomUser = customUserRequestService.saveUser(customUser);
        CustomUserResponse customUserResponse = new CustomUserResponse(savedCustomUser.getUsername(), "");

        return ResponseEntity.ok().body(customUserResponse);
    }

    @PostMapping("/log-in")
    public ResponseEntity<CustomUserResponse> login(@RequestBody CustomUserRequest customUserRequest) {

        System.out.println("login...");

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        customUserRequest.getUsername(),
                        customUserRequest.getPassword()
                )
        );

        System.out.println("login authen ...");

        SecurityContextHolder.getContext().setAuthentication(authentication);

        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
//        User user = customUserDetails.getUser();
        String jwt = jwtProvider.generateJwt(customUserDetails);
        CustomUserResponse customUserResponse = new CustomUserResponse(customUserDetails.getUsername(), jwt);

        return ResponseEntity.ok().body(customUserResponse);
    }

}

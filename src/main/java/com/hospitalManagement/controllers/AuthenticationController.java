package com.hospitalManagement.controllers;

import com.hospitalManagement.dto.LoginRequestDto;
import com.hospitalManagement.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private AuthService authService;
    @PostMapping("/authenticate")
    public String authenticate(@RequestBody LoginRequestDto loginRequestDto){
        return authService.authenticateUser(loginRequestDto);
    }
}

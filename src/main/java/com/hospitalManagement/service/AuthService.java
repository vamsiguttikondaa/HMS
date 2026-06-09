package com.hospitalManagement.service;

import com.hospitalManagement.dto.LoginRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final  AuthenticationManager authenticationManager;
    public String authenticateUser(LoginRequestDto loginRequestDto){
        try{

            Authentication authentication=authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequestDto.getUsername(),
                            loginRequestDto.getPassword()
                    )
            );
            System.out.println(authentication.getDetails());

            if(authentication.isAuthenticated()){
                return "auth";
            }
        }
        catch (Exception e){
            return e.getMessage();
        }
        return  null;
    }

}

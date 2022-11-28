package com.brs.securityconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
@CrossOrigin("*")
@RestController
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping(value = "/token")
    public ResponseEntity<?> createToken(@RequestBody LoginData loginData) throws Exception {
        try{
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginData.getUserName() , loginData.getPassword()));
        }
        catch (UsernameNotFoundException e)
        {
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }
        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(loginData.getUserName());
        String token = this.jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));

    }
}

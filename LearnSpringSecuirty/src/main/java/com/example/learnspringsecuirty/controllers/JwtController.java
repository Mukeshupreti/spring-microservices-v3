package com.example.learnspringsecuirty.controllers;

import java.time.Instant;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class JwtController {


  private JwtEncoder jwtEncoder;

  public JwtController(JwtEncoder jwtEncoder) {
    this.jwtEncoder = jwtEncoder;
  }

  // you can check what authenticate object contains
  @PostMapping("/authentication")
  public Authentication getAuthentication(Authentication authentication) {
    return authentication;
  }

  @PostMapping("/Jwttoken")
  public JwtResponse getJWTToken(Authentication authentication) {
    return new JwtResponse(createToken(authentication));
  }

  // JwtEncoder encode Jwtclaim set and send token.
  // which you can use with rest api in  Authorization: Bearer ${JWT_TOKEN}
  private String createToken(Authentication authentication) {
    var claims =
        JwtClaimsSet.builder()
            .issuer("self")
            .issuedAt(Instant.now())
            .expiresAt(Instant.now().plusSeconds(3600))
            .subject(authentication.getName())
            .claim("scope", createScope(authentication))
            .build();
    return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
  }
// set authorities in scope.
  private String createScope(Authentication authentication) {
    return authentication.getAuthorities().stream()
        .map(x -> x.getAuthority())
        .collect(Collectors.joining(" "));
  }
  record JwtResponse(String token) {}
}

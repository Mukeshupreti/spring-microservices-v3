package com.example.learnspringsecuirty.config.jwt;

import static org.springframework.security.config.Customizer.withDefaults;

import com.example.learnspringsecuirty.config.basic.BasicAuthSecurityConfiguration;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration

/**
 * comment @Configuration to enable
 {@link com.example.learnspringsecuirty.config.basic.BasicAuthSecurityConfiguration}

 */


public class JwtAuthSecurityConfiguration {

  @Bean
  SecurityFilterChain basicSecurityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
    http.sessionManagement(
        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

    http.csrf(csrf -> csrf.disable());
    http.httpBasic(withDefaults());

    // enabling frames for h2 console
    http.headers(
        headers -> headers.frameOptions(frameOptionsConfig -> frameOptionsConfig.sameOrigin()));
    // add jwt configuration

    http.oauth2ResourceServer(
        OAuth2ResourceServerConfigurer ->
            OAuth2ResourceServerConfigurer.jwt(
                jwtConfigurer -> jwtConfigurer.decoder(jwtDecoder(rsaKey(keyPair())))));

    return http.build();
  }

  @Bean
  public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
            .build();
  }
  // implementation 2 : JDBC with h2 to store credential
  @Bean
  public UserDetailsService userDetailService(DataSource dataSource) {
    var user =
        User.withUsername("mukesh")
            // .password("{noop}upreti")
            .password(passwordEncoder().encode("upreti"))
            .roles("USER")
            .build();
    var admin =
        User.withUsername("admin")
            // .password("{noop}upreti")
            .password(passwordEncoder().encode("upreti"))
            .roles("ADMIN")
            .build();
    JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
    jdbcUserDetailsManager.createUser(user);
    jdbcUserDetailsManager.createUser(admin);

    return jdbcUserDetailsManager;
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {

    return new BCryptPasswordEncoder();
  }


// step 1 : create KeyPair

  @Bean
  public KeyPair keyPair() {
    KeyPairGenerator keyPairGenerator = null;
    try {
      keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
    keyPairGenerator.initialize(2048);
    return keyPairGenerator.generateKeyPair();
  }
// step 2 : from key pair create RSA key ( with public and private key)
  @Bean
  public RSAKey rsaKey(KeyPair keyPair) {
    RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
    RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
    return new RSAKey.Builder(publicKey)
        .privateKey(privateKey)
        .keyID(UUID.randomUUID().toString()) // Optional: assign a unique key ID
        .build();
  }
// step 3 : create JwkSource and set RSA key inside JWKset of JwkSource
  @Bean
  public JWKSource jwkSource(RSAKey rsaKey) {
    var jwkSet = new JWKSet(rsaKey);
    return ((jwkSelector, securityContext) -> jwkSelector.select(jwkSet));
  }
/// Step 4 :create jwtencoder with jwk source to encode
  @Bean
  public JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource) {
    return new NimbusJwtEncoder(jwkSource);
  }


  /// create JwtDecoder with public key to decode.
  @Bean
  public JwtDecoder jwtDecoder(RSAKey rsaKey) {

    try {
      return NimbusJwtDecoder.withPublicKey((rsaKey.toRSAPublicKey())).build();
    } catch (JOSEException e) {
      throw new RuntimeException(e);
    }
  }


}

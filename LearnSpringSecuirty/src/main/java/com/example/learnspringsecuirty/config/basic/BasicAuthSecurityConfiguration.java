package com.example.learnspringsecuirty.config.basic;

import static org.springframework.security.config.Customizer.withDefaults;

import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BasicAuthSecurityConfiguration {

/*what to comment in case if you don't need below basicauth configuration
        comment @Configuration* of this class /
public class BasicAuthSecurityConfiguration {

/*  for all the put and post method for session orriented application csrf is required.
            for stateless application csrf is not required.*/

/*  csrf is not required if no session is involved. (stateless) as csrf can occur in session only.
  so if it is not require you can disable it.

  SpringBootWebSecurityConfiguration- you can see all the default spring behavior.


  */

/*
Example one of securityFilter chain.

http.authorizeHttpRequests(customer) ==> as this accept customier class which have cutomize consumer function.
so you can pass any lamda function.
example http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
and so on in all class if it takes customizer it can accept lamda function as customerier is function interface
*/

/*
  @Bean
  SecurityFilterChain basicSecurityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
    http.sessionManagement(
        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

    // if you disable csrf then you can call post method without csrf token.
    http.csrf(csrf -> csrf.disable());
    // http.formLogin(withDefaults()); /// this will show login form. disable it if you dont want
    // InMemoryUserDetailsManager
    http.httpBasic(withDefaults());
    http.cors(cors -> cors.configurationSource(corsConfigurationSource()));
  //  http.cors(()=>corsConfigurer());

    // enabling frames for h2 console
    http.headers(
        headers -> headers.frameOptions(frameOptionsConfig -> frameOptionsConfig.sameOrigin()));

    return http.build();
  }
*/


  //Filter chain
  // authenticate all requests
  //basic authentication
  //disabling csrf
  //stateless rest api

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //1: Response to preflight request doesn't pass access control check
    //2: basic auth
    return
            http
                    .authorizeHttpRequests(
                            auth ->
                                    auth
                                            .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                                            .requestMatchers( "/api/manage/**").permitAll()
                                            .anyRequest().authenticated()
                    )
                    .httpBasic(Customizer.withDefaults())
                    // this will make session stateless and in stateless session we dont need csrf
                    .sessionManagement(
                            session -> session.sessionCreationPolicy
                                    (SessionCreationPolicy.STATELESS))
                    // .csrf().disable() Deprecated in SB 3.1.x
    //.cors(cors -> cors.configurationSource(corsConfigurationSource()))
                    .csrf(csrf -> csrf.disable()) // Starting from SB 3.1.x using Lambda DSL
                    // .csrf(AbstractHttpConfigurer::disable) // Starting from SB 3.1.x using Method Reference

                    .build();
  }

  /**************************************************************/
//  Below will configure the cors policy for all the controller
//  @Bean
//  public CorsConfigurationSource corsConfigurationSource() {
//    CorsConfiguration configuration = new CorsConfiguration();
//    configuration.addAllowedOrigin("http://localhost:3000"); // Frontend origin
//    configuration.addAllowedMethod("*"); // Allow all HTTP methods
//    configuration.addAllowedHeader("*"); // Allow all headers
//    configuration.setAllowCredentials(true); // Allow cookies if needed
//    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//    source.registerCorsConfiguration("/**", configuration); // Apply to all endpoints
//    return source;
//  }

/*and if you want to apply cors to specific controller then you can do like below for  only origin http://localhost:3000

    @CrossOrigin(origins = "http://localhost:3000")
    @RestController
    @RequestMapping("/api/manage")
    public class ManageController {
        @GetMapping("/hello")
        public*/
  /**************************************************************/


  // Implementation #1 : InMemoryUserDetailsManager : creating user in in-membory database (no external database like h2)
  // Step1 :comment spring.security credential   in application property and disable

          /*#spring.security.user.name=mukesh
          #spring.security.user.password=upreti*/
  // http.formLogin(withDefaults());

  // Step 2: comment out h2 database things in application.properties.
  /*  @Bean
      public UserDetailsService userDetailsService() {
          var admin = User.withUsername("mukesh")
                  .password("{noop}upreti")
                  .roles("USER")
                  .build();
          // remember when you put password you have to put upreti not {noop}upreti
          // {noop} => is requried to put else spring security will give you error no encoded password

          var user = User.withUsername("admin")
                  .password("{noop}upreti")
                  .roles("USER")
                  .build();

          return new InMemoryUserDetailsManager(admin, user);
      }*/

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
           // .password(passwordEncoder().encode("upreti"))
                .password("upreti")
                .passwordEncoder(str -> passwordEncoder().encode(str))
            .roles("ADMIN")
            .build();
    JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
    jdbcUserDetailsManager.createUser(user);
    jdbcUserDetailsManager.createUser(admin);

    return jdbcUserDetailsManager;
  }
// bcrypt and scrypt are hashing algorithm store  password in hashed format.
//  when user enter password than it will be hashed and compare with hashed password in database.
///  after putting the BCryptPasswordEncoder you dont need  // .password("{noop}upreti")
// encoding -- reverserable --- SHA-256 ,MP3 , usage - compression , streaming
// encryption -- reverserable ,encoding with credential usage - data validation  (two type :symmetric and Asymmetic (public and private)
// hashing -- irreversable - usage -data integrity
///  here dont get confused by name BCryptPasswordEncoder ("encoder) actually this is hashing
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {

    return new BCryptPasswordEncoder();
  }

  @Bean
  public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder()
            ///  org/springframework/security/core/userdetails/jdbc/users.ddl  creating embeded database with h2.
        .setType(EmbeddedDatabaseType.H2)

            ///  creating user and other tables from ddl  org/springframework/security/core/userdetails/jdbc/users.ddl
/*    create table users(username varchar_ignorecase(50) not null primary key,password varchar_ignorecase(500) not null,enabled boolean not null);
    create table authorities (username varchar_ignorecase(50) not null,authority varchar_ignorecase(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
    create unique index ix_auth_username on authorities (username,authority);*/
            .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
        .build();
  }

//  @Bean
//  public WebMvcConfigurer corsConfigurer() {
//    return new WebMvcConfigurer() {
//      public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedMethods("*")
//                .allowedOrigins("http://localhost:3000");
//      }
//    };
//  }




}

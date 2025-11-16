package com.in28minutes.rest.webservices.restfulwebservices.customAutoconfiguration;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/* Example of create your custom autoconfigration */

/*
Step 1 : create and configuration with ConditionalOnProperty to enable
autoconfiguration only when the property is set to true eg  "my.feature.enabled"

Step 2: put you configuration in spring.factories to register you configuration
eg :
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
com.in28minutes.rest.webservices.restfulwebservices.customAutoconfiguration.MyFeatureAutoConfiguration

Step 3 : enable property my.feature.enabled=true

Step 4: ch

*/


@Configuration
@ConditionalOnProperty(name = "my.feature.enabled", havingValue = "true", matchIfMissing = false)
public class MyFeatureAutoConfiguration {

    @Bean
    public MyService myService() {
        return new MyService();
    }
}


package com.in28minutes.rest.webservices.restfulwebservices;

import com.in28minutes.rest.webservices.restfulwebservices.customAutoconfiguration.MyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(properties = "my.feature.enabled=true")
public class MyAutoConfigurationTest {


    @Autowired
    private MyService myService;

    @Test
    void testAutoConfigurationLoads() {
        assertThat(myService).isNotNull();
    }
}

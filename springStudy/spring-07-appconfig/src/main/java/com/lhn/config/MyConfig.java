package com.lhn.config;

import com.lhn.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.lhn")
@Import(com.lhn.config.MyConfig2.class)
public class MyConfig {
    @Bean
    public User user(){
        return new User();
    }
}

package com.phexum.wf.infrastructure.common.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class Config {
    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }
}

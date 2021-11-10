package com.phexum.wf.infrastructure;

import com.phexum.wf.domain.common.DomainComponent;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.awt.*;

@SpringBootApplication
@ComponentScan(
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {DomainComponent.class})
        },basePackages ={"com.phexum.wf.domain","com.phexum.wf.infrastructure"}

)
public class InfraStructureApp {
    public static void main(String[] args) {
        SpringApplication.run(InfraStructureApp.class, args);
    }


}

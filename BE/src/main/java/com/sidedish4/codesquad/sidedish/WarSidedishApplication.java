package com.sidedish4.codesquad.sidedish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WarSidedishApplication extends SpringBootServletInitializer {

    @Override
    public SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(WarSidedishApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(WarSidedishApplication.class, args);
    }
}

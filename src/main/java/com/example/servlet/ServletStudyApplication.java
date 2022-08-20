package com.example.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ServletComponentScan   // 서블릿 자동등록
@SpringBootApplication
public class ServletStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServletStudyApplication.class, args);
    }
}

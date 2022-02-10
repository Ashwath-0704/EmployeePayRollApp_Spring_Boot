package com.bridgelabz.employeepayrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class EmployeePayRollAppApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(EmployeePayRollAppApplication.class, args);
        log.info("EmployeePayRoll AppApplication Stated in {} Environment", applicationContext.getEnvironment().getProperty("environment"));
        log.info("EmployeePayRoll AppApplication DataBase is {} ", applicationContext.getEnvironment().getProperty("spring.datasource.username"));
    }
}

package com.bridgelabz.employeepayrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * UC1 : Create an Employee Payroll Spring Project to cater to REST Request from Employee Payroll UI - Here we will reuse the Employee Payroll Frontend UI
 *               we have already developed
 *             - Instead of making REST call to JSONServer will now make server calls to Employee Payroll Spring App
 *             - Also test the REST API using CURL Commands
 *
 * section 3 -> UC2 : Use Lombok Library for Logging
 */
@SpringBootApplication
@Slf4j
public class EmployeePayRollAppApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext =SpringApplication.run(EmployeePayRollAppApplication.class, args);
        log.info("EmployeePayRoll AppApplication Stated in {} Environment", applicationContext.getEnvironment().getProperty("environment"));
        log.info("EmployeePayRoll AppApplication DataBase is {} ", applicationContext.getEnvironment().getProperty("spring.datasource.username"));
    }
}

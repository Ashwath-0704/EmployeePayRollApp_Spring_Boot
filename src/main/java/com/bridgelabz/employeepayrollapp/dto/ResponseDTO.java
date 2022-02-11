package com.bridgelabz.employeepayrollapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * @author -> Ashwath Naidu <ashwath.bly@gmail.com>
 * @version -> :: Spring Boot :: (v2.6.3)
 *
 * Section 2 -> UC1: Introducing DTO and Model to Employee Payroll App
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    private String message;
    private Object data;
}

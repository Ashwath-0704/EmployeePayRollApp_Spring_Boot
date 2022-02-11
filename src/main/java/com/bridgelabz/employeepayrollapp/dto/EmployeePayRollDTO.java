package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.ElementCollection;
import javax.validation.constraints.*;
import java.util.List;

/**
 * @author -> Ashwath Naidu <ashwath.bly@gmail.com>
 * @version -> :: Spring Boot :: (v2.6.3)
 *
 *
 * Section 2 -> UC1: Introducing DTO and Model to Employee Payroll App
 *
 * section 3: UC1 Use Lombok Library to auto generate getters and setters for the DTO
 *
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayRollDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z ]{2,}$" , message = "Invalid person full name")
    private String name;
    private String profilePic;
    private String gender;
    @ElementCollection
    private List<String> departments;
    private String startDate;
    private long salary;
    @NotBlank
    private String note;
}

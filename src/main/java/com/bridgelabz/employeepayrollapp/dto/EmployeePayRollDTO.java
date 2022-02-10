package com.bridgelabz.employeepayrollapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

/**
 * @author -> Ashwath Naidu <ashwath.bly@gmail.com>
 * @version -> :: Spring Boot :: (v2.6.3)
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayRollDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z ]{2,}$" , message = "Invalid person full name")
    private String name;
   /* private String profilePic;
    private String gender;
    private List<String> department;
    private LocalDate startDate;*/
    private long salary;
    /*private String note;*/
}

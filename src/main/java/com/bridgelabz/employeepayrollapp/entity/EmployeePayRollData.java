package com.bridgelabz.employeepayrollapp.entity;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * @author -> Ashwath Naidu <ashwath.bly@gmail.com>
 * @version -> :: Spring Boot :: (v2.6.3)
 *
 * Section 2 -> UC1: Introducing DTO and Model to Employee Payroll App
 *
 */
@Entity
@Table(name = "EmployeePayRollDataList")
@Data
@ToString
@NoArgsConstructor
public class EmployeePayRollData {
    @Id
    private long employeeId;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z ]{2,}$" , message = "Invalid person full name")
    private String name;
    @NotBlank(message = "Profile pic can not be null")
    private String profilePic;
    @Pattern(regexp = "male|female" , message = "Invalid gender input")
    private String gender;

    @ElementCollection
    @CollectionTable(name = "EmployeePayRoll_Department",joinColumns = @JoinColumn(name = "id"))
    private List<String> department;
    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull (message = "start data should not be empty")
    private String startDate;
    @Min(value = 500,message = "Min salary should start with 500")
    private long salary;
    @NotBlank(message = "Note cant be blank or empty")
    private String note;

    public EmployeePayRollData(long employeeId, EmployeePayRollDTO employeePayRollDTO) {
        this.employeeId = employeeId;
        this.name=employeePayRollDTO.getName();
        this.profilePic=employeePayRollDTO.getProfilePic();
        this.gender=employeePayRollDTO.getGender();
        this.department=employeePayRollDTO.getDepartments();
        this.startDate=employeePayRollDTO.getStartDate();
        this.salary=employeePayRollDTO.getSalary();
        this.note=employeePayRollDTO.getNote();
    }
}

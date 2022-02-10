package com.bridgelabz.employeepayrollapp.entity;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

/**
 * @author -> Ashwath Naidu <ashwath.bly@gmail.com>
 * openjdk version "11.0.12" 2021-07-20
 * OpenJDK Runtime Environment 18.9 (build 11.0.12+7)
 * OpenJDK 64-Bit Server VM 18.9 (build 11.0.12+7, mixed mode)
 */
@Entity
@Table(name = "EmployeePayRollDataNew")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayRollData {
    @Id
    private long employeeId;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z ]{2,}$" , message = "Invalid person full name")
    private String name;
    /*private String profilePic;
    private String gender;
    private List<String> department;
    private LocalDate startDate;*/
    private long salary;
    /*private String note;*/

    /**
     * @purpose -> parameterized constructor
     * @param employeeId
     * @param employeePayRollDTO
     */
    public EmployeePayRollData(long employeeId, EmployeePayRollDTO employeePayRollDTO) {
        this.employeeId = employeeId;
        this.name=employeePayRollDTO.getName();
       /* this.profilePic=employeePayRollDTO.getProfilePic();
        this.gender=employeePayRollDTO.getGender();
        this.department=employeePayRollDTO.getDepartment();
        this.startDate=employeePayRollDTO.getStartDate();*/
        this.salary=employeePayRollDTO.getSalary();
      /*  this.note=employeePayRollDTO.getNote();*/
    }
}

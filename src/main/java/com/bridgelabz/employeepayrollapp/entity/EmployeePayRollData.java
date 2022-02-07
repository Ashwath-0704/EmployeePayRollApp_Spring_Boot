package com.bridgelabz.employeepayrollapp.entity;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * @author -> Ashwath Naidu <ashwath.bly@gmail.com>
 * openjdk version "11.0.12" 2021-07-20
 * OpenJDK Runtime Environment 18.9 (build 11.0.12+7)
 * OpenJDK 64-Bit Server VM 18.9 (build 11.0.12+7, mixed mode)
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayRollData {
    private int employeeId;
    private String name;
    private long salary;

    /**
     * @purpose -> parameterized constructor
     * @param employeeId
     * @param employeePayRollDTO
     */
    public EmployeePayRollData(int employeeId, EmployeePayRollDTO employeePayRollDTO) {
        this.employeeId = employeeId;
        this.name=employeePayRollDTO.getName();
        this.salary=employeePayRollDTO.getSalary();
    }
}

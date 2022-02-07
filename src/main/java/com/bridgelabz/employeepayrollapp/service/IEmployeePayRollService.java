package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;
import com.bridgelabz.employeepayrollapp.entity.EmployeePayRollData;

import java.util.List;
/**
 * @author -> Ashwath Naidu <ashwath.bly@gmail.com>
 * openjdk version "11.0.12" 2021-07-20
 * OpenJDK Runtime Environment 18.9 (build 11.0.12+7)
 * OpenJDK 64-Bit Server VM 18.9 (build 11.0.12+7, mixed mode)
 */

public interface IEmployeePayRollService {
    List<EmployeePayRollData> getEmployeePayRollData();
    EmployeePayRollData getEmployeeOayRollDataById(int employeeId);
    EmployeePayRollData createEmployeePayRollData(EmployeePayRollDTO employeePayRollDTO);
    EmployeePayRollData updateEmployeePayRollData(EmployeePayRollDTO employeePayRollDTO);
    void deleteEmployeePayRollData(int employeeId);
}

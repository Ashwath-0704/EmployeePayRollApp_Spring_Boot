package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;
import com.bridgelabz.employeepayrollapp.entity.EmployeePayRollData;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Stack;

/**
 * @author -> Ashwath Naidu <ashwath.bly@gmail.com>
 * @version -> :: Spring Boot :: (v2.6.3)
 */

public interface IEmployeePayRollService {
    List<EmployeePayRollData> getEmployeePayRollData();
    EmployeePayRollData getEmployeeOayRollDataById(Long employeeId);
    EmployeePayRollData createEmployeePayRollData(EmployeePayRollDTO employeePayRollDTO);
    EmployeePayRollData updateEmployeePayRollData( long Id,String name,long salary);
    String deleteEmployeePayRollData(Long employeeId);
}

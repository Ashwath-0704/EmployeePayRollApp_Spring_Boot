package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.entity.EmployeePayRollData;

import java.util.List;

/**
 * @author -> Ashwath Naidu <ashwath.bly@gmail.com>
 * @version -> :: Spring Boot :: (v2.6.3)
 */

public interface IEmployeePayRollService {
    List<EmployeePayRollData> getEmployeePayRollData();
    EmployeePayRollData getEmployeeOayRollDataById(Long employeeId);
    EmployeePayRollData updateEmployeePayRollData( long emplId,String name, String profilePic, String gender,  List<String> departments, String startDate, long salary, String note);
    String deleteEmployeePayRollData(Long employeeId);
    EmployeePayRollData createEmployeePayRollData(String name, String profilePic, String gender,  List<String> departments, String startDate, long salary, String note);
    List<EmployeePayRollData> findEmployeePayRollDataByDepartment(String department);
    List findEmployeePayRollDataCountByGender();
    List findEmployeePayRollDataSumOfSalaryBYGender();
}

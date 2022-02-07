package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;
import com.bridgelabz.employeepayrollapp.entity.EmployeePayRollData;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
/**
 * @author -> Ashwath Naidu <ashwath.bly@gmail.com>
 * openjdk version "11.0.12" 2021-07-20
 * OpenJDK Runtime Environment 18.9 (build 11.0.12+7)
 * OpenJDK 64-Bit Server VM 18.9 (build 11.0.12+7, mixed mode)
 */
@Service
public class EmployeePayRollServiceImpl implements IEmployeePayRollService {

    /**
     * @return -> it returns the al the data from database
     */
    @Override
    public List<EmployeePayRollData> getEmployeePayRollData() {
        List<EmployeePayRollData> employeePayRollDataArrayList = new ArrayList<>();
        employeePayRollDataArrayList.add(new EmployeePayRollData(1,new EmployeePayRollDTO("ashwath",50000)));
        return employeePayRollDataArrayList;
    }

    /**
     * @param employeeId
     * @return -> It returns the employee data that matches to given employee ID
     */
    @Override
    public EmployeePayRollData getEmployeeOayRollDataById(int employeeId) {
        EmployeePayRollData employeePayRollData = null;
        employeePayRollData = new EmployeePayRollData(1,new EmployeePayRollDTO("ashwath",50000));
        return employeePayRollData;
    }

    /**
     * @param employeePayRollDTO
     * @return -> It returns creates new employee data into the database
     */
    @Override
    public EmployeePayRollData createEmployeePayRollData(EmployeePayRollDTO employeePayRollDTO) {
        EmployeePayRollData employeePayRollData = null;
        employeePayRollData = new EmployeePayRollData(1,employeePayRollDTO);
        return employeePayRollData;
    }

    /**
     * @param employeePayRollDTO
     * @return -> It returns the updated employee data
     */
    @Override
    public EmployeePayRollData updateEmployeePayRollData(EmployeePayRollDTO employeePayRollDTO) {
        EmployeePayRollData employeePayRollData= null;
        employeePayRollData= new EmployeePayRollData(1,employeePayRollDTO);
        return employeePayRollData;
    }

    @Override
    public void deleteEmployeePayRollData(int employeeId) {}
}

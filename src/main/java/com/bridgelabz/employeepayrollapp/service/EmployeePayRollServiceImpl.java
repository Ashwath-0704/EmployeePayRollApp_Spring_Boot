package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;
import com.bridgelabz.employeepayrollapp.entity.EmployeePayRollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayRollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author -> Ashwath Naidu <ashwath.bly@gmail.com>
 * @version -> :: Spring Boot :: (v2.6.3)
 *
 * section 2 -> UC2: Introducing Services Layer in Employee Payroll App
 * section 2 -> UC3: Ability for the Services Layer to store the Employee Payroll Data
 */
@Service
@Slf4j
public class EmployeePayRollServiceImpl implements IEmployeePayRollService {
    AtomicLong atomicLong = new AtomicLong();
    EmployeePayRollData employeePayRollData = null;
    @Autowired
    EmployeePayRollRepository employeePayRollRepository;

    /**
     * @return -> it returns the al the data from database
     */
    @Override
    public List<EmployeePayRollData> getEmployeePayRollData() { return employeePayRollRepository.findAll(); }

    /**
     * @param employeeId
     * @return -> It returns the employee data that matches to given employee ID
     */
    @Override
    public EmployeePayRollData getEmployeeOayRollDataById(Long employeeId) {
        return employeePayRollRepository.findById(employeeId).get();
    }

    /**
     *
     * @param name
     * @param profilePic
     * @param gender
     * @param departments
     * @param startDate
     * @param salary
     * @param note
     * @return -> It returns creates new employee data into the database
     */
    @Override
    public EmployeePayRollData createEmployeePayRollData(String name, String profilePic, String gender,  List<String> departments, String startDate, long salary, String note) {
        employeePayRollData = new EmployeePayRollData(atomicLong.incrementAndGet(),new EmployeePayRollDTO(name,profilePic,gender,departments,startDate,salary,note));
        log.debug("EmployeePayRoll Data : "+employeePayRollData.toString());
        return employeePayRollRepository.save(employeePayRollData);
    }

    /**
     * @param emplId
     * @param name
     * @param profilePic
     * @param gender
     * @param departments
     * @param startDate
     * @param salary
     * @param note
     * @returnIt -> it updates existing employee data into the database by ID
     */
    @Override
    public EmployeePayRollData updateEmployeePayRollData(long emplId,String name, String profilePic, String gender,  List<String> departments, String startDate, long salary, String note) {
        employeePayRollData= new EmployeePayRollData(emplId,new EmployeePayRollDTO(name,profilePic,gender,departments,startDate,salary,note));
        return employeePayRollRepository.save(employeePayRollData);
    }

    /**
     * @param employeeId
     * @return -> It returns the deleted employee ID
     */
    @Override
    public String deleteEmployeePayRollData(Long employeeId) {employeePayRollRepository.deleteById(employeeId); return "Employee with ID -> (" + employeeId + " ) has deleted form the database";}

    @Override
    public List<EmployeePayRollData> findEmployeePayRollDataByDepartment(String department) { return employeePayRollRepository.findEmployeePayRollDataByDepartment(department); }

    @Override
    public List findEmployeePayRollDataCountByGender() { return employeePayRollRepository.findCountByGender(); }

    @Override
    public List findEmployeePayRollDataSumOfSalaryBYGender() { return employeePayRollRepository.findSumOfSalaryByGender(); }

}

package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.entity.EmployeePayRollData;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayRollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author -> Ashwath Naidu <ashwath.bly@gmail.com>
 * @version -> :: Spring Boot :: (v2.6.3)
 */

@RestController
@RequestMapping("/employeepayrollservice")
@Slf4j
public class EmployeePayRollController {

    EmployeePayRollData employeePayRollData;
    List<EmployeePayRollData> employeePayRollDataList;
    @Autowired
    IEmployeePayRollService iEmployeePayRollService;

    /**
     * @return -> it returns the al the data from database
     */

    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO> getEmployeePaYRollData(){
        employeePayRollDataList = iEmployeePayRollService.getEmployeePayRollData();
        /*if (employeePayRollDataList.size()<=0){
            throw new NestedRuntimeException("Employee Payroll data is not found, check your path") {
            };
        }*/
        ResponseDTO getting_call_successfully = new ResponseDTO("Getting call successfully", employeePayRollDataList);
        return new ResponseEntity<>(getting_call_successfully, HttpStatus.OK);
    }

    /**
     *
     * @param emailID
     * @return -> It returns the employee data that matches to given employee ID
     */
    @GetMapping(value = {"/get/{emailID}"})
    public ResponseEntity<ResponseDTO> getEmployeePaYRollDataByID(@PathVariable long emailID){
        employeePayRollData = iEmployeePayRollService.getEmployeeOayRollDataById(emailID);
        ResponseDTO responseDTO = new ResponseDTO("Get call for ID successfully",employeePayRollData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
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
    @PostMapping(value = {"/create"})
    public ResponseEntity<ResponseDTO> createEmployeePaYRollData(@RequestParam String name, @RequestParam String profilePic, @RequestParam String gender, @RequestParam  List<String> departments, @RequestParam String startDate, @RequestParam long salary, @RequestParam String note){
        employeePayRollData = iEmployeePayRollService.createEmployeePayRollData(name,profilePic,gender,departments,startDate,salary,note);
        ResponseDTO responseDTO = new ResponseDTO("created employee payroll data successfully",employeePayRollData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * @param empId
     * @param name
     * @param profilePic
     * @param gender
     * @param departments
     * @param startDate
     * @param salary
     * @param note
     * @return -> It returns the updated employee data
     */
    @PutMapping(value = {"/update"})
    public ResponseEntity<ResponseDTO> updateEmployeePaYRollData(@RequestParam long empId,@RequestParam String name, @RequestParam String profilePic, @RequestParam String gender, @RequestParam  List<String> departments, @RequestParam String startDate, @RequestParam long salary, @RequestParam String note){
        employeePayRollData = iEmployeePayRollService.updateEmployeePayRollData(empId,name,profilePic,gender,departments,startDate,salary,note);
        ResponseDTO responseDTO = new ResponseDTO("update employee payroll data successfully",employeePayRollData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    /**
     * @param employId
     * @return ->  It returns the deleted employee ID number
     */
    @DeleteMapping(value = {"/delete/{employId}"})
    public ResponseEntity<ResponseDTO> deleteEmployeePaYRollData(@PathVariable Long employId){
        iEmployeePayRollService.deleteEmployeePayRollData(employId);
        ResponseDTO responseDTO = new ResponseDTO("update employee payroll data successfully", "Deleted ID is"+employId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

/* It SQL Queries Operation */

    /**
     * @param department
     * @return -> It returns the employee data by department
     */
    @GetMapping(value = {"/department/{department}"})
    public ResponseEntity<ResponseDTO> findEmployeePaYRollDataByDepartment(@PathVariable String department){
        employeePayRollDataList= iEmployeePayRollService.findEmployeePayRollDataByDepartment(department);
        ResponseDTO responseDTO = new ResponseDTO("Getting employee payroll data by department successfully",employeePayRollDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * @return -> It returns list of count of all the employee by gender
     */
    @GetMapping(value = {"/genderCount"})
    public ResponseEntity<ResponseDTO> findAllEmployeeCountByGender(){
        List countByGender = iEmployeePayRollService.findEmployeePayRollDataCountByGender();
        ResponseDTO responseDTO = new ResponseDTO("Getting all employee pay count by gender successfully",countByGender);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * @return -> it returns the list of gender with SUM of employee salary
     */
    @GetMapping(value = {"/sumOfSalaryByGender"})
    public ResponseEntity<ResponseDTO> findEmployeeSumOfSalaryBYGender(){
        List countByGender = iEmployeePayRollService.findEmployeePayRollDataSumOfSalaryBYGender();
        ResponseDTO responseDTO = new ResponseDTO("Getting all employee pay count by gender successfully",countByGender);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


}

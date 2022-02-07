package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.entity.EmployeePayRollData;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayRollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author -> Ashwath Naidu <ashwath.bly@gmail.com>
 * openjdk version "11.0.12" 2021-07-20
 * OpenJDK Runtime Environment 18.9 (build 11.0.12+7)
 * OpenJDK 64-Bit Server VM 18.9 (build 11.0.12+7, mixed mode)
 */

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayRollController {

    @Autowired
    IEmployeePayRollService iEmployeePayRollService;

    /**
     * @return -> it returns the al the data from database
     */
    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO> getEmployeePaYRollData(){
        List<EmployeePayRollData> employeePayRollData =null;
        employeePayRollData = iEmployeePayRollService.getEmployeePayRollData();
        ResponseDTO responseDTO = new ResponseDTO("Getting call successfully",employeePayRollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * @param emailID
     * @return -> It returns the employee data that matches to given employee ID
     */
    @GetMapping(value = {"/get/{emailID}"})
    public ResponseEntity<ResponseDTO> getEmployeePaYRollData(@PathVariable int emailID){
        EmployeePayRollData employeePayRollData =null;
        employeePayRollData = iEmployeePayRollService.getEmployeeOayRollDataById(emailID);
        ResponseDTO responseDTO = new ResponseDTO("Get call for ID successfully",employeePayRollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * @param employeePayRollDTO
     * @return -> It returns creates new employee data into the database
     */
    @PostMapping(value = {"/create"})
    public ResponseEntity<ResponseDTO> createEmployeePaYRollData(@RequestParam EmployeePayRollDTO employeePayRollDTO){
        EmployeePayRollData employeePayRollData =null;
        employeePayRollData = iEmployeePayRollService.createEmployeePayRollData(employeePayRollDTO);
        ResponseDTO responseDTO = new ResponseDTO("created employee payroll data successfully",employeePayRollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * @param employeePayRollDTO
     * @return -> It returns the updated employee data
     */
    @PutMapping(value = {"/update"})
    public ResponseEntity<ResponseDTO> updateEmployeePaYRollData(@RequestParam EmployeePayRollDTO employeePayRollDTO){
        EmployeePayRollData employeePayRollData =null;
        employeePayRollData = iEmployeePayRollService.updateEmployeePayRollData(employeePayRollDTO);
        ResponseDTO responseDTO = new ResponseDTO("update employee payroll data successfully",employeePayRollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * @param employId
     * @return -> It returns the deleted employee ID number
     */
    @DeleteMapping(value = {"/delete/{employId}"})
    public ResponseEntity<ResponseDTO> deleteEmployeePaYRollData(@PathVariable int employId){
        iEmployeePayRollService.deleteEmployeePayRollData(employId);
        ResponseDTO responseDTO = new ResponseDTO("update employee payroll data successfully", "Deleted ID is"+employId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}

package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.entity.EmployeePayRollData;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayRollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author -> Ashwath Naidu <ashwath.bly@gmail.com>
 * @version -> :: Spring Boot :: (v2.6.3)
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
        List<EmployeePayRollData> employeePayRollDataList =null;
        employeePayRollDataList = iEmployeePayRollService.getEmployeePayRollData();
        ResponseDTO getting_call_successfully = new ResponseDTO("Getting call successfully", employeePayRollDataList);
        return new ResponseEntity<ResponseDTO>(getting_call_successfully, HttpStatus.OK);
    }

    /**
     * @param emailID
     * @return -> It returns the employee data that matches to given employee ID
     */
    @GetMapping(value = {"/get/{emailID}"})
    public ResponseEntity<ResponseDTO> getEmployeePaYRollDataByID(@PathVariable long emailID){
        EmployeePayRollData employeePayRollData =null;
        employeePayRollData = iEmployeePayRollService.getEmployeeOayRollDataById(emailID);
        ResponseDTO responseDTO = new ResponseDTO("Get call for ID successfully",employeePayRollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * @param name.
     * @return -> It returns creates new employee data into the database
     */
    @PostMapping(value = {"/create"})
    public ResponseEntity<ResponseDTO> createEmployeePaYRollData(@RequestParam String name,@RequestParam long salary){
        EmployeePayRollData employeePayRollData =null;
        employeePayRollData = iEmployeePayRollService.createEmployeePayRollData(new EmployeePayRollDTO(name,salary));
        ResponseDTO responseDTO = new ResponseDTO("created employee payroll data successfully",employeePayRollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * @param Id,name,salary
     * @return -> It returns the updated employee data
     */
    @PutMapping(value = {"/update"})
    public ResponseEntity<ResponseDTO> updateEmployeePaYRollData(@RequestParam long Id,@RequestParam String name,@RequestParam long salary){
        EmployeePayRollData employeePayRollData =null;
        employeePayRollData = iEmployeePayRollService.updateEmployeePayRollData(Id,name,salary);
        ResponseDTO responseDTO = new ResponseDTO("update employee payroll data successfully",employeePayRollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * @param employId
     * @return -> It returns the deleted employee ID number
     */
    @DeleteMapping(value = {"/delete/{employId}"})
    public ResponseEntity<ResponseDTO> deleteEmployeePaYRollData(@PathVariable Long employId){
        iEmployeePayRollService.deleteEmployeePayRollData(employId);
        ResponseDTO responseDTO = new ResponseDTO("update employee payroll data successfully", "Deleted ID is"+employId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}

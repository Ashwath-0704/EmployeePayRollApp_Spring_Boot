package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;
import com.bridgelabz.employeepayrollapp.entity.EmployeePayRollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayRollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author -> Ashwath Naidu <ashwath.bly@gmail.com>
 * @version -> :: Spring Boot :: (v2.6.3)
 */
@Service
public class EmployeePayRollServiceImpl implements IEmployeePayRollService {
    AtomicLong atomicLong = new AtomicLong();

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
     * @param employeePayRollDTO
     * @return -> It returns creates new employee data into the database
     */
    @Override
    public EmployeePayRollData createEmployeePayRollData(EmployeePayRollDTO employeePayRollDTO) {
        EmployeePayRollData employeePayRollData = null;
        employeePayRollData = new EmployeePayRollData(atomicLong.incrementAndGet(),employeePayRollDTO);
        return employeePayRollRepository.save(employeePayRollData);
    }

    @Override
    public EmployeePayRollData updateEmployeePayRollData(long emplId, String name, long salary) {
        EmployeePayRollData employeePayRollData= null;
        employeePayRollData= new EmployeePayRollData(emplId,new EmployeePayRollDTO(name,salary));
        return employeePayRollRepository.save(employeePayRollData);
    }

    @Override
    public String deleteEmployeePayRollData(Long employeeId) {employeePayRollRepository.deleteById(employeeId); return "Employee with ID -> (" + employeeId + " ) has deleted form the database";}
}

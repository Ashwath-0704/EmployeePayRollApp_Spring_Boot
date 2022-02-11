package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.entity.EmployeePayRollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author -> Ashwath Naidu <ashwath.bly@gmail.com>
 * @version -> :: Spring Boot :: (v2.6.3)
 */
public interface EmployeePayRollRepository extends JpaRepository<EmployeePayRollData, Long> {

    @Query(value = "select * from employee_pay_roll_data_list,employee_pay_roll_data_department where employee_id = employee_pay_roll_data_employee_id and department = :department",nativeQuery = true)
    List<EmployeePayRollData> findEmployeePayRollDataByDepartment(String department);

    @Query(value = " select gender,COUNT(salary) from employee_pay_roll_data_list group by gender",nativeQuery = true)
    List findCountByGender();

    @Query(value = " select gender,SUM(salary) from employee_pay_roll_data_list group by gender",nativeQuery = true)
    List findSumOfSalaryByGender();
}

package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.entity.EmployeePayRollData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author -> Ashwath Naidu <ashwath.bly@gmail.com>
 * @version -> :: Spring Boot :: (v2.6.3)
 */
public interface EmployeePayRollRepository extends JpaRepository<EmployeePayRollData,Long> {
}

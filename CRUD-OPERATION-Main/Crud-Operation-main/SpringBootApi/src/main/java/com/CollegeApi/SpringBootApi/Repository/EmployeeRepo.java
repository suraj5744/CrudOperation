package com.CollegeApi.SpringBootApi.Repository;

import com.CollegeApi.SpringBootApi.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    // All CRUD Database Methods
}

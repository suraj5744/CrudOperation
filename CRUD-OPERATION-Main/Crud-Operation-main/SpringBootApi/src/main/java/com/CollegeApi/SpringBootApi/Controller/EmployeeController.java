package com.CollegeApi.SpringBootApi.Controller;

import com.CollegeApi.SpringBootApi.Exception.ResourceNotFound;
import com.CollegeApi.SpringBootApi.Model.Employee;
import com.CollegeApi.SpringBootApi.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/employee")
public class EmployeeController {
    @Autowired
    public EmployeeRepo employeeRepo;
    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeRepo.findAll();
    }
    // Build Create Employee Rest Api
    @PostMapping
    public Employee CreateEmployee(@RequestBody Employee employee){
        return employeeRepo.save(employee);
    }
    // Build Get Employee By id Rest Api;
    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee=employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Employee Not Exist With Id:"+id));
        return ResponseEntity.ok(employee);
    }
    // Build  Update Employee Rest Api
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails){
        Employee updateEmployee= employeeRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFound("Employee Not Exist With Id:"+ id));
        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());
        employeeRepo.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }
    // Build Delete Employee Rest Api
    @DeleteMapping(value = "/Delete/{id}")
    public ResponseEntity<HttpStatus> DeleteEmployee(@PathVariable long id){
        Employee employee=employeeRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFound("Employee Not Exist With Id:"+ id));
        employeeRepo.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

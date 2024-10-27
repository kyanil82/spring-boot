package com.aky.backend_app.controller;

import com.aky.backend_app.dto.EmployeeDto;
import com.aky.backend_app.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService empservice;

    // Build Add Employee Rest API
    @PostMapping
    @RequestMapping("/add")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto empDto){
        EmployeeDto savedEmployee = empservice.createEmployee(empDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Build Get Employee Rest API
    @GetMapping
    @RequestMapping("/get/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Integer Id){
        EmployeeDto employeeDto = empservice.getEmployeeById(Id);
        return ResponseEntity.ok(employeeDto);
    }

    // Build Get All Employees Rest API
    @GetMapping
    @RequestMapping("/list")
    public ResponseEntity<List<EmployeeDto>> listEmployee(){
        List<EmployeeDto> employeeDto = empservice.getAllEmployees();
        return ResponseEntity.ok(employeeDto);
    }

    @PutMapping
    @RequestMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Integer Id,@RequestBody EmployeeDto empDto){
        EmployeeDto updatedEmployee = empservice.updateEmployee(Id, empDto);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.CREATED);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer Id){
        empservice.deleteEmployee(Id);
        return  ResponseEntity.ok("Employee deleted succesfully");
    }


}

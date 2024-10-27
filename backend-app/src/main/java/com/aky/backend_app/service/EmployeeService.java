package com.aky.backend_app.service;

import com.aky.backend_app.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Integer Id);
    List <EmployeeDto> getAllEmployees();EmployeeDto updateEmployee(Integer Id, EmployeeDto employeeDto);
    void deleteEmployee(Integer Id);

}

package com.aky.backend_app.service.impl;

import com.aky.backend_app.dto.EmployeeDto;
import com.aky.backend_app.entity.Employee;
import com.aky.backend_app.exception.ResourceNotFoundException;
import com.aky.backend_app.mapper.EmployeeMapper;
import com.aky.backend_app.repository.EmployeeRepository;
import com.aky.backend_app.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee emp = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(emp);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Integer Id) {
        Employee emp = employeeRepository.findById(Id).orElseThrow(()->
                new ResourceNotFoundException("Employee with Id ".concat(Id.toString()).concat(" does not exist.")));
        return EmployeeMapper.mapToEmployeeDto(emp);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> emplist = employeeRepository.findAll();

        return emplist.stream().map((emp) -> EmployeeMapper.mapToEmployeeDto(emp)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Integer Id, EmployeeDto employeeDto) {
        Employee emp = employeeRepository.findById(Id).orElseThrow(()->
                new ResourceNotFoundException("Employee with Id ".concat(Id.toString()).concat(" does not exist.")));
        emp.setName(employeeDto.getName());
        emp.setEmailId(employeeDto.getEmailId());
        Employee updatedEmp =  employeeRepository.save(emp);

        return EmployeeMapper.mapToEmployeeDto(updatedEmp);
    }

    public void deleteEmployee(Integer Id) {
        Employee emp = employeeRepository.findById(Id).orElseThrow(()->
                new ResourceNotFoundException("Employee with Id ".concat(Id.toString()).concat(" does not exist.")));

        employeeRepository.deleteById(Id);
    }
}

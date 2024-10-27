package com.aky.backend_app.mapper;

import com.aky.backend_app.dto.EmployeeDto;
import com.aky.backend_app.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee emp)
    {
        return new EmployeeDto(
                emp.getId(),
                emp.getName(),
                emp.getEmailId()
        );
    }

    public static Employee mapToEmployee(EmployeeDto empDto)
    {
        return new Employee(
                empDto.getId(),
                empDto.getName(),
                empDto.getEmailId()
        );
    }
}

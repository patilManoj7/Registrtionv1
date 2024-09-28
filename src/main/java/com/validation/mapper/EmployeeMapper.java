package com.validation.mapper;

import com.validation.dto.EmployeeDto;
import com.validation.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeMapper INSTANCE= Mappers.getMapper(EmployeeMapper.class);
            EmployeeDto ToEmployeeDto(Employee employee);
            Employee   ToEmployee(EmployeeDto employeeDto);
}

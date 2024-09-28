package com.validation.service;

import com.validation.dto.EmployeeDto;
import com.validation.entity.Employee;
import com.validation.exception.ResouceNotFoundException;
import com.validation.mapper.EmployeeMapper;
import com.validation.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository repository;
    private EmployeeMapper mapper;

    public EmployeeDto getEmployee(Long id) {
        return repository.findById(id).map(mapper::ToEmployeeDto).orElseThrow(()->new ResouceNotFoundException("Resource Not Found"));
    }

    public List<EmployeeDto> getEmployeeList() {
        return repository.findAll().stream().map(mapper::ToEmployeeDto).toList();
    }

    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
      Employee employee= mapper.ToEmployee(employeeDto);
       return mapper.ToEmployeeDto(repository.save(employee));
    }

    public EmployeeDto updateEmployee(EmployeeDto employeeDto, Long id) {
     Employee findEmployee=repository.findById(id).orElseThrow(()->new ResouceNotFoundException("Resource Not Found"));
     Employee saveEmployee= mapper.ToEmployee(employeeDto);
     return mapper.ToEmployeeDto(repository.save(saveEmployee));
    }

    public void deleteEmployee(Long id) {
      Employee findEmployee= repository.findById(id).orElseThrow(()->new ResouceNotFoundException("Resource Not Found"));
      repository.delete(findEmployee);
    }
}

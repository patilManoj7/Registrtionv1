package com.validation.controller;

import com.validation.dto.EmployeeDto;
import com.validation.service.EmployeeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee/")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@NotNull @PathVariable Long id) {
        EmployeeDto savedEmployee = employeeService.getEmployee(id);
        return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<EmployeeDto>> getEmployeeList() {
        List<EmployeeDto> listOfEmployee = employeeService.getEmployeeList();
        return new ResponseEntity<>(listOfEmployee, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<EmployeeDto> addEmployeeDto(@Valid @RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.addEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

    }

    @PutMapping()
    public ResponseEntity<EmployeeDto> updateEmployee(@Valid @RequestBody EmployeeDto employeeDto,@NotNull Long id) {
        EmployeeDto updatedEmployee = employeeService.updateEmployee(employeeDto, id);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteEmployee(@NotNull @RequestParam Long id)
    {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("deleted Successfully",HttpStatus.OK);
    }
}

package com.validation.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    @Email(message = "Format Mismatch")
    private String email;
    @Size(min = 10, max = 10)
    @NotNull(message = "phone number is required")
    private String phone;
    @Positive
    @NotNull(message = "salary should not null")
    private Long salary;
    @Size(min = 10,max = 50,message = "address must be between 10 to 50 character")
    private String address;
}
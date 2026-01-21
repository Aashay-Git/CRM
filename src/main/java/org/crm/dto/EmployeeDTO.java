package org.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.crm.enums.EmployeeStatus;
import org.crm.enums.Role;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDTO {
    private String name;
    private String email;
    private Role role;
    private String phoneNum;
    private String designation;
    private EmployeeStatus status;
    private LocalDate joiningDate;
    private float salary;
}

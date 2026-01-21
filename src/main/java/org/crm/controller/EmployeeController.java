package org.crm.controller;

import org.crm.dto.EmployeeDTO;
import org.crm.enums.EmployeeStatus;
import org.crm.repository.EmployeeRepository;
import org.crm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/admin/create/employee")
    public String createEmployee(@RequestBody EmployeeDTO employeeDTO){
        try{
            return employeeService.createEmployee(employeeDTO);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

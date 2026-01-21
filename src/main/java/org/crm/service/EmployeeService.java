package org.crm.service;

import org.crm.dto.EmployeeDTO;
import org.crm.model.Employee;
import org.crm.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public String createEmployee(EmployeeDTO employeeDTO){
        Employee e = new Employee();

        e.setName(employeeDTO.getName());
        e.setEmail(employeeDTO.getEmail());
        e.setRole(employeeDTO.getRole());
        e.setPhoneNum(employeeDTO.getEmail());
        e.setDesignation(employeeDTO.getDesignation());
        e.setJoiningDate(employeeDTO.getJoiningDate());
        e.setStatus(employeeDTO.getStatus());
        e.setSalary(employeeDTO.getSalary());

        employeeRepository.save(e);

        return "Employee Created";
    }
}

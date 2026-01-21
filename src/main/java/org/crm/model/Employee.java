package org.crm.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.crm.enums.DepartmentEnum;
import org.crm.enums.EmployeeStatus;
import org.crm.enums.Role;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String phoneNum;
    private String designation;
    private LocalDate joiningDate;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus Status;

    @OneToOne(mappedBy = "employee")
    @JoinColumn
    private User userid;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "managerid")
    private Employee manager;

    @OneToMany(mappedBy = "manager")
    @JsonIgnore
    private List<Employee> teamMembers = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "departmentid")
    private Department department;


    private float salary;
//    private DepartmentEnum departmentEnum;

//    @OneToMany(mappedBy = "employee")
//    @JoinColumn
//    private List<Project> projectList = new ArrayList<>();

    @OneToMany(mappedBy = "manager")
    @JsonIgnore
    private List<Project> projectList = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "employees_projects",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private Set<Project> projects = new HashSet<>();
}

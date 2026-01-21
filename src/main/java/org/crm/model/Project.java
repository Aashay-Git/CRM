package org.crm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.crm.enums.ProjectStatus;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

    @ManyToOne
    @JoinColumn(name = "managerid")
    private Employee manager;

//    @OneToMany(mappedBy = "project")
//    @JoinColumn
//    private List<Employee> employeeList = new ArrayList<>();

    @ManyToMany(mappedBy = "projects")
    @JsonIgnore
    private Set<Employee> teamMembers = new HashSet<>();
}

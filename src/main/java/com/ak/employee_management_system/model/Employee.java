package com.ak.employee_management_system.model;


import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "employee_table")
public class Employee {
    @Id
    @SequenceGenerator(
            sequenceName = "employee_sequence",
            name = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long id;

    @NotNull
    @NotEmpty(message = "First Name field should not be empty.")
    private String firstName;

    @NotEmpty(message = "Last Name field should not be empty.")
    private String lastName;

    @NotEmpty(message = "Email field should not be empty.")
    @Email(regexp = "^(.+)@(.+)$", message = "Invalid email pattern.")
    private String email;

    @NotEmpty(message = "phone field should not be empty.")
    @Size(max = 12, message = "digits should be 10 maximum.")
    private String phone;

    private String department;

    @NotEmpty(message = "Salary field should not be empty.")
    private String basicSalary;


    public Employee() {
    }



    public Employee(Long id, String firstName,
                    String lastName, String email,
                    String phone, String department,
                    String basicSalary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.basicSalary = basicSalary;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(String basicSalary) {
        this.basicSalary = basicSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", department='" + department + '\'' +
                ", basicSalary='" + basicSalary + '\'' +
                '}';
    }
}

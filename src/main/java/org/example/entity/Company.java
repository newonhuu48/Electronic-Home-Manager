package org.example.entity;

import jakarta.validation.constraints.*;

import jakarta.persistence.*;

import java.util.Set;

// POJO
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotBlank(message = "Company name cannot be blank!")
    @Size(max = 20, message = "Company name has to be with up to 20 characters!")
    @Pattern(regexp = "^([A-Z]).*", message = "Company name has to start with capital letter!")
    @Column(name = "name", nullable = false)
    private String name;

    @Positive
    @DecimalMin(value = "0.00", message = "Income has to be more than or equal to 5000.00", inclusive = true)
    @DecimalMax(value = "10000.00", message = "Income has to be less than or equal to 10000.00")
    @Column(name = "income", nullable = false)
    private double income;


    @OneToMany(mappedBy = "company")
    private Set<Employee> employees;



    public Company() {
    }

    public Company(String name, int income) {
        this.name = name;
        this.income = income;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }


    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }


    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", income=" + income +
                '}';
    }
}

package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Employee name cannot be blank!")
    @Size(max = 40, message = "Employee name has to be with up to 40 characters!")
    @Pattern(regexp = "^([A-Z]).*", message = "Employee name has to start with capital letter!")
    @Column(name = "name", nullable = false)
    private String name;


    @ManyToOne()
    private Company company;


    @OneToMany(mappedBy = "employee")
    private Set<Building> buildings;



    @OneToMany(mappedBy = "employee_tax")
    Set<PaidTaxes> paidTaxes;




    public Employee() {
    }


    public Employee(String name, Company company) {
        this.name = name;
        this.company = company;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(Set<Building> buildings) {
        this.buildings = buildings;
    }

    public Set<PaidTaxes> getPaidTaxes() {
        return paidTaxes;
    }

    public void setPaidTaxes(Set<PaidTaxes> paidTaxes) {
        this.paidTaxes = paidTaxes;
    }

    @Override
        public String toString() {
            return "Employee{" +
                    ", company=" + company +
                    '}';
        }
}

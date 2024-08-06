package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;


@Entity
@Table(name = "building")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "district")
    @NotBlank(message = "Please enter a valid district name.")
    private String district;

    @Column(name = "address")
    @NotBlank(message = "Please enter a valid district address.")
    private String address;


    //Employee serving the building
    @ManyToOne()
    private Employee employee;


    //Apartment List
    @OneToMany(mappedBy = "building")
    private Set<Apartment> apartments;





    public Building() {
    }

    public Building(String district, String address) {
        this.district = district;
        this.address = address;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(Set<Apartment> apartments) {
        this.apartments = apartments;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.validator.constraints.Range;

import java.util.Set;

@Entity
@Table(name = "apartment")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "floor")
    @Min(value = -1, message = "Apartment floor cannot be less than -1 (basement)")
    private int floor;

    @Column(name = "number")
    @Min(value = 1, message = "Apartment number cannot be less than 1.")
    private int number;

    @Column(name = "area")
    @Positive(message = "Apartment area must be positive.")
    private int area;

    @Column(name = "inhabitants")
    @PositiveOrZero(message = "Apartment number of inhabitants must be non-negative.")
    private int inhabitants;

    @ManyToOne
    private Building building;



    @OneToMany(mappedBy = "apartment_tax")
    Set<PaidTaxes> paidTaxes;





    public Apartment() {
    }

    public Apartment(int floor, int number, int area, int inhabitants) {
        this.floor = floor;
        this.number = number;
        this.area = area;
        this.inhabitants = inhabitants;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getInhabitants() {
        return inhabitants;
    }

    public void setInhabitants(int inhabitants) {
        this.inhabitants = inhabitants;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Set<PaidTaxes> getPaidTaxes() {
        return paidTaxes;
    }

    public void setPaidTaxes(Set<PaidTaxes> paidTaxes) {
        this.paidTaxes = paidTaxes;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", floor=" + floor +
                ", number=" + number +
                ", area=" + area +
                ", inhabitants=" + inhabitants +
                '}';
    }
}

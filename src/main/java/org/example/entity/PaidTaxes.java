package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;


@Entity
@Table(name = "paid_taxes")
public class PaidTaxes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne
    @JoinColumn(name = "employee_id")
    Employee employee_tax;


    @ManyToOne
    @JoinColumn(name = "apartment_id")
    Apartment apartment_tax;


    @PositiveOrZero
    @Column(name = "amount")
    private double amount;


    @Column(name = "date")
    @PastOrPresent(message = "Tax date cannot be in the future.")
    private LocalDate date;




    public PaidTaxes() {
    }

    public PaidTaxes(Apartment apartment, LocalDate date) {
        //The employee that serves the building also serves the apartments in it.
        this.employee_tax = apartment.getBuilding().getEmployee();

        this.apartment_tax = apartment;
        this.date = date;

        this.amount = (apartment.getArea() * 2) + (apartment.getInhabitants() * 30);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee_tax;
    }

    public void setEmployee(Employee employee_tax) {
        this.employee_tax = employee_tax;
    }

    public Apartment getApartment() {
        return apartment_tax;
    }

    public void setApartment(Apartment apartment_tax) {
        this.apartment_tax = apartment_tax;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public Employee getEmployee_tax() {
        return employee_tax;
    }

    public void setEmployee_tax(Employee employee_tax) {
        this.employee_tax = employee_tax;
    }

    public Apartment getApartment_tax() {
        return apartment_tax;
    }

    public void setApartment_tax(Apartment apartment_tax) {
        this.apartment_tax = apartment_tax;
    }

    @Override
    public String toString() {
        return "PaidTaxes{" +
                "id=" + id +
                ", employee_name=" + employee_tax.getName() +
                ", apartment_floor=" + apartment_tax.getFloor() +
                ", apartment_number" + apartment_tax.getNumber() +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
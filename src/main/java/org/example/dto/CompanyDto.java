package org.example.dto;

import jakarta.persistence.Column;
import java.time.LocalDate;

public class CompanyDto {
    private long id;
    private String name;
    private double income;

    public CompanyDto(long id, String name, double initialCapital) {
        this.id = id;
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
}

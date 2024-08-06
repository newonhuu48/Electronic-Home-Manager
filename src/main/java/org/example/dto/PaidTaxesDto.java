package org.example.dto;

import java.time.LocalDate;

public class PaidTaxesDto {
    private String company_name;

    private String employee_name;

    private String building_district;

    private String building_address;

    private int apartment_floor;

    private int apartment_number;

    private double amount;

    private LocalDate date;

    public PaidTaxesDto(String company_name, String employee_name, String building_district, String building_address, int apartment_floor, int apartment_number, double amount, LocalDate date) {
        this.company_name = company_name;
        this.employee_name = employee_name;

        this.building_district = building_district;
        this.building_address = building_address;

        this.apartment_floor = apartment_floor;
        this.apartment_number = apartment_number;

        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Paid Tax Info:\n" +
                "Company name: " + company_name + "\n" +
                "Employee name: " + employee_name + "\n\n" +

                "Building district: " + building_district + "\n" +
                "Building address: " + building_address + "\n\n" +

                "Apartment floor: " + apartment_floor + "\n" +
                "Apartment number: " + apartment_number + "\n\n" +

                "Tax amount: " + amount + "\n" +
                "Tax date: " + date + "\n" +

                "\n\n\n";
    }
}

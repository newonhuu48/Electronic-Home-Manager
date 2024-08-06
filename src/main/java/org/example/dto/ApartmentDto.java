package org.example.dto;

public class ApartmentDto {
    private long id;

    private int floor;

    private int number;

    public ApartmentDto(long id, int floor, int number) {
        this.id = id;
        this.floor = floor;
        this.number = number;
    }

    @Override
    public String toString() {
        return "ApartmentDto{" +
                "id=" + id +
                ", floor=" + floor +
                ", number=" + number +
                '}';
    }
}

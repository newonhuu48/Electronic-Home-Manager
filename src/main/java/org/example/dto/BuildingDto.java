package org.example.dto;

public class BuildingDto {
    private long id;
    private String district;
    private String address;

    public BuildingDto(long id, String district, String address) {
        this.id = id;
        this.district = district;
        this.address = address;
    }

    @Override
    public String toString() {
        return "BuildingDto{" +
                "id=" + id +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

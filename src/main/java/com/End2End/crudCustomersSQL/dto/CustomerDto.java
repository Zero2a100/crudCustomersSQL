package com.End2End.crudCustomersSQL.dto;

public class CustomerDto {
    private String firstName;
    private String lastName;
    private String city;
    private Integer ssn;

    public CustomerDto() {
    }

    public CustomerDto(String firstName, String lastName, String city, Integer ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.ssn = ssn;
    }
}

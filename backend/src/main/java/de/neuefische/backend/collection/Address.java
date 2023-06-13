package de.neuefische.backend.collection;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    private String streetName;
    private String houseNo;
    private String apartment;
    private String zipCode;
    private String city;
    private String country;
}

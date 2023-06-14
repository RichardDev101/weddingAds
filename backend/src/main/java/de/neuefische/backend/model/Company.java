package de.neuefische.backend.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Company {

    private String id;
    private String name;
    private Address address;
}

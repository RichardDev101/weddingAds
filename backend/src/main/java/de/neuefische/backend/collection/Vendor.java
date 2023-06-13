package de.neuefische.backend.collection;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Vendor extends Person{
    private String companyName;
}

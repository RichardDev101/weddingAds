package de.neuefische.backend.collection;

import io.netty.resolver.AddressResolver;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Company {

    private String id;
    private String name;
    private Address address;

}

package de.neuefische.backend.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactDetail {

    private String email;
    private String phoneNumber;
    private String homepageURL;
}

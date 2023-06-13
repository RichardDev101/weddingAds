package de.neuefische.backend.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import de.neuefische.backend.enums.LoginRole;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection="person")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {

    @Id
    private String personId;
    private List<Company> companies;
    private String userName;
    private String firstName;
    private String lastName;
    private String  email;
    private String phoneNumber;
    private List<Address> addresses;
    private List<LoginRole> roles;
    private String gpsData;
}

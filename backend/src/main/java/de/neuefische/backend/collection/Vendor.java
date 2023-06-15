package de.neuefische.backend.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import de.neuefische.backend.enums.BusinessCategory;
import de.neuefische.backend.model.Company;
import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Builder(builderMethodName = "vendorBuilder")
@Document(collection="vendor")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Vendor extends Person{

    private List<Advertisement> advertisements;
}

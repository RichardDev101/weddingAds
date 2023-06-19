package de.neuefische.backend.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(builderMethodName = "vendorBuilder")
@Document(collection="vendor")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Vendor extends Person{

    private List<Advertisement> advertisements;
}

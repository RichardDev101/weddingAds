package de.neuefische.backend.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import de.neuefische.backend.enums.AdvertisementStatus;
import de.neuefische.backend.enums.BusinessCategory;
import de.neuefische.backend.enums.PaymentCategory;
import de.neuefische.backend.enums.PriceCategory;
import de.neuefische.backend.model.Address;
import de.neuefische.backend.model.Company;
import de.neuefische.backend.model.ContactDetail;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Builder
@Document(collection="advertisement")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Advertisement {

    @Id
    private String id;
    private AdvertisementStatus advertisementStatus;
    private PaymentCategory paymentCategory;
    private Company company;
    private List<BusinessCategory>businessCategories;
    private List<Photo> photos;
    private String about; // Section where one writes about himself in a shot manner
    private String detail; //Description about the Service someone ist offering
    private float averagePrice; // Price someone requests for his service
    private List<PriceCategory> priceCategories; //per hour/ per day... etc.
    private List<ContactDetail> contacts;
    private List<Address> location;
    private List<Vendor> persons;

}

package de.neuefische.backend.dto;

import de.neuefische.backend.collection.Vendor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
@Data
@EqualsAndHashCode(callSuper = true)
public class VendorDTO extends PersonDTO {

    private List<String> advertisementsId;

}

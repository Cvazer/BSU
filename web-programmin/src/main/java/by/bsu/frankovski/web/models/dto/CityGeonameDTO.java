package by.bsu.frankovski.web.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityGeonameDTO {
    private String countryCode;
    private String toponymName;
}

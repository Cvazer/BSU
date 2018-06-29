package by.bsu.frankovski.web.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeonameDTO {
    private Long totalResultsCount;
    private List<CityGeonameDTO> geonames;
}

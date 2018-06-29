package by.bsu.frankovski.web.services;

import by.bsu.frankovski.web.models.City;
import by.bsu.frankovski.web.models.dto.CityDTO;
import by.bsu.frankovski.web.repositories.CityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CityService {
    private @Autowired CityRepository cityRepository;


    public List<CityDTO> getByCountryWithOffset(String a2, Long offset) {
        Pageable nextTwinty = PageRequest.of(offset.intValue(), 20);
        List<City> result = cityRepository.getByCountry_A2Code(a2.toUpperCase(), nextTwinty);
        return result.stream().map(city -> new CityDTO(city.getName(), city.getId(), city.getCountry().getA2Code())).collect(Collectors.toList());
    }
}

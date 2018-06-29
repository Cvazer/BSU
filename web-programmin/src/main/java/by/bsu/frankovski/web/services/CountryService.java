package by.bsu.frankovski.web.services;

import by.bsu.frankovski.web.models.dto.CountryDTO;
import by.bsu.frankovski.web.repositories.CountryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Slf4j
public class CountryService {
    private @Autowired CountryRepository countryRepository;

    public List<CountryDTO> getAllDTO() {
        List<CountryDTO> dtos = new ArrayList<>();
        countryRepository.findAll().forEach(country -> dtos.add(new CountryDTO(country.getA2Code(),country.getName())));
        return dtos;
    }

    public List<CountryDTO> getAllContainsDTO(String text) {
        List<CountryDTO> dtos = new ArrayList<>();
        countryRepository.findAllByNameContaining(text).forEach(country -> dtos.add(new CountryDTO(country.getA2Code(), country.getName())));
        return dtos;
    }
}

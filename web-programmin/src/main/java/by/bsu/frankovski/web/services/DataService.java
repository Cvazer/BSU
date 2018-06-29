package by.bsu.frankovski.web.services;

import by.bsu.frankovski.web.models.City;
import by.bsu.frankovski.web.models.Country;
import by.bsu.frankovski.web.models.dto.GeonameDTO;
import by.bsu.frankovski.web.repositories.CityRepository;
import by.bsu.frankovski.web.repositories.CountryRepository;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
@Transactional
@Slf4j
public class DataService {
    private @Autowired CityRepository cityRepository;
    private @Autowired CountryRepository countryRepository;

    public void loadCountries() throws IOException {
        Document document = Jsoup.connect("http://www.fao.org/countryprofiles/iso3list/en/").get();
        Elements rows = document.select("tr.showpanel");
        log.info("Start countries scrap...");
        countryRepository.deleteAll();
        rows.forEach(row -> {
            Country country = new Country();
            country.setName(row.select("td.shortname a").text());
            country.setA2Code(row.select("td.iso2").text());
            countryRepository.save(country);
        });
        log.info("Scrap finished!");
    }

    public void loadCities() throws Exception {
        log.info("Cities scan started...");
        countryRepository.findAll().forEach(country -> {
            RestTemplate restTemplate = new RestTemplate();
            GeonameDTO geonameDTO = restTemplate.getForObject("http://api.geonames.org/searchJSON?username=frankovski&country="+country.getA2Code().toLowerCase()+"&style=SHORT", GeonameDTO.class);
            geonameDTO.getGeonames().forEach(dto -> {
                if (dto.getCountryCode()==null){return;}
                City city = new City();
                city.setName(dto.getToponymName());
                city.setCountry(country);
                cityRepository.save(city);
            });
        });
        log.info("Scan finished!");
    }

}

package by.bsu.frankovski.web.controllers;

import by.bsu.frankovski.web.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ApiController {
    private @Autowired DataService service;

    @GetMapping(value = "/data/countries")
    public void loadCountries() throws IOException {
        service.loadCountries();
    }

    @GetMapping(value = "/data/cities")
    public void loadCities() throws Exception {
        service.loadCities();
    }

}

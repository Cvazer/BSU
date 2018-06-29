package by.bsu.frankovski.web.controllers;

import by.bsu.frankovski.web.models.dto.CountryDTO;
import by.bsu.frankovski.web.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    private @Autowired CountryService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CountryDTO> getAll(){
        return service.getAllDTO();
    }

    @PostMapping(value = "/getContains", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<CountryDTO> getAllContains(@RequestBody String text){
        return service.getAllContainsDTO(text);
    }

}

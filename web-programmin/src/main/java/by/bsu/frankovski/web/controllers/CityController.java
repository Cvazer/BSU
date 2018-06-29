package by.bsu.frankovski.web.controllers;

import by.bsu.frankovski.web.models.dto.CityDTO;
import by.bsu.frankovski.web.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    private @Autowired CityService cityService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/get/{a2}/{offset}")
    public List<CityDTO> getCitiesByCountryWithOffset(@PathVariable String a2, @PathVariable Long offset){
        return cityService.getByCountryWithOffset(a2, offset);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/get/{id}")
    public CityDTO 

}

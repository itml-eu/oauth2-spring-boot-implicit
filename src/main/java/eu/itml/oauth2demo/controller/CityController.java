package eu.itml.oauth2demo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import eu.itml.oauth2demo.model.City;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityController {

    private List<City> cities = new ArrayList<>();

    @GetMapping
    public ResponseEntity<Collection<City>> getCities() {
        cities.add(new City("Warsaw"));
        cities.add(new City("Cracow"));
        cities.add(new City("Lodz"));

        return new ResponseEntity<Collection<City>>(cities, HttpStatus.OK);
    }
}

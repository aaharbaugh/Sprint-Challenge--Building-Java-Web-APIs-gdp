package com.gdp.demo.controller;

import com.gdp.demo.DemoApplication;
import com.gdp.demo.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@RestController
@RequestMapping("/country")
public class CountryController
{
    // localhost:8080/country/name
    @GetMapping(value = "/name")
    public ResponseEntity<?> getAllCountries()
    {
        DemoApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(DemoApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    // localhost:8080/country/economy
    @GetMapping(value = "/economy")
    public ResponseEntity<?> getAllCountriesByEconomy()
    {
        DemoApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getGdp() - c2.getGdp());
        return new ResponseEntity<>(DemoApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    // localhost:8080/country/id
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCountryDetail(@PathVariable long id)
    {
        Country rtnCountry = DemoApplication.ourCountryList.findCountry(c -> (c.getId() == id));
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    // localhost:8080/country/stats/median
    @GetMapping(value = "/stats/median")
    public ResponseEntity<?> getMedianCountryGdp()
    {
        DemoApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getGdp() - c2.getGdp());
        return new ResponseEntity<>(DemoApplication.ourCountryList.countryList.get(DemoApplication.ourCountryList.countryList.size()/2), HttpStatus.OK);
    }

    // localhost:2019/country/table
    @GetMapping(value = "economy/table")
    public ModelAndView displayCountryTable()
    {

        DemoApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getGdp() - c2.getGdp());
        ModelAndView mav = new ModelAndView();
        mav.setViewName("country");
        mav.addObject("countrylist", DemoApplication.ourCountryList.countryList);

        return mav;
    }
}

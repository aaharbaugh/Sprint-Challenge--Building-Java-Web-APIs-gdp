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
    // localhost:8080/country/all
    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllCountries()
    {
        return new ResponseEntity<>(DemoApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    // localhost:8080/country/id
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCountryDetail(@PathVariable long id)
    {
        Country rtnCountry = DemoApplication.ourCountryList.findCountry(c -> (c.getId() == id));
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    // localhost:2019/country/table
    @GetMapping(value = "/table")
    public ModelAndView displayEmployeeTable()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("country");
        mav.addObject("countryList", DemoApplication.ourCountryList.countryList);

        return mav;
    }
}

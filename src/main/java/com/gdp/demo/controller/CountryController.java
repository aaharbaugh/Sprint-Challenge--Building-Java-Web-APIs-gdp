package com.gdp.demo.controller;

import com.gdp.demo.DemoApplication;
import com.gdp.demo.exception.MessageDetail;
import com.gdp.demo.exception.ResourceNotFoundException;
import com.gdp.demo.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@RestController
@RequestMapping("/gdp")
public class CountryController
{

    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    // localhost:8080/gdp/name
    @GetMapping(value = "/name")
    public ResponseEntity<?> getAllCountries()
    {
        logger.info("/gdp/name accessed");
        MessageDetail message = new MessageDetail("/gdp/name accessed", 7, false);

        DemoApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(DemoApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    // localhost:8080/gdp/economy
    @GetMapping(value = "/economy")
    public ResponseEntity<?> getAllCountriesByEconomy()
    {

        logger.info("/gdp/economy accessed");
        MessageDetail message = new MessageDetail("/gdp/economy accessed", 7, false);

        DemoApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getGdp() - c2.getGdp());
        return new ResponseEntity<>(DemoApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    // localhost:8080/gdp/country/id
    @GetMapping(value = "country/{id}")
    public ResponseEntity<Country> getCountryDetail(@PathVariable long id) throws ResourceNotFoundException
    {

        logger.info("/gdp/country/" + id + " accessed");
        MessageDetail message = new MessageDetail("/gdp/country/" + id + " accessed", 7, false);

        if(DemoApplication.ourCountryList.findCountry(c -> (c.getId() == id)) == null)
        {
            throw new ResourceNotFoundException("Country with id " + id + " not found");
        } else
        {
            Country rtnCountry = DemoApplication.ourCountryList.findCountry(c -> (c.getId() == id));
            return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
        }


    }

    // localhost:8080/gdp/stats/median
    @GetMapping(value = "/stats/median")
    public ResponseEntity<?> getMedianCountryGdp()
    {

        logger.info("/gdp/stats/median accessed");
        MessageDetail message = new MessageDetail("/gdp/stats/median accessed", 7, false);

        DemoApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getGdp() - c2.getGdp());
        return new ResponseEntity<>(DemoApplication.ourCountryList.countryList.get(DemoApplication.ourCountryList.countryList.size()/2), HttpStatus.OK);
    }

    // localhost:2019/gdp/economy/table
    @GetMapping(value = "economy/table")
    public ModelAndView displayCountryTable()
    {

        logger.info("/gdp/economy/table accessed");
        MessageDetail message = new MessageDetail("/gdp/economy/table accessed", 7, false);

        DemoApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getGdp() - c2.getGdp());
        ModelAndView mav = new ModelAndView();
        mav.setViewName("country");
        mav.addObject("countrylist", DemoApplication.ourCountryList.countryList);

        return mav;
    }
}

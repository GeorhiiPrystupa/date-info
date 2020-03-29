package nl.matchinglink.showyourskills.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import nl.matchinglink.showyourskills.domain.DateInfoProviderResponse;
import nl.matchinglink.showyourskills.utils.DateInfoUtils;

@RestController
@RequestMapping("date")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class DateController {

    
    @RequestMapping(method = GET, value = "/info", produces = "application/json")
    public @ResponseBody ResponseEntity<DateInfoProviderResponse> getDateInfo(@RequestParam("date") long date) {
    	LocalDate localDate =
    		    Instant.ofEpochMilli(date).atZone(ZoneId.systemDefault()).toLocalDate();
    	
    	DateInfoProviderResponse response = DateInfoUtils.getDateInfo(localDate);
    			
		return new ResponseEntity<DateInfoProviderResponse>(response, HttpStatus.OK);
        
    }
}

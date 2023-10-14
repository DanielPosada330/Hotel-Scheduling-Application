package edu.wgu.d387_sample_code.international_functions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Enable communication with front end
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TimeZoneConversionController {
    @GetMapping("/presentation")
    public ResponseEntity<String> displayPresentation(){
        String banner = "Live online presentation currently being held in the main exhibition room! Presentation time: " + TimeZoneConversion.showTime();
        return new ResponseEntity<String>(banner, HttpStatus.OK);
    }
}

package edu.wgu.d387_sample_code.international_functions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

// Enable communication with front end
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class WelcomeMessageController {

    // RequestParam mapping in order to get lang parameter from html frontend.
    @GetMapping("/welcome")
    public ResponseEntity<String> showWelcome (@RequestParam("lang")String lang) {

        // Object to house correct language parameter.
        Locale locale = Locale.forLanguageTag(lang);

        // Pull in correct language
        ShowWelcomeMessage showWelcomeMessage = new ShowWelcomeMessage(locale);

        // Returns correct language message
        return new ResponseEntity<String> (showWelcomeMessage.getShowWelcomeMessage(), HttpStatus.OK);
    }

}

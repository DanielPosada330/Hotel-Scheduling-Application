package edu.wgu.d387_sample_code;

import edu.wgu.d387_sample_code.international_functions.ShowWelcomeMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class D387SampleCodeApplication {

	public static void main(String[] args) {

		SpringApplication.run(D387SampleCodeApplication.class, args);

		// Create thread for U.S. English
		ShowWelcomeMessage showWelcomeMessageEnglish = new ShowWelcomeMessage(Locale.US);
		Thread welcomeThreadEnglish = new Thread(showWelcomeMessageEnglish);
		welcomeThreadEnglish.start();

		// Create thread for Canadian French
		ShowWelcomeMessage showWelcomeMessageFrench = new ShowWelcomeMessage(Locale.CANADA_FRENCH);
		Thread welcomeThreadFrench = new Thread(showWelcomeMessageFrench);
		welcomeThreadFrench.start();
	}

}

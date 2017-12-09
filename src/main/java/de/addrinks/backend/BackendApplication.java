package de.addrinks.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.microsoft.applicationinsights.TelemetryClient;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		TelemetryClient client = new TelemetryClient();
		SpringApplication.run(BackendApplication.class, args);
	}
}

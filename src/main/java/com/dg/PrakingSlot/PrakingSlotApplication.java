package com.dg.PrakingSlot;

import com.dg.PrakingSlot.Repository.ParkingDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PrakingSlotApplication {
	@Autowired
	ParkingDetailsRepository parkingDetailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(PrakingSlotApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> parkingDetailsRepository.loadParkingDetails();
	}

}

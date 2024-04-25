package com.example.AssetTracker_V2;

import jakarta.persistence.PrePersist;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class AssetTrackerV2Application {

	public static void main(String[] args) {
		SpringApplication.run(AssetTrackerV2Application.class, args);
	}
}

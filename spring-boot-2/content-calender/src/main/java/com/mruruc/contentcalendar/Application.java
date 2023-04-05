package com.mruruc.contentcalendar;

import com.mruruc.contentcalendar.Repository.ContentCollectionRepository;
import com.mruruc.contentcalendar.Repository.ContentRepository;
import com.mruruc.contentcalendar.controller.ContentController;
import com.mruruc.contentcalendar.model.Content;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

import static com.mruruc.contentcalendar.model.Status.IN_PROGRESS;
import static com.mruruc.contentcalendar.model.Type.COURSE;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
}

package com.mruruc.config;

import com.mruruc.model.Student;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application_db.properties")

/**
 *
 *@PropertySource annotation is used to define the locations of externalized configuration files,
 * typically property files. When our Spring application starts,
 * it loads the properties from these files into the Spring Environment,
 * and then you can easily access them from your application code.
 * (This Annotation is used with @Configuration classes.)
 */

public class ApplicationConfig {

}

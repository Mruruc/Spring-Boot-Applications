package com.mruruc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
public class Internationalization_Controller {
    private MessageSource messageSource;

    @Autowired
    public Internationalization_Controller(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/hello-internationalized")
    public String HelloInternationalizedMessage(){
        Locale locale=LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message"
                                       ,null,"Default Message",
                                       locale);

    }

    @GetMapping("/")
    public ResponseEntity<Person> getPerson() {

        Person person = new Person("Waflo Mafloo");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentLanguage( Locale.US);

        return new ResponseEntity<>(person, headers, HttpStatus.OK);
    }

}

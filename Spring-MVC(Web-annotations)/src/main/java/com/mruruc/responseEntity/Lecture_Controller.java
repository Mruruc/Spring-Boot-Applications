package com.mruruc.responseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

@Controller
public class Lecture_Controller {
    public Lecture_Service service;
    @Autowired
    public Lecture_Controller(Lecture_Service service){
        this.service=service;
    }
    @RequestMapping(path = "/api/lectures"
                    ,method = RequestMethod.GET
                     ,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Lecture>> getAllLectures(){
        List<Lecture> allLecture = service.getAllLecture();

        HttpHeaders headers=new HttpHeaders();
        headers.setDate(ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toInstant().toEpochMilli());
        headers.setContentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE));
       // headers.set("Content-Language", "pl");
        headers.setContentLanguage(Locale.forLanguageTag("en-US"));
        headers.set("Server","LocalhostServer/1.0");

        return new ResponseEntity<>(allLecture,headers,HttpStatus.OK);
    }

    /**
     * Retrieves Lecture based on the provided criteria.
     *
     * @param lectureId   optional Id criterion
     *
     * @return  lecture matching the criteria
     */
    @RequestMapping(path = "/api/lecture-byId/{id}"
                    ,method = RequestMethod.GET
                    ,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Optional<Lecture>> getLecture(@PathVariable("id") Integer lectureId){
        Optional<Lecture> lectureById = service.getLectureById(lectureId);

        HttpHeaders headers=new HttpHeaders();
        headers.setDate(ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toInstant().toEpochMilli());
        headers.setContentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE));
        headers.setContentLanguage(Locale.forLanguageTag("en-US"));
        headers.set("Server","LocalhostServer/1.0");

        if(!service.isEmpty(lectureId)){
          return new ResponseEntity<>(headers,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(lectureById,headers,HttpStatus.OK);
    }

    /**
     *
     * In pure RESTful services,
     * the Location header is the standard and preferred way to provide the URI of a newly created resource.
     * However, based on your API's consumers and their needs,
     * there's nothing wrong with including it in the body for better accessibility,
     * especially if you're building a more pragmatic API.
     */
    @RequestMapping(path = "/api/add-lecture"
                    ,method = RequestMethod.POST
                    ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Lecture> addLecture(@RequestBody Lecture lecture){
        Lecture savedLecture = service.addLecture(lecture);

        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(URI.create("http://localhost:8080/api/lecture-byId/"+lecture.getId()));

        return new ResponseEntity<>(savedLecture,headers,HttpStatus.CREATED);
    }



        @RequestMapping(path = "/update-lecture/{id}",
                       method = RequestMethod.PUT,
                       consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Map<String, Object>>
                       updateLecture(@PathVariable("id") Integer lectureId,
                                     @RequestBody Lecture lecture) {

            Optional<Lecture> updatedLectureOpt = service.updateLectureById(lectureId, lecture);

            if (!updatedLectureOpt.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Lecture updatedLecture = updatedLectureOpt.get();

            Map<String, Object> response = new HashMap<>();
            response.put("id", updatedLecture.getId());
            response.put("name", updatedLecture.getName());
            URI uri = URI.create("http://localhost:8080/api/lecture-byId/" + updatedLecture.getId());
            response.put("uri", uri);

            return new ResponseEntity<>(response, HttpStatus.OK);
        }


    @RequestMapping(path = "/api/delete-lecture/{id}"
            , method = RequestMethod.DELETE
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> deleteLecture(final @PathVariable Integer id) {
        service.deleteLecture(id);

        Map<String,String> response=new HashMap<>();
        response.put("status","REMOVED");
        response.put("message", "Lecture with Id: " + id + " REMOVED");
        response.put("timestamp",(ZonedDateTime.of
                (LocalDateTime.now(), ZoneId.systemDefault()).toInstant().toString()));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}

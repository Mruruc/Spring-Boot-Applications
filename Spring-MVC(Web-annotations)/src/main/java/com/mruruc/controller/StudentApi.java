package com.mruruc.controller;

import com.mruruc.model.Student;
import com.mruruc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
/**
 *
 * The @RestController combines @Controller and @ResponseBody.
 * Automatic Serialization:
 *
 * When using @RestController, the objects returned by the methods of the annotated class
 * are automatically serialized to the appropriate format (like JSON or XML) before being written to the HTTP response body.
 * Ideal for RESTful Web Services:
 *
 * @RestController simplifies the development of RESTful web services.
 * You don't need to specify views or templates; you just return the data, and Spring takes care of converting it into the appropriate format.
 */
@RequestMapping("/api")

public class StudentApi {
    private StudentService service;
    @Autowired
    public StudentApi(StudentService service){
        this.service=service;
    }

    /**
     *The primary purpose of @GetMapping is to make configuration for HTTP GET requests more concise and readable.
     *  It internally inherits from @RequestMapping, but it's set to handle GET requests by default.
     *
     * HTTP Method:
     * @GetMapping is specifically designed to handle HTTP GET requests.
     * This makes it inherently clear when glancing at a controller method what type of request it handles.
     */
    @GetMapping(value = "/name",
            produces ={MediaType.APPLICATION_JSON_VALUE})
    public List<Student> getByName(@RequestParam("name") String studentName){
        return service.findByName(studentName);
    }

    /**
     *The @RequestParam annotation in Spring MVC is a powerful feature that allows you to extract values from the query string of a URL.
     *  It's often used in form submissions and URL query parameters.
     *
     * Values from the query string or form submissions can be automatically converted and
     * bound to method parameters annotated with @RequestParam.
     *
     * List or Array as Parameters:
     *
     * If a request parameter can have multiple values (e.g., multi-select boxes in forms), you can bind it to a list or an array.
     *
     * Map All Parameters:
     * If you want to capture all parameters from the request without explicitly listing each one, you can use a Map:
     *
     * The way of passing data to URI is below :
     * "http://localhost:8080/student-api/params?name=Omer&age=24&faculty=Art"
     */
    @GetMapping(value = "/params")
    public String getParams(@RequestParam Map<String, String> allParams) {
        return allParams.toString();
    }

    @GetMapping(value = {"/{id}"})
    @ResponseStatus(value = HttpStatus.OK)
    public Optional<Student> findStudentById(@PathVariable("id") Integer studentId){
        return service.findStudentById(studentId);
    }

    /**
     *
     * Purpose: @PathVariable is used to extract values from the URI path.
     * Unlike request parameters (usually found after the ? in a URL), path variables are embedded within the URI itself.
     * This makes them particularly useful in RESTful services,
     * where URIs often represent resources and the ID or properties of the resource are embedded within the URI.
     *
     * Binding to Method Parameters:
     * The extracted value from the URI is automatically converted and bound to the method parameter annotated with @PathVariable.
     *
     * Type Conversion:
     * Spring automatically converts the extracted path variable to the method parameter's data type.
     * For instance, if the method parameter is of type Long, Spring will try to convert the path variable value to a Long.
     * If the conversion fails, a type mismatch exception occurs.
     *
     * Variable Naming:
     *
     * By default, the method parameter name is used as the path variable name. However, if the URI template variable has a different name, you can specify it explicitly. For example, in the URI /users/{id}, you can use @PathVariable("id") Long userId.
     * Multiple Path Variables:
     *
     * You can use multiple @PathVariable annotations in a single method to extract
     * Regular Expressions:
     *
     * You can use regex in @PathVariable to further specify the URI matching pattern. For
     */

    @GetMapping(value ={"/","student"},produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(value =HttpStatus.OK)
    public List<Student> findStudents(){
        return service.getAllStudent();
    }

    @PostMapping("/")
    @ResponseStatus(value = HttpStatus.CREATED,reason = "Successful")
    public void addStudent(@RequestBody Student student){
        service.add(student);
    }

    /**
     *It allows developers to specify the HTTP status code that should be returned in response to a web request.
     *It provides a mechanism to define custom responses when used with exceptions or directly on controller methods.
     *
     * The @ResponseStatus annotation can take two primary attributes:
     * value: The HTTP status code that will be returned. This is typically one of the values from the org.springframework.http.HttpStatus enumeration.
     * reason: A custom reason string that can be sent back as part of the HTTP response. This is optional.
     *
     * Combined with Exception Handling
     * The real power of @ResponseStatus comes out when combined with Spring's exception handling mechanisms.
     * When an exception annotated with @ResponseStatus is thrown from a controller method,
     * Spring's exception handling mechanisms will ensure the appropriate status code
     * and reason are returned in the HTTP response.
     */

}

package com.mruruc.controller;

import com.mruruc.model.Faculty;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
/**
 * The @Controller annotation is a core part of the Spring Web MVC framework,
 * which is designed for building web applications.
 * This annotation indicates that a class should be treated as a controller in the
 * Model-View-Controller (MVC) paradigm that Spring follows.
 */
public class FacultyController {

    /**
     * It's used to map web requests to specific handler classes or handler methods,
     * essentially defining how your application responds to certain web URLs or HTTP methods
     */

    /**
     * We can use as class-Level: Define a base URI for all methods in the class.
     * Path, or its aliases, name, and value: which URL the method is mapped to.
     * By default, @RequestMapping maps to all HTTP actions.
     * However, you can specify one or more HTTP methods using the method attribute
     * */

    /**
     *We can use @RequestMapping to map a URL to a method.
     **/
    /**
     * The headers attribute allows you to map the method based on request headers.
     */

    /**
     * produces:
     *
     * The produces attribute defines the types of media that the method can produce or send in its response.
     * It corresponds to what's acceptable as specified in the Accept header in the HTTP request.
     * Useful when you want to specify which format (e.g., JSON, XML) the response should be in, given what the client can accept.
     * it can produce multiple media type*/

    @RequestMapping(path= "/api/faculty",method = RequestMethod.GET,
                    produces ={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
                )
    @ResponseBody
    /**
     * Purpose: When you annotate a method with @ResponseBody,
     * you're telling Spring that the return value of the method should be written directly to the HTTP response body,
     * rather than being used to identify a view (like a JSP).
     *
     * Direct Response: Without @ResponseBody, the default behavior for controllers is to map the returned value to a view.
     * But with @ResponseBody, the serialization process is done automatically,
     * and the serialized value (JSON, XML, etc.) is written directly to the HTTP response.
     *
     * REST APIs: @ResponseBody is particularly useful when building RESTful web services
     * where you often want to send raw data in the response like JSON or XML rather than HTML views.
     */
    public Faculty getBook(){
        return new Faculty(102,"CS");
    }

    /**
     * consumes attribute:
     *
     * The consumes attribute of @RequestMapping specifies the types of media that the method can consume from client requests.
     * It's essentially a restriction based on the Content-Type header in the HTTP request.
     * Useful when you want a controller method to handle only requests with a specific type of content (e.g., JSON, XML)
     */

    @RequestMapping(path = "/api/add-faculty",method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addFaculty(@RequestBody Faculty faculty){
        new Faculty(faculty.getId(),faculty.getName());
    }

    /**
     *The @RequestBody annotation maps the HttpRequest body to a transfer,
     * onto a Java object.
     *
     * Deserialization:
     * When a client sends data (e.g., JSON or XML) in the body of a request, the data must be transformed into a Java object.
     * This process is known as deserialization.
     * The actual process of deserialization relies on libraries like Jackson (for JSON) or JAXB (for XML).
     * The appropriate library must be included in the project's dependencies.
     *
     * HttpMessageConverter:
     * Spring uses implementations of the HttpMessageConverter interface to convert between request/response objects and HTTP request/response messages.
     * For example, MappingJackson2HttpMessageConverter is used for JSON,
     * while MappingJackson2XmlHttpMessageConverter is used for XML, given that the Jackson library is on the classpath.
     * Content-Type:
     * The Content-Type header in the HTTP request plays a significant role in determining which HttpMessageConverter to use.
     * For instance, if the Content-Type is application/json, Spring will use a JSON converter.
     *
     * RESTful Services:
     * In modern web applications or microservices architectures, it's common to send data to the server using JSON format.
     * @RequestBody allows you to directly bind this incoming JSON data to a Java object.
     */

}


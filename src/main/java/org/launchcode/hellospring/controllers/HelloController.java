package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    // Create a Handler request in the form /hello?name=LaunchCode

//    @GetMapping("hello") //Specific Get request
//    @ResponseBody
//    public String helloWithQueryParam(@RequestParam String name){
//    return "Hello, " + name + "!";
//    }
    //lives at /hello/hello
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}) //General Get and Post request
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    // Handler that handles requests in the for /hello/LaunchCode

    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    // lives at hello/form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method = 'post'>" + //submit a request to /hello
                "<input type='text' name= 'name'>" +
                "<input type='submit' value ='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }



}

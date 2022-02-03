package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chris Bay
 */
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    public static String createMessage(String name, String language){
        if (language.equals("English")) {
            return "Hello, " + name;
        } else if (language.equals("French")) {
            return "Bonjour " + name;
        } else if (language.equals("Spanish") ) {
            return "Hola " + name;
        } else if (language.equals("Polish") ) {
            return "Witaj " + name;
        } else {
            return "Merhaba " + name;
        }
    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public static String greeting(@RequestParam String name, @RequestParam String language) {
        return createMessage(name, language);
    }

    // Handler that handles requests in the for /hello/LaunchCode
    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // /hello/form
    @GetMapping("form")
    public String greetingForm() {
        return "<html>" +
                "<body>" +
                "<form action = '/hello' method = 'post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name' >" +
                "<select name = 'language'>"+
                "<option value = 'French'>French</option>" +
                "<option value = 'English'>English</option>" +
                "<option value = 'Spanish'>Spanish</option>" +
                "<option value = 'Turkish'>Turkish</option>" +
                "<option value = 'Polish'>Polish</option>" +
                "</select>" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
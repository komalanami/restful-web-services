package com.projects.rest.webservices.restful_web_services.Controllers.HelloWorld;

import com.projects.rest.webservices.restful_web_services.Controllers.HelloWorld.HelloWorldBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloworld(){
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloworldBean() throws Exception {
//        throw new RuntimeErrorException(Some error has happened);
        return new HelloWorldBean("Hello World Changed");
    }

    @GetMapping("/hello-world/{name}")
    public HelloWorldBean helloworldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s",name));
    }


}

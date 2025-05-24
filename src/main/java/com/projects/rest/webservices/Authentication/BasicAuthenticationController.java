package com.projects.rest.webservices.Authentication;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
public class BasicAuthenticationController {

    @GetMapping("/basicauth")
    public AuthenticationBean authenticationBean() throws Exception {
//        throw new RuntimeErrorException(Some error has happened);
        return new AuthenticationBean("You are authenticated");
    }

    @GetMapping("/hello-world/{name}")
    public AuthenticationBean authenticationPathVariable(@PathVariable String name){
        return new AuthenticationBean(String.format("Hello World, %s",name));
    }


}

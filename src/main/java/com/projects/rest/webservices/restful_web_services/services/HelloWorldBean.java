package com.projects.rest.webservices.restful_web_services.services;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HelloWorldBean {

    private String message;

    public HelloWorldBean(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("HelloWorldBean [message=%s]", message);
    }

}

package com.projects.rest.webservices.restful_web_services.services.TodoList;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardCodedService {

    private static List<Todo> todos = new ArrayList<>();
    private static int idCounter = 0;

    static {
        todos.add(new Todo(++idCounter,"Shan","learn to sing",new Date(),false));
        todos.add(new Todo(++idCounter,"Shan","learn microservices",new Date(),false));
        todos.add(new Todo(++idCounter,"Shan","learn to write",new Date(),false));
    }

    public List<Todo> findAll(){
        return todos;
    }
}

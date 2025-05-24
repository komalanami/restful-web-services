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

    public Todo save(Todo todo) {
        if (todo.getId() == -1 || todo.getId() == 0) {
            todo.setId(++idCounter);
            todos.add(todo);
        } else {
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }

    public Todo deleteById(long id) {
        Todo todo = findbyId(id);

        if(todo==null) return null;

        if(todos.remove(todo)) {
            return todo;
        }

        return null;
    }

    public Todo findbyId(long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }
}

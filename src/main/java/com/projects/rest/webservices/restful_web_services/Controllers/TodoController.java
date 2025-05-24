package com.projects.rest.webservices.restful_web_services.Controllers;

import com.projects.rest.webservices.restful_web_services.services.TodoList.TodoHardCodedService;
import com.projects.rest.webservices.restful_web_services.services.TodoList.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {

    @Autowired
    private TodoHardCodedService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){
        return todoService.findAll();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo geTodo(@PathVariable String username , @PathVariable long id){
        return todoService.findbyId(id);
    }

    //DELETE /users/{username}/todos/{id}
    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(
            @PathVariable String username, @PathVariable long id){

        Todo todo = todoService.deleteById(id);

        if(todo!=null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    // edit update a todo
    //put /user/{user_name}/todos/{todoid}
    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username,
                                           @PathVariable long id, @RequestBody Todo todo) {
        Todo updatedTodo = todoService.save(todo);
        return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
    }


    //create a new todo
    //post call /users/{username}/todos
    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Todo> createTodo(@PathVariable String username, @RequestBody Todo todo) {
        Todo createdTodo = todoService.save(todo);
        //location get current resource url  new resource which got created

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();

    }

}

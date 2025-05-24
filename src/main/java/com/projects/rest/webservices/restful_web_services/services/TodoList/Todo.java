package com.projects.rest.webservices.restful_web_services.services.TodoList;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Todo {
    private long id;
    private String username;
    private String description;
    private Date targetDate;
    private boolean isDone;

    protected Todo(){

    }

    public Todo(long id, String username, String description, Date targetDate, boolean isDone) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }


}

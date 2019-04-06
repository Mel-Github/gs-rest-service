package com.example.controller;

import com.example.domain.TodoModel;
import com.example.domain.member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/todos")


public class TodoController {

    @Autowired
    RestTemplate restTemplate;
    @GetMapping

    public List<TodoModel> getTodos() {
//        String theUrl = "https://jsonplaceholder.typicode.com/todos";
        String theUrl = "https://api.meetup.com/Jenkins-User-Group-Singapore/events/256932104/attendance";
        ResponseEntity<List<TodoModel>> response = restTemplate.exchange
                (theUrl, HttpMethod.GET, null,  new ParameterizedTypeReference<List<TodoModel>>() {});
            List<TodoModel> todoList = response.getBody();
            return todoList;

    }

//    @GetMapping(path="/{id}")
//    public TodoModel getTodo(@PathVariable String id) {
//        String theUrl = "https://jsonplaceholder.typicode.com/todos/" + id;
//        ResponseEntity<TodoModel> response = restTemplate.exchange(theUrl, HttpMethod.GET, null, TodoModel.class );
//        TodoModel todoList = response.getBody();
//        return todoList;
//    }

    @GetMapping(path="/json")
    public String getTodosJson() {
        String theUrl = "https://api.meetup.com/Jenkins-User-Group-Singapore/events/256932104/attendance";
        ResponseEntity<String> response = restTemplate.exchange(theUrl, HttpMethod.GET, null, String.class);

        return response.getBody();
    }

    @GetMapping(path="/getUser")
    public List<member>  getUser() {

        String theUrl = "https://api.meetup.com/Jenkins-User-Group-Singapore/events/256932104/attendance";
        ResponseEntity<List<member>> response = restTemplate.exchange
                (theUrl, HttpMethod.GET, null,  new ParameterizedTypeReference<List<member>>() {});
        List<member> memberList = response.getBody();
        return memberList;


    }
}

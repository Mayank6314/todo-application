package com.example.TODO_Application.services;

import com.example.TODO_Application.entities.Todo;
import com.example.TODO_Application.repository.TODORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TODOService {

    @Autowired
    TODORepository todoRepository;

    public void saveTodo(Todo todo){
        todoRepository.save(todo);
    }

    public List<Todo> getallTodos(){
        return todoRepository.findAll();
    }
}

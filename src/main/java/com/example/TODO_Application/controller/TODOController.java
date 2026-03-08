package com.example.TODO_Application.controller;

import com.example.TODO_Application.entities.Todo;
import com.example.TODO_Application.services.TODOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TODOController {

    @Autowired
    TODOService todoService;

    @RequestMapping(value="/addtodo", method = RequestMethod.POST)
    @ResponseBody
    public String createTodo(@ModelAttribute Todo todo){
        todoService.saveTodo(todo);
        return "success";
    }

    @RequestMapping
    public String loadForm(){
        return "task";
    }

//    public String updateTodo(){
//
//    }
//
//    public String deleteTodo(){
//
//    }
//
    @RequestMapping
    public String getAllTodo(Model model){
        List<Todo> listOfTodos = todoService.getallTodos();
        model.addAttribute("listOfTodos", listOfTodos);
        return "task";
    }
}

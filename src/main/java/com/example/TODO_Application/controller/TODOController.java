package com.example.TODO_Application.controller;

import com.example.TODO_Application.entities.Todo;
import com.example.TODO_Application.services.TODOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TODOController {

    @Autowired
    TODOService todoService;

    @RequestMapping("/")
    public String getAllTodo(Model model){
        List<Todo> listOfTodos = todoService.getAllTodos();
        model.addAttribute("listoftodos", listOfTodos);
        return "task";
    }

    @RequestMapping(value="/addtodo", method = RequestMethod.POST)
    @ResponseBody
    public String createTodo(@ModelAttribute Todo todo){

        todoService.saveTODO(todo);
        return "success";
    }


    @RequestMapping(value="/updatetodo/{id}")
    public String updateTodo(@PathVariable("id") Long id, @ModelAttribute Todo todo){
        todoService.updateTodo(id, todo);
        return "redirect:/";
    }

    @RequestMapping("/deleteTODO/{id}")
    public String deleteTodo(@PathVariable("id") Long id){
        todoService.deleteTODO(id);
        return "redirect:/";
    }


}

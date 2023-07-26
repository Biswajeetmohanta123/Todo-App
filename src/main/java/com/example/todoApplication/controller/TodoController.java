package com.example.todoApplication.controller;

import com.example.todoApplication.model.Todo;
import com.example.todoApplication.service.TodoService;
//import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    TodoService todoService;
    @GetMapping(value = "/getTodo")
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }
    @GetMapping(value = "/getTodoByStatus")
    public List<Todo> getTodoByStatus(@RequestParam String status){
        return todoService.getTodoByUserStatus(status);
    }
    @GetMapping(value = "/todo")
    public List<Todo> getTodo(@RequestParam String id, @RequestParam String status){
        return todoService.getTodo(id,status);
    }
    @PostMapping(value = "/addTodo")
    public String addTodo(@RequestBody Todo todo){
        return todoService.getMyTodo(todo);
    }
    @RequestMapping(value = "/getTodoById/{id}",method = RequestMethod.GET)
    public Todo getTodoById(@PathVariable String id){
        return todoService.getTodoBasedOnId(id);
    }
    @DeleteMapping(value = "/deleteTodoById/{id}")
    public String deleteTodoById(@PathVariable String id){
        return todoService.removeTodoById(id);
    }
    @PutMapping(value="/updateTodoById/{id}/{status}")
    public String updateTodoStatusById(@PathVariable String id,@PathVariable String status){
        return todoService.updateTodoStatusById(id,status);
    }
}

package com.example.todoApplication.service;

import com.example.todoApplication.model.Todo;
import com.example.todoApplication.repository.TodoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    TodoDao todoDao;
    public List<Todo> getAllTodos() {
        return todoDao.getTodosFromDataSource();
    }
    public String getMyTodo(Todo todo){
        boolean insertionStatus = todoDao.save(todo);
        if(insertionStatus){
            return "Todo Added Successfully...!!!";
        }
        else{
            return "Failed Todo Not Possible... DataBase Error";
        }
    }

    public Todo getTodoBasedOnId(String id) {
        List<Todo> todoListRightNow = todoDao.getTodosFromDataSource();
        for(Todo todo: todoListRightNow){
            if(todo.getId().equals(id)){
                return todo;
            }
        }
        return null;
    }

    public String removeTodoById(String id) {
        boolean deleteResponse = false;
        String status;
        if(id != null){
            List<Todo> todoListRightNow = todoDao.getTodosFromDataSource();
            for(Todo todo : todoListRightNow){
                if(todo.getId().equals(id)){
                    deleteResponse = todoDao.remove(todo);
                    if(deleteResponse){
                        status = "todo with id "+id+" was deleted!!!";
                    }
                    else{
                        status = "todo with id "+id+" was not deleted!!!....Database Error";
                    }
                    return status;
                }
            }
            return "todo with id "+id+" does not exit";
        }
        else{
            return "invalid id ....Can Not accept null ID..";
        }
    }
    public String updateTodoStatusById(String id, String status) {
        boolean updateStatus = todoDao.update(id, Boolean.parseBoolean(status));
        if(updateStatus){
            return "todo with id "+id+" was updated";
        }
        return "todo with id "+id+" does not exit";
    }

    public List<Todo> getTodoByUserStatus(String status) {
        List<Todo> todoListRightNow = todoDao.getTodosFromDataSource();
        List<Todo> todoListStatusBased = new ArrayList<>();
        for(Todo todo: todoListRightNow){
            if(todo.isTodoStatus() == Boolean.parseBoolean(status)){
                todoListStatusBased.add(todo);
            }
        }
        return todoListStatusBased;
    }

    public List<Todo> getTodo(String id, String status) {
        List<Todo> todoListRightNow = todoDao.getTodosFromDataSource();
        List<Todo> todoListEitherByIdOrStatus = new ArrayList<>();
        if(id == null && status == null){
            return todoListRightNow;
        }
        else if(id != null && status != null){
            for(Todo todo : todoListRightNow){
                if(todo.getId().equals(id) && todo.isTodoStatus() == Boolean.parseBoolean(status)){
                    todoListEitherByIdOrStatus.add(todo);
                }
            }
        }
        else if(id != null){
            for(Todo todo : todoListRightNow){
                if(todo.getId().equals(id)){
                    todoListEitherByIdOrStatus.add(todo);
                }
            }
        }
        else {
            for(Todo todo : todoListRightNow){
                if(todo.isTodoStatus() == Boolean.parseBoolean(status)){
                    todoListEitherByIdOrStatus.add(todo);
                }
            }
        }
        return todoListEitherByIdOrStatus;
    }
}

package com.example.todoApplication.repository;

import com.example.todoApplication.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class TodoDao {
    private List<Todo> todoList;

    public TodoDao(){
        todoList = new ArrayList<>();
        todoList.add(new Todo("0","Dummy todo for Testing",true));
    }

    public List<Todo> getTodosFromDataSource() {
        return todoList;
    }
    public boolean save(Todo todo){
        todoList.add(todo);
        return true;
    }

    public boolean remove(Todo todo) {
        todoList.remove(todo);
        return true;
    }

    public boolean update(String id, boolean status) {
        for(Todo todo : todoList){
            if(todo.getId().equals(id)){
                //remove original
                remove(todo);

                //change todo now
                todo.setTodoStatus(status);

                //Add this new todo
                save(todo);
                return true;
            }
        }
        return false;
    }
}

# Todo-Application
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>

<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/Maven-3.0.6-brightgreen.svg" />
</a>

</center>

A todo application, also known as a task management or productivity app, is a software tool designed to help individuals or teams organize and keep track of their tasks and activities. It provides a centralized platform for creating, managing, and tracking tasks, enabling users to prioritize and stay on top of their work or personal responsibilities.

---
<br>

## Framework Used
* Spring Boot

---
<br>

## Dependencies
The following dependencies are required to run the project:

* Spring Boot Dev Tools
* Spring Web
* Lombok

## Language Used
* Java

---
<br>

## Data Model

The Job data model is defined in the Job class, which has the following attributes:
<br>

* todo Model
```
String id : String;
todoName : String;
todoStatus : boolean;
```

## Data Flow

1. The todo at client side sends a request to the application through the API endpoints.
2. The API receives the request and sends it to the appropriate controller method.
3. The controller method makes a call to the method in service class.
4. The method in service class builds logic and retrieves or modifies data from the database, which is in turn given to controller class
5. The controller method returns a response to the API.
6. The API sends the response back to the todo.

---

<br>


## API End Points 

The following endpoints are available in the API:

* User Controller:
```
POST /addtodo: create a new todo list
GET /getTodo: read all todo list
GEt /getTodoByStatus: read all todo based on status
PUT /updateTodoById/{id}/{status}: update todo based on id and status
DELETE /deleteTodoById/{id}: delete todo based on id
```


<br>

## DataBase Used

```
We have used Arraylist database to implement CRUD Operations.
```
---
<br>

## Project Summary

Overall, a todo application serves as a digital task manager, offering a structured and efficient way to organize, prioritize, and track tasks, enhancing productivity and helping individuals and teams stay organized and focused on their goals.


## 📝 Licence
---
Copywrite © 2019 [Biswajeet]().

This project is [Geekster]() Licensed.
 
---
_This README was generated with ❤️  by [readme-github]()_

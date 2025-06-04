package com.todo.todoapp.repository;

import com.todo.todoapp.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
//Repository is used to connect the applicaiton to db. JpaRepositroy is for
// giving CRUD operations , set of pre defined methods. Task is the primary key and Long is the
// type of the primary key
public interface TaskRepository extends JpaRepository<Task, Long> {

}

package com.todo.todoapp.services;

import com.todo.todoapp.models.Task;
import com.todo.todoapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    //Get access to the TaskRepository class
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        //This is going to return list of all the things
        return taskRepository.findAll();
    }

    public void createTask(String title) {
         Task task = new Task();
         task.setTitle(title);
         task.setCompleted(false);
         taskRepository.save(task); //Save to the database using repository
    }

    public void deleteTasks(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggleTasks(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task id (Exception)"));
                task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}

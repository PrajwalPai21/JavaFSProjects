package com.todo.todoapp.controller;

import com.todo.todoapp.models.Task;
import com.todo.todoapp.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasks(Model model){
        List<Task> tasksList = taskService.getAllTasks();
        model.addAttribute("tasks",tasksList);
        return "tasks"; //Thymeleaf template
    }


    @PostMapping
//    String title is the variable in the tasks.html input form, dont mismatch
    public String createTask(@RequestParam String title){
//        Create a task and here is the title that needs to be created
        taskService.createTask(title);
        return "redirect:/"; //Thymeleaf template , basically redirect to root upon post
    }

    @GetMapping("/{id}/delete")
//    PathVar is because we are accepting something from the path of url
    public String deleteTasks(@PathVariable Long id){ //pathvariable tells to look at the path  in the @GetMapping("{}/delete)
       taskService.deleteTasks(id);
        return "redirect:/"; //Thymeleaf template
    }

    @GetMapping("/{id}/toggle")
//    PathVar is because we are accepting something from the path of url
    public String toggleTasks(@PathVariable Long id){ //pathvariable tells to look at the path  in the @GetMapping("{}/delete)
        taskService.toggleTasks(id);
        return "redirect:/"; //Thymeleaf template
    }

}

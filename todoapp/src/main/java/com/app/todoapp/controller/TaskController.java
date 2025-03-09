package com.app.todoapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.todoapp.models.Task;
import com.app.todoapp.services.TaskService;

@Controller
// @RequestMapping("tasks")
public class TaskController {
    private final TaskService taskService;
    
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    
    @GetMapping
    public String getTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping
    public String createTasks(@RequestParam String title, @RequestParam String dueDate) {
        System.out.println("title: " + title + " dueDate: " + dueDate);
        taskService.createTask(title, dueDate);
        return "redirect:/"; // redirect to the root URL (es un refresh)
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        taskService.toggleTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editTask(@PathVariable Long id) {
        taskService.editTask(id);
        return "redirect:/";
    }

    @PostMapping("/{id}/update")
    public String updateTask(@PathVariable Long id, @RequestParam String title, @RequestParam String dueDate) {
        taskService.updateTask(id, title, dueDate);
        return "redirect:/";
    }

}

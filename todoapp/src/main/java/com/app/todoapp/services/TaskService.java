package com.app.todoapp.services;
import org.springframework.stereotype.Service;
import com.app.todoapp.models.Task;
import com.app.todoapp.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
        
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    
}

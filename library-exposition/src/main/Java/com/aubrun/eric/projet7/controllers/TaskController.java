package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.business.dto.TaskDto;
import com.aubrun.eric.projet7.business.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public List<TaskDto> getAllTasks() {
        return this.taskService.findAll();
    }

    @GetMapping("/{id}")
    public TaskDto getTaskById(@PathVariable(value = "id") int taskId) {
        return this.taskService.findById(taskId);
    }

    @PostMapping("/")
    private void createTask(@RequestBody TaskDto taskDto) {
        taskService.save(taskDto);
    }

    @PutMapping("/task")
    private void updateTask(@RequestBody TaskDto taskDto) {
        taskService.update(taskDto);
    }

    @DeleteMapping("/{id}")
    private void deleteTask(@PathVariable("id") int id) {
        taskService.delete(id);
    }
}

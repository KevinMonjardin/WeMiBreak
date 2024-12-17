package com.taskify.wemibreak.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskify.wemibreak.persistence.entity.Task;
import com.taskify.wemibreak.services.TaskService;
import com.taskify.wemibreak.services.dto.TaskDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@Valid @RequestBody TaskDTO taskDTO) {
        return this.taskService.create(taskDTO);
    }

    @GetMapping
    public List<Task> findTasks() {
        return this.taskService.retrieve();
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Void> updateTasks(@PathVariable("id") Long id) {
        this.taskService.update(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

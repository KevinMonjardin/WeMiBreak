package com.taskify.wemibreak.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taskify.wemibreak.mappers.TaskDTOToTask;
import com.taskify.wemibreak.persistence.entity.Task;
import com.taskify.wemibreak.persistence.repository.TaskRepository;
import com.taskify.wemibreak.services.dto.TaskDTO;

import jakarta.transaction.Transactional;

@Service
public class TaskService {
    private final TaskRepository repository;
    private final TaskDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task create(TaskDTO taskDTO) {
        Task task = mapper.map(taskDTO);
        return this.repository.save(task);
    }

    public List<Task> retrieve() {
        return this.repository.findAll();
    }

    @Transactional
    public void update(Long id) {
        this.repository.updateTask(id);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}

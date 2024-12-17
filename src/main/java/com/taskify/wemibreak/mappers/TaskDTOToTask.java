package com.taskify.wemibreak.mappers;

import org.springframework.stereotype.Component;

import com.taskify.wemibreak.persistence.entity.Task;
import com.taskify.wemibreak.persistence.entity.TaskStatus;
import com.taskify.wemibreak.services.dto.TaskDTO;

@Component
public class TaskDTOToTask implements GeneralMapper<TaskDTO, Task> {

    @Override
    public Task map(TaskDTO in) {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setStatus(TaskStatus.PENDING);
        return task;
    }

}
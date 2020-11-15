package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.Task;
import com.aubrun.eric.projet7.business.dto.TaskDto;

public class TaskDtoMapper {

    static public TaskDto toDto(Task task) {

        TaskDto dto = new TaskDto();
        dto.setTaskId(task.getTaskId());
        dto.setTaskName(task.getTaskName());
        return dto;
    }

    static public Task toEntity(TaskDto taskDto) {

        Task entity = new Task();
        entity.setTaskId(taskDto.getTaskId());
        entity.setTaskName(taskDto.getTaskName());
        return entity;
    }
}

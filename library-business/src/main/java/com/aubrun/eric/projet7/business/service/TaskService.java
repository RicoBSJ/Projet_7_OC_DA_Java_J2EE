package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.business.dto.TaskDto;
import com.aubrun.eric.projet7.business.mapper.TaskDtoMapper;
import com.aubrun.eric.projet7.consumer.repository.TaskRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskDto> findAll() {
        return taskRepository.findAll().stream().map(TaskDtoMapper::toDto).collect(Collectors.toList());
    }

    public int save(TaskDto newTask) {
        return taskRepository.save(TaskDtoMapper.toEntity(newTask)).getTaskId();
    }

    public TaskDto update(TaskDto task) {
        return TaskDtoMapper.toDto(taskRepository.save(TaskDtoMapper.toEntity(task)));
    }

    public TaskDto findById(Integer id) {
        return TaskDtoMapper.toDto(taskRepository.findById(id).get());
    }

    public void delete(int id) {
        taskRepository.deleteById(id);
    }
}

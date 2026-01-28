package com.example.SecondTask.service;

import com.example.SecondTask.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SecondTask.repository.TaskRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(UUID id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(UUID id, Task updatedTask) {
        if (!taskRepository.findById(id).isPresent()) {
            return null;
        }
        updatedTask.setId(id);
        return taskRepository.save(updatedTask);
    }

    public boolean deleteTask(UUID id) {
        return taskRepository.deleteById(id);
    }
}
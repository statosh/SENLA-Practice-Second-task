package com.example.SecondTask.repository;

import com.example.SecondTask.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class TaskRepository {
    private static final List<Task> tasks = new ArrayList<>();

    public List<Task> findAll() {
        return new ArrayList<>(tasks);
    }

    public Optional<Task> findById(UUID id) {
        return tasks.stream().filter(t -> t.getId().equals(id)).findFirst();
    }

    public Task save(Task task) {
        if (task.getId() == null) {
            task.setId(UUID.randomUUID());
            tasks.add(task);
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).getId().equals(task.getId())) {
                    tasks.set(i, task);
                    break;
                }
            }
        }
        return task;
    }

    public boolean deleteById(UUID id) {
        return tasks.removeIf(t -> t.getId().equals(id));
    }
}
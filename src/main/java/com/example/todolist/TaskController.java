package com.example.todolist;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private List<Task> tasks = new ArrayList<>();

    private int nextId = 1;

    @GetMapping
    public List<Task> getAllTasks() {
        return tasks;
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        task.setId(nextId);
        task.setDone(false);
        nextId = nextId + 1;
        tasks.add(task);
        return task;
    }

    @PutMapping("/{id}")
    public Task markAsDone(@PathVariable int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setDone(true);
                return task;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.remove(i);
                return;
            }
        }
    }
}

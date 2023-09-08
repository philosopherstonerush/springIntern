package com.aula.assign.crudApp.rest;

import com.aula.assign.crudApp.documents.taskItem;
import com.aula.assign.crudApp.repository.taskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
public class TaskCRUD {

    @Autowired
    taskRepository taskRepo;

    @GetMapping("/tasks")
    public Object getAllTasks() {
        List<taskItem> tasks = taskRepo.findAll();
        return tasks;
    }

    @PostMapping("/tasks")
    public Object insertTask(@RequestBody taskItem tt) {
        return taskRepo.insert(tt);
    }

    @PutMapping("/tasks/{id}")
    public Object updateTask(@RequestBody taskItem tt, @PathVariable("id") String id) {
        int updated = taskRepo.updateTask(id, tt);
        return updated;
    }

    @GetMapping("tasks/{id}")
    public Object getTask(@PathVariable("id") String id) {
        return taskRepo.findById(id);
    }

    @DeleteMapping("tasks/{id}")
    public Object deleteTasks(@PathVariable("id") String id) {
        taskRepo.deleteById(id);
        return id;
    }

}

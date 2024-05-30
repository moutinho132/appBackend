package com.practica.appbackend.controller;


import com.practica.appbackend.model.TaskDto;
import com.practica.appbackend.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/task")
@AllArgsConstructor
public class TaskController {
    private TaskService taskService;

    /*@PostMapping
    ResponseEntity<TaskDto> addTask(@RequestBody TaskDto task) {

        return new ResponseEntity<>(new TaskDto(null,null,null,null), HttpStatus.ACCEPTED);
    }*/

    @PostMapping
    public Mono<TaskDto> addTask(@RequestBody TaskDto task) {
        return taskService.addTask(task);
    }


}

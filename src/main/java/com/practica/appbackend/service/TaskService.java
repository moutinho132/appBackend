package com.practica.appbackend.service;

import com.practica.appbackend.model.TaskDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Log4j2
public class TaskService {

    private WebClient webClient;

    public TaskService(@Qualifier("taskWebClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<TaskDto> addTask(TaskDto task) {
        return webClient.post()
                .uri("http://localhost:8080/api/task")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(task),
                        TaskDto.class)
                .retrieve()
                .bodyToMono(TaskDto.class);
    }



}

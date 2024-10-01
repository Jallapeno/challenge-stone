package com.hytalocoelho.docker_manager.controllers;

import com.github.dockerjava.api.model.Container;
import com.hytalocoelho.docker_manager.services.DockerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/containers")
public class DockerContainersController {
    private final DockerService dockerService;

    public DockerContainersController(DockerService dockerService) {
        this.dockerService = dockerService;
    }

    @GetMapping("")
    public List<Container> listContainers(
            @RequestParam(required = false, defaultValue = "true") boolean showAll
    ) {
        return dockerService.listContainers(showAll);
    }

    @PostMapping("/{containerId}/stop")
    public void stopContainer(@PathVariable String containerId) {
        dockerService.stopContainer(containerId);
    }

    @PostMapping("/{containerId}/start")
    public void startContainer(@PathVariable String containerId) {
        dockerService.startContainer(containerId);
    }

    @PostMapping("/{containerId}/remove")
    public void removeContainer(@PathVariable String containerId) {
        dockerService.removeContainer(containerId);
    }

    @PostMapping("/{imageName}/create")
    public void createContainer(@PathVariable String imageName) {
        dockerService.createContainer(imageName);
    }

}

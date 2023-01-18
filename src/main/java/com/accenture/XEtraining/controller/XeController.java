package com.accenture.XEtraining.controller;

import brave.Tracer;
import com.accenture.XEtraining.entity.Demo;
import com.accenture.XEtraining.repository.XeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/XeTraining")
public class XeController {

    private final XeRepository repo;

    Tracer tracer;

    public XeController(XeRepository repo, Tracer tracer) {
        this.repo = repo;
        this.tracer = tracer;
    }

    @GetMapping("/test") //for testing purpose only-to get list
    public List<Demo> getList(){
        return repo.findAll();
    }

    @GetMapping("/testing/{id}")
    public ResponseEntity<?> test(@PathVariable(value = "id") long id) {
        System.out.println(tracer.currentSpan().context().traceIdString());
        return ResponseEntity.ok(repo.findById(id).get());
    }
}

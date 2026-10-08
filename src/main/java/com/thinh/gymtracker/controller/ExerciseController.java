package com.thinh.gymtracker.controller;

import com.thinh.gymtracker.dto.ExerciseRequest;
import com.thinh.gymtracker.model.Exercise;
import com.thinh.gymtracker.repository.ExerciseRepository;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController 
@RequestMapping("/api/exercises")
public class ExerciseController {
    private final ExerciseRepository exerciseRepository;

    public ExerciseController(ExerciseRepository exerciseRepository){
        this.exerciseRepository = exerciseRepository;
    }

    @GetMapping
    public List<Exercise> getAll(){
        return exerciseRepository.findAll();
    } 

    @PostMapping 
    @ResponseStatus (HttpStatus.CREATED)
    public void create(@Valid @RequestBody ExerciseRequest request){
        exerciseRepository.save(new Exercise(null, request.name(), request.muscleGroup()));
    }
}

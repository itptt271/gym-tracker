package com.thinh.gymtracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ExerciseRequest(
    @NotBlank @Size (max = 50) String name,
    @NotBlank String muscleGroup
) {
} 
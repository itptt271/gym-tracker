package com.thinh.gymtracker.repository;

import com.thinh.gymtracker.model.Exercise;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository 
public class ExerciseRepository {
    private final JdbcTemplate jdbcTemplate;
    public ExerciseRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Exercise> findAll(){
        String sql = "SELECT id, name, muscle_group FROM exercises ORDER BY name";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Exercise(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("muscle_group")
        ));
    }

    public void save(Exercise exercise){
        String sql = "INSERT INTO exercises (name, muscle_group) VALUES (?, ?)";
        jdbcTemplate.update(sql, exercise.name(), exercise.muscleGroup());
    }
}

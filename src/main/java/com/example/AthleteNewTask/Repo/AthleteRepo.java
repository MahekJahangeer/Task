package com.example.AthleteNewTask.Repo;

import com.example.AthleteNewTask.model.Athlete;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AthleteRepo extends CrudRepository<Athlete,String>{


    List<Athlete> findByGender(String gender);

    void deleteByName(String name);

    Optional<Athlete> findByName(String name);
}

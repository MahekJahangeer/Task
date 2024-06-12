package com.example.AthleteNewTask.service;

import com.example.AthleteNewTask.Controller.AthleteController;
import com.example.AthleteNewTask.Repo.AthleteRepo;
import com.example.AthleteNewTask.Request.WorkflowStartRequest;
import com.example.AthleteNewTask.client.AbstractOrchestrationClient;
import com.example.AthleteNewTask.model.Athlete;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AthleteService {

    private final Logger logger = LoggerFactory.getLogger(AthleteService.class);
    private final AbstractOrchestrationClient abstractOrchestrationClient;
    private String workflowBaseUri="http//localhost:5000";
    @Autowired
    AthleteRepo repo;

    public Athlete addAthletes(Athlete athlete) {

        athlete.setStatus("ADDED");
        athlete.setTimeStamp(new Date());
        Athlete athleteSaved = (Athlete) repo.save(athlete);

        WorkflowStartRequest request =
                WorkflowStartRequest.builder().name("Athlete_01").input(athleteSaved).build();
        logger.debug("WorkflowStartRequest request is::{}", request);

        String workflowId = abstractOrchestrationClient.startWorkflow(request);
        logger.debug("WorkflowStartRequest workflowId is::{}", workflowId);

        String workflowUri = workflowBaseUri + "/execution/{workflowId}";

        workflowUri = workflowUri.replaceAll("\\{workflowId}", workflowId);
        logger.debug("WorkflowStartRequest workflowUri is::{}", workflowUri);

        return athleteSaved;
    }

    public List<Athlete> getAthlete() {

        return (List<Athlete>) repo.findAll();
    }


    public List<Athlete> getAthleteByGender(String gender) {

        return repo.findByGender(gender);
    }

    public Athlete updAthlete(Athlete athlete, String id) {

        Optional<Athlete> getAthleteById = repo.findById(id);

        logger.debug("athlete is {}", getAthleteById);

        if (getAthleteById.isPresent()) {

            getAthleteById.get().setStatus(athlete.getStatus());
            getAthleteById.get().setTimeStamp(new Date());
            repo.save(getAthleteById.get());
            logger.debug("upd athlete{}", getAthleteById);
        }
        return getAthleteById.get();
    }

    public void deleteAthlete(String name) {

        repo.deleteByName(name);
    }
}

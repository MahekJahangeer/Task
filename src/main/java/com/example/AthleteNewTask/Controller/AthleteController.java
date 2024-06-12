package com.example.AthleteNewTask.Controller;

import com.example.AthleteNewTask.Repo.AthleteRepo;
import com.example.AthleteNewTask.model.Athlete;
import com.example.AthleteNewTask.service.AthleteService;
import com.example.AthleteNewTask.service.NetflixConductorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class AthleteController {


    private final AthleteService athleteService;
    private final Logger logger = LoggerFactory.getLogger(AthleteController.class);


    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;

    }

    @PostMapping("/athlete")
    public Athlete addAthletes(@RequestBody Athlete athlete){

        logger.info("adding Athlete:::");
        Athlete addedAthlete = athleteService.addAthletes(athlete);
        return addedAthlete;

    }

    @GetMapping("/athletes")
    public List<Athlete> getAthlete() {

        logger.info("getting all the athletes");
        List<Athlete> getAthleteList=athleteService.getAthlete();

        return getAthleteList;

    }

    @GetMapping("/athlete/{gender}")
    public List<Athlete> getAthleteByGender(@PathVariable("gender")String gender) {

        logger.info("getting Athletes by gender");
        List<Athlete> athlete=athleteService.getAthleteByGender(gender);
        return athlete;
    }

    @PutMapping("/athlete/{id}")
    public Athlete updateAthlete(@RequestBody Athlete athlete,@PathVariable("id") String id) {

        logger.info("Updating Athlete");
        Athlete updAthlete=athleteService.updAthlete(athlete,id);
        return updAthlete;

    }

    @DeleteMapping(path="/athlete/{name}")
    public String DeleteAthlete(@PathVariable("name") String name) {

        athleteService.deleteAthlete(name);
        return "Deleted record of " + name;

    }


}

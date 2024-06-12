package com.example.AthleteNewTask.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "race")
@Data
public class Athlete {


    @Id
    private String id;
    private String name;
    private int age;
    private String gender;
    private String status;
    private Date timeStamp;

}

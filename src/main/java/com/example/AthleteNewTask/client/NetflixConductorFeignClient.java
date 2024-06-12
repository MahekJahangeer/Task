package com.example.AthleteNewTask.client;

import com.example.AthleteNewTask.Request.WorkflowStartRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "netflix-conductor-uservice",
        url = "http://localhost:8080")
public interface NetflixConductorFeignClient {


    @PostMapping("/api/workflow")
    ResponseEntity<String> startWorkflow(@RequestBody WorkflowStartRequest workflowStartRequest);
}

package com.example.AthleteNewTask.service;

import com.example.AthleteNewTask.Request.WorkflowStartRequest;
import com.example.AthleteNewTask.client.AbstractOrchestrationClient;
import com.example.AthleteNewTask.client.NetflixConductorFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Slf4j
@Service
@RequiredArgsConstructor
public class NetflixConductorService implements AbstractOrchestrationClient {

    private final NetflixConductorFeignClient netflixConductorFeignClient;
    private final Logger logger = LoggerFactory.getLogger(NetflixConductorService.class);

    @Override
    public String startWorkflow(WorkflowStartRequest workflowRequest) {
        logger.info("Start - NetflixConductorService : startWorkflow ");
        StopWatch watch = new StopWatch();
        watch.start();
        ResponseEntity<String> startWorkflowResponse;


        startWorkflowResponse = netflixConductorFeignClient.startWorkflow(workflowRequest);


        return startWorkflowResponse.getBody();
    }
}

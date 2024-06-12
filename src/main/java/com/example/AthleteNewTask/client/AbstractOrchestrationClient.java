package com.example.AthleteNewTask.client;

import com.example.AthleteNewTask.Request.WorkflowStartRequest;

public interface AbstractOrchestrationClient {

    String startWorkflow(WorkflowStartRequest workflowRequest);
}

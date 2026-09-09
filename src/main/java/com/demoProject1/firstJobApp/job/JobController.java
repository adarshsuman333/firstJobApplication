package com.demoProject1.firstJobApp.job;


import com.demoProject1.firstJobApp.job.impl.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
GET /jobs: Get all jobs
GET /jobs/{id}: Get a specific job by ID
POST /jobs: Create a new job (request body should contain the job details)
DELETE /jobs/{id}: Delete a specific job by ID
PUT /jobs/{id}: Update a specific job by ID (request body should contain the updated job details)
GET /jobs/{id}/company: Get the company associated with a specific job by ID

Example API URLs:
GET {base_url}/jobs
GET {base_url}/jobs/1
POST {base_url}/jobs
DELETE {base_url}/jobs/1
PUT {base_url}/jobs/1
GET {base_url}/jobs/1/company

*
*/

@RestController
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobService.findAll();
    }

    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job){
        jobService.createJob(job);
        return "Job added successfully.";
    }

    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if (job!=null){
            return job;
        }
        return new Job(1L, "Test Job", "Test description", "18000", "21000", "Hyderabad");
    }

}

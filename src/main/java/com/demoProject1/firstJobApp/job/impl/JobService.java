package com.demoProject1.firstJobApp.job.impl;

import com.demoProject1.firstJobApp.job.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
}

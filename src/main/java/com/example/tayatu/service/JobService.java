package com.example.tayatu.service;

import com.example.tayatu.model.JobPost;
import com.example.tayatu.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    public JobRepo repo;

    public void addJob(JobPost job){
        repo.addJob(job);
    }

    public List<JobPost> getAllJobs(){
        return repo.getAllJobs();
    }

    public JobPost getJob(int id) {
        return  repo.getJob(id);
    }

    public void updateJob(JobPost jobPost) {
        repo.updateJob(jobPost);

    }

    public void deleteJob(int jobId) {
        repo.deleteJob(jobId);
    }
}

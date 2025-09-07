package com.example.tayatu;

import com.example.tayatu.model.JobPost;
import com.example.tayatu.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    @Autowired
   private JobService jobService;


    @GetMapping("jobposts")
    @ResponseBody
    public List<JobPost> getAlljobs(){
        return  jobService.getAllJobs();
    }

    @GetMapping("jobpost/{jobId}")
    public JobPost getJob(@PathVariable("jobId") int jobId){
        System.out.println(jobId);

        return jobService.getJob(jobId);
    }

    @PostMapping("jobpost")
    public void addJob(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);
    }

    @PutMapping("jobpost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        jobService.updateJob(jobPost);
        return  jobService.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobpost/{jobId}")
    public void deleteJob(@PathVariable("jobId") int jobId){
        System.out.println(jobId);
        jobService.deleteJob(jobId);
    }


    @PostMapping("addTestJobs")
    public void addJob(){
        jobService.saveTestJobs();
    }

    @GetMapping("jobpost/keyword/{keyword}")
    public List<JobPost> searchJobs(@PathVariable("keyword") String keyword){
        return jobService.findByKeyword(keyword);
    }

}

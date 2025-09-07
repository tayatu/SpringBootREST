package com.example.tayatu.repo;

import com.example.tayatu.model.JobPost;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
@Component
public class JobRepo {

    // ArrayList to store JobPost objects
    List<JobPost> jobs = new ArrayList<>(Arrays.asList(

            new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                    List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),


            new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
                    List.of("HTML", "CSS", "JavaScript", "React")),


            new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                    List.of("Python", "Machine Learning", "Data Analysis")),


            new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
                    List.of("Networking", "Cisco", "Routing", "Switching")),


            new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
                    List.of("iOS Development", "Android Development", "Mobile App"))
    ));

    public List<JobPost> getAllJobs(){
        System.out.println("repo");
        System.out.println(jobs);
        return jobs;
    }

    public  void  addJob(JobPost job){

        jobs.add(job);
        System.out.println("jobs");
        System.out.println(jobs);
    }


    public JobPost getJob(int id) {
        for (JobPost job : jobs) {
            if (job.getPostId() == id) {
                return job;
            }
        }
        return null; // or throw exception if not found
    }

    public void updateJob(JobPost jobPost) {
        int id = jobPost.getPostId();
        for (JobPost job : jobs) {
            if (job.getPostId() == id) {
                job.setPostDesc(jobPost.getPostDesc());
                job.setPostProfile(jobPost.getPostProfile());
                job.setReqExperience(jobPost.getReqExperience());
            }
        }
    }

    public void deleteJob(int jobId) {
        jobs.removeIf(job -> job.getPostId() == jobId);

    }
}

package com.waleed.Job.tracker.APi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public List<JobApplication> getAlljobs(){
        return jobRepository.findAll();
    }

    public JobApplication saveJob(JobApplication job){
        return jobRepository.save(job);
    }

    public void deleteJob(Long id){
        jobRepository.deleteById(id);
    }

    public JobApplication updateJob(Long id, JobApplication updatedDetails){
        JobApplication existingJob = jobRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(" No id found "+id));
        existingJob.setCompanyName(updatedDetails.getCompanyName());
        existingJob.setJobTitle(updatedDetails.getJobTitle());
        existingJob.setStatus(updatedDetails.getStatus());
        existingJob.setOfferedSalary(updatedDetails.getOfferedSalary());
        return  jobRepository.save(existingJob);
    }
    public List<JobApplication> searchByCompany(String companyName){
        return jobRepository.findByCompanyName(companyName);
    }


}

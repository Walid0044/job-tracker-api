package com.waleed.Job.tracker.APi;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping
    public List<JobApplication> getAll(){
        return jobService.getAlljobs();
    }

    @PostMapping
    public JobApplication create(@Valid @RequestBody JobApplication job){
        return jobService.saveJob(job);
    }
    @DeleteMapping("/{id}")
    public String deletejob(@PathVariable Long id){
        jobService.deleteJob(id);
        return "Job deleted successfully";
    }
    @PutMapping("/{id}")
    public JobApplication updateJob(@PathVariable Long id,@RequestBody JobApplication updated){
        return jobService.updateJob(id, updated);
    }
    @GetMapping("/search")
    public List<JobApplication> findByCompanyName(@RequestParam String companyName){
        return jobService.searchByCompany(companyName);
    }

}

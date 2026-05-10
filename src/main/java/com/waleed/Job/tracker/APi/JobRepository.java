package com.waleed.Job.tracker.APi;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<JobApplication, Long> {
    List<JobApplication> findByCompanyName(String companyName);
    List<JobApplication> findByStatus(String status);
}

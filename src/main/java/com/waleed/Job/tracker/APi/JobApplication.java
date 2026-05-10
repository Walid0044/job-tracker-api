package com.waleed.Job.tracker.APi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Entity
@Data
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

@NotBlank(message = "name is required ")
    private String companyName;

@NotBlank(message = "title is required")
    private String jobTitle;
    private String status;
    @PositiveOrZero(message = "digit number must greater than zero ")
    private double offeredSalary;



}

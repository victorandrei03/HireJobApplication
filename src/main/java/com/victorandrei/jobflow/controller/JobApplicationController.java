
package com.victorandrei.jobflow.controller;

import com.victorandrei.jobflow.entity.JobApplication;
import com.victorandrei.jobflow.service.JobApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    public JobApplicationController(
            JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @GetMapping
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationService.getAllJobApplications();
    }

    @GetMapping("/{id}")
    public JobApplication getJobApplicationById(@PathVariable Long id) {
        return jobApplicationService.getJobApplicationById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Application not found with id: " + id));
    }

    @PostMapping
    public JobApplication createJobApplication(
            @RequestBody JobApplication jobApplication) {
        return jobApplicationService.createJobApplication(jobApplication);
    }

    @PutMapping("/{id}")
    public JobApplication updateJobApplication(
            @PathVariable Long id,
            @RequestBody JobApplication updatedApplication) {
        return jobApplicationService.updateJobApplication(
                id, updatedApplication);
    }

    @DeleteMapping("/{id}")
    public String deleteJobApplication(@PathVariable Long id) {
        jobApplicationService.deleteJobApplication(id);
        return "Application deleted successfully!";
    }
}

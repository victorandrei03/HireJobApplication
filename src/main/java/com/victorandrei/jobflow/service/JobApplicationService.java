
package com.victorandrei.jobflow.service;

import com.victorandrei.jobflow.entity.JobApplication;
import com.victorandrei.jobflow.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;

    public JobApplicationService(
            JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    public JobApplication createJobApplication(
            JobApplication jobApplication) {
        return jobApplicationRepository.save(jobApplication);
    }

    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }

    public Optional<JobApplication> getJobApplicationById(Long id) {
        return jobApplicationRepository.findById(id);
    }

    public JobApplication updateJobApplication(
            Long id, JobApplication updatedApplication) {

        return jobApplicationRepository.findById(id)
                .map(existingApplication -> {
                    existingApplication.setCompany(
                            updatedApplication.getCompany());
                    existingApplication.setPosition(
                            updatedApplication.getPosition());
                    existingApplication.setStatus(
                            updatedApplication.getStatus());
                    existingApplication.setApplicationDate(
                            updatedApplication.getApplicationDate());

                    return jobApplicationRepository.save(existingApplication);
                })
                .orElseThrow(() -> new RuntimeException(
                        "Job application not found with id: " + id));
    }

    public void deleteJobApplication(Long id) {
        jobApplicationRepository.deleteById(id);
    }
}

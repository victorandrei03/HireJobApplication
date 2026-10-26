package com.victorandrei.jobflow.repository;

import com.victorandrei.jobflow.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository
        extends JpaRepository<JobApplication, Long> {
}

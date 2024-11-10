package com.interview.repo;

import com.interview.model.InterviewRecording;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewRecordingRepository extends JpaRepository<InterviewRecording, Long> {}

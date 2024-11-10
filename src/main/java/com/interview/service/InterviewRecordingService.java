package com.interview.service;

// src/service/InterviewService.java


import com.interview.model.InterviewRecording;
import com.interview.repo.InterviewRecordingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterviewRecordingService {
    @Autowired
    private InterviewRecordingRepository repository;

    public InterviewRecording saveRecording(InterviewRecording recording) {
        return repository.save(recording);
    }
}
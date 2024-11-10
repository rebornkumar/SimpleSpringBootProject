// src/model/InterviewRecording.java
package com.interview.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class InterviewRecording {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String interviewer;
    private String interviewee;
    private String transcript; // This should be encrypted in production.
    private String s3Url;
    private Date dateRecorded;

    public InterviewRecording(String number, String johnDoe, String janeSmith, String s, Date date, String path) {
    }
}
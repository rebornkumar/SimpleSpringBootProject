package com.interview.controller;

import com.interview.service.analysis.predictive.PredictiveModelService;
import com.interview.service.analysis.sentiment.SentimentService;
import com.interview.service.analysis.tone.ToneAnalysisService;
import com.interview.service.storage.StorageService;
import com.interview.service.summary.SummarizationService;
import com.interview.service.transcription.TranscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {
    @Autowired
    private  StorageService s3Service;
    @Autowired
    private TranscriptionService transcriptionService;
    @Autowired
    private SentimentService sentimentService;
    @Autowired
    private SummarizationService summarizationService;
    @Autowired
    private ToneAnalysisService toneService;
    @Autowired
    private PredictiveModelService predictiveService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        return s3Service.uploadFile(file);
    }

    @PostMapping("/process")
    public Map<String, String> processInterview(@RequestParam("gcsUri") String gcsUri) throws Exception {
        String transcript = transcriptionService.transcribeAudio(gcsUri);
        String summary = summarizationService.summarizeText(transcript);
        String sentiment = sentimentService.analyzeSentiment(transcript);
        String tone = toneService.analyzeTone(transcript).toString();
        String prediction = predictiveService.predictOutcome(transcript);

        Map<String, String> response = new HashMap<>();
        response.put("transcript", transcript);
        response.put("summary", summary);
        response.put("sentiment", sentiment);
        response.put("tone", tone);
        response.put("prediction", prediction);

        return response;
    }
    @GetMapping("/test")
    public String testApi() {
        return "Welcome To Interview Analysis";
    }
}
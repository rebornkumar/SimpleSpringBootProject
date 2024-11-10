package com.interview.service.analysis.sentiment;

import com.amazonaws.services.comprehend.AmazonComprehend;
import com.amazonaws.services.comprehend.model.*;
import org.springframework.stereotype.Service;

@Service
public class SentimentService {
    private final AmazonComprehend comprehendClient;

    public SentimentService(AmazonComprehend comprehendClient) {
        this.comprehendClient = comprehendClient;
    }

    public String analyzeSentiment(String text) {
        DetectSentimentRequest request = new DetectSentimentRequest()
                .withText(text)
                .withLanguageCode("en");
        DetectSentimentResult result = comprehendClient.detectSentiment(request);
        return result.getSentiment();
    }
}

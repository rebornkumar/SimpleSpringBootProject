package com.interview.service.config;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.tone_analyzer.v3.ToneAnalyzer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WatsonConfig {

    @Bean
    public ToneAnalyzer toneAnalyzer() {
        // Replace with your IBM Watson API key and service URL
        IamAuthenticator authenticator = new IamAuthenticator("YOUR_API_KEY");

        ToneAnalyzer toneAnalyzer = new ToneAnalyzer("2017-09-21", authenticator);
        toneAnalyzer.setServiceUrl("YOUR_SERVICE_URL");

        return toneAnalyzer;
    }
}

package com.interview.service.analysis.tone;

import com.ibm.watson.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.tone_analyzer.v3.model.ToneInput;
import com.ibm.watson.tone_analyzer.v3.model.ToneOptions;
import com.ibm.watson.tone_analyzer.v3.model.ToneAnalysis;
import org.springframework.stereotype.Service;

@Service
public class ToneAnalysisService {
    private final ToneAnalyzer toneAnalyzer;

    public ToneAnalysisService(ToneAnalyzer toneAnalyzer) {
        this.toneAnalyzer = toneAnalyzer;
    }

    public ToneAnalysis analyzeTone(String text) {
        ToneInput toneInput = new ToneInput.Builder().text(text).build();
        ToneOptions options = new ToneOptions.Builder().toneInput(toneInput).build();
        return toneAnalyzer.tone(options).execute().getResult();
    }
}

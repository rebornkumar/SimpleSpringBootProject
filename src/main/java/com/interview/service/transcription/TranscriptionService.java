package com.interview.service.transcription;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.speech.v1.*;

import com.google.cloud.speech.v1.*;
import org.springframework.stereotype.Service;

@Service
public class TranscriptionService {
    public String transcribeAudio(String gcsUri) throws Exception {
        try (SpeechClient speechClient = SpeechClient.create()) {
            RecognitionConfig config = RecognitionConfig.newBuilder()
                    .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
                    .setLanguageCode("en-US")
                    .setSampleRateHertz(16000)
                    .build();
            RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(gcsUri).build();
            OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata> response =
                    speechClient.longRunningRecognizeAsync(config, audio);
            return response.get().getResultsList().get(0).getAlternativesList().get(0).getTranscript();
        }
    }
}

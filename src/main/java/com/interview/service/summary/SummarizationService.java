package com.interview.service.summary;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.stereotype.Service;

@Service
public class SummarizationService {
    private final OpenAiService openAiService;

    public SummarizationService(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    public String summarizeText(String text) {
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt("Summarize the following interview transcript: " + text)
                .maxTokens(150)
                .build();
        return openAiService.createCompletion(completionRequest).getChoices().get(0).getText();
    }
    public String generateText(String prompt) {
        CompletionRequest request = CompletionRequest.builder()
                .prompt(prompt)
                .model("text-davinci-003") // Specify the model, e.g., "gpt-3.5-turbo"
                .maxTokens(100)
                .build();

        CompletionResult result = openAiService.createCompletion(request);
        return result.getChoices().get(0).getText().trim();
    }
}

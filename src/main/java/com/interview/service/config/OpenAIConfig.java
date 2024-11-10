package com.interview.service.config;

import com.theokanning.openai.service.OpenAiService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAIConfig {

    @Bean
    public OpenAiService openAiService() {
        // Replace "YOUR_OPENAI_API_KEY" with your actual OpenAI API key
        return new OpenAiService("YOUR_OPENAI_API_KEY");
    }
}

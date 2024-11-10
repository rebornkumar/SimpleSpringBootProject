package com.interview.service.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.comprehend.AmazonComprehend;
import com.amazonaws.services.comprehend.AmazonComprehendClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonComprehendConfig {

    @Bean
    public AmazonComprehend amazonComprehend() {
        // Replace with your actual AWS credentials and region
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials("YOUR_ACCESS_KEY", "YOUR_SECRET_KEY");

        return AmazonComprehendClientBuilder.standard()
                .withRegion("us-west-2") // Replace with your AWS region
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }
}

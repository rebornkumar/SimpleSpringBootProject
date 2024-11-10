package com.interview.service.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonS3Config {

    @Bean
    public AmazonS3 amazonS3() {
        // Replace with your actual AWS credentials and region
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials("YOUR_ACCESS_KEY", "YOUR_SECRET_KEY");

        return AmazonS3ClientBuilder.standard()
                .withRegion("us-west-2") // Replace with your AWS region
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }
}

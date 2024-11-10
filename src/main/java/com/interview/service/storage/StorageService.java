package com.interview.service.storage;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {
    private final AmazonS3 s3Client;

    public StorageService(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }

    public String uploadFile(MultipartFile file) {
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        try {
            s3Client.putObject(new PutObjectRequest("interview-recordings", fileName, file.getInputStream(), new ObjectMetadata()));
            return s3Client.getUrl("interview-recordings", fileName).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

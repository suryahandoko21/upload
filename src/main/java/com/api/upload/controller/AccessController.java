package com.api.upload.controller;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.upload.service.KafkaProducer;

@RestController
@RequestMapping("/api/access")
public class AccessController {
    
    @Autowired
    private  KafkaProducer kafkaProducer;  
    @GetMapping("/public")
    public String allAccess() {
        return "All public can access this page";
    }
    
    @PostMapping("/upload")
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try{
            String fileContent = new String(file.getBytes(), StandardCharsets.UTF_8);
            kafkaProducer.sendMessage("uploadFile", fileContent);
            return ResponseEntity.ok("File berhasil diunggah dan dikirim ke Kafka.");
        }
       catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Gagal mengunggah file.");
        }
        
    }
}

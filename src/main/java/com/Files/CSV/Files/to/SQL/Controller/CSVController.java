package com.Files.CSV.Files.to.SQL.Controller;

import com.Files.CSV.Files.to.SQL.Entity.Usermodel;
import com.Files.CSV.Files.to.SQL.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class CSVController {
    @Autowired
    private UserService userService;  // Assuming UserService is your service class

    @PostMapping("/upload-csv")
    public ResponseEntity<String> uploadCsv(@RequestParam("file") MultipartFile file) {
        try {
            userService.saveDataFromCsv(file);
            return ResponseEntity.ok("CSV file uploaded and data saved successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while processing the CSV file.");
        }
}
}

package com.Files.CSV.Files.to.SQL.Controller;

import com.Files.CSV.Files.to.SQL.Entity.Usermodel;
import com.Files.CSV.Files.to.SQL.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CSVController {
    @Autowired
    private UserService userService;

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
    @GetMapping("/get-all-users")
    public ResponseEntity<List<Usermodel>> getAllUsers() {
        List<Usermodel> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}

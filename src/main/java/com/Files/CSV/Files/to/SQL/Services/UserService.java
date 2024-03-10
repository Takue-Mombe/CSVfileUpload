package com.Files.CSV.Files.to.SQL.Services;

import au.com.bytecode.opencsv.CSVReader;
import com.Files.CSV.Files.to.SQL.Entity.Usermodel;
import com.Files.CSV.Files.to.SQL.Repositories.JPArepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private JPArepo jpArepo;

    public void saveDataFromCsv(MultipartFile file) throws IOException {
        try (Reader reader = new InputStreamReader(file.getInputStream())) {
            CSVReader csvReader = new CSVReader(reader);
            String[] nextRecord;

            while ((nextRecord = csvReader.readNext()) != null) {
                // Assuming that the first column contains the username and the second column contains the email
                String username = nextRecord[0];
                String password = nextRecord[1];

                // Create a Usermodel entity and set the data
                Usermodel user = new Usermodel();
                user.setHitmail(username);
                user.setPassword(password);

                // Save the user to the database using the JpaRepository's save method
                jpArepo.save(user);
            }
        }
    }
    public List<Usermodel> getAllUsers() {
        return jpArepo.findAll();
    }
}

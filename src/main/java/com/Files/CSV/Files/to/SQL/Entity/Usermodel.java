package com.Files.CSV.Files.to.SQL.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Getter
@Entity(name = "postgres")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Component
@Table(name = "users")
public class Usermodel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String hitmail;
    private String password;


}

package com.Files.CSV.Files.to.SQL.Repositories;

import com.Files.CSV.Files.to.SQL.Entity.Usermodel;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPArepo extends JpaRepository<Usermodel, Id> {
}

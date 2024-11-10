package com.telusko.repository;

import com.telusko.entity.Schools;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolsRepo extends JpaRepository<Schools, Long> {
}

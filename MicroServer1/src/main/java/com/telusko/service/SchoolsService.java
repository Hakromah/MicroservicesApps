package com.telusko.service;

import com.telusko.entity.Schools;
import com.telusko.repository.SchoolsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolsService {

    @Autowired
    private SchoolsRepo repo;

    public String registerSchool(Schools schools) {
        repo.save(schools);
        return "School registered successfully";
    }

    public List<Schools> findAllSchools() {
        return repo.findAll();
    }

    public Schools getSchoolById(Long id) {
        Optional<Schools> optional = repo.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("School not found for id - " + id);
        }
    }

    public String deleteSchoolById(Long id) {
        repo.deleteById(id);
        return "School deleted successfully";
    }

    public Schools updateSchool(Long id, Schools schools) {
        schools.setId(id);
        schools.setName(schools.getName());
        schools.setAddress(schools.getAddress());
        return repo.save(schools);
    }

}

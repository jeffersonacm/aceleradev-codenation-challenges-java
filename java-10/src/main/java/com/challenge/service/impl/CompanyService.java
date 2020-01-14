package com.challenge.service.impl;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.interfaces.CompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompanyService implements CompanyServiceInterface {

    @Autowired
    private CompanyRepository companyRepository;

    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    public List<Company> findByAccelerationId(Long accelerationId) {
        return companyRepository.findByAccelerationId(accelerationId);
    }

    public List<Company> findByUserId(Long userId) {
        return companyRepository.findByUserId(userId);
    }

    @Override
    public Company save(Company object) {
        object.setCreatedAt(LocalDateTime.now());
        return companyRepository.save(object);
    }
}

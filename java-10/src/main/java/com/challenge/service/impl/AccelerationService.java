package com.challenge.service.impl;

import com.challenge.entity.Acceleration;
import com.challenge.repository.AccelerationRepository;
import com.challenge.service.interfaces.AccelerationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccelerationService implements AccelerationServiceInterface {

    @Autowired
    private AccelerationRepository accelerationRepository;

    public Optional<Acceleration> findById(Long id) {
        return accelerationRepository.findById(id);
    }

    public List<Acceleration> findByCompanyId(Long companyId) {
        return accelerationRepository.findByCompanyId(companyId);
    }

    @Override
    public Acceleration save(Acceleration object) {
        object.setCreatedAt(LocalDateTime.now());
        return accelerationRepository.save(object);
    }
}

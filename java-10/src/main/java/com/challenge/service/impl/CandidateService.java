package com.challenge.service.impl;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.repository.CandidateRepository;
import com.challenge.service.interfaces.CandidateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CandidateService implements CandidateServiceInterface {

    @Autowired
    private CandidateRepository candidateRepository;

    public Optional<Candidate> findById(CandidateId id) {
        return candidateRepository.findByIdUserIdCompanyIdAcceleration(id.getUser().getId(),
                id.getCompany().getId(),
                id.getAcceleration().getId());
    }

    public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
        return candidateRepository.findByIdUserIdCompanyIdAcceleration(userId, companyId, accelerationId);
    }

    public List<Candidate> findByCompanyId(Long companyId) {
        return candidateRepository.findByIdCompany(companyId);
    }

    public List<Candidate> findByAccelerationId(Long accelerationId) {
        return candidateRepository.findById_Acceleration(accelerationId);
    }

    @Override
    public Candidate save(Candidate object) {
        object.setCreatedAt(LocalDateTime.now());
        return candidateRepository.save(object);
    }
}

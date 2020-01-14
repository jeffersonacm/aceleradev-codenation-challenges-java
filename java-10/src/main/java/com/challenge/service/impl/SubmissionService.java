package com.challenge.service.impl;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class SubmissionService implements SubmissionServiceInterface {

    @Autowired
    private SubmissionRepository submissionRepository;

    public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
        return submissionRepository.findMaxScoreByChallengeId(challengeId);
    }

    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        return submissionRepository.findByChallangeIdAndAccelerationId(challengeId, accelerationId);
    }

    @Override
    public Submission save(Submission object) {
        object.setCreatedAt(LocalDateTime.now());
        return submissionRepository.save(object);
    }
}

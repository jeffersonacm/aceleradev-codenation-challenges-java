package com.challenge.service.impl;

import com.challenge.entity.Challenge;
import com.challenge.repository.ChallengeRepository;
import com.challenge.service.interfaces.ChallengeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ChallengeService implements ChallengeServiceInterface {

    @Autowired
    private ChallengeRepository challengeRepository;

    public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
        return challengeRepository.findByAccelerationsIdAndSubmissionsIdUserId(accelerationId, userId);
    }

    @Override
    public Challenge save(Challenge object) {
        object.setCreatedAt(LocalDateTime.now());
        return challengeRepository.save(object);
    }
}

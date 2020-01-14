package com.challenge.service.impl;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import com.challenge.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    public List<User> findByAccelerationName(String name) {
        return userRepository.findUserByAccelerationName(name);
    }

    public List<User> findByCompanyId(Long companyId) {
        return userRepository.findUsersByCompanyID(companyId);
    }

    @Override
    public User save(User object) {
        object.setCreatedAt(LocalDateTime.now());
        return userRepository.save(object);
    }
}

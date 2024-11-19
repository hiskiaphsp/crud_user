package com.app.cruduser.service.impl;

import com.app.cruduser.model.User;
import com.app.cruduser.repository.UserRepository;
import com.app.cruduser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveOrUpdateUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public List<User> searchUsers(String nik, String name, String gender, String address, String nationality) {
        return userRepository.findByAllFields(
                nik != null ? nik : "",
                name != null ? name : "",
                gender != null ? gender : "",
                address != null ? address : "",
                nationality != null ? nationality : ""
        );
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}

package com.app.cruduser.service;

import com.app.cruduser.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveOrUpdateUser(User user);

    List<User> searchUsers(String nik, String name, String gender, String address, String nationality);

    void deleteUser(Long id);

    Optional<User> findById(Long id);

    List<User> findAllUsers();
}

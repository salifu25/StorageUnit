package com.groupsix.documentarchive.Service;

import com.groupsix.documentarchive.Model.User;

import java.util.Optional;

public interface UserService {

    User addUser(User user);

    Optional<User> findUserById(Long id);
}

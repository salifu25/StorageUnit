package com.groupsix.documentarchive.Service;

import com.groupsix.documentarchive.Model.User;
import com.groupsix.documentarchive.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService{

    @Autowired
    UserRepository userRepository;

    private  final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User addUser(User user) {
        String EncodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(EncodedPassword);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }
}

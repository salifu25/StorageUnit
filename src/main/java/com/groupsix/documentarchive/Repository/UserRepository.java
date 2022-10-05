package com.groupsix.documentarchive.Repository;

import com.groupsix.documentarchive.Model.User;
import com.groupsix.documentarchive.SecurityConfig.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<CustomUser> findByUsername(String username);
}

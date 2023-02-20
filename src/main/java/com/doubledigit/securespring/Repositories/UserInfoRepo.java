package com.doubledigit.securespring.Repositories;

import com.doubledigit.securespring.Models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepo extends JpaRepository<UserInfo, Integer> {
    Optional<UserInfo> findByName(String username);
}

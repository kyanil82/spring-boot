package com.aky.sb_multithreading.repository;

import com.aky.sb_multithreading.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}

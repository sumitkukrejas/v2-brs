package com.brs.repository;

import com.brs.entity.Users1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsersRepository extends JpaRepository<Users1, Integer> {
    Optional<Users1>findByUserName(String userName);
}

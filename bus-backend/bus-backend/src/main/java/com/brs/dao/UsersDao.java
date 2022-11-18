package com.brs.dao;

import com.brs.entity.Users1;
import org.springframework.data.jpa.repository.JpaRepository;

import com.brs.entity.Users;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsersDao extends JpaRepository<Users, Integer>{
    Optional<Users> findByUserName(String userName);



}

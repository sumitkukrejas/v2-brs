package com.brs.repository;

import com.brs.entity.Users;
import com.brs.exceptions.UserNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IUsersRepository extends JpaRepository<Users, String> {

    Optional<Users>findByUserName(String userName) throws UserNotFoundException;

}

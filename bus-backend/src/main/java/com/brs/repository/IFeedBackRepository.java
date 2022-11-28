package com.brs.repository;

import com.brs.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFeedBackRepository extends JpaRepository<Feedback , Integer> {

}

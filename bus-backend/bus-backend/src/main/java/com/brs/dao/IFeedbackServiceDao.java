package com.brs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brs.entity.Feedback;

public interface IFeedbackServiceDao extends JpaRepository<Feedback, Integer> {

}

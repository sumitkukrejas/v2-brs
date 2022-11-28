package com.brs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brs.entity.Route;
import org.springframework.stereotype.Repository;

@Repository
public interface IRouteRepository extends JpaRepository<Route, Integer>{

}

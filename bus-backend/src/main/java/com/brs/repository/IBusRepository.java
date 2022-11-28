package com.brs.repository;

import com.brs.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface IBusRepository extends JpaRepository<Bus, Integer> {
    @Query(" SELECT b FROM Bus b WHERE b.routeFrom =?1 and b.routeTo =?2 and  b.departureDate =?3")
    List<Bus> searchBus(String from , String to , LocalDate departureDate);
}

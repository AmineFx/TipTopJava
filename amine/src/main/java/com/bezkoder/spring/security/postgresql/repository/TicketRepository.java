package com.bezkoder.spring.security.postgresql.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.spring.security.postgresql.models.ERole;
import com.bezkoder.spring.security.postgresql.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.bezkoder.spring.security.postgresql.models.Ticket;
import com.bezkoder.spring.security.postgresql.payload.response.TicketStatsResponse;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
  Optional<Ticket> findByNumber(String name);
  
  @Query("SELECT NEW com.bezkoder.spring.security.postgresql.payload.response.TicketStatsResponse(" +
          "SUM(CASE WHEN t.utilise = true THEN 1 ELSE 0 END), " +
          "SUM(CASE WHEN t.utilise = false THEN 1 ELSE 0 END)) " +
          "FROM Ticket t")
   TicketStatsResponse getTicketStats();
}

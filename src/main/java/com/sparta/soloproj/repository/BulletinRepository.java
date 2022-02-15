package com.sparta.soloproj.repository;

import com.sparta.soloproj.model.Bulletin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BulletinRepository extends JpaRepository<Bulletin, Long> {
    List<Bulletin> findAllById(Long id);
}

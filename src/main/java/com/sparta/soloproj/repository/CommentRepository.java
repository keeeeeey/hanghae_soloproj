package com.sparta.soloproj.repository;

import com.sparta.soloproj.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBulletinId(Long bulletinId);
}

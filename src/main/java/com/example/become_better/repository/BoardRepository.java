package com.example.become_better.repository;

import com.example.become_better.model.Board;
import com.example.become_better.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    List<Board> findAllByUserId(int id);
}

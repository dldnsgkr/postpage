package com.example.safekorea.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.safekorea.domain.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

	List<Board> findByTitleContaining(String keyword);

}

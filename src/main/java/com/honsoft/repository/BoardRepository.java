package com.honsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honsoft.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

}

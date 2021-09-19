package com.honsoft.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.honsoft.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

	 @Query("Select s from  boards s ")
	    Page<Board> findBySomethingElseId(Pageable pageable);
	 
}

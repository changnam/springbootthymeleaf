package com.honsoft.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.honsoft.domain.BoardVo;

public interface BoardService {
	Page<BoardVo> getAllBoards(Pageable pageable);
}

package com.honsoft.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honsoft.domain.BoardVo;
import com.honsoft.entity.Board;
import com.honsoft.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardRepository boardRepository;

	@Override
	public List<BoardVo> getAllBoards() {
		List<Board> list = boardRepository.findAll();
		List<BoardVo> voList = new ArrayList<BoardVo>();
		for (Board board : list) {
			BoardVo boardVo = new BoardVo();
			boardVo.setId(board.getId());
			boardVo.setTitle(board.getTitle());
			voList.add(boardVo);
		}
		
		return voList;
	}
	
	
}

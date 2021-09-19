package com.honsoft.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.honsoft.domain.BoardVo;
import com.honsoft.entity.Board;
import com.honsoft.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardRepository boardRepository;

	@Override
	public Page<BoardVo> getAllBoards(Pageable pageable) {
		int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
		// pageable = PageRequest.of(page, 10, new Sort(Sort.Direction.DESC, "id")); //
		// <- Sort 추가
		Page<Board> list = boardRepository.findAll(pageable);
		Page<BoardVo> voList = list.map(entity -> {
			BoardVo vo = boardToBoardVo(entity);
			return vo;
		});

		return voList;
	}

	private BoardVo boardToBoardVo(Board entity) {
		BoardVo boardVo = new BoardVo();
		boardVo.setId(entity.getId());
		boardVo.setTitle(entity.getTitle());
		return boardVo;
	}
	
	 @Transactional(readOnly=true)
	    public BoardVo getSomething(long somethingElseId, int page, int size){
	         Page<BoardVo> somethings = somethingRepository.findBySomethingElseId(new PageResult(page, size));

	        return new BoardVo(somethings.getContent()
	                .stream()
	                .map(BoardVo::createDto)
	                .sorted(comparing(SomethingDto::getDatum))
	                .collect(toList()), somethings.getTotalElements(), somethings.getTotalPages();
	    }
	 

}

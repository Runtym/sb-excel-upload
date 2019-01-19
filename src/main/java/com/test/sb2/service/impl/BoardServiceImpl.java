package com.test.sb2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.sb2.repository.BoardRepository;
import com.test.sb2.service.BoardService;
import com.test.sb2.vo.Board;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardRepository br;
	
	@Override
	public List<Board> selectBoardList() {
		return br.selectBoardList();
	}

	@Override
	public Board selectBoard(Board b) {
		return br.selectBoard(b);
	}

	@Override
	public int insertBoard(Board b) {
		return br.insertBoard(b);
	}

	@Override
	public int updateBoard(Board b) {
		return br.updateBoard(b);
	}

	@Override
	public int deleteBoard(Board b) {
		return br.deleteBoard(b);
	}
	
	
}

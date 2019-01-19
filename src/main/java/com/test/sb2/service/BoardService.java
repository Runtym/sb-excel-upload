package com.test.sb2.service;

import java.util.List;

import com.test.sb2.vo.Board;

public interface BoardService {
	public List<Board> selectBoardList();
	public Board selectBoard(Board b);
	public int insertBoard(Board b);
	public int updateBoard(Board b);
	public int deleteBoard(Board b);
}

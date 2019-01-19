package com.test.sb2.repository;

import java.util.List;

import com.test.sb2.vo.Board;

public interface BoardRepository {
	public List<Board> selectBoardList();
	public Board selectBoard(Board b);
	public int insertBoard(Board b);
	public int updateBoard(Board b);
	public int deleteBoard(Board b);
}

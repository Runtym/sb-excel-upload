package com.test.sb2.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.sb2.repository.BoardRepository;
import com.test.sb2.vo.Board;

@Repository
public class BoardRepositoryImpl implements BoardRepository{

	@Autowired
	private SqlSession ss;
	
	@Override
	public List<Board> selectBoardList() {
		return ss.selectList("com.test.sb2.Board.selectBoardList");
	}

	@Override
	public Board selectBoard(Board b) {
		return ss.selectOne("com.test.sb2.Board.selectBoard",b);
	}

	@Override
	public int insertBoard(Board b) {
		return ss.insert("com.test.sb2.Board.insertBoard",b);
	}

	@Override
	public int updateBoard(Board b) {
		return ss.insert("com.test.sb2.Board.updateBoard",b);
	}

	@Override
	public int deleteBoard(Board b) {
		return ss.insert("com.test.sb2.Board.deleteBoard",b);
	}
	
	
}

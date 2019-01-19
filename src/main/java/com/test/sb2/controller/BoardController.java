package com.test.sb2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.sb2.service.BoardService;
import com.test.sb2.vo.Board;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService bs;
	
	@GetMapping("/list")
	public String board(Model m){
		m.addAttribute("boardList",bs.selectBoardList());
		return "board/list";
	}

	@GetMapping
	public @ResponseBody Board board(Board b){
		return bs.selectBoard(b);
	} 
	@PostMapping
	public @ResponseBody int insertBoard(@RequestBody Board b) {
		return bs.insertBoard(b);
	}
	@PutMapping
	public @ResponseBody int updateBoard(@RequestBody Board b) {
		return bs.updateBoard(b);
	}
	@DeleteMapping
	public @ResponseBody int deleteBoard(@RequestBody Board b) {
		return bs.deleteBoard(b);
	}
}

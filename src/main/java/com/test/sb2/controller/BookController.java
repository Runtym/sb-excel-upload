package com.test.sb2.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.test.sb2.service.BookService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BookController {
	@Autowired
	ServletContext context; 
	@Autowired 
	private BookService bs;
	
	private String getExt(String fileName) {
		int idx = fileName.lastIndexOf(".");
		return fileName.substring(idx);
	}
	@PostMapping("/excel")
	public int uploadExcel(@RequestParam("file") MultipartFile mf) throws IllegalStateException, IOException {
		
		String fileName = mf.getOriginalFilename();
		String ext = getExt(fileName);
		String path = context.getRealPath("/excel");
		log.info("fileName=>{}, ext=>{}, path=>{}",fileName, ext,path);
		File saveFile = new File(path + "/" + fileName);
		mf.transferTo(saveFile);
		List<Map<String, Object>> bookList;
		try {
			bookList = bs.getBookListFromExcel(saveFile);
			return bs.insertBookList(bookList);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
}

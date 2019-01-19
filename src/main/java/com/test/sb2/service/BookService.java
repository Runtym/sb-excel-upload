package com.test.sb2.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public interface BookService {
	public int insertBookList(List<Map<String,Object>> bookList);
	public List<Map<String,Object>> getBookListFromExcel(File file) throws InvalidFormatException, IOException;
}

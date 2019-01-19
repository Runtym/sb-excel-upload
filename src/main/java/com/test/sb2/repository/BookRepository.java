package com.test.sb2.repository;

import java.util.List;
import java.util.Map;

public interface BookRepository {
	public int insertBookList(List<Map<String,Object>> bookList);
	public void insertBookList2(List<Map<String,Object>> bookList);
}

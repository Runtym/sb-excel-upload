package com.test.sb2.repository.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.test.sb2.repository.BookRepository;

@Repository
public class BookRepositoryImpl implements BookRepository {


	@Autowired
	private SqlSession ss;
	@Autowired
	private DataSourceTransactionManager tran;
	
	@Override
	public int insertBookList(List<Map<String, Object>> bookList) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("test");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus st = tran.getTransaction(def);
		int cnt = 0;
		for(int i=0;i<bookList.size();i++) {
			Map<String,Object>book = bookList.get(i);
			cnt += ss.insert("com.test.sb2.Book.insertBook",book);
		}
		tran.commit(st);
		return cnt;
	}

	@Override
	public void insertBookList2(List<Map<String, Object>> bookList) {
	}
}

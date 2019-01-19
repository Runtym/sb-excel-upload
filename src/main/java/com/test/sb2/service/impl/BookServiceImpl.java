package com.test.sb2.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.sb2.repository.BookRepository;
import com.test.sb2.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository br;
	
	@Override
	public int insertBookList(List<Map<String, Object>> bookList) {
		// TODO Auto-generated method stub
		return br.insertBookList(bookList);
	}
	
	public List<Map<String,Object>> getBookListFromExcel(File file) throws InvalidFormatException, IOException{

		XSSFWorkbook xssfw = new XSSFWorkbook(file);

		List<String> keyList = new ArrayList<>();
		List<Map<String,Object>> bookList = new ArrayList<>();
		XSSFSheet firstSheet = xssfw.getSheetAt(0);
		int rows = firstSheet.getPhysicalNumberOfRows();
		
		for(int i=1;i<=rows;i++) {
			XSSFRow row = firstSheet.getRow(i);
			if(row!=null) {
				int cells = row.getPhysicalNumberOfCells();
				Map<String,Object> cellMap = new HashMap<>();
				for(int j=0;j<=cells;j++) {
					XSSFCell cell = row.getCell(j);
					if(cell==null) continue;
					
					if(i==1) {
						keyList.add(cell.getStringCellValue());
					}else {
						if(cell.getCellTypeEnum()==CellType.NUMERIC) {
							cellMap.put(keyList.get(j-1), cell.getNumericCellValue());
						}else if(cell.getCellTypeEnum()==CellType.STRING) {
							cellMap.put(keyList.get(j-1), cell.getStringCellValue());
						}else if(cell.getCellTypeEnum()==CellType.FORMULA) {
							cellMap.put(keyList.get(j-1), cell.getCellFormula());
						}
					}
				}
				if(cellMap.size()!=0) {
					bookList.add(cellMap);
				}
			}
		}
		return bookList;
	}

}

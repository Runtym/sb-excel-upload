package com.test.sb2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.sb2.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ExcelTest {

	String path = "D:\\study\\workspace\\test\\src\\main\\resources\\book-list.xlsx";
	FileInputStream fis; 
	XSSFWorkbook xssfw;
	List<String> keyList = new ArrayList<>();
	List<Map<String,Object>> bookList = new ArrayList<>();
	@Autowired
	private BookRepository br;
	
	@Before
	public void before() throws IOException {
		fis = new FileInputStream(path);
		xssfw = new XSSFWorkbook(fis);
	}
	@Test
	public void test() {
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
		log.info("bookList=>{}",bookList);
		assertEquals(20432, bookList.size());
		br.insertBookList(bookList);
	}

}

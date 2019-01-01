package com.nt.test;


import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class CalcTest {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(CalcAppTest.class);
		Workbook wb = null;
		FileOutputStream out = null;
		Sheet sheet = null;
		Sheet sheet1 = null;
		Row row = null;
		List<Failure> failList = null;
		int i = 0;
		int j = 0;

		wb = new HSSFWorkbook();
		sheet = wb.createSheet("Test Report");
		
		row = sheet.createRow(i++);
		row.createCell(0).setCellValue("Run Time : ");
		row.createCell(1).setCellValue(LocalDateTime.now().toString());
		
		row = sheet.createRow(i++);
		row.createCell(0).setCellValue("Total Case : ");
		row.createCell(1).setCellValue(result.getRunCount());
		
		row = sheet.createRow(i++);
		row.createCell(0).setCellValue("Ignore Case : ");
		row.createCell(1).setCellValue(result.getIgnoreCount());
		
		row = sheet.createRow(i++);
		row.createCell(0).setCellValue("Failure Case : ");
		row.createCell(1).setCellValue(result.getFailureCount());
		i = 0;
		sheet1 = wb.createSheet("Failure Sheet");
		row = sheet1.createRow(i++);
		row.createCell(j++).setCellValue("Failure Reason : ");
		failList = result.getFailures();
		for(Failure fail:failList) {
			row.createCell(j++).setCellValue(fail.getMessage());
		}
		try {
			 out = new FileOutputStream(new File("TestReport.xlsx"));
       			  wb.write(out);
       			  out.close();
       			  wb.close();
       			  System.out.println("TestReport.xlsx written successfully on disk.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

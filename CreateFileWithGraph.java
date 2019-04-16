package com.howtodoinjava.demo.poi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

//import statements
public class CreateFileWithGraph {
	public static void main(String[] args) {
		// Blank wb
		XSSFWorkbook wb = new XSSFWorkbook();

		// Create a blank sheet
		XSSFSheet sheet = wb.createSheet("Employee Data");

		// This data needs to be written (Object[])
		Map<Integer, Object[]> data = new TreeMap<Integer, Object[]>();
		data.put(1, new Object[] { 40, "NAME", "LASTNAME" });
		data.put(2, new Object[] { 61, "Amit", "Shukla" });
		data.put(3, new Object[] { 82, "Lokesh", "Gupta" });
		data.put(4, new Object[] { 53, "John", "Adwards" });
		data.put(5, new Object[] { 74, "Brian", "Schultz" });

		// Iterate over data and write to sheet
		Set<Integer> keyset = data.keySet();
		int rownum = 0;
		for (Integer key : keyset) {
			XSSFRow row = sheet.createRow(rownum++);
			Object[] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				XSSFCell cell = row.createCell(cellnum++);
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}

		try {
			createGraph(wb, data);
			InputStream is = new FileInputStream("/home/ist/chart.jpg");
		    byte [] bytes = IOUtils.toByteArray(is); 
		    int pictureIndex = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
		    is.close();

		    CreationHelper helper = wb.getCreationHelper();
		    Drawing drawingPatriarch = sheet.createDrawingPatriarch();
		    ClientAnchor anchor = helper.createClientAnchor();

		    anchor.setCol1(0);
		    anchor.setRow1(6);
		    Picture pict = drawingPatriarch.createPicture(anchor, pictureIndex);
		    pict.resize();

			// Write the wb in file system
			FileOutputStream out = new FileOutputStream(new File("/home/ist/testxslxgraphjava_demo.xlsx"));
			wb.write(out);
			out.close();
			System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createGraph(Workbook wb, Map map) {
		JFreeChart chart = null;
		DefaultCategoryDataset dataset = null;
		Sheet sheet = wb.getSheetAt(0);
		ByteArrayOutputStream chart_out = null;
		dataset = new DefaultCategoryDataset();
		// set = map.keySet();
		Collection<Object[]> set = map.values();
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		for (Object[] arr : set) {
			dataset.setValue((Integer) arr[0], arr[1].toString(), arr[2].toString());
			// dataset.setValue(value, rowKey, columnKey);
		}
		chart = ChartFactory.createBarChart("Mark Graph ", "Subject", "Marks", dataset, PlotOrientation.VERTICAL, false,
				true, false);
		try {
			ChartUtils.saveChartAsJPEG(new File("/home/ist/chart.jpg"), chart, 300, 200);
		} catch (IOException e) {
			System.out.println("Problem in creating chart.");
		}
	}
}
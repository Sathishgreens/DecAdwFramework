package org.mavendemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	public static void main(String[] args) throws IOException {

		File file = new File("C:\\Users\\Lenovo\\eclipse-workspace\\"
				+ "DecAdvFramework\\src\\test\\resources\\Excel Files\\Data - Copy.xlsx");
		FileInputStream inputStream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(inputStream);

		// Create a sheet
		Sheet createSheet = workbook.createSheet("New Sheet");

		// create a row
		Row createRow = createSheet.createRow(0);

		// create a cell
		Cell createCell = createRow.createCell(0);

		// Set the data in cell
		createCell.setCellValue("Sathish");

		// to write in a file
		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
	}
}

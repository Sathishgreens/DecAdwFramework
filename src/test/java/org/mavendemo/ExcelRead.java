package org.mavendemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Lenovo\\eclipse-workspace\\"
				+ "DecAdvFramework\\src\\test\\resources\\Excel Files\\Data.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		// access the Workbook
		Workbook workbook = new XSSFWorkbook(inputStream);
		// access a sheet
		Sheet sheet = workbook.getSheet("Sheet3");
		// Sheet sheet2 = workbook.getSheet("Adactin Login Data");
		// to get the access of a row in the sheet
		int numberOfRows = sheet.getPhysicalNumberOfRows();// 5
		for (int i = 0; i < numberOfRows; i++) {
			Row row = sheet.getRow(i);
			int numberOfCells = row.getPhysicalNumberOfCells();
			// to get the access of a cell in a row
			for (int j = 0; j < numberOfCells; j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();

				switch (cellType) {
				case STRING:
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);
					break;
				case NUMERIC:
					boolean dateFormatted = DateUtil.isCellDateFormatted(cell);
					if (dateFormatted) {
						Date date = cell.getDateCellValue();
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
						String format = dateFormat.format(date);
						System.out.println(format);
					} else {
						double numericCellValue = cell.getNumericCellValue();//98.990  99
						long l = Math.round(numericCellValue);
						if (numericCellValue == l) {
							System.out.println(l);
						} else {
							System.out.println(numericCellValue);
						}
					}
					break;
				case BOOLEAN:
					boolean booleanCellValue = cell.getBooleanCellValue();
					System.out.println(booleanCellValue);
				default:
					break;
				}

			}
		}

	}
}

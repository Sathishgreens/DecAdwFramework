package org.mavendemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

public class ExcelReadAndWrite {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Lenovo\\eclipse-workspace\\"
				+ "DecAdvFramework\\src\\test\\resources\\Excel Files\\Data.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		// access the Workbook
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet existingSheet = workbook.getSheet("Sheet3");
		Sheet newSheet = workbook.createSheet("New Sheet");
		for (int i = 0; i < existingSheet.getPhysicalNumberOfRows(); i++) {
			Row existingRow = existingSheet.getRow(i);
			Row newRow = newSheet.createRow(i);
			for (int j = 0; j < existingRow.getPhysicalNumberOfCells(); j++) {
				Cell cell = existingRow.getCell(j);
				CellType cellType = cell.getCellType();
				Cell newCell = newRow.createCell(j);
				switch (cellType) {
				case STRING:
					String stringCellValue = cell.getStringCellValue();
					newCell.setCellValue(stringCellValue);
					break;
				case NUMERIC:
					boolean dateFormatted = DateUtil.isCellDateFormatted(cell);
					if (dateFormatted) {
						Date date = cell.getDateCellValue();
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
						String format = dateFormat.format(date);
						newCell.setCellValue(format);
					} else {
						double numericCellValue = cell.getNumericCellValue();
						long l = Math.round(numericCellValue);
						if (numericCellValue == l) {
							newCell.setCellValue(l);
						} else {
							newCell.setCellValue(numericCellValue);
						}
					}
					break;
				case BOOLEAN:
					boolean booleanCellValue = cell.getBooleanCellValue();
					newCell.setCellValue(booleanCellValue);
				default:
					break;
				}
			}
		}
		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
	}
}

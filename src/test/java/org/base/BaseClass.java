package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver;
	
	public static void browserLaunch(String browser) {
		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			 driver = new EdgeDriver();
			break;
		case "firefox":
			 driver = new FirefoxDriver();
			break;

		default:
			throw new IllegalArgumentException();
		}		
	}
	
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public static void loadUrl(String url) {
		driver.get(url);
	}
	
	public static WebElement findingWebElement(String locator,String value) {		//id
		
		WebElement element = null;
		if(locator.equals("id")) {
			element = driver.findElement(By.id(value));
		} else if(locator.equals("name")) {
			element = driver.findElement(By.name(value));
		}
		
		return element;
	}
	
	public static String gettingElementText(WebElement ele) {
		String text = ele.getText();
		return text;
	}
	
	public static void passValues(WebElement ele,String value) {
		ele.sendKeys(value);
	}
	
	public static String excelRead(String path,String sheetName,int rowNum,int cellNum) throws IOException {
		File file = new File(path);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		CellType cellType = cell.getCellType();
		String data = null;
		switch (cellType) {
		case STRING:
			String stringCellValue = cell.getStringCellValue();
			data = stringCellValue;
			break;
		case NUMERIC:
			boolean dateFormatted = DateUtil.isCellDateFormatted(cell);
			if (dateFormatted) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
				String format = dateFormat.format(date);
				data = format;
			} else {
				double numericCellValue = cell.getNumericCellValue();//98.990  99
				long l = Math.round(numericCellValue);
				if (numericCellValue == l) {
					String string = Long.toString(l);
					data = string;
				} else {
					data = Double.toString(numericCellValue);
				}
			}
			break;
		case BOOLEAN:
			boolean booleanCellValue = cell.getBooleanCellValue();
			data = Boolean.toString(booleanCellValue);
		default:
			break;
		}

		
		return data;
	}
	
	public static void elementClick(WebElement ele) {
		ele.click();
	}
	
	public static void navigateBack() {
		driver.navigate().back();
	}
	
	public static void refreshPage() {
		driver.navigate().refresh();
	}
	
	public static void quitBrowser() {
		driver.quit();
	}
	
	public static void setImplicitWaits(long seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	public static String getAttributeValue(WebElement ele,String attributeName) {
		return ele.getAttribute(attributeName);
	}
	
	public static void dropDown(WebElement ele , String byMethod,String value) {
		
		Select select = new Select(ele);
		switch (byMethod) {
		case "value":
			select.selectByValue(value);
			break;
		case "text":
			select.selectByVisibleText(value);
			break;
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		default:
			break;
		}
		
	}
	
	public static void screenshot(File file) throws IOException {
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, file);
		
	}
	
}





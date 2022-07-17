package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static void captureScreenshot (WebDriver driver , String Testid) throws IOException
	{
		SimpleDateFormat formatter = new SimpleDateFormat ("dd-MM-yyyy hh-mm-ss");
		Date date = new Date ();
		String result = formatter.format(date);
		System.out.println(result);
	 
		TakesScreenshot t = (TakesScreenshot) driver ;
		File source = t.getScreenshotAs(OutputType.FILE);
		//File dest = new File ("C:\\Users\\Swaraj\\Desktop\\SOFTWARE TESTING\\SELENIUM\\screenshot\\Test-"+Testid +" "+ result+".jpeg");
	    File dest = new File("test-output\\Screenshot\\Test-"+Testid+" "+result+".jpeg");
		FileHandler.copy(source, dest);
	}
	
	
	public static String fetchDataFromExcel (String sheet , int rownum ,int cellnum) throws EncryptedDocumentException, IOException
	{
		//String path = "C:\\Users\\Swaraj\\Desktop\\SOFTWARE TESTING\\SELENIUM\\acti-time.xlsx";
		String path = "src\\main\\resources\\Testdata\\acti-time.xlsx";
		FileInputStream file = new FileInputStream (path);
		Workbook book  = WorkbookFactory.create(file);
			
		
		String data = book.getSheet(sheet).getRow(rownum).getCell(cellnum).getStringCellValue();
		return data;
		
		
		
	}
	

}

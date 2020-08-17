package seleniumFirstProject;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import cucumber.api.java.en.Given;		


public class SeleniumFirstTest {
WebDriver driver;


	@Given("^End to End DBS Test$")
	public void launchBrowser()throws Exception {
	System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.dbs.com/default.page");

	driver.manage().window().maximize();

	driver.findElement(By.xpath("//div[@class='navbar-links-left']//a[@href='/sustainability/default.page']")).click();
	driver.findElement(By.xpath("//a[text()='Creating Social Impact']")).click();
	
	
	driver.findElement(By.xpath("//a[@href='/sustainability/dbs-stronger-together-fund'][text()='Learn More']")).click();
	
    driver.findElement(By.xpath("//a[@class='nav-link hasDevice'][text()='Singapore']")).click();
       
    String beforeXpath_col1 = "//table//tbody//tr[";
    String afterXpath_col1 = "]//td[1]";

    
    String beforeXpath_col2 = "//table//tbody//tr[";
    String afterXpath_col2 = "]//td[2]";
    
    
    String beforeXpath_col3 = "//table//tbody//tr[";
    String afterXpath_col3 = "]//td[3]";
    
    String beforeXpath_col4 = "//table//tbody//tr[";
    String afterXpath_col4 = "]//td[4]";
    
    String beforeXpath_col5 = "//table//tbody//tr[";
    String afterXpath_col5 = "]//td[5]";
    
    int rowCount = driver.findElements(By.xpath("//table//tr")).size();
   
    String path = "Sample.xlsx";
   
    FileInputStream input = new FileInputStream(path);
    
    Workbook wb = new XSSFWorkbook(input);

    for(int i=1; i<rowCount; i++) {
        Sheet sheet = wb.getSheetAt(0);

    	String actualXpath_col1 = beforeXpath_col1+i+afterXpath_col1;
    	String col1 = driver.findElement(By.xpath(actualXpath_col1)).getText();
    	System.out.println(col1);
    	//sheet.(i).createCell(1).setCellValue(col1);
    	sheet.createRow(i);
    	sheet.getRow(i).createCell(0).setCellValue(col1);
    	
    	
    	String actualXpath_col2 = beforeXpath_col2+i+afterXpath_col2;
    	String col2 = driver.findElement(By.xpath(actualXpath_col2)).getText();
    	System.out.println(col2);
    	sheet.getRow(i).createCell(1).setCellValue(col2);


    	
    	String actualXpath_col3 = beforeXpath_col3+i+afterXpath_col3;
    	String col3 = driver.findElement(By.xpath(actualXpath_col3)).getText();
    	System.out.println(col3);
    	sheet.getRow(i).createCell(2).setCellValue(col3);

    	
    	String actualXpath_col4 = beforeXpath_col4+i+afterXpath_col4;
    	String col4 = driver.findElement(By.xpath(actualXpath_col4)).getText();
    	System.out.println(col4);
    	sheet.getRow(i).createCell(3).setCellValue(col4);

    	
    	String actualXpath_col5 = beforeXpath_col5+i+afterXpath_col5;
    	String col5 = driver.findElement(By.xpath(actualXpath_col5)).getText();
    	System.out.println(col5);
    	sheet.getRow(i).createCell(4).setCellValue(col5);
    }

    
    FileOutputStream output=new FileOutputStream(path);
	wb.write(output);
	wb.close();
	
	
    
	driver.findElement(By.xpath("//div[@id='flpHeader']//a[text()='About']")).click();
	driver.findElement(By.xpath("//a[text()='Who We Are']")).click();
	driver.findElement(By.xpath("//a[text()='Our Awards & Accolades']")).click();
	
	int AwardCount = driver.findElements(By.xpath("//div[@class='row mBot-20']")).size();
	
	System.out.println(AwardCount);

	
	Assert.assertEquals(AwardCount,22);
	
    List<WebElement> awardName  = driver.findElements(By.xpath("//div[@class='row mBot-20']"));    
    
	List<String> award	 = Arrays.asList("EuromoneyBank of the Year 2019", "The BankerBank of the Year 2018", "Global FinanceBest Bank in the World 2018");
	
    List<String> a = new ArrayList<>();

	for (int i = 0; i < awardName.size(); i++) {
        a.add(awardName.get(i).getText());
    }        
	System.out.println(a);	
	
	for (int i = 0; i < award.size(); i++) {
		if (a.contains(award.get(i))){
			System.out.println(award.get(i)+ " present");
		} else {
			System.out.println(award.get(i)+ " not present");
		}
    
	}

	}

}

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.blog;
import PageObject.home;
import PageObject.login;
import utility.webExplorer;

public class testcase2_ExploreBlogs {
	/*Ready*/
	WebDriver driver;
	Workbook wb;
	Sheet sh;
	int norows;
	int nocols;
	webExplorer webdriver;
	String url = "https://www.edureka.co/";
 		
	@BeforeTest
	  public void OpeBrowser() {
	  	
	  	System.setProperty("webdriver.chrome.driver", "C:\\\\Program Files\\\\Jar Files\\\\chromedriver.exe");
	  	driver = new ChromeDriver();
	  	driver.get(url);

	  }
	@Test(dataProvider = "testDatafeed")
	public void test_signinEdureka(String email, String pass) throws Exception {
		login log =new login(driver);
		log.userLogin(email,pass);
		Thread.sleep(7000);
		
	}
	@DataProvider
	public Object[][]testDatafeed() throws Exception{
	
		//to import the file to the script and fetch the bytes from the file
		FileInputStream fis = new FileInputStream("C:\\Users\\a66q8zz\\OneDrive - 3M\\Devops\\Training\\eclipse-workspace\\Project\\src\\Excel_Data\\TestData.xlsx");
		
		//call the workbook and open it
		wb = WorkbookFactory.create(fis);
		
		//define the sheet with which we want to work
		sh = wb.getSheet("Sheet2");
		
		norows = sh.getLastRowNum();
		
		nocols = sh.getRow(0).getLastCellNum();
		
		Object[][] formData = new Object[norows][nocols];
		
		for(int row=0; row<norows; row++) 
		{
			for(int col=0; col<nocols; col++) 
			{
				//fetch the data from the excel file
				formData[row][col]=sh.getRow(row).getCell(col).toString();
			}
		}
		
		return formData;		
	}
	@Test(priority=2, enabled=true)
	public void test_blog() throws Exception {
		home h =new home(driver);
		h.userCommunity("Blog");
		Thread.sleep(3000);
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());   
		String handleName = tabs.get(1);      
		driver.switchTo().window(handleName);
		Thread.sleep(3000);
		blog b=new blog(driver);
		b.searchSelenium();
			
		
	}
	 
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}

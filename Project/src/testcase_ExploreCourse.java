
import java.io.FileInputStream;
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

import PageObject.home;
import PageObject.login;
import utility.webExplorer;

public class testcase_ExploreCourse{
	/*Ready
	 * Create a hybrid framework project using selenium and java to test the below
	 * testcases. Usethe concepts of hybrid framework ,Page Object Factory Video 11, Log4j to
	 * log the outputs, POIconcept to read the data from an excel page Video 11 to do the
	 * following script
	 */
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
  		public void test_validateMyCourse() throws Exception {
  			home h =new home(driver);
  			//String textValue="My Profile";
  			h.userProfile("My Profile");
  			/*WebElement profile= driver.findElement(By.xpath("//ul[@class='dropdown-menu user-menu profile-xs hidden-sm hidden-xs']"));
  			List<WebElement> profileDropdown= profile.findElements(By.tagName("a"));
  			for ( WebElement e : profileDropdown ) {
  				String str = e.getAttribute("innerHTML");
  				System.out.println("innerHTML : " + str);
  				if( str.contentEquals("My Profile")) {
  					e.click();
  					break;
  				}
  			}*/
  			
  			h.userCourses("My Classroom");
  			/*driver.findElement(By.xpath("//li[@class=\"dropdown lms_link hidden-xs\"]")).click();
  			WebElement courses= driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right caret_drop']"));
  			List<WebElement> coursesDropdown = courses.findElements(By.tagName("a"));
  			for ( WebElement e : coursesDropdown ) {
  				String str = e.getAttribute("innerHTML");
  				System.out.println("innerHTML : " + str);
  				if( str.contentEquals("")) {
  					e.click();
  					break;
  				}
  			}*/
  			Thread.sleep(7000);
  			//webdriver.DropdownClick(dropdown, "My Classroom");
  			String mjs=driver.findElement(By.xpath("//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 course_not_enroll box_mycourse']")).getText();
  			if(mjs.contains("It looks like you are not enrolled for any course")){
  				System.out.println("There is not any course");
  			}
  			
  		}
  		@Test(priority=3, enabled=true)
  		public void test_userLogOut() {
  			home h =new home(driver);
  			h.userLogout();
  			//h.userProfile("Log Out");

  		}
  		 
  		@AfterTest
  		public void CloseBrowser() {
  			driver.quit();
  		}
}

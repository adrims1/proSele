package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.webExplorer;

/**
 * @author A66Q8ZZ
 *
 */
public class home {
	@FindBy(className="webinar-profile-name")
	WebElement profileClick;
	@FindBy(xpath="//ul[@class='dropdown-menu user-menu profile-xs hidden-sm hidden-xs']")
	WebElement profile;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right caret_drop']")
	WebElement courses;
	@FindBy(xpath="//li[@class=\"dropdown lms_link hidden-xs\"]")
	WebElement coursesClick;
	@FindBy(className="user_name")
	WebElement edureka;
	@FindBy(xpath="//div[@class='dropdown menu-dropdown']")
	WebElement communityClick;
	@FindBy(xpath="//*[@id=\"search-inp\"]")
	WebElement txtBoxSearch;
	
	
	//@FindBy(className="dropdown-toggle ga_ecom_info trackButton")
	
	
	
	@FindBy(xpath="//ul[@class='dropdown-menu' and @aria-labelledby='dropdownMenu4' ]")
	WebElement community;
			
	
	webExplorer webdriver =new webExplorer() ;
	
	public home(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	public void userLogout() {
			
		edureka.click();
		List<WebElement> coursesDropdown = courses.findElements(By.tagName("a"));
	
		webdriver.DropdownClick(coursesDropdown,"Log Out");
	}
	
	/*public void clickBlog() {
		
		profileClick.click();

		webdriver.DropdownClick(profileDropdown, "Blog");
}*/
	public void userProfile(String textValue) {
		
		profileClick.click();
		List<WebElement> profileDropdown= profile.findElements(By.tagName("a"));

		webdriver.DropdownClick(profileDropdown, textValue);
}
	
public void userCourses(String textValue) {
		
		coursesClick.click();
			List<WebElement> coursesDropdown = courses.findElements(By.tagName("a"));

		webdriver.DropdownClick(coursesDropdown, textValue);
}

public void userCommunity(String textValue) {
	
	communityClick.click();
		List<WebElement> communityDropdown = community.findElements(By.tagName("a"));

	webdriver.DropdownClick(communityDropdown, textValue);
}

	
	  public void searchCourse() { // TODO Auto-generated method stub
	  txtBoxSearch.clear();
	  txtBoxSearch.sendKeys("Selenium");
	  
	  }
	 

}

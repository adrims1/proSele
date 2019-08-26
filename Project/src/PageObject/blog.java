package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.webExplorer;

public class blog {
	
	@FindBy(xpath="//li[@id='menu-item-97008']")
	WebElement linktSeleniumIQ;
	
			
	
	webExplorer webdriver =new webExplorer() ;
	
	public blog(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	public void searchSelenium() {
		
		linktSeleniumIQ.click();
		
	}

}

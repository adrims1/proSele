package PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class login {
	
	@FindBy(id="si_popup_email")
	WebElement email;
	@FindBy(id="si_popup_passwd")
	WebElement pass;
	@FindBy(linkText="Log In")
	WebElement btnlogIn1;
	@FindBy(xpath="//button[@class=\'clik_btn_log btn-block\']")
	WebElement btnlogIn2;
	
	

	public login(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Program Files\\Jar Files\\chromedriver.exe"); driver = new
		 * ChromeDriver();
		 */
	}
	public void userLogin(String email1,String pass1) throws InterruptedException {
		//LinkText 
		btnlogIn1.click();
		//Input your email and Pass 
		email.clear();
		email.sendKeys(email1);
		
		pass.clear();
		pass.sendKeys(pass1);
		btnlogIn2.click();
		
	}

}

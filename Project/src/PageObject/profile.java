package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class profile {
	@FindBy(xpath="//a[@id='professional_details']")
	WebElement editProfessional;
	
	@FindBy(xpath="//input[@name='fullname']")
	WebElement txtName;
	
	@FindBy(xpath="//input[@name='currentrole']")
	WebElement txtRole;
	
	@FindBy(xpath="//button[@class='btn btn-default pull-right verify-continue-btn']")
	WebElement btnContinue;
	
	@FindBy(xpath="//a[@class='success active-link']")
	WebElement btnProfile;
	
	@FindBy(xpath="//a[@class='skip']")
	
	WebElement btnSkip;
	@FindBy(xpath="//button[@class='btn pull-right onboarding-primary-button']")
	WebElement btnNext;
	
	@FindBy(xpath="//button[@class='btn onboarding-primary-button pull-right']")
	WebElement btnNext1;
	
	@FindBy(xpath="//button[@class='btn pull-right onboarding-primary-button']")
	WebElement btnSave;
	public profile(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	public void editProfessional() throws Exception {
		editProfessional.click();
		Thread.sleep(2000);
		btnProfile.click();
		txtName.clear();
		txtName.sendKeys("Maria Marin Astorga");
		//txtRole.clear();
		//txtRole.sendKeys("DevOps Engineer");
		Thread.sleep(5000);
		btnContinue.click();
		Thread.sleep(5000);
		btnSkip.click();
		Thread.sleep(5000);
		btnNext.click();
		Thread.sleep(5000);
		btnNext1.click();
		Thread.sleep(5000);
		btnSave.click();
	}
	
	

}

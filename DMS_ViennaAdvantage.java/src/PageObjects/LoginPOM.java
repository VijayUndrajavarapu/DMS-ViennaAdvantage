package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	//@FindBy(how=How.ID,using="log")
	WebElement username;
	
	//@FindBy(how=How.ID,using="pwd")
	WebElement password;
	
	//@FindBy(how=How.ID,using="rememberme")
	WebElement remembermeCheckBox;
	
	//@FindBy(how=How.ID,using="login")
	WebElement loginButton;
	
	public LoginPOM(WebDriver driver){
		
		/*static class in selenium*/
		//PageFactory.initElements(driver, this);
		
		/*NO need to use */
		username=driver.findElement(By.id("log"));
		password=driver.findElement(By.id("pwd"));
		remembermeCheckBox=driver.findElement(By.id("rememberme"));
		loginButton=driver.findElement(By.id("login"));
	}
	
	public void loginWithCookiesSaved(String username,String password){
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		loginButton.click();
	}
	
	public void loginWitoutSavingCookies(String username,String password){
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		remembermeCheckBox.click();
		loginButton.click();
	}

}

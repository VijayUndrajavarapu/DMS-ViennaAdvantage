package PageObjects;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

 

public class ActionKeyword {
	// static RemoteWebDriver product=null;
	static WebDriver product;
	// DesiredCapabilities dr=null;
	public void open_Browser(String browserName) throws MalformedURLException {
		try {
			if (browserName.equalsIgnoreCase("Firefox")) {
				String url = System.getProperty("user.dir") + "\\src\\Browsers_drivers\\geckodriver.exe";
				String driverPath = System.setProperty("webdriver.gecko.driver", url);
				setProduct(new FirefoxDriver());
			} else if (browserName.equalsIgnoreCase("chrome")) {
				/*
				 * String url = System.getProperty("user.dir")+
				 * "\\src\\Browsers_drivers\\chromedriver.exe";
				 */
				String url = System.getProperty("user.dir") + "\\src\\Browser\\chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", url);
				setProduct(new ChromeDriver());
				/* dr=DesiredCapabilities.chrome();
				 dr.setBrowserName("chrome");
				 dr.setPlatform(Platform.WINDOWS);*/
			 
			 /*  product=new RemoteWebDriver(new     URL("http://192.168.0.213:4444/wd/hub"), dr);*/
				 getProduct().manage().window().maximize();
				getProduct().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
			} else if (browserName.equalsIgnoreCase("IE")) {
				String url = System.getProperty("user.dir") + "\\src\\Browsers_drivers\\IEDriverServer.exe";
				System.setProperty("webdriver.ie.driver", url);
				setProduct(new InternetExplorerDriver());
			}
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}

	public String enter_URL(String URL) {
		getProduct().navigate().to(URL);
		String actualUrl = getProduct().getCurrentUrl();
		return actualUrl;

	}

	public By locatorValue(String locatorTpye, String value) {

		By by;
		switch (locatorTpye) {
		case "id":

			by = By.id(value);
			break;
		case "name":
			by = By.name(value);
			break;
		case "xpath":

			by = By.xpath(value);
			break;
		case "css":
			by = By.cssSelector(value);
			break;
		case "linkText":
			by = By.linkText(value);
			break;
		case "partialLinkText":
			by = By.partialLinkText(value);
			break;
		default:
			by = null;
			break;
		}
		/* System.out.println(by); */
		return by;
	}

	public String input_data(String locatorType, String value, String passValue) {
		WebDriverWait wait = new WebDriverWait(product, 30);
		String returnTxt = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			getProduct().findElement(locator).sendKeys(passValue);
			returnTxt = getProduct().findElement(locator).getText();
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to enter text" + e);
		}

		return returnTxt;

	}

	public void click_On_Link(String locatorType, String value) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = getProduct().findElement(locator);
			element.click();
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to enter text" + e);
		}
	}

	public void click_On_Button(String locatorType, String value) {
		WebDriverWait wait = new WebDriverWait(product, 30);
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			WebElement element = getProduct().findElement(locator);
			element.click();
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to perform click" + e);
		}
	}

	public void close_Browser() {
		getProduct().quit();
	}

	public static WebDriver getProduct() {
		return product;
	}

	public static void setProduct(WebDriver product) {
		ActionKeyword.product = product;
	}

	/*
	 * public static void input_email(){
	 * driver.findElement(By.id("identifierId")).sendKeys(
	 * "shaveta.malhotra47@gmail.com"); } public static void click_Next(){
	 * driver.findElement(By.id("identifierNext")).click(); }
	 * 
	 * public static void input_Password(){
	 * driver.findElement(By.id("pwd")).sendKeys("Test@123"); }
	 * 
	 * public static void click_Login(){
	 * driver.findElement(By.id("login")).click(); }
	 * 
	 * public static void waitFor() throws Exception{ Thread.sleep(5000); }
	 * 
	 * public static void click_Logout(){ driver.findElement
	 * (By.xpath(".//*[@id='account_logout']/a")).click(); }
	 * 
	 * public static void closeBrowser(){ driver.quit(); }
	 */

}

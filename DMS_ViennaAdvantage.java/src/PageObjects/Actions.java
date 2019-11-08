package PageObjects;

import java.awt.AWTException;

import java.io.IOException;
import java.net.MalformedURLException;
 
import java.util.Random;
 
 
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Actions extends ActionKeyword {
	Random rand = new Random();
	int rand_int1 = rand.nextInt(10000);
	

	/*public void lounchApp(String URl) throws MalformedURLException {
		open_Browser("chrome");
		getProduct().get(URl);
		getProduct().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}*/
		
	public void lounchApp() throws MalformedURLException {
		String xlrPath = System.getProperty("user.dir") + "\\TestCases.xlsx";
		// Calling constructor of xls reader to read the data from xl sheet
			Xls_Reader xlr = new Xls_Reader(xlrPath);
		int rowCount = xlr.getRowCount("Link Detail");
	
	for (int i = 2; i <= rowCount; i++) {
	
		String runOn = xlr.getCellData("Link Detail", "RUN", i);
	
	
	 
	if (runOn.equals("ON")) {
	
	String link = xlr.getCellData("Link Detail", "HTML Link", i);
	String uname = xlr.getCellData("Link Detail", "HTML User Name", i);
	String pwd = xlr.getCellData("Link Detail", "HTML Password", i);
	
	open_Browser("chrome");
	product.get(link);
	 input_data("id", "loginName", uname);
	// login name
	
	input_data("id", "txtPwd", pwd);
	// login pw
	click_On_Button("id", "btnLogin1");
	 WebDriverWait wait =new WebDriverWait(product,60);
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='DMS']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='DMS']")));
		
		click_On_Button("partialLinkText", "DMS");
		 
			}}
		}
		
	public void reLogin() throws MalformedURLException {
		String xlrPath = System.getProperty("user.dir") + "\\TestCases.xlsx";
		// Calling constructor of xls reader to read the data from xl sheet
			Xls_Reader xlr = new Xls_Reader(xlrPath);
		int rowCount = xlr.getRowCount("Link Detail");
	
	for (int i = 2; i <= rowCount; i++) {
	
		String runOn = xlr.getCellData("Link Detail", "RUN", i);
	
	
	 
	if (runOn.equals("ON")) {
	
	String uname = xlr.getCellData("Link Detail", "HTML User Name", i);
	String pwd = xlr.getCellData("Link Detail", "HTML Password", i);
	
	 input_data("id", "loginName", uname);
	// login name
	
	input_data("id", "txtPwd", pwd);
	// login pw
	click_On_Button("id", "btnLogin1");
	 WebDriverWait wait =new WebDriverWait(product,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("DMS")));
		click_On_Button("partialLinkText", "DMS");
		 
			}}
		}
		
	

	
	
	public void login(String uname, String pwd) throws AWTException {
	input_data("id", "loginName", uname);
		// login name
	 
	input_data("id", "txtPwd", pwd);
		// login pw
	click_On_Button("id", "btnLogin1");
	 WebDriverWait wait =new WebDriverWait(product,60);
	wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("DMS")));
	click_On_Button("partialLinkText", "DMS");
	/*getProduct().findElement(By.partialLinkText("DMS")).click();*/
	/* Robot r = new Robot();                          
		r.keyPress(KeyEvent.VK_CONTROL); 
		r.keyPress(KeyEvent.VK_T); 
		r.keyRelease(KeyEvent.VK_CONTROL); 
		r.keyRelease(KeyEvent.VK_T);
	    ArrayList<String> tabs = new ArrayList<String> (product.getWindowHandles());
	    System.out.println(tabs);
	    product.switchTo().window(tabs.get(1)); //switches to new tab
	    product.get("https://www.facebook.com");*/

    
	}

	
	
	public  void newFolder(String fldname) throws InterruptedException {
		WebDriverWait wait =new WebDriverWait(product,60);
		 click_On_Button("id", "imgNewFolder_1");
		 
		
 		String fName = fldname +rand_int1;
 		System.out.println("foldername"+fldname);

 		input_data("id", "txtFolderName_1", fName);
 		click_On_Button("xpath", "//button[contains(text(),'OK')]");
		 

		int count = getProduct().findElements(By.className("VADMS_pomeriti-7")).size();
		System.out.println("count is"+count);

		int elementCount = count - 1;
		System.out.println("elementCount is"+elementCount);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("VADMS_pomeriti-7")));
		Thread.sleep(5000);
		getProduct().findElements(By.className("VADMS_pomeriti-7")).get(count - 1).click();
	}
	
	

	public  void deletefolder() {
		
		 WebDriverWait wait =new WebDriverWait(product,30);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("VADMS_pomeriti-7")));
			wait.until(ExpectedConditions.elementToBeClickable(By.className("VADMS_pomeriti-7")));

		int count = getProduct().findElements(By.className("VADMS_pomeriti-7")).size();

 
		getProduct().findElements(By.className("VADMS_pomeriti-7")).get(count - 1).click();
		click_On_Button("xpath", "//a[contains(text(),'Delete Folder')]");
		click_On_Button("xpath", "//button[contains(text(),'OK')]");
		 
		getProduct().switchTo().alert().accept();
	
	}
	
	
	public static void quit_Browser() {
		getProduct().quit();
	} 
	
	
	public  void create_Sub_Folder(String child){
		getProduct().findElement(By.partialLinkText("New Sub Folder")).click();
		String sFolder = child +rand_int1;
		input_data("id", "txtFolderName_1", sFolder);
		click_On_Button("xpath", "//button[contains(text(),'OK')]"); 
	 
	}

	
	public void rename_Folder(String Rename) throws InterruptedException {
		   
		int count = getProduct().findElements(By.className("VADMS_pomeriti-7")).size();

		int elementCount = count - 1;
		getProduct().findElements(By.className("VADMS_pomeriti-7")).get(count - 2).click();
		 
		getProduct().findElement(By.partialLinkText("Rename Folder")).click();
		getProduct().findElement(By.id("txtFolderName_1")).clear();
		String rName = Rename +rand_int1;
		input_data("id", "txtFolderName_1", rName);
		  // Rename  folder
		click_On_Button("xpath", "//button[contains(text(),'OK')]"); 

 	/*	Thread.sleep(5000);
		 product.switchTo().alert().accept();
		 Thread.sleep(5000);
		alt.accept();
		product.switchTo().alert().accept();*/
		
		
		//Subscribe Folder
		getProduct().findElements(By.className("VADMS_pomeriti-7")).get(count - 2).click();
		getProduct().findElement(By.partialLinkText("Subscribe Folder")).click();
		/*Thread.sleep(5000);*/
		 getProduct().switchTo().alert().accept();
	}
	
	
	
	public   void delete_Sub_Folder() throws InterruptedException{
		int count = getProduct().findElements(By.className("VADMS_pomeriti-7")).size();

		int elementCount = count - 1;
		getProduct().findElements(By.className("VADMS_pomeriti-7")).get(count - 2).click();
		getProduct().findElement(By.partialLinkText("Delete Sub Folder")).click();	
		click_On_Button("xpath", "//button[contains(text(),'OK')]");
		 
		getProduct().switchTo().alert().accept();
	}
	
	public  void move_Folder() throws InterruptedException{
		 WebDriverWait wait =new WebDriverWait(product,30);
		 
		getProduct().findElement(By.partialLinkText("Move Folder")).click();
		
		
		/*getProduct().findElement(By.name("VADMS_Folder_ID")).sendKeys("Move In");*/
		click_On_Button("xpath", "//button[@class='vis-controls-txtbtn-table-td2'][@style='opacity: 1; height: 30px; width: 40px; float: left;']");
	     
	     Thread.sleep(2000); 
	    //click_On_Button("id", "btnLogin1");
		click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Refresh24.png']");
	    
	   /* Thread.sleep(5000);*/
	    /*getProduct().findElement(By.xpath("//div[contains(text(),'1001158')]")).click();*/
		click_On_Button("xpath", "//tr[@recid='1']");
	     
	    /*Thread.sleep(5000);*/
		click_On_Button("xpath", "//button[@class='VIS_Pref_btn-2'][@style='margin-top: 5px;margin-bottom: -10px;margin-right:5px']");
	     
	    /*Thread.sleep(5000); */
		click_On_Button("xpath", "//button[contains(text(),'OK')]");
		 
		/* product.switchTo().alert().accept();*/
		
	   }
	public   void upload_Document() throws IOException, InterruptedException{
		 WebDriverWait wait =new WebDriverWait(product,30);
			
		int count = getProduct().findElements(By.className("VADMS_pomeriti-7")).size();
		getProduct().findElements(By.className("VADMS_pomeriti-7")).get(count - 1).click();
		
		/*Thread.sleep(5000); */
		click_On_Button("xpath", "//img[@src='/Areas/VADMS/Images/upload.png']");
		 
	 
		/*Thread.sleep(5000); */
		click_On_Button("xpath", "//div[@class='k-button k-upload-button']");
		 
		 
	 	Thread.sleep(2000);  
		Runtime.getRuntime().exec("D:\\AutoITScripts\\AutoUpload2.exe");
		click_On_Button("xpath", "//input[@type='submit'][@value='OK']");
		click_On_Button("id", "btnCloseInfo");
		 
	}

	public void share_Folder() throws InterruptedException, AWTException, MalformedURLException {

		int count = getProduct().findElements(By.className("VADMS_pomeriti-7")).size();
		getProduct().findElements(By.className("VADMS_pomeriti-7")).get(count - 1).click();
		getProduct().findElement(By.partialLinkText("Share Folder")).click();
		getProduct().findElement(By.name("AD_User_ID")).sendKeys("ankita");
		click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/PickOpen20.png']");
		 
		 WebDriverWait wait =new WebDriverWait(product,30);
		 Thread.sleep(2000);
		 click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Refresh24.png']");
		 click_On_Button("xpath", "//div[text()='aadmin']");
		 click_On_Button("xpath", "//button[@class='VIS_Pref_btn-2'][@style='margin-top: 5px;margin-bottom: -10px;margin-right:5px']");
		 click_On_Button("id", "imgSaveAccess");
		 click_On_Button("id", "vadms-btnok");
		
		getProduct().findElements(By.className("VADMS_pomeriti-7")).get(count - 1).click();
		getProduct().findElement(By.partialLinkText("Folder Information")).click();
		String yup = getProduct().findElement(By.xpath("//td[contains(text(),'2019')]")).getText();
		System.out.println(yup);
		click_On_Button("xpath", "//button[@title='Close']");
		 
		
		
		getProduct().findElement(By.partialLinkText("Log Out")).click();
		Actions obj = new Actions();
		obj.login("aadmin", "ankita");		 
		int count1 = getProduct().findElements(By.className("VADMS_pomeriti-7")).size();		 
		getProduct().findElements(By.className("VADMS_pomeriti-7")).get(count1 - 1).click();
		getProduct().findElement(By.partialLinkText("Folder Information")).click();
		String yup1 = getProduct().findElement(By.xpath("//td[contains(text(),'2019')]")).getText();
		if (yup.equals(yup1)) {
			System.out.println("Same Folder Exists(PASSED)");
		} else {
			System.out.println("Not Found(Fail)");
		}
		click_On_Button("xpath", "//button[@title='Close']");
		 
		getProduct().findElement(By.partialLinkText("Log Out")).click();
		 //obj.login("IdeasIncAdmin", "AdminIncIdeas");
		//login("SuperUser", "LinkBeta");
		reLogin();
	} 
		
		
		
		
		
	
}

package PageObjects;

import java.awt.AWTException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Right_Action_Panel extends Actions {

 
			public void all_Doc() throws InterruptedException{
				getProduct().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				 WebDriverWait wait =new WebDriverWait(product,30);
		 
			click_On_Button("xpath", "//span[contains(text(),'All Document ')]");
			click_On_Button("id", "row0col0");
			click_On_Button("id", "row0col0");
			click_On_Button("id", "row0col0");
			WebElement arrow = product.findElement(By.xpath("//span[text()='View Document']"));
			Thread.sleep(2000);
			/*if (arrow.) {
				click_On_Button("xpath", "//img[@src='/Areas/VADMS/Images/arrow-right.png']");
			}*/
		/* click_On_Button("xpath", "//img[@src='/Areas/VADMS/Images/arrow-right.png']");
		 	 click_On_Button("xpath", "//img[@src='/Areas/VADMS/Images/arrow-right.png']"); */
		String doc =	getProduct().findElement(By.xpath("//img[@title='Check Out']")).getAttribute("style");
			System.out.println(doc);
			 
			if (doc.equals("cursor: pointer; position: absolute; opacity: 1; display: none;")) {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Document Name ')]//img[@src='/Areas/VADMS/Images//document.png']")));
				
			click_On_Button("xpath", "//p[contains(text(),'Document Name ')]//img[@src='/Areas/VADMS/Images//document.png']");
			
 			} else {//What are Index
				/*Thread.sleep(10000);*/
			click_On_Button("id", "imgCheckOut_1");
			click_On_Button("xpath", "//button[contains(text(),'OK')]");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Document Name ')]//img[@src='/Areas/VADMS/Images//document.png']")));
			click_On_Button("xpath", "//p[contains(text(),'Document Name ')]//img[@src='/Areas/VADMS/Images//document.png']");
			}
			
		 
				
			}
			public void edit_Doc() throws InterruptedException{
				String doc_Name = "Test_Automation_" +rand_int1;
				click_On_Button("xpath", "//input[@class='docName']");
 			input_data("xpath", "//input[@class='docName']", doc_Name);
 			click_On_Button("xpath", "//p[contains(text(),'Keyword ')]//img[@src='/Areas/VADMS/Images//document.png']");
           
          product.findElement(By.className(" dockeyWord")).clear();
          product.findElement(By.className(" dockeyWord")).sendKeys(doc_Name);
          click_On_Button("xpath", "//p[contains(text(),'Description ')]//img[@src='/Areas/VADMS/Images//document.png']");
          product.findElement(By.className("docDescription")).clear();
          product.findElement(By.className("docDescription")).sendKeys(doc_Name);
          click_On_Button("id", "imgSaveMetadatAttribute_1");
          product.switchTo().alert().accept();
          click_On_Button("id", "imgCheckIn_1");
          click_On_Button("xpath", "//button[contains(text(),'OK')]");
  		
			}
				public void delete_Doc(){
					click_On_Button("id", "imgDeleteDoc_1");
					 click_On_Button("xpath", "//button[contains(text(),'OK')]");
						getProduct().switchTo().alert().accept();
				}
				
				public void move_Doc() throws InterruptedException{
					WebDriverWait wait =new WebDriverWait(product,30);
					
			String folDer =	product.findElements(By.xpath("//span[@class='VADMS_sakriti prvi-uredi5']")).get(5).getAttribute("title");
			System.out.println(folDer);
			click_On_Button("id", "imgMoveDoc_1");
			input_data("name", "VADMS_Folder_ID", folDer);
			 
			 click_On_Button("xpath", "//button[@class='vis-controls-txtbtn-table-td2'][@style='opacity: 1; height: 30px; width: 40px; float: left;']");
			 Thread.sleep(1000);
			 click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Refresh24.png']");
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@recid='1']")));
				click_On_Button("xpath","//tr[@recid='1']");	
				click_On_Button("xpath", "//button[@class='VIS_Pref_btn-2'][@style='margin-top: 5px;margin-bottom: -10px;margin-right:5px']");
				click_On_Button("xpath", "//button[contains(text(),'OK')]");
				getProduct().switchTo().alert().accept();
				}
				
				
				public void chat(){
					click_On_Button("id", "row1col0");
					click_On_Button("id", "imgChat_1");
					input_data("id", "input-chat-new", "Hi This Is Automation :)");
					 click_On_Button("xpath", "//button[contains(text(),'OK')]");
				}
				public void attachMent(){
					click_On_Button("id", "imgAttachToDoc_1");
				}
				public void subscribe_Doc() throws InterruptedException{
					String sub = product.findElement(By.id("imgSubscribeDoc_1")).getAttribute("style");
					if(sub.equalsIgnoreCase("cursor: pointer; position: absolute; opacity: 1; display: block;")){
						click_On_Button("id", "imgSubscribeDoc_1");
						Thread.sleep(1000);
						getProduct().switchTo().alert().accept();
						
					}
					else{
						click_On_Button("id", "imgUnSubscribeDoc_1");
						Thread.sleep(1000);
						getProduct().switchTo().alert().accept();	
					}
				}
				public void copy_Doc() throws InterruptedException{
					WebDriverWait wait =new WebDriverWait(product,30);
					click_On_Button("id", "imgCopyDoc_1");
					String nameIt = "Copy" +rand_int1;
					product.findElement(By.className("vadms-txtCopyDocName")).sendKeys(nameIt);
					String folDer1 =	product.findElements(By.xpath("//span[@class='VADMS_sakriti prvi-uredi5']")).get(5).getAttribute("title");
					input_data("name", "VADMS_Folder_ID", folDer1);
					click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/PickOpen20.png']");
					Thread.sleep(1000);
					 click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Refresh24.png']");
					 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@recid='1']")));
						click_On_Button("xpath", "//tr[@recid='1']");	
						click_On_Button("xpath", "//button[@class='VIS_Pref_btn-2'][@style='margin-top: 5px;margin-bottom: -10px;margin-right:5px']");
						click_On_Button("xpath", "//button[contains(text(),'OK')]");
						getProduct().switchTo().alert().accept();

					
				}
				public void doc_Access() throws InterruptedException{
					WebDriverWait wait =new WebDriverWait(product,30);
					click_On_Button("id", "imgDocAccess_1");
					getProduct().findElement(By.name("AD_User_ID")).sendKeys("ankita");
					click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/PickOpen20.png']");
					Thread.sleep(1000);
					click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Refresh24.png']");
					click_On_Button("xpath", "//div[text()='aadmin']");
					click_On_Button("xpath", "//button[@class='VIS_Pref_btn-2'][@style='margin-top: 5px;margin-bottom: -10px;margin-right:5px']");
					click_On_Button("id", "imgSaveAccess");
					click_On_Button("id", "vadms-btnok");
					 
				}
				public void forward() throws InterruptedException, AWTException, MalformedURLException{
					click_On_Button("id", "imgForwardDoc_1");
					product.findElement(By.className("vadms-withoutdocno")).click();
			 
					product.findElement(By.className("vadms-user")).click();
					click_On_Button("xpath", "//div[contains(text(),'Ankita Admin')]");
					click_On_Button("xpath", "//button[contains(text(),'OK')]");
					getProduct().switchTo().alert().accept();
			        String sel = product.findElement(By.id("row0col0")).getText();
			        System.out.println(sel);
					click_On_Button("partialLinkText", "Log Out");
					login("aadmin", "ankita");
					/*click_On_Button("xpath", "//span[@title='Inbox']");
					*/
					String sel1 = product.findElement(By.id("row0col0")).getText();
					System.out.println(sel1);
					if (sel.equals(sel1)) {
						System.out.println("Same DOc Exists(TC Pass)");
					} else {
						System.out.println("Forwareded Doc Not Found on User(TC Fail)");
					}
					click_On_Button("partialLinkText", "Log Out");
					//login("IdeasIncAdmin", "AdminIncIdeas");
					reLogin();
					
					
				}
				public void mail(){
					click_On_Button("xpath", "//span[contains(text(),'All Document ')]");
					click_On_Button("id", "row0col0");
					click_On_Button("id", "imgSendEmail_1");
					product.findElement(By.className("vadms-subject")).sendKeys("DMS");
					
					 
				 
					product.switchTo().frame(0);
				 
					
					input_data("xpath", "//body[@contenteditable='true']", "Hi Its Automation Of DMS.");
				 
					product.switchTo().defaultContent();
					
					product.findElement(By.className("vadms-to")).sendKeys("kejru@yopmail.com");
					product.findElement(By.className("vadms-sendmail")).click();
					getProduct().switchTo().alert().accept();
					getProduct().switchTo().alert().accept();
					
					
				}
				}

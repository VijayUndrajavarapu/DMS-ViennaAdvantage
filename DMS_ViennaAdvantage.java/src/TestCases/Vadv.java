package TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import PageObjects.ActionKeyword;
import PageObjects.Actions;
import PageObjects.Right_Action_Panel;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class Vadv extends Actions {

	Right_Action_Panel obj1 = new Right_Action_Panel();

	@BeforeClass
	public void setup() throws MalformedURLException {
	//Lounch the URl and login to the application and click on DMS
			lounchApp();
	}


	  @Test(priority = 2)
	public void create_New_Folder() throws InterruptedException {
    // Create a new Folder name as Automation.
		newFolder("Automation_");
	}
	  
   //Create a Subfolder in that parent folder
	@Test(priority = 3)
	public void create_Sub_Folder() {
		create_Sub_Folder("Sub Folder");
	}

	//Rename the folder and subscribe that folder
	@Test(priority = 4)
	public void rename_Subscribe_Folder() throws InterruptedException {

		rename_Folder("Automation");
	}

	//Delete Sub Folder 
	@Test(priority = 5)
	public void Delete_Sub_Folder() throws InterruptedException {
		delete_Sub_Folder();
	}

	//Delete Folder that created on the top 
	@Test(priority = 9)
	public void delete_Folder() {
		deletefolder();
	}

	//Create a new folder and Move previous foder to that folder  
	@Test(priority = 7)
	public void Move_Folder() throws InterruptedException {

		newFolder("Move To");
		move_Folder();
	}
 
/*	//Upload the document to the  folder through Auto IT tool
	@Test(priority = 6)
	public void Upload_Document() throws IOException, InterruptedException {
		upload_Document();
	}

	//Share the folder with User and then check the shared folder on that user's login but there should be a user created already on that link with ankita UN. 
  @Test(priority = 8)
	public void share() throws InterruptedException, AWTException, MalformedURLException {
		share_Folder();
	} 
   
  //Doc Action Panel
  //Go to the All Doc folder and then select a document
	@Test(priority = 10)
	public void all_Doc() throws InterruptedException {
		obj1.all_Doc();
	}

	//Edit the doc Name ,Keyword and the Description etc. in the edit panel
	@Test(priority = 11)
	public void checkOut() throws InterruptedException {
		obj1.edit_Doc();
	}

	
	//Delete the selected Document
	@Test(priority = 12)
	public void delete_Doc() {
		obj1.delete_Doc();
	}

	//Move the document to the other folder
	@Test(priority = 13)
	public void move_Doc() throws InterruptedException {
		obj1.move_Doc();
	}
	
//Do Chat for the particular Doc and verify on the homepage
	@Test(priority = 14)
	public void Chat() {
		obj1.chat();
	}

	//Do the attachment of the document and verify
	@Test(priority = 15)
	public void attachment() {
		obj1.attachMent();
	}
 
	//Verify the system by subscribing and Unsubscribe the selected doc.
	@Test(priority = 16)
	public void subscribe_Unsubscribe_Doc() throws InterruptedException {
		obj1.subscribe_Doc();
	}

	//Copy the selected doc 
	@Test(priority = 17)
	public void copy_Document() throws InterruptedException {	
		obj1.copy_Doc();
	}

	//Give the access of the doc to the other user and verify
  @Test(priority = 18)
	public void share_Document() throws InterruptedException {
		obj1.doc_Access();
	}  
 
  //Forward the document to other user and then verify on other user 
	  @Test(priority = 19)
	public void forward_Document() throws InterruptedException, AWTException, MalformedURLException {
		obj1.forward();
	}   

	  //Send the doc through attachment in the mail
	@Test(priority = 20)
	public void mail_Doc() throws InterruptedException {
		obj1.mail();
	}
*/
	 
//	    @AfterClass public void close() { close_Browser(); } 
	 
}

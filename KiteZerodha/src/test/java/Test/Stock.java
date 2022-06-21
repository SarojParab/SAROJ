package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POJO.Browser1;
import POM.ZerodhPinPage;
import POM.ZerodhaLoginPage;
import Utility.Paramitrization1;

public class Stock {
	WebDriver driver;

	@BeforeMethod
	public void browser() {
		driver =Browser1.openBrowser();
	}

	@Test
	public void loginWithValidCredentialsTest() throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodhaLoginPage zerodhaLoginPage=new ZerodhaLoginPage(driver);
		String username = Paramitrization1.getdata("Credentials", 0, 1);
		String password = Paramitrization1.getdata("Credentials", 1, 1);
		System.out.println(username);
		System.out.println(password);
		zerodhaLoginPage.enterUserID(username);
		zerodhaLoginPage.enterPassword(password);
		zerodhaLoginPage.clickOnLogin();
		Thread.sleep(5000);
		ZerodhPinPage zerodhaPinPage=new ZerodhPinPage(driver);
		String pin=Paramitrization1.getdata("Credentials", 2, 1);
		zerodhaPinPage.enterPin(pin);
		zerodhaPinPage.clickOnContinue();
		Thread.sleep(5000);
		Actions act = new Actions(driver);
		WebElement search =driver.findElement(By.xpath("//input[@icon='search']"));
		act.moveToElement(search);
		act.click();
		
		
		
		
	}

}

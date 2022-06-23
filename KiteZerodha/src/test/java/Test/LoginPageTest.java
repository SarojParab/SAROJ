package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POJO.Browser1;
import POM.ZerodhaLoginPage;
import Utility.Paramitrization1;

public class LoginPageTest {
WebDriver driver;

@BeforeMethod
public void browser() {
	driver =Browser1.openBrowser();
}

@Test
public void loginWithValidCredentialsTest() throws EncryptedDocumentException, IOException {
	ZerodhaLoginPage zerodhaLoginPage=new ZerodhaLoginPage(driver);
	String username = Paramitrization1.getdata("Credentials", 0, 1);
	String password = Paramitrization1.getdata("Credentials", 1, 1);
	System.out.println(username);
	System.out.println(password);
	zerodhaLoginPage.enterUserID(username);
	zerodhaLoginPage.enterPassword(password);
	zerodhaLoginPage.clickOnLogin();
}
@Test
public void forgetPasswordLinkTest() {
	ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
	zerodhaLoginPage.clickOnForgotPassword();
}
	
@Test
public void signUpLinkTest() {
	ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
	zerodhaLoginPage.clickOnSignUp();
}

@Test
public void demo() {
	System.out.println("new method added");
}
}

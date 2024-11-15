package testing_pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LabExam {
	public static WebDriver wd;

	@Test
	@Parameters({ "un", "pw" })

	public void login(String un, String pw) throws Exception {
		wd.findElement(By.xpath("//input[@name='email']")).sendKeys(un);
		Thread.sleep(3000);
		wd.findElement(By.xpath("//input[@name='password']")).sendKeys(pw);
		Thread.sleep(3000);
		wd.findElement(By.xpath("//button[@id='submit']")).click();
		Thread.sleep(3000);

		// fetch data

		WebElement we = wd.findElement(By.name("firstName"));
		we.sendKeys("Ankita");
		String w = we.getAttribute("value");
		System.out.println(w);
		
		WebElement we1 = wd.findElement(By.name("lastName"));
		we1.sendKeys("Ank");
		String w1 = we.getAttribute("value");
		System.out.println(w1);
	}

	@BeforeTest

	public void beforeTest() {
		wd = new ChromeDriver(); 
		wd.get("https://automationexercise.com/login");
		wd.manage().window().maximize();

	}

	@AfterTest

	public void afterTest() {
		String s = wd.getTitle();
		System.out.println(s);
		String u = wd.getCurrentUrl();
		System.out.println(u);
		wd.close();

	}
}
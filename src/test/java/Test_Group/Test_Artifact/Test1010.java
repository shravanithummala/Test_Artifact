package Test_Group.Test_Artifact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1010 {

	// This test-case runs for 15 minutes

	@Test
	public void test() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\preet\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/preet/Desktop/Dummy web application.html");

		Thread.sleep(900000);

		driver.quit();
	}

}

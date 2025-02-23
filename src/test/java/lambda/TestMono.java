package lambda;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestMono {
	
	
	private static String username = "pulusatapathy";
	private static String accessKey = "LT_vnTtE7Kz2JdZxDMdHcYILw8YqMD67aJVEhWyE4GFf2cTdoL";
	private static String LAMBDA_TEST_URL = "https://hub.lambdatest.com/wd/hub";
	private static String TEST_SITE_URL = "https://freelance-learn-automation.vercel.app/login";

	@Test
	public void loginTest() throws MalformedURLException {
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("119.0");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", username);
		ltOptions.put("accessKey", accessKey);
		ltOptions.put("resolution", "1920x1080");
		ltOptions.put("build", "selnmBuild");
		ltOptions.put("project", "selTest");
		ltOptions.put("selenium_version", "4.0.0");
		ltOptions.put("w3c", true);
		browserOptions.setCapability("LT:Options", ltOptions);
		WebDriver driver = new RemoteWebDriver(new URL(LAMBDA_TEST_URL), browserOptions);

		driver.get(TEST_SITE_URL);
		AssertJUnit.assertTrue(driver.getTitle().contains("Automation"));
		driver.findElement(By.id("email1")).sendKeys("admin@email.com");
		driver.findElement(By.name("password1")).sendKeys("admin@123");
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
		driver.quit();

	}

}

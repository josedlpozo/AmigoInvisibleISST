package es.upm.isst.amigoinvisible.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sorteo {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:8888";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testSorteo() throws Exception {
		driver.get(baseUrl + "/index.html");
		driver.findElement(By.id("Entrar")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("manuel");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("isst");
		driver.findElement(By.cssSelector("input[type=submit]")).submit();
		driver.findElement(By.name("ComunidadISST")).click();
		driver.findElement(By.name("Realizar sorteo")).submit();
		assertNotNull(driver.findElement(By.cssSelector("p.oculto")).getText());
		driver.findElement(By.id("Salir")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}

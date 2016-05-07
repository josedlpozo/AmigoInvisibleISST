package es.upm.isst.amigoinvisible.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Registro {
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
	public void testRegistro() throws Exception {
		driver.get(baseUrl + "/index.html");
		driver.findElement(By.id("Registro")).click();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("manuel");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("isst");
		driver.findElement(By.id("confpassword")).clear();
		driver.findElement(By.id("confpassword")).sendKeys("isst");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(
				"manuel.isst2016@gmail.com");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.id("Salir")).click();
		driver.findElement(By.id("Entrar")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("manuel");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("isst");
		driver.findElement(By.cssSelector("input[type=submit]")).submit();
		driver.findElement(By.id("Mi cuenta")).click();
		assertEquals("Correo: manuel.isst2016@gmail.com",
				driver.findElement(By.cssSelector("p")).getText());
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

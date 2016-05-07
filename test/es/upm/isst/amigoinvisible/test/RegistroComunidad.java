package es.upm.isst.amigoinvisible.test;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegistroComunidad {
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
	public void testRegistroComunidad() throws Exception {
		driver.get(baseUrl + "/index.html");
		driver.findElement(By.id("Entrar")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("manuel");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("isst");
		driver.findElement(By.cssSelector("input[type=submit]")).submit();
		driver.findElement(
				By.cssSelector("div.row.text-center > input.btn.btn-default"))
				.click();
		driver.findElement(By.name("nombre_comunidad")).clear();
		driver.findElement(By.name("nombre_comunidad")).sendKeys(
				"ComunidadISST");
		driver.findElement(By.name("pass_comunidad")).clear();
		driver.findElement(By.name("pass_comunidad")).sendKeys("isst");
		driver.findElement(By.name("pass_comunidad2")).clear();
		driver.findElement(By.name("pass_comunidad2")).sendKeys("isst");
		driver.findElement(By.id("nombre_1")).clear();
		driver.findElement(By.id("nombre_1")).sendKeys("jose@gmail.com");
		driver.findElement(By.linkText("[+] Agregar")).click();
		driver.findElement(By.id("nombre_2")).clear();
		driver.findElement(By.id("nombre_2")).sendKeys("miguel@gmail.com");
		driver.findElement(By.linkText("[+] Agregar")).click();
		driver.findElement(By.id("nombre_3")).clear();
		driver.findElement(By.id("nombre_3")).sendKeys("eduardo@gmail.com");
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		driver.findElement(By.id("Salir")).click();
		driver.findElement(By.id("Entrar")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("manuel");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("isst");
		driver.findElement(By.cssSelector("input[type=submit]")).submit();
		driver.findElement(By.name("ComunidadISST")).click();
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

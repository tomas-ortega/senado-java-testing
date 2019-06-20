package com.tdd.tutorial.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestFirefox {
	private static WebDriver driver;

	@BeforeAll
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver",
				"src/test/resources/drivers/geckodriver/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://es.wikipedia.org/");
	}

	@Test
	public void goToGoogle() {
		
	}
	
	@Test
	public void searchTextInWikipedia() {
		WebElement liPortada = driver.findElement(By.id("n-mainpage-description"));
		assertEquals(liPortada.getText(), "Portada");
		
		WebElement liCommunityPortal = driver.findElement(By.id("n-portal"));
		assertEquals(liCommunityPortal.getText(), "Portal de la comunidad");
		
	}

	@AfterAll
	public static void tearDown() {
		driver.quit();
	}
}

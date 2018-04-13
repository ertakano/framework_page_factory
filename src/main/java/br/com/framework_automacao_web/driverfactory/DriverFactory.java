package br.com.framework_automacao_web.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.framework_automacao_web.enumerator.SelectBrowser;

public class DriverFactory {

	private static WebDriver driver = null;

	public static WebDriver createDriver(SelectBrowser browser) {

		switch (browser) {

		case CHROME:
			if (driver == null) {
				System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
				return driver = new ChromeDriver();
			}
			break;

		case FIREFOX:
			if (driver == null) {
				System.setProperty("webdriver.gecko.driver", "/automacao/framework_automacao/drivers/geckodriver");
				return driver = new FirefoxDriver();
			}
			break;

		default:
			System.out.printf("Digite as op��es de browser: CHROME ou FIREFOX.");
		}
		return driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void quitDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}

}

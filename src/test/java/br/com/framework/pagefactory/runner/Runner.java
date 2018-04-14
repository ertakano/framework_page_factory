package br.com.framework.pagefactory.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import br.com.framework.pagefactory.driverfactory.DriverFactory;
import br.com.framework.pagefactory.enumerator.SelectBrowser;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
features = "features/"
,snippets = SnippetType.CAMELCASE
,glue = "br.com.framework.pagefactory.stepdefinitions"
,monochrome = true
,plugin = "br.com.framework.pagefactory.report.ExtentCucumberFormatter:"
,tags = {"@CN01,@CN02"}
)

public class Runner {

	@BeforeClass
	public static void start() throws IOException {
		DriverFactory.createDriver(SelectBrowser.CHROME);
		System.out.println("Inicializando driver...");
	}
	
	@AfterClass
	public static void finish() {
		System.out.println("Fechando driver....");
		DriverFactory.quitDriver();
	}
}
	
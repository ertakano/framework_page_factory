package br.com.framework_automacao_web.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import br.com.framework_automacao_web.driverfactory.DriverFactory;
import br.com.framework_automacao_web.enumerator.SelectBrowser;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
features = "features/"
,snippets = SnippetType.CAMELCASE
,glue = "br.com.framework_automacao_web.stepdefinitions"
,monochrome = true
,plugin = "br.com.framework_automacao_web.report.ExtentCucumberFormatter:"
,tags = {"@CN01,@CN02"}
)

public class CucumberRunner {

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
	
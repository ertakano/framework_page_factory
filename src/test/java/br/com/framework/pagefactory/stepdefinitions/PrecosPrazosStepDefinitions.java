package br.com.framework.pagefactory.stepdefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.framework.pagefactory.driverfactory.DriverFactory;
import br.com.framework.pagefactory.pagefactory.PrecosEPrazosPageObject;
import br.com.framework.pagefactory.report.ExtentCucumberFormatter;
import br.com.framework.pagefactory.utils.WebDriverUtils;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PrecosPrazosStepDefinitions{

	private static WebDriver driver = DriverFactory.getDriver();
	
	WebDriverUtils utils = new WebDriverUtils();
	PrecosEPrazosPageObject precosPrazos = PageFactory.initElements(driver, PrecosEPrazosPageObject.class);
		
	@Dado("^que estou na tela inicial da tela de Precos e prazos$")
	public void queEstouNaTelaInicialDaTelaDePrecosePrazos() throws Throwable {
		precosPrazos.irParaUrlPrecosEPrazos();
		Assert.assertTrue(precosPrazos.isValidaTitulo());
		ExtentCucumberFormatter.screenShotBrowser("tela de Precos e prazos");
		ExtentCucumberFormatter.insertInfoTextInStepReport("Acessa a tela de precos e prazos");
	}
	
	@Dado("^que eu insira o CEP de origem \"(.*?)\"$")
	public void queEuInsiraOCEPDeOrigem(String cepOrigem) throws Throwable {
		precosPrazos.preencherCepDeOrigem(cepOrigem);
		ExtentCucumberFormatter.screenShotBrowser("CEP de origem");
	}
	
	@Dado("^que eu insira o CEP de destino \"(.*?)\"$")
	public void queEuInsiraOCEPDeDestino(String cepDestino) throws Throwable {
		precosPrazos.preencherCepDeDestino(cepDestino);
		ExtentCucumberFormatter.screenShotBrowser("CEP de destino");
	}
	
	@Dado("^selecione o Tipo de Servico \"(.*?)\"$")
	public void selecioneOTipoDeServico(String tipoServico) throws Throwable {
		precosPrazos.selecionarTipoServico(tipoServico);
		ExtentCucumberFormatter.screenShotBrowser("Tipo de Servico");
	}

	@Quando("^clicar em Enviar$")
	public void clicarEmEnviar() throws Throwable {
		precosPrazos.clicarBotaoEnviar();
		ExtentCucumberFormatter.screenShotBrowser("Enviar");
	}

	@Entao("^devo visualizar os dados Prazo de entrega \"(.*?)\", entrega \"(.*?)\", Dias de Entrega \"(.*?)\"$")
	public void devoVisualizarOsDadosPrazoDeEntregaEntregaDiasDeEntrega(String prazoEntrega, String entrega, String diasEntrega) throws Throwable {
		utils.alterTab();
		Assert.assertEquals(prazoEntrega, precosPrazos.pegarTextoprazoEntregaTxt());
		Assert.assertEquals(entrega, precosPrazos.pegarTextoentregaTxt());
		Assert.assertEquals(diasEntrega, precosPrazos.pegarTextodiasEntregaTxt());
		ExtentCucumberFormatter.screenShotBrowser("dados Prazo de entrega");
	}

	@Entao("^clicar em dados do Objeto Simulado$")
	public void clicarEmDadosDoObjetoSimulado() throws Throwable {
		try {
			precosPrazos.clicarBotaoDadosObjetoSimulado();
			ExtentCucumberFormatter.screenShotBrowser("Objeto Simulado");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Entao("^o endereco Simulado de Origem: CEP \"(.*?)\", endereco \"(.*?)\", Bairro \"(.*?)\", Cidade / UF \"(.*?)\"$")
	public void oEnderecoSimuladoDeOrigemCEPEnderecoBairroCidadeUF(String CEPOrigem, String enderecoOrigem, String bairroOrigem, String cidadeUfOrigem) throws Throwable {
		Assert.assertEquals(CEPOrigem, precosPrazos.pegarcepOrigemTxt());
		Assert.assertEquals(enderecoOrigem, precosPrazos.pegarendOrigemTxt());
		Assert.assertEquals(bairroOrigem, precosPrazos.pegarbairroOrigemTxt());
		Assert.assertEquals(cidadeUfOrigem, precosPrazos.pegarcidadeOrigemTxt());
		ExtentCucumberFormatter.screenShotBrowser("endereco Simulado de Origem");
	}
	
	@Entao("^o endereco Simulado de Destino: CEP \"(.*?)\", endereco \"(.*?)\", Bairro \"(.*?)\", Cidade / UF \"(.*?)\"$")
	public void oEnderecoSimuladoDeDestinoCEPEnderecoBairroCidadeUF(String CEPDestino, String enderecoDestino, String bairroDestino, String cidadeUfDestino) throws Throwable {
		Assert.assertEquals(CEPDestino, precosPrazos.pegarcepDestinoTxt());
		Assert.assertEquals(enderecoDestino, precosPrazos.pegarendDestinoTxt());
		Assert.assertEquals(bairroDestino, precosPrazos.pegarbairroDestinoTxt());
		Assert.assertEquals(cidadeUfDestino, precosPrazos.pegarcidadeDestinoTxt());
		ExtentCucumberFormatter.screenShotBrowser("endereco Simulado de Destino");
	}
	
	@SuppressWarnings("static-access")
	@Entao("^o endereco Simulado de Origem: CEP, endereco, Bairro, Cidade$")
	public void oEnderecoSimuladoDeOrigemCEPEnderecoBairroCidade(List<String> listaEnderecoOrigem) throws Throwable {

		String cep = null;
		String endereco = null;
		String Bairro = null;
		String Cidade = null;
		
		for(String lista : listaEnderecoOrigem) {
			cep = lista.valueOf(precosPrazos.pegarcepOrigemTxt());
			endereco = lista.valueOf(precosPrazos.pegarendOrigemTxt());
			Bairro = lista.valueOf(precosPrazos.pegarbairroOrigemTxt());
			Cidade = lista.valueOf(precosPrazos.pegarcidadeOrigemTxt());
		}
		
		Assert.assertEquals(cep, precosPrazos.pegarcepOrigemTxt());
		Assert.assertEquals(endereco, precosPrazos.pegarendOrigemTxt());
		Assert.assertEquals(Bairro, precosPrazos.pegarbairroOrigemTxt());
		Assert.assertEquals(Cidade, precosPrazos.pegarcidadeOrigemTxt());
		ExtentCucumberFormatter.screenShotBrowser("endereco Simulado de Origem");
	}
	
	@SuppressWarnings("static-access")
	@Entao("^o endereco Simulado de Destino: CEP, endereco, Bairro, Cidade$")
	public void oEnderecoSimuladoDeDestinoCEPEnderecoBairroCidade(List<String> listaEnderecoDestino) throws Throwable {
		
		String CEPDestino = null;
		String enderecoDestino = null;
		String bairroDestino = null;
		String cidadeUfDestino = null;
		
		for(String lista : listaEnderecoDestino) {
			CEPDestino = lista.valueOf(precosPrazos.pegarcepDestinoTxt());
			enderecoDestino = lista.valueOf(precosPrazos.pegarendDestinoTxt());
			bairroDestino = lista.valueOf(precosPrazos.pegarbairroDestinoTxt());
			cidadeUfDestino = lista.valueOf(precosPrazos.pegarcidadeDestinoTxt());
		}
		
		Assert.assertEquals(CEPDestino, precosPrazos.pegarcepDestinoTxt());
		Assert.assertEquals(enderecoDestino, precosPrazos.pegarendDestinoTxt());
		Assert.assertEquals(bairroDestino, precosPrazos.pegarbairroDestinoTxt());
		Assert.assertEquals(cidadeUfDestino, precosPrazos.pegarcidadeDestinoTxt());
		ExtentCucumberFormatter.screenShotBrowser("endereco Simulado de Destino");
	}
	
	@After()
	public void retornarTabEfecharAba() {
		driver.close();
		utils.returnAlterTab();
	}

}

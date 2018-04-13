package br.com.framework_automacao_web.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.framework_automacao_web.utils.WebDriverUtils;

public class PrecosEPrazosPageObject extends WebDriverUtils{
	
	@FindBy(xpath = "//div[@class='tituloimagem']/h3")
	private WebElement xpathTitulo;
	
	@FindBy(xpath = "//*[@id='data']")
	private WebElement xpathElementoDataPostagem;
	
	@FindBy(xpath = "//input[@name='cepOrigem']")
	private WebElement xpathElementoCepOrigem;
	
	@FindBy(xpath = "//input[@name='cepDestino']")
	private WebElement xpathElementoCepDestino;
	
	@FindBy(name = "servico")
	private WebElement namelistBoxTipoServico;
	
	@FindBy(xpath = "//div[@id='spanBotao']/input")
	private WebElement xpathElementoBotaoEnviar;
	
	@FindBy(xpath = "//div[@class='expodados']/b")
	private WebElement botaoDadosObjetoSimulado;
	
	@FindBy(xpath = "//tr[@class='destaque']/td/prazoentrega")
	private WebElement prazoEntregaTxt;
	
	@FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/table/tbody/tr[3]/td")
	private WebElement entregaTxt;
	
	@FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/table/tbody/tr[4]/td")
	private WebElement diasEntregaTxt;
	
	@FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div[6]/table/tbody/tr[2]/td[1]")
	private WebElement cepOrigemTxt;
	
	@FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div[6]/table/tbody/tr[3]/td[1]")
	private WebElement endOrigemTxt;	
	
	@FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div[6]/table/tbody/tr[4]/td[1]")
	private WebElement bairroOrigemTxt;
	
	@FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div[6]/table/tbody/tr[5]/td[1]")
	private WebElement cidadeOrigemTxt; 
	
	@FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div[6]/table/tbody/tr[2]/td[2]")
	private WebElement cepDestinoTxt;
	
	@FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div[6]/table/tbody/tr[3]/td[2]")
	private WebElement endDestinoTxt;
	
	@FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div[6]/table/tbody/tr[4]/td[2]")
	private WebElement bairroDestinoTxt;
	
	@FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div[6]/table/tbody/tr[5]/td[2]")
	private WebElement cidadeDestinoTxt;
	
	@FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/ul/li[6]/a/h2")
	private WebElement namePagePrecosPrazos;		
		
	
	public void irParaUrlPrecosEPrazos() {
		navigateTo("http://www2.correios.com.br/sistemas/precosPrazos/");
	}
	
	public boolean isValidaTitulo() throws Exception {
		containsTextInElement(xpathTitulo, getText(xpathTitulo));
		return true;
	}
	
	public boolean isValidaTexto(String texto) throws Exception {
		return containsElementsByText(texto);
	}
	
	public String pegarTextoprazoEntregaTxt() throws Exception {
		containsElement(prazoEntregaTxt);
		return getText(prazoEntregaTxt);
	}
	
	public String pegarTextoentregaTxt() throws Exception {
		containsElement(entregaTxt);
		return getText(entregaTxt);
	}
	
	public String pegarTextodiasEntregaTxt() throws Exception {
		containsElement(diasEntregaTxt);
		return getText(diasEntregaTxt);
	}
	
	public String pegarcepOrigemTxt() throws Exception {
		containsElement(cepOrigemTxt);
		return getText(cepOrigemTxt);
	}
	
	public String pegarendOrigemTxt() throws Exception {
		containsElement(endOrigemTxt);
		return getText(endOrigemTxt);
	}
	
	public String pegarbairroOrigemTxt() throws Exception {
		containsElement(bairroOrigemTxt);
		return getText(bairroOrigemTxt);
	}
	
	public String pegarcidadeOrigemTxt() throws Exception {
		containsElement(cidadeOrigemTxt);
		return getText(cidadeOrigemTxt);
	}
	
	public String pegarcepDestinoTxt() throws Exception {
		containsElement(cepDestinoTxt);
		return getText(cepDestinoTxt);
	}
	
	public String pegarendDestinoTxt() throws Exception {
		containsElement(endDestinoTxt);
		return getText(endDestinoTxt);
	}
	
	public String pegarbairroDestinoTxt() throws Exception {
		containsElement(bairroDestinoTxt);
		return getText(bairroDestinoTxt);
	}
	
	public String pegarcidadeDestinoTxt() throws Exception {
		containsElement(cidadeDestinoTxt);
		return getText(cidadeDestinoTxt);
	}

	public void preencherCepDeOrigem(String cepOrigem) {
		click(xpathElementoCepOrigem);
		clear(xpathElementoCepOrigem);
		writeText(xpathElementoCepOrigem, cepOrigem);
	}
	
	public void preencherCepDeDestino(String cepDestino) {
		click(xpathElementoCepDestino);
		clear(xpathElementoCepDestino);
		writeText(xpathElementoCepDestino, cepDestino);
	}
	
	public void selecionarTipoServico(String tipoServico) {
		selectElementListBox(namelistBoxTipoServico, tipoServico);
	}
	
	public void clicarBotaoEnviar() {	
		click(xpathElementoBotaoEnviar);
	}
	
	public void clicarBotaoDadosObjetoSimulado() {	
		click(botaoDadosObjetoSimulado);
	}
	
	public String namePagePrecosPrazos() {
		return getText(namePagePrecosPrazos);
	}
}

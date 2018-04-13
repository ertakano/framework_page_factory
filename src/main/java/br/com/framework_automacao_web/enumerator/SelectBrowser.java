package br.com.framework_automacao_web.enumerator;

public enum SelectBrowser {

	CHROME("CHROME"),
	FIREFOX("FIREFOX");
	
	private final String value;
	
	SelectBrowser(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}

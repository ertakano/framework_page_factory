package br.com.framework.pagefactory.enumerator;

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

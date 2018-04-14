package br.com.framework_automacao_web.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
	
	/**
	 * Metodo para retornar a data atual no formato String 'dd/mm/yyyy'
	 * @return
	 */
	public String preencherDataDePostagem() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		dateFormat.format(date).toString();
		System.out.println("Data da postagem:" + dateFormat.format(date).toString());
		return dateFormat.format(date).toString();
	}

}

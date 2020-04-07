package br.com.foursys.relatorio.controller;

import java.util.ArrayList;

import br.com.foursys.relatorio.vo.FilmeVO;

public class FilmeController {

	/**
	 * M�todo fake para gerar uma lista de filme para exibir 
	 * no relat�rio
	 * Esse m�todo ser� retirado futuramente;
	 * @return ArrayList de Clientes
	 */
	
	
	public ArrayList<FilmeVO> retornaFilmes(){
		ArrayList<FilmeVO> lista = new ArrayList<FilmeVO>();
		
		lista.add(new FilmeVO("1", "Vingadores", "A��o"));
		lista.add(new FilmeVO("2", "Matrix", "Fic��o"));
		lista.add(new FilmeVO("3", "Trom", "Fic��o"));
		lista.add(new FilmeVO("4", "Indiana Jones", "Aventura"));
		lista.add(new FilmeVO("5", "Neon Genesis Evangelion", "Anima��o"));

		return lista;
	}
}

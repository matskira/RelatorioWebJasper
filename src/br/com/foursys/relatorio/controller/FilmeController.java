package br.com.foursys.relatorio.controller;

import java.util.ArrayList;

import br.com.foursys.relatorio.vo.FilmeVO;

public class FilmeController {

	/**
	 * Método fake para gerar uma lista de filme para exibir 
	 * no relatório
	 * Esse método será retirado futuramente;
	 * @return ArrayList de Clientes
	 */
	
	
	public ArrayList<FilmeVO> retornaFilmes(){
		ArrayList<FilmeVO> lista = new ArrayList<FilmeVO>();
		
		lista.add(new FilmeVO("1", "Vingadores", "Ação"));
		lista.add(new FilmeVO("2", "Matrix", "Ficção"));
		lista.add(new FilmeVO("3", "Trom", "Ficção"));
		lista.add(new FilmeVO("4", "Indiana Jones", "Aventura"));
		lista.add(new FilmeVO("5", "Neon Genesis Evangelion", "Animação"));

		return lista;
	}
}

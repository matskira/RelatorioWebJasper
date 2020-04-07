package br.com.foursys.relatorio.controller;

import java.util.ArrayList;

import br.com.foursys.relatorio.vo.VendedorVO;

public class VendedorController {
	
	/**
	 * Método fake para gerar uma lista de vendedores para exibir 
	 * no relatório
	 * Esse método será retirado futuramente;
	 * @return ArrayList de Vendedor
	 */
	
	
	public ArrayList<VendedorVO> retornaVendedores(){
		ArrayList<VendedorVO> lista = new ArrayList<VendedorVO>();
		
		lista.add(new VendedorVO("João Carlos", "Caixa", "R$2.000,50"));
		lista.add(new VendedorVO("Diego Jones", "Gerente", "R$4.000,50"));
		lista.add(new VendedorVO("Augusto Moraes", "Caixa", "R$2.000,50"));
		lista.add(new VendedorVO("Carlos Donnare", "Diretor", "R$6.000,50"));
		lista.add(new VendedorVO("Guilherme Donsa", "Caixa", "R$2.000,50"));
		
		
	
		
		return lista;
	}

}

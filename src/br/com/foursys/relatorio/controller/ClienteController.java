package br.com.foursys.relatorio.controller;

import java.util.ArrayList;

import br.com.foursys.relatorio.bean.Cliente;
import br.com.foursys.relatorio.dao.ClienteDAO;
import br.com.foursys.relatorio.vo.ClienteVO;

public class ClienteController {

	
	/**
	 * Método para gerar uma lista de Cliente para exibir no relatório
	 * @return ArrayList de Clientes
	 */
	
	
	public ArrayList<ClienteVO> retornaClientes(){
		ArrayList<ClienteVO> listaVO = new ArrayList<ClienteVO>();
		try {
			ArrayList<Cliente> listaClientes = new ClienteDAO().buscarTodos();
			for (Cliente cliente : listaClientes) {
				ClienteVO vo = new ClienteVO();
				vo.setNome(cliente.getNome());
				vo.setTelefone(cliente.getTelefone());
				vo.setDataNascimento(cliente.getDataNascimento());
				vo.setCidade(cliente.getCidade());
				listaVO.add(vo);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listaVO;
	}
	
	
	
}

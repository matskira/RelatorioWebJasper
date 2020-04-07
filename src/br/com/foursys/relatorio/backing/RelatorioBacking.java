package br.com.foursys.relatorio.backing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.foursys.relatorio.controller.ClienteController;
import br.com.foursys.relatorio.controller.FilmeController;
import br.com.foursys.relatorio.controller.VendedorController;
import br.com.foursys.relatorio.vo.ClienteVO;
import br.com.foursys.relatorio.vo.FilmeVO;
import br.com.foursys.relatorio.vo.VendedorVO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class RelatorioBacking {

	private String saida;

	public String getSaida() {
		return saida;
	}

	public void setSaida(String saida) {
		this.saida = saida;
	}
	
	/**
	 * Método para retornar o caminho completo do diretório onde se encontra o
	 * arquivo 'jasper' e o arquivo 'pdf'
	 * 
	 * @param diretorio String a ser localizado na aplicação
	 * @return String do caminho do arquivo completo
	 */
	
	private String getDiretorioReal(String diretorio) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		
		
		return session.getServletContext().getRealPath(diretorio);
	}
	
	/**
	 * Método para retornar o nome da aplicação
	 * 
	 * @return String do nome da aplicação
	 */
	
	private String getContextPath() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

		return session.getServletContext().getContextPath();
	}
	
	/**
	 * Método para preencher o PDF de relatório 
	 * @param JasperPrint para preencher o arquivo original PDF
	 * @throws JRExcpetion 
	 */
	
	private void preenchePdf(JasperPrint print) throws JRException{
		// Pega o caminho completo do PDF desde a raiz;
		saida = getDiretorioReal("/pdf/relatorio.pdf");
		// Exportando para PDF
		JasperExportManager.exportReportToPdfFile(print, saida);
		/*
		 * Jogo na variável saída o nome da aplicação mais o caminho para o PDF
		 * Essa variável será utilizada pela view(tela);
		 */
		saida = getContextPath() +  "/pdf/relatorio.pdf";
	}
	
	
	/**
	 * Método para gerar o relatório de Cliente
	 * 
	 * @return String navigation rule que exibe o relatório;
	 */
	
	public String geraRelatorioCliente() {
		saida = null;
		
		//Captura o local onde está gravado o arquivo 'jasper'
		String jasper = getDiretorioReal("/jasper/cliente.jasper");
		
		//Cria a instância da lista de Clientes e carrega para gerar o Relatório
		ArrayList<ClienteVO> clientes = new ClienteController().retornaClientes();
		
		// Gerando uma lista de cliente convertida para enviar ao Jasper;
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(clientes);
		
		// Gerando mapa de parâmetros e informando título e totalizadores;
		Map parametros = new HashMap();
		parametros.put("titulo", "Relatório de Clientes");
		parametros.put(clientes, ds);
		parametros.put("total", "Total de Clientes: " + clientes.size());
		
		try {
			// Efetuando a geração do relatório jasper
			JasperPrint print = JasperFillManager.fillReport(jasper, parametros, ds);
			// Gerar o PDF
			preenchePdf(print);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "exibeRelatorio";
	}
	
	/**
	 * Método para gerar o relatório do Filme
	 * 
	 * @return String navigation rule que exibe o relatório;
	 */
	
	public String geraRelatorioFilme() {
		saida = null;
		
		//Captura o local onde está gravado o arquivo 'jasper'
		String jasper = getDiretorioReal("/jasper/filmes.jasper");
		
		//Cria a instância da lista de Filmes e carrega para gerar o Relatório
		ArrayList<FilmeVO> filmes = new FilmeController().retornaFilmes();
		
		// Gerando uma lista de filmes convertida para enviar ao Jasper;
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(filmes);
		
		// Gerando mapa de parâmetros e informando título e totalizadores;
		Map parametros = new HashMap();
		parametros.put("titulo", "Relatório de Filmes");
		parametros.put(filmes, ds);
		parametros.put("total", "Total de Filmes: " + filmes.size());
		
		try {
			// Efetuando a geração do relatório jasper
			JasperPrint print = JasperFillManager.fillReport(jasper, parametros, ds);
			// Gerar o PDF
			preenchePdf(print);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "exibeRelatorio";
	}
	
	/**
	 * Método para gerar o relatório do Vendedor
	 * 
	 * @return String navigation rule que exibe o relatório;
	 */
	
	public String geraRelatorioVendedor() {
		saida = null;
		
		//Captura o local onde está gravado o arquivo 'jasper'
		String jasper = getDiretorioReal("/jasper/vendedor.jasper");
		
		//Cria a instância da lista de Filmes e carrega para gerar o Relatório
		ArrayList<VendedorVO> vendedor = new VendedorController().retornaVendedores();
		
		// Gerando uma lista de filmes convertida para enviar ao Jasper;
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(vendedor);
		
		// Gerando mapa de parâmetros e informando título e totalizadores;
		Map parametros = new HashMap();
		parametros.put("titulo", "Relatório de Vendedores");
		parametros.put(vendedor, ds);
		parametros.put("total", "Total de Vendedores: " + vendedor.size());
		
		try {
			// Efetuando a geração do relatório jasper
			JasperPrint print = JasperFillManager.fillReport(jasper, parametros, ds);
			// Gerar o PDF
			preenchePdf(print);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "exibeRelatorio";
	}
	
	
	
	
	
	
}

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
	 * M�todo para retornar o caminho completo do diret�rio onde se encontra o
	 * arquivo 'jasper' e o arquivo 'pdf'
	 * 
	 * @param diretorio String a ser localizado na aplica��o
	 * @return String do caminho do arquivo completo
	 */
	
	private String getDiretorioReal(String diretorio) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		
		
		return session.getServletContext().getRealPath(diretorio);
	}
	
	/**
	 * M�todo para retornar o nome da aplica��o
	 * 
	 * @return String do nome da aplica��o
	 */
	
	private String getContextPath() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

		return session.getServletContext().getContextPath();
	}
	
	/**
	 * M�todo para preencher o PDF de relat�rio 
	 * @param JasperPrint para preencher o arquivo original PDF
	 * @throws JRExcpetion 
	 */
	
	private void preenchePdf(JasperPrint print) throws JRException{
		// Pega o caminho completo do PDF desde a raiz;
		saida = getDiretorioReal("/pdf/relatorio.pdf");
		// Exportando para PDF
		JasperExportManager.exportReportToPdfFile(print, saida);
		/*
		 * Jogo na vari�vel sa�da o nome da aplica��o mais o caminho para o PDF
		 * Essa vari�vel ser� utilizada pela view(tela);
		 */
		saida = getContextPath() +  "/pdf/relatorio.pdf";
	}
	
	
	/**
	 * M�todo para gerar o relat�rio de Cliente
	 * 
	 * @return String navigation rule que exibe o relat�rio;
	 */
	
	public String geraRelatorioCliente() {
		saida = null;
		
		//Captura o local onde est� gravado o arquivo 'jasper'
		String jasper = getDiretorioReal("/jasper/cliente.jasper");
		
		//Cria a inst�ncia da lista de Clientes e carrega para gerar o Relat�rio
		ArrayList<ClienteVO> clientes = new ClienteController().retornaClientes();
		
		// Gerando uma lista de cliente convertida para enviar ao Jasper;
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(clientes);
		
		// Gerando mapa de par�metros e informando t�tulo e totalizadores;
		Map parametros = new HashMap();
		parametros.put("titulo", "Relat�rio de Clientes");
		parametros.put(clientes, ds);
		parametros.put("total", "Total de Clientes: " + clientes.size());
		
		try {
			// Efetuando a gera��o do relat�rio jasper
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
	 * M�todo para gerar o relat�rio do Filme
	 * 
	 * @return String navigation rule que exibe o relat�rio;
	 */
	
	public String geraRelatorioFilme() {
		saida = null;
		
		//Captura o local onde est� gravado o arquivo 'jasper'
		String jasper = getDiretorioReal("/jasper/filmes.jasper");
		
		//Cria a inst�ncia da lista de Filmes e carrega para gerar o Relat�rio
		ArrayList<FilmeVO> filmes = new FilmeController().retornaFilmes();
		
		// Gerando uma lista de filmes convertida para enviar ao Jasper;
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(filmes);
		
		// Gerando mapa de par�metros e informando t�tulo e totalizadores;
		Map parametros = new HashMap();
		parametros.put("titulo", "Relat�rio de Filmes");
		parametros.put(filmes, ds);
		parametros.put("total", "Total de Filmes: " + filmes.size());
		
		try {
			// Efetuando a gera��o do relat�rio jasper
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
	 * M�todo para gerar o relat�rio do Vendedor
	 * 
	 * @return String navigation rule que exibe o relat�rio;
	 */
	
	public String geraRelatorioVendedor() {
		saida = null;
		
		//Captura o local onde est� gravado o arquivo 'jasper'
		String jasper = getDiretorioReal("/jasper/vendedor.jasper");
		
		//Cria a inst�ncia da lista de Filmes e carrega para gerar o Relat�rio
		ArrayList<VendedorVO> vendedor = new VendedorController().retornaVendedores();
		
		// Gerando uma lista de filmes convertida para enviar ao Jasper;
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(vendedor);
		
		// Gerando mapa de par�metros e informando t�tulo e totalizadores;
		Map parametros = new HashMap();
		parametros.put("titulo", "Relat�rio de Vendedores");
		parametros.put(vendedor, ds);
		parametros.put("total", "Total de Vendedores: " + vendedor.size());
		
		try {
			// Efetuando a gera��o do relat�rio jasper
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

package controller;

import dao.ArtigoDao;
import dao.ArtigoDaoImp;
import model.Artigo;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.Column;

@ManagedBean
public class ArtigoController {

	private String nome;
	private String link;
	private String autor;
	private DataModel listaArtigos;

	public DataModel getListaArtigos() {
		List<Artigo> lista = new ArtigoDaoImp().list();
		listaArtigos = new ListDataModel(lista);
		return listaArtigos;
	}
	/*
	public String prepararAlterarArtigo(){
		artigo = (Artigo)(listaArtigos.getRowData());
		return "gerenciarArtigo";
	}
	*/
	
	public String excluirArtigo(){
		Artigo artigoTemp = (Artigo)(listaArtigos.getRowData());
		ArtigoDao dao = new ArtigoDaoImp();
		dao.remove(artigoTemp);
		return "index";
	}
	
	public void adicionarArtigo(){
		ArtigoDao dao = new ArtigoDaoImp();
		Artigo artigo = new Artigo(nome,link,autor);
		dao.save(artigo);
	}
	
	public void alterarArtigo(){
		Artigo artigo = new Artigo(nome,link,autor);
		ArtigoDao dao = new ArtigoDaoImp();
		dao.update(artigo);
		return;
	}
	
	//Gets and Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setListaArtigos(DataModel listaArtigos) {
		this.listaArtigos = listaArtigos;
	}
	
}

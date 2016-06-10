package controller;

import dao.NoticiaDao;
import dao.NoticiaDaoImp;
import model.Noticia;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.Column;

@ManagedBean
public class NoticiaController {

	private String titulo;
	private String conteudo;
	private String data;
	private DataModel listaNoticias;

	public DataModel getListaNoticias() {
		List<Noticia> lista = new NoticiaDaoImp().list();
		listaNoticias = new ListDataModel(lista);
		return listaNoticias;
	}
	/*
	public String prepararAlterarArtigo(){
		artigo = (Artigo)(listaArtigos.getRowData());
		return "gerenciarArtigo";
	}
	*/
	
	public String excluirNoticia(){
		Noticia noticiaTemp = (Noticia)(listaNoticias.getRowData());
		NoticiaDao dao = new NoticiaDaoImp();
		dao.remove(noticiaTemp);
		return "index";
	}
	
	public void adicionarNoticia(){
		NoticiaDao dao = new NoticiaDaoImp();
		Noticia noticia = new Noticia(titulo,conteudo,data);
		dao.save(noticia);
	}
	
	public void alterarNoticia(){
		Noticia noticia = new Noticia(titulo,conteudo,data);
		NoticiaDao dao = new NoticiaDaoImp();
		dao.update(noticia);
		return;
	}
	
	//Getter and Setters
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setListaNoticias(DataModel listaNoticias) {
		this.listaNoticias = listaNoticias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conteudo == null) ? 0 : conteudo.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((listaNoticias == null) ? 0 : listaNoticias.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}
	
	//Hashs and Equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NoticiaController other = (NoticiaController) obj;
		if (conteudo == null) {
			if (other.conteudo != null)
				return false;
		} else if (!conteudo.equals(other.conteudo))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (listaNoticias == null) {
			if (other.listaNoticias != null)
				return false;
		} else if (!listaNoticias.equals(other.listaNoticias))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
}

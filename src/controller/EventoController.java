package controller;

import dao.EventoDao;
import dao.EventoDaoImp;
import model.Evento;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.Column;

@ManagedBean
public class EventoController {

	private String nome;
	private String descricao;
	private String data;
	private String organizador;
	private DataModel listaEventos;

	public DataModel getListaEventos() {
		List<Evento> lista = new EventoDaoImp().list();
		listaEventos = new ListDataModel(lista);
		return listaEventos;
	}
	/*
	public String prepararAlterarArtigo(){
		artigo = (Artigo)(listaArtigos.getRowData());
		return "gerenciarArtigo";
	}
	*/
	
	public String excluirEvento(){
		Evento eventoTemp = (Evento)(listaEventos.getRowData());
		EventoDao dao = new EventoDaoImp();
		dao.remove(eventoTemp);
		return "index";
	}
	
	public void adicionarEvento(){
		EventoDao dao = new EventoDaoImp();
		Evento evento = new Evento(nome,descricao,data,organizador);
		dao.save(evento);
	}
	
	public void alterarEvento(){
		Evento evento = new Evento(nome,descricao,data,organizador);
		EventoDao dao = new EventoDaoImp();
		dao.update(evento);
		return;
	}
	
	//Gets and Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getOrganizador() {
		return organizador;
	}

	public void setOrganizador(String organizador) {
		this.organizador = organizador;
	}

	public void setListaEventos(DataModel listaEventos) {
		this.listaEventos = listaEventos;
	}	
}

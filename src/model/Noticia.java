package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "noticia")
public class Evento {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "nome", length = 200, nullable = true)
	private String nome;
	
	@Column(name = "conteudo", length = 200, nullable = true)
	private String conteudo;
	
	@Column(name = "data", length = 200, nullable = true)
	private String data;
	
	@Column(name = "organizador", length = 200, nullable = true)
	private String Organizador;
	
	//Methods builders
	
	//Getters and Setters
	
	//Hashs and Equals
		
}

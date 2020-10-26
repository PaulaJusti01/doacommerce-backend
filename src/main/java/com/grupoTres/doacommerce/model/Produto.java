package com.grupoTres.doacommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	//@Size(max=4) ta dando problema na validação do Size
	private int quantidade; 
	
	@NotNull
	@Size(max=25)
	private String nome;//tive que adicionar o "nome do produto", caso contrario só apareceria a categoria na tabela.(ex o nome do produto é "Arroz" da categoria alimento)
	private String img;	
	private String texto;
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	private boolean urgente;
	
	@ManyToOne()
	@JsonIgnoreProperties("doacao")
	private Usuario doacao; 
	
	@ManyToOne()
	@JsonIgnoreProperties("usuario")
	
	private Usuario usuario; 
	
	@ManyToOne()
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isUrgente() {
		return urgente;
	}

	public void setUrgente(boolean urgente) {
		this.urgente = urgente;
	}

	public Usuario getDoacao() {
		return doacao;
	}

	public void setDoacao(Usuario doacao) {
		this.doacao = doacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	} 

	
}
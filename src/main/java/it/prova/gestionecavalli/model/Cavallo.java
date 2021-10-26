package it.prova.gestionecavalli.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cavallo")
public class Cavallo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "razza")
	private String razza;
	@Column(name = "prezzo")
	private Integer prezzo;
	@Column(name = "datadinascita")
	private Date dataDiNascita;

	public Cavallo() {
	}

	public Cavallo(Long id, String nome, String razza, Integer prezzo, Date dataDiNascita) {
		super();
		this.id = id;
		this.nome = nome;
		this.razza = razza;
		this.prezzo = prezzo;
		this.dataDiNascita = dataDiNascita;
	}

	public Cavallo(String nome, String razza, Integer prezzo, Date dataDiNascita) {
		super();
		this.nome = nome;
		this.razza = razza;
		this.prezzo = prezzo;
		this.dataDiNascita = dataDiNascita;
	}

	public Cavallo(String nome, String razza) {
		super();
		this.nome = nome;
		this.razza = razza;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRazza() {
		return razza;
	}

	public void setRazza(String razza) {
		this.razza = razza;
	}

	public Integer getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

}

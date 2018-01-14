package spring.mysql.poc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nome;
	private String email;

	/**
	 * Construtor padrão
	 */
	public Pessoa() {
		super();
	}

	/**
	 * Construtor sobrescrito
	 * 
	 * @param nome
	 * @param email
	 */
	public Pessoa(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("Pessoa[id=%s, nome='%s', email='%s']", id, nome, email);
	}

}

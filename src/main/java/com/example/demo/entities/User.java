package com.example.demo.entities;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="tb_user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "user_sequence"
    )
	@Column
	private Long id;
	@Column
	private String nome;
	@Column
	private String email;
	@Column
	private String telefone;
	@Column
	private String password;
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public User() {
	}

	public User(String nome, 
				String email, 
				String telefone, 
				String password) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.password = password;
	}
	
	public User(String nome, 
			String telefone, 
			String password) {
	this.nome = nome;
	this.telefone = telefone;
	this.password = password;
}

	public User(Long id, 
				String nome, 
				String email, 
				String telefone, 
				String password) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.password = password;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	
}

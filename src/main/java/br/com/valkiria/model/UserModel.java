package br.com.valkiria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import java.util.UUID;

@Data
@Entity(name = "tb_valkiria_user")
public class UserModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true ,nullable = false)
    private String cpf;
    @Column(unique = true ,nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserModel() {}
	public UserModel(UUID id, String name, String cpf, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.password = password;
	}

}

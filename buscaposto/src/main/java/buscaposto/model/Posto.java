//package buscaposto.model;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//
//@Entity
//@Table
//
//@NamedQueries({ @NamedQuery(name = "Posto.findAll", query = "SELECT p FROM Posto p"),
////	@NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.id = :id") 
//	})
////@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
//public class Posto implements Serializable{
//	private static final long serialVersionUID = 1L;
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="idPosto")
//	private Integer id;
//
//	@Column(name="email")
//	private String email;
//	@Column(name="senha")
//	private String senha;
//	@Column(name="nome")
//	private String nome;
//	@Column(name="localizacao")
//	private Localizacao localizacao;
//	@Column(name="bandeira_posto")
//	private String bandeira;
//
//	private Combustivel combustivel;
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getSenha() {
//		return senha;
//	}
//
//	public void setSenha(String senha) {
//		this.senha = senha;
//	}
//
//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	public Localizacao getLocalizacao() {
//		return localizacao;
//	}
//
//	public void setLocalizacao(Localizacao localizacao) {
//		this.localizacao = localizacao;
//	}
//
//	public String getBandeira() {
//		return bandeira;
//	}
//
//	public void setBandeira(String bandeira) {
//		this.bandeira = bandeira;
//	}
//
//	public Combustivel getCombustivel() {
//		return combustivel;
//	}
//
//	public void setCombustivel(Combustivel combustivel) {
//		this.combustivel = combustivel;
//	}
//
//}

package buscaposto.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
@NamedQuery(name = "BuscaPosto.findAll", query = "SELECT b FROM BuscaPosto b ORDER BY b.id")
public class BuscaPosto implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)

	private Integer id;
	@Column(name = "nome_posto", nullable = false)

	private String posto;

	@Column(name = "posicao_table", nullable = false)

	private Integer posicao;

	@Column(name = "preco_gasolina", nullable = false)

	private Double gasolina;

	@Column(name = "preco_etanol", nullable = false)

	private Double etanol;
	@Column(name = "bandeira_posto", nullable = false)

	private String bandeira;
	@Column(name = "lat", nullable = false)
	private String latitude;

	@Column(name = "long", nullable = false)
	private String longitude;

	public BuscaPosto(Integer id, String posto, Integer posicao, Double gasolina, Double etanol, String latitude,
			String longitude) {
		this.id = id;
		this.posto = posto;
		this.posicao = posicao;
		this.gasolina = gasolina;
		this.etanol = etanol;
		this.latitude = latitude;
		this.longitude = longitude;

	}

	public BuscaPosto() {

	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPosto() {
		return posto;
	}

	public void setPosto(String posto) {
		this.posto = posto;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

	public Double getGasolina() {
		return gasolina;
	}

	public void setGasolina(Double gasolina) {
		this.gasolina = gasolina;
	}

	public Double getEtanol() {
		return etanol;
	}

	public void setEtanol(Double etanol) {
		this.etanol = etanol;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

}

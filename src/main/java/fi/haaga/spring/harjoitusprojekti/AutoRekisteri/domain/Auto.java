package fi.haaga.spring.harjoitusprojekti.AutoRekisteri.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Auto {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String Merkki;
	private String Malli;	
	private int Vuosimalli;
	private String Hinta;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "polttoaineid")
	private Polttoaine polttoaine;
	
	public Auto() { }		
	
	public Auto(long id, String Merkki, String Malli, int Vuosimalli, String Hinta, Polttoaine polttoaine) {
		super();
		this.id = id;
		this.Merkki = Merkki;
		this.Malli = Malli;
		this.Vuosimalli = Vuosimalli;
		this.Hinta = Hinta;
		this.polttoaine = polttoaine;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMerkki() {
		return Merkki;
	}

	public void setMerkki(String Merkki) {
		this.Merkki = Merkki;
	}

	public String getMalli() {
		return Malli;
	}

	public void setMalli(String Malli) {
		this.Malli = Malli;
	}

	public int getVuosimalli() {
		return Vuosimalli;
	}

	public void setVuosimalli(int Vuosimalli) {
		this.Vuosimalli = Vuosimalli;
	}

	public String getHinta() {
		return Hinta;
	}

	public void setHinta(String Hinta) {
		this.Hinta = Hinta;
	}
	

	public Polttoaine getPolttoaine() {
		return polttoaine;
	}

	public void setPolttoaine(Polttoaine polttoaine) {
		this.polttoaine = polttoaine;
	}
	@Override
	public String toString() {
		if (this.polttoaine != null)
			return "Auto [id=" + id + ", Merkki=" + Merkki + ", Malli=" + Malli + ", Vuosimalli=" + Vuosimalli + ", Hinta=" + Hinta + " Polttoaine =" + this.getPolttoaine()+ "]";
		else 
			return "Auto [id=" + id + ", Merkki=" + Merkki + ", Malli=" + Malli + ", Vuosimalli=" + Vuosimalli + ", Hinta=" + Hinta +  "]";
	}
	
}
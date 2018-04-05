package fi.haaga.spring.harjoitusprojekti.AutoRekisteri.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Polttoaine {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long Polttoaineid;
	private String name;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "polttoaine")
	
	private List<Auto> autos;
	
	public Polttoaine() {}
	
	public Polttoaine(String name) {
		super();
		this.name = name;
	}

	public Long getPolttoaineid() {
		return Polttoaineid;
	}

	public void setPolttoaineid(Long Polttoaineid) {
		this.Polttoaineid = Polttoaineid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Auto> getAutos() {
		return autos;
	}

	public void setAutos(List<Auto> autos) {
		this.autos = autos;
	}
	@Override
	public String toString() {
		return "Polttoaine [Polttoaineid=" +Polttoaineid + ", name=" + name + "]";
	}
}

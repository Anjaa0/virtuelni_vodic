package me.fit.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({ 
    @NamedQuery(name = Tura.GET_ALL_TURE, query = "SELECT tr FROM Tura tr"),
    @NamedQuery(name = Tura.GET_TURA_BY_NAME, query = "SELECT tr FROM Tura tr WHERE tr.naziv = :name") 
})
public class Tura {

    public static final String GET_ALL_TURE = "getAllTure";
    public static final String GET_TURA_BY_NAME = "getTuraByName";
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vodic_seq")
	public Long id;
	public String opis;
	public String naziv;
	public String jezik;
	public double ocjena;
	public int trajanje;
	
	public Tura(String opis, String naziv, String jezik, double ocjena, int trajanje) {
		super();
		this.opis = opis;
		this.naziv = naziv;
		this.jezik = jezik;
		this.ocjena = ocjena;
		this.trajanje = trajanje;
	}
	
	

	public Tura() {
		
	}

	@ManyToMany(mappedBy = "ture")
    private Set<Vodic> vodici = new HashSet<>();


	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getJezik() {
		return jezik;
	}

	public void setJezik(String jezik) {
		this.jezik = jezik;
	}

	public double getOcjena() {
		return ocjena;
	}

	public void setOcjena(double ocjena) {
		this.ocjena = ocjena;
	}

	public int getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((id == null) ? 0 : id.hashCode());
	    return result;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (getClass() != obj.getClass())
	        return false;
	    Vodic other = (Vodic) obj;
	    if (id == null) {
	        if (other.id != null)
	            return false;
	    } else if (!id.equals(other.id))
	        return false;
	    return true;
	}

	
	@Override
	public String toString() {
		return "Tura [id=" + id + ", opis=" + opis + ", naziv=" + naziv + ", jezik=" + jezik + ", ocjena=" + ocjena
				+ ", trajanje=" + trajanje + "]";
	}
	
	
}

package me.fit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name = Turista.GET_ALL_TURISTE, query = "Select t from Turista t"),
	@NamedQuery(name = Turista.GET_TURISTA_BY_NAME, query = "Select t from Turista t where t.ime = :name") 
	})
public class Turista {

	public static final String GET_ALL_TURISTE = "getAllTuriste";
	public static final String GET_TURISTA_BY_NAME = "getTuristaByName";
		
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "vodic_seq")
	public Long id;
	private String ime;
	private String prezime;
	private String email;
	private String korisnickoIme;
	private String sifra;
	
	public Turista(Long id,String ime,String prezime, String email, String korisnickoIme, String sifra) {
		super();
		this.id = id;
		this.ime=ime;
		this.prezime = prezime;
		this.email = email;
		this.korisnickoIme = korisnickoIme;
		this.sifra = sifra;
	}
	public Turista() {
		
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
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
		Turista other = (Turista) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Turista [id=" + id + ", prezime=" + prezime + ", email=" + email + ", korisnickoIme=" + korisnickoIme
				+ ", sifra=" + sifra + "]";
	}
	

}

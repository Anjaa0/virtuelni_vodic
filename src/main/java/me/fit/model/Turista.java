package me.fit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Turista {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "vodic_seq")
	public Long id;
	private String prezime;
	private String email;
	private String korisnickoIme;
	private String sifra;
	
	public Turista(Long id, String prezime, String email, String korisnickoIme, String sifra) {
		super();
		this.id = id;
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
	
	

}

package me.fit.model;


	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

	@Entity
	@NamedQueries({ 
		@NamedQuery(name = Vodic.GET_ALL_VODIC, query = "Select v from Vodic v"),
		@NamedQuery(name = Vodic.GET_VODIC_BY_NAME, query = "Select v from Vodic v where v.ime = :name") 
		})
	public class Vodic {
		
		
		public static final String GET_ALL_VODIC = "getAllVodic";
		public static final String GET_VODIC_BY_NAME = "getVodicByName";

		
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vodic_seq")
		public Long id;
		private String ime;
		private String prezime;
		private String email;
		private String korisnickoIme;
		private String sifra;
		private int rejting;
		private String lokacija;
		
		public Vodic(String ime, String prezime, String email, String korisnickoIme, String sifra, int rejting,
				String lokacija) {
			super();
			this.ime = ime;
			this.prezime = prezime;
			this.email = email;
			this.korisnickoIme = korisnickoIme;
			this.sifra = sifra;
			this.rejting = rejting;
			this.lokacija = lokacija;
		}
		public Vodic() {
			
		}

		public String getIme() {
			return ime;
		}

		public void setIme(String ime) {
			this.ime = ime;
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

		public int getRejting() {
			return rejting;
		}

		public void setRejting(int rejting) {
			this.rejting = rejting;
		}

		public String getLokacija() {
			return lokacija;
		}

		public void setLokacija(String lokacija) {
			this.lokacija = lokacija;
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
			return "Vodic [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", email=" + email + ", korisnickoIme="
					+ korisnickoIme + ", sifra=" + sifra + ", rejting=" + rejting + ", lokacija=" + lokacija + "]";
		}
		

		
		
		
}

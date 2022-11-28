package cars_bd;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the uzytkownik database table.
 * 
 */
@Entity
@NamedQuery(name="Uzytkownik.findAll", query="SELECT u FROM Uzytkownik u")
public class Uzytkownik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_klient")
	private int idKlient;

	private String imie;

	private String login;

	private String nazwisko;

	@Column(name="numer_telefonu")
	private int numerTelefonu;

	private String pass;

	//bi-directional many-to-one association to Rola
	@ManyToOne
	private Rola rola;

	//bi-directional many-to-one association to Wynajem
	@OneToMany(mappedBy="uzytkownik")
	private List<Wynajem> wynajems;

	public Uzytkownik() {
	}

	public int getIdKlient() {
		return this.idKlient;
	}

	public void setIdKlient(int idKlient) {
		this.idKlient = idKlient;
	}

	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public int getNumerTelefonu() {
		return this.numerTelefonu;
	}

	public void setNumerTelefonu(int numerTelefonu) {
		this.numerTelefonu = numerTelefonu;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Rola getRola() {
		return this.rola;
	}

	public void setRola(Rola rola) {
		this.rola = rola;
	}

	public List<Wynajem> getWynajems() {
		return this.wynajems;
	}

	public void setWynajems(List<Wynajem> wynajems) {
		this.wynajems = wynajems;
	}

	public Wynajem addWynajem(Wynajem wynajem) {
		getWynajems().add(wynajem);
		wynajem.setUzytkownik(this);

		return wynajem;
	}

	public Wynajem removeWynajem(Wynajem wynajem) {
		getWynajems().remove(wynajem);
		wynajem.setUzytkownik(null);

		return wynajem;
	}

}
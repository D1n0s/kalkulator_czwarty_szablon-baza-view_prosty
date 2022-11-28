package cars_bd;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the marka database table.
 * 
 */
@Entity
@NamedQuery(name="Marka.findAll", query="SELECT m FROM Marka m")
public class Marka implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_marka")
	private int idMarka;

	@Column(name="nazwa_marki")
	private String nazwaMarki;

	//bi-directional many-to-one association to Samochody
	@OneToMany(mappedBy="marka")
	private List<Samochody> samochodies;

	public Marka() {
	}

	public int getIdMarka() {
		return this.idMarka;
	}

	public void setIdMarka(int idMarka) {
		this.idMarka = idMarka;
	}

	public String getNazwaMarki() {
		return this.nazwaMarki;
	}

	public void setNazwaMarki(String nazwaMarki) {
		this.nazwaMarki = nazwaMarki;
	}

	public List<Samochody> getSamochodies() {
		return this.samochodies;
	}

	public void setSamochodies(List<Samochody> samochodies) {
		this.samochodies = samochodies;
	}

	public Samochody addSamochody(Samochody samochody) {
		getSamochodies().add(samochody);
		samochody.setMarka(this);

		return samochody;
	}

	public Samochody removeSamochody(Samochody samochody) {
		getSamochodies().remove(samochody);
		samochody.setMarka(null);

		return samochody;
	}

}
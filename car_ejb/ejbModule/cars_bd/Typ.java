package cars_bd;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typ database table.
 * 
 */
@Entity
@NamedQuery(name="Typ.findAll", query="SELECT t FROM Typ t")
public class Typ implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_typ")
	private int idTyp;

	@Column(name="nazwa_typ")
	private String nazwaTyp;

	//bi-directional many-to-one association to Samochody
	@OneToMany(mappedBy="typ")
	private List<Samochody> samochodies;

	public Typ() {
	}

	public int getIdTyp() {
		return this.idTyp;
	}

	public void setIdTyp(int idTyp) {
		this.idTyp = idTyp;
	}

	public String getNazwaTyp() {
		return this.nazwaTyp;
	}

	public void setNazwaTyp(String nazwaTyp) {
		this.nazwaTyp = nazwaTyp;
	}

	public List<Samochody> getSamochodies() {
		return this.samochodies;
	}

	public void setSamochodies(List<Samochody> samochodies) {
		this.samochodies = samochodies;
	}

	public Samochody addSamochody(Samochody samochody) {
		getSamochodies().add(samochody);
		samochody.setTyp(this);

		return samochody;
	}

	public Samochody removeSamochody(Samochody samochody) {
		getSamochodies().remove(samochody);
		samochody.setTyp(null);

		return samochody;
	}

}
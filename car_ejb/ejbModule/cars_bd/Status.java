package cars_bd;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the status database table.
 * 
 */
@Entity
@NamedQuery(name="Status.findAll", query="SELECT s FROM Status s")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_status")
	private int idStatus;

	private String status;

	@Lob
	private byte[] typ;

	//bi-directional many-to-one association to Samochody
	@OneToMany(mappedBy="status")
	private List<Samochody> samochodies;

	//bi-directional many-to-one association to Wynajem
	@OneToMany(mappedBy="status")
	private List<Wynajem> wynajems;

	public Status() {
	}

	public int getIdStatus() {
		return this.idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public byte[] getTyp() {
		return this.typ;
	}

	public void setTyp(byte[] typ) {
		this.typ = typ;
	}

	public List<Samochody> getSamochodies() {
		return this.samochodies;
	}

	public void setSamochodies(List<Samochody> samochodies) {
		this.samochodies = samochodies;
	}

	public Samochody addSamochody(Samochody samochody) {
		getSamochodies().add(samochody);
		samochody.setStatus(this);

		return samochody;
	}

	public Samochody removeSamochody(Samochody samochody) {
		getSamochodies().remove(samochody);
		samochody.setStatus(null);

		return samochody;
	}

	public List<Wynajem> getWynajems() {
		return this.wynajems;
	}

	public void setWynajems(List<Wynajem> wynajems) {
		this.wynajems = wynajems;
	}

	public Wynajem addWynajem(Wynajem wynajem) {
		getWynajems().add(wynajem);
		wynajem.setStatus(this);

		return wynajem;
	}

	public Wynajem removeWynajem(Wynajem wynajem) {
		getWynajems().remove(wynajem);
		wynajem.setStatus(null);

		return wynajem;
	}

}
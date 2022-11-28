package cars_bd;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the model database table.
 * 
 */
@Entity
@NamedQuery(name="Model.findAll", query="SELECT m FROM Model m")
public class Model implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_model")
	private int idModel;

	@Column(name="nazwa_model")
	private String nazwaModel;

	//bi-directional many-to-one association to Samochody
	@OneToMany(mappedBy="model")
	private List<Samochody> samochodies;

	public Model() {
	}

	public int getIdModel() {
		return this.idModel;
	}

	public void setIdModel(int idModel) {
		this.idModel = idModel;
	}

	public String getNazwaModel() {
		return this.nazwaModel;
	}

	public void setNazwaModel(String nazwaModel) {
		this.nazwaModel = nazwaModel;
	}

	public List<Samochody> getSamochodies() {
		return this.samochodies;
	}

	public void setSamochodies(List<Samochody> samochodies) {
		this.samochodies = samochodies;
	}

	public Samochody addSamochody(Samochody samochody) {
		getSamochodies().add(samochody);
		samochody.setModel(this);

		return samochody;
	}

	public Samochody removeSamochody(Samochody samochody) {
		getSamochodies().remove(samochody);
		samochody.setModel(null);

		return samochody;
	}

}
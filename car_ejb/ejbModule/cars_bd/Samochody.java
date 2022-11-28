package cars_bd;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the samochody database table.
 * 
 */
@Entity
@NamedQuery(name="Samochody.findAll", query="SELECT s FROM Samochody s")
public class Samochody implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_samochod")
	private int idSamochod;

	private float cena;

	@Column(name="poj_silnika")
	private float pojSilnika;

	private int przebieg;

	@Column(name="rok_prod")
	private int rokProd;

	//bi-directional many-to-one association to Marka
	@ManyToOne
	private Marka marka;

	//bi-directional many-to-one association to Model
	@ManyToOne
	private Model model;

	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="status_wynajmu_id_status")
	private Status status;

	//bi-directional many-to-one association to Typ
	@ManyToOne
	private Typ typ;

	//bi-directional many-to-one association to Wynajem
	@OneToMany(mappedBy="samochody")
	private List<Wynajem> wynajems;

	public Samochody() {
	}

	public int getIdSamochod() {
		return this.idSamochod;
	}

	public void setIdSamochod(int idSamochod) {
		this.idSamochod = idSamochod;
	}

	public float getCena() {
		return this.cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public float getPojSilnika() {
		return this.pojSilnika;
	}

	public void setPojSilnika(float pojSilnika) {
		this.pojSilnika = pojSilnika;
	}

	public int getPrzebieg() {
		return this.przebieg;
	}

	public void setPrzebieg(int przebieg) {
		this.przebieg = przebieg;
	}

	public int getRokProd() {
		return this.rokProd;
	}

	public void setRokProd(int rokProd) {
		this.rokProd = rokProd;
	}

	public Marka getMarka() {
		return this.marka;
	}

	public void setMarka(Marka marka) {
		this.marka = marka;
	}

	public Model getModel() {
		return this.model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Typ getTyp() {
		return this.typ;
	}

	public void setTyp(Typ typ) {
		this.typ = typ;
	}

	public List<Wynajem> getWynajems() {
		return this.wynajems;
	}

	public void setWynajems(List<Wynajem> wynajems) {
		this.wynajems = wynajems;
	}

	public Wynajem addWynajem(Wynajem wynajem) {
		getWynajems().add(wynajem);
		wynajem.setSamochody(this);

		return wynajem;
	}

	public Wynajem removeWynajem(Wynajem wynajem) {
		getWynajems().remove(wynajem);
		wynajem.setSamochody(null);

		return wynajem;
	}

}
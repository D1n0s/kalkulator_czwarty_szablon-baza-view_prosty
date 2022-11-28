package cars_bd;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the wynajem database table.
 * 
 */
@Entity
@NamedQuery(name="Wynajem.findAll", query="SELECT w FROM Wynajem w")
public class Wynajem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_wynajem")
	private int idWynajem;

	@Temporal(TemporalType.DATE)
	@Column(name="data_end")
	private Date dataEnd;

	@Temporal(TemporalType.DATE)
	@Column(name="data_start")
	private Date dataStart;

	//bi-directional many-to-one association to Uzytkownik
	@ManyToOne
	@JoinColumn(name="klient_id_klient")
	private Uzytkownik uzytkownik;

	//bi-directional many-to-one association to Samochody
	@ManyToOne
	private Samochody samochody;

	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="status_wynajmu_id_status")
	private Status status;

	public Wynajem() {
	}

	public int getIdWynajem() {
		return this.idWynajem;
	}

	public void setIdWynajem(int idWynajem) {
		this.idWynajem = idWynajem;
	}

	public Date getDataEnd() {
		return this.dataEnd;
	}

	public void setDataEnd(Date dataEnd) {
		this.dataEnd = dataEnd;
	}

	public Date getDataStart() {
		return this.dataStart;
	}

	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}

	public Uzytkownik getUzytkownik() {
		return this.uzytkownik;
	}

	public void setUzytkownik(Uzytkownik uzytkownik) {
		this.uzytkownik = uzytkownik;
	}

	public Samochody getSamochody() {
		return this.samochody;
	}

	public void setSamochody(Samochody samochody) {
		this.samochody = samochody;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
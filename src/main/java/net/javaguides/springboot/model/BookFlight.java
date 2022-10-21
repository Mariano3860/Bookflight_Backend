package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "book")
public class BookFlight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "origen", nullable = false)
	private String origen;

	@Column(name = "destino", nullable = false)
	private String destino;
	
	@Column(name = "roundTrip", nullable = false)
	private boolean roundTrip;

	@Column(name = "goDate")
	private Date goDate;

	@Column(name = "backDate")
	private Date backDate;

	@Column(name = "price")
	private double price;

	public BookFlight() {
		
	}

	public BookFlight(long id, String origen, String destino, boolean roundTrip, Date goDate, Date backDate, double price) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.roundTrip = roundTrip;
		this.goDate = goDate;
		this.backDate = backDate;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public boolean getRoundTrip() {
		return roundTrip;
	}

	public void setRoundTrip(boolean tripType) {
		this.roundTrip = roundTrip;
	}

	public Date getGoDate() {
		return goDate;
	}

	public void setGoDate(Date goDate) {
		this.goDate = goDate;
	}

	public Date getBackDate() {
		return backDate;
	}

	public void setBackDate(Date backDate) {
		this.backDate = backDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}

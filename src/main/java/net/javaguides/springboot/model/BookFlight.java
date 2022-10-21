package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
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
	private LocalDate goDate;

	@Column(name = "backDate")
	private LocalDate backDate;

	@Column(name = "price")
	private double price;

	public BookFlight() {
		
	}

	public BookFlight(long id, String origen, String destino, boolean roundTrip, LocalDate goDate, LocalDate backDate, double price) {
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

	public LocalDate getGoDate() {
		return goDate;
	}

	public void setGoDate(LocalDate goDate) {
		this.goDate = goDate;
	}

	public LocalDate getBackDate() {
		return backDate;
	}

	public void setBackDate(LocalDate backDate) {
		this.backDate = backDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}

package com.minato.springboot.entityRef;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.minato.springboot.entity.Reservations;

@Entity
@Table(name = "Ref_Payment_Methods")
public class RefPaymentMethods {

	@Column(name = "Payment_Method_Code")
	private int code;
	
	@Column(name = "Payment_Method_Description")
	private String paymentMethodDescription; //eg AMEX = American Express, MC = Master Card

	private Set<Reservations> reservations;
	
	@OneToMany(mappedBy = "refPaymentMethods", cascade = CascadeType.ALL)
	public Set<Reservations> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservations> reservations) {
		this.reservations = reservations;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getPaymentMethodDescription() {
		return paymentMethodDescription;
	}

	public void setPaymentMethodDescription(String paymentMethodDescription) {
		this.paymentMethodDescription = paymentMethodDescription;
	}
}

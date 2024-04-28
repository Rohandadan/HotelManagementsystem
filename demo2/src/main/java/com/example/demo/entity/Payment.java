package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")

public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payment_id;

	@ManyToOne
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Booking booking;

	private String cardHolderName;
	private String cardNumber;
	private String cvv;
	private double amount;
	private Date payment_date;

	public Payment(int payment_id, String card_number, String cvv, double amount, Date payment_date,
			String cardHolderName) {
		super();
		this.payment_id = payment_id;
		this.cardNumber = card_number;
		this.cvv = cvv;
		this.amount = amount;
		this.payment_date = payment_date;
		this.cardHolderName = cardHolderName;
	}

	public Payment() {

	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String card_number) {
		this.cardNumber = card_number;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", card_number=" + cardNumber + ", cvv=" + cvv + ", amount="
				+ amount + ", payment_date=" + payment_date + "]";
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
}

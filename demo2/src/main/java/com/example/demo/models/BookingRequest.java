package com.example.demo.models;
import java.sql.Date;


public class BookingRequest {
	

	private int roomNumber;

	private int totalAmount;
	private String name;
	private Date fromDate;
	private Date toDate;
	private String paymentStatus;
	private String email;
	private String phoneNumber;
	private boolean isAcRoom;
	private int adults;
	private int children;
	
	public BookingRequest() {
		
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean getIsAcRoom() {
		return isAcRoom;
	}

	public void setIsAcRoom(boolean isAcRoom) {
		this.isAcRoom = isAcRoom;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public BookingRequest(int roomNumber, int totalAmount, String name, Date fromDate, Date toDate,
			String paymentStatus, String email, String phoneNumber, boolean isAcRoom, int adults, int children) {
		super();
		this.roomNumber = roomNumber;
		this.totalAmount = totalAmount;
		this.name = name;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.paymentStatus = paymentStatus;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.isAcRoom = isAcRoom;
		this.adults = adults;
		this.children = children;
	}

	public Object getSomeCriteria() {
		// TODO Auto-generated method stub
		return null;
	}


	
}

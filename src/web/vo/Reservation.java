package web.vo;

import java.sql.Date;

public class Reservation {
	private int reservationNo;
	private int campingNo;
	private String memberId;
	private Date reservationDate;
	private int personnel;
	public int getReservationNo() {
		return reservationNo;
	}
	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}
	public int getCampingNo() {
		return campingNo;
	}
	public void setCampingNo(int campingNo) {
		this.campingNo = campingNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	public int getPersonnel() {
		return personnel;
	}
	public void setPersonnel(int personnel) {
		this.personnel = personnel;
	}
	@Override
	public String toString() {
		return "Reservation [reservationNo=" + reservationNo + ", campingNo=" + campingNo + ", memberId=" + memberId
				+ ", reservationDate=" + reservationDate + ", personnel=" + personnel + "]";
	}
	
}

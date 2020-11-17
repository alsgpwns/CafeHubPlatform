package com.www.hj.DTO.Board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DTOWriteOwner  {
	private String cafeName;
	private String cafeNumber;
	private String cafeReprePicture;
	private String cafePrice;
	private String cafeParking;
	private String cafeHours;
	private String cafeBreakeTime;
	private String CafeLastorder;
	private String CafeIntroduce;
	private String CafeHashTag;
	private String CafeMenu1;
	private String CafeMenu2;
	private String CafeMenu3;
	private String cafePicture1;
	private String cafePicture2;
	private String cafePicture3;
	private String cafePicture4;
	private String cafePicture5;
	private String cafePicture6;
	private String cafePicture7;
	private String cafeMenu;
	private String id;
	private int report;
	private String cafeAddress;
	private int like;
	private int reviews;
	
	public String getcafeAddress() {
		return cafeAddress;
	}
	public void setcafeAddress(String cafeAddress) {
		this.cafeAddress = cafeAddress;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public int getReviews() {
		return reviews;
	}
	public void setReviews(int reviews) {
		this.reviews = reviews;
	}
	public String getCafeReprePicture() {
		return cafeReprePicture;
	}
	public void setCafeReprePicture(String cafeReprePicture) {
		this.cafeReprePicture = cafeReprePicture;
	}
	public String getCafeMenu() {
		return cafeMenu;
	}
	public void setCafeMenu(String cafeMenu) {
		this.cafeMenu = cafeMenu;
	}
	
	public String getCafeName() {
		return cafeName;
	}
	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}
	public String getCafeNumber() {
		return cafeNumber;
	}
	public void setCafeNumber(String cafeNumber) {
		this.cafeNumber = cafeNumber;
	}
	public String getCafePrice() {
		return cafePrice;
	}
	public void setCafePrice(String cafePrice) {
		this.cafePrice = cafePrice;
	}
	public String getCafeParking() {
		return cafeParking;
	}
	public void setCafeParking(String cafeParking) {
		this.cafeParking = cafeParking;
	}
	public String getCafeHours() {
		return cafeHours;
	}
	public void setCafeHours(String cafeHours) {
		this.cafeHours = cafeHours;
	}
	public String getCafeBreakeTime() {
		return cafeBreakeTime;
	}
	public void setCafeBreakeTime(String cafeBreakeTime) {
		this.cafeBreakeTime = cafeBreakeTime;
	}
	public String getCafeLastorder() {
		return CafeLastorder;
	}
	public void setCafeLastorder(String cafeLastorder) {
		CafeLastorder = cafeLastorder;
	}
	public String getCafeIntroduce() {
		return CafeIntroduce;
	}
	public void setCafeIntroduce(String cafeIntroduce) {
		CafeIntroduce = cafeIntroduce;
	}
	public String getCafeHashTag() {
		return CafeHashTag;
	}
	public void setCafeHashTag(String cafeHashTag) {
		CafeHashTag = cafeHashTag;
	}
	public String getCafeMenu1() {
		return CafeMenu1;
	}
	public void setCafeMenu1(String cafeMenu1) {
		CafeMenu1 = cafeMenu1;
	}
	public String getCafeMenu2() {
		return CafeMenu2;
	}
	public void setCafeMenu2(String cafeMenu2) {
		CafeMenu2 = cafeMenu2;
	}
	public String getCafeMenu3() {
		return CafeMenu3;
	}
	public void setCafeMenu3(String cafeMenu3) {
		CafeMenu3 = cafeMenu3;
	}
	public String getCafePicture1() {
		return cafePicture1;
	}
	public void setCafePicture1(String cafePicture1) {
		this.cafePicture1 = cafePicture1;
	}
	public String getCafePicture2() {
		return cafePicture2;
	}
	public void setCafePicture2(String cafePicture2) {
		this.cafePicture2 = cafePicture2;
	}
	public String getCafePicture3() {
		return cafePicture3;
	}
	public void setCafePicture3(String cafePicture3) {
		this.cafePicture3 = cafePicture3;
	}
	public String getCafePicture4() {
		return cafePicture4;
	}
	public void setCafePicture4(String cafePicture4) {
		this.cafePicture4 = cafePicture4;
	}
	public String getCafePicture5() {
		return cafePicture5;
	}
	public void setCafePicture5(String cafePicture5) {
		this.cafePicture5 = cafePicture5;
	}
	public String getCafePicture6() {
		return cafePicture6;
	}
	public void setCafePicture6(String cafePicture6) {
		this.cafePicture6 = cafePicture6;
	}
	public String getCafePicture7() {
		return cafePicture7;
	}
	public void setCafePicture7(String cafePicture7) {
		this.cafePicture7 = cafePicture7;
	}
	public int getReport() {
		return report;
	}
	public void setReport(int report) {
		this.report = report;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	

}

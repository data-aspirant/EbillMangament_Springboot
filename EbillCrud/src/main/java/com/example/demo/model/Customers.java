package com.example.demo.model;

import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import 	jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class Customers {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="consumer_number")
	private String consumerNumber;
	@Column(name="bill_number")
    private String billNumber;
	@Column(name="title")
    private String title;
	@Column(name="email")
    private String email;
	@Column(name="name")
    private String name;
	@Column(name="mobile_code")
    private String mobileCode;
	@Column(name="mobile_number")
    private String mobileNumber;
	@Column(name="userid")
    private String userId;
	@Column(name="password")
    private String password;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getConsumerNumber() {
		return consumerNumber;
	}
	public void setConsumerNumber(String consumerNumber) {
		this.consumerNumber = consumerNumber;
	}
	public String getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
    private String generateConsumerNumber() {
        // Generate a 13-digit consumer number (you can customize the generation logic here)
        String consumerNumber = generateRandomNumber(13);
        return consumerNumber;
    }

    private String generateBillNumber() {
        // Use the last 5 digits of the consumer number as bill number
        return consumerNumber.substring(consumerNumber.length() - 5);
    }

    private String generateRandomNumber(int length) {
        // Generate a random number of specified length (for demonstration purposes)
        // You should replace this logic with a more suitable generation method.
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileCode() {
		return mobileCode;
	}
	public void setMobileCode(String mobileCode) {
		this.mobileCode = mobileCode;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@PrePersist
    private void generateUserId() {
        // Generate 5-digit random number
        Random random = new Random();
        int randomNumber = 10000 + random.nextInt(90000); // Generates a number between 10000 and 99999
        this.userId = String.valueOf(randomNumber);
        this.consumerNumber = generateConsumerNumber();
        this.billNumber = generateBillNumber();
    }
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customers [id=" + id + ", consumerNumber=" + consumerNumber + ", billNumber=" + billNumber + ", title="
				+ title + ", email=" + email + ", name=" + name + ", mobileCode=" + mobileCode + ", mobileNumber="
				+ mobileNumber + ", userId=" + userId + ", password=" + password + "]";
	}
    
    
}

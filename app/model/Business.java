package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="m_business")
public class Business {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	Long id;
	
	@Column(name="name",nullable=false)
	String name;
	
	@Column(name="address",nullable=false)
	String address;
	
	@Column(name="city",nullable=false)
	String city;
	
	@Column(name="state",nullable=false)
	String state;
	
	@Column(name="postal_code",nullable=false)
	String postCode;
	
	@Column(name="latitude",nullable=false)
	Float latitude;
	
	@Column(name="longtitude",nullable=false)
	Float longitude;
	
	@Column(name="phone")
	String phone;
	
	@Column(name="application_date")
	Date appDate;

	@Column(name="owner_name")
	String ownerName;
	
	@Column(name="category")
	Long cat;
	
	@Column(name="note")
	String note;
	
	@Column(name="active", nullable=false)
	Boolean active;
	
	@Column(name="virtual", nullable=false)
	Boolean virtual;
	
	@Column(name="last_update", nullable=false)
	Date lastUpdate;
	
}

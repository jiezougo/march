package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@javax.persistence.Entity
@Table(name="m_business")
public class Business {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Long id;
	
	@Column(name="name",nullable=false)
	public String name;
	
	@Column(name="address",nullable=false)
	public String address;
	
	@Column(name="city",nullable=false)
	public String city;
	
	@Column(name="state",nullable=false)
	public String state;
	
	@Column(name="postal_code",nullable=false)
	public String postCode;
	
	@Column(name="latitude",nullable=false)
	public Double latitude;
	
	@Column(name="longtitude",nullable=false)
	public Double longitude;
	
	@Column(name="phone")
	public String phone;
	
	@Column(name="application_date")
	public Date appDate;

	@Column(name="owner_name")
	public String ownerName;
	
	@Column(name="category")
	public Long cat;
	
	@Column(name="note")
	public String note;
	
	@Column(name="active", nullable=false)
	public Boolean active;
	
	@Column(name="virtual", nullable=false)
	public Boolean virtual;
	
	@Column(name="last_update", nullable=false)
	public Date lastUpdate;
	
	@Transient
	public double dist;
	
}

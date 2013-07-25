package model;

import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@javax.persistence.Entity
@Table(name="m_user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Long id;
	
	@Column(name="first_name", nullable=false)
	public String fName;
	
	@Column(name="last_name", nullable=false)
	public String lName;
	
	@Column(name="email", nullable=false)
	public String email;
	
	@Column(name="password",nullable=false)
	public String pwd;
	
	
	

}

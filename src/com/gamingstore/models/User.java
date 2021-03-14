package com.gamingstore.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;


public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@NotEmpty(message = "Username is a required field")
    @Size(min = 1, message = " Username is a required field")
	private String username;
    
    //@NotEmpty(message = "Password is a required field")
    @Size(min = 1, message = " Password is a required field")
	private String password;
    
	//@NotEmpty(message = "First name is a required field")
    @Size(min = 1, message = " First name is a required field")
	private String firstname;
	
	//@NotEmpty(message = "Last name is a required field")
    @Size(min = 1, message = " Last name is a required field")
	private String lastname;

    @Size(min = 1, message = " Email is a required field")
	private String email;

	@Size(min = 10, message = " Phone number should be {min} consecutive digits")
	private String phonenumber;
	
	public User() {
		super();
		this.id = 0;
		this.username = "";
		this.password = "";
		this.firstname = "";
		this.lastname = "";
		this.email = "";
		this.phonenumber = "";
	}
	
	public User(Integer id, String username, String password, String firstname, String lastname, String email,
			String phonenumber) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phonenumber = phonenumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
	    return username;
	}

	public void setUsername(String username) {
	    this.username = username;
	}

	public String getPassword() {
	    return password;
	}

	public void setPassword(String password) {
	    this.password = password;
	}

	public String getFirstname() {
	    return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	  }

	public String getLastname() {
	    return lastname;
	}

	public void setLastname(String lastname) {
	    this.lastname = lastname;
	}

	public String getEmail() {
	    return email;
	}

	public void setEmail(String email) {
	    this.email = email;
	}


	public String getPhonenumber() {
	    return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
	    this.phonenumber = phonenumber;
	}
}

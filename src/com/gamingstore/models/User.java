package com.gamingstore.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;


/**User object used to store user information.*/
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
	
	/**User constructor to set default values.*/
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
	
	/**User constructor that takes arguments.*/
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

	/**Method used to get the user ID.*/
	public Integer getId() {
		return id;
	}

	/**Method used to set the user ID.*/
	public void setId(Integer id) {
		this.id = id;
	}

	/**Method used to get the user username.*/
	public String getUsername() {
	    return username;
	}

	/**Method used to set the user username.*/
	public void setUsername(String username) {
	    this.username = username;
	}

	/**Method used to get the user password.*/
	public String getPassword() {
	    return password;
	}

	/**Method used to set the user password.*/
	public void setPassword(String password) {
	    this.password = password;
	}

	/**Method used to get the user first name.*/
	public String getFirstname() {
	    return firstname;
	}

	/**Method used to set the user first name.*/
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	  }

	/**Method used to get the user last name.*/
	public String getLastname() {
	    return lastname;
	}

	/**Method used to set the user last name.*/
	public void setLastname(String lastname) {
	    this.lastname = lastname;
	}

	/**Method used to get the user email.*/
	public String getEmail() {
	    return email;
	}

	/**Method used to set the user email.*/
	public void setEmail(String email) {
	    this.email = email;
	}

	/**Method used to get the user phone number.*/
	public String getPhonenumber() {
	    return phonenumber;
	}

	/**Method used to set the user phone number.*/
	public void setPhonenumber(String phonenumber) {
	    this.phonenumber = phonenumber;
	}
}

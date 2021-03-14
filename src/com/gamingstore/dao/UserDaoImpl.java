package com.gamingstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.gamingstore.models.User;

public class UserDaoImpl implements UserDao {
 // import data source
  @Autowired
  DataSource datasource;
 // import jbdc template
  @Autowired
  JdbcTemplate jdbcTemplate;

  public int register(User user) {
    String sql="insert into gaming_db.users(username, password, firstname, lastname, email, phonenumber) VALUES ('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getFirstname()+"','"+user.getLastname()+"','"+user.getEmail()+"','"+user.getPhonenumber()+"')";  
    return jdbcTemplate.update(sql);
  }
  /*
   * Method to check if user is registered
   *
   */
  public boolean checkRegister(User user) {
	  // sql query
	  String sql="select * from gaming_db.users where username='" + user.getUsername() +"'";
	  // make list of users from query
	  List<User> users = jdbcTemplate.query(sql, new UserMapper());
	  // if user list size is greater than 0 return true the user is registered else return false
	  if(users.size() > 0)
	  {
		  return true;
	  }
	  return false;
  }
  /*
   * Method to validate the user
   * 
   */
  public User validateUser(User user) {
	  // sql query
    String sql = "select * from gaming_db.users where username='" + user.getUsername() + "' and password='" + user.getPassword()
        + "'";
    // make a list of users from the query
    List<User> users = jdbcTemplate.query(sql, new UserMapper());
    // if the user size is greater than 0 return the first user in the list as a model
    return users.size() > 0 ? users.get(0) : null;
  }
  
  //Returns a list of users in the database.
  public List<User> getUsers() {
	  String sql="select * from gaming_db.users";
	  List<User> users = jdbcTemplate.query(sql, new UserMapper());
	  return users;
  }  
  

}

//use the RowMapper implementation to iterate the ResultSet and add it into the collection.
class UserMapper implements RowMapper<User> {

  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();

    user.setUsername(rs.getString("username"));
    user.setPassword(rs.getString("password"));
    user.setFirstname(rs.getString("firstname"));
    user.setLastname(rs.getString("lastname"));
    user.setEmail(rs.getString("email"));
    user.setPhonenumber(rs.getString("phonenumber"));

    return user;
  }
}
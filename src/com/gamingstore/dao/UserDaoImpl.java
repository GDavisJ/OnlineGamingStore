package com.gamingstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

  public int register(User user) {
		logger.info("Entering UserDaoImpl.register");
    String sql="insert into gaming_db.users(username, password, firstname, lastname, email, phonenumber) VALUES ('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getFirstname()+"','"+user.getLastname()+"','"+user.getEmail()+"','"+user.getPhonenumber()+"')";
	logger.info("Leaving UserDaoImpl.register");
    return jdbcTemplate.update(sql);
  }
  /*
   * Method to check if user is registered
   *
   */
  public boolean checkRegister(User user) {
		logger.info("Entering UserDaoImpl.checkRegister");
	  // sql query
	  String sql="select * from gaming_db.users where username='" + user.getUsername() +"'";
	  // make list of users from query
	  List<User> users = jdbcTemplate.query(sql, new UserMapper());
	  // if user list size is greater than 0 return true the user is registered else return false
	  if(users.size() > 0)
	  {
			logger.info("Leaving UserDaoImpl.checkRegister");
		  return true;
	  }
		logger.info("Leaving UserDaoImpl.checkRegister");
	  return false;
  }
  /*
   * Method to validate the user
   * 
   */
  public User validateUser(User user) {
		logger.info("Entering UserDaoImpl.validateUser");
	  // sql query
    String sql = "select * from gaming_db.users where username='" + user.getUsername() + "' and password='" + user.getPassword()
        + "'";
    // make a list of users from the query
    List<User> users = jdbcTemplate.query(sql, new UserMapper());
    // if the user size is greater than 0 return the first user in the list as a model
	logger.info("Leaving UserDaoImpl.validateUser");
    return users.size() > 0 ? users.get(0) : null;
  }
  
  //Returns a list of users in the database.
  public List<User> getUsers() {
		logger.info("Entering UserDaoImpl.getUsers");
	  String sql="select * from gaming_db.users";
	  List<User> users = jdbcTemplate.query(sql, new UserMapper());
		logger.info("Leaving UserDaoImpl.getUsers");
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
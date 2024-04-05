package com.techymeet.SpringbootRepositorycurd.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="user")
public class UserVo {
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int userId;
	    private String firstName;
	    private String lastName;
	    private String emailId;
		private long mobileNumber;

}

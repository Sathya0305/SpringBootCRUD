package com.techymeet.SpringbootRepositorycurd.Bo;

import lombok.Data;

@Data
public class UserBo {
	private int userId;
    private String firstName;
    private String lastName;
    private String emailId;
	private long mobileNumber;
	

}

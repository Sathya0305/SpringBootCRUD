package com.techymeet.SpringbootRepositorycurd.Service;

import java.util.List;
import com.techymeet.SpringbootRepositorycurd.Bo.UserBo;
import com.techymeet.SpringbootRepositorycurd.Entity.UserVo;
public interface UserService {

	UserBo createuser(UserBo userbo);

	List<UserVo> getuser();

	UserBo updateuser(UserBo userBo);

	int deleteuser(int id);

	List<UserBo> searchByUserName(String name);

	List<UserBo> findByName(String name);

	UserBo getUserById(int id);


}

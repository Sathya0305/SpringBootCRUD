package com.techymeet.SpringbootRepositorycurd.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.techymeet.SpringbootRepositorycurd.Bo.UserBo;
import com.techymeet.SpringbootRepositorycurd.Entity.UserVo;
import com.techymeet.SpringbootRepositorycurd.Repository.UserRepository;

@Service
@Transactional

public class UserServiceImpl implements UserService{
@Autowired 
private UserRepository userRepository;
	@Override
	public UserBo createuser(UserBo userbo) {
	
		UserVo userVo=new UserVo();
		BeanUtils.copyProperties(userbo, userVo);
		userVo=userRepository.save(userVo);
		BeanUtils.copyProperties(userVo, userbo);
		return userbo;
	}
	@Override
	public List<UserVo> getuser() {
	
		List<UserVo> list=new ArrayList<>();
		list=userRepository.findAll();
		return list;
	}
	@Override
	public UserBo updateuser(UserBo userBo) {
		UserVo userVo=new UserVo();		
		BeanUtils.copyProperties(userBo, userVo);
		userVo=userRepository.save(userVo);
		userBo.setUserId(userVo.getUserId());
		BeanUtils.copyProperties(userVo, userBo);

		return userBo;
	}
	@Override
	public int deleteuser(int id) {
		UserVo userVo=new UserVo();		
		userVo=userRepository.findById(id).get();
		if(null!=userVo) {
			userRepository.delete(userVo);
			return userVo.getUserId();
		}
		return 0;
	}
	@Override
	public List<UserBo> searchByUserName(String name) {
		List<UserVo> list=null;
		List<UserBo> userList=new ArrayList<UserBo>();
		try {
		list=userRepository.searchByUserName(name);
		if(null!=list && !list.isEmpty() &&list.size()>0) {
			for(UserVo uservo:list) {
				UserBo userBo=new UserBo();
				BeanUtils.copyProperties(uservo, userBo);
				userList.add(userBo);
			}
			return userList;
		}
	}catch (Exception e) {
		e.printStackTrace();
	}
		
		return null;
	}
	@Override
	public List<UserBo> findByName(String name) {
		List<UserVo> list=null;
		List<UserBo> userList=new ArrayList<UserBo>();
		try {
		list=userRepository.findByfirstName(name);
		if(null!=list && !list.isEmpty() &&list.size()>0) {
			for(UserVo uservo:list) {
				UserBo userBo=new UserBo();
				BeanUtils.copyProperties(uservo, userBo);
				userList.add(userBo);
			}
			return userList;
		}
	}catch (Exception e) {
		e.printStackTrace();
	}
		
		return null;
	}
	@Override
	public UserBo getUserById(int id) {
		UserVo userVo=new UserVo();
		try {
			userVo=userRepository.findById(id).get();
			if(null!=userVo) {
				UserBo userBo=new UserBo();
				BeanUtils.copyProperties(userVo, userBo);
				return userBo;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	}

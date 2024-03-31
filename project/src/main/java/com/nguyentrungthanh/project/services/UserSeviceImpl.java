package com.nguyentrungthanh.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyentrungthanh.project.models.User;
import com.nguyentrungthanh.project.repository.UserRepository;

@Service
public class UserSeviceImpl implements UserSevice{
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(userName);
	}

}

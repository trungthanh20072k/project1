package com.nguyentrungthanh.project.services;

import com.nguyentrungthanh.project.models.User;

public interface UserSevice {
	User findByUserName(String userName);
}

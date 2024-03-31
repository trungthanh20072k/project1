package com.nguyentrungthanh.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyentrungthanh.project.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserName(String userName);
}

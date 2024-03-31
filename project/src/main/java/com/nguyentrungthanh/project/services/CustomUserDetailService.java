package com.nguyentrungthanh.project.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nguyentrungthanh.project.models.CustomUserDetails;
import com.nguyentrungthanh.project.models.User;
import com.nguyentrungthanh.project.models.UserRole;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserSevice userSevice;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userSevice.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("Sai");
		}
		Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
		
		Set<UserRole> roles = user.getUserRoles();
		
		for (UserRole userRole : roles) {
			grantedAuthoritySet.add(new SimpleGrantedAuthority(userRole.getRole().getName()));
		}
		return new CustomUserDetails(user, grantedAuthoritySet);
	}

}

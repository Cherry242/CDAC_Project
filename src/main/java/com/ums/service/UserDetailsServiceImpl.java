package com.ums.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.ums.repository.UserRepository;
import com.ums.entity.User;
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository UserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=UserRepository.getUserByUserName(username);
		if(user==null) {
			throw new UsernameNotFoundException("Could not Found User!!");
		}
		CustomUserDetails customUserDetails=new CustomUserDetails(user);
		
		
		return customUserDetails;
	}

}

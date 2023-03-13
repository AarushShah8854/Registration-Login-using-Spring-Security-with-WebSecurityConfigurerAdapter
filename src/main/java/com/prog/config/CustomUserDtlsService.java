package com.prog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.prog.entity.UserDtls;
import com.prog.repository.UserRepository;

public class CustomUserDtlsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
				
		try {
			UserDtls u = userRepository.findByEmail(email);
			System.out.println(u);
			if(u==null) {
				throw new UsernameNotFoundException("No User");
			} else {
				return new CustomUserDtls(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

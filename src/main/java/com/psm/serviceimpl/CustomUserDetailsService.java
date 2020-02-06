package com.psm.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.psm.daoapi.DaoApi;
import com.psm.entities.UserBean;
import com.psm.entities.UserRole;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private DaoApi dao;

	protected final static Log log = LogFactory.getLog(CustomUserDetailsService.class);

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserBean user = dao.getUserByUsername(username);

		if (user == null) {
			log.info("***User not found***");
			throw new UsernameNotFoundException("Username not found");
		}

		List<GrantedAuthority> authorities = getGrantedAuthorities(user.getRoles());
		boolean isEnabled = true;
		return new User(user.getUserUserName(), user.getUserPassword(), isEnabled,
				true, true, true, authorities);
	}

	private List<GrantedAuthority> getGrantedAuthorities(Set<UserRole> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
        for(UserRole userProfile : roles){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getRoleId()));
        }
        log.info(authorities);
        return authorities;
	}

}

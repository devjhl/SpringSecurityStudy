package com.dev.springsecurity.auth;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dev.springsecurity.model.User;

//login後security session(Security ContextHolder)に入れるたの
//Object　=> Authentication Type Object
// Authentication中にUser情報がいなければならない
// UserObjectType　=> UserDetails Type object

// Security Session => Authentication => UserDetails(PrincipalDetails)
public class PrincipalDetails implements UserDetails{
	
	private User user; 
	
	public PrincipalDetails(User user) {
		this.user = user;
	}
	
	//該当Userの権限をreturn
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList<>();
		collect.add(()->{
			return user.getRole();
		});
		return collect;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}

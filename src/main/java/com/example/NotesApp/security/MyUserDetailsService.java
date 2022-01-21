package com.example.NotesApp.security;


import com.example.NotesApp.security.model.MyUserDetails;
import com.example.NotesApp.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService
{
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername( String userName ) throws UsernameNotFoundException
	{
		Optional< User > user = userRepository.findByUserName( userName );

		user.orElseThrow( () -> new UsernameNotFoundException( "Not found: " + userName ) );

		return user.map( MyUserDetails::new ).get();
	}

	public void register( User aUser )
	{
		userRepository.save( aUser );
	}
}

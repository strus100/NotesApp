package com.example.NotesApp;

import com.example.NotesApp.security.UserRepository;
import com.example.NotesApp.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner
{
	private UserRepository userRepository;

	@Autowired
	public DataLoader( UserRepository userRepository )
	{
		this.userRepository = userRepository;
	}

	public void run( ApplicationArguments args )
	{
		User superUser = new User( 1,"admin",new BCryptPasswordEncoder().encode( "admin" ),true,"ADMIN" );
		if( !userRepository.findAll().contains( superUser ) )
		{
			userRepository.save( superUser );
		}
	}
}

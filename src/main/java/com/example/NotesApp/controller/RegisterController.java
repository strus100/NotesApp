package com.example.NotesApp.controller;

import com.example.NotesApp.security.MyUserDetailsService;
import com.example.NotesApp.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController
{
	@Autowired
	MyUserDetailsService userDetailsService;

	@PostMapping( "/register" )
	public void register(@RequestBody User aUser )
	{
		userDetailsService.register( aUser );
	}

}

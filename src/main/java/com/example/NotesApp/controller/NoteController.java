package com.example.NotesApp.controller;

import com.example.NotesApp.model.Note;
import com.example.NotesApp.service.NoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoteController
{
	private final NoteService noteService;

	public NoteController( NoteService aNoteService )
	{
		noteService = aNoteService;
	}

	@GetMapping( "/notes" )
	public List< Note > findNotes()
	{
		return noteService.findNotes();
	}

	@PostMapping( "/addNote" )
	public void addNote( @RequestBody Note aNote )
	{
		noteService.addNote( aNote );
	}

}

package com.example.NotesApp.controller;

import com.example.NotesApp.model.Note;
import com.example.NotesApp.service.NoteService;
import org.springframework.web.bind.annotation.*;

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

	@PutMapping( "/editNote" )
	public void editNote( @RequestBody Note aNote )
	{
		noteService.editNote( aNote );
	}

	@DeleteMapping( "/deleteNote" )
	public void deleteNote( @RequestParam int aId )
	{
		noteService.deleteNote( aId );
	}

}

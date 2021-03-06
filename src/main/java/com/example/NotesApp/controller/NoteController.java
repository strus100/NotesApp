package com.example.NotesApp.controller;

import com.example.NotesApp.model.Note;
import com.example.NotesApp.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
public class NoteController
{
	private final NoteService noteService;

	public NoteController( NoteService aNoteService )
	{
		noteService = aNoteService;
	}

	@GetMapping( "/" )
	public List< Note > findNotes()
	{
		return noteService.findNotes();
	}

	@GetMapping( "/{aId}" )
	public Optional< Note > findNoteById( @PathVariable int aId )
	{
		return noteService.findNote( aId );
	}

	@PostMapping( "/addNote" )
	public int addNote( @RequestBody Note aNote )
	{
		Note note = noteService.addNote( aNote );
		return note.getId();
	}

	@PutMapping( "/editNote" )
	public void editNote( @RequestBody Note aNote )
	{
		noteService.editNote( aNote );
	}

	@DeleteMapping( "/deleteNote/{aId}" )
	public void deleteNote( @PathVariable int aId )
	{
		noteService.deleteNote( aId );
	}
}

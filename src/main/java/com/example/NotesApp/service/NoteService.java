package com.example.NotesApp.service;

import com.example.NotesApp.model.Note;
import com.example.NotesApp.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService
{
	/* USE THAT IF YOU DON'T HAVE DATABASE INSTALLED YET
	private final TestNoteRepository noteRepository;
	public NoteService()
	{
		noteRepository = new TestNoteRepository();
	}
*/

	private final NoteRepository noteRepository;

	public NoteService( NoteRepository aNoteRepository )
	{
		noteRepository = aNoteRepository;
	}

	public List< Note > findNotes()
	{
		return noteRepository.findAll();
	}

	public Optional< Note > findNote( int aId )
	{
		return noteRepository.findById( aId );
	}

	public Note addNote( Note aNote )
	{
		return noteRepository.save( aNote );
	}

	public void editNote( Note aNote )
	{
		Optional< Note > oldNote = noteRepository.findById( aNote.getId() );
		oldNote.ifPresent( note -> {
			note.setTitle( aNote.getTitle() );
			note.setContent( aNote.getContent() );
			noteRepository.save( note );
		} );
	}

	public void deleteNote( int aId )
	{
		noteRepository.deleteById( aId );
	}

}

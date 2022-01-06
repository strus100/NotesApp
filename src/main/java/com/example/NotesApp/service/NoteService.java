package com.example.NotesApp.service;

import com.example.NotesApp.model.Note;
import com.example.NotesApp.repository.NoteRepository;
import com.example.NotesApp.repository.TestNoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

	public void addNote( Note aNote )
	{
		noteRepository.save( aNote );
	}

}

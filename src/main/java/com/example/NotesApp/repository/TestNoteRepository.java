package com.example.NotesApp.repository;

import com.example.NotesApp.model.Note;

import java.util.LinkedList;
import java.util.List;

public class TestNoteRepository
{
	private final LinkedList< Note >  repo;

	public TestNoteRepository()
	{
		repo = new LinkedList<>();
		repo.add( new Note( 0, "TEST", "TEST") );
	}

	public List< Note > findAll()
	{
		return repo;
	}

	public void save( Note aNote )
	{
		repo.add( aNote );
	}
}

package com.example.NotesApp.repository;

import com.example.NotesApp.model.Note;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class TestNoteRepository implements NoteRepository
{
	private final LinkedList< Note > repo;

	public TestNoteRepository()
	{
		repo = new LinkedList<>();
	}

	public List< Note > findAll()
	{
		return repo;
	}

	@Override
	public List< Note > findAll( Sort sort )
	{
		return null;
	}

	@Override
	public Page< Note > findAll( Pageable pageable )
	{
		return null;
	}

	@Override
	public List< Note > findAllById( Iterable< Integer > integers )
	{
		return null;
	}

	@Override
	public long count()
	{
		return 0;
	}

	@Override
	public void deleteById( Integer integer )
	{
		repo.remove( integer );
	}

	@Override
	public void delete( Note entity )
	{
		repo.remove( entity );
	}

	@Override
	public void deleteAllById( Iterable< ? extends Integer > integers )
	{

	}

	@Override
	public void deleteAll( Iterable< ? extends Note > entities )
	{

	}

	@Override
	public void deleteAll()
	{

	}

	@Override
	public < S extends Note > S save( S entity )
	{
		repo.add( entity );
		return entity;
	}

	@Override
	public < S extends Note > List< S > saveAll( Iterable< S > entities )
	{
		return null;
	}

	@Override
	public Optional< Note > findById( Integer integer )
	{
		return Optional.empty();
	}

	@Override
	public boolean existsById( Integer integer )
	{
		return false;
	}

	@Override
	public void flush()
	{

	}

	@Override
	public < S extends Note > S saveAndFlush( S entity )
	{
		return null;
	}

	@Override
	public < S extends Note > List< S > saveAllAndFlush( Iterable< S > entities )
	{
		return null;
	}

	@Override
	public void deleteAllInBatch( Iterable< Note > entities )
	{

	}

	@Override
	public void deleteAllByIdInBatch( Iterable< Integer > integers )
	{

	}

	@Override
	public void deleteAllInBatch()
	{

	}

	@Override
	public Note getOne( Integer integer )
	{
		return null;
	}

	@Override
	public Note getById( Integer integer )
	{
		return null;
	}

	@Override
	public < S extends Note > Optional< S > findOne( Example< S > example )
	{
		return Optional.empty();
	}

	@Override
	public < S extends Note > List< S > findAll( Example< S > example )
	{
		return null;
	}

	@Override
	public < S extends Note > List< S > findAll( Example< S > example,Sort sort )
	{
		return null;
	}

	@Override
	public < S extends Note > Page< S > findAll( Example< S > example,Pageable pageable )
	{
		return null;
	}

	@Override
	public < S extends Note > long count( Example< S > example )
	{
		return 0;
	}

	@Override
	public < S extends Note > boolean exists( Example< S > example )
	{
		return false;
	}

	@Override
	public < S extends Note,R > R findBy( Example< S > example,
										  Function< FluentQuery.FetchableFluentQuery< S >, R > queryFunction )
	{
		return null;
	}
}

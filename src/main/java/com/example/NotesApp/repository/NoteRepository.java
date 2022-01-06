package com.example.NotesApp.repository;

import com.example.NotesApp.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository< Note, Integer>
{
}

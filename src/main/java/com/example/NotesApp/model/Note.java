package com.example.NotesApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
@AllArgsConstructor
public class Note
{
	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String content;
}

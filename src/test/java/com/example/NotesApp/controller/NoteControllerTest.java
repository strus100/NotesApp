package com.example.NotesApp.controller;

import com.example.NotesApp.model.Content;
import com.example.NotesApp.model.Note;
import com.example.NotesApp.repository.NoteRepository;
import com.example.NotesApp.repository.TestNoteRepository;
import com.example.NotesApp.service.NoteService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Make sure that you have NotesAppTest db created.
 */
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(
		locations = "classpath:application-test.properties")
class NoteControllerTest
{
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private NoteService service;

	@Test
	public void shouldBlockAccessWithNoAuthorization() throws Exception
	{
		mockMvc.perform( get( "/api/notes/" ) )
				.andExpect( status().is( 401 ) );
	}

	@Test
	@WithMockUser(username = "admin", password = "admin", authorities = "ADMIN")
	public void shouldGrandAccessWithAuthorization() throws Exception
	{
		mockMvc.perform( get( "/api/notes/" ) )
				.andExpect( status().is( 200 ) );
	}

	@Test
	@WithMockUser(username = "admin", password = "admin", authorities = "ADMIN")
	public void shouldGrandAccessWithAuthorization2() throws Exception
	{
		String json =
				"""
				 {
					 "id": 0,
					 "title": "TEST",
					 "content": "TEST"
				 }
				 """;

		MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", java.nio.charset.Charset.forName("UTF-8"));
		MockHttpServletRequestBuilder request = post("/api/notes/addNote");
		request.content(json);
		request.locale( Locale.ENGLISH);
		request.accept(MEDIA_TYPE_JSON_UTF8);
		request.contentType(MEDIA_TYPE_JSON_UTF8);

		mockMvc.perform( request ).andExpect( status().is( 200 ) );
		assertFalse( service.findNotes().isEmpty() );
	}

	@Test
	@WithMockUser(username = "admin", password = "admin", authorities = "ADMIN")
	public void shouldGrandAccessWithAuthorization3() throws Exception
	{
		service.addNote( new Note( 1, "TEST", new Content(1, "test")) );
		assertFalse( service.findNotes().isEmpty() );
		mockMvc.perform( delete( "/api/notes/deleteNote/" ).param( "aId", "1" ) )
				.andExpect( status().is( 200 ) );
		assertTrue( service.findNotes().isEmpty() );
	}

}

package com.fullteaching.backend;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

import java.io.IOException;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fullteaching.backend.repo.CourseRepository;
import com.fullteaching.backend.repo.CourseDetailsRepository;
import com.fullteaching.backend.repo.FileRepository;
import com.fullteaching.backend.repo.FileGroupRepository;
import com.fullteaching.backend.repo.ForumRepository;
import com.fullteaching.backend.security.AuthorizationService;
import com.fullteaching.backend.repo.SessionRepository;
import com.fullteaching.backend.security.user.UserComponent;
import com.fullteaching.backend.repo.UserRepository;

@WebAppConfiguration
public abstract class AbstractControllerUnitTest extends AbstractUnitTest {

	@Mock
	protected UserRepository userRepository;
		
	@Mock
	protected AuthorizationService authorizationService;  
	
	@Mock
	protected CourseRepository courseRepository;
	
	@Autowired
	protected UserComponent user;
	
	@Mock
	protected CourseDetailsRepository courseDetailsRepository;
	
	@Mock
	protected ForumRepository forumRepository;
	
	@Mock
	private SessionRepository sessionRepository;
	
	@Mock
	private FileGroupRepository fileGroupRepository;
	
	@Mock
	private FileRepository fileRepository;
	
		
	protected MockMvc mvc; 
	

	@Autowired
	protected WebApplicationContext webAppCtx;
	

	
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webAppCtx)
				.apply(springSecurity()).build();
	}
		
	
	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}
	
	protected <T> T mapFromJson(String json, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, clazz);
	}
}

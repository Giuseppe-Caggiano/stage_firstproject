package com.projectstage.demo;

import static org.junit.jupiter.api.Assertions.*;

import com.projectstage.project.Entities.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


class DemoApplicationTests extends AbstractTest {
	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	 }

	@Test
	void getUserList() throws Exception{
		String uri = "/user";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      User[] userList = super.mapFromJson(content, User[].class);
      assertTrue(userList.length > 0);

	}

	@Test
   public void createUser() throws Exception {
      String uri = "/user";
      User user = new User();
      user.setId("5");
      user.setName("Francesco");
	  user.setSurname("Rossi");
	  user.setEmail("fr@gmail.com");
      String inputJson = super.mapToJson(user);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
   }

   @Test
   public void updateUser() throws Exception {
      String uri = "/user/2";
      User user = new User();
      user.setId("2");
      user.setName("Giovanni");
      String inputJson = super.mapToJson(user);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
   }

   @Test
   public void deleteUser() throws Exception {
      String uri = "/user/3";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
   
   }


}

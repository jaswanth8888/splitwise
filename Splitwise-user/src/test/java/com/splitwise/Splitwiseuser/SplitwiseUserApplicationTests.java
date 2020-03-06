package com.splitwise.Splitwiseuser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.util.Times;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PathVariable;

import com.splitwise.Splitwiseuser.Controller.userController;
import com.splitwise.Splitwiseuser.Service.userService;
import com.splitwise.Splitwiseuser.beans.Address;
import com.splitwise.Splitwiseuser.beans.Name;
import com.splitwise.Splitwiseuser.beans.User;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@SpringBootTest
class SplitwiseUserApplicationTests {

	@Test
	void contextLoads() {
	}
	
	
	@InjectMocks
	userController userController;
	
	@Mock
	userService userService;
	
	@BeforeEach
	void testpostuser()
	{
		User user=new User();
		user.setId(200);
		user.setDob("12/12/1976");
		user.setAddress(new Address("123", "Prerananagar", "Bnagalore", 85,"pes", "karnataka", "india"));
		user.setEmail("suraj@ps.com");
		user.setPassword("123");
		user.setName(new Name("Suraj", "Suhas"));
		user.setFriends(new ArrayList<Integer>());
		user.setPhoneNumber(98542432);
		user.setGroups(new ArrayList<Integer>());
		
		when(userService.insertUser(user)).thenReturn(user);
		
		
		
		User ex=userController.saveUser(user);
		
		  //when(userService.insertUser(user)).thenReturn(user);
		
		
		assertNotNull(ex);
		//System.out.println(ex.getName().getFirstName());
		assertEquals("Suraj", ex.getName().getFirstName());
		
	}
	
	@Test
	public List<User> getUser(@PathVariable int uId)
	{
		List<User> list=new ArrayList<User>();
		
		User user1=new User(12,new Name("Preeti", "Agarwal"), "12/10/87",0,0,986588665, "preeti@ps.com","123", new Address("56", "krishna", "hyderbad",87, "kengeri", "Karnataka", "India"), new ArrayList<Integer>(), new ArrayList<Integer>());
		User user2=new User(14,new Name("Saahil", "Agarwal"), "12/10/87",0,0, 986588665, "saahil@ps.com","123", new Address("56", "krishna", "hyderbad",87, "kengeri", "Karnataka", "India"), new ArrayList<Integer>(), new ArrayList<Integer>());
		User user3=new User(17,new Name("Prerana", "Jayakumar"), "12/10/87",0,0, 986588665, "preeti@ps.com","123", new Address("56", "krishna", "hyderbad",87, "kengeri", "Karnataka", "India"), new ArrayList<Integer>(), new ArrayList<Integer>());

	
	list.add(user1);
	list.add(user2);
	list.add(user3);
	
	
	when(userService.getUserById(user1.getId())).thenReturn((User) list);
	
	List<User> usrList=(List<User>) userController.getUser(user1.getId());
	
	 /*when(userService.getAllUsers()).thenReturn(list);
     
     //test
     List<User> usrList = userController.getAllUsers();
     
     assertEquals(3, usrList.size());
     verify(userService, times(1)).getAllUsers();
	*/
	
	
	
	
	
	
	return list;
	
	 	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

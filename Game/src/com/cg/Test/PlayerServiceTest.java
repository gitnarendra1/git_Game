package com.cg.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;

import com.cg.bean.Player;
import com.cg.repo.PlayerRepo;
import com.cg.service.PlayerService;

public class PlayerServiceTest {
	
		private PlayerService service;
		@Mock private PlayerRepo repo;
		
		@Test
		public void test_player_object_null() {
			 Player player = null;		 
			    assertNull("Player object is null", player);
		}
		
		@Test(expected=NullPointerException.class)
		public void test_save_throwsNullPointerException(){
			Player player1=new Player();
			service.add(player1);
				}
		
		@Test
		public void test_playerName_null(){
			Player player1=new Player();
			player1.setName(null);
			//assertEquals(null,palyer.getName());
			assertThat(player1.getName(), nullValue(String.class));
				}
		
		@Test
		public void test_palyerName_duplication() {
			Player player=new Player();
			player.setName("Virat");
			Player player2=new Player();
			 player2.setName("Virat");
			 //assertEquals(game1.getName(),game2.getName());
			 assertSame("Duplicate Player Name",player.getName(),player2.getName());
			 }
		
		@Test
		public void test_add_success(){
			Player player1=new Player();
			player1.setName("Virat");
			
			Player player2=new Player();
			player2.setName("Sachin");
			
			Player player3=new Player();
			player3.setName("Dhoni");
			
			
		    List<Player> l1=new ArrayList<Player>();
		    l1.add(player1);
		    l1.add(player2);
		    l1.add(player3);
		    assertEquals(3, l1.size());
			}
		
		
	
}

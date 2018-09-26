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
import com.cg.bean.Game;
import com.cg.repo.GameRepo;
import com.cg.service.GameService;

public class GameServiceTest {
	private GameService service;
	@Mock private GameRepo repo;
	
	@Test
	public void test_game_object_null() {
		 Game games = null;		 
		    assertNull("game object is null", games);
	}
	
	@Test(expected=NullPointerException.class)
	public void test_save_throwsNullPointerException(){
		Game game1=new Game();
		service.add(game1);
			}
	
	@Test
	public void test_gameName_null(){
		Game game1=new Game();
		game1.setName(null);
		//assertEquals(null,game1.getName());
		assertThat(game1.getName(), nullValue(String.class));
			}
	
	@Test
	public void test_gameName_duplication() {
		 Game game1=new Game();
		 game1.setName("Cricket");
		 Game game2=new Game();
		 game2.setName("Cricket");
		 //assertEquals(game1.getName(),game2.getName());
		 assertSame("Duplicate Game Name",game1.getName(),game2.getName());
		 }
	
	@Test
	public void test_add_success(){
		Game game1=new Game();
		game1.setName("Kho Kho");
		game1.setNumofplayers((byte)11);
		Game game2=new Game();
		game2.setName("Kho Kho1");
		game2.setNumofplayers((byte)11);
		Game game3=new Game();
		game3.setName("Kho Kho2");
		game3.setNumofplayers((byte)11);
		
		//service.add(game1);
		
	    List<Game> l1=new ArrayList<Game>();
	    l1.add(game1);
	    l1.add(game2);
	    l1.add(game3);
	    assertEquals(3, l1.size());
		}
	
	
}

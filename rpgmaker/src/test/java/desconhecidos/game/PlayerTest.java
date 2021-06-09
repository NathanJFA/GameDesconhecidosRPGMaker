package desconhecidos.game;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Entities.Player;

class PlayerTest {

    Player player1;
    
    @BeforeEach
    public void setUp(){
        Player player1 = new Player("player1", 20, 15, 10);
    }
    @Test
    public void testPlayer(){
        Player player1 = new Player("player1", 20, 15, 10);
        assertEquals("player1", player1.getNome());
    }
}

package desconhecidos.game;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Entities.Player;

class PlayerTest {

    Player player1;
    
    @BeforeEach
    void setUp(){
        player1 = new Player("player1", 20, 15, 10);
    }
    @Test
    void testPlayer(){
        assertEquals("player1", player1.getNome());
        assertEquals(20, player1.getVida());
        assertEquals(15, player1.getForca());
        assertEquals(10, player1.getDestreza());
        assertEquals(0, player1.getInventario().size());
    }

    
}

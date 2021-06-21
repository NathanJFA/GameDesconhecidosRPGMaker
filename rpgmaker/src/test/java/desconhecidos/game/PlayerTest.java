package desconhecidos.game;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Entities.Player;
import Historia.Possibilidade;
import javafx.geometry.Pos;

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

    @Test
    public void testeFor(){
        for(int i = 0; i < 5; i++){
            System.out.println("aaa"+i);
            System.out.println(++i);
            System.out.println(i++);
        }
    }
    @Test
    public void testPossi(){
        Possibilidade p0 = new Possibilidade();
        assertEquals(p0.getId(), "0");

       
        Possibilidade p01 = p0.gerarPossi1("E tudo isso, so pq eu tava testando ele");
        assertEquals(p01.getId(), "01");

        Possibilidade p11 = p01.gerarPossi1("Tu eh gay mano ?");
        assertEquals(p11.getId(), "011");
    }
    
}
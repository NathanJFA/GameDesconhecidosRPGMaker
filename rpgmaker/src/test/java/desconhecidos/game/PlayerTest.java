package desconhecidos.game;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Entities.Player;
import Historia.Possibilidade;

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
    public void test(){
        Possibilidade p1 = new Possibilidade("Escolha uma opcao");
        p1.setId("0");
        p1.setMsgOp1("1");
        p1.setMsgOp2("2");
        p1.setMsgOp3("3");

    }
    @Test
    public void testeFor(){
        for(int i = 0; i < 5; i++){
            System.out.println("aaa"+i);
            System.out.println(++i);
            System.out.println(i++);
        }
    }
    
}
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
        Possibilidade p1 = new Possibilidade();
        p1.setOpcao1("msg da opcao 1 do p1");
        p1.getOpcao1().setOpcao1("msg da opcao 1 do opcao1");

        System.out.println(p1.getOpcao1().getMensagem());
        System.out.println(p1.getOpcao1().getOpcao1().getMensagem());
    }
    
}
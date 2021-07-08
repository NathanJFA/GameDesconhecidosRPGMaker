package desconhecidos.game;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;

import Historia.Possibilidade;
import bd.WriteAndRead;

public class testWriteAndRead {
    @BeforeEach
    void setUp(){
        WriteAndRead wr = new WriteAndRead();
        Possibilidade possibilidade = new Possibilidade();
    }

}

package desconhecidos.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import Historia.Possibilidade;
import bd.WriteAndRead;

public class testWriteAndRead {
    
    WriteAndRead wr;
    Possibilidade possibilidade;
    Possibilidade possibilidade01;
    Possibilidade possibilidade02;
    Possibilidade possibilidade03;

    @BeforeEach
    void setUp(){
        wr = new WriteAndRead();
        possibilidade = new Possibilidade("0", "Descricao test", "msgOpcao1", "msgOpcao2", "msgOpcao3");
        
        possibilidade01 = possibilidade.gerarPossi1("test possiblidade 01");
        possibilidade01.setAttr("Test descricao 01", "op1 do 01", "op2 do 01", "op3 do 01");
        
        possibilidade02 = possibilidade.gerarPossi2("test possiblidade 02");
        possibilidade02.setAttr("Test descricao 021", "op1 do 02", "op2 do 02", "op3 do 02");

        possibilidade03 = possibilidade.gerarPossi3("test possiblidade 03");
        possibilidade03.setAttr("Test descricao 03", "op1 do 03", "op2 do 03", "op3 do 03");
    }

    @Test
    void testIdPossibilidades(){
        assertEquals("0", possibilidade.getId());
        assertEquals("01", possibilidade01.getId());
        assertEquals("02", possibilidade02.getId());
        assertEquals("03", possibilidade03.getId());
    }

    @Test
    void testGravador() throws IOException{
        String arquivo = "/TestArq/testPossiArq.txt";
        leitor(arquivo);
    }

    private void escritor(String path) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		Scanner in = new Scanner(System.in);
		System.out.println("Escreva algo: ");
		linha = in.nextLine();
		buffWrite.append(linha + "\n");
		buffWrite.close();
	}

    private void leitor(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
		while (true) {
			if (linha != null) {
				System.out.println(linha);

			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();
	}

}

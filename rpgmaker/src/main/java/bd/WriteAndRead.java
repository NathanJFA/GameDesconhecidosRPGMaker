package bd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Historia.Possibilidade;
import desconhecidos.game.CadastroController;
import desconhecidos.game.PossibilidadesController;
import javafx.collections.ObservableList;

public class WriteAndRead {
	CadastroController controllerCadastro = new CadastroController();
    PossibilidadesController controllerPossibili = new PossibilidadesController();


    private ObservableList <Possibilidade> listPossibiliComple = controllerPossibili.getPossibiliDataComple();
    private ObservableList <Possibilidade> listPossibiliImcomple = controllerPossibili.getPossibiliDataIncomple();
	//O nome do arquivo tem que ser uma string passada da classe Cadastro
	//Tem que criar um get na classe do Cadastro para passar essa String
	private String nameArq;


    
    public static void leitor(String path) throws IOException {
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

	public static void escritor(String path) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		Scanner in = new Scanner(System.in);
		System.out.println("Escreva algo: ");
		linha = in.nextLine();
		buffWrite.append(linha + "\n");
		buffWrite.close();
	}

}

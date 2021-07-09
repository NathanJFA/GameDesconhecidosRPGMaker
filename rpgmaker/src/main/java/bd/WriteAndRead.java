package bd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

import Entities.Entity;
import Entities.Item;
import Historia.Aventura;
import Historia.Possibilidade;
import desconhecidos.game.CadastroController;
import desconhecidos.game.PossibilidadesController;
import javafx.collections.ObservableList;

public class WriteAndRead {

	static File FILE_AVENTURAS = new File("aventuras.txt");

	public static CadastroController sistemaCadastro = new CadastroController();
   
    public static void recuperarDados() throws IOException {
		FileReader fileReader = new FileReader(FILE_AVENTURAS);
		BufferedReader buffRead = new BufferedReader(fileReader);
		String linha = buffRead.readLine();
		while (linha != null) {
			Aventura aventura;
			String [] geral = linha.split("%");
			String atributos = geral[0];
			String entidades = geral[1];
			String itens = geral[2];
			String possibilidades = geral[3];

			//ATRIBUTOS
			String [] atributosGeral = atributos.split("#");
			String nome = atributosGeral[0]; 
			String categoriaAventura = atributosGeral[1];
			String objetivo = atributosGeral[2];
			String personagemPrincipal =  atributosGeral[3];
			String ambiente = atributosGeral[4];
			String descricao = atributosGeral[5];

			//LISTA ENTIDADES
			String [] entidadesGeral = entidades.split("$");
			HashMap<String, Entity> entidadesList = new HashMap<>();
			for(int i = 0; i < entidadesGeral.length; i++){
				String [] entidade = entidadesGeral[i].split("#");
				String nomeE = entidade[0];
				int vida = Integer.parseInt(entidade[1]);
				int forca = Integer.parseInt(entidade[2]);
				int destreza = Integer.parseInt(entidade[3]);
				entidadesList.put(nomeE, new Entity(nomeE, vida, forca, destreza));
			}

			//LISTA ITENS
			String [] itensGeral = itens.split("$");
			HashMap<String, Item> itensList = new HashMap<String, Item>();
			for(int i = 0; i < itensGeral.length; i++){
				String [] item = itensGeral[i].split("#");
				String nomeI = item[0];
				//TALVEZ IMPLEMENTAR ALGUM ATRIBUTO
				itensList.put(nomeI, new Item(nomeI, i, i, i, false));
			}

			//LISTA POSSIBILIDADES
			String [] possibilidadesGeral = possibilidades.split("$");
			HashMap<String, Possibilidade> possibilidadesList = new HashMap<String, Possibilidade>();
			for(int i = 0; i < possibilidadesGeral.length; i++){
				String [] possibilidade = possibilidadesGeral[i].split("#");
				String id = possibilidade[0];
				String descricaoP = possibilidade[1];
				String op1 = possibilidade[2];
				String op2 = possibilidade[3];
				String op3 = possibilidade[4];
				possibilidadesList.put(id, new Possibilidade(id, descricaoP, op1, op2, op3));
			}

			aventura = new Aventura(nome, categoriaAventura, objetivo, personagemPrincipal, ambiente, descricao, entidadesList, itensList, possibilidadesList);
			sistemaCadastro.aventuras.put(nome, aventura);
		}
		buffRead.close();
	}

	public static void gravarDados() throws IOException {
		FileWriter fileWriter = new FileWriter(FILE_AVENTURAS);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		/**
		 *  % DIVIDE OS ATRIBUROS DAS LISTAS
		 *  $ DIVIDE CABA OBJETO DAS LISTAS
		 *  # DIVIDE OS ATRIBUTOS DE CADA OBJETO
		 */
		try {
            for(Aventura a : sistemaCadastro.aventuras.values()) {

				String stringCompostaAtributos = a.getNome() +"#"+a.getCategoriaAventura()+"#"+a.getObjetivo()+"#"+a.getPersonagemPrincipal()+"#"+a.getAmbiente()+"#"+a.getDescricao();
				
				String stringCompostaEntidades = "";
				for(Entity e: a.getEntity().values()){
					if(stringCompostaEntidades.length() == 0){
						stringCompostaEntidades += e.getNome() +"#"+ e.getVida() +"#"+ e.getForca() +"#"+ e.getDestreza();
					}else{
						stringCompostaEntidades += "$" + e.getNome() +"#"+ e.getVida() +"#"+ e.getForca() +"#"+ e.getDestreza();
					}
				}
				String stringCompostaItens = "";
				for(Item i: a.getItens().values()){
					if(stringCompostaItens.length() == 0 ){
						stringCompostaItens += i.getNome();
					}else{
						stringCompostaItens += "$" + i.getNome();
					}
					//+"@"+ i.get() +"@"+ i.getForca() +"@"+ i.getDestreza()
				}
				String stringCompostaPossibilidades = "";
				for(Possibilidade p: a.getPossibilidades().values()){
					if(stringCompostaPossibilidades.length() == 0){
						stringCompostaPossibilidades += p.getId() +"#"+ p.getDescricao() +"#"+ p.getMsgOpcao1() +"#"+ p.getMsgOpcao2()+"#"+ p.getMsgOpcao3();
					}else{
						stringCompostaPossibilidades += "$" + p.getId() + "#"+ p.getDescricao() +"#"+ p.getMsgOpcao1() +"#"+ p.getMsgOpcao2()+"#"+ p.getMsgOpcao3();
					}
				}
                String stringCompostaGeral = stringCompostaAtributos+"%"+stringCompostaEntidades+"%"+stringCompostaItens+"%"+stringCompostaPossibilidades;
                bufferedWriter.write(stringCompostaGeral);
                bufferedWriter.newLine();
            }
		}catch(IOException e){
			System.out.println("erro ao recuperar");
		}
		bufferedWriter.flush();
		fileWriter.close();
	}
}

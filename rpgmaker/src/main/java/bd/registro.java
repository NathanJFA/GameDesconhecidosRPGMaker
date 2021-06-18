package bd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class registro {
    
    public boolean gravarDados(){

        try {
            FileWriter fileWriterC = new FileWriter(FILE_CLIENTES);
            BufferedWriter bwC = new BufferedWriter(fileWriterC);
            for (Cliente cliente : clientes.values()) {
                String stringClienteComposta = cliente.getNome() +"#"+ cliente.getTelefone() +"#"+ cliente.getEmail();
                bwC.write(stringClienteComposta);
                bwC.newLine();
            }
            bwC.flush();
            fileWriterC.close();

            FileWriter fileWriterH = new FileWriter(FILE_HORARIOS);
            BufferedWriter bwH = new BufferedWriter(fileWriterH);
            for (String k : agendaDeHorarios.getHorariosAgendados().keySet()) {
                String stringHorarioComposto = agendaDeHorarios.getHorariosAgendados().get(k).get(Calendar.DAY_OF_MONTH) +"#"+ agendaDeHorarios.getHorariosAgendados().get(k).get(Calendar.MONTH)+"#"+ agendaDeHorarios.getHorariosAgendados().get(k).get(Calendar.YEAR) + "#" + agendaDeHorarios.getHorariosAgendados().get(k).get(Calendar.HOUR) +"#"+ agendaDeHorarios.getHorariosAgendados().get(k).get(Calendar.MINUTE) +"#"+k;
                bwH.write(stringHorarioComposto);
                bwH.newLine();
            }
            bwH.flush();
            fileWriterH.close();

            /*
            FileWriter fileWriterP = new FileWriter(FILE_PRODUTOS);
            BufferedWriter bwP = new BufferedWriter(fileWriterP);
            
            String stringProdutoComposto;
            for (Produto produto : produtos.values()) {
                //stringProdutoComposto = produto.getNome() + "#" + produto.getPreco();
                stringProdutoComposto = produto.getNome() +"#"+ produto.getPreco() +"#"+ produto.getCodigo() +"#"+ produto.getCategoriaVenda() +"#"+ produto.getQuantidadeProdutoEstoque() +"#"+ produto.getDescricao();
                
                bwP.write(stringProdutoComposto);
                bwP.newLine();
            }

            bwP.flush();
            fileWriterP.close();
            */
            

            FileWriter fileWriterF = new FileWriter(FILE_FUNCIONARIOS);
            BufferedWriter bwF = new BufferedWriter(fileWriterF);
            for (Funcionario funcionario : funcionarios.values()) {
                String stringFuncionarioComposta = funcionario.getNome() +"#"+ funcionario.getDataDeNascimento() +"#"+ funcionario.getTelefone() +"#"+ funcionario.getEmail() + "#" + funcionario.getCpf();
                bwF.write(stringFuncionarioComposta);
                bwF.newLine();
            }
            bwF.flush();
            fileWriterF.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            return false;
        }
    }

    @Override
    public void recuperarDados(){

        try{
            FileReader fileReaderC = new FileReader(FILE_CLIENTES);
            BufferedReader brC = new BufferedReader(fileReaderC);
            String lineC;
            while((lineC = brC.readLine()) != null){
                String nome, telefone, email;
                String vetor [] = lineC.split("#");
                nome = vetor[0];
                telefone = vetor[1];
                email = vetor[2];
                Cliente c = new Cliente(nome, telefone, email); 
                this.clientes.put(c.getTelefone(), c );        
            }
            FileReader fileReaderH = new FileReader(FILE_HORARIOS);
            BufferedReader brH = new BufferedReader(fileReaderH);
            String lineH;
            while((lineH = brH.readLine()) != null){
                int day, month, year, hour, minute;
                String vetor [] = lineH.split("#");
                day = Integer.parseInt(vetor[0]);
                month = Integer.parseInt(vetor[1]);
                year = Integer.parseInt(vetor[2]);
                hour = Integer.parseInt(vetor[3]);
                minute = Integer.parseInt(vetor[4]);
                String key = vetor[5];
                Calendar c = Calendar.getInstance(); 
                c.set(Calendar.DAY_OF_MONTH, day);
                c.set(Calendar.MONTH, month);
                c.set(Calendar.YEAR, year);
                c.set(Calendar.HOUR, hour);
                c.set(Calendar.MINUTE, minute);
                agendaDeHorarios.addRetornoDoArquivo(c, key);      
            }
            /*
            FileReader fileReaderP = new FileReader(FILE_PRODUTOS);
            BufferedReader brP = new BufferedReader(fileReaderP);
            String lineP;
            while((lineP = brP.readLine()) != null){
                String nome;
                Double preco;
                String codigo;
                String categoriaVenda;
                int quantidadeProdutosEstoque;
                String descricao;
                
                String vetor [] = lineP.split("#");
                nome = vetor[0];
                preco = Double.parseDouble(vetor[1]);
                codigo = vetor[2];
                categoriaVenda = vetor[3];
                quantidadeProdutosEstoque = Integer.parseInt(vetor[4]);
                descricao = vetor[5];
                ProdutoFisico p = new ProdutoFisico(nome, preco, codigo, categoriaVenda, quantidadeProdutosEstoque, descricao);
                this.produtos.put(p.getCodigo(), p);
                
            }
            */

            FileReader fileReaderF = new FileReader(FILE_FUNCIONARIOS);
            BufferedReader brF = new BufferedReader(fileReaderF);
            String lineF;
            while((lineF = brF.readLine()) != null){
                String nome, dataDeNascimento, telefone, email, cpf;
                String vetor [] = lineF.split("#");
                nome = vetor[0];
                dataDeNascimento = vetor[1];
                telefone = vetor[2];
                email = vetor[3];
                cpf = vetor[4];
                Funcionario f = new Funcionario(nome, dataDeNascimento, telefone, email, cpf);
                this.funcionarios.put(f.getCpf(), f);        
            }  

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
}

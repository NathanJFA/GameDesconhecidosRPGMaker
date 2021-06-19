package Historia;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Historia {
    public static LinkedHashMap<String, Possibilidade> possibilidades = new LinkedHashMap<>();

    public static void updateId(Possibilidade possibilidade){
        for(Map.Entry<String , Possibilidade> p: possibilidades.entrySet()) {
            if(p.getValue().getMsgOpcao1().equals(possibilidade.getApontador())) {
                String newIdFilho = nomeiaId(p.getValue().getId(), "1");
                possibilidade.setId(newIdFilho);
            }else if(p.getValue().getMsgOpcao2().equals(possibilidade.getApontador())){
                String newIdFilho = nomeiaId(p.getValue().getId(), "2");
                possibilidade.setId(newIdFilho);
            }else if(p.getValue().getMsgOpcao3().equals(possibilidade.getApontador())){
                String newIdFilho = nomeiaId(p.getValue().getId(), "3");
                possibilidade.setId(newIdFilho);
            }
        }
    }
    public static String nomeiaId(String idPai, String op){ 
        String newIdFilho = idPai + op;
        return newIdFilho;
    }

    public static void addPossibilidade(String id, Possibilidade possiblidade){
        possibilidades.put(id,possiblidade);
    }
    public void removerPossibilidade(Possibilidade possibilidade){
        possibilidades.remove(possibilidade);
    }
    public LinkedHashMap<String, Possibilidade> getPossibilidades(){
        return possibilidades;
    }

    
   // public void setPossiblilidade(Possibilidade possibilidade){ Esse metodo e necessário, tendo em vista o método addPossilibidade?
    //    this.possibilidades = possibilidades;
   // }

   
}

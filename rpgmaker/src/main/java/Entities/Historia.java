package Entities;

import java.util.LinkedList;
import java.util.List;

public class Historia {
    private List<Possibilidades> possibilidades = new LinkedList<>();

    public void addPossibilidade(Possibilidades possiblidade){
        this.possibilidades.add(possiblidade);
    }
    public List<Possibilidades> removerPossibilidade(Possibilidades possibilidade){
        
        this.possibilidades.remove(possibilidade);
        return possibilidades;
    }
    public List<Possibilidades> getPossibilidades(Possibilidades possiblidade){
        return possibilidades;
    }
   // public void setPossiblilidade(Possibilidade possibilidade){ Esse metodo e necessário, tendo em vista o método addPossilibidade?
    //    this.possibilidades = possibilidades;
   // }

   
}

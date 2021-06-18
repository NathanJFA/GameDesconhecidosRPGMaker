package Historia;

import java.util.LinkedList;
import java.util.List;

public class Historia {
    private List<Possibilidade> possibilidades = new LinkedList<>();

    public void addPossibilidade(Possibilidade possiblidade){
        this.possibilidades.add(possiblidade);
    }
    public List<Possibilidade> removerPossibilidade(Possibilidade possibilidade){
        
        this.possibilidades.remove(possibilidade);
        return possibilidades;
    }
    public List<Possibilidade> getPossibilidades(Possibilidade possiblidade){
        return possibilidades;
    }
   // public void setPossiblilidade(Possibilidade possibilidade){ Esse metodo e necessário, tendo em vista o método addPossilibidade?
    //    this.possibilidades = possibilidades;
   // }

   
}

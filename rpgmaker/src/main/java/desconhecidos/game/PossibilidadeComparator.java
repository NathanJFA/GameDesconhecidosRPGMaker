package desconhecidos.game;

import java.util.Comparator;

import Historia.Possibilidade;

public class PossibilidadeComparator implements Comparator<Possibilidade>{
    @Override
    public int compare(Possibilidade o1, Possibilidade o2) {
        
        return o1.getId().compareTo(o2.getId());
    }
    
}

package Entities;

public class ItemEquipavel implements Item {
    private String nome;
    
    private int constituicao;
    
    public void Item(String nome, int forca, int destreza, int constituicao){

    }
    public void changeAbility(String attr, int value){

    }
    public int getConstituicao() {
        return constituicao;
    }
    
    @Override
    public String getNome() {
        return this.nome;
    }
    @Override
    public boolean getEquipavel() {
        return false;
    }
    @Override
    public void setEquipavel(boolean newTipoItem) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public int getHabilidade() {
        // TODO Auto-generated method stub
        return 0;
    }

    
}
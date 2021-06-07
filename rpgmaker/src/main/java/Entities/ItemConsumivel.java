package Entities;

public class ItemConsumivel implements Item{

    public void Item(String nome, int vida, int forca, int destreza, int constituicao){

    }
    public void changeAbility(String attr, int value){

    }
    @Override
    public String getNome() {
        
        return null;
    }
    @Override
    public boolean getEquipavel() {
        
        return false;
    }

    @Override
    public void setEquipavel(boolean newTipoItem) {
       
        
    }

    @Override
    public int getHabilidade() {
        
        return 0;
    }
    
}

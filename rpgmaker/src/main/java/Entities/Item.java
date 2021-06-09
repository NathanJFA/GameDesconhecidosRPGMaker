package Entities;

public interface Item {
    
    public String getNome();
    public boolean getEquipavel();
    public void setEquipavel(boolean newTipoItem);
    public int getHabilidade();/*Tem que pensar de uma maneira de implemntar esse
    metodo de forma que ele so retorne a habilidade que ele vai alterar*/
}

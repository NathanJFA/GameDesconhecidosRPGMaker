package Entities;

import java.util.LinkedList;

public class Player extends Entity{
    private LinkedList<Item> inventario;

    public Player(String nome) {
        super(nome);
        this.inventario = new LinkedList<>();
    }

    public Player (String nome, int vida, int forca, int destreza){
        super(nome, vida, forca, destreza);
        this.inventario = new LinkedList<>();
    }
    
    public Item addItem(Item i) throws Exception{
        if(this.inventario.size() >= 15){
            throw new Exception("Inventario cheio");
        }
        this.inventario.add(i);
        return i;
    }

    public Item removerItem(Item i) throws Exception{
        for (Item item : this.inventario) {
            if(item.equals(i)){
                this.inventario.remove(i);
                return i;
            }
        }
        throw new Exception("Item nao presente no inventario");
    }

    public Item geItem(Item i) throws Exception{
        for (Item item : this.inventario) {
            if(item.equals(i)){
                return item;
            }
        }
        throw new Exception("Item nao presente no inventario");
    }

    public LinkedList getInventario(){
        return this.inventario;
    }
}

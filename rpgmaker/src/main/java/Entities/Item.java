package Entities;

public class Item{
    private String nome;
    private int vida;
    private int forca;
    private int destreza;
    private boolean some;

    public Item(String nome, int vida, int forca, int destreza, boolean some){
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
        this.destreza = destreza;
        this.some = some;
    }

    public String getNome() {
        return this.nome;
    }

    public boolean getSome() {
        return this.some;
    }

    public void setSome(boolean newSome) {
       this.some = newSome;
    }
    
    public int getHabilidade() {
        return this.vida + this.forca + this.destreza;
    }
    
}
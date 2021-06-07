package Entities;

public class Entity {
    private String nome;
    private int vida;
    private int forca;
    private int destreza;

    public Entity(String nome) {
        this.nome = nome;
        this.vida = 1;
        this.forca = 0;
        this.destreza = 0;
    }

    public Entity(String nome, int vida, int forca, int destreza) {
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
        this.destreza = destreza;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String newNome) {
        this.nome = newNome;
    }

    public int getVida() {
        return this.vida;
    }

    public int getForca() {
        return this.forca;
    }

    public void setForca(int newForca) {
        this.forca = newForca;
    }

    public int getDestreza() {
        return this.destreza;
    }

    public void setDestreza(int newDestreza) {
        this.destreza = newDestreza;
    }

    public int danoRecebido(int dano) {
        return this.vida = -dano;

    }

}

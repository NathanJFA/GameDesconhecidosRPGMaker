package Entities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Entity {
    private StringProperty nome;
    private IntegerProperty vida;
    private IntegerProperty forca;
    private IntegerProperty destreza;

    public Entity(String nome) {
        this.nome = new SimpleStringProperty(nome);
        this.vida = new SimpleIntegerProperty(1);
        this.forca = new SimpleIntegerProperty(0);
        this.destreza = new SimpleIntegerProperty(0);
    }

    public Entity(String nome, int vida, int forca, int destreza) {
        this.nome = new SimpleStringProperty(nome);
        this.vida = new SimpleIntegerProperty(vida);
        this.forca = new SimpleIntegerProperty(forca);
        this.destreza = new SimpleIntegerProperty(destreza);
    }

    public String getNome() {
        return nome.get();
    }

    public void setNome(String newNome) {
        this.nome = new SimpleStringProperty(newNome);
    }

    public int getVida() {
        return this.vida.get();
    }

    public int getForca() {
        return this.forca.get();
    }

    public void setForca(int newForca) {
        this.forca = new SimpleIntegerProperty(newForca);
    }

    public int getDestreza() {
        return this.destreza.get();
    }

    public void setDestreza(int newDestreza) {
        this.destreza = new SimpleIntegerProperty(newDestreza);
    }

    public int danoRecebido(int dano) {
        vida.set(this.vida.get() - dano);
        return vida.get();
    }
 
}

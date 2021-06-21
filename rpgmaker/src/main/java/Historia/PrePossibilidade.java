package Historia;

public class PrePossibilidade {
    private String id;
    private String apontador;

    public PrePossibilidade(String id, String apontador){
        this.id = id;
        this.apontador = apontador;
    }
    public String getId(){
        return this.id;
    }
    public String getAPontador(){
        return this.apontador;
    }public void setId(String id){
        this.id = id;
    }
    public void setApontador(String apontador){
        this.apontador = apontador;
    }
}

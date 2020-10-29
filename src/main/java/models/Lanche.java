package models;

public class Lanche {
    private String carne;
    private String salada;
    private String pao;
    private String molho;
    private int    valor;
    private long   id_pedido;

    public Lanche(){
    
    };

    public Lanche(String carne, String salada, String pao, String molho){
        this.carne = carne;
        this.salada = salada;
        this.pao = pao;
        this.molho = molho;
    }

    public int getValor() {
        return valor;
    }

    public String getCarne() {
        return carne;
    }
    
    public String getSalada() {
        return salada;
    }

    public String getPao() {
        return pao;
    }

    public String getMolho() {
        return molho;
    }

    public Long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setMolho(String molho) {
        this.molho = molho;
    }

    public void setSalada(String salada) {
        this.salada = salada;
    }

    public void setPao(String getPao) {
        this.pao = getPao;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }
}

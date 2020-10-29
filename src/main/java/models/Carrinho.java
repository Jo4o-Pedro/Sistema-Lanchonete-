package models;

public class Carrinho {
    private String carne;
    private String salada;
    private String pao;
    private String molho;
    private int    valor;
    private long   id_pedido;
    private long   id_lanche;
    private int    total;

    public Carrinho(){
    
    };

    public Carrinho(String carne, String salada, String pao, String molho){
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

    public Long getId_lanche() {
        return id_lanche;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setId_lanche(Long id_lanche) {
        this.id_lanche = id_lanche;
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

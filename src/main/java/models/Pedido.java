package models;

public class Pedido {
    private Long id;
    private Long id_usuario;
    private String data;
    private int totalRS;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getTotalRS() {
        return totalRS;
    }

    public void setTotalRS(int totalRS) {
        this.totalRS = totalRS;
    }
}

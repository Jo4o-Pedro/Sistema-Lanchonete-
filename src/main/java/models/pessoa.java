
package models;

/**classe pessoa tem Gets e Sets necessarios para cadastrar uma pessoa no db*/
public class pessoa {
    private Long id;
    private String nome;
    private String email;
    private Integer telefone;
    private String senha;
    
    public pessoa(){
    
}
    
    public pessoa(Long id, String nome, String email, Integer telefone, String senha){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }
    
     public pessoa(String nome, String email, Integer telefone, String senha){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }
    
    public void SetNome(Long id){
    this.id = id;
    }
        
    public void SetNome(String nome){
    this.nome = nome;
    }

    public void SetEmail(String email){
    this.email = email;
    }

    public void SetSenha(String senha){
    this.senha = senha;
    }

    public void SetTelefone(Integer telefone){
    this.telefone = telefone;
    }

    public Long GetId(){
    return id;
    }
    
    public String GetNome(){
    return nome;
    }

    public String GetEmail(){
    return email;
    }

    public String GetSenha(){
    return senha;
    }

    public Integer GetTelefone(){
    return telefone;
    }


}
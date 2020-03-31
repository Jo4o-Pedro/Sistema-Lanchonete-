package models;

/**classe pessoa tem Gets e Sets necessarios para cadastrar uma pessoa no db*/
public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    
    public Usuario(){
    
}
    
    public Usuario(Long id, String nome, String email, String telefone, String senha){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }
    
     public Usuario(String nome, String email, String telefone, String senha){
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

    public void SetTelefone(String telefone){
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

    public String GetTelefone(){
    return telefone;
    }


}
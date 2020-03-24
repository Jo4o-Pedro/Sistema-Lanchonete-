
public class Usuario {
    private String nome = null;
    private String email = null;
    private String senha = null;
    private Integer telefone = null;
    
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

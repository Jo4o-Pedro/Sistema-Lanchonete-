package crud;

public class Usuario {
    private String nome = null;
    private String email = null;
    private String senha = null;
    private String telefone = null;
    
    public void Usuario(){
    
    };

    public void Usuairo(String nome, String email, String senha, String telefone){
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.telefone = telefone;
    };
    
    public void SetNome(String nome){
        if(nome == null){
            this.nome = "";
        }else{
            this.nome = nome;
        };
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

package banco;


public class Clientes {
    private String nome;
    private String cpf;
    private String tipoConta;

    public Clientes(String nome, String cpf, String conta) {
        this.nome = nome;
        this.cpf = cpf;
        this.tipoConta = conta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }
    
    

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
 
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
 
}

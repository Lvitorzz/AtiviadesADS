package banco;

public class ContaCliente {
    //todos os metodos e atributos dessa classe sao herdados por ContaCorrente e ContaPoupanca
    private Clientes nome; //associacao
    private int senha;
    private double saldo;

    public ContaCliente(Clientes cliente, int senha) { //metodo construtor
        this.nome = cliente;
        this.senha = senha;
    }

    // metodos get e set
    public Clientes getCliente() {
        return nome;
    }

    public void setCliente(Clientes cliente) {
        this.nome = cliente;
    }
    
    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
            //metodos para operaçoes
    public void realizarSaque(double quantias){
        if (this.getSaldo() < quantias){
            System.out.println("Seu saldo é menor que a quantia que deseja sacar!\nUsaremos seu cheque especial para realizar a operacao");
        }
        System.out.println("Saque de R$" + quantias + " realizado com sucesso!");
        this.setSaldo(this.getSaldo() - quantias);
        System.out.println("Seu novo saldo eh de R$" + this.getSaldo());         
    }
    
    public void realizarDeposito(double quantiad){
        System.out.println("Deposito de R$" + quantiad + " realizado com sucesso!");
        this.setSaldo(this.getSaldo() + quantiad);
        System.out.println("Seu novo saldo eh de R$" + this.getSaldo());
    }
    
    public void visualizarSaldo(){
        System.out.println("Seu saldo atual eh de \n>>>R$" + this.getSaldo());
        if (this.getSaldo() < 0){
            System.out.println("Voce esta no cheque especial e esta sendo cobrada uma taxa de juros de 0,5% por dia.\nVoce pode calcular o juros do cheque especial em uma das opcoes do menu!");
        }
    }
}

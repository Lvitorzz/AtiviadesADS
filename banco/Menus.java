package banco;

public class Menus { //classe para deixar o codigo mais limpo
    private int op;

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }
    
    //metodos para menus
    public void menuInicial(){ 
        System.out.println("Bem Vindo(a)!");
        System.out.println("1 -> Entrar na sua conta!");
        System.out.println("2 -> Criar uma conta!");
        System.out.println("3 -> Visualizar todos os clientes");
    }
    
    public void menuClienteCorrente(){
        System.out.println("1 -> Visualizar saldo!");
        System.out.println("2 -> Realizar deposito!");
        System.out.println("3 -> Realizar saque!");
        System.out.println("4 -> Calcular juros do cheque especial!");
        System.out.println("5 -> Excluir conta!");
        System.out.println("6 -> Sair");
    }
    
        public void menuClientePoupanca(){
        System.out.println("1 -> Visualizar saldo!");
        System.out.println("2 -> Realizar deposito!");
        System.out.println("3 -> Realizar saque!");
        System.out.println("4 -> Calcular rendimento poupanca!");
        System.out.println("5 -> Excluir conta!");
        System.out.println("6 -> Sair");
    }
    
    public void simNao(){
        System.out.println("1 -> SIM!");
        System.out.println("2 -> NAO!");
    }
    
    public void menuConta(){
        System.out.println("1 -> Conta Poupanca!");
        System.out.println("2 -> Conta Corrente!");
    }

    //metodos para fazer separaçoes na hora da impressao
    public void apenasLinha(){
        System.out.println("==============================");
    }
    
    public void linhaFrase(String frase){
        System.out.println("========== " + frase + " ==========");
    }
}

package banco;
import java.util.ArrayList;
import java.util.Scanner;

public class Banco {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Menus m = new Menus();
        ArrayList<ContaPoupanca> ListaPoupanca = new ArrayList<>(); //lista para clientes com conta poupança
        ArrayList<ContaCorrente> ListaCorrente = new ArrayList<>(); //lista para clientes com conta corrente
        ArrayList<Clientes> ListaClientes = new ArrayList<>(); // lista com todos os clientes cadastrados
        
        
        /*o sistema comeca sem clientes cadastrados, primeiro cadastre pelo menos 1 cliente para acessar as funçoes
          do sistema, é possivel cadastrar varios clientes e visualiza-los depois
          foi ultilado herança nas classes ContaCorrente e ContaPoupanca que herdam atributos de ContaCliente
          tem associaçao da classe Cliente em ContaCliente e todos os atributos e metodos estao encapsulados*/
        
        
        while (true){ //menu principal banco
        m.linhaFrase("BANCO LVBRASIL");
        m.menuInicial();
        System.out.println("Oque deseja fazer hoje: "); //cliente escolhe se quer criar ou acessar uma conta
        m.setOp(input.nextInt());
        m.apenasLinha();
        switch (m.getOp()){
            case 1:
                m.menuConta();
                System.out.println("Qual conta deseja acessar: "); //cliente escolhe se vai acessar conta corrente ou poupanca
                m.setOp(input.nextInt());
                switch (m.getOp()){
                    case 1: //poupança
                        m.linhaFrase("LOGIN DE ACESSO");
                System.out.println("Digite seu CPF: "); //procura cliente por CPF
                String cpf = input.next();
                int i=0;
                    while (i<ListaPoupanca.size() && !ListaPoupanca.get(i).getCliente().getCpf().equals(cpf)){
                        i++;
                    }
                    if(i==ListaPoupanca.size()){
                        System.out.println("Cliente nao encontrado!"); //cliente ainda nao cadastrado
                        m.apenasLinha();
                    }
                    else {
                        m.linhaFrase("SENHA"); //cliente cadastrado digita senha para acessar conta
                        System.out.println("Ola " + ListaPoupanca.get(i).getCliente().getNome() + "!");
                        System.out.println("Digite sua senha: ");
                            int senhaid = input.nextInt();
                            int tentativas = 1; 
                        while (senhaid != ListaPoupanca.get(i).getSenha()){
                            if (tentativas <= 3){
                            System.out.println("Senha incorreta"); //cliente erra senha e entra um loop de 3 ciclos ou ate ele acertar a senha
                            System.out.println("Esta eh sua " + tentativas + "º tentativa!\nVoce tem direito a 3!");
                            System.out.println("Digite sua senha novamente: ");
                            senhaid = input.nextInt();
                            tentativas++;
                        }   else {
                                System.out.println("Conta Bloqueada!"); //cliente erra senha 3 vezes
                                break;
                            }
                        }
                            if (senhaid == ListaPoupanca.get(i).getSenha()){
                                System.out.println("Senha correta!\nEntrando na sua conta!"); //cliente coloca a senha certa e acessa sua conta
                                m.apenasLinha();
                                while (true){
                                    m.linhaFrase("MENU DE CONTA DE USUARIO");
                                m.menuClientePoupanca();
                                System.out.println("Oque deseja fazer " + ListaPoupanca.get(i).getCliente().getNome() + "?");
                                m.setOp(input.nextInt()); //cliente escolhe qual operacao deseja fazer
                                switch (m.getOp()){
                                    case 1:
                                        m.linhaFrase("SALDO BANCARIO CONTA POUPANCA"); //cliente visualiza saldo
                                        ListaPoupanca.get(i).visualizarSaldo();
                                        m.apenasLinha();
                                        break;
                                    case 2:
                                        m.linhaFrase("DEPOSITO CONTA POUPANCA"); //cliente realiza deposito
                                        System.out.println("Qual valor deseja depositar " + ListaPoupanca.get(i).getCliente().getNome() + "? ");
                                            double quantiad = input.nextDouble(); //cliente define valor do deposito
                                            ListaPoupanca.get(i).realizarDeposito(quantiad); //sistema deposita e retorna saldo atual
                                            m.apenasLinha();
                                        break;
                                    case 3:
                                        m.linhaFrase("SAQUE CONTA POUPANCA"); //cliente realiza saque
                                        if (ListaPoupanca.get(i).getSaldo() > 0){ //sistema verifica se existe saldo na conta para saque
                                            System.out.println("Qual valor deseja sacar " + ListaPoupanca.get(i).getCliente().getNome() + "? ");
                                            double quantias = input.nextDouble(); //sistema realiza saque e retorna saldo atual
                                            if (quantias > ListaPoupanca.get(i).getSaldo()){ //sistema verifica se valor de saque do cliente e menor que saldo em conta
                                                System.out.println("Nao é possivel sacar esse valor");
                                            } else{
                                                ListaPoupanca.get(i).realizarSaque(quantias); //sistema realiza saque e retorna saldo atual
                                                m.apenasLinha();
                                            }
                                            
                                            
                                        } else {
                                            m.apenasLinha();
                                            System.out.println("Que pena " + ListaPoupanca.get(i).getCliente().getNome() + "!\nVoce nao tem saldo suficiente para saque! ");
                                            System.out.println("Operacao negada!"); //cliente nao tem saldo
                                            m.apenasLinha();
                                        }
                                        
                                        break;
                                    case 4:
                                        m.linhaFrase("SIMULADOR DE RENDIMENTO POUPANCA"); //cliente simula quanto seu dinheiro vai render na poupança
                                        System.out.println("Vamos simular para voce quanto seu dinheiro renderia aqui!");
                                        System.out.println("No momento seu saldo é de R$" + ListaPoupanca.get(i).getSaldo());
                                        System.out.println("Por quantos meses deseja guardar seu dinheiro aqui? ");
                                        int meses = input.nextInt();
                                        m.linhaFrase("EXTRATO SIMULADOR RENDIMENTO POUPANCA");
                                        ListaPoupanca.get(i).calculoRendimento(meses); //sistema retorna simulaçao de saldo ao cliente
                                        m.apenasLinha();
                                        break;
                                    case 5:
                                        m.linhaFrase("DELETAR CONTA");
                                        System.out.println("Tem certeza que deseja deletar sua conta " + ListaPoupanca.get(i).getCliente().getNome());
                                        m.simNao();
                                        m.setOp(input.nextInt());
                                        switch (m.getOp()){
                                            case 1:
                                                m.linhaFrase("SUA CONTA FOI DELETADA");
                                                System.out.println("Eh uma pena que esta saindo " + ListaPoupanca.get(i).getCliente().getNome() + " :(");
                                                ListaPoupanca.remove(i);
                                                ListaClientes.remove(i);
                                                System.out.println("Ate breve!");
                                                m.apenasLinha();
                                                break;
                                            case 2:
                                                m.apenasLinha();
                                                System.out.println("Que bom que vai continuar com a gente " + ListaPoupanca.get(i).getCliente().getNome() + "!");
                                                break;
                                        }
                                        break;
                                    case 6:
                                        m.linhaFrase("VOLTANDO AO MENU ANTERIOR");
                                        break;
                                        
                                }
                                
                    }
                        }break;
                    }
                
                break;
                    case 2: //nesse case 2 acontece as mesmas coisas do case 1 porem na conta corrente
                        m.linhaFrase("LOGIN DE ACESSO");
                System.out.println("Digite seu CPF: ");
                String cpfi = input.next();
                int c=0;
                    while (c<ListaCorrente.size() && !ListaCorrente.get(c).getCliente().getCpf().equals(cpfi)){
                        c++;
                    }
                    if(c==ListaCorrente.size()){
                        System.out.println("Cliente nao encontrado!");
                        m.apenasLinha();
                    }
                    else {
                        m.linhaFrase("SENHA");
                        System.out.println("Ola " + ListaCorrente.get(c).getCliente().getNome() + "!");
                        System.out.println("Digite sua senha: ");
                            int senhaid = input.nextInt();
                            int tentativas = 1; 
                        while (senhaid != ListaCorrente.get(c).getSenha()){
                            if (tentativas <= 3){
                            System.out.println("Senha incorreta");
                            System.out.println("Esta eh sua " + tentativas + "º tentativa!\nVoce tem direito a 3!");
                            System.out.println("Digite sua senha novamente: ");
                            senhaid = input.nextInt();
                            tentativas++;
                        }   else {
                                System.out.println("Conta Bloqueada!");
                                break;
                            }
                        }
                            if (senhaid == ListaCorrente.get(c).getSenha()){
                                System.out.println("Senha correta!\nEntrando na sua conta!");
                                m.apenasLinha();
                                while (true){
                                    m.linhaFrase("MENU DE CONTA DE USUARIO");
                                m.menuClienteCorrente();
                                System.out.println("Oque deseja fazer " + ListaCorrente.get(c).getCliente().getNome() + "?");
                                m.setOp(input.nextInt());
                                switch (m.getOp()){
                                    case 1:
                                        m.linhaFrase("SALDO BANCARIO CONTA CORRENTE");
                                        ListaCorrente.get(c).visualizarSaldo();
                                        m.apenasLinha();
                                        break;
                                    case 2:
                                        m.linhaFrase("DEPOSITO CONTA CORRENTE");
                                        System.out.println("Qual valor deseja depositar " + ListaCorrente.get(c).getCliente().getNome() + "? ");
                                            double quantiad = input.nextDouble();
                                            ListaCorrente.get(c).realizarDeposito(quantiad);
                                            m.apenasLinha();
                                        break;
                                    case 3:
                                        m.linhaFrase("SAQUE CONTA CORRENTE");

                                            System.out.println("Qual valor deseja sacar " + ListaCorrente.get(c).getCliente().getNome() + "? ");
                                            double quantias = input.nextDouble();
                                            
                                                ListaCorrente.get(c).realizarSaque(quantias);
                                                m.apenasLinha();
                                                break;
                                        
                                        
                                       
                                    case 4:
                                        m.linhaFrase("SIMULADOR DE JUROS CONTA CORRENTE"); //sistema simula valor de juros do cheque especial do cliente
                                        System.out.println("Vamos simular o juros do seu cheque especial!");
                                        System.out.println("No momento seu saldo é de R$" + ListaCorrente.get(c).getSaldo());
                                        System.out.println("Por quantos dias deseja deixar a conta em cheque especial? ");
                                        int dias = input.nextInt();
                                        ListaCorrente.get(c).calculoJuros(dias); //sistema retorna simulacao de juros ao cliente
                                        m.apenasLinha();
                                        break;
                                    case 5:
                                        m.linhaFrase("DELETAR CONTA");
                                        System.out.println("Tem certeza que deseja deletar sua conta " + ListaCorrente.get(c).getCliente().getNome());
                                        m.simNao();
                                        m.setOp(input.nextInt());
                                        switch (m.getOp()){
                                            case 1:
                                                m.linhaFrase("SUA CONTA FOI DELETADA");
                                                System.out.println("Eh uma pena que esta saindo " + ListaCorrente.get(c).getCliente().getNome() + " :(");
                                                ListaCorrente.remove(c);
                                                ListaClientes.remove(c);
                                                System.out.println("Ate breve!");
                                                m.apenasLinha();
                                                break;
                                            case 2:
                                                m.apenasLinha();
                                                System.out.println("Que bom que vai continuar com a gente " + ListaCorrente.get(c).getCliente().getNome() + "!");
                                                break;
                                        }
                                        break;
                                    case 6:
                                        m.linhaFrase("VOLTANDO AO MENU ANTERIOR");
                                        break;
                                } 
                    } 
                        }
                    }
                
                
                }
                
            case 2:
                m.linhaFrase("CRIAR CONTA"); //cliente deseja abrir uma conta
                m.menuConta();
                System.out.println("Oque deseja: ");
                m.setOp(input.nextInt());
                m.apenasLinha();
                switch (m.getOp()){
                    case 1: //CONTA POUPANÇA
                      System.out.println("Nos diga qual eh seu primeiro nome? "); //solicita nome usuario
                      String nome = input.next();
                      System.out.println("Digite seu cpf: "); //solicita cpf cliente
                      String cpf = input.next();
                      int i=0; //verifica se cliente ja tem conta poupança
                    while (i<ListaPoupanca.size() && !ListaPoupanca.get(i).getCliente().getCpf().equals(cpf)){
                        i++;
                    }
                    if(i==ListaPoupanca.size()){
                        m.apenasLinha();
                        ListaClientes.add(new Clientes(nome, cpf, "poupanca")); // cadastra usuario no banco de dados de clientes
                m.linhaFrase("DFINIR SENHA"); //cliente define senha
                System.out.println("Muito bem " + nome + "!\nAgora vamos definir sua senha!");
                System.out.println("Escolha uma senha NUMERICA!");
                int senha = input.nextInt();
                for (int c = 0; c < 3; c++){
                    m.linhaFrase("CONFIRMAR SENHA"); //confirmar senha
                    System.out.println("Repita a senha por favor!");
                    int conferesenha = input.nextInt();
                    if (senha == conferesenha){
                        ListaPoupanca.add(new ContaPoupanca(ListaClientes.get(ListaClientes.size() - 1), senha)); //cliente cria conta poupança 
                        m.linhaFrase("VOCE FOI CADASTRADO COM SUCESSO!");
                        System.out.println("Boa " + nome + "! Obrigado por se tornar um cliente! :)");
                        m.apenasLinha();
                        break;
                    }else {
                        System.out.println("Voce digitou a senha errada!");
                    }
                }
                    }
                    else {
                        System.out.println("CPF JA CADASTRADO EM CONTA POUPANCA");
                    }

                   break;
                    case 2:
                System.out.println("Nos diga qual é seu primeiro nome? ");
                String nomec = input.next();
                        System.out.println("Digite seu cpf: ");
                        String cpfc = input.next();
                        int in=0; //verifica se cliente ja tem conta corrente
                    while (in<ListaCorrente.size() && !ListaCorrente.get(in).getCliente().getCpf().equals(cpfc)){
                        in++;
                    }
                    if(in==ListaCorrente.size()){
                        ListaClientes.add(new Clientes(nomec, cpfc, "corrente"));
                System.out.println("Muito bem " + nomec + "!\nAgora vamos definir sua senha!");
                System.out.println("Escolha uma senha NUMERICA!");
                int senhac = input.nextInt();
                for (int c = 0; c < 3; c++){
                    System.out.println("Repita a senha por favor!");
                    int conferesenha = input.nextInt();
                    if (senhac == conferesenha){
                        ListaCorrente.add(new ContaCorrente(ListaClientes.get(ListaClientes.size() - 1), senhac)); //cliente cria conta corrente
                        System.out.println("Boa " + nomec + " voce foi cadastrado com sucesso!");
                        break;
                    }else {
                        System.out.println("Voce digitou a senha errada!");
                                            } 
                } System.out.println("Nao deu certo a criacao da sua conta!");
                    }else{
                        System.out.println("CPF JA CADASTRADO EM CONTA CORRENTE");
                    }

                    break;
                }
                break;
            case 3:
                m.linhaFrase("VISUALIZANDO TODOS OS CLIENTES");
                for (Clientes cliente : ListaClientes) {
                    m.apenasLinha();
                    System.out.println("Cliente: " + cliente.getNome());
                    System.out.println("CPF: " + cliente.getCpf());
                    System.out.println("Tipo de conta: " + cliente.getTipoConta());
                    m.apenasLinha();
                    }
        }
    }
    
}
    }

package banco;

public class ContaCorrente extends ContaCliente{ //classe herdeira de ContaCliente
    private double juros;

     public ContaCorrente(Clientes nome, int senha){
        super(nome, senha);
    }
    


    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }
    
    public void calculoJuros(int dias){ //metodo exclusivo para contas corrente
        if (this.getSaldo() < 0){
            double j = 0.8 / 100;

            this.juros = (this.getSaldo()) + this.getSaldo() * j * dias;
            this.setJuros(this.juros);
            
            System.out.println("Se ficar no cheque especial durante esse periodo de " + dias + " dias voce ficara com um saldo devedor de ");
                System.out.format("R$%.2f", this.getJuros());
                System.out.println("\n*Juros de 0,8% por dia!");
            
        } else{
            System.out.println("Voce nao esta com saldo devedor");
        }
    }
}

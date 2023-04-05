package banco;


public class ContaPoupanca extends ContaCliente{ //classe herdeira de ContaCliente

    private double rendimento;

    public ContaPoupanca(Clientes nome, int senha){
        super(nome, senha);
    }
    
    
    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }
    
    public void calculoRendimento(int mes){ //metodo exclusivo de conta poupança
        System.out.println("Deixando seu dinheiro na poupanca ele rende 1,5% ao mes");
        System.out.println("Seu dinheiro vai render nesse tmepo: ");
        double s = 1.5/100;

            this.rendimento = (this.getSaldo()) + this.getSaldo() * s * mes;
            this.setRendimento(this.rendimento);
            
            System.out.println("Se deixar seu dinheiro rendendo na poupança por esse periodo de " + mes + " meses voce tera um valor de ");
            System.out.format(">>>R$%.2f", this.getRendimento());
            System.out.println("\n*Rendimento de 1,5% ao mes!");
    } 
    
}

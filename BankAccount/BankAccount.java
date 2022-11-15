/*Implementare una classe BankAccount che permette di gestire un conto bancario 
  contenente un saldo che può essere modificato da depositi e prelievi costruttore
   1)Metodo deposit per versare denaro nel conto bancario
   2)Metodo withdraw preleva denaro dal conto bancario
   3)Metodo getBalance ritorna il saldo attuale 

   Implementare una classe BankAccountTest per il collaudo della classe BankAccount
    1)Inserimento denaro
    2)Prelievo
    3)Stampa Saldo
*/

public class BankAccount implements Measurable{
        private  int num_conto;
        private static int n = 0;
        private double saldo;
        private static BankAccount[] array;
        private boolean tassa;
        private int cont_dep;
        private static double dollaro = 0.97;

        //Costruttore
    public BankAccount(double quant){
        num_conto = n++;     //Numero di conto
        saldo = quant;    //Saldo
        cont_dep = 0;    //Contatore dei depositi

    }

    //Costruttore implicito
    public BankAccount(){
        this(0.0);
    }

    //Deposito
    public void  deposit(double qt){
        saldo = saldo+qt;
        cont_dep++;
    }
    //Prelievo
    public void withdraw(double qt){
        try {
            //Controllo sullo stato del saldo
            //Se la quantità da prelevare è maggiore
            //del saldo allora si crea l'eccezzione
            if (qt > this.getBalance()){
                throw new NoFundsException();
            }
            saldo = saldo-qt;
        }
        catch (NoFundsException exc){
            System.out.println(exc.toString());
        }
    }

    //Saldo
    public double getBalance(){
        return saldo;
    }

    public int getContDep() {
        return cont_dep;
    }

    public String printConto(){
        String formattedNumber = String.format("%010d", num_conto);
        //System.out.println("\nQuesto è il numero conto: " + formattedNumber);
        return formattedNumber;
    }

    //Setto il valore di tass
    public void setTassa(boolean tassa) {
        this.tassa = tassa;
    }

    //Controllo se il conto è gia stato tassato
    public boolean isTass(){
        if (tassa)
            return tassa = true;
        return tassa;
    }

    public double convert(){
        return getBalance() * dollaro;
    }

    public double getMeasure(){
        return saldo;
    }
}

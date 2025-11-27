
public class Main {

    public static void main(String[] args) throws InterruptedException {


        Barbearia barbearia = new Barbearia(5);

        Barbeiro barbeiro = new Barbeiro(barbearia);
        barbeiro.start();


        for (int i = 1; i <= 10; i++) {
            Cliente cliente = new Cliente(barbearia, "Cliente " + i);
            cliente.start();

            Thread.sleep(1000);
            //simulação de chegada dos clientes

        }

    }
}

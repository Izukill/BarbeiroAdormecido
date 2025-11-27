public class Barbeiro extends Thread {

    private Barbearia barbearia;

    public Barbeiro(Barbearia barbearia) {
        this.barbearia = barbearia;
    }

    @Override
    public void run() {

        System.out.println("Barbeiro: estou na espera de clientes");

        while (true){
            try {
                barbearia.proximoCliente();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

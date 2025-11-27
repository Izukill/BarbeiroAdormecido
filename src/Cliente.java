public class Cliente extends Thread {

    private Barbearia barbearia;

    private String nome;

    public Cliente(Barbearia barbearia,String nome) {
        this.barbearia = barbearia;
        this.nome= nome;
    }


    @Override
    public void run() {


        try {
            barbearia.entrarBarbearia(this.nome);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

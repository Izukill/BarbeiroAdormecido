import java.util.concurrent.Semaphore;

public class Barbearia {

    private Semaphore clientes = new Semaphore(0);

    private Semaphore barbeiro = new Semaphore(0);

    private Semaphore mutex = new Semaphore(1);
    //variavel para exclusão mutua de processos

    private int esperando = 0;

    private int cadeiras;

    public Barbearia(int cadeiras){
        this.cadeiras = cadeiras;
    }



    //usada pelos clientes
    public void entrarBarbearia(String nomeCliente) throws InterruptedException {

        mutex.acquire();

        if(esperando < cadeiras){

            esperando++;

            System.out.println(nomeCliente+ " entrou na barbearia");
            System.out.println("Clientes esperando:"+ esperando + "/"+cadeiras);

            clientes.release();
            mutex.release();

            barbeiro.acquire();
            System.out.println(nomeCliente + " terminou o corte e foi embora");

        }else {
            System.out.println(nomeCliente+" tentou entrar porém a barbearia está cheia");
            mutex.release();
        }



    }


    //
    public void proximoCliente() throws InterruptedException {

        clientes.acquire();
        mutex.acquire();
        esperando--;
        mutex.release();

        cortarCabelo();
        barbeiro.release();






    }



    //Função para simulação de tempo de espera entre clientes na fila
    public void cortarCabelo() throws InterruptedException {
        System.out.println("Barbeiro está cortando o cabelo de um cliente...");
        Thread.sleep(3000);

    }




}

import java.util.Random;

public class JogadorAzar extends Jogador {
    public JogadorAzar(String cor){
        super(cor);
    }

    public void rolarDados(){
        super.setJogadas(getJogadas() + 1);
        Random random = new Random();
        do{
            super.setDado1((random.nextInt(6) + 1));
            super.setDado2((random.nextInt(6) + 1));
        }while(super.getDado1()+super.getDado2() > 6);
        System.out.println("\n❒ Dado 1: " + super.getDado1() + "\n❒ Dado 2: " + super.getDado2());
        super.setPosicao((super.getDado1()+super.getDado2()+super.getPosicao()));
        System.out.println("\n | POSIÇÃO DO JOGADOR AZARADO " + super.getCor() + " É: " + super.getPosicao() + " | \n");
        System.out.println("........................................................................");
    }
}

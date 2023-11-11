import java.util.Random;

public class JogadorNormal extends Jogador {
    
    public JogadorNormal(String cor){
        super(cor);
    }

    public void rolarDados(){
        super.setJogadas(getJogadas() + 1);
        Random random = new Random();
        super.setDado1((random.nextInt(6) + 1));
        super.setDado2((random.nextInt(6) + 1));
        System.out.println("\n❒ Dado 1: " + super.getDado1() + "\n❒ Dado 2: " + super.getDado2());
        super.setPosicao((super.getDado1()+super.getDado2()+super.getPosicao()));
        System.out.println("\n | POSIÇÃO DO JOGADOR NORMAL " + super.getCor() + " É: " + super.getPosicao()+ " | \n");
        System.out.println("........................................................................");
    }
}

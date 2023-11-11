import java.util.Collections;
import java.util.Scanner;

public class Principal{
    public static void main(String[] args){
        int option = 0;
        int qntd_jogadores=0;
        Scanner leitor = new Scanner(System.in);
        System.out.println("Você quer iniciar o jogo?(Digite 1 para iniciar o jogo ou 2 para fechar o programa): ");
        option = Integer.parseInt(leitor.nextLine());
        if(option==1){
        boolean continua = true;
        Tabuleiro tab = new Tabuleiro();
        System.out.println("Digite a quantidade de jogadores: ");
        qntd_jogadores = Integer.parseInt(leitor.nextLine());
        while((qntd_jogadores < 2) || (qntd_jogadores>6)){
            System.out.println("Digite quantidade valida(entre 2 e 6 jogadores): ");
            qntd_jogadores = Integer.parseInt(leitor.nextLine());
        }
        for(int i=0; i<qntd_jogadores;i++){
            String cor;
            System.out.printf("Digite a cor do jogador {%d}", i+1);
            cor = leitor.nextLine();
            if(i==1){
                JogadorAzar jog = new JogadorAzar(cor);
                tab.adicionarJogador(jog);
            } else if(i==4) {
                JogadorSorte jog = new JogadorSorte(cor);
                tab.adicionarJogador(jog);
            } else
            {
            JogadorNormal jog = new JogadorNormal(cor);
            tab.adicionarJogador(jog);
            }
        }
        Collections.shuffle(tab.getLista());


        do{
            tab.jogarRodada();
            for(int j = 0; j < tab.getLista().size();j++){
                if(tab.getLista().get(j).getPosicao() >= 40){
                	System.out.println("|----------------------------------------------|\n");
                    System.out.println("            " + tab.getLista().get(j).getCor() + " * VENCEU!!! * \n");
                	System.out.println("|----------------------------------------------|\n");
                    continua = false;
                    break;
                }
            }

        }while(continua == true);
        
        for(Jogador jogador: tab.getLista()){
            System.out.println(jogador);
        }


    } else {
        System.out.println("Fim de jogo! ");
}
}
}

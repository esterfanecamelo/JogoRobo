import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class Tabuleiro {
    private ArrayList<Jogador> listaJogador;

    public ArrayList<Jogador> getLista(){
        return this.listaJogador;
    }

    public Tabuleiro(){
        listaJogador = new ArrayList<Jogador>();
    }

    public boolean adicionarJogador(Jogador jogador){
        if(this.listaJogador.size() == 6){
            System.out.println("\n --------  Capacidade máxima de jogadores ---------");
            return false;
        }else{
            this.listaJogador.add(jogador);
            return true;
        }
    }

    public void jogarRodada(){
    
        for(int i = 0; i < this.listaJogador.size();i++){
            
            if(this.listaJogador.get(i).getJogaProxima() == true){
                
                this.listaJogador.get(i).rolarDados();
                
                if(this.listaJogador.get(i).getDado1() == this.listaJogador.get(i).getDado2()){ 
                	
                	String tipoJogador = receberTipodeJogador(this.listaJogador.get(i));
                	
                    System.out.println("\nJOGADOR " + tipoJogador + " " + this.listaJogador.get(i).getCor() + " teve valores de *DADOS IGUAIS*, portanto *JOGA PRÓXIMA* de novo.");
                    
                    i--;
                    
                }else if(this.listaJogador.get(i).getPosicao() == 10 || this.listaJogador.get(i).getPosicao() == 25 || this.listaJogador.get(i).getPosicao() == 38){
                    System.out.println("\n--- Jogador " + this.listaJogador.get(i).getCor() + " não joga a próxima rodada! ---\n");
                    this.listaJogador.get(i).setJogaProxima(false);
                }else if(this.listaJogador.get(i).getPosicao() == 13){
                    String novoTipo = mudarJogador();
                    if(novoTipo.equals("Jogador Normal")){
                        if(this.listaJogador.get(i) instanceof JogadorNormal){
                            System.out.println("\n--- Jogador " + this.listaJogador.get(i).getCor() + "já pertence a esse tipo de jogador ---\n");
                        }else{
                            System.out.println("\n--- Jogador " + this.listaJogador.get(i).getCor() + " agora pertence ao tipo Jogador normal ---\n");
                            JogadorNormal novoJogador = new JogadorNormal(this.listaJogador.get(i).getCor());
                            novoJogador.setPosicao(this.listaJogador.get(i).getPosicao());
                            this.listaJogador.set(i, novoJogador);
                        }   
                    }else if(novoTipo.equals("Jogador com Sorte")){
                        if(this.listaJogador.get(i) instanceof JogadorSorte){
                            System.out.println("\n--- Jogador " + this.listaJogador.get(i).getCor() + " já pertence a esse tipo de jogador ---\n");
                        }else{
                            System.out.println("\n--- Jogador " + this.listaJogador.get(i).getCor() +  " agora pertence ao tipo Jogador Com Sorte ---\n");
                            JogadorSorte novoJogador = new JogadorSorte(this.listaJogador.get(i).getCor());
                            novoJogador.setPosicao(this.listaJogador.get(i).getPosicao());
                            this.listaJogador.set(i, novoJogador);
                        }
                    }else if(novoTipo.equals("Jogador com Azar")){
                        if(this.listaJogador.get(i) instanceof JogadorAzar){
                            System.out.println("\n--- Jogador " + this.listaJogador.get(i).getCor() + " já pertence a esse tipo de jogador ---\n");
                        }else{
                            System.out.println("\n--- Jogador " + this.listaJogador.get(i).getCor() + " agora pertence ao tipo Jogador Com Azar ---\n");
                            JogadorAzar novoJogador = new JogadorAzar(this.listaJogador.get(i).getCor());
                            novoJogador.setPosicao(this.listaJogador.get(i).getPosicao());
                            this.listaJogador.set(i, novoJogador);
                        }
                    }
                }else if(this.listaJogador.get(i).getPosicao() == 5 || this.listaJogador.get(i).getPosicao() == 15 || this.listaJogador.get(i).getPosicao() == 30){
                    if(this.listaJogador.get(i) instanceof JogadorAzar){
                        System.out.println("\n--- Jogador azarado " + this.listaJogador.get(i).getCor() + " não recebe o bonus! :( ---\n");
                    }else{
                        this.listaJogador.get(i).setPosicao((this.listaJogador.get(i).getPosicao() + 3));
                        System.out.println("\n   | AVANCE 3 casas " + this.listaJogador.get(i).getCor() + ":) |");
                    }
                }else if(this.listaJogador.get(i).getPosicao() == 17 || this.listaJogador.get(i).getPosicao() == 27){
                    System.out.println("\n--- Jogador " + this.listaJogador.get(i).getCor() + " escolha um jogador para *AMALDIÇOA-LO* ao inicio do jogo! ---\n");
                    Scanner cin = new Scanner(System.in);
                    String escolha = cin.nextLine();
                    for(int j = 0; j < this.listaJogador.size(); j++){
                        if(this.listaJogador.get(j).getCor().equals(escolha)){
                            System.out.println("\n--- Jogador " + this.listaJogador.get(j).getCor() + " volta ao início ---\n");
                            this.listaJogador.get(j).setPosicao(0);
                        }
                    }
                    //cin.close();
                }else if(this.listaJogador.get(i).getPosicao() == 20 || this.listaJogador.get(i).getPosicao() == 35){
                    
                    int aux = this.listaJogador.get(i).getPosicao();
                    int auxW = aux;
                    
                    for(int w = 0; w < this.listaJogador.size();w++){
                        
                        if(this.listaJogador.get(i).getPosicao() > this.listaJogador.get(w).getPosicao()){
                            this.listaJogador.get(i).setPosicao(this.listaJogador.get(w).getPosicao());
                            auxW = this.listaJogador.get(w).getPosicao();
                        }
                    }
                    
                    for(int z = 0; z < this.listaJogador.size();z++){
                        if(auxW == this.listaJogador.get(z).getPosicao()){
                            this.listaJogador.get(z).setPosicao(auxW);
                        }
                    }

                }

            }else if(this.listaJogador.get(i).getJogaProxima() == false){
                System.out.println("\n--- Jogador " + this.listaJogador.get(i).getCor() + " não joga essa rodada ---\n");
                this.listaJogador.get(i).setJogaProxima(true);
            }
            
            
          
            
        }
    }

    public String mudarJogador(){
        String[] jogadores = {"Jogador Normal", "Jogador com Sorte", "Jogador com Azar"};
        Random gerador = new Random();
        int indice = gerador.nextInt(jogadores.length);
        String palavraAleatoria = jogadores[indice];
        return palavraAleatoria;
    }
    
    public String receberTipodeJogador(Jogador jogador) {
    	String tipo = "-";
    	if (jogador instanceof JogadorAzar) {
    		tipo = "AZARADO";
    		return tipo;
    	}else if (jogador instanceof JogadorSorte) {
    		tipo = "SORTUDO";
    		return tipo;    		
    	}else if (jogador instanceof JogadorNormal) {
    		tipo = "NORMAL";
    		return tipo;
    	}
		return tipo;
    }

}

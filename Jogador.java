public abstract class Jogador {
    private String cor;
    private int posicao = 0 ;
    private int dado1;
    private int dado2;
    private int jogadas;
    private boolean jogaProxima;

    public boolean getJogaProxima(){return this.jogaProxima;}
    public void setJogaProxima(boolean jogaProxima){this.jogaProxima = jogaProxima;}

    public int getDado1(){return this.dado1;}
    public void setDado1(int dado1){
        this.dado1 = dado1;
    }
    public int getDado2(){return this.dado2;}
    public void setDado2(int dado2){
        this.dado2 = dado2;
    }
    public int getJogadas(){return this.jogadas;}
    public void setJogadas(int jogadas){this.jogadas = jogadas;}

    public String getCor(){return this.cor;}
    public void setCor(String cor){this.cor = cor;}

    public int getPosicao(){return this.posicao;}
    public void setPosicao(int posicao){this.posicao = posicao;}

    public Jogador(String cor){
        this.cor = cor;
        this.posicao = 0;
        this.dado1 = 0;
        this.dado2 = 0;
        this.jogadas = 0;
        this.jogaProxima = true;
    }

    public abstract void rolarDados();

    public String toString(){
        return "\nCor: " + this.cor + "\nPosição: " + this.posicao + "\nJogadas: " + this.jogadas;
    }

}

package classes;

public class Tabuleiro {

    private char[] mapa = {'-','x','o'};
    private int[][] tabuleiro;
    private int tamanho;


  
    // criador de um novo tabuleiro
    public Tabuleiro(){
        this.tamanho = 3;
        tabuleiro = new int[tamanho][tamanho];
    }

    public Tabuleiro(int tam){
        this.tamanho = tam;
        tabuleiro = new int[tam][tam];
    }


    // função para mostrar o tabuleiro
    public void imprimeTabuleiro(){
        //System.out.println("\n -- TABULEIRO -- \n");
        //System.out.println(" Tabuleiro Atual ");
        for(int i = 0; i < tamanho; i++){
            System.out.print("\n");
            for(int j = 0; j < tamanho; j++){
                if(tabuleiro[i][j] == 0)
                    System.out.print(mapa[0]);
                else if(tabuleiro[i][j] ==-1)
                    System.out.print(mapa[1]);
                else if(tabuleiro[i][j] ==1)
                    System.out.print(mapa[2]);

                if (j!=2)  System.out.print(" | ");
            }
        }
    }

    public void imprimeGuia(){
        System.out.print("\n\n -- Guia de Posicoes -- \n\n");
       
        for(int i = 0; i < tamanho; i++){
            System.out.print("\n");
            for(int j = 0; j < tamanho; j++){
                System.out.print(i*3+j);
                if (j!=2)  System.out.print(" | ");
            }
        }
    }

    public boolean jogada(int lin, int col){
        if(tabuleiro[lin][col] == 0){
            tabuleiro[lin][col] = -1;
            return true;
        }else{
            System.out.println("Posição ocupada!");
        }
        return false;
    }

    public int[][] getTabuleiro(){
        return this.tabuleiro;
    }

    public void setTabuleiro(int[][] newTab){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                this.tabuleiro[i][j] = newTab[i][j];
            }
        }
    }

    public int getTam(){
        return this.tamanho;
    }

}

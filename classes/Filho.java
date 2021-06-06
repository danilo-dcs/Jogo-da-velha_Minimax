package classes;

public class Filho {

    // ATRIBUTOS
    private int[][] tabuleiro;
    int utilidade;


    // MÉTODOS

    public Filho(int[][] newTab){

        int tam = 3;
        this.tabuleiro = new int[tam][tam];
        
        // clonando o tabuleiro
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                this.tabuleiro[i][j] = newTab[i][j];
            }
        }
    }

    public int[][] getTabuleiro(){
        return tabuleiro;
    }

    public int getUtilidade(){
        return utilidade;
    }
    public void setUtilidade(int num){
        utilidade = num;
    }
}

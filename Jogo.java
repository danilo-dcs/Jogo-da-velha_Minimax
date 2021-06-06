import java.util.Scanner;

import classes.*;

class Jogo{

    public static void main(String [] args){

        Scanner input = new Scanner(System.in);

        Tabuleiro tab = new Tabuleiro(3);
        MinMax minimax = new MinMax(3, -1);

        int[][] mapa = {
                        {0,0}, {0,1}, {0,2},
                        {1,0}, {1,1}, {1,2},
                        {2,0}, {2,1}, {2,2},
                };

        tab.imprimeGuia();

        System.out.print("\n\n - GAME START - \n\n");
        System.out.println(" - marque com o 'x' - ");

        tab.imprimeTabuleiro();

        do{

            int[] coord;
            int pos;

            // repete enquanto a posição for inválida
            do{
                System.out.println("\n\nEscolha a posição: ");
                pos = input.nextInt();
                coord = mapa[pos];
            }while(!tab.jogada(coord[0], coord[1]));

            tab.imprimeTabuleiro();

            if(!minimax.testeTerminal(tab.getTabuleiro())){
                tab.setTabuleiro(minimax.decisao(tab.getTabuleiro()));
                System.out.println("\n\nJogada da IA: \n");
                tab.imprimeTabuleiro();
            }

        } while (!minimax.testeTerminal(tab.getTabuleiro()));

        if(minimax.vitoria(tab.getTabuleiro(), 1)){
            System.out.println("\n\n A IA VENCEU! \n\n");
        }
        else if(minimax.vitoria(tab.getTabuleiro(), -1)){
            System.out.println("\n\n VOCÊ VENCEU! \n\n");
        }
        else{
            System.out.println("\n\n EMPATE! \n\n");
        }
    }
}
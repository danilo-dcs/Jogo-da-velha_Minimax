package classes;

import java.util.ArrayList;

public class MinMax {
    
    static ArrayList<Filho> sucessores = new ArrayList<Filho> ();  // lista de sucessores

    int maxDepth;
    int tam;


    public MinMax(int tam, int maxDepth){
        this.tam = tam;

        if(maxDepth > 0) 
            this.maxDepth = maxDepth;
        else  
            this.maxDepth = Integer.MAX_VALUE;
    }

    public int[][] decisao(int[][] tab){

        sucessores.clear(); // limpando a lista de sucessores

        int v = getMax(tab, true, 1);  // utilidade máxima

        for(Filho s:sucessores){
            if(s.getUtilidade() == v){
                return s.getTabuleiro();
            }
        }

        return tab;
    }


    private int getMax (int [][] tab, boolean prim, int currentDepth){

        if(currentDepth++ > maxDepth || testeTerminal(tab)){
            return utilidade(tab);
        }

        int v = Integer.MIN_VALUE;

        for(Filho s:gerarSucessores(tab,1)){
            v = Math.max(v, getMin(s.getTabuleiro(), currentDepth));
            s.setUtilidade(v);

            if(prim){
                sucessores.add(s);
            }
        }
        return v;
    }

    private int getMin(int[][] tab, int currentDepth){
        if(currentDepth++ > maxDepth || testeTerminal(tab)){
            return utilidade(tab);
        }
        int v = Integer.MAX_VALUE;

        for(Filho s:gerarSucessores(tab,-1)){
            v = Math.min(v, getMax(s.getTabuleiro(), false, currentDepth));
            s.setUtilidade(v);
        }
        return v;
    }

    private ArrayList<Filho> gerarSucessores(int[][] tab, int v){

        ArrayList<Filho> suc = new ArrayList<Filho>();

        for(int i=0; i<tam; i++){
            for(int j=0; j<tam; j++){
                if(tab[i][j] == 0){
                    tab[i][j] = v;
                    suc.add(new Filho(tab));
                    tab[i][j] = 0;
                }
            }
        }
        return suc;
    }

    public boolean testeTerminal(int [][] tab){
        return ( vitoria(tab,1) ||  vitoria(tab,-1) || tabuleiroCheio(tab));
    }

    private int utilidade(int [][] tab){
        if( vitoria(tab,1) )
            return 1;
        else if(vitoria(tab,-1))
            return -1;
        else
            return 0;
    }

    public boolean vitoria(int[][] tab, int v){

        for(int i=0; i<tam; i++){
            if(vitoriaLinha (tab, i, v) || vitoriaColuna(tab,i,v) )
                return true;
        }

        if(vitoriaDiag1 (tab, v) || vitoriaDiag2(tab,v) )
            return true;

        return false;
    }

    private boolean vitoriaLinha(int[][] tab, int l, int v){
        for(int i=0; i < tam; i++){
            if(tab[l][i] != v)
                return false;
        }
        return true;
    }

    private boolean vitoriaColuna(int [][] tab, int c, int v){
        for(int i=0; i < tam; i++){
            if(tab[i][c] != v)
                return false;
        }
        return true;
    }

    private boolean vitoriaDiag1(int [][] tab, int v){
        for(int i=0; i < tam; i++){
            if(tab[i][i] != v)
                return false;
        }
        return true;
    }

    private boolean vitoriaDiag2(int [][] tab, int v){
        for(int i=0; i < tam; i++){
            if(tab[(tam-1)-i][i] != v)
                return false;
        }
        return true;
    }

    private boolean tabuleiroCheio(int[][] tab){
        for(int i=0; i<tam; i++){
            for(int j=0; j<tam; j++){
                if(tab[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
}

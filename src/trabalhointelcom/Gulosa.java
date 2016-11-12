/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhointelcom;

/**
 *
 * @author carlos
 */
public class Gulosa {
    private double[][] custos;
    private int[] rota;
    private int[][] coordenadas;
    private int ponto_partida;

    public Gulosa(double[][] custos, int[][] coordenadas, int ponto_partida) {
        this.custos = custos;
        this.coordenadas = coordenadas;
        this.ponto_partida = ponto_partida;
        
        rota=new int[this.custos.length];
        //Esvaziando o vetor
        for (int i = 0; i < this.custos.length; i++) {
            rota[i]=-1;
        }
        rota[0]=ponto_partida;
        
        //calculando rota
        calcula_rota(ponto_partida, 0);
    }

    public double[][] getCustos() {
        return custos;
    }

    public void setCustos(double[][] custos) {
        this.custos = custos;
    }

    public int[] getRota() {
        return rota;
    }

    public void setRota(int[] rota) {
        this.rota = rota;
    }

    public int[][] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(int[][] coordenadas) {
        this.coordenadas = coordenadas;
    }

    public int getPonto_partida() {
        return ponto_partida;
    }

    public void setPonto_partida(int ponto_partida) {
        this.ponto_partida = ponto_partida;
    }
    
    private double[][] calcula_custos(int ponto){
        double[][] aux= new double[this.custos.length][2];
        double troca;
        for (int i = 0; i < this.custos.length; i++) {
            aux[i][0]=i;
            aux[i][1]=this.custos[ponto][i];
        }
        //ordenando de Forma crescente
        for (int i = 0; i < aux.length-1; i++) {
            for (int j = i+1; j < aux.length; j++) {
                if(aux[i][1]>aux[j][1]){
                    troca= aux[i][1];
                    aux[i][1]=aux[j][1];
                    aux[j][1]=troca; 
                    
                    troca= aux[i][0];
                    aux[i][0]=aux[j][0];
                    aux[j][0]=troca;
                }     
            }
        }
        return aux;
    }
    
    private boolean usado(int ponto){
        boolean aux = false;
        for (int i = 0; i < this.custos.length; i++) {
            if(this.rota[i]==ponto){
                aux=true;
            }
        }
        return aux;
    }
    
    private void calcula_rota(int ponto_atual, int cont_rota){
        double custos_do_ponto_atual[][] = calcula_custos(ponto_atual);
        
        
        int i=0;
        while (usado((int)custos_do_ponto_atual[i][0])) {            
           i++;
        }
        cont_rota++;
        this.rota[cont_rota]=(int)custos_do_ponto_atual[i][0];
        ponto_atual = (int)custos_do_ponto_atual[i][0];
        
        if (cont_rota<this.custos.length-1) {
            calcula_rota(ponto_atual, cont_rota);   
        }
    }
}

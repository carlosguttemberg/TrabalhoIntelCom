/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Ronaldo Jão
package trabalhointelcom;

/**
 *
 * @author carlos
 */
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class Pontos  extends JPanel{
    private int vertices;
    private int[][] coordenadas; 
    private double[][] custos; //Irá armazenar a distância entre todos os pontos
    private int largura, altura;
    
    public double[][] getCustos() {
        return custos;
    }

    public void setCustos(double[][] custos) {
        this.custos = custos;
    }

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public int[][] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(int[][] coordenadas) {
        this.coordenadas = coordenadas;
    }
    
    public Pontos(int vertices, int largura, int altura){
        this.coordenadas=new int[vertices][2];
        this.custos=new double[vertices][vertices];
        this.vertices=vertices;
        this.largura = largura;
        this.altura = altura;
        gerar();
        calcula_custos();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        //Desenhando os vértices gerados
        for (int i=0; i<this.vertices;i++){
           g.drawOval(this.coordenadas[i][0], this.coordenadas[i][1], 10, 10);
           g.drawString(" "+(i), this.coordenadas[i][0], this.coordenadas[i][1]);
        }
        
        //Desenhando uma linha interligando todos os vértices
        for (int i=0;i<this.vertices;i++){
            for (int j=0;j<this.vertices;j++){
                if (i!=j){
                    g.drawLine(this.coordenadas[i][0],this.coordenadas[i][1],this.coordenadas[j][0],this.coordenadas[j][1]);
                }
            }
        }
        
    } 
    
    public void gerar(){
        Random r = new Random();
        int x, y;
        for (int i=0; i<this.vertices;i++){
            x=r.nextInt(largura);
            y=r.nextInt(altura);
            this.coordenadas[i][0]=x;
            this.coordenadas[i][1]=y;
        }
    }
    
    public void calcula_custos(){
        double h,a,b;
        for (int i=0;i<this.vertices;i++){
            for (int j=0;j<this.vertices;j++){
                if (i==j){
                    h=0;
                }else{
                    a=Math.abs(this.coordenadas[i][0]-this.coordenadas[j][0]);
                    b=Math.abs(this.coordenadas[i][1]-this.coordenadas[j][1]);
                    h=Math.sqrt(a*a+b*b);
                }
                this.custos[i][j]=h;
            }
        }
    }
}

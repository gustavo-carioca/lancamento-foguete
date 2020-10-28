
package projetolançamento;
import java.util.Scanner;

/*
Feito por Matheus Cunha - 21473811 &&
Gustavo Carioca - 21377252
*/

public class ProjetoLançamento {
    
   
    //Constante que representa a aceleração da gravidade.
    static final double ACELERACAO = 9.81;
     
    static double calcularAlcance(double velocity, double angle) {
    return  2 * Math.pow(velocity, 2) * Math.cos(angle) * Math.sin(angle) / ACELERACAO;
    }
    
    
    static double calcularTempo(double velocity, double angle) {
    return  2 * velocity * Math.sin(angle) / ACELERACAO;                      
    }
    
     static double calcularAlturaMaxima(double velocity, double angle) {
     return  Math.pow(velocity, 2) * Math.pow(Math.sin(angle), 2) / (2 * ACELERACAO);
    }
    
    
     static Status calcularResultado(double range, double distance, double size) {
    //              (errou)               (acertou)              (errou)
    // ______________________________===================________________________
    //              distancia              tamanho                passou
    //
    // ------------------------------*                *-------------------------
    //                 distancia +1 <|                |> distancia + tamanho -1
    
    double distanciaMinimaAcerto = distance + 1;
    double distanciaMaximaAcerto = distance + size - 1;
    
    if (range < distanciaMinimaAcerto) {
    return Status.nao_alcancou;
          
    } else if (range > distanciaMaximaAcerto) {
    return Status.passou;
          
    } else {
    return Status.acertou;
    }
          
    }
    
    
    enum Status {
    nao_alcancou("Não chegou no alvo"),
    passou("Passou do alvo"),
    acertou ("Na mosca");
    
    final String status;
    
    Status(String status) {
    this.status = status;
    }
    
    @Override
    public String toString(){
    return status;
    }
    
    }
    
    public static void main(String[] args) {
    Scanner entry = new Scanner(System.in);
    
    // <----- Dados do alvo ----->
    double size; // 20 >= tamanho <= 50
    double distance;
    
    // <----- Descrição do Canhão ----->
    double velocity;
    double angle;      // 0 < angulo < 90
    
    // <----- Dados de resultado ------->
    double range;
    double maxHeight;
    double time;
    Status results;
    
    
    // <----- Entrada de dados ------>
    do {
    System.out.print("Target Size [ 20 - 49 ]: ");
    size = entry.nextDouble();
    
    } while (size < 20 || size >= 50);
    
    System.out.print("Distância do alvo: ");
    distance = entry.nextDouble();
    entry.nextLine();
    distance = Math.abs(distance);
    
    System.out.print("Velocidade do Projétil: ");
    velocity = entry.nextDouble();
    // <------ Utilizando a classe abs para que o valor seja positivo ------->
    velocity = Math.abs(velocity);
    
    do {
    System.out.print("Angle of cannon [ 1 - 89 ]: ");
    angle = entry.nextDouble();    
    } while (angle <= 0 || angle >= 90);
    
    // <------ Converte graus para radianos ------>
    angle = Math.toRadians(angle);
    // <----- Entrada de dados ----->
    
    // <----- Cálculos ----->
    range = calcularAlcance(velocity, angle);
    maxHeight = calcularAlturaMaxima(velocity, angle);
    time = calcularTempo(velocity, angle);
    results = calcularResultado(range, distance, size);
    // <----- Cálculos ----->
    
   
    System.out.println("---------------ALVO-----------------");
    System.out.println("TARGET: ");
    System.out.println("Size =  " + size);
    System.out.println("Distance =  " + distance);
    System.out.println("---------------CANHÃO---------------");
    System.out.println("Cannon: ");
    System.out.println("Speeed =  " + velocity);
    System.out.println("Angle (-- G --) =  " + Math.toDegrees(angle));
    System.out.println("Angle (-- R --) =  " + angle);
    System.out.println("---------------RESULTADO------------");
    System.out.println("Result: ");
    System.out.println("Range =  " + range);
    System.out.println("Maximum Height =  " + maxHeight);
    System.out.println("Time =  " + time);
    System.out.println("Result =  " + results);
    System.out.println("------------------------------------");
    
    }
    
    
    
}
    

     
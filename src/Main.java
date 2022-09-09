import java.io.InputStream;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main{
    public static void main(String[] args){
        Scanner scan;
        scan = new Scanner(System.in);
        DecimalFormat decimal = new DecimalFormat("0.00");

        String[] carros = {"FORD-KA","FORD-KA","FORD-KA","AUDI-A1",
                "AUDI-A1","FIAT-UNO","AUDI-A4","CITROEN-C3","CITROEN-C3",
                "RENAULT-CLIO","RENAULT-CLIO","MERCEDES-BENS-ACTROS",""};
        String[] placas = {"JGF-8573","JGE-9393","JGM-4773","JGE-0620",
                "JGE-4583","JGG-7389","JMM-7513","JWM-1235","JHM-7491",
                "KRM-6771","JGE-0611","LOG-2008",""};
        int[] litros = {55,55,55,45,45,48,65,47,47,50,50,535,0};


        int tempoGasolina, tempoEtanol, tempoDiesel, i=0, opcao;
        int[] litrosBombas= {0,0,0};
        double[] valorBombas= {0,0,0};
        double[] precoCarro = {0,0,0};

        do {
            if(i<=5) {
                tempoGasolina = litros[i]/10;
                System.out.println("[00:0"+ tempoGasolina+"]"+"Veículo modelo "+carros[i]
                        +", placa "+ placas[i]
                        +" foi abastecido com " + litros[i]+ " litros de GASOLINA");
                precoCarro[0]= litros[i]*2.90;
                System.out.println("Total a pagar: R$"+decimal.format(precoCarro[0])+" reais");
                litrosBombas[0]=litrosBombas[0]+litros[i];
            }else if(i>5&&i<11){
                tempoEtanol = litros[i]/12;
                System.out.println("[00:0"+ tempoEtanol+"]"+"Veículo modelo "+carros[i]
                        +", placa "+ placas[i]
                        +" foi abastecido com " + litros[i]+ " litros de ETANOL.");
                precoCarro[1] = litros[i]*2.27;
                System.out.println("Total a pagar: R$"+decimal.format(precoCarro[1])+" reais");
                litrosBombas[1]=litrosBombas[1]+litros[i];
            }
            if(i==11) {
                tempoDiesel=litros[i]/15;
                System.out.println("[00:"+ tempoDiesel +"]"+"Veículo modelo "+carros[i]
                        +", placa "+ placas[i]
                        +" foi abastecido com " + litros[i]+ " litros de "+"DIESEL");
                precoCarro[2] = litros[i]*3.75;
                System.out.println("Total a pagar: R$"+decimal.format(precoCarro[2])+" reais");
                litrosBombas[2]=litrosBombas[2]+litros[i];
            }
            System.out.println("Deseja continuar ?\n1-Sim\n2-Não\n");
            opcao = scan.nextInt();
            i=i+1;
            if(i>11) {
                System.out.println("Não tem mais carro para abastecer");
                break;
            }
        }while(opcao==1);

        valorBombas[0]=litrosBombas[0]*2.9;
        valorBombas[1]=litrosBombas[1]*2.27;
        valorBombas[2]=litrosBombas[2]*3.75;
        double valorTotal=valorBombas[0]+valorBombas[1]+valorBombas[2];

        System.out.println("Total abastecido na bomba 1 (GASOLINA): "+litrosBombas[0]+" litros");
        System.out.println("Total recebido na bomba 1 (GASOLINA): R$"+decimal.format(valorBombas[0])+" reais");
        System.out.println("Total abastecido na bomba 2 (ETANOL): "+litrosBombas[1]+" litros");
        System.out.println("Total recebido na bomba 2 (ETANOL): R$"+decimal.format(valorBombas[1])+" reais");
        System.out.println("Total abastecido na bomba 3 (DIESEL): "+litrosBombas[2]+" litros");
        System.out.println("Total recebido na bomba 3 (DIESEL): R$"+decimal.format(valorBombas[2])+" reais");

        System.out.println("Total recebido no Posto: R$"+ decimal.format(valorTotal) + " reais");
    }
}

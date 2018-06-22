package dragon.worldadventure.Algoritmos;

import java.util.Random;

import dragon.worldadventure.Objects.AppData;

public class TravelXPRewards {

    public static final int ValorSorte1 = 2000;
    public static final int ValorSorte2 = 6000;
    public static final int ValorSorte3 = 8000;
    public static final int ValorSorte4 = 9501;
    public static final int ValorMaximoSorte = 10000;
    private double userheroluck;
    private boolean reroll=false;
    private int lucknumber=0;



    private int NumeroAleatorio(){
        Random r = new Random();
        int min = 1;
        int max = ValorMaximoSorte;

        return r.nextInt(max - min + 1) + min;
    }

    private void GetLuck (){
           userheroluck= AppData.selectedstats.getLuck();
    }

    private void Lucktime(){
        GetLuck();
        lucknumber=0;
        for(double i=1;i<userheroluck;i++){
            int numero=NumeroAleatorio();
            if(numero>lucknumber){
                numero = numero/2;
                lucknumber+=numero;
            }

        }
    }

    /**
     * a sorte vai de 1 a 1000
     * de 1 a 2000 nao vai dar nada
     * de 2001 a 6000 vai dar um exp aleatorio entre 1 a 3
     * de 6001 a 7000 vai encontrar um inimigo
     * de 7001 a 9500 vai dar um exp aleatorio entre 5 a 10
     * de 9501 a 10000 vai voltar a fazer rerrol da sorte e oferece um item
     * @return
     */
    private void DefineBonus(){
        if(lucknumber< ValorSorte1){

        }
        else if(lucknumber< ValorSorte2){

            Random r = new Random();
            int min = 1;
            int max = 3;


            int randomnumber = r.nextInt(max - min + 1) + min;

            AppData.stepxp= (double) randomnumber;
        }
        else if(lucknumber< ValorSorte3){

            AppData.enemy=true;

        }
        else if(lucknumber< ValorSorte4){
            Random r = new Random();
            int min = 5;
            int max = 10;


            int randomnumber = r.nextInt(max - min + 1) + min;

            AppData.stepxp= (double) randomnumber;
        }
    }

    public void TaketheStep(){
        Lucktime();
        DefineBonus();
    }


}

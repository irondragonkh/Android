package dragon.worldadventure.Algoritmos;

import java.util.Random;

import dragon.worldadventure.Objects.AppData;

public class TravelXPandBatlleFunc {

    private double userheroluck;
    private boolean reroll=false;
    private int lucknumber=0;



    private int NumeroAleatorio(){
        Random r = new Random();
        int min = 1;
        int max = 10000;


        int randomnumber = r.nextInt(max - min + 1) + min;

        return randomnumber;
    }

    private void GetLuck (){
        if (AppData.selectedherotab1){
           userheroluck= AppData.stats1.getLuck();
        }else if(AppData.selectedherotab2){
            userheroluck= AppData.stats2.getLuck();
        }else if(AppData.selectedherotab3){
            userheroluck= AppData.stats3.getLuck();
        }
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
        if(lucknumber<2000){

        }
        else if(lucknumber<6000){

            Random r = new Random();
            int min = 1;
            int max = 3;


            int randomnumber = r.nextInt(max - min + 1) + min;

            AppData.stepxp= (double) randomnumber;
        }
        else if(lucknumber<7000){

            AppData.enemy=true;

        }
        else if(lucknumber<9501){
            Random r = new Random();
            int min = 5;
            int max = 10;


            int randomnumber = r.nextInt(max - min + 1) + min;

            AppData.stepxp= (double) randomnumber;
        }else if((reroll==false)&&(lucknumber<9500)){
            reroll=true;
        }
    }

    public void TaketheStep(){
        Lucktime();
        DefineBonus();
    }


}

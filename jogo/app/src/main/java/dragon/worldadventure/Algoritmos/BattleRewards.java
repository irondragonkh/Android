package dragon.worldadventure.Algoritmos;

import java.util.Random;

import dragon.worldadventure.Objects.AppData;

public class BattleRewards {

    public static final int Sortevalor1 = 2000;
    public static final int SorteValor2 = 6000;
    public static final int SorteValor3 = 7000;
    public static final int SorteValor4 = 9501;
    private int lucknumber=0;

    private int NumeroAleatorio(){
        Random r = new Random();
        int min = 1;
        int max = 10000;

        return r.nextInt(max - min + 1) + min;
    }

    private void DefineBonus(){
        lucknumber=NumeroAleatorio();
        if(lucknumber< Sortevalor1){
            Random r = new Random();
            int min = 5;
            int max = 9;


            int randomnumber = r.nextInt(max - min + 1) + min;

            AppData.stepxp= (double) randomnumber;
        }
        else if(lucknumber< SorteValor2){

            Random r = new Random();
            int min = 9;
            int max = 13;


            int randomnumber = r.nextInt(max - min + 1) + min;

            AppData.stepxp= (double) randomnumber;
        }
        else if(lucknumber< SorteValor3){

            Random r = new Random();
            int min = 13;
            int max = 17;


            int randomnumber = r.nextInt(max - min + 1) + min;

            AppData.stepxp= (double) randomnumber;

        }
        else if(lucknumber< SorteValor4){
            Random r = new Random();
            int min = 17;
            int max = 25;


            int randomnumber = r.nextInt(max - min + 1) + min;

            AppData.stepxp= (double) randomnumber;
        }
    }

    public void GiveRewards(){
        DefineBonus();
    }
}

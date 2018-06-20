package dragon.worldadventure.Algoritmos;

import java.util.Random;

import dragon.worldadventure.Objects.AppData;

public class BattleRewards {

    private int lucknumber=0;

    private int NumeroAleatorio(){
        Random r = new Random();
        int min = 1;
        int max = 10000;

        return r.nextInt(max - min + 1) + min;
    }

    private void DefineBonus(){
        lucknumber=NumeroAleatorio();
        if(lucknumber<2000){
            Random r = new Random();
            int min = 5;
            int max = 9;


            int randomnumber = r.nextInt(max - min + 1) + min;

            AppData.stepxp= (double) randomnumber;
        }
        else if(lucknumber<6000){

            Random r = new Random();
            int min = 9;
            int max = 13;


            int randomnumber = r.nextInt(max - min + 1) + min;

            AppData.stepxp= (double) randomnumber;
        }
        else if(lucknumber<7000){

            Random r = new Random();
            int min = 13;
            int max = 17;


            int randomnumber = r.nextInt(max - min + 1) + min;

            AppData.stepxp= (double) randomnumber;

        }
        else if(lucknumber<9501){
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

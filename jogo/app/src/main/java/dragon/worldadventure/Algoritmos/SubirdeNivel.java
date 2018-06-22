package dragon.worldadventure.Algoritmos;

import java.util.Random;

import dragon.worldadventure.Objects.AppData;

public class SubirdeNivel {

    public void LeveluponStep (){

        /***
         * falta aqui aumentar os stats-------------------------------
         */
        double experinciaatual;


            experinciaatual=AppData.selectedstats.getCurrentxp();
            experinciaatual+=AppData.stepxp;
          if(AppData.selectedlevel.getXp()==experinciaatual){
              AppData.levelup=true;
          }else if(experinciaatual>AppData.selectedlevel.getXp()){
              AppData.levelup=true;
              AppData.expparanextlevel=experinciaatual-AppData.selectedlevel.getXp();
          }

    }

    public void GiveStepxp(){

        double experinciaatual;
            experinciaatual=AppData.selectedstats.getCurrentxp();
            experinciaatual+=AppData.stepxp;
            AppData.selectedstats.setCurrentxp(experinciaatual);

    }

    public void AppDataLevelupParameteresForExp(){


            AppData.selectedstats.setCurrentxp(AppData.expparanextlevel);
            AppData.selectedusedhero.setLevelid(AppData.selectedusedhero.getLevelid()+1);

    }

    public void AppDataLevelupStatsUpdate(){
        int hp;
        int atk;
        int defence;


          if(AppData.selectedhero.getId()==1){

              hp=GenerateRandomNewStats();

              if (hp<500){
                  AppData.selectedstats.setHp(AppData.selectedstats.getHp()+2);
              }else if (hp<700){
                  AppData.selectedstats.setHp(AppData.selectedstats.getHp()+3);
              }else if (hp<900){
                  AppData.selectedstats.setHp(AppData.selectedstats.getHp()+4);
              }else{
                  AppData.selectedstats.setHp(AppData.selectedstats.getHp()+5);
              }

              atk=GenerateRandomNewStats();

              if (atk<500){
                    AppData.selectedstats.setAtk(AppData.selectedstats.getAtk()+3);
              }else if(atk<700){
                    AppData.selectedstats.setAtk(AppData.selectedstats.getAtk()+4);
              }else if(atk<900){
                  AppData.selectedstats.setAtk(AppData.selectedstats.getAtk()+5);
              }else{
                  AppData.selectedstats.setAtk(AppData.selectedstats.getAtk()+6);
              }

              defence=GenerateRandomNewStats();

              if (defence<500){
                    AppData.selectedstats.setDefense(AppData.selectedstats.getDefense()+1);
              }else if(defence<700){
                  AppData.selectedstats.setDefense(AppData.selectedstats.getDefense()+2);
              }else if(defence<900){
                  AppData.selectedstats.setDefense(AppData.selectedstats.getDefense()+3);
              }else{
                  AppData.selectedstats.setDefense(AppData.selectedstats.getDefense()+4);
              }

          }
            if(AppData.selectedhero.getId()==2){

                hp=GenerateRandomNewStats();

                if (hp<500){
                    AppData.selectedstats.setHp(AppData.selectedstats.getHp()+1);
                }else if (hp<700){
                    AppData.selectedstats.setHp(AppData.selectedstats.getHp()+2);
                }else if (hp<900){
                    AppData.selectedstats.setHp(AppData.selectedstats.getHp()+3);
                }else{
                    AppData.selectedstats.setHp(AppData.selectedstats.getHp()+4);
                }

                atk=GenerateRandomNewStats();

                if (atk<500){
                    AppData.selectedstats.setAtk(AppData.selectedstats.getAtk()+7);
                }else if(atk<700){
                    AppData.selectedstats.setAtk(AppData.selectedstats.getAtk()+8);
                }else if(atk<900){
                    AppData.selectedstats.setAtk(AppData.selectedstats.getAtk()+9);
                }else{
                    AppData.selectedstats.setAtk(AppData.selectedstats.getAtk()+10);
                }

                defence=GenerateRandomNewStats();

                if (defence<500){
                    AppData.selectedstats.setDefense(AppData.selectedstats.getDefense()+1);
                }else if(defence<700){
                    AppData.selectedstats.setDefense(AppData.selectedstats.getDefense()+2);
                }else if(defence<900){
                    AppData.selectedstats.setDefense(AppData.selectedstats.getDefense()+3);
                }else{
                    AppData.selectedstats.setDefense(AppData.selectedstats.getDefense()+4);
                }

            }
            if(AppData.selectedhero.getId()==3){

                hp=GenerateRandomNewStats();

                if (hp<500){
                    AppData.selectedstats.setHp(AppData.selectedstats.getHp()+3);
                }else if (hp<700){
                    AppData.selectedstats.setHp(AppData.selectedstats.getHp()+4);
                }else if (hp<900){
                    AppData.selectedstats.setHp(AppData.selectedstats.getHp()+5);
                }else{
                    AppData.selectedstats.setHp(AppData.selectedstats.getHp()+6);
                }

                atk=GenerateRandomNewStats();

                if (atk<500){
                    AppData.selectedstats.setAtk(AppData.selectedstats.getAtk()+1);
                }else if(atk<700){
                    AppData.selectedstats.setAtk(AppData.selectedstats.getAtk()+2);
                }else if(atk<900){
                    AppData.selectedstats.setAtk(AppData.selectedstats.getAtk()+3);
                }else{
                    AppData.selectedstats.setAtk(AppData.selectedstats.getAtk()+4);
                }

                defence=GenerateRandomNewStats();

                if (defence<500){
                    AppData.selectedstats.setDefense(AppData.selectedstats.getDefense()+2);
                }else if(defence<700){
                    AppData.selectedstats.setDefense(AppData.selectedstats.getDefense()+3);
                }else if(defence<900){
                    AppData.selectedstats.setDefense(AppData.selectedstats.getDefense()+4);
                }else{
                    AppData.selectedstats.setDefense(AppData.selectedstats.getDefense()+5);
                }

            }
            if(AppData.selectedhero.getId()==4){

                hp=GenerateRandomNewStats();

                if (hp<500){
                    AppData.selectedstats.setHp(AppData.selectedstats.getHp()+1);
                }else if (hp<700){
                    AppData.selectedstats.setHp(AppData.selectedstats.getHp()+2);
                }else if (hp<900){
                    AppData.selectedstats.setHp(AppData.selectedstats.getHp()+3);
                }else{
                    AppData.selectedstats.setHp(AppData.selectedstats.getHp()+4);
                }

                atk=GenerateRandomNewStats();

                if (atk<500){
                    AppData.selectedstats.setAtk(AppData.selectedstats.getAtk()+3);
                }else if(atk<700){
                    AppData.selectedstats.setAtk(AppData.selectedstats.getAtk()+4);
                }else if(atk<900){
                    AppData.selectedstats.setAtk(AppData.selectedstats.getAtk()+5);
                }else{
                    AppData.selectedstats.setAtk(AppData.selectedstats.getAtk()+6);
                }

                defence=GenerateRandomNewStats();

                if (defence<500){
                    AppData.selectedstats.setDefense(AppData.selectedstats.getDefense()+2);
                }else if(defence<700){
                    AppData.selectedstats.setDefense(AppData.selectedstats.getDefense()+3);
                }else if(defence<900){
                    AppData.selectedstats.setDefense(AppData.selectedstats.getDefense()+4);
                }else{
                    AppData.selectedstats.setDefense(AppData.selectedstats.getDefense()+5);
                }

            }
            if(AppData.selectedhero.getId()==5){

                hp=GenerateRandomNewStats();

                if (hp<500){
                    AppData.selectedstats.setHp(AppData.selectedstats.getHp()+1);
                }else if (hp<700){
                    AppData.selectedstats.setHp(AppData.selectedstats.getHp()+2);
                }else if (hp<900){
                    AppData.selectedstats.setHp(AppData.selectedstats.getHp()+3);
                }else{
                    AppData.selectedstats.setHp(AppData.selectedstats.getHp()+4);
                }

                atk=GenerateRandomNewStats();

                if (atk<500){
                    AppData.selectedstats.setAtk(AppData.selectedstats.getAtk()+1);
                }else if(atk<700){
                    AppData.selectedstats.setAtk(AppData.selectedstats.getAtk()+2);
                }else if(atk<900){
                    AppData.selectedstats.setAtk(AppData.selectedstats.getAtk()+3);
                }else{
                    AppData.selectedstats.setAtk(AppData.selectedstats.getAtk()+4);
                }

                defence=GenerateRandomNewStats();

                if (defence<500){
                    AppData.selectedstats.setDefense(AppData.selectedstats.getDefense()+7);
                }else if(defence<700){
                    AppData.selectedstats.setDefense(AppData.selectedstats.getDefense()+8);
                }else if(defence<900){
                    AppData.selectedstats.setDefense(AppData.selectedstats.getDefense()+9);
                }else{
                    AppData.selectedstats.setDefense(AppData.selectedstats.getDefense()+10);
                }

            }

    }

    public int GenerateRandomNewStats(){

        Random r = new Random();

        int min = 1;
        int max = 10;

        int randomnumber = r.nextInt(max - min + 1) + min;
        return randomnumber;

    }
}

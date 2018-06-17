package dragon.worldadventure.Algoritmos;

import java.util.Random;

import dragon.worldadventure.Objects.AppData;

public class SubirdeNivel {

    public void LeveluponStep (){

        /***
         * falta aqui aumentar os stats-------------------------------
         */
        double experinciaatual;

        if(AppData.selectedherotab1){
            experinciaatual=AppData.stats1.getCurrentxp();
            experinciaatual+=AppData.stepxp;
          if(AppData.leveltab1.getXp()==experinciaatual){
              AppData.levelup=true;
          }else if(experinciaatual>AppData.leveltab1.getXp()){
              AppData.levelup=true;
              AppData.expparanextlevel=experinciaatual-AppData.leveltab1.getXp();
          }

        }
        else if(AppData.selectedherotab2){
            experinciaatual=AppData.stats2.getCurrentxp();
            experinciaatual+=AppData.stepxp;
            if(AppData.leveltab2.getXp()==experinciaatual){
                AppData.levelup=true;
            }else if(experinciaatual>AppData.leveltab2.getXp()){
                AppData.levelup=true;
                AppData.expparanextlevel=experinciaatual-AppData.leveltab2.getXp();
            }
        }
        else if(AppData.selectedherotab3){
            experinciaatual=AppData.stats3.getCurrentxp();
            experinciaatual+=AppData.stepxp;
            if(AppData.leveltab3.getXp()==experinciaatual){
                AppData.levelup=true;
            }else if(experinciaatual>AppData.leveltab3.getXp()){
                AppData.levelup=true;
                AppData.expparanextlevel=experinciaatual-AppData.leveltab3.getXp();
            }
        }
    }

    public void GiveStepxp(){
        double experinciaatual;
        if(AppData.selectedherotab1){
            experinciaatual=AppData.stats1.getCurrentxp();
            experinciaatual+=AppData.stepxp;
            AppData.stats1.setCurrentxp(experinciaatual);


        }else if(AppData.selectedherotab2){
            experinciaatual=AppData.stats2.getCurrentxp();
            experinciaatual+=AppData.stepxp;
            AppData.stats2.setCurrentxp(experinciaatual);


        }else if(AppData.selectedherotab3) {
            experinciaatual = AppData.stats3.getCurrentxp();
            experinciaatual += AppData.stepxp;
            AppData.stats3.setCurrentxp(experinciaatual);
        }
    }

    public void AppDataLevelupParameteresForExp(){

        if(AppData.selectedherotab1){
            AppData.stats1.setCurrentxp(AppData.expparanextlevel);
            AppData.userHero1.setLevelid(AppData.userHero1.getLevelid()+1);

        }else if(AppData.selectedherotab2){
            AppData.stats2.setCurrentxp(AppData.expparanextlevel);
            AppData.userHero2.setLevelid(AppData.userHero2.getLevelid()+1);


        }else if(AppData.selectedherotab3) {
            AppData.stats3.setCurrentxp(AppData.expparanextlevel);
            AppData.userHero3.setLevelid(AppData.userHero3.getLevelid()+1);
        }
    }

    public void AppDataLevelupStatsUpdate(){
        int hp;
        int atk;
        int defence;

        if(AppData.selectedherotab1){
          if(AppData.herotab1.getId()==1){

              hp=GenerateRandomNewStats();

              if (hp<500){
                  AppData.stats1.setHp(AppData.stats1.getHp()+2);
              }else if (hp<700){
                  AppData.stats1.setHp(AppData.stats1.getHp()+3);
              }else if (hp<900){
                  AppData.stats1.setHp(AppData.stats1.getHp()+4);
              }else{
                  AppData.stats1.setHp(AppData.stats1.getHp()+5);
              }

              atk=GenerateRandomNewStats();

              if (atk<500){
                    AppData.stats1.setAtk(AppData.stats1.getAtk()+3);
              }else if(atk<700){
                    AppData.stats1.setAtk(AppData.stats1.getAtk()+4);
              }else if(atk<900){
                  AppData.stats1.setAtk(AppData.stats1.getAtk()+5);
              }else{
                  AppData.stats1.setAtk(AppData.stats1.getAtk()+6);
              }

              defence=GenerateRandomNewStats();

              if (defence<500){
                    AppData.stats1.setDefense(AppData.stats1.getDefense()+1);
              }else if(defence<700){
                  AppData.stats1.setDefense(AppData.stats1.getDefense()+2);
              }else if(defence<900){
                  AppData.stats1.setDefense(AppData.stats1.getDefense()+3);
              }else{
                  AppData.stats1.setDefense(AppData.stats1.getDefense()+4);
              }

          }
            if(AppData.herotab1.getId()==2){

                hp=GenerateRandomNewStats();

                if (hp<500){
                    AppData.stats1.setHp(AppData.stats1.getHp()+1);
                }else if (hp<700){
                    AppData.stats1.setHp(AppData.stats1.getHp()+2);
                }else if (hp<900){
                    AppData.stats1.setHp(AppData.stats1.getHp()+3);
                }else{
                    AppData.stats1.setHp(AppData.stats1.getHp()+4);
                }

                atk=GenerateRandomNewStats();

                if (atk<500){
                    AppData.stats1.setAtk(AppData.stats1.getAtk()+7);
                }else if(atk<700){
                    AppData.stats1.setAtk(AppData.stats1.getAtk()+8);
                }else if(atk<900){
                    AppData.stats1.setAtk(AppData.stats1.getAtk()+9);
                }else{
                    AppData.stats1.setAtk(AppData.stats1.getAtk()+10);
                }

                defence=GenerateRandomNewStats();

                if (defence<500){
                    AppData.stats1.setDefense(AppData.stats1.getDefense()+1);
                }else if(defence<700){
                    AppData.stats1.setDefense(AppData.stats1.getDefense()+2);
                }else if(defence<900){
                    AppData.stats1.setDefense(AppData.stats1.getDefense()+3);
                }else{
                    AppData.stats1.setDefense(AppData.stats1.getDefense()+4);
                }

            }
            if(AppData.herotab1.getId()==3){

                hp=GenerateRandomNewStats();

                if (hp<500){
                    AppData.stats1.setHp(AppData.stats1.getHp()+3);
                }else if (hp<700){
                    AppData.stats1.setHp(AppData.stats1.getHp()+4);
                }else if (hp<900){
                    AppData.stats1.setHp(AppData.stats1.getHp()+5);
                }else{
                    AppData.stats1.setHp(AppData.stats1.getHp()+6);
                }

                atk=GenerateRandomNewStats();

                if (atk<500){
                    AppData.stats1.setAtk(AppData.stats1.getAtk()+1);
                }else if(atk<700){
                    AppData.stats1.setAtk(AppData.stats1.getAtk()+2);
                }else if(atk<900){
                    AppData.stats1.setAtk(AppData.stats1.getAtk()+3);
                }else{
                    AppData.stats1.setAtk(AppData.stats1.getAtk()+4);
                }

                defence=GenerateRandomNewStats();

                if (defence<500){
                    AppData.stats1.setDefense(AppData.stats1.getDefense()+2);
                }else if(defence<700){
                    AppData.stats1.setDefense(AppData.stats1.getDefense()+3);
                }else if(defence<900){
                    AppData.stats1.setDefense(AppData.stats1.getDefense()+4);
                }else{
                    AppData.stats1.setDefense(AppData.stats1.getDefense()+5);
                }

            }
            if(AppData.herotab1.getId()==4){

                hp=GenerateRandomNewStats();

                if (hp<500){
                    AppData.stats1.setHp(AppData.stats1.getHp()+1);
                }else if (hp<700){
                    AppData.stats1.setHp(AppData.stats1.getHp()+2);
                }else if (hp<900){
                    AppData.stats1.setHp(AppData.stats1.getHp()+3);
                }else{
                    AppData.stats1.setHp(AppData.stats1.getHp()+4);
                }

                atk=GenerateRandomNewStats();

                if (atk<500){
                    AppData.stats1.setAtk(AppData.stats1.getAtk()+3);
                }else if(atk<700){
                    AppData.stats1.setAtk(AppData.stats1.getAtk()+4);
                }else if(atk<900){
                    AppData.stats1.setAtk(AppData.stats1.getAtk()+5);
                }else{
                    AppData.stats1.setAtk(AppData.stats1.getAtk()+6);
                }

                defence=GenerateRandomNewStats();

                if (defence<500){
                    AppData.stats1.setDefense(AppData.stats1.getDefense()+2);
                }else if(defence<700){
                    AppData.stats1.setDefense(AppData.stats1.getDefense()+3);
                }else if(defence<900){
                    AppData.stats1.setDefense(AppData.stats1.getDefense()+4);
                }else{
                    AppData.stats1.setDefense(AppData.stats1.getDefense()+5);
                }

            }
            if(AppData.herotab1.getId()==5){

                hp=GenerateRandomNewStats();

                if (hp<500){
                    AppData.stats1.setHp(AppData.stats1.getHp()+1);
                }else if (hp<700){
                    AppData.stats1.setHp(AppData.stats1.getHp()+2);
                }else if (hp<900){
                    AppData.stats1.setHp(AppData.stats1.getHp()+3);
                }else{
                    AppData.stats1.setHp(AppData.stats1.getHp()+4);
                }

                atk=GenerateRandomNewStats();

                if (atk<500){
                    AppData.stats1.setAtk(AppData.stats1.getAtk()+1);
                }else if(atk<700){
                    AppData.stats1.setAtk(AppData.stats1.getAtk()+2);
                }else if(atk<900){
                    AppData.stats1.setAtk(AppData.stats1.getAtk()+3);
                }else{
                    AppData.stats1.setAtk(AppData.stats1.getAtk()+4);
                }

                defence=GenerateRandomNewStats();

                if (defence<500){
                    AppData.stats1.setDefense(AppData.stats1.getDefense()+7);
                }else if(defence<700){
                    AppData.stats1.setDefense(AppData.stats1.getDefense()+8);
                }else if(defence<900){
                    AppData.stats1.setDefense(AppData.stats1.getDefense()+9);
                }else{
                    AppData.stats1.setDefense(AppData.stats1.getDefense()+10);
                }

            }

        }else if(AppData.selectedherotab2){

            if(AppData.herotab2.getId()==1){

                hp=GenerateRandomNewStats();

                if (hp<500){
                    AppData.stats2.setHp(AppData.stats2.getHp()+2);
                }else if (hp<700){
                    AppData.stats2.setHp(AppData.stats2.getHp()+3);
                }else if (hp<900){
                    AppData.stats2.setHp(AppData.stats2.getHp()+4);
                }else{
                    AppData.stats2.setHp(AppData.stats2.getHp()+5);
                }

                atk=GenerateRandomNewStats();

                if (atk<500){
                    AppData.stats2.setAtk(AppData.stats2.getAtk()+3);
                }else if(atk<700){
                    AppData.stats2.setAtk(AppData.stats2.getAtk()+4);
                }else if(atk<900){
                    AppData.stats2.setAtk(AppData.stats2.getAtk()+5);
                }else{
                    AppData.stats2.setAtk(AppData.stats2.getAtk()+6);
                }

                defence=GenerateRandomNewStats();

                if (defence<500){
                    AppData.stats2.setDefense(AppData.stats2.getDefense()+1);
                }else if(defence<700){
                    AppData.stats2.setDefense(AppData.stats2.getDefense()+2);
                }else if(defence<900){
                    AppData.stats2.setDefense(AppData.stats2.getDefense()+3);
                }else{
                    AppData.stats2.setDefense(AppData.stats2.getDefense()+4);
                }

            }
            if(AppData.herotab2.getId()==2){

                hp=GenerateRandomNewStats();

                if (hp<500){
                    AppData.stats2.setHp(AppData.stats2.getHp()+1);
                }else if (hp<700){
                    AppData.stats2.setHp(AppData.stats2.getHp()+2);
                }else if (hp<900){
                    AppData.stats2.setHp(AppData.stats2.getHp()+3);
                }else{
                    AppData.stats2.setHp(AppData.stats2.getHp()+4);
                }

                atk=GenerateRandomNewStats();

                if (atk<500){
                    AppData.stats2.setAtk(AppData.stats2.getAtk()+7);
                }else if(atk<700){
                    AppData.stats2.setAtk(AppData.stats2.getAtk()+8);
                }else if(atk<900){
                    AppData.stats2.setAtk(AppData.stats2.getAtk()+9);
                }else{
                    AppData.stats2.setAtk(AppData.stats2.getAtk()+10);
                }

                defence=GenerateRandomNewStats();

                if (defence<500){
                    AppData.stats2.setDefense(AppData.stats2.getDefense()+1);
                }else if(defence<700){
                    AppData.stats2.setDefense(AppData.stats2.getDefense()+2);
                }else if(defence<900){
                    AppData.stats2.setDefense(AppData.stats2.getDefense()+3);
                }else{
                    AppData.stats2.setDefense(AppData.stats2.getDefense()+4);
                }

            }
            if(AppData.herotab2.getId()==3){

                hp=GenerateRandomNewStats();

                if (hp<500){
                    AppData.stats2.setHp(AppData.stats2.getHp()+3);
                }else if (hp<700){
                    AppData.stats2.setHp(AppData.stats2.getHp()+4);
                }else if (hp<900){
                    AppData.stats2.setHp(AppData.stats2.getHp()+5);
                }else{
                    AppData.stats2.setHp(AppData.stats2.getHp()+6);
                }

                atk=GenerateRandomNewStats();

                if (atk<500){
                    AppData.stats2.setAtk(AppData.stats2.getAtk()+1);
                }else if(atk<700){
                    AppData.stats2.setAtk(AppData.stats2.getAtk()+2);
                }else if(atk<900){
                    AppData.stats2.setAtk(AppData.stats2.getAtk()+3);
                }else{
                    AppData.stats2.setAtk(AppData.stats2.getAtk()+4);
                }

                defence=GenerateRandomNewStats();

                if (defence<500){
                    AppData.stats2.setDefense(AppData.stats2.getDefense()+2);
                }else if(defence<700){
                    AppData.stats2.setDefense(AppData.stats2.getDefense()+3);
                }else if(defence<900){
                    AppData.stats2.setDefense(AppData.stats2.getDefense()+4);
                }else{
                    AppData.stats2.setDefense(AppData.stats2.getDefense()+5);
                }

            }
            if(AppData.herotab2.getId()==4){

                hp=GenerateRandomNewStats();

                if (hp<500){
                    AppData.stats2.setHp(AppData.stats2.getHp()+1);
                }else if (hp<700){
                    AppData.stats2.setHp(AppData.stats2.getHp()+2);
                }else if (hp<900){
                    AppData.stats2.setHp(AppData.stats2.getHp()+3);
                }else{
                    AppData.stats2.setHp(AppData.stats2.getHp()+4);
                }

                atk=GenerateRandomNewStats();

                if (atk<500){
                    AppData.stats2.setAtk(AppData.stats2.getAtk()+3);
                }else if(atk<700){
                    AppData.stats2.setAtk(AppData.stats2.getAtk()+4);
                }else if(atk<900){
                    AppData.stats2.setAtk(AppData.stats2.getAtk()+5);
                }else{
                    AppData.stats2.setAtk(AppData.stats2.getAtk()+6);
                }

                defence=GenerateRandomNewStats();

                if (defence<500){
                    AppData.stats2.setDefense(AppData.stats2.getDefense()+2);
                }else if(defence<700){
                    AppData.stats2.setDefense(AppData.stats2.getDefense()+3);
                }else if(defence<900){
                    AppData.stats2.setDefense(AppData.stats2.getDefense()+4);
                }else{
                    AppData.stats2.setDefense(AppData.stats2.getDefense()+5);
                }

            }
            if(AppData.herotab2.getId()==5){

                hp=GenerateRandomNewStats();

                if (hp<500){
                    AppData.stats2.setHp(AppData.stats2.getHp()+1);
                }else if (hp<700){
                    AppData.stats2.setHp(AppData.stats2.getHp()+2);
                }else if (hp<900){
                    AppData.stats2.setHp(AppData.stats2.getHp()+3);
                }else{
                    AppData.stats2.setHp(AppData.stats2.getHp()+4);
                }

                atk=GenerateRandomNewStats();

                if (atk<500){
                    AppData.stats2.setAtk(AppData.stats2.getAtk()+1);
                }else if(atk<700){
                    AppData.stats2.setAtk(AppData.stats2.getAtk()+2);
                }else if(atk<900){
                    AppData.stats2.setAtk(AppData.stats2.getAtk()+3);
                }else{
                    AppData.stats2.setAtk(AppData.stats2.getAtk()+4);
                }

                defence=GenerateRandomNewStats();

                if (defence<500){
                    AppData.stats2.setDefense(AppData.stats2.getDefense()+7);
                }else if(defence<700){
                    AppData.stats2.setDefense(AppData.stats2.getDefense()+8);
                }else if(defence<900){
                    AppData.stats2.setDefense(AppData.stats2.getDefense()+9);
                }else{
                    AppData.stats2.setDefense(AppData.stats2.getDefense()+10);
                }

            }



        }else if(AppData.selectedherotab3) {

            if(AppData.herotab3.getId()==1){

                hp=GenerateRandomNewStats();

                if (hp<500){
                    AppData.stats3.setHp(AppData.stats3.getHp()+2);
                }else if (hp<700){
                    AppData.stats3.setHp(AppData.stats3.getHp()+3);
                }else if (hp<900){
                    AppData.stats3.setHp(AppData.stats3.getHp()+4);
                }else{
                    AppData.stats3.setHp(AppData.stats3.getHp()+5);
                }

                atk=GenerateRandomNewStats();

                if (atk<500){
                    AppData.stats3.setAtk(AppData.stats3.getAtk()+3);
                }else if(atk<700){
                    AppData.stats3.setAtk(AppData.stats3.getAtk()+4);
                }else if(atk<900){
                    AppData.stats3.setAtk(AppData.stats3.getAtk()+5);
                }else{
                    AppData.stats3.setAtk(AppData.stats3.getAtk()+6);
                }

                defence=GenerateRandomNewStats();

                if (defence<500){
                    AppData.stats3.setDefense(AppData.stats3.getDefense()+1);
                }else if(defence<700){
                    AppData.stats3.setDefense(AppData.stats3.getDefense()+2);
                }else if(defence<900){
                    AppData.stats3.setDefense(AppData.stats3.getDefense()+3);
                }else{
                    AppData.stats3.setDefense(AppData.stats3.getDefense()+4);
                }

            }
            if(AppData.herotab3.getId()==2){

                hp=GenerateRandomNewStats();

                if (hp<500){
                    AppData.stats3.setHp(AppData.stats3.getHp()+1);
                }else if (hp<700){
                    AppData.stats3.setHp(AppData.stats3.getHp()+2);
                }else if (hp<900){
                    AppData.stats3.setHp(AppData.stats3.getHp()+3);
                }else{
                    AppData.stats3.setHp(AppData.stats3.getHp()+4);
                }

                atk=GenerateRandomNewStats();

                if (atk<500){
                    AppData.stats3.setAtk(AppData.stats3.getAtk()+7);
                }else if(atk<700){
                    AppData.stats3.setAtk(AppData.stats3.getAtk()+8);
                }else if(atk<900){
                    AppData.stats3.setAtk(AppData.stats3.getAtk()+9);
                }else{
                    AppData.stats3.setAtk(AppData.stats3.getAtk()+10);
                }

                defence=GenerateRandomNewStats();

                if (defence<500){
                    AppData.stats3.setDefense(AppData.stats3.getDefense()+1);
                }else if(defence<700){
                    AppData.stats3.setDefense(AppData.stats3.getDefense()+2);
                }else if(defence<900){
                    AppData.stats3.setDefense(AppData.stats3.getDefense()+3);
                }else{
                    AppData.stats3.setDefense(AppData.stats3.getDefense()+4);
                }

            }
            if(AppData.herotab3.getId()==3){

                hp=GenerateRandomNewStats();

                if (hp<500){
                    AppData.stats3.setHp(AppData.stats3.getHp()+3);
                }else if (hp<700){
                    AppData.stats3.setHp(AppData.stats3.getHp()+4);
                }else if (hp<900){
                    AppData.stats3.setHp(AppData.stats3.getHp()+5);
                }else{
                    AppData.stats3.setHp(AppData.stats3.getHp()+6);
                }

                atk=GenerateRandomNewStats();

                if (atk<500){
                    AppData.stats3.setAtk(AppData.stats3.getAtk()+1);
                }else if(atk<700){
                    AppData.stats3.setAtk(AppData.stats3.getAtk()+2);
                }else if(atk<900){
                    AppData.stats3.setAtk(AppData.stats3.getAtk()+3);
                }else{
                    AppData.stats3.setAtk(AppData.stats3.getAtk()+4);
                }

                defence=GenerateRandomNewStats();

                if (defence<500){
                    AppData.stats3.setDefense(AppData.stats3.getDefense()+2);
                }else if(defence<700){
                    AppData.stats3.setDefense(AppData.stats3.getDefense()+3);
                }else if(defence<900){
                    AppData.stats3.setDefense(AppData.stats3.getDefense()+4);
                }else{
                    AppData.stats3.setDefense(AppData.stats3.getDefense()+5);
                }

            }
            if(AppData.herotab3.getId()==4){

                hp=GenerateRandomNewStats();

                if (hp<500){
                    AppData.stats3.setHp(AppData.stats3.getHp()+1);
                }else if (hp<700){
                    AppData.stats3.setHp(AppData.stats3.getHp()+2);
                }else if (hp<900){
                    AppData.stats3.setHp(AppData.stats3.getHp()+3);
                }else{
                    AppData.stats3.setHp(AppData.stats3.getHp()+4);
                }

                atk=GenerateRandomNewStats();

                if (atk<500){
                    AppData.stats3.setAtk(AppData.stats3.getAtk()+3);
                }else if(atk<700){
                    AppData.stats3.setAtk(AppData.stats3.getAtk()+4);
                }else if(atk<900){
                    AppData.stats3.setAtk(AppData.stats3.getAtk()+5);
                }else{
                    AppData.stats3.setAtk(AppData.stats3.getAtk()+6);
                }

                defence=GenerateRandomNewStats();

                if (defence<500){
                    AppData.stats3.setDefense(AppData.stats3.getDefense()+2);
                }else if(defence<700){
                    AppData.stats3.setDefense(AppData.stats3.getDefense()+3);
                }else if(defence<900){
                    AppData.stats3.setDefense(AppData.stats3.getDefense()+4);
                }else{
                    AppData.stats3.setDefense(AppData.stats3.getDefense()+5);
                }

            }
            if(AppData.herotab3.getId()==5){

                hp=GenerateRandomNewStats();

                if (hp<500){
                    AppData.stats3.setHp(AppData.stats3.getHp()+1);
                }else if (hp<700){
                    AppData.stats3.setHp(AppData.stats3.getHp()+2);
                }else if (hp<900){
                    AppData.stats3.setHp(AppData.stats3.getHp()+3);
                }else{
                    AppData.stats3.setHp(AppData.stats3.getHp()+4);
                }

                atk=GenerateRandomNewStats();

                if (atk<500){
                    AppData.stats3.setAtk(AppData.stats3.getAtk()+1);
                }else if(atk<700){
                    AppData.stats3.setAtk(AppData.stats3.getAtk()+2);
                }else if(atk<900){
                    AppData.stats3.setAtk(AppData.stats3.getAtk()+3);
                }else{
                    AppData.stats3.setAtk(AppData.stats3.getAtk()+4);
                }

                defence=GenerateRandomNewStats();

                if (defence<500){
                    AppData.stats3.setDefense(AppData.stats3.getDefense()+7);
                }else if(defence<700){
                    AppData.stats3.setDefense(AppData.stats3.getDefense()+8);
                }else if(defence<900){
                    AppData.stats3.setDefense(AppData.stats3.getDefense()+9);
                }else{
                    AppData.stats3.setDefense(AppData.stats3.getDefense()+10);
                }

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

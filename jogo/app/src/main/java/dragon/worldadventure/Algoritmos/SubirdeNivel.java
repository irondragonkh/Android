package dragon.worldadventure.Algoritmos;

import dragon.worldadventure.Objects.AppData;

public class SubirdeNivel {

    public void LeveluponStep (){
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

    public void AppDataLevelupParameteres(){

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
}

package dragon.worldadventure.Algoritmos;

import java.util.Random;

import dragon.worldadventure.Objects.AppData;
import dragon.worldadventure.Objects.Hero;

public class BattleDmg {

    private int numero;
    private int stack;
    private double critico;
    private double hipotesebaixararmadura;

    /**
     * batalha vai de 0 a 1000 e de 0 a 500 e nada de 500 a 750 e 1 de vida regenera  e de 750 a 1000 vai atacar, se conseguir mandar 3 ataques baseado na sorte sai critico
     * no caso de ataque fazer especie de regra de 3 simples onde a desefa total e 100 e o ataque sera percentagem dai essa percentagem sera a hipotese de perder armadura,
     * ataque maior que a armadura ira sempre tirar 1 ponto de defesa
     */


    public void LetsFight(){

            DecisonofActionHero();
            stack = 0;
            critico = 0;
            DecisonofActionVillan();
            stack = 0;
            critico = 0;
    }
    private int NumeroAleatorio(){
        Random r = new Random();
        int min = 1;
        int max = 1000;

        return r.nextInt(max - min + 1) + min;
    }

    private void DecisonofActionVillan(){
        for (double i=0;i<AppData.villan.getLuck();i++){
            numero=NumeroAleatorio();
            if (numero<500){

            }else if(numero<750){
                Dealdmg(false,true);
            }else{
                Heal(false,true);
            }
        }

    }

    private void DecisonofActionHero(){
            for (double i = 0; i < AppData.selectedhero.getLuck(); i++) {
                numero = NumeroAleatorio();
                if (numero < 500) {

                } else if (numero < 750) {
                    Dealdmg(true, false);
                } else {
                    Heal(true, false);
                }
            }
    }

    private void Dealdmg(boolean hero,boolean villan){
        stack++;
        if(hero) {


                    if (stack > 2) {
                        AppData.herocrit = true;
                        critico = AppData.selectedstats.getAtk() * 2;

                        if (critico > AppData.villandefense) {
                            AppData.herodmg = critico - AppData.villandefense;

                        } else if (critico == AppData.villandefense) {
                            hipotesebaixararmadura = 100;
                            LowerDefence(true, false, hipotesebaixararmadura);

                        } else if (critico < AppData.villandefense) {
                            hipotesebaixararmadura = (critico * 100) / AppData.villandefense;
                            LowerDefence(true, false, hipotesebaixararmadura);
                        }
                    } else {

                        if (AppData.selectedstats.getAtk() > AppData.villandefense) {
                            AppData.herodmg = AppData.selectedstats.getAtk() - AppData.villandefense;

                        } else if (AppData.selectedstats.getAtk() == AppData.villandefense) {
                            hipotesebaixararmadura = 100;
                            LowerDefence(true, false, hipotesebaixararmadura);

                        } else if (AppData.selectedstats.getAtk() < AppData.villandefense) {
                            hipotesebaixararmadura = (AppData.selectedstats.getAtk() * 100) / AppData.villandefense;
                            LowerDefence(true, false, hipotesebaixararmadura);
                        }
                    }

        }else if (villan) {
                if (stack > 2) {
                    AppData.villancrit=true;
                    critico=AppData.villan.getAtk()*2;

                    if (critico> AppData.herodefense) {
                        AppData.villandmg=critico-AppData.herodefense;

                    }else if(critico==AppData.herodefense){
                        hipotesebaixararmadura=100;
                        LowerDefence(false,true,hipotesebaixararmadura);

                    }else if(critico<AppData.herodefense){
                        hipotesebaixararmadura=(critico*100)/AppData.herodefense;
                        LowerDefence(false,true,hipotesebaixararmadura);
                    }
                } else {

                    if (AppData.villan.getAtk() > AppData.herodefense) {
                        AppData.villandmg = AppData.villan.getAtk() - AppData.herodefense;

                    } else if (AppData.villan.getAtk() == AppData.herodefense) {
                        hipotesebaixararmadura = 100;
                        LowerDefence(false, true, hipotesebaixararmadura);

                    } else if (AppData.villan.getAtk() < AppData.herodefense) {
                        hipotesebaixararmadura = (AppData.villan.getAtk() * 100) / AppData.herodefense;
                        LowerDefence(false, true, hipotesebaixararmadura);
                    }
                }
        }
    }

    private void Heal(boolean hero,boolean villan){
        if (hero) {
            AppData.heroregainhealth++;
        }else if(villan){
            AppData.villanregainhealth++;
        }
    }

    private void LowerDefence(boolean hero,boolean villan,double hipotesebaixararmadura){
        Random r = new Random();
        int min = 1;
        int max = 100;

        if(hero){
            int value=r.nextInt(max - min + 1) + min;
            if(value<hipotesebaixararmadura){
                AppData.villanlosedefence++;
            }

        }else if (villan){
            int value=r.nextInt(max - min + 1) + min;
            if(value<hipotesebaixararmadura){
                AppData.herolosedefence++;
            }

        }
    }

}

package dragon.worldadventure.Algoritmos;

import java.util.Random;

public class BattleDmg {

    /**
     * batalha vai de 0 a 1000 e de 0 a 500 e nada de 500 a 750 e 1 de vida regenera  e de 750 a 1000 vai atacar, se conseguir mandar 3 ataques baseado na sorte sai critico
     * no caso de ataque fazer especie de regra de 3 simples onde a desefa total e 100 e o ataque sera percentagem dai essa percentagem sera a hipotese de perder armadura,
     * ataque maior que a armadura ira sempre tirar 1 ponto de defesa
     */


    private int NumeroAleatorio(){
        Random r = new Random();
        int min = 1;
        int max = 1000;

        return r.nextInt(max - min + 1) + min;
    }

    private void

    private void Dealdmg(){

    }
    private void Heal(){

    }
    private void LowerDefence(){

    }

}

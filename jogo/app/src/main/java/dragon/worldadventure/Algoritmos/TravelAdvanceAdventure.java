package dragon.worldadventure.Algoritmos;

import java.util.Random;

public class TravelAdvanceAdventure {

    Random r = new Random();

private String ChooseField(){


    int min = 1;
    int max = 10;


    int randomnumber = r.nextInt(max - min + 1) + min;

    if(randomnumber==1){
        return "You find a old house, seems like no one is there";
    }else if(randomnumber==2){
        return "You run into a cavern, you decide to enter looking for a treasure and hopefully no bear, it happers you had luck";
    }else if(randomnumber==3){
        return "";
    }else if(randomnumber==4){

    }else if(randomnumber==5){

    }else if(randomnumber==6){

    }else if(randomnumber==7){

    }else if(randomnumber==8){

    }else if(randomnumber==9){

    }else if(randomnumber==10){

    }
    return null;
}




}

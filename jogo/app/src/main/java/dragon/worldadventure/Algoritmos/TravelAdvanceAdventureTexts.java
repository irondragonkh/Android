package dragon.worldadventure.Algoritmos;

import java.util.Random;

public class TravelAdvanceAdventureTexts {

    Random r = new Random();
    TravelXPandBatlleFunc algoritmod = new TravelXPandBatlleFunc();

public String ChooseField(){


    int min = 1;
    int max = 10;


    int randomnumber = r.nextInt(max - min + 1) + min;

    if(randomnumber==1){
        return "You found a old house, seems like no one is there";
    }else if(randomnumber==2){
        return "You run into a cavern, you decide to enter looking for a treasure and hopefully no bear, it happers you had luck";
    }else if(randomnumber==3){
        return "You keep walking around, thinking about life";
    }else if(randomnumber==4){
        return "You reach a town, good place to gather information and maybe rest a bit ";
    }else if(randomnumber==5){
        return "You walk into a ancient ruin,you decide to explore it";
    }else if(randomnumber==6){
        return "You go play cards with your friends";
    }else if(randomnumber==7){
        return "Thank you for playing this game, send a email with tips to improve the game";
    }else if(randomnumber==8){
        return "You try to exercise more at morning, exercise is good to keep focus and health and maybe help you survive";
    }else if(randomnumber==9){
        return "You found a monster lair, hopefully no monster is there";
    }else if(randomnumber==10){
        return "You found some mercheants and decide to help them until the next city";
    }else{
        return null;
    }
}




}

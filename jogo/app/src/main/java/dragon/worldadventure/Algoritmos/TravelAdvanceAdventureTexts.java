package dragon.worldadventure.Algoritmos;

import java.util.Random;

import dragon.worldadventure.R;

public class TravelAdvanceAdventureTexts {

    Random r = new Random();
    TravelXPRewards algoritmod = new TravelXPRewards();

public int ChooseField() {


    int min = 1;
    int max = 10;


    int randomnumber = r.nextInt(max - min + 1) + min;

    if (randomnumber == 1) {
        return R.string.StepText1;
    } else if (randomnumber == 2) {
        return R.string.StepText2;
    } else if (randomnumber == 3) {
        return R.string.StepText3;
    } else if (randomnumber == 4) {
        return R.string.StepText4;
    } else if (randomnumber == 5) {
        return R.string.StepText5;
    } else if (randomnumber == 6) {
        return R.string.StepText6;
    } else if (randomnumber == 7) {
        return R.string.StepText7;
    } else if (randomnumber == 8) {
        return R.string.StepText8;
    } else if (randomnumber == 9) {
        return R.string.StepText9;
    } else if (randomnumber == 10) {
        return R.string.StepText10;

    }else{
        return -1;
    }
}




}

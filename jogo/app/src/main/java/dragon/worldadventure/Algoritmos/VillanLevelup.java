package dragon.worldadventure.Algoritmos;

import java.util.Random;

import dragon.worldadventure.Objects.AppData;

public class VillanLevelup {

    public static final int SorteValor1 = 500;
    public static final int SorteValor2 = 700;
    public static final int SorteValor3 = 900;
    public static final int SorteValorMaximo = 1000;

    private int NumeroAleatorio(){
        Random r = new Random();
        int min = 1;
        int max = SorteValorMaximo;

        return r.nextInt(max - min + 1) + min;
    }

    public void levelupVillan() {
        int hp;
        int atk;
        int defence;


            for (double i = 1; i < AppData.selectedlevel.getLevel(); i++) {

                if (AppData.villan.getId() == 1) {

                    hp = NumeroAleatorio();

                    if (hp < SorteValor1) {
                        AppData.villan.setHp(AppData.villan.getHp() + 2);
                    } else if (hp < SorteValor2) {
                        AppData.villan.setHp(AppData.villan.getHp() + 3);
                    } else if (hp < SorteValor3) {
                        AppData.villan.setHp(AppData.villan.getHp() + 4);
                    } else {
                        AppData.villan.setHp(AppData.villan.getHp() + 5);
                    }

                    atk = NumeroAleatorio();

                    if (atk < SorteValor1) {
                        AppData.villan.setAtk(AppData.villan.getAtk() + 3);
                    } else if (atk < SorteValor2) {
                        AppData.villan.setAtk(AppData.villan.getAtk() + 4);
                    } else if (atk < SorteValor3) {
                        AppData.villan.setAtk(AppData.villan.getAtk() + 5);
                    } else {
                        AppData.villan.setAtk(AppData.villan.getAtk() + 6);
                    }

                    defence = NumeroAleatorio();

                    if (defence < SorteValor1) {
                        AppData.villan.setDefense(AppData.villan.getDefense() + 1);
                    } else if (defence < SorteValor2) {
                        AppData.villan.setDefense(AppData.villan.getDefense() + 2);
                    } else if (defence < SorteValor3) {
                        AppData.villan.setDefense(AppData.villan.getDefense() + 3);
                    } else {
                        AppData.villan.setDefense(AppData.villan.getDefense() + 4);
                    }

                }
                if (AppData.villan.getId() == 2) {

                    hp = NumeroAleatorio();

                    if (hp < SorteValor1) {
                        AppData.villan.setHp(AppData.villan.getHp() + 1);
                    } else if (hp < SorteValor2) {
                        AppData.villan.setHp(AppData.villan.getHp() + 2);
                    } else if (hp < SorteValor3) {
                        AppData.villan.setHp(AppData.villan.getHp() + 3);
                    } else {
                        AppData.villan.setHp(AppData.villan.getHp() + 4);
                    }

                    atk = NumeroAleatorio();

                    if (atk < SorteValor1) {
                        AppData.villan.setAtk(AppData.villan.getAtk() + 7);
                    } else if (atk < SorteValor2) {
                        AppData.villan.setAtk(AppData.villan.getAtk() + 8);
                    } else if (atk < SorteValor3) {
                        AppData.villan.setAtk(AppData.villan.getAtk() + 9);
                    } else {
                        AppData.villan.setAtk(AppData.villan.getAtk() + 10);
                    }

                    defence = NumeroAleatorio();

                    if (defence < SorteValor1) {
                        AppData.villan.setDefense(AppData.villan.getDefense() + 1);
                    } else if (defence < SorteValor2) {
                        AppData.villan.setDefense(AppData.villan.getDefense() + 2);
                    } else if (defence < SorteValor3) {
                        AppData.villan.setDefense(AppData.villan.getDefense() + 3);
                    } else {
                        AppData.villan.setDefense(AppData.villan.getDefense() + 4);
                    }

                }
                if (AppData.villan.getId() == 3) {

                    hp = NumeroAleatorio();

                    if (hp < SorteValor1) {
                        AppData.villan.setHp(AppData.villan.getHp() + 3);
                    } else if (hp < SorteValor2) {
                        AppData.villan.setHp(AppData.villan.getHp() + 4);
                    } else if (hp < SorteValor3) {
                        AppData.villan.setHp(AppData.villan.getHp() + 5);
                    } else {
                        AppData.villan.setHp(AppData.villan.getHp() + 6);
                    }

                    atk = NumeroAleatorio();

                    if (atk < SorteValor1) {
                        AppData.villan.setAtk(AppData.villan.getAtk() + 1);
                    } else if (atk < SorteValor2) {
                        AppData.villan.setAtk(AppData.villan.getAtk() + 2);
                    } else if (atk < SorteValor3) {
                        AppData.villan.setAtk(AppData.villan.getAtk() + 3);
                    } else {
                        AppData.villan.setAtk(AppData.villan.getAtk() + 4);
                    }

                    defence = NumeroAleatorio();

                    if (defence < SorteValor1) {
                        AppData.villan.setDefense(AppData.villan.getDefense() + 2);
                    } else if (defence < SorteValor2) {
                        AppData.villan.setDefense(AppData.villan.getDefense() + 3);
                    } else if (defence < SorteValor3) {
                        AppData.villan.setDefense(AppData.villan.getDefense() + 4);
                    } else {
                        AppData.villan.setDefense(AppData.villan.getDefense() + 5);
                    }

                }
                if (AppData.villan.getId() == 4) {

                    hp = NumeroAleatorio();

                    if (hp < SorteValor1) {
                        AppData.villan.setHp(AppData.villan.getHp() + 1);
                    } else if (hp < SorteValor2) {
                        AppData.villan.setHp(AppData.villan.getHp() + 2);
                    } else if (hp < SorteValor3) {
                        AppData.villan.setHp(AppData.villan.getHp() + 3);
                    } else {
                        AppData.villan.setHp(AppData.villan.getHp() + 4);
                    }

                    atk = NumeroAleatorio();

                    if (atk < SorteValor1) {
                        AppData.villan.setAtk(AppData.villan.getAtk() + 3);
                    } else if (atk < SorteValor2) {
                        AppData.villan.setAtk(AppData.villan.getAtk() + 4);
                    } else if (atk < SorteValor3) {
                        AppData.villan.setAtk(AppData.villan.getAtk() + 5);
                    } else {
                        AppData.villan.setAtk(AppData.villan.getAtk() + 6);
                    }

                    defence = NumeroAleatorio();

                    if (defence < SorteValor1) {
                        AppData.villan.setDefense(AppData.villan.getDefense() + 2);
                    } else if (defence < SorteValor2) {
                        AppData.villan.setDefense(AppData.villan.getDefense() + 3);
                    } else if (defence < SorteValor3) {
                        AppData.villan.setDefense(AppData.villan.getDefense() + 4);
                    } else {
                        AppData.villan.setDefense(AppData.villan.getDefense() + 5);
                    }

                }
                if (AppData.villan.getId() == 5) {

                    hp = NumeroAleatorio();

                    if (hp < SorteValor1) {
                        AppData.villan.setHp(AppData.villan.getHp() + 1);
                    } else if (hp < SorteValor2) {
                        AppData.villan.setHp(AppData.villan.getHp() + 2);
                    } else if (hp < SorteValor3) {
                        AppData.villan.setHp(AppData.villan.getHp() + 3);
                    } else {
                        AppData.villan.setHp(AppData.villan.getHp() + 4);
                    }

                    atk = NumeroAleatorio();

                    if (atk < SorteValor1) {
                        AppData.villan.setAtk(AppData.villan.getAtk() + 1);
                    } else if (atk < SorteValor2) {
                        AppData.villan.setAtk(AppData.villan.getAtk() + 2);
                    } else if (atk < SorteValor3) {
                        AppData.villan.setAtk(AppData.villan.getAtk() + 3);
                    } else {
                        AppData.villan.setAtk(AppData.villan.getAtk() + 4);
                    }

                    defence = NumeroAleatorio();

                    if (defence < SorteValor1) {
                        AppData.villan.setDefense(AppData.villan.getDefense() + 7);
                    } else if (defence < SorteValor2) {
                        AppData.villan.setDefense(AppData.villan.getDefense() + 8);
                    } else if (defence < SorteValor3) {
                        AppData.villan.setDefense(AppData.villan.getDefense() + 9);
                    } else {
                        AppData.villan.setDefense(AppData.villan.getDefense() + 10);
                    }

                }
            }
        }
}

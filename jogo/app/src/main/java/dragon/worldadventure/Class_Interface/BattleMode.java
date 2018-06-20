package dragon.worldadventure.Class_Interface;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

import dragon.worldadventure.Algoritmos.BattleDmg;
import dragon.worldadventure.Algoritmos.VillanLevelup;
import dragon.worldadventure.Objects.AppData;
import dragon.worldadventure.R;
import pl.droidsonroids.gif.GifImageView;

public class BattleMode extends AppCompatActivity {

    GifImageView hero,villan;
    CardView cardviewhero,cardviewvillan;
    TextView herostatshp,herostatsatk,herostatsdefense,herostatsluck,villanstatshp,villanstatsatk,villanstatsdefence,villanstatsluck,herohealthvalue,villanhealthvalue,heroname,villanname,herofightresult,villanfightresult;
    Button buttonfight,buttonfightend,buttongameover;
    ProgressBar herohp,villanhp;
    VillanLevelup villanLevelup=new VillanLevelup();
    BattleDmg battleDmg = new BattleDmg();
    Handler threadhandler=new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        herostatshp = (TextView) findViewById(R.id.TextViewBattleHeroHP);
        herostatsatk = (TextView) findViewById(R.id.TextViewBattleHeroATK);
        herostatsdefense = (TextView) findViewById(R.id.TextViewBattleHeroDefence);
        herostatsluck = (TextView) findViewById(R.id.TextViewBattleHeroLuck);

        villanstatshp = (TextView) findViewById(R.id.TextViewBattleVillanHP);
        villanstatsatk = (TextView) findViewById(R.id.TextViewBattleVillanATK);
        villanstatsdefence = (TextView) findViewById(R.id.TextViewBattleVillanDefence);
        villanstatsluck = (TextView) findViewById(R.id.TextViewBattleVillanLuck);

        herohealthvalue = (TextView) findViewById(R.id.TextViewBattleHeroHPvalue);
        villanhealthvalue = (TextView) findViewById(R.id.TextViewBattleVillanHPvalue);

        heroname = (TextView)findViewById(R.id.TextViewBattleHeroName);
        villanname = (TextView)findViewById(R.id.TextViewBattleVillanName);

        herofightresult=(TextView)findViewById(R.id.TextViewBattleHeroFight);
        villanfightresult=(TextView) findViewById(R.id.TextViewBattleVillanFight);

        cardviewhero=(CardView) findViewById(R.id.CardViewBattleHeroFight);
        cardviewvillan=(CardView) findViewById(R.id.CardViewBattleVillanFight);

        hero = (GifImageView) findViewById(R.id.GifImageViewBattleHero);
        villan = (GifImageView) findViewById(R.id.GifImageViewBattleVillan);

        buttonfight = (Button) findViewById(R.id.ButtonBattleFight);
        buttonfightend=(Button) findViewById(R.id.ButtonBattleEnd);
        buttongameover=(Button) findViewById(R.id.ButtonBattleGameOver);

        herohp=(ProgressBar) findViewById(R.id.ProgressBarHeroHP);
        villanhp=(ProgressBar) findViewById(R.id.ProgressBarVillanHP);

        villanLevelup.levelupVillan();

        AppData.currenthpvillan=AppData.villan.getHp();
        AppData.villandefense=AppData.villan.getDefense();
        if(AppData.selectedherotab1) {
            AppData.currenthp=AppData.stats1.getHp();
            AppData.herodefense = AppData.stats1.getDefense();
        }else if(AppData.selectedherotab2){
            AppData.currenthp=AppData.stats2.getHp();
            AppData.herodefense = AppData.stats2.getDefense();
        }else if(AppData.selectedherotab3)
            AppData.currenthp=AppData.stats3.getHp();
            AppData.herodefense = AppData.stats3.getDefense();
        SetStatsonHero();
        SetStatsonVillan();
    }
    public void Fight(View view) {
        Runnable figthStatus = new Runnable() {
            @Override
            public void run() {
                UpdateBattleStatus();
            }
        };
        new Thread(figthStatus).start();
    }

    private void UpdateBattleStatus() {
        battleDmg.LetsFight();


        threadhandler.post(new Runnable() {
            @Override
            public void run() {
                if(AppData.currenthpvillan-AppData.herodmg<=0){//heroi mata vilao
                    AppData.currenthpvillan=0;
                    cardviewhero.setVisibility(View.VISIBLE);
                    cardviewvillan.setVisibility(View.GONE);
                    if(AppData.herocrit){
                        herofightresult.setText("You critical strike the villan for " + AppData.herodmg + " damage and you killed him");
                    }else {
                        herofightresult.setText("You strike the villan for " + AppData.herodmg + " damage and you killed him");
                    }

                    buttonfight.setVisibility(View.GONE);
                    buttonfightend.setVisibility(View.VISIBLE);


                }else if(AppData.currenthp-AppData.villandmg<=0){//vilao matar o heroi
                    AppData.currenthp=0;
                    cardviewhero.setVisibility(View.GONE);
                    cardviewvillan.setVisibility(View.VISIBLE);
                    if(AppData.villancrit){
                        villanfightresult.setText("Villan critical strike you for " + AppData.villandmg + " damage and killed you");
                    }else {
                        villanfightresult.setText("Villan strike you for " + AppData.villandmg + " damage and killed you");
                    }
                    buttonfight.setVisibility(View.GONE);
                    buttongameover.setVisibility(View.VISIBLE);

                }else{
                    AppData.currenthp=AppData.currenthp-AppData.villandmg;
                    AppData.currenthpvillan=AppData.currenthpvillan-AppData.herodmg;
                    AppData.herodefense=AppData.herodefense-AppData.herolosedefence;
                    AppData.villandefense=AppData.villandefense-AppData.villanlosedefence;
                    if(AppData.currenthp+AppData.heroregainhealth>AppData.heromaxhealth){
                        AppData.currenthp=AppData.heromaxhealth;
                    }else{
                        AppData.currenthp=AppData.currenthp+AppData.heroregainhealth;
                    }
                    if(AppData.currenthpvillan+AppData.villanregainhealth>AppData.villanmaxhealth){
                        AppData.currenthpvillan=AppData.villanmaxhealth;
                    }else{
                        AppData.currenthpvillan=AppData.currenthpvillan+AppData.villanregainhealth;
                    }
                    cardviewhero.setVisibility(View.VISIBLE);
                    cardviewvillan.setVisibility(View.VISIBLE);

                    if(AppData.herocrit){
                        if(AppData.heroregainhealth>0){
                            if(AppData.herolosedefence>0){
                                herofightresult.setText("You critical strike the enemy for "+AppData.herodmg+", You regain "+AppData.heroregainhealth+" life, You lost "+ AppData.herolosedefence+ " defence");
                            }else{
                                herofightresult.setText("You critical strike the enemy for "+AppData.herodmg+", You regain "+AppData.heroregainhealth+" life");
                            }
                        }else{
                            if(AppData.herolosedefence>0){
                                herofightresult.setText("You critical strike the enemy for "+AppData.herodmg+", You lost "+ AppData.herolosedefence+ " defence");
                            }else {
                                herofightresult.setText("You critical strike the enemy for " + AppData.herodmg);
                            }
                        }
                    }else{
                        if(AppData.herodmg>0) {
                            if (AppData.heroregainhealth > 0) {
                                if (AppData.herolosedefence > 0) {
                                    herofightresult.setText("You strike the enemy for " + AppData.herodmg + ", You regain " + AppData.heroregainhealth + " life, You lost " + AppData.herolosedefence + " defence");
                                } else {
                                    herofightresult.setText("You strike the enemy for " + AppData.herodmg + ", You regain " + AppData.heroregainhealth + " life");
                                }
                            } else {
                                if (AppData.herolosedefence > 0) {
                                    herofightresult.setText("You strike the enemy for " + AppData.herodmg + ", You lost " + AppData.herolosedefence + " defence");
                                }else {
                                    herofightresult.setText("You strike the enemy for " + AppData.herodmg);
                                }
                            }
                        }else{
                            if(AppData.heroregainhealth>0){
                                if (AppData.herolosedefence > 0) {
                                    herofightresult.setText(" You regain " + AppData.heroregainhealth + " life, You lost " + AppData.herolosedefence + " defence");
                                } else {
                                    herofightresult.setText(" You regain " + AppData.heroregainhealth + " life");
                                }
                            } else {
                                if (AppData.herolosedefence > 0) {
                                    herofightresult.setText(" You lost " + AppData.herolosedefence + " defence");
                                }
                            }

                        }

                    }
                    if(AppData.villancrit){
                        if(AppData.villanregainhealth>0){
                            if(AppData.villanlosedefence>0){
                                villanfightresult.setText("Villan critical strike you for "+AppData.villandmg+", Villan regain "+AppData.villanregainhealth+" life, Villan lost "+ AppData.villanlosedefence+ " defence");
                            }else{
                                villanfightresult.setText("Villan critical strike you for "+AppData.villandmg+", Villan regain "+AppData.villanregainhealth+" life");
                            }
                        }else{
                            if(AppData.villanlosedefence>0){
                                villanfightresult.setText("Villan critical strike you for "+AppData.villandmg+", Villan lost "+ AppData.villanlosedefence+ " defence");
                            }else {
                                villanfightresult.setText("Villan critical strike you for " + AppData.villandmg);
                            }
                        }
                    }else{
                        if(AppData.villandmg>0) {
                            if (AppData.villanregainhealth > 0) {
                                if (AppData.villanlosedefence > 0) {
                                    villanfightresult.setText("Villan strike you for " + AppData.villandmg + ", Villan regain " + AppData.villanregainhealth + " life, Villan lost " + AppData.villanlosedefence + " defence");
                                } else {
                                    villanfightresult.setText("Villan strike you for " + AppData.villandmg + ", Villan regain " + AppData.villanregainhealth + " life");
                                }
                            } else {
                                if (AppData.villanlosedefence > 0) {
                                    villanfightresult.setText("Villan strike you for " + AppData.villandmg + ", Villan lost " + AppData.villanlosedefence + " defence");
                                }else {
                                    villanfightresult.setText("Villan strike you for " + AppData.villandmg);
                                }
                            }
                        }else{
                            if(AppData.villanregainhealth>0){
                                if (AppData.villanlosedefence > 0) {
                                    villanfightresult.setText(" Villan regain " + AppData.villanregainhealth + " life, Villan lost " + AppData.villanlosedefence + " defence");
                                } else {
                                    villanfightresult.setText(" Villan regain " + AppData.villanregainhealth + " life");
                                }
                            } else {
                                if (AppData.villanlosedefence > 0) {
                                    villanfightresult.setText(" Villan lost " + AppData.villanlosedefence + " defence");
                                }
                            }

                        }

                    }
                }
                int health=(int) AppData.currenthp;
                int healthvillan=(int) AppData.currenthpvillan;
                herohp.setProgress(health);
                villanhp.setProgress(healthvillan);
                herostatsdefense.setText("DFC:   "+AppData.herodefense);
                villanstatsdefence.setText(""+AppData.villandefense+"   :DFC");
                herostatshp.setText("HP:     "+ AppData.currenthp);
                villanstatshp.setText(""+ AppData.currenthpvillan+"     :HP");

                AppData.herolosedefence=0;AppData.heroregainhealth=0;AppData.herodmg=0;AppData.herocrit=false;
                AppData.villanlosedefence=0;AppData.villanregainhealth=0;AppData.villandmg=0;AppData.villancrit=false;
            }
        });

    }

    private void SetStatsonHero() {
        if(AppData.selectedherotab1){
            heroname.setText(AppData.herotab1.getHeroname());
            herostatshp.setText("HP:     "+ AppData.currenthp);
            herostatsatk.setText("ATK:   "+AppData.stats1.getAtk());
            herostatsdefense.setText("DFC:   "+AppData.herodefense);
            herostatsluck.setText("LUCK: "+AppData.stats1.getLuck());

            int maxhealth= (int) AppData.stats1.getHp();
            AppData.heromaxhealth=AppData.stats1.getHp();
            int currenthealth=(int)AppData.currenthp;
            herohealthvalue.setText(""+AppData.stats1.getHp()+"/"+AppData.currenthp);

            herohp.setMax(maxhealth);
            herohp.setProgress(currenthealth);


            if(AppData.herotab1.getId()==1){
                hero.setImageResource(R.drawable.warriorheroicon);

            }else if(AppData.herotab1.getId()==2){
                hero.setImageResource(R.drawable.mageheroicon);

            }else if(AppData.herotab1.getId()==3){
                hero.setImageResource(R.drawable.paladinheroicon);

            }else if(AppData.herotab1.getId()==4){
                hero.setImageResource(R.drawable.archerheroicon);

            }else if(AppData.herotab1.getId()==5){
                hero.setImageResource(R.drawable.priestheroicon);

            }
        }else if(AppData.selectedherotab2){
            heroname.setText(AppData.herotab2.getHeroname());
            herostatshp.setText("HP:     "+ AppData.currenthp);
            herostatsatk.setText("ATK:   "+AppData.stats2.getAtk());
            herostatsdefense.setText("DFC:   "+AppData.herodefense);
            herostatsluck.setText("LUCK: "+AppData.stats2.getLuck());

            int maxhealth= (int) AppData.stats2.getHp();
            AppData.heromaxhealth=AppData.stats2.getHp();
            int currenthealth=(int)AppData.currenthp;
            herohealthvalue.setText(""+AppData.stats2.getHp()+"/"+AppData.currenthp);

            herohp.setMax(maxhealth);
            herohp.setProgress(currenthealth);


            if(AppData.herotab2.getId()==1){
                hero.setImageResource(R.drawable.warriorheroicon);

            }else if(AppData.herotab2.getId()==2){
                hero.setImageResource(R.drawable.mageheroicon);

            }else if(AppData.herotab2.getId()==3){
                hero.setImageResource(R.drawable.paladinheroicon);

            }else if(AppData.herotab2.getId()==4){
                hero.setImageResource(R.drawable.archerheroicon);

            }else if(AppData.herotab2.getId()==5){
                hero.setImageResource(R.drawable.priestheroicon);

            }

        }else if(AppData.selectedherotab3){
            heroname.setText(AppData.herotab3.getHeroname());
            herostatshp.setText("HP:     "+ AppData.currenthp);
            herostatsatk.setText("ATK:   "+AppData.stats3.getAtk());
            herostatsdefense.setText("DFC:   "+AppData.herodefense);
            herostatsluck.setText("LUCK: "+AppData.stats3.getLuck());

            int maxhealth= (int) AppData.stats3.getHp();
            AppData.heromaxhealth=AppData.stats3.getHp();
            int currenthealth=(int)AppData.currenthp;
            herohealthvalue.setText(""+AppData.stats3.getHp()+"/"+AppData.currenthp);

            herohp.setMax(maxhealth);
            herohp.setProgress(currenthealth);

            if(AppData.herotab3.getId()==1){
                hero.setImageResource(R.drawable.warriorheroicon);

            }else if(AppData.herotab3.getId()==2){
                hero.setImageResource(R.drawable.mageheroicon);

            }else if(AppData.herotab3.getId()==3){
                hero.setImageResource(R.drawable.paladinheroicon);

            }else if(AppData.herotab3.getId()==4){
                hero.setImageResource(R.drawable.archerheroicon);

            }else if(AppData.herotab3.getId()==5){
                hero.setImageResource(R.drawable.priestheroicon);

            }

        }
    }

    private void SetStatsonVillan() {


        villanname.setText(AppData.villan.getVillanname());
        villanstatshp.setText(""+ AppData.currenthpvillan+"     :HP");
        villanstatsatk.setText(""+AppData.villan.getAtk()+"   :ATK");
        villanstatsdefence.setText(""+AppData.villandefense+"   :DFC");
        villanstatsluck.setText(""+AppData.villan.getLuck()+" :LUCK");
        AppData.currenthpvillan=AppData.villan.getHp();
        int maxhealth= (int) AppData.villan.getHp();
        AppData.villanmaxhealth=AppData.villan.getHp();
        int currenthealth=(int)AppData.currenthpvillan;
        villanhealthvalue.setText(""+AppData.villan.getHp()+"/"+AppData.currenthpvillan);

        villanhp.setMax(maxhealth);
        villanhp.setProgress(currenthealth);

        Random r = new Random();
        int min = 1;
        int max = 5;

       int number= r.nextInt(max - min + 1) + min;
       if(number==1){
           villan.setImageResource(R.drawable.villan0smaller);
       }else if(number==2){
           villan.setImageResource(R.drawable.villan1smaller);
       }else if(number==3){
           villan.setImageResource(R.drawable.villan2smaller);
       }else if(number==4){
           villan.setImageResource(R.drawable.villan3smaller);
       }else if(number==5){
           villan.setImageResource(R.drawable.villan4smaller);
       }


    }

    public void EndFight(View view) {
    }

    public void GameOver(View view) {
    }
}
/**
 * os stats aumentam nos viloes de 3 a 5(0 a 500, 501 a 800,800++)
 * nso herois de 1 a 3 nos genericos e nos especificos de 2 a 6 e 6 a10 se for so 1, e da +5 pontos extra depois
 * batalha vai de 0 a 1000 e de 0 a 500 e nada de 500 a 750 e 1 de vida regenera  e de 750 a 1000 vai atacar, se conseguir mandar 3 ataques baseado na sorte sai critico
 * level up vai de 0 a 1000 em que ate 500 e um, ate 700, ate 900 e outro e +900 e outro
 * mago aumenta ataque
 * paladino defesa e vida
 * priest defesa
 * warrior vida e ataque
 * archer ataque e defesa
 *
 * no caso de ataque fazer especie de regra de 3 simples onde a desefa total e 100 e o ataque sera percentagem dai essa percentagem sera a hipotese de perder armadura,
 * ataque maior que a armadura ira sempre tirar 1 ponto de defesa
 */

package dragon.worldadventure.Class_Interface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    TextView herostatshp,herostatsatk,herostatsdefense,herostatsluck,villanstatshp,villanstatsatk,villanstatsdefence,villanstatsluck,herohealthvalue,villanhealthvalue,heroname,villanname;
    Button buttonfight;
    ProgressBar herohp,villanhp;
    VillanLevelup villanLevelup=new VillanLevelup();
    BattleDmg battleDmg = new BattleDmg();



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

        hero = (GifImageView) findViewById(R.id.GifImageViewBattleHero);
        villan = (GifImageView) findViewById(R.id.GifImageViewBattleVillan);

        buttonfight = (Button) findViewById(R.id.ButtonBattleFight);

        herohp=(ProgressBar) findViewById(R.id.ProgressBarHeroHP);
        villanhp=(ProgressBar) findViewById(R.id.ProgressBarVillanHP);

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

    }

    private void SetStatsonHero() {
        if(AppData.selectedherotab1){
            heroname.setText(AppData.herotab1.getHeroname());
            herostatshp.setText("HP:   "+ AppData.stats1.getHp());
            herostatsatk.setText("ATK:  "+AppData.stats1.getAtk());
            herostatsdefense.setText("DFC:  "+AppData.stats1.getDefense());
            herostatsluck.setText("LUCK: "+AppData.stats1.getLuck());
            AppData.currenthp=AppData.stats1.getHp();
            int maxhealth= (int) AppData.stats1.getHp();
            herohealthvalue.setText(""+AppData.stats1.getHp()+"/"+AppData.currenthp);

            herohp.setMax(maxhealth);
            herohp.setProgress(maxhealth);


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
            herostatshp.setText(""+ AppData.stats2.getHp());
            herostatsatk.setText(""+AppData.stats2.getAtk());
            herostatsdefense.setText(""+AppData.stats2.getDefense());
            herostatsluck.setText(""+AppData.stats2.getLuck());
            AppData.currenthp=AppData.stats2.getHp();
            int maxhealth= (int) AppData.stats2.getHp();
            herohealthvalue.setText(""+AppData.stats2.getHp()+"/"+AppData.currenthp);

            herohp.setMax(maxhealth);
            herohp.setProgress(maxhealth);


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
            herostatshp.setText(""+ AppData.stats3.getHp());
            herostatsatk.setText(""+AppData.stats3.getAtk());
            herostatsdefense.setText(""+AppData.stats3.getDefense());
            herostatsluck.setText(""+AppData.stats3.getLuck());
            AppData.currenthp=AppData.stats3.getHp();
            int maxhealth= (int) AppData.stats3.getHp();
            herohealthvalue.setText(""+AppData.stats3.getHp()+"/"+AppData.currenthp);

            herohp.setMax(maxhealth);
            herohp.setProgress(maxhealth);


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
        villanLevelup.levelupVillan();

        villanname.setText(AppData.villan.getVillanname());
        villanstatshp.setText(""+ AppData.villan.getHp()+"   :HP");
        villanstatsatk.setText(""+AppData.villan.getAtk()+"  :ATK");
        villanstatsdefence.setText(""+AppData.villan.getDefense()+"  :DFC");
        villanstatsluck.setText(""+AppData.villan.getLuck()+" :LUCK");
        AppData.currenthpvillan=AppData.villan.getHp();
        int maxhealth= (int) AppData.villan.getHp();
        villanhealthvalue.setText(""+AppData.villan.getHp()+"/"+AppData.currenthpvillan);

        villanhp.setMax(maxhealth);
        villanhp.setProgress(maxhealth);

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

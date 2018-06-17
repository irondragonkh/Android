package dragon.worldadventure.Class_Interface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import dragon.worldadventure.Objects.AppData;
import dragon.worldadventure.R;
import pl.droidsonroids.gif.GifImageView;

public class BattleMode extends AppCompatActivity {

    GifImageView hero,villan;
    TextView herostatshp,herostatsatk,herostatsdefense,herostatsluck,villanstatshp,villanstatsatk,villanstatsdefence,villanstatsluck,herohealthvalue,villanhealthvalue;
    Button buttonfight;
    ProgressBar herohp,villanhp;

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

    }

    private void SetStatsonHero() {
        if(AppData.selectedherotab1){
            herostatshp.setText(""+ AppData.stats1.getHp());
            herostatsatk.setText(""+AppData.stats1.getAtk());
            herostatsdefense.setText(""+AppData.stats1.getDefense());
            herostatsluck.setText(""+AppData.stats1.getLuck());
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

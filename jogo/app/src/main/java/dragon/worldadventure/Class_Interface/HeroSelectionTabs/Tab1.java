package dragon.worldadventure.Class_Interface.HeroSelectionTabs;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import dragon.worldadventure.Objects.AppData;
import dragon.worldadventure.R;
import pl.droidsonroids.gif.GifImageView;

public class Tab1 extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.heroselectiontab1, container, false);




        checkexistance(rootView);

        return rootView;
    }

    private void checkexistance(View rootView) {


        if(AppData.existstab1){

            TextView textViewHeroName = rootView.findViewById(R.id.TextViewHeroName);
            ImageView imageViewHeroIcon = rootView.findViewById(R.id.ImageViewHeroIcon);
            GifImageView gifImageViewCreateHero =rootView.findViewById(R.id.ImageView_CreateHero1);
            GifImageView gifImageViewHero =rootView.findViewById(R.id.ImageView_Hero1);

            //tabela------------------------------------------------------------------
            TextView textViewHp = rootView.findViewById(R.id.TextViewHPValue);
            TextView textViewATK = rootView.findViewById(R.id.TextViewATKValue);
            TextView textViewDefence = rootView.findViewById(R.id.TextViewDefenceValue);
            TextView textViewLuck = rootView.findViewById(R.id.TextViewLuckValue);
            TextView textViewClass = rootView.findViewById(R.id.TextViewClassValue);
            TextView textViewLevel = rootView.findViewById(R.id.TextViewLevelValue);
            TextView textViewArmor = rootView.findViewById(R.id.TextViewEquipArmorValue);
            TextView textViewWeapon = rootView.findViewById(R.id.TextViewEquipSwordValue);
            //--------------------------------------------------------------------------

            textViewHeroName.setText(AppData.userHero1.getUserheroname());

            //esta parte tem que ser mexida porque tem  que se adicionar os stats depois
            textViewHp.setText(""+AppData.stats1.getHp());
            textViewATK.setText(""+AppData.stats1.getAtk());
            textViewDefence.setText(""+AppData.stats1.getDefense());
            textViewLuck.setText(""+AppData.stats1.getLuck());
            textViewClass.setText(AppData.herotab1.getClasse());
            textViewLevel.setText(""+AppData.leveltab1.getLevel());

            if (AppData.herotab1.getId()==1) {
                gifImageViewHero.setImageResource(R.drawable.selection_warrior_smaller);
                imageViewHeroIcon.setImageResource(R.drawable.warrior);
            }
            else if (AppData.herotab1.getId()==2) {
                gifImageViewHero.setImageResource(R.drawable.selection_mage_smaller60_130);
                imageViewHeroIcon.setImageResource(R.drawable.mage);
            }
            else if (AppData.herotab1.getId()==3) {
                gifImageViewHero.setImageResource(R.drawable.selection_paladin_smaller);
                imageViewHeroIcon.setImageResource(R.drawable.paladin);
            }
            else if (AppData.herotab1.getId()==5) {
                gifImageViewHero.setImageResource(R.drawable.selection_priest_smaller);
                imageViewHeroIcon.setImageResource(R.drawable.priest);
            }
            else if (AppData.herotab1.getId()==4) {
                gifImageViewHero.setImageResource(R.drawable.selection_darkelf_smaller);
                imageViewHeroIcon.setImageResource(R.drawable.archer);
            }




            gifImageViewCreateHero.setVisibility(View.GONE);


        }else{
            TextView textViewHeroName = rootView.findViewById(R.id.TextViewHeroName);
            TextView textViewDelete = rootView.findViewById(R.id.TextViewDelete);
            ImageView imageViewHeroIcon = rootView.findViewById(R.id.ImageViewHeroIcon);
            GridLayout gridLayoutHeroStats = rootView.findViewById(R.id.GridLayoutHeroStats);
            Button buttonInventario = rootView.findViewById(R.id.buttonInventario);
            GifImageView gifImageViewHero =rootView.findViewById(R.id.ImageView_Hero1);


            textViewHeroName.setVisibility(View.INVISIBLE);
            textViewDelete.setVisibility(View.INVISIBLE);
            imageViewHeroIcon.setVisibility(View.INVISIBLE);
            gridLayoutHeroStats.setVisibility(View.INVISIBLE);
            buttonInventario.setVisibility(View.INVISIBLE);
            gifImageViewHero.setVisibility(View.GONE);



        }
    }
}


package dragon.worldadventure.Class_Interface.HeroSelectionTabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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

public class Tab3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.heroselectiontab3, container, false);


        checkexistance(rootView);

        return rootView;
    }

    private void checkexistance(View rootView) {


        if(AppData.existstab3){
            TextView textViewHeroName = rootView.findViewById(R.id.TextViewHeroName);
            ImageView imageViewHeroIcon = rootView.findViewById(R.id.ImageViewHeroIcon);
            GifImageView gifImageViewCreateHero =rootView.findViewById(R.id.ImageView_CreateHero3);
            GifImageView gifImageViewHero =rootView.findViewById(R.id.ImageView_Hero3);

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

            textViewHeroName.setText(AppData.userHero3.getUserheroname());

            //esta parte tem que ser mexida porque tem  que se adicionar os stats depois
            textViewHp.setText(""+AppData.stats3.getHp());
            textViewATK.setText(""+AppData.stats3.getAtk());
            textViewDefence.setText(""+AppData.stats3.getDefense());
            textViewLuck.setText(""+AppData.stats3.getLuck());
            textViewClass.setText(AppData.herotab3.getClasse());
            textViewLevel.setText(""+AppData.leveltab3.getLevel());


            if (AppData.herotab3.getId()==1) {
                gifImageViewHero.setImageResource(R.drawable.selection_warrior_smaller);
                imageViewHeroIcon.setImageResource(R.drawable.warrior);
            }
            else if (AppData.herotab3.getId()==2) {
                gifImageViewHero.setImageResource(R.drawable.selection_mage_smaller60_130);
                imageViewHeroIcon.setImageResource(R.drawable.mage);
            }
            else if (AppData.herotab3.getId()==3) {
                gifImageViewHero.setImageResource(R.drawable.selection_paladin_smaller);
                imageViewHeroIcon.setImageResource(R.drawable.paladin);
            }
            else if (AppData.herotab3.getId()==4) {
                gifImageViewHero.setImageResource(R.drawable.selection_darkelf_smaller);
                imageViewHeroIcon.setImageResource(R.drawable.archer);
            }
            else if (AppData.herotab3.getId()==5) {
                gifImageViewHero.setImageResource(R.drawable.selection_priest_smaller);
                imageViewHeroIcon.setImageResource(R.drawable.priest);
            }



            gifImageViewCreateHero.setVisibility(View.GONE);



        }else{
            TextView textViewHeroName = rootView.findViewById(R.id.TextViewHeroName);
            TextView textViewDelete = rootView.findViewById(R.id.TextViewDelete);
            ImageView imageViewHeroIcon = rootView.findViewById(R.id.ImageViewHeroIcon);
            GridLayout gridLayoutHeroStats = rootView.findViewById(R.id.GridLayoutHeroStats);
            Button buttonInventario = rootView.findViewById(R.id.buttonInventario);
            GifImageView gifImageViewHero =rootView.findViewById(R.id.ImageView_Hero3);


            textViewHeroName.setVisibility(View.INVISIBLE);
            textViewDelete.setVisibility(View.INVISIBLE);
            imageViewHeroIcon.setVisibility(View.INVISIBLE);
            gridLayoutHeroStats.setVisibility(View.INVISIBLE);
            buttonInventario.setVisibility(View.INVISIBLE);
            gifImageViewHero.setVisibility(View.GONE);



        }
    }
}

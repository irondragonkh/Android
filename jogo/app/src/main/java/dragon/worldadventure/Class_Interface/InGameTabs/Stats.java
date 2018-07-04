package dragon.worldadventure.Class_Interface.InGameTabs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
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

public class Stats extends Fragment {

    View myView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.ingamestats,container,false);

        checkexistance(myView);

        return myView;
    }

    private void checkexistance(View rootView) {

            TextView textViewHeroName = rootView.findViewById(R.id.TextViewSelectedHeroName);
            ImageView imageViewHeroIcon = rootView.findViewById(R.id.ImageViewSelectedHeroIcon);
            GifImageView gifImageViewHero =rootView.findViewById(R.id.ImageView_SelectedHero);
            TextView textViewPoints = rootView.findViewById(R.id.TextViewPointsLeft);

            //tabela------------------------------------------------------------------
            TextView textViewHp = rootView.findViewById(R.id.TextViewSelectedHPValue);
            TextView textViewATK = rootView.findViewById(R.id.TextViewSelectedATKValue);
            TextView textViewDefence = rootView.findViewById(R.id.TextViewSelectedDefenceValue);
            TextView textViewLuck = rootView.findViewById(R.id.TextViewSelectedLuckValue);
            TextView textViewClass = rootView.findViewById(R.id.TextViewSelectedClassValue);
            TextView textViewLevel = rootView.findViewById(R.id.TextViewSelectedLevelValue);
            //--------------------------------------------------------------------------

            textViewHeroName.setText(AppData.selectedusedhero.getUserheroname());


            textViewHp.setText(""+AppData.selectedstats.getHp());
            textViewATK.setText(""+AppData.selectedstats.getAtk());
            textViewDefence.setText(""+AppData.selectedstats.getDefense());
            textViewLuck.setText(""+AppData.selectedstats.getLuck());
            textViewClass.setText(AppData.selectedhero.getClasse());
            textViewLevel.setText(""+AppData.selectedlevel.getLevel());
            textViewPoints.setText("Points left to spend: " + AppData.selectedusedhero.getPoints());

            if (AppData.selectedhero.getId()==1) {
                gifImageViewHero.setImageResource(R.drawable.selection_warrior_smaller);
                imageViewHeroIcon.setImageResource(R.drawable.warrior);
            }
            else if (AppData.selectedhero.getId()==2) {
                gifImageViewHero.setImageResource(R.drawable.selection_mage_smaller60_130);
                imageViewHeroIcon.setImageResource(R.drawable.mage);
            }
            else if (AppData.selectedhero.getId()==3) {
                gifImageViewHero.setImageResource(R.drawable.selection_paladin_smaller);
                imageViewHeroIcon.setImageResource(R.drawable.paladin);
            }
            else if (AppData.selectedhero.getId()==4) {
                gifImageViewHero.setImageResource(R.drawable.selection_darkelf_smaller);
                imageViewHeroIcon.setImageResource(R.drawable.archer);
            }
            else if (AppData.selectedhero.getId()==5) {
                gifImageViewHero.setImageResource(R.drawable.selection_priest_smaller);
                imageViewHeroIcon.setImageResource(R.drawable.priest);
            }
    }
}

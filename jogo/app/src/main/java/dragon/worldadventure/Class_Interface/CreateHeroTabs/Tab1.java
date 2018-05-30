package dragon.worldadventure.Class_Interface.CreateHeroTabs;

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

public class Tab1 extends Fragment{



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.createherotab1, container, false);


        TextView textViewHeroName = rootView.findViewById(R.id.TextViewHeroName);
        TextView textViewHp = rootView.findViewById(R.id.TextViewHPValue);
        TextView textViewATK = rootView.findViewById(R.id.TextViewATKValue);
        TextView textViewDefence = rootView.findViewById(R.id.TextViewDefenceValue);
        TextView textViewLuck = rootView.findViewById(R.id.TextViewLuckValue);
        TextView textViewClass = rootView.findViewById(R.id.TextViewClassValue);

        textViewHeroName.setText(AppData.warrior.getHeroname());
        textViewHp.setText(""+AppData.warrior.getHp());
        textViewATK.setText(""+AppData.warrior.getAtk());
        textViewDefence.setText(""+AppData.warrior.getDefense());
        textViewLuck.setText(""+AppData.warrior.getLuck());
        textViewClass.setText(AppData.warrior.getClasse());

        return rootView;
    }
}

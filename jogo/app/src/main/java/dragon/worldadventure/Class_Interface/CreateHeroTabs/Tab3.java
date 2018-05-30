package dragon.worldadventure.Class_Interface.CreateHeroTabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dragon.worldadventure.Objects.AppData;
import dragon.worldadventure.R;

public class Tab3 extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.createherotab3, container, false);

        TextView textViewHeroName = rootView.findViewById(R.id.TextViewHeroName);
        TextView textViewHp = rootView.findViewById(R.id.TextViewHPValue);
        TextView textViewATK = rootView.findViewById(R.id.TextViewATKValue);
        TextView textViewDefence = rootView.findViewById(R.id.TextViewDefenceValue);
        TextView textViewLuck = rootView.findViewById(R.id.TextViewLuckValue);
        TextView textViewClass = rootView.findViewById(R.id.TextViewClassValue);

        textViewHeroName.setText(AppData.paladin.getHeroname());
        textViewHp.setText(""+AppData.paladin.getHp());
        textViewATK.setText(""+AppData.paladin.getAtk());
        textViewDefence.setText(""+AppData.paladin.getDefense());
        textViewLuck.setText(""+AppData.paladin.getLuck());
        textViewClass.setText(AppData.paladin.getClasse());

       
        return rootView;
    }
}

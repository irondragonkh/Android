package dragon.worldadventure.Class_Interface.CreateHeroTabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dragon.worldadventure.Objects.AppData;
import dragon.worldadventure.R;

public class Tab5 extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.createherotab5, container, false);

        TextView textViewHeroName = rootView.findViewById(R.id.TextViewHeroName);
        TextView textViewHp = rootView.findViewById(R.id.TextViewHPValue);
        TextView textViewATK = rootView.findViewById(R.id.TextViewATKValue);
        TextView textViewDefence = rootView.findViewById(R.id.TextViewDefenceValue);
        TextView textViewLuck = rootView.findViewById(R.id.TextViewLuckValue);
        TextView textViewClass = rootView.findViewById(R.id.TextViewClassValue);

        textViewHeroName.setText(AppData.archer.getHeroname());
        textViewHp.setText(""+AppData.archer.getHp());
        textViewATK.setText(""+AppData.archer.getAtk());
        textViewDefence.setText(""+AppData.archer.getDefense());
        textViewLuck.setText(""+AppData.archer.getLuck());
        textViewClass.setText(AppData.archer.getClasse());

       
        return rootView;
    }
}

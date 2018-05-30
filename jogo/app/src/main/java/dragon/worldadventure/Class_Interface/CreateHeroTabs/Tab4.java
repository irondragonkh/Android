package dragon.worldadventure.Class_Interface.CreateHeroTabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dragon.worldadventure.Objects.AppData;
import dragon.worldadventure.R;

public class Tab4 extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.createherotab4, container, false);

        TextView textViewHeroName = rootView.findViewById(R.id.TextViewHeroName);
        TextView textViewHp = rootView.findViewById(R.id.TextViewHPValue);
        TextView textViewATK = rootView.findViewById(R.id.TextViewATKValue);
        TextView textViewDefence = rootView.findViewById(R.id.TextViewDefenceValue);
        TextView textViewLuck = rootView.findViewById(R.id.TextViewLuckValue);
        TextView textViewClass = rootView.findViewById(R.id.TextViewClassValue);

        textViewHeroName.setText(AppData.priest.getHeroname());
        textViewHp.setText(""+AppData.priest.getHp());
        textViewATK.setText(""+AppData.priest.getAtk());
        textViewDefence.setText(""+AppData.priest.getDefense());
        textViewLuck.setText(""+AppData.priest.getLuck());
        textViewClass.setText(AppData.priest.getClasse());

       
        return rootView;
    }
}

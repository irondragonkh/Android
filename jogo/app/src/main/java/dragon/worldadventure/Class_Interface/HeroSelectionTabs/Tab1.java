package dragon.worldadventure.Class_Interface.HeroSelectionTabs;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import dragon.worldadventure.Base_Dados.DBHandler;
import dragon.worldadventure.Base_Dados.UserHeroesDBTable;
import dragon.worldadventure.Objects.AppData;
import dragon.worldadventure.R;
import pl.droidsonroids.gif.GifImageView;

public class Tab1 extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1, container, false);




        checkexistance(rootView);

        return rootView;
    }

    private void checkexistance(View rootView) {


        if(AppData.existstab1){

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
            gifImageViewHero.setImageResource(R.drawable.ic_person_add_black_24dp);
        }
    }
}


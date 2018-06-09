package dragon.worldadventure.Class_Interface.InGameTabs;

import android.app.Activity;
import android.content.Context;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.InputStream;
import java.util.Random;

import dragon.worldadventure.R;
import pl.droidsonroids.gif.GifImageView;

public class Travel extends Fragment {

    View myView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.ingametravel,container,false);

        FillTravel(myView);
        return myView;



    }


    private void FillTravel(View myView){
        GifImageView gifImageView = myView.findViewById(R.id.GifImageViewTravel);
        Button button = myView.findViewById(R.id.ButtonAdvanceAdventure);
        button.setText(R.string.TravelButton);

        int min = 1;
        int max = 2;

        Random r = new Random();
        int randomnumber = r.nextInt(max - min + 1) + min;

        if(randomnumber==1){
            gifImageView.setImageResource(R.drawable.forestslower);
        }else if(randomnumber==2){
            gifImageView.setImageResource(R.drawable.cityslower);
        }
    }
}
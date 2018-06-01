package dragon.worldadventure.Class_Interface.Bars;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import dragon.worldadventure.R;

public class Bars extends Activity {


    TextView textViewLevel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header_in_game);

        textViewLevel = findViewById(R.id.TextViewNavBarLevel);
        textViewLevel.setText("Level 50");
    }


}

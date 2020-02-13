package com.bagalkotneha.onclicklistener_toast_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toast toast;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int count;
    SeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("keyName", "newValue");
        editor.putInt("TopLeft", 0);
        editor.putInt("TopRight", 0);
        editor.putInt("BottomLeft", 0);
        editor.putInt("BottomRight", 0);
        editor.apply();
        seekbar = findViewById(R.id.seekbar);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {

                // increment 1 in progress and
                // increase the textsize
                // with the value of progress
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

                // This method will automatically
                // called when the user touches the SeekBar
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

                // This method will automatically
                // called when the user
                // stops touching the SeekBar
            }
        });
    }

    public void onClick(View view) {
        TextView x = (TextView)view;
        String id = String.valueOf(x.getTag());
        count = sharedPreferences.getInt(id, 0);
        count++;
        editor.putInt(id, count);
        editor.apply();
        toast = Toast.makeText(getApplicationContext(),
                "The " + id + " text was pressed " + count + " times.",
                Toast.LENGTH_SHORT);
        toast.show();
    }
}

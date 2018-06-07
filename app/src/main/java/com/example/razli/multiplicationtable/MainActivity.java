package com.example.razli.multiplicationtable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> mListOfMultiples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get reference for seekbar & listview
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        final ListView multiplicationListView = findViewById(R.id.multiplicationListView);

        // Create arraylist (dynamic) (x, x + x, x + 2x ...)
        mListOfMultiples = new ArrayList<Integer>();

        // Create adapter
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, mListOfMultiples);

        // Attach adapter
        multiplicationListView.setAdapter(arrayAdapter);

        // Seekbar alters arraylist
        seekBar.setMax(50);
        //seekBar.setMin(1);
        seekBar.setProgress(2);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateArrayValues(mListOfMultiples, progress);
                ((BaseAdapter) multiplicationListView.getAdapter()).notifyDataSetChanged();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void updateArrayValues(ArrayList<Integer> arrayList, int newBaseValue) {
        arrayList.clear();

        // Fill arraylist again. Loops 20 times
        for(int i = 1; i <= 50; i++) {
            arrayList.add(newBaseValue * i);
        }

        Log.i("Multiples", Arrays.toString(arrayList.toArray()));
    }
}

package com.example.examplejavaspinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private Activity mActivity;

    private ConstraintLayout mCLayout;
    private Spinner mSpinner;
    private ArrayAdapter mAdapter;
    private int mSelectedIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        mActivity = MainActivity.this;

        // Get the widget reference from XML layout
        mCLayout = (ConstraintLayout) findViewById(R.id.cl_layout);
        mSpinner = (Spinner) findViewById(R.id.action_bar_spinner);
        // Initialize a new list
                List<String> flowers = new ArrayList<>();
                flowers.add("Aconitum");
                flowers.add("African Daisy");
                flowers.add("Alchemilla");
                flowers.add("Allium roseum");
                flowers.add("Alstroemeria");

        // Initialize an array adapter
        mAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, flowers) {
            public View getView(int position, View convertView, ViewGroup parent) {
                // Cast the spinner collapsed item (non-popup item) as a text view
                TextView tv = (TextView) super.getView(position, convertView, parent);


                tv.setTextColor(Color.BLUE);

                
                return tv;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                // Cast the drop down items (popup items) as text view
                TextView tv = (TextView) super.getDropDownView(position, convertView, parent);

                // Set the text color of drop down items
                tv.setTextColor(Color.RED);

                // If this item is selected item
                if (position == mSelectedIndex) {
                    // Set spinner selected popup item's text color
                    tv.setTextColor(Color.BLUE);
                }

                // Return the modified view
                return tv;
            }
        };

        // Set an item selection listener for spinner widget
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Set the value for selected index variable
                mSelectedIndex = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Data bind the spinner with array adapter items
        mSpinner.setAdapter(mAdapter);

    }
}
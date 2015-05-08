package com.example.finley.listviewdemo;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Checkable;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ListActivity {

    private ArrayList<String> listValues;

    private TextView mCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCount = (TextView) findViewById(R.id.select_item_count);

        listValues = new ArrayList<String>();
        listValues.add("Android");
        listValues.add("iOS");
        listValues.add("Symbian");
        listValues.add("Blackberry");
        listValues.add("Windows Phone");

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, R.layout.listview_row_layout, R.id.listText, listValues);
        setListAdapter(myAdapter);

        getListView().setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ViewGroup vp = (ViewGroup) view;

                final int count = vp.getChildCount();

                for(int i = 0; i < count; i++) {
                    final View child = vp.getChildAt(i);
                    if(child instanceof Checkable) {
                        ((Checkable) child).setChecked(true);
                    }
                }

                mCount.setText(String.format(getResources().getString(R.string.item_count), getListView().getCheckedItemCount()));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.m2sili.convertisseur;

import android.app.ListActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class Convertisseur extends ListActivity
{
    private DeviseAdapter adapter;
    private double value = 1.0;
    private EditText mEdit;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mEdit = (EditText)findViewById(R.id.value);
        mEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!mEdit.getText().toString().equals("")) {
                    double newValue = Double.parseDouble(mEdit.getText().toString());
                    int i;
                    for (i = 0; i < adapter.getCount(); ++i) {
                        adapter.getItem(i).setValue((newValue * adapter.getItem(i).getValue()) / value);
                    }
                    value = Double.parseDouble(mEdit.getText().toString());
                    adapter.notifyDataSetChanged();
                }
            }
        });

        adapter = new DeviseAdapter(this);
        setListAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        double newValue = Double.parseDouble(mEdit.getText().toString());
        switch (item.getItemId()) {
            case R.id.menu_refresh:
                int i;
                for(i = 0; i < adapter.getCount(); ++i) {
                    adapter.getItem(i).setValue(newValue * adapter.getItem(i).getValue() / value);
                }
                break;
        }
        value = Double.parseDouble(mEdit.getText().toString());
        adapter.notifyDataSetChanged();
        return(super.onOptionsItemSelected(item));
    }
}

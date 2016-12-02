package com.m2sili.convertisseur;

import android.content.Context;
import android.content.res.AssetManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 11/16/16.
 */

public class DeviseAdapter extends ArrayAdapter<Devise> {
    private final Context context;

    public DeviseAdapter(Context context) {
        super(context, R.layout.ligne);
        this.context = context;
        AssetManager asset = context.getAssets();

        //  lecture du fichier csv
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(asset.open("taux.csv")));
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replace(",", ".");
                String[] result = line.split(";");
                double taux = 0d;
                if(!result[1].equals("ND")) {
                    taux = Double.parseDouble(result[1]);
                }
                Devise devise = new Devise(result[0], taux);
                this.add(devise);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View ligneView = inflater.inflate(R.layout.ligne, parent, false);
        TextView nom = (TextView) ligneView.findViewById(R.id.label);
        TextView valeur = (TextView) ligneView.findViewById(R.id.value);
        nom.setText(this.getItem(position).getNom());
        if(this.getItem(position).getValue() == 0d) {
            valeur.setText("Not available");
        }
        else {
            valeur.setText(Double.toString(this.getItem(position).getValue()));
        }
        return ligneView;
    }
}

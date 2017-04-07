package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Praktikan on 23/03/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake>{
    public EarthquakeAdapter(Context context, List<Earthquake> objects){
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        Earthquake mEarthquake = getItem(position);
        TextView magnitude = (TextView) convertView.findViewById(R.id.angka);

        GradientDrawable bg = (GradientDrawable) magnitude.getBackground();
        bg.setColor(ContextCompat.getColor(getContext(),
                getColor(mEarthquake.getMag())));

        magnitude.setText(String.valueOf(mEarthquake.getMag()));

        if (mEarthquake.getLoc().contains(" of ")){
            String dataLoc[] = mEarthquake.getLoc().split(" of ");

            TextView distance = (TextView) convertView.findViewById(R.id.distance);
            distance.setText(dataLoc[0] + " of");

            TextView lokasi = (TextView) convertView.findViewById(R.id.lokasi);
            distance.setText(dataLoc[1]);
        }
        else {
            TextView distance = (TextView) convertView.findViewById(R.id.distance);
            distance.setText("Near of");
            TextView lokasi = (TextView) convertView.findViewById(R.id.lokasi);
            distance.setText(mEarthquake.getLoc());
        }

        Date date = new Date(mEarthquake.getDate());
        SimpleDateFormat sdf = new SimpleDateFormat("d-M-yyyy");
        TextView dateSet = (TextView) convertView.findViewById(R.id.tanggal);
        dateSet.setText(sdf.format(date));
        return convertView;
    }

    private int getColor(double mMagnitude){
        int mag = (int) Math.floor(mMagnitude);
        int result;
        switch (mag) {
            case 0:
            case 1:
                result = R.color.magnitude1;
                break;
            case 2:
                result = R.color.magnitude2;
                break;
            case 3:
                result = R.color.magnitude3;
                break;
            case 4:
                result = R.color.magnitude4;
                break;
            case 5:
                result = R.color.magnitude5;
                break;
            case 6:
                result = R.color.magnitude6;
                break;
            case 7:
                result = R.color.magnitude7;
                break;
            case 8:
                result = R.color.magnitude8;
                break;
            case 9:
                result = R.color.magnitude9;
                break;
            default:
                result = R.color.magnitude10;
                break;
        }
        return result;
    }
}

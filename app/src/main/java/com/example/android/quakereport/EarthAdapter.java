package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by swamygangadharpavanvulisetti on 9/7/17.
 */

public class EarthAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = "of";

    public EarthAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_view, parent, false);
        }

        Earthquake currentEarthQuake = getItem(position);


        //double originalMagnitude = currentEarthQuake.getMagnitude();

        //        DecimalFormat formatter = new DecimalFormat("0.0");
        //        String output = formatter.format(originalMagnitude);

        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);
        String formatMagnitude = formatMagnitude(currentEarthQuake.getMagnitude());
        magnitude.setText(formatMagnitude);


        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthQuake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        String originalLocation = currentEarthQuake.getPlace();
        String locationOffset;
        String primaryLocation;

        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        TextView offset = (TextView) listItemView.findViewById(R.id.offset);
        offset.setText(locationOffset);

        TextView primary = (TextView) listItemView.findViewById(R.id.primary);
        primary.setText(primaryLocation);


        // Completely About Date

        Date dateObject = new Date((currentEarthQuake.getDate()));

        TextView date = (TextView) listItemView.findViewById(R.id.date);


        String formattedDate = formatDate(dateObject);
        date.setText(formattedDate);

        TextView time = (TextView) listItemView.findViewById(R.id.time);

        String formattedTime = formatTime(dateObject);

        time.setText(formattedTime);

        return listItemView;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM DD, YYYY");
        return dateFormatter.format(dateObject);
    }

    private String formatTime(Date timeObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a ");
        return timeFormat.format(timeObject);
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

}
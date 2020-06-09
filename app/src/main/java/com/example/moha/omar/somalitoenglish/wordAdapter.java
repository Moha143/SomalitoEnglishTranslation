package com.example.moha.omar.somalitoenglish;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;


public class wordAdapter extends ArrayAdapter<word > {

private int ScolorResourceID; ;


    public wordAdapter (Activity context,ArrayList<word > words,int colorResourceid) {
        super(context ,0,words);
        ScolorResourceID =colorResourceid ;


    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from (getContext ()).inflate (
                    R.layout.list_item,parent,false);
        }


        // Get the {@link AndroidFlavor} object located at this position in the list
        word currentword = getItem (position);


        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView MiwoktextView = (TextView) listItemView.findViewById (R.id.miwok_text);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        MiwoktextView.setText (currentword.getSSomTtranslation ());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView DefaultTextView = (TextView) listItemView.findViewById (R.id.default_text);
        // set this text on the number TextView
        DefaultTextView.setText (currentword.getmDefaultTtranslation ());

        ImageView  iconView = (ImageView) listItemView.findViewById(R.id.image);
        if(currentword.HasImage () ){

            iconView.setImageResource (currentword.getImageResourId () );
            iconView.setVisibility (iconView.VISIBLE ) ;

        }
        else
        {

            iconView.setVisibility (iconView.GONE ) ;


        }

        View textContainer = listItemView.findViewById (R.id.text_container ) ;
        int color=ContextCompat.getColor (getContext () ,ScolorResourceID ) ;
        textContainer.setBackgroundColor (color ) ;






        // Return the whole list item layout
        // so that it can be shown in the ListView
        return listItemView;
    }
}

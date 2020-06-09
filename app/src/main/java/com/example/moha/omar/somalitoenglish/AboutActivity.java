package com.example.moha.omar.somalitoenglish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_about);

        TextView  gmail  = findViewById (R.id.gmail  );

        gmail.setOnClickListener (  new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext (), "Open your gmail",Toast.LENGTH_SHORT ).show () ;

                Intent  GmailIntent = new Intent (Intent.ACTION_SENDTO) ;
                GmailIntent.setData (Uri.parse ("mailto: moha143omar@gmail.com")) ;

                if(GmailIntent.resolveActivity (getPackageManager () )!=null)
                {

                    startActivity (GmailIntent) ;
                }


            }

        } );
        TextView tell = findViewById (R.id.tellphone);
        tell.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent  TellIntent = new Intent (Intent.ACTION_DIAL) ;
                TellIntent.setData (Uri.parse ("tel: 0615314730")) ;

                startActivity (TellIntent) ;



            }
        });
        TextView fb = findViewById (R.id.facebook);
        fb.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Uri uri = Uri.parse ("https://www.facebook.com/maxamed.qadar.754");
                Intent  facebook = new Intent (Intent.ACTION_VIEW) ;
                facebook.setPackage ("mobile.facebook.com") ;
                try {
                    startActivity (facebook) ;

                }

                catch (ActivityNotFoundException e){
                    startActivity ( new Intent (Intent.ACTION_VIEW, Uri.parse ("https://www.facebook.com/maxamed.qadar.754"))) ;


                }


            }
        });
        TextView instagrm = findViewById (R.id.instagram);
        instagrm.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Uri uri = Uri.parse ("https://www.instagram.com/khadar_malaysia?r=nametag");
                Intent  intent = new Intent (Intent.ACTION_VIEW) ;
                intent.setPackage ("com.instagram.android") ;
                try {
                    startActivity (intent) ;

                }

                catch (ActivityNotFoundException e){
                    startActivity ( new Intent (Intent.ACTION_VIEW, Uri.parse ("https://www.instagram.com/khadar_malaysia?r=nametag"))) ;


                }


            }
        });

        TextView tw = findViewById (R.id.twitter);
        tw.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Uri uri = Uri.parse ("https://twitter.com/Khadar_Malaysia?s=08");
                Intent  twitter = new Intent (Intent.ACTION_VIEW) ;
                twitter.setPackage ("mobile.twitter.com") ;
                try {
                    startActivity (twitter) ;

                }

                catch (ActivityNotFoundException e){
                    startActivity ( new Intent (Intent.ACTION_VIEW, Uri.parse ("https://twitter.com/Khadar_Malaysia?s=08"))) ;


                }


            }
        });



    }


}

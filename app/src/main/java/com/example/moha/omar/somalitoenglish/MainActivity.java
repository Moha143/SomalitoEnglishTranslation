package com.example.moha.omar.somalitoenglish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        // Step One Numbers
        CardView numbers = findViewById (R.id.numbers );
        numbers.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Toast.makeText (view.getContext () , "Open the list of Numbers",Toast.LENGTH_SHORT  ).show () ;
                Intent numberIntent = new Intent (MainActivity.this , numbersActivity .class ) ;
                startActivity (numberIntent ) ;

            }
        });

        // Step two  Family
        CardView  family = findViewById (R.id.family  );
        family .setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext (), "Open the list of family",Toast.LENGTH_SHORT ).show () ;
                Intent familyIntent = new Intent(MainActivity.this , FamilyActiviy  .class );
                startActivity(familyIntent);

            }

        } );
        CardView color = findViewById (R.id.colors   );
        color .setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext (), "Open the list of color",Toast.LENGTH_SHORT ).show () ;
                Intent colorIntent = new Intent(MainActivity.this , ColorsActivity   .class );
                startActivity(colorIntent);

            }

        } );

        CardView  phrases = findViewById (R.id.phrases    );

        phrases.setOnClickListener (  new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext (), "Open the list of Phrases",Toast.LENGTH_SHORT ).show () ;

                Intent  phrasesIntent = new Intent(MainActivity.this , PhrasesActivity   .class );
                startActivity(phrasesIntent);

            }

        } );
        CardView  about = findViewById (R.id.Abouts    );

        about.setOnClickListener (  new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext (), "Open about",Toast.LENGTH_SHORT ).show () ;

                Intent  AboutIntent = new Intent(MainActivity.this , AboutActivity   .class );
                startActivity(AboutIntent);


            }

        } );


// End

    }
}

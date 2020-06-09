package com.example.moha.omar.somalitoenglish;

public class word {
    private String mDefaultTtranslation;
    private String SSomTtranslation;



    private int ImageResourId=no_image_proveded;
    private  static final int no_image_proveded=-1;
    private  int SaudioResourceId;

    // the first constructor
    public word (String DefaultTtranslation, String SomaliTtranslation, int   AudioResourceId)
    {
        mDefaultTtranslation= DefaultTtranslation;
        SSomTtranslation=      SomaliTtranslation;
        SaudioResourceId = AudioResourceId ;


    }

    // second costructor that holds three input paramter
    public word (String DefaultTtranslation, String SomaliTtranslation,int SImageResourceID , int AudioResourceId )
    {
        mDefaultTtranslation= DefaultTtranslation;
        SSomTtranslation=      SomaliTtranslation;
        ImageResourId = SImageResourceID ;
        SaudioResourceId = AudioResourceId ;



    }

    // returns Image resource ID
    public int  getImageResourId  ()
    {

        return ImageResourId  ;


    }
    // returns English translation
    public String getmDefaultTtranslation ()
    {

        return mDefaultTtranslation ;


    }
    // returns Somali translation
    public String getSSomTtranslation()

    {

        return SSomTtranslation ;

    }
    // returns Audio Resource ID
    public int getSaudioResourceId()

    {

        return SaudioResourceId  ;

    }

    //  rerurn wether or not  hasImage for word
    public boolean HasImage(){

        return ImageResourId !=no_image_proveded ;

    }
}

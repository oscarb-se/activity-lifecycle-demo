package se.oscarb.activitylifecycledemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    /*
        När och i vilken ordning körs de olika metoderna?
        Pröva olika saker i mobilen! Kan du få alla att köras?
        Anteckna vad du gjorde som fick respektive metod att köras
        och vilka metoder som kördes precis innan/efter.

        Fundera också på - vilka tillstånd gick appen mellan?
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Activity Lifecycle", "Metoden onCreate() körs!");
    }

    /* 
    Den här metoden körs när man klickar på "Bakåt" knappen och att Activty hhar varit uppe i länge, men innan onDestoy() körs också onStop()  /Wojtek
    */
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    // Metoden onPause() körs när man klickar "bakåt" knappen kort efter Activty har startat /Wojtek

    @Override
    protected void onPause() {
        super.onPause();
    }
    
    //Metoden onRestart() körs när man återupptar Activty efter ett längre period /Wojtek
    
    @Override
    protected void onRestart() {
        super.onRestart();
    }

    //Metoden onResume() körs efter onCreate() och onStart() och när man återupptar Activity efter en kort period /Wojtek
    
    @Override
    protected void onResume() {
        super.onResume();
    }

    //Den metoden körs efter onCreate() Activty har skappats /Wojtek
    @Override
    protected void onStart() {
        super.onStart();
    }
    
    //Metoden onStop() körs när man klickar "hemma" knappen  /Wojtek
    @Override
    protected void onStop() {
        super.onStop();
    }
}

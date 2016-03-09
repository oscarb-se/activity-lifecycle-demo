package se.oscarb.activitylifecycledemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*
        När och i vilken ordning körs de olika metoderna?
        Pröva olika saker i mobilen! Kan du få alla att köras?
        Anteckna vad du gjorde som fick respektive metod att köras
        och vilka metoder som kördes precis innan/efter.

        Fundera också på - vilka tillstånd gick activityn mellan?

        Dela med dig av det du hittat genom att göra en "pull request"
        på denna fil på GitHub!

        Lägg till så att ett slumpat tal visas i appen.
        Vid vilka situationer byts talet ut?
        Hur kan vi göra så att vi behåller det slumpade värdet?

     */

    // Instansvariabel
    double savedRandomNumber;

    // Metoden körs när appen startar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Activity Lifecycle", "Metoden onCreate() körs!");

        // Om det finns ett tidigare sparat värde (savedInstance är inte null)..
        if(savedInstanceState != null) {
            //...hämta tidigare sparat värde
            savedRandomNumber = savedInstanceState.getDouble("RandomNumber");
        } else if (savedRandomNumber == 0) {
            //...annars sätt till nytt slumptal
            savedRandomNumber = Math.random();
        }
    }

    /*
        Denna metod körs varje gång något behöver sparas, då activityn byter tillstånd där informationen kan gå förlorad

     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i("Activiy Lifecycle", "Saving " + savedRandomNumber);

        // Spara värdet från instansvariabeln savedRandomNumber i outState (en Bundle)
        outState.putDouble("RandomNumber", savedRandomNumber);

        super.onSaveInstanceState(outState);

    }

    // Metoden körs när appen förstörs // Henry
    // Den här metoden körs när man klickar på "Bakåt" knappen och att Activty hhar varit uppe i länge, men innan onDestoy() körs också onStop()  /Wojtek
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Activity Lifecycle", "Metoden onDestroy() körs!");
    }

    // Metoden körs när appen pausar // Henry
    // Metoden onPause() körs när man klickar "bakåt" knappen kort efter Activty har startat /Wojtek
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Activity Lifecycle", "Metoden onPause() körs!");
    }

    // Metoden körs när appen startar om // Henry
    //Metoden onRestart() körs när man återupptar Activty efter ett längre period /Wojtek
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Activity Lifecycle", "Metoden onRestart() körs!");
        
    }

    // Metoden körs när appen körs igen // Henry
    //Metoden onResume() körs efter onCreate() och onStart() och när man återupptar Activity efter en kort period /Wojtek
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Activity Lifecycle", "Metoden onResume() körs!");
    }

    // Metoden körs när appen startar om // Henry
    // Den metoden körs efter onCreate() Activity har skappats /Wojtek
    @Override
    protected void onStart() {
        super.onStart();

        // Hämta TextView som ska visa slumpat tal
        TextView randomNumberText = (TextView) findViewById(R.id.random_number);
        randomNumberText.setText("" + savedRandomNumber);

        Log.i("Activity Lifecycle", "Metoden onStart() körs!");
    }


    // Metoden körs när appen slutar // Henry
    //Metoden onStop() körs när man klickar "hemma" knappen  /Wojtek
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Activity Lifecycle", "Metoden onStop() körs!");
    }


}

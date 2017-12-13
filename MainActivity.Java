package com.visualprecinct.baseballscore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {
String[] country = { "NYM","LAD","TBJ","NYY","Col.R","MM","AB","CC","TBR","LAA","PP","BRS","HA","BO", "DT"
};
int hits=0;
int hitsH=0;
int run=0;
int runsH=0;
int err=0;
int errH=0;
int thitsH=0;
int thits=0;
int score=0;

@Override

protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner ) findViewById(R.id.team_spinner);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
    //Getting the instance of Spinner and applying OnItemSelectedListener on it
    Spinner spinH =(Spinner) findViewById(R.id.team_spinnerH);
    spinH.setOnItemSelectedListener(this);
    //Setting the ArrayAdapter data on the Spinner
    spinH.setAdapter(aa);

        }

//Performing action onItemSelected and onNothing selected
public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(),country[position] ,Toast.LENGTH_LONG).show();
        }

public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

        }

    /**
     * This method is called when the Hits button is clicked for the home team.
     */
    public void incrementHitsH(View v) {
        hitsH = hitsH + 1;
        if (hitsH==2){
            runsH=runsH+1;
            displayRunsH(runsH);
            hitsH=0;
        }
        if (hitsH == 1) {
            thitsH=thitsH+1;
            displayTHitsH(thitsH);
        }
        displayHitsH(hitsH);
    }
    /**
     * This method is called when the Runs button is clicked for the home team.
     */
    public void incrementRunsH(View v) {
        runsH = runsH + 1;
        displayRunsH(runsH);
    }

    /**
     * This method is called when the Errors button is clicked for the home team.
     */
    public void incrementErrorsH(View v) {
        errH = errH + 1;
        if (errH==4){
            runsH=runsH+1;
            displayRunsH(runsH);
            errH=0;
        }
        if (errH == 1) {
            thitsH=thitsH+1;
            displayTHitsH(thitsH);
        }
        displayerrH(errH);
    }

    /**
     * This method is called when the Hits button is clicked for the visiting team.
     */
    public void incrementHits(View v) {
        hits = hits + 1;
        if(hits == 2){
            run = run +1;
            displayRuns(run);
            hits=0;
        }
        if (hits == 1) {
            thits=thits+1;
            displayTHits(thits);
        }
        displayHits(hits);
    }

    /**
     * This method is called when the Runs button is clicked for the visiting team.
     */
    public void incrementRuns(View v) {
        run = run + 1;
        displayRuns(run);
                    }

    /**
     * This method is called when the Errors button is clicked for the visiting team.
     */
    public void incrementErrors(View v) {
        err = err + 1;
        if (err==4){
            run=run+1;
            displayRuns(run);
            err=0;
        }
        if (err == 1) {
            thits=thits+1;
            displayTHits(thits);
        }
        displayErr(err);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayHitsH(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_hits_viewH);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayRunsH(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_run_viewH);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayerrH(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_error_viewH);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayHits(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_hits_view);
        quantityTextView.setText("" + number);
    }
    private void displayTHitsH(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_Thits_viewH);
        quantityTextView.setText("" + number);
    }
    private void displayTHits(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_Thits_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayRuns(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_run_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayErr(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_error_view);
        quantityTextView.setText("" + number);
    }
    private void displayScore(int number){
        TextView quantityTextView=(TextView)findViewById(R.id.Metz);
        quantityTextView.setText(""+ number);
    }
    public void winner (View V){
        String winner_message=null;
        if (runsH<run){
            Spinner spin = (Spinner ) findViewById(R.id.team_spinner);
            winner_message="Team "+ spin.getSelectedItem().toString() + "is the winner";
            Toast.makeText(this,"Team " +spin.getSelectedItem().toString()  + " is the winner!",Toast.LENGTH_LONG).show();
        }
        if (run<runsH){
            Spinner   spinH = (Spinner ) findViewById(R.id.team_spinnerH);
            winner_message="Team "+ spinH.getSelectedItem().toString() + "is the winner";
            Toast.makeText(this,"Team " +spinH.getSelectedItem().toString()  + " is the winner!",Toast.LENGTH_LONG).show();
        }
        TextView WinnerTv=findViewById(R.id.Metz);
        WinnerTv.setText(winner_message);
    }
    public void resetScore(View V) {
        hits = 0;
        hitsH = 0;
        run = 0;
        runsH = 0;
        err = 0;
        errH = 0;
        displayScore(0);
        displayRunsH(runsH);
        displayRuns(run);
        displayHits(hits);
        displayHitsH(hitsH);
        displayerrH(errH);
        displayErr(err);
    }
}
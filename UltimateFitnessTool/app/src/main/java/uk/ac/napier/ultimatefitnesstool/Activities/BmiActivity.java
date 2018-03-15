package uk.ac.napier.ultimatefitnesstool.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import uk.ac.napier.ultimatefitnesstool.R;

/**
 * Created by alex4 on 12/03/2018.
 */

public class BmiActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private LinearLayoutCompat linearLayoutCompatBmi;
    private TextInputEditText textInputEditTextHeight;
    private TextInputEditText textInputEditTextWeight;

    private TextInputLayout textInputLayoutWeight;
    private TextInputLayout textInputLayoutHeight;

    private AppCompatButton appCompatButtonCalculateBmi;
    private TextView textViewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        linearLayoutCompatBmi = (LinearLayoutCompat) findViewById(R.id.linearLayoutCompatBmi);
        textInputEditTextHeight = (TextInputEditText) findViewById(R.id.textInputEditTextHeight);
        textInputEditTextWeight = (TextInputEditText) findViewById(R.id.textInputEditTextWeight);
        textInputLayoutWeight = (TextInputLayout)findViewById(R.id.textInputLayoutWeight);
        textInputLayoutHeight = (TextInputLayout)findViewById(R.id.textInputLayoutHeight);
        appCompatButtonCalculateBmi = (AppCompatButton)findViewById(R.id.appCompatButtonCalculateBmi);
        textViewResult = (TextView) findViewById(R.id.textViewResult);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        appCompatButtonCalculateBmi.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                appCompatButtonCalculateBmi = (AppCompatButton) findViewById(R.id.appCompatButtonCalculateBmi);
                String heightStr = textInputEditTextHeight.getText().toString();
                String weightStr = textInputEditTextWeight.getText().toString();
                if (!isInputEditTextFilled(textInputEditTextHeight, textInputLayoutHeight, getString(R.string.error_message_height))) {
                    return;
                }
                if (!isInputEditTextFilled(textInputEditTextWeight, textInputLayoutWeight, getString(R.string.error_message_weight))) {
                    return;
                }else{
                    double heightValue = Float.parseFloat(heightStr) / 100;
                    double weightValue = Float.parseFloat(weightStr);
                    double bmi = weightValue / (heightValue * heightValue);

                    displayBMI(bmi);
                    Snackbar.make(linearLayoutCompatBmi, getString(R.string.success_bmi), Snackbar.LENGTH_LONG).show();
                    emptyInputEditText();
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent = new Intent(BmiActivity.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent = new Intent (BmiActivity.this, MainHomeActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.nav_diary) {

        } else if (id == R.id.nav_bmi) {

        } else if (id == R.id.nav_goals) {
            Intent intent = new Intent(BmiActivity.this, GoalsActivity.class);
            finish();
            startActivity(intent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.nav_settings) {
            Intent intent = new Intent(BmiActivity.this, SettingsActivity.class);
            finish();
            startActivity(intent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void displayBMI(double bmi) {
        String bmiLabel = "";

        if (Double.compare(bmi, 15) <= 0) {
            bmiLabel = getString(R.string.very_severely_underweight);
        } else if (Double.compare(bmi, 15) > 0  &&  Double.compare(bmi, 16) <= 0) {
            bmiLabel = getString(R.string.severely_underweight);
        } else if (Double.compare(bmi, 16) > 0  &&  Double.compare(bmi, 18.5) <= 0) {
            bmiLabel = getString(R.string.underweight);
        } else if (Double.compare(bmi, 18.5) > 0  &&  Double.compare(bmi, 25) <= 0) {
            bmiLabel = getString(R.string.normal);
        } else if (Double.compare(bmi, 25) > 0  &&  Double.compare(bmi, 30) <= 0) {
            bmiLabel = getString(R.string.overweight);
        } else if (Double.compare(bmi, 30) > 0  &&  Double.compare(bmi, 35) <= 0) {
            bmiLabel = getString(R.string.obese_class_i);
        } else if (Double.compare(bmi, 35) > 0  &&  Double.compare(bmi, 40) <= 0) {
            bmiLabel = getString(R.string.obese_class_ii);
        } else {
            bmiLabel = getString(R.string.obese_class_iii);
        }
        bmiLabel = bmi + "\n\n" + bmiLabel;
        textViewResult.setText(bmiLabel);
    }
    public boolean isInputEditTextFilled(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String message){
        String value = textInputEditText.getText().toString().trim();
        if(value.isEmpty()){
            textInputLayout.setError(message);
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            return false;
        }else{
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    public void emptyInputEditText(){
        textInputEditTextHeight.setText("");
        textInputEditTextWeight.setText("");
    }

}

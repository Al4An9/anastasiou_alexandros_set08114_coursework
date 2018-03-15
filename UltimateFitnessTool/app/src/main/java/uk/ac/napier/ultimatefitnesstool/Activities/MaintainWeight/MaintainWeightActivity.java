package uk.ac.napier.ultimatefitnesstool.Activities.MaintainWeight;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import uk.ac.napier.ultimatefitnesstool.Activities.BmiActivity;
import uk.ac.napier.ultimatefitnesstool.Activities.LooseWeight.LooseWMealsActivity;
import uk.ac.napier.ultimatefitnesstool.Activities.LooseWeight.LooseWSupplementsActivity;
import uk.ac.napier.ultimatefitnesstool.Activities.LooseWeight.LooseWTipsandTricksActivity;
import uk.ac.napier.ultimatefitnesstool.Activities.LooseWeight.LooseWWorkoutActivity;
import uk.ac.napier.ultimatefitnesstool.Activities.MaintainWeight.MaintainWeightActivity;
import uk.ac.napier.ultimatefitnesstool.Activities.MainHomeActivity;
import uk.ac.napier.ultimatefitnesstool.Activities.SettingsActivity;
import uk.ac.napier.ultimatefitnesstool.R;

public class MaintainWeightActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals_navigation);

        AppCompatButton appCompatButton = (AppCompatButton)findViewById(R.id.appCompatButtonTipsandTricks);
        AppCompatButton appCompatButton1 = (AppCompatButton)findViewById(R.id.appCompatButtonMealsSuggestions);
        AppCompatButton appCompatButton2 = (AppCompatButton)findViewById(R.id.appCompatButtonWorkoutSuggestions);
        AppCompatButton appCompatButton3 = (AppCompatButton)findViewById(R.id.appCompatButtonSupplementSuggestions) ;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        appCompatButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AppCompatButton appCompatButton = (AppCompatButton) findViewById(R.id.appCompatButtonTipsandTricks);
                startActivity(new Intent(MaintainWeightActivity.this, MaintainWTipsandTricksActivity.class));
            }
        });

        appCompatButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AppCompatButton appCompatButton1 = (AppCompatButton) findViewById(R.id.appCompatButtonMealsSuggestions);
                startActivity(new Intent(MaintainWeightActivity.this, MaintainWMealsActivity.class));
            }
        });

        appCompatButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AppCompatButton appCompatButton2 = (AppCompatButton) findViewById(R.id.appCompatButtonWorkoutSuggestions);
                startActivity(new Intent(MaintainWeightActivity.this, MaintainWWorkoutActivity.class));
            }
        });

        appCompatButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AppCompatButton appCompatButton2 = (AppCompatButton) findViewById(R.id.appCompatButtonSupplementSuggestions);
                startActivity(new Intent(MaintainWeightActivity.this, MaintainWSupplementsActivity.class));
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
            startActivity(new Intent(this, SettingsActivity.class));
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
            Intent intent = new Intent (MaintainWeightActivity.this, MainHomeActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.nav_diary) {

        } else if (id == R.id.nav_bmi) {
            Intent intent = new Intent(MaintainWeightActivity.this, BmiActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.nav_goals) {
            finish();
        } else if (id == R.id.nav_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
package uk.ac.napier.ultimatefitnesstool.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import uk.ac.napier.ultimatefitnesstool.R;

/**
 * Created by alex4 on 14/03/2018.
 */

public class GoalsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);

        AppCompatButton appCompatButton = (AppCompatButton)findViewById(R.id.appCompatButtonLooseWeight);
        AppCompatButton appCompatButton1 = (AppCompatButton)findViewById(R.id.appCompatButtonGainWeight);
        AppCompatButton appCompatButton2 = (AppCompatButton)findViewById(R.id.appCompatButtonMaintainWeight);

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
                AppCompatButton appCompatButton = (AppCompatButton) findViewById(R.id.appCompatButtonLooseWeight);
                Intent intent = new Intent(GoalsActivity.this, LooseWeightActivity.class);
                startActivity(intent);
                finish();
            }
        });

        appCompatButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AppCompatButton appCompatButton1 = (AppCompatButton) findViewById(R.id.appCompatButtonGainWeight);
                Intent intent = new Intent(GoalsActivity.this, GainWeightActivity.class);
                startActivity(intent);
                finish();
            }
        });

        appCompatButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AppCompatButton appCompatButton2 = (AppCompatButton) findViewById(R.id.appCompatButtonMaintainWeight);
                Intent intent = new Intent(GoalsActivity.this, MaintainWeightActivity.class);
                startActivity(intent);
                finish();
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
            Intent intent = new Intent(GoalsActivity.this, SettingsActivity.class);
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
            Intent intent = new Intent (GoalsActivity.this, MainHomeActivity.class);
            finish();
            startActivity(intent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.nav_diary) {

        } else if (id == R.id.nav_bmi) {
            Intent intent = new Intent(GoalsActivity.this, BmiActivity.class);
            finish();
            startActivity(intent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.nav_goals) {

        } else if (id == R.id.nav_settings) {
            Intent intent = new Intent(GoalsActivity.this, SettingsActivity.class);
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
}

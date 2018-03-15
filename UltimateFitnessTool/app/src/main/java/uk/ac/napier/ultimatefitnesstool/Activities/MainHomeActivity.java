package uk.ac.napier.ultimatefitnesstool.Activities;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.TextView;

import uk.ac.napier.ultimatefitnesstool.Model.User;
import uk.ac.napier.ultimatefitnesstool.R;
import uk.ac.napier.ultimatefitnesstool.sql.DatabaseHelper;

public class MainHomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    /*
    private DatabaseHelper databaseHelper;
    private User user;
    private String name, height, weight;

    public MainHomeActivity(User user) {
        this.user = user;
    }*/

    private TextView textViewName;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*databaseHelper = new DatabaseHelper(getApplicationContext());
        user = databaseHelper.getUser(String name);

        Intent intent = databaseHelper.getUser(String);
        name = intent.getStringExtra("COLUMN_USER_NAME");
        height = intent.getStringExtra("COLUMN_USER_HEIGHT");
        weight = intent.getStringExtra("COLUMN_USER_WEIGHT");*/

        textViewName = (TextView)findViewById(R.id.text1);
        String nameFromIntent = getIntent().getStringExtra("EMAIL");
        textViewName.setText("Welcome " + nameFromIntent);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //TextView headerNameTextView = navigationView.findViewById(R.id.textViewUsername);
        //headerNameTextView.setText("HellO");
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity( new Intent(MainHomeActivity.this, SettingsActivity.class));
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

        } else if (id == R.id.nav_diary) {

        } else if (id == R.id.nav_bmi) {
            Intent intent = new Intent(MainHomeActivity.this, BmiActivity.class);
            finish();
            startActivity(intent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.nav_goals) {
            Intent intent = new Intent(MainHomeActivity.this, GoalsActivity.class);
            finish();
            startActivity(intent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.nav_settings) {
            Intent intent = new Intent(MainHomeActivity.this, SettingsActivity.class);
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
    /*private void deleteClicked(){
        DatabaseHelper databaseHelper = new
        databaseHelper.deleteUser(user);
        Intent loginIntent = new Intent(MainHomeActivity.this, LoginActivity.class);
        startActivity(loginIntent);
        //Snackbar to show success message that record saved successfully
        Snackbar.make(MainHomeCoordinator, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();

    }*/
}

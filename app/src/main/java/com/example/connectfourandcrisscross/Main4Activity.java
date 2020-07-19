package com.example.connectfourandcrisscross;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.Timer;
import java.util.TimerTask;

public class Main4Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    ViewPager viewPager;
    PagerAdapter adapter;
    int curranrPage=0;
    int[] images;
    Timer timer;
    final long Delay_MS=500;
    final long PERIOD_MS=3000;
    int NUM_PAGES=6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        images = new int[] { R.drawable.download,
                R.drawable.downloadabc,
                R.drawable.connectgame,
                R.drawable.abcdef,
                R.drawable.downloadabc};

        viewPager = (ViewPager) findViewById(R.id.pager);

        adapter = new ImagePagerAdapter(Main4Activity.this, images);
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);
        final Handler handeler=new Handler();
        final Runnable update=new Runnable() {
            @Override
            public void run() {
                if(curranrPage==NUM_PAGES-1){
                    curranrPage=0;
                }
                viewPager.setCurrentItem(curranrPage++,true);
            }
        };
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handeler.post(update);
            }
        },Delay_MS,PERIOD_MS);
        ImageView ims=(ImageView)findViewById(R.id.imageView3);
        ims.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeTogame();
            }
        });
    }

public void takeTogame(){
    Intent u=new Intent(this,MainActivity.class);
    startActivity(u);
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
        getMenuInflater().inflate(R.menu.main4, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        int id = item.getItemId();
        if (id == R.id.nav_home) {
            // Create a new fragment of the appropriate type
            PersonalProfile fragment = new PersonalProfile();
            // What to do and where to do it
            transaction.replace(R.id.fragmentHolder, fragment);}
        else if (id == R.id.nav_gallery) {
            HowtoPlay fragment = new HowtoPlay();
            transaction.replace(R.id.fragmentHolder, fragment);

        }
        else if(id==R.id.nav_slideshow){
            Intent inta=new Intent(this,Main5Activity.class);
            startActivity(inta);
        }

        transaction.addToBackStack(null);

            // Implement the change
            transaction.commit();

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;

    }
}

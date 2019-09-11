package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.material.navigation.NavigationView;

import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //tutaj umiesc domyslna strone
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new FizFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_fiz);
        }
    }

    //routing
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_fiz:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FizFragment()).commit();
                break;
            case R.id.nav_chem:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ChemFragment()).commit();
                break;
            case R.id.nav_adm:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AdmFragment()).commit();
                break;
            case R.id.nav_biol:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new BiolFragment()).commit();
                break;
            case R.id.nav_eko:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EkoFragment()).commit();
                break;
            case R.id.nav_fil:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FilFragment()).commit();
                break;
            case R.id.nav_geo:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new GeoFragment()).commit();
                break;
            case R.id.nav_hist:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HistFragment()).commit();
                break;
            case R.id.nav_mat:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MatFragment()).commit();
                break;
            case R.id.nav_smp:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SmpFragment()).commit();
                break;
            case R.id.nav_wych:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new WychFragment()).commit();
                break;
            case R.id.nav_zarz:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ZarzFragment()).commit();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}

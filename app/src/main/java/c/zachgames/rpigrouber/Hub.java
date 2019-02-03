package c.zachgames.rpigrouber;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


public class Hub extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    private ViewPager viewPager;
    private SlideAdapter myadapter;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hub);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        myadapter = new SlideAdapter(this);
        viewPager.setAdapter(myadapter);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.nav_editProfile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container, new EditProfileFragment()).commit();
                break;

            case R.id.nav_manageNotifications:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container, new ManageNotificationsFragment()).commit();
                break;
            case R.id.nav_privacysettings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container, new PrivacySettingsFragment()).commit();
                break;
            case R.id.nav_securitysettings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container, new SecuritySettingsFragment()).commit();
                break;
            case R.id.nav_addfriends:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container, new AddFriendsFragment()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }
}

package com.carcavaz.chochilyapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.carcavaz.chochilyapp.fragments.PersonalFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = (BottomNavigationView) findViewById(R.id.bottombar);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_personal);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Toast toast = Toast.makeText(getApplicationContext(), item.toString(), Toast.LENGTH_LONG);

            switch (item.getItemId()) {
                case R.id.navigation_personal:
                    toast.show();
                    setToolbarBottomBarColor(R.style.PersonalTheme, R.color.color_orange_dark, getDrawable(R.color.color_orange));
                    PersonalFragment homeFragment = new PersonalFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, homeFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .commit();

                    return true;
                case R.id.navigation_produccion:
                    toast.show();
                    return true;
                case R.id.navigation_inventario:
                    toast.show();
                    return true;
            }
            return false;
        }
    };

    private void setToolbarBottomBarColor(int personalTheme, int color_orange_dark, Drawable drawable) {
        setTheme(personalTheme);
        setNotificationColor(color_orange_dark);
        navigation.setBackground(drawable);

    }

    private void setNotificationColor(int color) {
        // clear FLAG_TRANSLUCENT_STATUS flag:
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // finally change the color
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), color));

    }

}
                /*Intent intent = new Intent(activity, PictureDetailActivity.class);
                //transiciones de salida
                /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                {
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(activity, v, activity.getString(R.string.transitionname_picture)).toBundle());
                }
                else{
                    activity.startActivity(intent);
                }
                */
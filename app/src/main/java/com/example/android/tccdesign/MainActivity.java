package com.example.android.tccdesign;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import static android.content.Intent.getIntent;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    public static final String PREFS_NAME = "MyPrefsFile";

    Bundle dados;
    Intent intent;

    //This is our viewPager
    private ViewPager viewPager;

    //Fragments

    CarteirinhaFragment carterinhaFragment;
    NotasFragment notasFragment;
    HorarioFragment horarioFragment;
    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = getIntent();
        dados = intent.getExtras();

        ImageButton configbutton = (ImageButton) findViewById(R.id.configButton);
        configbutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, settingActivity.class));
            }
        });

        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        //Initializing the bottomNavigationView
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_Home:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.action_Notas:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.action_horarios:
                                viewPager.setCurrentItem(2);
                                break;
                        }
                        return false;
                    }
                });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setupViewPager(viewPager);
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        carterinhaFragment = new CarteirinhaFragment();
        notasFragment = new NotasFragment();
        horarioFragment = new HorarioFragment();
        adapter.addFragment(carterinhaFragment);
        adapter.addFragment(notasFragment);
        adapter.addFragment(horarioFragment);
        viewPager.setAdapter(adapter);
        carterinhaFragment.setArguments(dados);
        notasFragment.setArguments(dados);
    }

    protected void onStop()
    {
        super.onStop();
        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("RM", dados.getString("RM"));
        editor.putString("Nome", dados.getString("Nome"));
        editor.putString("Sala", dados.getString("Sala"));
        editor.putString("Curso", dados.getString("Curso"));
        editor.putString("Número", dados.getString("Número"));
        editor.putString("Validade", dados.getString("Validade"));

        // Commit the edits!
        editor.commit();
    }

}

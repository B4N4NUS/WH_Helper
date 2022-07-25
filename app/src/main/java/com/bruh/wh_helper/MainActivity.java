package com.bruh.wh_helper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    public static final Fragment[] tabsFragments = {new Basic(), new Battle(), new Command(), new Movement(), new Psycker(), new Shooting(), new Attack(), new Combat(), new Morale(), new Missions()};
    private static final String[] titles = {"База", "Бой", "Фаза Коммандования", "Фаза Перемещения", "Психическая Фаза", "Фаза Стрельбы", "Фаза Атаки", "Фаза Сражения", "Фаза Морали", "Миссии"};


    private void switchActivitiesWithData() {
        Intent switchActivityIntent = new Intent(this, DicesActivity.class);
        switchActivityIntent.putExtra("message", "From: " + MainActivity.class.getSimpleName());
        startActivity(switchActivityIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

//        Thread thread =new Thread() {
//            @Override
//            public void run() {
//            try {
//                String sosi = "";
//                StringBuilder string = new StringBuilder();
//                URL url = new URL("https://wahapedia.ru/wh40k9ed/factions/necrons/datasheets.html#Ghost-Ark");
//
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                connection.setRequestMethod("GET");
//                connection.setRequestProperty("Accept-Encoding", "gzip");
//                connection.connect();
//
//                // Ответный код сервера.
//                int responseCode = connection.getResponseCode();
//                System.out.println("----------------------------------------GOT_RESPONSE_FROM_PLAYERS_FOR_USER_FINDING________________________________________________");
//
//
//                // Если сервак не захотел отдавать данные.
//                if (responseCode != 200) {
//                    throw new RuntimeException("Players: HttpResponseCode: " + responseCode);
//                } else {
//                    // Перегоняем инфу с сервера в строку.
//                    Scanner scanner = new Scanner(url.openStream());
//                    while (scanner.hasNext()) {
//                        string.append(scanner.nextLine());
//                    }
//                    scanner.close();
//                }
//
//                sosi = string.toString();
//                System.out.println("----------------------------------------RAW_USER_________________________________________________");
//                System.out.println("Raw user: " + sosi);
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }};
//        thread.start();

        setContentView(R.layout.activity_main);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);

//        tabLayout.addTab(tabLayout.newTab().setText("Профиль").setIcon(R.drawable.ic_profile));
//        tabLayout.addTab(tabLayout.newTab().setText("Статистика").setIcon(R.drawable.ic_stats));
//        tabLayout.addTab(tabLayout.newTab().setText("Новости").setIcon(R.drawable.ic_news));
//        tabLayout.addTab(tabLayout.newTab().setText("Расписание").setIcon(R.drawable.ic_schedule));
//        tabLayout.addTab(tabLayout.newTab().setText("Достижения").setIcon(R.drawable.ic_medal));

        tabLayout.addTab(tabLayout.newTab().setText("База").setIcon(R.drawable.book));
        tabLayout.addTab(tabLayout.newTab().setText("Бой").setIcon(R.drawable.document));
        tabLayout.addTab(tabLayout.newTab().setText("Коммандование").setIcon(R.drawable.angry));
        tabLayout.addTab(tabLayout.newTab().setText("Перемещение").setIcon(R.drawable.acceleration));
        tabLayout.addTab(tabLayout.newTab().setText("Магия").setIcon(R.drawable.magic));
        tabLayout.addTab(tabLayout.newTab().setText("Стрельба").setIcon(R.drawable.target));
        tabLayout.addTab(tabLayout.newTab().setText("Атака").setIcon(R.drawable.heart));
        tabLayout.addTab(tabLayout.newTab().setText("Сражение").setIcon(R.drawable.sword));
        tabLayout.addTab(tabLayout.newTab().setText("Мораль").setIcon(R.drawable.sad));
        tabLayout.addTab(tabLayout.newTab().setText("Миссии").setIcon(R.drawable.clipboard));

//
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_stats));
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_medal));
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_schedule));
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_news));
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_profile));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        TextView title = findViewById(R.id.textView4);
        title.setText(titles[0]);


        ImageButton info = findViewById(R.id.infoButton);
        info.setOnClickListener(e -> switchActivitiesWithData());


        final SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setOffscreenPageLimit(5);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                title.setText(titles[tab.getPosition()]);
//                if (tab.getPosition() == 1) {
//                    info.setVisibility(View.VISIBLE);
//                    inf.setVisibility(View.INVISIBLE);
//                } else {
//                    if (tab.getPosition() == 0) {
//                        inf.setVisibility(View.VISIBLE);
//                        info.setVisibility(View.INVISIBLE);
//                    } else {
//                        info.setVisibility(View.INVISIBLE);
//                        inf.setVisibility(View.INVISIBLE);
//                    }
//                }
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
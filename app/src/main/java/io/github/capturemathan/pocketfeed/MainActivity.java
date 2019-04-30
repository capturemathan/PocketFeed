package io.github.capturemathan.pocketfeed;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    //private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_images);
        //mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        View menu_fab1 = findViewById(R.id.fab1);
        menu_fab1.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View arg0) {
                Toast.makeText(getApplicationContext(), "Report a Bug", Toast.LENGTH_SHORT).show();
                return true;    // set to true
            }
        });

        View menu_fab2 = findViewById(R.id.fab2);
        menu_fab2.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View arg0) {
                Toast.makeText(getApplicationContext(), "Rate me", Toast.LENGTH_SHORT).show();
                return true;    // set to true
            }
        });

        View menu_fab3 = findViewById(R.id.fab3);
        menu_fab3.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View arg0) {
                Toast.makeText(getApplicationContext(), "About me", Toast.LENGTH_SHORT).show();
                return true;    // set to true
            }
        });

        View menu_icon = findViewById(R.id.menu);
        menu_icon.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View arg0) {
                Toast.makeText(getApplicationContext(), "Options", Toast.LENGTH_SHORT).show();
                return true;    // set to true
            }
        });

    }

    //String NEWS_CAT_URL; //="category=business&apiKey=c60dc7c66a474c03ba181227554788ee";
    public static int id = 0;
    Bundle params = new Bundle();

    public void tech(View view) {
        //NEWS_CAT_URL="category=technology&apiKey=c60dc7c66a474c03ba181227554788ee";
        id = 1;
        params.putString("Category", "Technology");
        //mFirebaseAnalytics.logEvent("SelectedCategory_Technology", params);
        Intent i = new Intent(MainActivity.this, NewsActivity.class);
        startActivity(i);
    }

    public void business(View view) {
        //NEWS_CAT_URL="category=business&apiKey=c60dc7c66a474c03ba181227554788ee";
        id = 2;
        params.putString("Category", "Business");
        //mFirebaseAnalytics.logEvent("SelectedCategory_Business", params);
        Intent i = new Intent(MainActivity.this, NewsActivity.class);
        startActivity(i);
    }

    public void entertainment(View view) {
        //NEWS_CAT_URL="category=entertainment&apiKey=c60dc7c66a474c03ba181227554788ee";
        id = 3;
        params.putString("Category", "Entertainment");
        //mFirebaseAnalytics.logEvent("SelectedCategory_Entertainment", params);
        Intent i = new Intent(MainActivity.this, NewsActivity.class);
        startActivity(i);
    }

    public void health(View view) {
        //NEWS_CAT_URL="category=health&apiKey=c60dc7c66a474c03ba181227554788ee";
        id = 4;
        params.putString("Category", "Health");
        //mFirebaseAnalytics.logEvent("SelectedCategory_Health", params);
        Intent i = new Intent(MainActivity.this, NewsActivity.class);
        startActivity(i);
    }

    public void science(View view) {
        //NEWS_CAT_URL="category=science&apiKey=c60dc7c66a474c03ba181227554788ee";
        id = 5;
        params.putString("Category", "Science");
        //mFirebaseAnalytics.logEvent("SelectedCategory_Science", params);
        Intent i = new Intent(MainActivity.this, NewsActivity.class);
        startActivity(i);
    }

    public void sport(View view) {
        //NEWS_CAT_URL="category=sports&apiKey=c60dc7c66a474c03ba181227554788ee";
        id = 6;
        params.putString("Category", "Sport");
        //mFirebaseAnalytics.logEvent("SelectedCategory_Sport", params);
        Intent i = new Intent(MainActivity.this, NewsActivity.class);
        startActivity(i);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        deleteCache(getBaseContext());
    }

    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if (dir != null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }

    public void bug(View view) {
        params.putString("MenuCategory", "Bug");
        //mFirebaseAnalytics.logEvent("MenuSelectedCategory_Bug", params);
        Intent it = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "capturesmk@gmail.com", null));
        it.putExtra(Intent.EXTRA_SUBJECT, "Regarding Bug in Pocket Feed App");
        it.putExtra(Intent.EXTRA_EMAIL, new String[]{"capturesmk@gmail.com"});
        if (it.resolveActivity(getPackageManager()) != null)
            startActivity(it);
    }

    public void rateme(View view) {
        params.putString("MenuCategory", "Ratings");
        //mFirebaseAnalytics.logEvent("MenuSelectedCategory_Ratings", params);
        final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }

    public void knowme(View view) {
        params.putString("MenuCategory", "Profile");
        //mFirebaseAnalytics.logEvent("MenuSelectedCategory_Profile", params);
        Intent i = new Intent(MainActivity.this, About.class);
        startActivity(i);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {

            case R.id.about:
                Intent i = new Intent(MainActivity.this, About.class);
                startActivity(i);
                return true;
            case R.id.bug:
                Intent it = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "capturesmk@gmail.com", null));
                it.putExtra(Intent.EXTRA_SUBJECT, "Regarding Bug in Pocket Feed App");
                it.putExtra(Intent.EXTRA_EMAIL, new String[]{"capturesmk@gmail.com"});
                if (it.resolveActivity(getPackageManager()) != null)
                    startActivity(it);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void proceed(View view) {
        Intent i = new Intent(MainActivity.this, Content.class);
        startActivity(i);
    }*/

}
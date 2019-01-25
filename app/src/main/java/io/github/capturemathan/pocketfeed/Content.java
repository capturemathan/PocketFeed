package io.github.capturemathan.pocketfeed;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.analytics.FirebaseAnalytics;

public class Content extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }

    //String NEWS_CAT_URL; //="category=business&apiKey=c60dc7c66a474c03ba181227554788ee";
    public static int id = 0;
    Bundle params = new Bundle();

    public void tech(View view) {
        //NEWS_CAT_URL="category=technology&apiKey=c60dc7c66a474c03ba181227554788ee";
        id = 1;
        params.putString("Category", "Technology");
        mFirebaseAnalytics.logEvent("SelectedCategory_Technology", params);
        Intent i = new Intent(Content.this, NewsActivity.class);
        startActivity(i);
    }

    public void business(View view) {
        //NEWS_CAT_URL="category=business&apiKey=c60dc7c66a474c03ba181227554788ee";
        id = 2;
        params.putString("Category", "Business");
        mFirebaseAnalytics.logEvent("SelectedCategory_Business", params);
        Intent i = new Intent(Content.this, NewsActivity.class);
        startActivity(i);
    }

    public void entertainment(View view) {
        //NEWS_CAT_URL="category=entertainment&apiKey=c60dc7c66a474c03ba181227554788ee";
        id = 3;
        params.putString("Category", "Entertainment");
        mFirebaseAnalytics.logEvent("SelectedCategory_Entertainment", params);
        Intent i = new Intent(Content.this, NewsActivity.class);
        startActivity(i);
    }

    public void health(View view) {
        //NEWS_CAT_URL="category=health&apiKey=c60dc7c66a474c03ba181227554788ee";
        id = 4;
        params.putString("Category", "Health");
        mFirebaseAnalytics.logEvent("SelectedCategory_Health", params);
        Intent i = new Intent(Content.this, NewsActivity.class);
        startActivity(i);
    }

    public void science(View view) {
        //NEWS_CAT_URL="category=science&apiKey=c60dc7c66a474c03ba181227554788ee";
        id = 5;
        params.putString("Category", "Science");
        mFirebaseAnalytics.logEvent("SelectedCategory_Science", params);
        Intent i = new Intent(Content.this, NewsActivity.class);
        startActivity(i);
    }

    public void sport(View view) {
        //NEWS_CAT_URL="category=sports&apiKey=c60dc7c66a474c03ba181227554788ee";
        id = 6;
        params.putString("Category", "Sport");
        mFirebaseAnalytics.logEvent("SelectedCategory_Sport", params);
        Intent i = new Intent(Content.this, NewsActivity.class);
        startActivity(i);
    }
}

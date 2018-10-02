package io.github.capturemathan.pocketfeed;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Content extends AppCompatActivity{
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);
    }

    //String NEWS_CAT_URL; //="category=business&apiKey=c60dc7c66a474c03ba181227554788ee";
    public static int id=0;

    public void tech(View view) {
        //NEWS_CAT_URL="category=technology&apiKey=c60dc7c66a474c03ba181227554788ee";
        id=1;
        Intent i = new Intent(Content.this,NewsActivity.class);
        startActivity(i);
    }

    public void business(View view) {
        //NEWS_CAT_URL="category=business&apiKey=c60dc7c66a474c03ba181227554788ee";
        id=2;
        Intent i = new Intent(Content.this,NewsActivity.class);
        startActivity(i);
    }

    public void entertainment(View view) {
        //NEWS_CAT_URL="category=entertainment&apiKey=c60dc7c66a474c03ba181227554788ee";
        id=3;
        Intent i = new Intent(Content.this,NewsActivity.class);
        startActivity(i);
    }

    public void health(View view) {
        //NEWS_CAT_URL="category=health&apiKey=c60dc7c66a474c03ba181227554788ee";
        id=4;
        Intent i = new Intent(Content.this,NewsActivity.class);
        startActivity(i);
    }

    public void science(View view) {
        //NEWS_CAT_URL="category=science&apiKey=c60dc7c66a474c03ba181227554788ee";
        id=5;
        Intent i = new Intent(Content.this,NewsActivity.class);
        startActivity(i);
    }

    public void sport(View view) {
        //NEWS_CAT_URL="category=sports&apiKey=c60dc7c66a474c03ba181227554788ee";
        id=6;
        Intent i = new Intent(Content.this,NewsActivity.class);
        startActivity(i);
    }
}

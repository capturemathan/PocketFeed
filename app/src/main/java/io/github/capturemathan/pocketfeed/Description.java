package io.github.capturemathan.pocketfeed;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class Description extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);
        Intent i = getIntent();
        Bundle b = i.getExtras();

        String st = (String) b.get("Desc");
        TextView txt = (TextView) findViewById(R.id.desctext);
        txt.setText(st);

        final String imgUrl=(String)b.get("Pic");
        final ImageView imageView=(ImageView)findViewById(R.id.descimage);
        final Bitmap[] bmp = {null};
        try {
            Thread thread = new Thread(new Runnable(){
                @Override
                public void run() {
                    try {
                        //Your code goes here
                        InputStream in = new java.net.URL(imgUrl).openStream();
                        bmp[0] = BitmapFactory.decodeStream(in);
                        imageView.setImageBitmap(bmp[0]);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            thread.start();
            //URL imgurl = new URL(currentarticle.getImgUrl());
            //Bitmap bmp = BitmapFactory.decodeStream(imgurl.openConnection().getInputStream());
            //img.setImageBitmap(bmp);
        } catch (Exception e) {
            e.printStackTrace();
        }


        final String url=(String)b.get("Url");

        Button button=findViewById(R.id.articleurl);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivity(i);
                }
            }
        });
    }
}

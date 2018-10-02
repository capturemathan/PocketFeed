package io.github.capturemathan.pocketfeed;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {

            case R.id.about:
                Intent i = new Intent(MainActivity.this,About.class);
                startActivity(i);
                 return true;
            case R.id.bug:
                Intent it = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","capturesmk@gmail.com", null));
                it.putExtra(Intent.EXTRA_SUBJECT, "Regarding Bug in Pocket Feed App");
                it.putExtra(Intent.EXTRA_EMAIL, new String[] {"capturesmk@gmail.com"});
                if(it.resolveActivity(getPackageManager())!=null)
                    startActivity(it);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void proceed(View view) {
        Intent i = new Intent(MainActivity.this,Content.class);
        startActivity(i);
    }
}

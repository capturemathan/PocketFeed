package io.github.capturemathan.pocketfeed;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>>{

    public static final String LOG_TAG = NewsActivity.class.getName();

    //private static final String NEWS_REQUEST_BASE_URL = "https://newsapi.org/v2/top-headlines?country=in&";

    //private static final String NEWS_CATEGORY_URL = obj.NEWS_CAT_URL;

    private static String NEWS_FETCH_URL = "https://newsapi.org/v2/top-headlines?country=in&apiKey=c60dc7c66a474c03ba181227554788ee";

    private static final int NEWS_LOADER_ID = 1;

    private NewsAdapter mAdapter;

    private TextView mEmptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity);

        if(Content.id==1)
        {
            NEWS_FETCH_URL="https://newsapi.org/v2/top-headlines?country=in&category=technology&apiKey=c60dc7c66a474c03ba181227554788ee";
        }
        else if(Content.id==2)
        {
            NEWS_FETCH_URL="https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=c60dc7c66a474c03ba181227554788ee";
        }
        else if(Content.id==3)
        {
            NEWS_FETCH_URL="https://newsapi.org/v2/top-headlines?country=in&category=entertainment&apiKey=c60dc7c66a474c03ba181227554788ee";
        }
        else if(Content.id==4)
        {
            NEWS_FETCH_URL="https://newsapi.org/v2/top-headlines?country=in&category=health&apiKey=c60dc7c66a474c03ba181227554788ee";
        }
        else if(Content.id==5)
        {
            NEWS_FETCH_URL="https://newsapi.org/v2/top-headlines?country=in&category=science&apiKey=c60dc7c66a474c03ba181227554788ee";
        }
        else
        {
            NEWS_FETCH_URL="https://newsapi.org/v2/top-headlines?country=in&category=sports&apiKey=c60dc7c66a474c03ba181227554788ee";
        }

        final ListView newsListView = (ListView) findViewById(R.id.list);

        mAdapter = new NewsAdapter(this,new ArrayList<News>(),R.color.colorPrimaryDark);

        newsListView.setAdapter(mAdapter);

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        newsListView.setEmptyView(mEmptyStateTextView);

        // Get a reference to the ConnectivityManager to check state of network connectivity
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        // Get details on the currently active default data network
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        // If there is a network connection, fetch data
        if (networkInfo != null && networkInfo.isConnected()) {
            // Get a reference to the LoaderManager, in order to interact with loaders.
            LoaderManager loaderManager = getLoaderManager();
            // Initialize the loader. Pass in the int ID constant defined above and pass in null for
            // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
            // because this activity implements the LoaderCallbacks interface).
            loaderManager.initLoader(NEWS_LOADER_ID, null, this);
        } else {
            // Otherwise, display error
            // First, hide loading indicator so error message will be visible
            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);
            // Update empty state with no connection error message
            mEmptyStateTextView.setText(" No Internet Connection ");
        }
    }

    @Override
    public Loader<List<News>> onCreateLoader(int i, Bundle bundle) {

        Uri baseUri = Uri.parse(NEWS_FETCH_URL);
        return new NewsLoader(this,baseUri.toString());
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> news) {
        // Hide loading indicator because the data has been loaded
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        mEmptyStateTextView.setText(" No News found ");

        // Clear the adapter of previous earthquake data
        mAdapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (news != null && !news.isEmpty()) {
            mAdapter.addAll(news);
        }

    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {

        mAdapter.clear();
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
        } catch (Exception e) { e.printStackTrace();}
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
        } else if(dir!= null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }
}

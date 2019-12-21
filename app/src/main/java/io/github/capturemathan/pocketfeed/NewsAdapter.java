package io.github.capturemathan.pocketfeed;

import android.content.Context;
import android.content.Intent;
import androidx.core.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    private int mColorResourceId;
    private Context mContext;

    public NewsAdapter(Context context, List<News> newsfeed, int colorResourceId) {
        super(context, 0, newsfeed);
        mColorResourceId = colorResourceId;
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // check if there is an existing list item (called convertView) that we can use,
        // otherwise if convertView is null, then inflate a new list item layout .
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_card, parent, false);
        }

        final News currentarticle = getItem(position);
        final ImageView img = (ImageView) listItemView.findViewById(R.id.listimage);
        Picasso.get().load(currentarticle.getImgUrl()).placeholder(R.drawable.loading).into(img);

        TextView newstitle = (TextView) listItemView.findViewById(R.id.newstitle);
        newstitle.setText(currentarticle.getTitle());

        //View textContainer = listItemView.findViewById(R.id.text_container);

        //int color = ContextCompat.getColor(getContext(), mColorResourceId);
        //textContainer.setBackgroundColor(color);

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getContext(), Description.class);
                i.putExtra("Desc", currentarticle.getDesc());
                i.putExtra("Pic", currentarticle.getImgUrl());
                i.putExtra("Url", currentarticle.getUrl());
                mContext.startActivity(i);
            }
        });

        return listItemView;
    }

}

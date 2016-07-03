package in.lemonco.dilli;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Adapter class to create a custom Array Adapter
 */
public class FeedAdapter extends ArrayAdapter<Feed> {
    private static final String LOG_TAG = FeedAdapter.class.getSimpleName();

    public FeedAdapter(Activity context, ArrayList<Feed> feeds) {
        super(context, 0, feeds);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.feed_list_item_layout, parent, false);
        }
        Feed currentFeed = getItem(position);

        //Find the image in listview item and set it to the value of current feed
        ImageView feedImage = (ImageView) listItemView.findViewById(R.id.item_image);
        feedImage.setImageResource(currentFeed.getmImageResourceId());

        TextView feedText = (TextView) listItemView.findViewById(R.id.item_text);
        feedText.setText(currentFeed.getmTitle());

        return listItemView;


    }
}

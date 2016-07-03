package in.lemonco.dilli;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FeedDetailActivity extends AppCompatActivity {

    public static final String FEED_OBJECT = "FEED_OBJECT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_detail);

        Intent intent = getIntent();
        Feed feed = (Feed) intent.getParcelableExtra("FEED_OBJECT");

        ImageView imageView = (ImageView) findViewById(R.id.feed_image);
        imageView.setImageResource(feed.getmImageResourceId());

        TextView title = (TextView) findViewById(R.id.feed_title);
        title.setText(feed.getmTitle());

        TextView description = (TextView) findViewById(R.id.feed_description);
        description.setText(feed.getmDescription());

        TextView location = (TextView) findViewById(R.id.feed_location);
        location.setText(feed.getmLocation());

        String dateAndTime = feed.getmWhen();
        TextView when_detail = (TextView) findViewById(R.id.feed_when);
        TextView when = (TextView) findViewById(R.id.when);
        if (dateAndTime != null) {  //if date and duration are not mentioned , then we need to remove this textview.
            when_detail.setText(dateAndTime);
        } else {
            when_detail.setVisibility(View.GONE);
            when.setVisibility(View.GONE);
        }

        TextView price = (TextView) findViewById(R.id.feed_price);
        price.setText(feed.getmPrice());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_feed_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

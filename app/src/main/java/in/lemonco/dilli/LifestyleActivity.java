package in.lemonco.dilli;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class LifestyleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_list);

        final ArrayList<Feed> lifestyles = new ArrayList<Feed>();
        lifestyles.add(new Feed("Gurgaon’s First Kids-Only Salon, Barber Black Sheep, Now Open", "It’s Gurgaon’s first kids-only salon, with grooming, baby-sitting and party-planning services so their super moms can take a bit of a break.", "A-14/1, Fourth Floor, DLF Phase I", "Salon services start at INR 400; hourly fee for the play area is INR 350", R.drawable.lifestyle_kids_salon));
        lifestyles.add(new Feed("Rent And Ride With Online Motorcycle Rental Portal WheelStreets", "WheelStreets is an online bike rental aggregator that has been up and running in Delhi and Bangalore since 2014. They have recently opened in Gurgaon", "Check website", "Checkout Website", R.drawable.lifestyle_rent_bike));
        lifestyles.add(new Feed("Wedding Gifting Just Became More Fun with ForMyShaadi.com", "ForMyShaadi.com is an online wedding gift registry portal that lets soon-to-be-married couples curate their own wedding wish lists and share them with their friends and family.", "Check website", "Checkout Website", R.drawable.lifestyle_for_my_shaadi));

        ListView listView = (ListView) findViewById(R.id.feedList);
        FeedAdapter feedAdapter = new FeedAdapter(this, lifestyles);
        listView.setAdapter(feedAdapter);

        //Set ListView on Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //passes the "feed" object in intent
                Intent intent = new Intent(LifestyleActivity.this, FeedDetailActivity.class);
                intent.putExtra(FeedDetailActivity.FEED_OBJECT, lifestyles.get(position));
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lifestyle, menu);
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

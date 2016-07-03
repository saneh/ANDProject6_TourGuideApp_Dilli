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

public class FoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_list);

        final ArrayList<Feed> foods = new ArrayList<>();
        foods.add(new Feed("Come Chill At The Backyard Underground, Now Open In Gurgaon", "To add to Gurgaon’s ever-increasing list of where we’d like to unwind, The Backyard Underground has set up shop in Sector 29. Their Punjabi Bagh outlet, The Backyard, is the perfect place to chill with old friends and cold beer, so they’re hoping to recreate the same magic in G-town.Except there’s a slight twist. It’s all underground – 20 feet underground to be precise.", "Delhi", "INR 1,200 for two {approx.)", R.drawable.food_underground));
        foods.add(new Feed("Drop Into Remember Me Cafe For Sunshine & Near-Perfect French Fries", "Shahpur Jat’s newest addition, Remember Me Cafe is a confusing mix of Italian, continental and a smattering of Chinjabi. The blue and yellow space makes for the ideal setting to take a quick break after a long day of shopping.", "JP House, First Floor, 118 {next to Apartment 9}, Shahpur Ja", "INR 1,000 for two", R.drawable.food_remember_me));
        foods.add(new Feed("Matamaal Offers Homestyle Kashmiri Pandit Food", "Literally meaning Nani’s home, Matamaal is a cosy and quaint Kashmiri diner which serves homestyle Pandit cuisine from the Kashmir valley.", "Delhi", "INR 1,000 for two", R.drawable.food_matamaal));

        ListView listView = (ListView) findViewById(R.id.feedList);
        FeedAdapter feedAdapter = new FeedAdapter(this, foods);
        listView.setAdapter(feedAdapter);

        //Set ListView on Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //passes the "feed" object in intent
                Intent intent = new Intent(FoodActivity.this, FeedDetailActivity.class);
                intent.putExtra(FeedDetailActivity.FEED_OBJECT, foods.get(position));
                startActivity(intent);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_food, menu);
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

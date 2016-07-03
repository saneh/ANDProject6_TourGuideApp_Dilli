package in.lemonco.dilli;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_list);

        final ArrayList<Feed> events = new ArrayList<Feed>();
        events.add(new Feed("A Kite’s Eye View And Patangbazi At Haveli Dharampura Every Sunday", "Haveli Dharampura, the first restored haveli in Chandni Chowk, is going to make July and August most memorable for you with a High Tea and a Patangbazi event every Sunday. So, if you want to rekindle your love for kite-flying, this would be a great place to start.", "Haveli Dharampura, Near Jama Masjid Police Station", "INR 1,000 plus taxes", R.drawable.events_kites, "4pm – 6.30pm"));
        events.add(new Feed("Go Green With The Earth Collective—An Organic Lifestyle Bazaar", "A farmers’ market, The Earth Collective is about organic produce, environment sustainability and making conscientious lifestyle choices. Everything up for grabs at this lifestyle bazaar has been curated by Meenu Nageshwaran, a plant-based chef and vegan pro.", "Club Patio, Block-E, South City – I", "Entry is free", R.drawable.events_organic_bazaar, "5pm – 8pm {every Friday}"));
        events.add(new Feed("Outhouse Is Having A Mother’s Day Sale", "Outhouse, everyone’s favourite jewellery store in Meherchand market, is holding a sale between Friday and Sunday, to celebrate Mother’s Day—everything is 20 per cent oTheir jewellery has been worn by names like Sonam Kapoor, Priyanka Chopra, Deepika Padukone, Kangana Ranaut, Nargis Fakri, and Sienna Miller, Ashley Louis James, and Tyra Banks, so you know you’re in good hands.!", "144 Lodhi Road, Meherchand Market", "Entry is free", R.drawable.events_outhouse_sale, "11am – 7.30pm"));
        events.add(new Feed("Bizarre Bazaar: A Flea Market for Your Inner Surprise-lover", "The Bizarre Bazaar is a flea market at SDA, and happens every Saturday. A shoppertunity that you do not want to miss, especially at a place known for its food joints and cafes. It’s a market that changes its stalls every week, and hence one is in for a surprise every time one visits this Bizarre Bazaar.", "Safdarjung Development Area market {opposite IIT Delhi main Gate}", "Entry is free", R.drawable.events_bizarre_bazaar, "12pm – 11pm"));
        events.add(new Feed("Explore the North with the Great Indian Riding Festival", "Launched by travel start-up Roots Vida, The Great Indian Riding Festival {GIRF} is a six-month long celebration of motorcycles and riding. The festival will consist of 25 riding tours, starting in New Delhi and moving on to Bhutan, Spiti, Ladhakh and the North East. You are free to choose the group, date and time of your journey.", "Starting from New Delhi", "Starting at INR 29,599.", R.drawable.events_riding_festival, "Apr 1 – Sept 30, 2016"));

        //Set Arrayadapter
        FeedAdapter feedAdapter = new FeedAdapter(this, events);
        ListView listView = (ListView) findViewById(R.id.feedList);
        listView.setAdapter(feedAdapter);

        //Set ListView on Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //passes the "feed" object in intent
                Intent intent = new Intent(EventsActivity.this, FeedDetailActivity.class);
                intent.putExtra(FeedDetailActivity.FEED_OBJECT, events.get(position));
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_events, menu);
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

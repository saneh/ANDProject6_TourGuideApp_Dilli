package in.lemonco.dilli;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_list);

        final ArrayList<Feed> events = new ArrayList<Feed>();


        events.add(new Feed(getString(R.string.events_kites_title),getString(R.string.events_kites_description),getString(R.string.events_kites_where),getString(R.string.events_kites_price),R.drawable.events_kites,getString(R.string.events_kites_when)));
        events.add(new Feed(getString(R.string.events_organic_bazaar_title),getString(R.string.events_organic_bazaar_description),getString(R.string.events_organic_bazaar_where),getString(R.string.events_organic_bazaar_price),R.drawable.events_organic_bazaar,getString(R.string.events_organic_bazaar_when)));
        events.add(new Feed(getString(R.string.events_outhouse_sale_title),getString(R.string.events_outhouse_sale_description),getString(R.string.events_outhouse_sale_where),getString(R.string.events_outhouse_sale_price),R.drawable.events_outhouse_sale,getString(R.string.events_outhouse_sale_when)));
        events.add(new Feed(getString(R.string.events_bizarre_bazaar_title),getString(R.string.events_bizarre_bazaar_description),getString(R.string.events_bizarre_bazaar_where),getString(R.string.events_bizarre_bazaar_price),R.drawable.events_bizarre_bazaar,getString(R.string.events_bizarre_bazaar_when)));
        events.add(new Feed(getString(R.string.events_riding_festival_title),getString(R.string.events_riding_festival_description),getString(R.string.events_riding_festival_where),getString(R.string.events_riding_festival_price),R.drawable.events_riding_festival,getString(R.string.events_riding_festival_when)));

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

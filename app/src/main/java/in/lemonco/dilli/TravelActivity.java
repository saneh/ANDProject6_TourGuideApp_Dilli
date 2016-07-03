package in.lemonco.dilli;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class TravelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_list);

        final ArrayList<Feed> travels = new ArrayList<Feed>();
        travels.add(new Feed("Settle Into The Lap Of Luxury At SUJÁN Rajmahal Palace", "In the heart of Jaipur lies the SUJÁN Rajmahal Palace—once home to kings and queens, and now open to those with discerning taste, looking for a quick weekend away.", "Sardar Patel Marg, C Scheme, Jaipur, Rajasthan", "Starting Price: INR 19000", R.drawable.travel_sujan_palace));
        travels.add(new Feed("Seetalvan Orchard, For The Best Hotel View In India", "Seetalvan Orchard is set on a working orchard, a few hours’ drive north of Shimla – the main town in the state of Himachal Pradesh – in the village of Kotgarh, and some 15 km from the main highway towards Tibet. Narkanda is the nearest town of any notable size. Kotgarh is right in the heart of apple country, so expect orchards, blossoming trees, fresh mountain air and of course those majestic mountain views at every turn.", " Kotgarh Narkanda, Shimla, Himachal Pradesh", "rooms start at INR 5,500 per night", R.drawable.travel_seetalvan));
        travels.add(new Feed("Live In The Lap Of Luxury At Lakshman Sagar", "Said to be one of the hidden gems of Rajasthan, Lakshman Sagar lets you experience the rustic and slow life, while also offering luxuries like a private splash pool.", "Raipur Road {near Haripur Railway Station} Dist. Pali, Raipur, Rajasthan", "Starting at INR 13,500 {for a room}", R.drawable.travel_laxman_sagar));
        ListView listView = (ListView) findViewById(R.id.feedList);
        FeedAdapter feedAdapter = new FeedAdapter(this, travels);
        listView.setAdapter(feedAdapter);

        //set Listview onItemClickListener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //passes the "feed" object in intent
                Intent intent = new Intent(TravelActivity.this, FeedDetailActivity.class);
                intent.putExtra("FEED_OBJECT", travels.get(position));
                startActivity(intent);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_travel, menu);
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

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

public class LifestyleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_list);

        final ArrayList<Feed> lifestyles = new ArrayList<Feed>();
        lifestyles.add(new Feed(getString(R.string.lifestyle_kids_salon_title),getString(R.string.lifestyle_kids_salon_description),getString(R.string.lifestyle_kids_salon_where),getString(R.string.lifestyle_kids_salon_price),R.drawable.lifestyle_kids_salon));
        lifestyles.add(new Feed(getString(R.string.lifestyle_rent_bike_title),getString(R.string.lifestyle_rent_bike_description),getString(R.string.lifestyle_rent_bike_where),getString(R.string.lifestyle_rent_bike_price),R.drawable.lifestyle_rent_bike));
        lifestyles.add(new Feed(getString(R.string.lifestyle_for_my_shaadi_title),getString(R.string.lifestyle_for_my_shaadi_description),getString(R.string.lifestyle_for_my_shaadi_where),getString(R.string.lifestyle_for_my_shaadi_price),R.drawable.lifestyle_for_my_shaadi));

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

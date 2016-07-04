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

public class TravelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_list);

        final ArrayList<Feed> travels = new ArrayList<Feed>();
        travels.add(new Feed(getString(R.string.travel_sujan_palace_title),getString(R.string.travel_sujan_palace_description),getString(R.string.travel_sujan_palace_where),getString(R.string.travel_sujan_palace_price),R.drawable.travel_sujan_palace));
        travels.add(new Feed(getString(R.string.travel_seetalvan_title),getString(R.string.travel_seetalvan_description),getString(R.string.travel_seetalvan_where),getString(R.string.travel_seetalvan_price),R.drawable.travel_seetalvan));
        travels.add(new Feed(getString(R.string.travel_laxman_sagar_title),getString(R.string.travel_laxman_sagar_description),getString(R.string.travel_laxman_sagar_where),getString(R.string.travel_laxman_sagar_price),R.drawable.travel_laxman_sagar));

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

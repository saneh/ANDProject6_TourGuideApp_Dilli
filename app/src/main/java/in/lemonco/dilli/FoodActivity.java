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

public class FoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_list);

        final ArrayList<Feed> foods = new ArrayList<>();
        foods.add(new Feed(getString(R.string.food_underground_title),getString(R.string.food_underground_description),getString(R.string.food_underground_where),getString(R.string.food_underground_price),R.drawable.food_underground));
        foods.add(new Feed(getString(R.string.food_remember_me_title),getString(R.string.food_remember_me_description),getString(R.string.food_remember_me_where),getString(R.string.food_remember_me_price),R.drawable.food_remember_me));
        foods.add(new Feed(getString(R.string.food_matamaal_title),getString(R.string.food_matamaal_description),getString(R.string.food_matamaal_where),getString(R.string.food_matamaal_price),R.drawable.food_matamaal));

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

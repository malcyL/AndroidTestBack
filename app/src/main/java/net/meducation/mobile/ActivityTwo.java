package net.meducation.mobile;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends ActionBarActivity implements View.OnClickListener {

    int mInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_two);

        if (savedInstanceState == null) {

            Intent intent = getIntent();
            if (null != intent) {
                Bundle bundle = getIntent().getExtras();
                if (null != bundle) {
                    mInt = bundle.getInt("TEST_ID", 0);
                }
            }

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment(mInt, this))
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_two, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ActivityThree.class);
        Bundle bundle = new Bundle();
        bundle.putInt("SECOND_TEST_ID", 54);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        int i;
        View.OnClickListener onClickListener;

        public PlaceholderFragment(int i, View.OnClickListener onClickListener) {
            this.i = i;
            this.onClickListener = onClickListener;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_activity_two, container, false);

            TextView textView = (TextView) rootView.findViewById(android.R.id.text1);
            textView.setText(""+i);

            final Button button = (Button) rootView.findViewById(R.id.button);
            button.setOnClickListener(onClickListener);

            return rootView;
        }
    }

}

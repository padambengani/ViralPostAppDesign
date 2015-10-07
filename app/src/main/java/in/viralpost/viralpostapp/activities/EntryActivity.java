package in.viralpost.viralpostapp.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import in.viralpost.viralpostapp.R;
import in.viralpost.viralpostapp.fragments.EntryFragment;
import in.viralpost.viralpostapp.fragments.LoginFragment;
import in.viralpost.viralpostapp.fragments.RegisterFragment;

public class EntryActivity extends AppCompatActivity implements EntryFragment.OnButtonClickListener {

    private static final String TAG = "EntryActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        if (findViewById(R.id.fragment_container_entry) != null) {

            if (savedInstanceState != null) return;

            showEntryFragment();
        }
    }

    private void showEntryFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container_entry, new EntryFragment());
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_entry, menu);
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

    @Override
    public void onLoginClicked() {
        Log.d(TAG, "Login button clicked");
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_entry, new LoginFragment()).addToBackStack(null).commit();
    }

    @Override
    public void onSignupClicked() {
        Log.d(TAG, "Sign up button clicked");
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_entry, new RegisterFragment()).addToBackStack(null).commit();
    }
}

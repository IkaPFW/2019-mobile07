package polinema.ac.id.androiduistarter.fragments.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import polinema.ac.id.androiduistarter.R;
import polinema.ac.id.androiduistarter.fragments.Fragments.DiscountFragment;
import polinema.ac.id.androiduistarter.fragments.Fragments.FoodFragment;
import polinema.ac.id.androiduistarter.fragments.Fragments.MovieFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new FoodFragment());
        BottomNavigationView bnv = findViewById(R.id.navigation);
        bnv.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if(fragment != null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameContainer, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }

        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case R.id.action_food:
                fragment = new FoodFragment();
                break;
            case R.id.action_movie:
                fragment = new MovieFragment();
                break;
            case R.id.action_discount:
                fragment = new DiscountFragment();
                break;
        }
        return loadFragment(fragment);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

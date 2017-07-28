package com.example.fragmentexample2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.fragmentexample2.ItemListFragment;
import com.example.fragmentexample2.ImageViewerFragment;

import org.androidtown.ui.fragment.R;

public class MainActivity extends AppCompatActivity implements ItemListFragment.OnListItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListItemClick(int index) {
        Fragment fragment = getSupportFragmentManager().
                findFragmentById( R.id.image_viewer_fragment);
        ((ImageViewerFragment) fragment ).updateView( index );
    }
}

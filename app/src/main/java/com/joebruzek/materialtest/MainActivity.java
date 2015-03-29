package com.joebruzek.materialtest;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity implements NavDrawerCallbacks {

    //Titles of the items in the Nav Drawer
    String TITLES[] = {"Home","Events","Mail","Shop","Travel"};
    //Icons for the items in the Nav Drawer
    int ICONS[] = {R.drawable.ic_action,
            R.drawable.ic_action,
            R.drawable.ic_action,
            R.drawable.ic_action,
            R.drawable.ic_action};
    //Profile information
    String NAME = "Joe Bruzek";
    String EMAIL = "jbruzek@vt.edu";
    int PROFILE = R.drawable.joe;

    private Toolbar toolbar;
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    DrawerLayout Drawer;
    ActionBarDrawerToggle mDrawerToggle;
    BlankFragment frag;

    /**
     * Initialize the toolbar and the nav drawer.
     * add the home fragment to the frame
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new NavAdapter(TITLES, ICONS, NAME, EMAIL, PROFILE, this, this);
        mRecyclerView.setAdapter(mAdapter);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);
        Drawer.setStatusBarBackgroundColor(getResources().getColor(R.color.primaryDark));
        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolbar,R.string.open_drawer,R.string.close_drawer){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //drawer is open
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                //drawer is closed
            }



        }; // Drawer Toggle Object Made
        Drawer.setDrawerListener(mDrawerToggle); // Drawer Listener set to the Drawer toggle
        mDrawerToggle.syncState();

        if (getFragmentManager().findFragmentById(R.layout.material_fragment) == null) {
            frag = new BlankFragment();
        }
        Bundle b = new Bundle();
        b.putString("name", "Home");
        frag.setArguments(b);
        getFragmentManager().beginTransaction().add(R.id.container, frag).commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Called by the Nav Drawer when an item in the nav drawer has been selected.
     * Swap the fragment in the frame, close the drawer, etc..
     * @param position
     */
    @Override
    public void itemSelected(int position) {
        Drawer.closeDrawers();
        Bundle b;
        switch(position) {
            case 1:
                toolbar.setTitle("Home");
                frag = new BlankFragment();
                b = new Bundle();
                b.putString("name", "Home");
                frag.setArguments(b);
                getFragmentManager().beginTransaction().replace(R.id.container, frag).commit();
                break;
            case 2:
                toolbar.setTitle("Events");
                frag = new BlankFragment();
                b = new Bundle();
                b.putString("name", "Events");
                frag.setArguments(b);
                getFragmentManager().beginTransaction().replace(R.id.container, frag).commit();
                break;
            case 3:
                toolbar.setTitle("Mail");
                frag = new BlankFragment();
                b = new Bundle();
                b.putString("name", "Mail");
                frag.setArguments(b);
                getFragmentManager().beginTransaction().replace(R.id.container, frag).commit();
                break;
            case 4:
                toolbar.setTitle("Shop");
                frag = new BlankFragment();
                b = new Bundle();
                b.putString("name", "Shop");
                frag.setArguments(b);
                getFragmentManager().beginTransaction().replace(R.id.container, frag).commit();
                break;
            case 5:
                toolbar.setTitle("Travel");
                frag = new BlankFragment();
                b = new Bundle();
                b.putString("name", "Travel");
                frag.setArguments(b);
                getFragmentManager().beginTransaction().replace(R.id.container, frag).commit();
                break;
        }
    }
}

package com.joebruzek.materialtest;

import android.app.FragmentManager;
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
import android.widget.Toast;

import com.software.shell.fab.ActionButton;


public class MainActivity extends ActionBarActivity implements NavDrawerCallbacks {

    private Toolbar toolbar;
    String TITLES[] = {"Home","Events","Mail","Shop","Travel"};
    int ICONS[] = {R.drawable.ic_action,
            R.drawable.ic_action,
            R.drawable.ic_action,
            R.drawable.ic_action,
            R.drawable.ic_action};
    String NAME = "Akash Bangad";
    String EMAIL = "akash.bangad@android4devs.com";
    int PROFILE = R.drawable.face;

    RecyclerView mRecyclerView;                           // Declaring RecyclerView
    RecyclerView.Adapter mAdapter;                        // Declaring Adapter For Recycler View
    RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager
    DrawerLayout Drawer;                                  // Declaring DrawerLayout
    ActionBarDrawerToggle mDrawerToggle;
    BlankFragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView); // Assigning the RecyclerView Object to the xml View
        mRecyclerView.setHasFixedSize(true);                            // Letting the system know that the list objects are of fixed size

        mAdapter = new NavAdapter(TITLES,ICONS,NAME,EMAIL,PROFILE,this, this);       // Creating the Adapter of MyAdapter class(which we are going to see in a bit)
        // And passing the titles,icons,header view name, header view email,
        // and header view profile picture

        mRecyclerView.setAdapter(mAdapter);                              // Setting the adapter to RecyclerView

        mLayoutManager = new LinearLayoutManager(this);                 // Creating a layout Manager

        mRecyclerView.setLayoutManager(mLayoutManager);                 // Setting the layout Manager


        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);        // Drawer object Assigned to the view
        Drawer.setStatusBarBackgroundColor(getResources().getColor(R.color.primaryDark));
        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolbar,R.string.open_drawer,R.string.close_drawer){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
                // open I am not going to put anything here)
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
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

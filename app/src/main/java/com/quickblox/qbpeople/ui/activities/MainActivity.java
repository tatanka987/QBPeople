package com.quickblox.qbpeople.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.quickblox.qbpeople.R;
import com.quickblox.qbpeople.htmlparcer.HtmlParser;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private AccountHeader accountHeader;
    private Drawer drawer;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolBar();
        createAccountHeader();
        createDrawer(toolbar, accountHeader);

        tv = (TextView) findViewById(R.id.textView);
        tv.setText(new HtmlParser().getStingFomWeb());
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public void onBackPressed() {
        if (drawer != null && drawer.isDrawerOpen()){
            drawer.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    private void initToolBar(){
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        if (toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    private void createAccountHeader(){
        accountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.green_blue_wallpaper)
                .withHeaderBackgroundScaleType(ImageView.ScaleType.CENTER_CROP)
                .withHeightDp(150)
                .build();
    }

    private void createDrawer(Toolbar toolbar, AccountHeader accountHeader) {

        drawer = new DrawerBuilder(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggleAnimated(true)
                .withAnimateDrawerItems(true)
                .withDisplayBelowToolbar(true)
//                .withTranslucentStatusBar(false)
//                .withTranslucentActionBarCompatibility(true)
                .withAccountHeader(accountHeader)
                .addDrawerItems(
                new PrimaryDrawerItem()
                        .withName(R.string.update)
                        .withIcon(R.drawable.ic_sync_black_18dp)
                        .withIdentifier(1),
                new DividerDrawerItem(),
                new PrimaryDrawerItem()
                        .withName(R.string.go_to_website)
                        .withIcon(R.drawable.ic_web_black_18dp)
                        .withIdentifier(2),
                new DividerDrawerItem(),
                new PrimaryDrawerItem()
                        .withName(R.string.in_social_networks)
                        .withIdentifier(3)
                        .withCheckable(false),
                new SecondaryDrawerItem()
                        .withName(R.string.social_facebook)
                        .withIcon(R.drawable.ic_facebook_box_grey600_18dp),
                new SecondaryDrawerItem()
                        .withName(R.string.social_vk)
                        .withIcon(R.drawable.ic_vk_grey600_18dp),
                new SecondaryDrawerItem()
                        .withName(R.string.social_twitter)
                        .withIcon(R.drawable.ic_twitter_grey600_18dp),
                new SecondaryDrawerItem()
                        .withName(R.string.social_youtube)
                        .withIcon(R.drawable.ic_youtube_play_grey600_18dp),
                new DividerDrawerItem(),
                new PrimaryDrawerItem()
                        .withName(R.string.exit)
                        .withIcon(R.drawable.ic_exit_to_app_black_18dp))
                .build();
    }
}

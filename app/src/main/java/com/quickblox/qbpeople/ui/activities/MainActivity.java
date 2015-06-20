package com.quickblox.qbpeople.ui.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.quickblox.qbpeople.R;
import com.quickblox.qbpeople.htmlparcer.HtmlParser;
import com.quickblox.qbpeople.utils.Consts;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private AccountHeader accountHeader;
    private Drawer drawer;
    private TextView tv;
    private static long back_pressed;

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

        if (drawer != null && drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        } else {
            if (back_pressed + 2000 > System.currentTimeMillis()) {
                super.onBackPressed();
            } else {
                Toast.makeText(getBaseContext(), R.string.press_once_again_to_exit,
                        Toast.LENGTH_SHORT).show();
                back_pressed = System.currentTimeMillis();
            }
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
                .withAccountHeader(accountHeader)
                .addDrawerItems(initialiseDrawerItems())
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {
                        switch (iDrawerItem.getIdentifier()) {
                            case Consts.UPDATE_ITEM_IDENTIFIER:
//                                Toast.makeText(MainActivity.this, "Pressed item with identifier " + iDrawerItem.getIdentifier(), Toast.LENGTH_LONG).show();
                                break;
                            case Consts.CORPORATE_SITE_ITEM_IDENTIFIER:
                                goToWeb(iDrawerItem.getIdentifier());
//                                Toast.makeText(MainActivity.this, "Pressed item with identifier " + iDrawerItem.getIdentifier(), Toast.LENGTH_LONG).show();
                                break;
                            case Consts.FACEBOOK_ITEM_IDENTIFIER:
                                goToWeb(iDrawerItem.getIdentifier());
//                                Toast.makeText(MainActivity.this, "Pressed item with identifier " + iDrawerItem.getIdentifier(), Toast.LENGTH_LONG).show();
                                break;
                            case Consts.VK_ITEM_IDENTIFIER:
                                goToWeb(iDrawerItem.getIdentifier());
//                                Toast.makeText(MainActivity.this, "Pressed item with identifier " + iDrawerItem.getIdentifier(), Toast.LENGTH_LONG).show();
                                break;
                            case Consts.TWITTER_ITEM_IDENTIFIER:
                                goToWeb(iDrawerItem.getIdentifier());
//                                Toast.makeText(MainActivity.this, "Pressed item with identifier " + iDrawerItem.getIdentifier(), Toast.LENGTH_LONG).show();
                                break;
                            case Consts.YOUTUBE_ITEM_IDENTIFIER:
                                goToWeb(iDrawerItem.getIdentifier());
//                                Toast.makeText(MainActivity.this, "Pressed item with identifier " + iDrawerItem.getIdentifier(), Toast.LENGTH_LONG).show();
                                break;
                            case Consts.EXIT_ITEM_IDENTIFIER:
                                openQuitDialog();
//                                Toast.makeText(MainActivity.this, "Pressed item with identifier " + iDrawerItem.getIdentifier(), Toast.LENGTH_LONG).show();
                                break;
                            default:
                                break;
                        }
                        return false;
                    }
                })
                .build();
    }

    private IDrawerItem [] initialiseDrawerItems(){
        return new IDrawerItem [] {
                new PrimaryDrawerItem()
                        .withName(R.string.update)
                        .withIcon(R.drawable.ic_sync_black_24dp)
                        .withIdentifier(Consts.UPDATE_ITEM_IDENTIFIER),
                new DividerDrawerItem(),
                new PrimaryDrawerItem()
                        .withName(R.string.go_to_website)
                        .withIcon(R.drawable.ic_web_black_24dp)
                        .withIdentifier(Consts.CORPORATE_SITE_ITEM_IDENTIFIER),
                new DividerDrawerItem(),
                new PrimaryDrawerItem()
                        .withName(R.string.in_social_networks)
                        .withCheckable(true)
                        .withDisabledTextColor(R.color.md_black_1000),
                new SecondaryDrawerItem()
                        .withIdentifier(Consts.FACEBOOK_ITEM_IDENTIFIER)
                        .withName(R.string.social_facebook)
                        .withIcon(R.drawable.ic_facebook_box_grey600_24dp),
                new SecondaryDrawerItem()
                        .withIdentifier(Consts.VK_ITEM_IDENTIFIER)
                        .withName(R.string.social_vk)
                        .withIcon(R.drawable.ic_vk_grey600_24dp),
                new SecondaryDrawerItem()
                        .withIdentifier(Consts.TWITTER_ITEM_IDENTIFIER)
                        .withName(R.string.social_twitter)
                        .withIcon(R.drawable.ic_twitter_grey600_24dp),
                new SecondaryDrawerItem()
                        .withIdentifier(Consts.YOUTUBE_ITEM_IDENTIFIER)
                        .withName(R.string.social_youtube)
                        .withIcon(R.drawable.ic_youtube_play_grey600_24dp),
                new DividerDrawerItem(),
                new PrimaryDrawerItem()
                        .withIdentifier(Consts.EXIT_ITEM_IDENTIFIER)
                        .withName(R.string.exit)
                        .withIcon(R.drawable.ic_exit_to_app_black_24dp)};
    }

    private void goToWeb(int itemIdentifier){
        String uri = "";

        switch (itemIdentifier){
            case Consts.CORPORATE_SITE_ITEM_IDENTIFIER:
                uri = Consts.CORPORATE_WEB_SITE;
                break;
            case Consts.FACEBOOK_ITEM_IDENTIFIER:
                uri = Consts.FACEBOOK_LINK;
                break;
            case Consts.VK_ITEM_IDENTIFIER:
                uri = Consts.VK_LINK;
                break;
            case Consts.TWITTER_ITEM_IDENTIFIER:
                uri = Consts.TWITTER_LINK;
                break;
            case Consts.YOUTUBE_ITEM_IDENTIFIER:
                uri = Consts.YOUTUBE_LINK;
                break;
            default:
                break;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }

    private void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(this);
        quitDialog.setTitle(R.string.dialog_title);

        quitDialog.setPositiveButton(R.string.positive_response, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        quitDialog.setNegativeButton(R.string.negative_response, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        quitDialog.show();
    }

}

package android.test.web3j;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.test.web3j.service.MyIntentService;
import android.test.web3j.service.ServiceUnicornEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.http.HttpService;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Button btnCreate, btnServiceStart, btnWeb;
    TextView txt;
    Context context;

    public final static String BROADCAST_ACTION = "UnicornEventer";
    BroadcastReceiver br;
    public final static String TYPEMSG = "type";
    public final static int START = 1;
    public final static int FINISH = 1;
    Intent intent;
    DrawerLayout drawer;
    MarketFragment marketFragment = new MarketFragment();
    Toolbar toolbar;
    NavigationView navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
//        navigation = (NavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        btnCreate = (Button) findViewById(R.id.btnCreateAcc);
//        btnWeb = (Button) findViewById(R.id.btnWeb);
//        btnServiceStart = (Button) findViewById(R.id.btnServiceStart);
//        txt = (TextView) findViewById(R.id.txt);
//        btnCreate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                new GenerateNewWallet().execute();
//            }
//        });
//        btnWeb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, WebActivity.class);
//                startActivity(intent);
//            }
//        });
////        intent = new Intent(this, ServiceUnicornEvent.class);
////        // стартуем сервис
////        startService(intent);
//
//        btnServiceStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                startService(new Intent(context, ServiceUnicornEvent.class));
//                // создаем BroadcastReceiver
////                createBCReciver();
//            }
//        });
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        initToolbar();
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(listenerDrawer);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.frame, marketFragment)
//                            .addToBackStack(null)
                .commit();

    }

    private void initToolbar() {
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
            toolbar.setTitle(R.string.title_unicorns);
            toolbar.inflateMenu(R.menu.unicorns_menu);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {

            case R.id.nav_setting:

                break;
            case R.id.nav_buy_gen0:

                break;
//            case R.id.nav_buy_candy:
////                showLoadingIndicator(getString(R.string.dlg_buying_unicorn));
//                new ConfirmBuy(2).execute();
//                break;
            case R.id.nav_get_candy:

//                intent = new Intent(MainActivity.this, SendActivity.class);
//                intent.putExtra("address", Constants.addressCandySale);
//                startActivityForResult(intent, GET_CANDY_TOKEN);
                break;
            case R.id.nav_transactions:

                break;
            case R.id.nav_send:

                break;
            case R.id.nav_recive:

                break;
            default:
                break;
        }
        drawer.closeDrawers();
//        drawer.closeDrawer(Gravity.START, false);
        return false;
    }
}

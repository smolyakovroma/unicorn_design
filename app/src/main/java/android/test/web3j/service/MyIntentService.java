package android.test.web3j.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.http.HttpService;

public class MyIntentService extends IntentService {
    Web3j web3j;

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        web3j = Web3jFactory.build(new HttpService("https://rinkeby.infura.io/oShbYdHLGQhi0rn1audL"));
        System.out.println("onCreate");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        System.out.println("Handler!");
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
                while (true) {
                    System.out.println("onHandle " + Thread.currentThread().getName());
                }
//            }
//        }).run();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("onStartCommand");

        onTaskRemoved(intent);
        onHandleIntent(intent);
        return START_NOT_STICKY;
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        System.out.println("TASK REMOVED");
        Intent intent = new Intent(getApplicationContext(), this.getClass());
        intent.setPackage(getPackageName());
        startService(intent);
        super.onTaskRemoved(rootIntent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
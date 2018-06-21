package android.test.web3j.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.test.web3j.MainActivity;
import android.test.web3j.R;
import android.widget.Toast;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.http.HttpService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import rx.Emitter;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Cancellable;

public class ServiceUnicornEvent extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    ExecutorService pool;
    Web3j web3j;

    public void onCreate() {
        super.onCreate();
        web3j = Web3jFactory.build(new HttpService("https://rinkeby.infura.io/oShbYdHLGQhi0rn1audL"));
        pool = Executors.newFixedThreadPool(1);
        pool.execute(runner);
//        jober = new Thread();
//        jober.start();
//        while (!jober.isAlive());
        System.out.println("onCreate");
    }

    Runnable runner = new Runnable() {
        @Override
        public void run() {
            Observable<EthBlock> observableEthBlock = web3j.catchUpToLatestAndSubscribeToNewBlocksObservable(
                    DefaultBlockParameterName.EARLIEST, true);

            observableEthBlock.subscribe(new Action1<EthBlock>() {
                @Override
                public void call(EthBlock ethBlock) {
                    System.out.println(ethBlock.getBlock().getHash());
                    System.out.println(Thread.currentThread().getName());
                }
            });
//                while (true) {
//                    System.out.println(Thread.currentThread().getName());
//                }
//                while (true){
//                    System.out.println("OK");
//                    try {
//                        TimeUnit.SECONDS.sleep(3);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }

//                observableEthBlock.subscribe({ ethBlock ->
//                        ethBlock.block.transactions.forEach { t ->
//                        web3j.ethGetTransactionReceipt(t.hash).send().result
//                        val logs = receipt.logs
//                        processLogs(logs)
//                }
//                })
        }
    };

    Thread jober;

    public int onStartCommand(Intent intent, int flags, int startId) {
//        System.out.println("onStartCommand");
//            if(!jober.isAlive()){
//                System.out.println("BAD");
//            }
//        new Task().execute();
        onTaskRemoved(intent);
//        Toast.makeText(getApplicationContext(), "this is service", Toast.LENGTH_LONG).show();
//        someTask();


        return START_NOT_STICKY;
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
//        System.out.println("TASK REMOVED");
        Intent intent = new Intent(getApplicationContext(), this.getClass());
        intent.setPackage(getPackageName());
        startService(intent);
        super.onTaskRemoved(rootIntent);
    }

    public void onDestroy() {
        super.onDestroy();
//        System.out.println("onDestroy");
    }

    //    void someTask() {
//        try {
//            TimeUnit.SECONDS.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_round, options);
//
//        NotificationCompat.Builder builder =
//                new NotificationCompat.Builder(this)
//                        .setSmallIcon(R.mipmap.ic_launcher)
//                        .setContentTitle("Title")
//                        .setContentText("Notification text")
//                        .setLargeIcon(bitmap);
//        Notification notification = builder.build();
//
//        NotificationManager notificationManager =
//                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        notificationManager.notify(1, notification);
//
//        System.out.println("START");
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("FINISH");
//
//    }
    class Task extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            Observable<EthBlock> observableEthBlock = web3j.catchUpToLatestAndSubscribeToNewBlocksObservable(
                    DefaultBlockParameterName.EARLIEST, true);

            observableEthBlock.subscribe(new Action1<EthBlock>() {
                @Override
                public void call(EthBlock ethBlock) {
                    System.out.println(ethBlock.getBlock().getHash());
                    System.out.println(ethBlock.getBlock().getAuthor());
                }
            });
            return null;
        }
    }
}

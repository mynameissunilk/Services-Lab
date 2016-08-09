package sunil.musiclab;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Switch;


public class MusicService extends Service {

    private MediaPlayer mPlayer;
    private HandlerThread thread;
    private Handler handler;
    private Looper looper;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



    @Override
    public void onCreate() {
        super.onCreate();

        // three methods: start(), stop(), pause(), who would have known...
        mPlayer = MediaPlayer.create(getApplicationContext(),R.raw.licensetokill);
        mPlayer.start();
/*
        thread = new HandlerThread("handlerthread");
        thread.start();
        looper = thread.getLooper();

        handler = new Handler(looper){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                String playfunc = String.valueOf(msg.obj);
                switch(playfunc){
                    case "PLAY":
                        mPlayer.start();
                        break;
                    case "PAUSE":
                        mPlayer.pause();
                        break;
                    case "STOP":
                        mPlayer.stop();
                        break;
                    default:
                        mPlayer.pause();
                        break;
                }
            }
        };
        */
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //return super.onStartCommand(intent, flags, startId);
        // switch statement goes here
        Message msg = handler.obtainMessage();
        msg.obj = intent.getStringExtra("PLAYBACK");

        handler.sendMessage(msg);


        return START_STICKY;
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}


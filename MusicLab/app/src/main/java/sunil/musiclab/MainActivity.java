package sunil.musiclab;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // hotify

    Button bplay, bpause, bstop;
    public static final String PLAY_KEY="PLAYBACK";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //startservice --> serviceclass.onCreate() --> serviceclass.onStartCommand()
        bplay = (Button)findViewById(R.id.btn_play);
        bpause = (Button)findViewById(R.id.btn_pause);
        bstop = (Button)findViewById(R.id.btn_stop);

        final Intent playbackIntent = new Intent(MainActivity.this, MusicService.class);

        bplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playbackIntent.putExtra(PLAY_KEY,"PLAY");
            }
        });

        bpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playbackIntent.putExtra(PLAY_KEY,"PAUSE");
            }
        });

        bstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playbackIntent.putExtra(PLAY_KEY,"STOP");
            }
        });

        startService(playbackIntent);
    }



    @Override
    protected void onStop() {
        super.onStop();
        // stop related behavior takes place here. what the fuck is going on here,
        //stopService(new Intent(MainActivity.this,serviceclass.class))l

    }
}

package com.example.videomeetup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;

public class MainActivity extends AppCompatActivity {
   EditText ed_room;
   Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_room=findViewById(R.id.ed_room);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed_room.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Specify Room id", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                                .setServerURL(new URL("https://meet.jit.si"))
                                .setRoom(ed_room.getText().toString())
                                .setAudioOnly(true)
                                .setVideoMuted(true)
                                .build();
                        JitsiMeetActivity.launch(MainActivity.this,options);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();

                    }
                }
            }
        });
    }
}
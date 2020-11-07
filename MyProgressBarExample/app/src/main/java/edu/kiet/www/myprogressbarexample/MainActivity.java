package edu.kiet.www.myprogressbarexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb;
    Button startprogress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb=findViewById(R.id.progressBar);
        startprogress=findViewById(R.id.btnStartProgress);
        startprogress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int value=0;
                        while(value<=100)
                        {
                            value=value+10;
                            try {
                                sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            pb.setProgress(value);
                        }
                    }
                });

                t.start();
            }
        });

    }
}

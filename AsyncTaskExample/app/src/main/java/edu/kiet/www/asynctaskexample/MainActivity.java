package edu.kiet.www.asynctaskexample;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    String url="https://yt3.ggpht.com/a-/AAuE7mBSSyLguJ1oyrDbGus7-z2TTsl4XA7qU1Tdyw=s288-mo-c-c0xffffffff-rj-k-no";
    Button loadimage;
    ImageView myimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myimage=findViewById(R.id.imageView);
        loadimage=findViewById(R.id.btnLoadImage);
        loadimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadMyImage loadMyImage =new LoadMyImage();
                loadMyImage.execute(url);
            }
        });
    }
    class LoadMyImage extends AsyncTask<String,Void,Bitmap>
    {
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog =new ProgressDialog(MainActivity.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... data) {
            Bitmap bitmap=null;
            try {
                URL url = new URL(data[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                bitmap = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            progressDialog.hide();
            myimage.setImageBitmap(bitmap);
        }
    }

}

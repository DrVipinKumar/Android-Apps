package edu.kiet.www.myasyntaskexample;

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
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button loadimage;
    ImageView imageView;
    String url="https://yt3.ggpht.com/a-/AAuE7mBSSyLguJ1oyrDbGus7-z2TTsl4XA7qU1Tdyw=s288-mo-c-c0xffffffff-rj-k-no";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadimage=findViewById(R.id.btnLoadImage);
        imageView=findViewById(R.id.imageView);
        loadimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadImageFromInternet internetimage = new LoadImageFromInternet();
                internetimage.execute(url);
            }
        });
    }

    private class LoadImageFromInternet extends AsyncTask<String, Integer,Bitmap> {
        int filesize=0;
        ProgressDialog progressDialog=null;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog=new ProgressDialog(MainActivity.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap image=null;
            int progress=0;
            try {
                URL url= new URL(strings[0]);
                HttpURLConnection httpurl = (HttpURLConnection) url.openConnection();
                InputStream is = httpurl.getInputStream();
                image = BitmapFactory.decodeStream(is);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return image;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);


        }

        @Override
        protected void onPostExecute(Bitmap image) {
            super.onPostExecute(image);
            progressDialog.hide();
            imageView.setImageBitmap(image);

        }

    }
}

package ir.asma.imageprosses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;




public class SplashActivity extends AppCompatActivity {

    ImageView imgLogo;
    TextView tvVersion,logoTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logoTextView=(TextView)findViewById(R.id.logoTextView);
        tvVersion=(TextView)findViewById(R.id.tvVersion);
        imgLogo=(ImageView) findViewById(R.id.imgLogo);

        logoTextView.setVisibility(View.INVISIBLE);
        tvVersion.setVisibility(View.INVISIBLE);
        imgLogo.setVisibility(View.INVISIBLE);
        imgClose.ssetVisibility()


        new Handler().postDelayed(new Runnable() {
            public void run() {

                logoTextView.setVisibility(View.VISIBLE);
                tvVersion.setVisibility(View.VISIBLE);
                imgLogo.setVisibility(View.VISIBLE);


                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent intent=new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                },  500);

            }
        },  3000);






    }
}
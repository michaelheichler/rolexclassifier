package ir.asma.imageprosses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {


   RelativeLayout rlChooseImage,rlArchive,rlProcessing;
   ImageView imageView;
   TextView prediction;
   TextView tvNo;


    Bitmap newProfilePic;

    RadusImageView imgImage;

    MainActivity mainActivity=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity=this;
        setContentView(R.layout.activity_main);
        rlArchive=(RelativeLayout) findViewById(R.id.rlArchive);
        rlChooseImage=(RelativeLayout) findViewById(R.id.rlChooseImage);
        rlProcessing=(RelativeLayout) findViewById(R.id.rlProcessing);
        imageView=(ImageView)findViewById(R.id.image);
        tvNo=(TextView) findViewById(R.id.tvNo);
        /* prediction=(TextView)findViewById(R.id.predictions);*/


        rlArchive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ArchiveActivity.class));

            }
        });

        rlChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                new DialogSetItem(MainActivity.this,R.style.TransparentDialog,mainActivity).show();


            }
        });

        rlProcessing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(MainActivity.this,ProccesActivity.class));


            }
        });

    }


    public void pickImage() {

        if(ActivityCompat.checkSelfPermission(MainActivity.this,READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
            Intent intent = new Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.INTERNAL_CONTENT_URI);

            intent.setType("image/*");
            intent.putExtra("crop", "true");
            intent.putExtra("scale", true);
            intent.putExtra("outputX", 500);
            intent.putExtra("outputY", 500);
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
            intent.putExtra("return-data", true);
            startActivityForResult(intent, 1);

        }
        else {
            String[] PERMISSIONS = { Manifest.permission.READ_EXTERNAL_STORAGE};
            ActivityCompat.requestPermissions(MainActivity.this, PERMISSIONS ,1);
        }




    }




    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {

            if (requestCode == 1) {
                final Bundle extras = data.getExtras();
                if (extras != null) {
                    //Get image
                    newProfilePic = extras.getParcelable("data");
                    //saveToInternalStorage(newProfilePic);
                   imgImage.setImageBitmap( newProfilePic);
                   rlProcessing.setVisibility(View.VISIBLE);
                   tvNo.setVisibility(View.GONE);







                }
            }

        }
        catch (Exception e){


            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();

        }

    }

}
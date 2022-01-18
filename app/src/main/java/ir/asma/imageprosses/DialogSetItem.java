package ir.asma.imageprosses;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;



import java.util.ArrayList;
import java.util.List;


public class DialogSetItem extends Dialog  {



    public DialogSetItem dialogProgressBar=this;

    CardView cvDialog;

    Context context;
    RelativeLayout rlGallery,rlCammera;
    MainActivity activity;


    public DialogSetItem(@NonNull Context context, int themeResId,MainActivity activity) {
        super(context, themeResId);
        this.context=context;
        this.activity=activity;


    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_set_list);
        this.setCancelable(true);
         rlCammera = (RelativeLayout) findViewById(R.id.rlCammera);
        rlGallery = (RelativeLayout) findViewById(R.id.rlGallery);

        rlGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               activity.pickImage();
                dismiss();

            }
        });



        rlCammera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


     //   this.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
















    }


}

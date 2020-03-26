package com.github.ivanshafran.picassosample;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_main );
		ImageView imageView = findViewById( R.id.imageView );

        Picasso
                .get()
                .load("https://img1.akspic.com/image/94611-kitten-american_shorthair-cat-whiskers-munchkin_cat-2560x1440.jpg")
                .fit()
                .centerInside()
                .into(imageView);
    }
}

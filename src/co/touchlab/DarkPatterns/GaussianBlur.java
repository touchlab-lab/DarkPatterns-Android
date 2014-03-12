package co.touchlab.DarkPatterns;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import co.touchlab.DarkPatterns.utils.BitmapUtils;

/**
 * User: davidredding
 * Date: 3/11/14
 * Time: 10:51 PM
 */

/*
YOU NEED APK 17
 */
public class GaussianBlur extends Activity implements View.OnClickListener {

    ImageView background;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gaussian);


        background = (ImageView) findViewById(R.id.background);

        Button alter = (Button) findViewById(R.id.alter);
        alter.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Blurring Background", Toast.LENGTH_SHORT).show();

        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),
                R.drawable.intro_screen);

        Bitmap blurredBitmap = BitmapUtils.blurBitmap(this, bitmap, 25);

        background.setImageBitmap(blurredBitmap);

    }
}
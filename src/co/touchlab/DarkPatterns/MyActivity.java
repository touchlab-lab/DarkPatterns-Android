package co.touchlab.DarkPatterns;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }



    public void gaussianBlur(View v){

        startActivity(new Intent(MyActivity.this, GaussianBlur.class));

    }

    public void pullRefresh(View v){
        startActivity(new Intent(MyActivity.this, PullRefresh.class));

    }

    public void googleShare(View v){
        startActivity(new Intent(MyActivity.this, GoogleShare.class));


    }


}

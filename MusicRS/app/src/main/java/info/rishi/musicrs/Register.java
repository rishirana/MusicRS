package info.rishi.musicrs;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Ritesh Rana on 6/23/2016.
 */
public class Register extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Log.d("check","message testing");
    }
}

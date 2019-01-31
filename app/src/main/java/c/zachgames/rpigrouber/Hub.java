package c.zachgames.rpigrouber;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Hub extends AppCompatActivity {
    private ViewPager viewPager;
    private SlideAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hub);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        myadapter = new SlideAdapter(this);
        viewPager.setAdapter(myadapter);
    }
}

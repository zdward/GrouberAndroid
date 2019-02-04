package c.zachgames.rpigrouber;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int number_tabs = 3;

    public PagerAdapter(FragmentManager fm, int Num) {
        super(fm);
        this.number_tabs = Num;
    }
    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                Hub_Fragment hub = new Hub_Fragment();
                return hub;
            case 1:
                Post_Fragment post = new Post_Fragment();
                return post;
            case 2:
                Profile_Fragment profile = new Profile_Fragment();
                return profile;
            default:
                return null;



        }
    }

    @Override
    public int getCount() {
        return 0;
    }
}

package c.zachgames.rpigrouber;

import android.support.v4.app.ListFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Hub_Fragment extends ListFragment implements SearchView.OnQueryTextListener, MenuItem.OnActionExpandListener{
    List<String> posts;
    private ArrayAdapter<String> adapter;
    private Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = getActivity();
        setHasOptionsMenu(true);
        populateList();
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        String item = (String) listView.getAdapter().getItem(position);
        if (getActivity() instanceof OnItem1SelectedListener) {
            ((OnItem1SelectedListener) getActivity()).OnItem1SelectedListener(item);
        }
        getFragmentManager().popBackStack();
    }

    public interface OnItem1SelectedListener {
        void OnItem1SelectedListener(String item);
    }

    private void populateList() {
        posts = new ArrayList<>();

        posts.add("Kevin's Post");
        posts.add("Dennis's Post");
        posts.add("Zach's Post");
        posts.add("John's Post");
        posts.add("Alex's Post");
        posts.add("Alexis's Post");
        posts.add("Paul's Post");
        posts.add("Frauk's Post");
        posts.add("Karen's Post");

        adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, posts);
        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hub_, container, false);
        ListView list = (ListView) view.findViewById(R.id.post_list);
        TextView emptyTextView = (TextView) view.findViewById(R.id.empty_list);
        list.setEmptyView(emptyTextView);

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem menuItem) {
        return true;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText == null || newText.trim().isEmpty()) {
            resetSearch();
            return false;
        }

        List<String> filteredValues = new ArrayList<String>(posts);
        for (String value : posts) {
            if (!value.toLowerCase().contains(newText.toLowerCase())) {
                filteredValues.remove(value);
            }
        }

        adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, filteredValues);
        setListAdapter(adapter);

        return false;
    }

    public void resetSearch() {
        adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, posts);
        setListAdapter(adapter);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

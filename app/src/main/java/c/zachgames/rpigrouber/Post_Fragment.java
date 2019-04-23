package c.zachgames.rpigrouber;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import static android.support.design.widget.Snackbar.make;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Post_Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Post_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Post_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private Button Post;

    public Post_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Post_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Post_Fragment newInstance(String param1, String param2) {
        Post_Fragment fragment = new Post_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_post_, container, false);

        String [] values =
                {"1","2","3","4","5","6"};
        Spinner spinner = (Spinner) v.findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);



        String [] hours =
                {"00","01","02","03","04","05","06","07","08","09","10","11","12"};
        Spinner h_spinner = (Spinner) v.findViewById(R.id.hour);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, hours);
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        h_spinner.setAdapter(adapter2);


        String [] minutes =
                {"00","01","02","03","04","05","06","07","08","09","10","11","12",
                        "13","14","15","16","17","18","19","20","21","22","23","24","25",
                        "26","27","28","29","30","31","32","33","34","35","36","37","38",
                        "39","40","41","42","43","44","45","46","47","48","49","50","51",
                        "52","53","54","55","56","57","58","59",};
        Spinner m_spinner = (Spinner) v.findViewById(R.id.minute);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, minutes);
        adapter3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        m_spinner.setAdapter(adapter3);

        String [] pm =
                {"AM","PM"};
        Spinner p_spinner = (Spinner) v.findViewById(R.id.am);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, pm);
        adapter4.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        p_spinner.setAdapter(adapter4);


        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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

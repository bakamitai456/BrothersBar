package games.produck.brothers;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.io.Serializable;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BackEndFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BackEndFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BackEndFragment extends Fragment {

    private Activity parentActivity;

    private OnFragmentInteractionListener mListener;

    public BackEndFragment() {
        // Required empty public constructor
    }

    public static BackEndFragment newInstance(Serializable param1) {
        BackEndFragment fragment = new BackEndFragment();
        Bundle args = new Bundle();
        args.putSerializable("activity", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            parentActivity = (Activity)getArguments().getSerializable("activity");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_back_end, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onStart() {
        LinearLayout newDeposite = (LinearLayout)getView().findViewById(R.id.new_deposite);
        LinearLayout deposite = (LinearLayout)getView().findViewById(R.id.deposite);
        LinearLayout withdraw = (LinearLayout)getView().findViewById(R.id.withdraw);

        newDeposite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = ((AppCompatActivity)parentActivity).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                NewDepositFragment fragment = new NewDepositFragment();
                fragmentTransaction.replace(R.id.fragment_content, fragment);
                fragmentTransaction.commit();
            }
        });

        deposite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = ((AppCompatActivity)parentActivity).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                DepositeFregment fragment = new DepositeFregment();
                fragmentTransaction.replace(R.id.fragment_content, fragment);
                fragmentTransaction.commit();
            }
        });

        withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                FragmentManager fm = ((AppCompatActivity)parentActivity).getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fm.beginTransaction();
//                BackEndFragment fragment = new BackEndFragment();
//                fragmentTransaction.replace(R.id.fragment_content, fragment);
//                fragmentTransaction.commit();
            }
        });
        super.onStart();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

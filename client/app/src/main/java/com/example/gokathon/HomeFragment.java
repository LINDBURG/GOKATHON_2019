package com.example.gokathon;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.leanback.widget.HorizontalGridView;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private GridView truckListView;
    private ArrayList<String> truckNo;
    private ArrayList<Integer> truckImage;

    ViewFlipper v_flipper;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        int images[] = {R.drawable.image1, R.drawable.image2, R.drawable.image3};
        ViewFlipper v_flipper = (ViewFlipper) view.findViewById(R.id.v_flipper);
        for (int i=0; i<images.length; i++){
            ImageView imageView  =new ImageView(this.getActivity());
            imageView.setBackgroundResource(images[i]);
            v_flipper.addView(imageView);
            v_flipper.setFlipInterval(3500); //3sec
            v_flipper.setAutoStart(true);
            v_flipper.setInAnimation(this.getActivity(),android.R.anim.fade_in);

        }
        //initialize view
        GridView truckListView = (GridView) view.findViewById(R.id.truckList);
        //initialize truck data
        truckNo = new ArrayList<>();
        truckImage = new ArrayList<>();
        // add values
        // add values
        truckNo.add("MH12MH12");
        truckNo.add("MH11MH11");
        truckNo.add("MH10MH10");
        truckNo.add("MH09MH09");
        truckNo.add("MH08MH08");
       /* truckNo.add("크리쳐");
        truckNo.add("해리코털95");
        truckNo.add("집요정맞음");
        truckNo.add("바나나");
        truckNo.add("옥시싹싹");*/


        truckImage.add(R.drawable.hanju);
        truckImage.add(R.drawable.jaemin);
        truckImage.add(R.drawable.gollum);
        truckImage.add(R.drawable.minion);
        truckImage.add(R.drawable.malfoy);

        truckListView.setNumColumns(truckNo.size());

        //manipulate the width of each item in grid view / truck list
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);

        // width = your devices width
        int width = dm.widthPixels;

        Log.d("MainActivity","hori grid width "+width);

        // number of items you have to display in screen
        int numOfItemPerScreen = 3;
        Log.d("MainActivity","hori grid width per screen "+numOfItemPerScreen);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                (width * (truckNo.size() / numOfItemPerScreen)), LinearLayout.LayoutParams.MATCH_PARENT);

        truckListView.setLayoutParams(params);
        // width of each item in grid I am displaying 3 items per screen
        truckListView.setColumnWidth(width / numOfItemPerScreen);
        truckListView.setHorizontalSpacing(2);
        truckListView.setStretchMode(GridView.STRETCH_SPACING);
        truckListView.setNumColumns(truckNo.size());
        // render truck mapping details
        truckListView.setAdapter(new CustomAdapter());

        return view;
    }

   /* public void flipperImages(int image){
        ImageView imageView  =new ImageView(this.getActivity());
        imageView.setBackgroundResource(image);
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(3000); //3sec
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this.getActivity(), android.R.anim.slide_in_left);
        v_flipper.setInAnimation(this.getActivity(), android.R.anim.slide_out_right);

    }*/
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
    private void customizeTruckView() {
        truckListView.setNumColumns(truckNo.size());

        //manipulate the width of each item in grid view / truck list
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);

        // width = your devices width
        int width = dm.widthPixels;

        Log.d("MainActivity","hori grid width "+width);

        // number of items you have to display in screen
        int numOfItemPerScreen = 3;
        Log.d("MainActivity","hori grid width per screen "+numOfItemPerScreen);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                (width * (truckNo.size() / numOfItemPerScreen)), LinearLayout.LayoutParams.MATCH_PARENT);

        truckListView.setLayoutParams(params);
        // width of each item in grid I am displaying 3 items per screen
        truckListView.setColumnWidth(width / numOfItemPerScreen);
        truckListView.setHorizontalSpacing(2);
        truckListView.setStretchMode(GridView.STRETCH_SPACING);
        truckListView.setNumColumns(truckNo.size());
        // render truck mapping details
        truckListView.setAdapter(new CustomAdapter());
    }

    /**
     * Class used to customize TruckView
     */
    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return truckNo.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View customTruckView = getLayoutInflater().inflate(R.layout.grid_element,null);
            TextView txtTruckNo = (TextView)customTruckView.findViewById(R.id.txtTruckNo);
            txtTruckNo.setText(truckNo.get(position));
            txtTruckNo.setCompoundDrawablesWithIntrinsicBounds(0, truckImage.get(position),0,0);
            return customTruckView;
        }
    }



}

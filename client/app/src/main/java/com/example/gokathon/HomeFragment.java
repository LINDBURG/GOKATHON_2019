package com.example.gokathon;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
    private ArrayList<String> truckNo_home;
    private ArrayList<Integer> truckImage_home;

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
        ImageView noti = (ImageView) view.findViewById(R.id.notification_button);
        noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent2 = new Intent(getActivity(), NotificationActivity.class);
                startActivity(myIntent2);
            }
        });
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
        GridView truckListView_home = (GridView) view.findViewById(R.id.truckList2);
        truckListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent newIntent= new Intent(getActivity(), DobbyInfoActivity.class);
                startActivity(newIntent);
            }
        });
        //initialize truck data
        truckNo = new ArrayList<>();
        truckImage = new ArrayList<>();
        truckNo_home = new ArrayList<>();
        truckImage_home = new ArrayList<>();
        // add values
        // add values
        truckNo.add("집요정맞음");
        truckNo.add("바나나");
        truckNo.add("옥시싹싹");
        truckImage.add(R.drawable.hanju);
        truckImage.add(R.drawable.jaemin);
        truckImage.add(R.drawable.gollum);
        //truckImage.add(R.drawable.minion);
        //truckImage.add(R.drawable.malfoy);
        truckNo_home.add("집좀 어떻게");
        truckNo_home.add("설거지");
        truckNo_home.add("안암동 돼지우리");
        truckImage_home.add(R.drawable.dirtyhouse1);
        truckImage_home.add(R.drawable.dirtyhouse3);
        truckImage_home.add(R.drawable.dirtyhouse4);
        truckListView.setNumColumns(truckNo.size());
        truckListView_home.setNumColumns(truckNo_home.size());
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

        LinearLayout.LayoutParams params_home = new LinearLayout.LayoutParams(
                (width * (truckNo_home.size() / numOfItemPerScreen)), LinearLayout.LayoutParams.MATCH_PARENT);

        truckListView.setLayoutParams(params_home);
        // width of each item in grid I am displaying 3 items per screen
        truckListView_home.setColumnWidth(width / numOfItemPerScreen);
        truckListView_home.setHorizontalSpacing(2);
        truckListView_home.setStretchMode(GridView.STRETCH_SPACING);
        truckListView_home.setNumColumns(truckNo_home.size());
        // render truck mapping details
        truckListView_home.setAdapter(new CustomAdapter_home());

        return view;
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

            txtTruckNo.setTextSize(9);
            txtTruckNo.setCompoundDrawablesWithIntrinsicBounds(0, truckImage.get(position),0,0);
            return customTruckView;
        }
    }


    /**
     * Class used to customize TruckView
     */
    private class CustomAdapter_home extends BaseAdapter {
        @Override
        public int getCount() {
            return truckNo_home.size();
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
            txtTruckNo.setText(truckNo_home.get(position));
            txtTruckNo.setCompoundDrawablesWithIntrinsicBounds(0, truckImage_home.get(position),0,0);
            return customTruckView;
        }
    }



}

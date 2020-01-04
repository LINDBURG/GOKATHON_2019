package com.example.gokathon;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MyPageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MyPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyPageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static int index = 0;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private ListView listView;
    ArrayList<MyHistory> history_list;
    HistoryAdapter myadapter;
    MyHistory my1, my2, my3;

    public MyPageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyPageFragment newInstance(String param1, String param2) {
        MyPageFragment fragment = new MyPageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    //스크롤뷰 안에 리스트뷰 문제 해결 위해 넣음
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);

        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
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


        //여기서부터 새로 작성 by 문재호

        View v = inflater.inflate(R.layout.fragment_my_page, container, false);

        ImageView imageView = (ImageView) v.findViewById(R.id.image1);
        TextView textView = (TextView) v.findViewById(R.id.text1);


        // drawable에 있는 이미지를 지정합니다.
        imageView.setImageResource(R.drawable.dobby);


        // 100 줄의 텍스트를 생성합니다.
        String text = "";
        for(int i=0; i<100; i++)
            text += i + "\n";
        textView.setText(text);


        listView = (ListView) v.findViewById(R.id.listView);
        my1 = new MyHistory("손님1", "정말조와용", "별점 5개", BitmapFactory.decodeResource(getResources(), R.drawable.gollum1));
        my2 = new MyHistory("손님2", "약간조와용", "별점 4개", BitmapFactory.decodeResource(getResources(), R.drawable.gollum2));
        my3 = new MyHistory("손님3", "별로조와용", "별점 3개", BitmapFactory.decodeResource(getResources(), R.drawable.gollum3));
        history_list = new ArrayList<MyHistory>();
        history_list.add(my1);
        history_list.add(my2);
        history_list.add(my3);
        history_list.add(my1);
        history_list.add(my2);
        history_list.add(my3);
        history_list.add(my1);
        history_list.add(my2);
        history_list.add(my3);

        myadapter = new HistoryAdapter(getActivity(), R.layout.my_history,history_list);
        listView.setAdapter(myadapter);
        setListViewHeightBasedOnChildren(listView);


        // Inflate the layout for this fragment
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

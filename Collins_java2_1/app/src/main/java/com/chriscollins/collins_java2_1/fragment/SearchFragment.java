package com.chriscollins.collins_java2_1.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chriscollins.collins_java2_1.R;

/**
 * Created by chriscollins on 4/11/16.
 */
public class SearchFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = "SearchFragment.TAG";

    public static SearchFragment newInstance() {
        SearchFragment frag = new SearchFragment();
        return frag;
    }

    public interface OnButtonClickListener {
        public void displayText(String _text);


    }

    private OnButtonClickListener mListener;

    @Override
    public void onAttach(Activity _activity) {
        super.onAttach(_activity);

        if(_activity instanceof OnButtonClickListener) {
            mListener = (OnButtonClickListener)_activity;
        } else {
            throw new IllegalArgumentException("Containing activity must implement OnButtonClickListener interface");
        }
    }

    @Override
    public View onCreateView(LayoutInflater _inflater, ViewGroup _container,
                             Bundle _savedInstanceState) {
        View view = _inflater.inflate(R.layout.search_fragment, _container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle _savedInstanceState) {
        super.onActivityCreated(_savedInstanceState);

        View view = getView();

        Button button = (Button)view.findViewById(R.id.searchButton);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View _v) {
        switch(_v.getId()) {
            case R.id.searchButton:

                mListener.displayText(getString(R.string.app_name));
                break;



        }
    }
}
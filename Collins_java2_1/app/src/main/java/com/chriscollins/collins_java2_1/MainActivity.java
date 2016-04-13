package com.chriscollins.collins_java2_1;
/**
 * Created by chriscollins on 4/11/16.
 */

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.chriscollins.collins_java2_1.fragment.DisplayFragment;
import com.chriscollins.collins_java2_1.fragment.SearchFragment;

public class MainActivity extends Activity implements SearchFragment.OnButtonClickListener {

    public static Context mContext;
    public static Activity mActivity;

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);

        mContext = this;
        mActivity = this;

        setContentView(R.layout.activity_main);


        if(_savedInstanceState == null) {
            SearchFragment frag = SearchFragment.newInstance();
            getFragmentManager().beginTransaction().replace(R.id.container1, frag, SearchFragment.TAG).commit();
        }


    }

    @Override
    public void displayText(String _text) {
        DisplayFragment frag = (DisplayFragment)getFragmentManager().findFragmentByTag(DisplayFragment.TAG);

        if(frag == null) {
            frag = DisplayFragment.newInstance(_text);
            getFragmentManager().beginTransaction().replace(R.id.container2, frag, DisplayFragment.TAG).commit();
        } else {
            frag.setDisplayText(_text);
        }
    }





}


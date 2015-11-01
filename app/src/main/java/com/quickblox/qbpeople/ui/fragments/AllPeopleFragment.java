package com.quickblox.qbpeople.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.quickblox.qbpeople.R;
import com.quickblox.qbpeople.utils.Consts;

/**
 * Created by Tereha on 21.06.2015.
 */
public class AllPeopleFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_peoples, null);

        WebView webView = (WebView) view.findViewById(R.id.webViewAllPeoples);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(Consts.CURRENT_URL);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

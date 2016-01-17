package com.quickblox.qbpeople.htmlparcer;

import android.os.AsyncTask;

public class HtmlParser {

    private static final String TAG = HtmlParser.class.getSimpleName();

    public void getStingFomWeb() {
        new NewThread().execute();
    }

    public class NewThread extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... arg) {

            return null;
        }
    }
}
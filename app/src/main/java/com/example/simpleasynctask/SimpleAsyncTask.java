package com.example.simpleasynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;


//public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {

public class SimpleAsyncTask extends AsyncTask<Void,Integer,String>{
    private WeakReference<TextView> mTextView;

    SimpleAsyncTask(TextView tv) {
        mTextView = new WeakReference<>(tv);
    }


    @Override
    protected String doInBackground(Void... voids) {

        // Generate a random number between 0 and 10
        Random r = new Random();
        int n = r.nextInt(11);

        // Make the task take long enough that we have
        // time to rotate the phone while it is running
        int s = n * 200;

       // super.publishProgress(s);
        //This method must be called from the Looper#getMainLooper() of your app.
        //Looper looper = Looper.getMainLooper().
        //super.onProgressUpdate(s);
        // Sleep for the random amount of time
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Return a String result
        return "Awake at last after sleeping for " + s + " milliseconds!";
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mTextView.get().setText(s);
    }

    //Coding Challenge
    //Use onProgressUpdate method to update the UI with the current sleep time
//    @Override
//    protected void onProgressUpdate(Integer... values) {
//        super.onProgressUpdate(values);
//
//        Looper looper = Looper.getMainLooper();
//        looper
//        Application::getMainLooper.onProgressUpdate(values);;
//
//    }
}
package com.example.connectfourandcrisscross;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class ShowDialog1 extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder =
                    new AlertDialog.Builder(getActivity());
            builder.setMessage("Error occured due to password mismatched").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Main3Activity m1=(Main3Activity) getActivity();
                    m1.showdiolog2();
                }
            });
            return builder.create();
        }
}

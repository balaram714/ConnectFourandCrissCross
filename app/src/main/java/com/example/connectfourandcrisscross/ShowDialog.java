package com.example.connectfourandcrisscross;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

public class ShowDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());
        LayoutInflater inflater =
                getActivity().getLayoutInflater();
        View dialogView =
                inflater.inflate(R.layout.show_dialog, null);
        final EditText editTitle = (EditText) dialogView.findViewById(R.
                id.id1);
        final EditText password = (EditText) dialogView.findViewById(R.
                id.pass);
        final EditText repassword = (EditText) dialogView.findViewById(R.
                id.repass);
        Button done = (Button) dialogView.findViewById(R.id.button2);
        builder.setView(dialogView);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseClass databaseClass=new DatabaseClass(getActivity());

                if(password.getText().toString().equals(repassword.getText().toString())){
                    databaseClass.insert(editTitle.getText().toString(),password.getText().toString());
                    Log.i("info","successfully");
                    Main3Activity m=(Main3Activity) getActivity();
                    m.confermationmessege();
                }
                else{
                    Log.i("info","unsuccessful");

                    Main3Activity m=(Main3Activity) getActivity();
                    m.showdiolog1();
                }

                dismiss();
            }});
        return builder.create();
        }
    }


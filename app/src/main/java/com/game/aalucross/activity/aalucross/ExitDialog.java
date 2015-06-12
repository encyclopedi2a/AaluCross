package com.game.aalucross.activity.aalucross;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

/**
 * Created by gokarna on 6/12/15.
 */
public class ExitDialog implements View.OnClickListener {
    private Context context;
    private Button positiveButton, negativeButton;
    private AlertDialog alertDialog;

    public ExitDialog(Context context) {
        this.context = context;
    }

    public AlertDialog returnDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.dialog_resources, null);
        positiveButton = (Button) view.findViewById(R.id.positive);
        positiveButton.setOnClickListener(this);
        negativeButton = (Button) view.findViewById(R.id.negative);
        negativeButton.setOnClickListener(this);
        builder.setView(view);
        alertDialog = builder.create();
        return alertDialog;
    }

    @Override
    public void onClick(View view) {
        if ((Button) view == positiveButton) {
            ((Activity) context).finish();
        } else {
            alertDialog.dismiss();
        }
    }
}

package com.example.raghunat.dialogstartup;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by raghunat on 9/28/2016.
 */
public class DialogHelper {
    public static void popup(
            String title,
            String message,
            String positiveText,
            String negativeText,
            boolean cancellable,
            Context context,
            final MainActivity activity) {

                // Instantiate
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                 dialog
                    .setTitle(title)
                    .setMessage(message)
                    .setCancelable(cancellable)
                    .setPositiveButton(positiveText, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface d, int id) {
                            // if this button is clicked, do something
                            // Close the app
                            activity.finish();
                        }
                    })
                    .setNegativeButton(negativeText, new DialogInterface.OnClickListener() {
                        public void onClick (DialogInterface d, int id){
                            // Close the popup
                            d.cancel();
                        }
                    });
                // Use
                dialog.create().show();
    }

    public static void timePopup(Context context) {
        TimePickerDialog.Builder dialog = new TimePickerDialog.Builder(context);
        // You can explore the other options in the API Docs

        dialog.create().show();
    }
}

package com.example.raghunat.timeproject;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

/**
 * Created by raghunat on 9/30/2016.
 */
public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(
                getActivity(),
                this, hour, minute, true);
    }

    @Override
    public void onTimeSet(TimePicker view, int hour, int min) {
        TextView setTimeText = (TextView)getActivity().findViewById(R.id.set_time);
        setTimeText.setText("Chosen Hour:" + hour + " Chosen minutes: " + min);
    }
}

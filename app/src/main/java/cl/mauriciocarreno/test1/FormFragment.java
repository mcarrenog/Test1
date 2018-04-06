package cl.mauriciocarreno.test1;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class FormFragment extends Fragment {

    int day;
    int month;
    int year;

    public FormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_form, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText titleReminderET = view.findViewById(R.id.reminderNameET);

        Button sendBtn = view.findViewById(R.id.sendBtn);

        CalendarView calendar = getView().findViewById(R.id.reminderCalendar);


        long date = calendar.getDate();


        day = Integer.parseInt(new SimpleDateFormat("dd").format(new Date(date)));
        month = Integer.parseInt(new SimpleDateFormat("MM").format(new Date(date)));
        year = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date(date)));

        final Calendar calendar1 =  Calendar.getInstance();

        calendar1.set(year,month,day);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {

                day = i2;
                month = i1;
                year = i;
                calendar1.set(year,month,day);
            }
        });

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(!titleReminderET.getText().toString().equals("")) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String dateFormat = simpleDateFormat.format(calendar1.getTimeInMillis());

                    Toast.makeText(getContext(), "Fecha feleccionada: " + dateFormat, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Snackbar.make(getActivity().findViewById(android.R.id.content),
                            "Debes ingresar un título para el recordatorio", Snackbar.LENGTH_LONG).show();
                }
            }
        });


    }
}

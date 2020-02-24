package com.example.budgetapp_ver0;

import android.app.DatePickerDialog;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;

import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import uiDesign.NoDefaultSelectSpinnerAdapter;

public class CreateNewEntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_entry);

        final ToggleButton expense_toggle = findViewById(R.id.expense_toggle_button);

        final EditText amountInput = findViewById(R.id.amount_input);

        final TextView dateInput = findViewById(R.id.date_input);
        dateInput.setInputType(InputType.TYPE_NULL);
        final Calendar inputCalendar = Calendar.getInstance();

        dateInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day = inputCalendar.get(Calendar.DAY_OF_MONTH);
                int month = inputCalendar.get(Calendar.MONTH);
                int year = inputCalendar.get(Calendar.YEAR);
                // date picker dialog
                DatePickerDialog picker = new DatePickerDialog(CreateNewEntryActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                Calendar today = Calendar.getInstance();
                                int dayToday = today.get(Calendar.DAY_OF_MONTH);
                                int monthToday = today.get(Calendar.MONTH);
                                int yearToday = today.get(Calendar.YEAR);

                                if (dayToday == dayOfMonth && monthToday == monthOfYear && yearToday == year) {
                                    dateInput.setText("Today");
                                } else {
                                    dateInput.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                                }
                                inputCalendar.set(year, monthOfYear,dayOfMonth);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        final Spinner categorySpinner = findViewById(R.id.category_spinner);

        List<CharSequence> trialList = new ArrayList<>();
        trialList.add("Income");
        trialList.add("heyhey");

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, trialList);
        categorySpinner.setPrompt("Select a Category");
        categorySpinner.setAdapter(
                new NoDefaultSelectSpinnerAdapter(
                        adapter,
                        R.layout.catergory_spinner,
                        // R.layout.contact_spinner_nothing_selected_dropdown, // Optional
                        this));

        final TextInputEditText noteInput = findViewById(R.id.note_edit_text);

        FloatingActionButton addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                // if amount or category is blank
                if (amountInput.getText().toString().equals("")) {
                    Snackbar.make(view, "Please enter amount", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else if (categorySpinner.getSelectedItem() == null) {
                    Snackbar.make(view, "Please select category", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    int amount = Integer.parseInt(amountInput.getText().toString());
                    if (!expense_toggle.isChecked()) {
                        amount = -amount;
                    }
                    int day = inputCalendar.get(Calendar.DAY_OF_MONTH);
                    int month = inputCalendar.get(Calendar.MONTH);
                    int year = inputCalendar.get(Calendar.YEAR);
                    String category = categorySpinner.getSelectedItem().toString();
                    String note = noteInput.getText().toString();
                    try {
                        MainActivity.budgetApp.addEntry(amount, day, month, year, category, note);
                    } catch (JSONException err) {
                        Snackbar.make(view, "ERROR OCCURRED", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                    // if recurrence, add recurrence
                    finish();
                }
            }
        });

    }
}

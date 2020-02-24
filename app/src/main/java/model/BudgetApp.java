package model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BudgetApp {

    // load only one month at a time.
    // each month has a summary data as well.....
    // but maybe we can have a summary for  year

    // should data be organized?

    private List<Entry> activeData;
    private List<String> categories;
    private Calendar calendar;

    public BudgetApp() {
        calendar = Calendar.getInstance();
        // TODO: set active data to load
        load();
    }

    public void addEntry(int amount, int date, int month, int year, String category, String note) throws JSONException {
        Entry entry = new Entry(amount, date, month, year, category, note);
        // TODO: add to active data
    }

    // TODO: balance monitor, financial summary sheet

    public void load() {
        // TODO: implement
        activeData = new ArrayList<>();
    }

    public void close() {
        save();
        // TODO: implement
    }

    public void save() {
        // TODO: implement
    }
}

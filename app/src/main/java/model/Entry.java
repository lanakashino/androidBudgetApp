package model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class Entry {
    private JSONObject data;


    public Entry(JSONObject data) {
        this.data = data;
    }

    public Entry(int amount, String category, Calendar calendar) throws JSONException {
        data = new JSONObject()
                .put("amount", amount)
                .put("date", calendar.get(Calendar.DATE))
                .put("month", calendar.get(Calendar.MONTH))
                .put("year", calendar.get(Calendar.YEAR))
                .put("recurrence", null)
                .put("category", category)
                .put("note", null);     // TODO: deal with note
    }

    public Entry(int amount, int date, int month, int year, String category, String note) throws JSONException {
        data = new JSONObject()
                .put("amount", amount)
                .put("date", date)
                .put("month", month)
                .put("year", year)
                .put("recurrence", null)
                .put("category", category)
                .put("note", note);
    }

    public void setRecurrence(int day, int week, int month, int year) throws JSONException{
        JSONObject recurrence = new JSONObject()
                .put("day", day)
                .put("week", week)
                .put("month", month)
                .put("year", year);
        data.put("recurrence", recurrence);
    }

    public JSONObject getData() {
        return data;
    }

    public void update() {
        // TODO: this should update date if there is an recurrence
    }
}

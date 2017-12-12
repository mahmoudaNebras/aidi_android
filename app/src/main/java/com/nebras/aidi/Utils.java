package com.nebras.aidi;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;

import android.content.res.Resources;
import android.graphics.Point;

import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import android.widget.DatePicker;

import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;



/**
 * Created by mahmoudkamal on 7/19/17.
 */

public class Utils {
    private static int screenWidth = 0;
    private static int screenHeight = 0;

    private static boolean tokenDilogShown;

    public static String getDayName(String dateStr) {
        String time = null;
        //2016-07-27 11:34:38

        String inputPattern = "yyyy-MM-dd HH:mm:ss", outputPattern = "dd";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.US);
        inputFormat.setTimeZone(TimeZone.getTimeZone("GMT+03:00"));
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.US);
        outputFormat.setTimeZone(TimeZone.getDefault());

        Date date = null;
        try {
            date = inputFormat.parse(dateStr);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date == null) {
            return "";
        }
        Calendar mDate = Calendar.getInstance();
        mDate.setTime(date);
        long difference = mDate.getTimeInMillis() - System.currentTimeMillis();
        long minutes = TimeUnit.MILLISECONDS.toMinutes(difference);
        long hours = TimeUnit.MILLISECONDS.toHours(difference);
        long days = TimeUnit.MILLISECONDS.toDays(difference);
         if (days ==0) {
            time = "Now";
            return time;

        } else time = outputFormat.format(date) + "";

        return time;
    }

   /* public static String getDayNames(String dateStr) {
        String time = null;
        //2016-07-27 11:34:38

        String inputPattern = "yyyy-MM-dd", outputPattern = "dd";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.US);
        inputFormat.setTimeZone(TimeZone.getTimeZone("GMT+03:00"));
        //Locale ar = new Locale("ar");
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.US);
        outputFormat.setTimeZone(TimeZone.getDefault());

        Date date = null;
        try {
            date = inputFormat.parse(dateStr);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date == null) {
            return "";
        }
        Calendar mDate = Calendar.getInstance();
        mDate.setTime(date);
        time = outputFormat.format(date) + "";

        return time;
    }

    public static String getMonthNames(String dateStr) {
        String time = null;
        //2016-07-27 11:34:38

        String inputPattern = "yyyy-MM-dd", outputPattern = "MMM";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.US);
        inputFormat.setTimeZone(TimeZone.getTimeZone("GMT+03:00"));
        //Locale ar = new Locale("ar");
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.US);
        outputFormat.setTimeZone(TimeZone.getDefault());

        Date date = null;
        try {
            date = inputFormat.parse(dateStr);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date == null) {
            return "";
        }
        Calendar mDate = Calendar.getInstance();
        mDate.setTime(date);
        time = outputFormat.format(date) + "";

        return time;
    }*/


    public static String getFormatedDate(String dateStr, String outputPattern) {
        String time = null;
        //2016-07-27 11:34:38

        String inputPattern = "yyyy-MM-dd";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.US);
        inputFormat.setTimeZone(TimeZone.getTimeZone("GMT+03:00"));
       // Locale ar = new Locale("ar");
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.US);

        outputFormat.setTimeZone(TimeZone.getDefault());

        Date date = null;
        try {
            date = inputFormat.parse(dateStr);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date == null) {
            return "";
        }
        Calendar mDate = Calendar.getInstance();
        mDate.setTime(date);
        time = outputFormat.format(date) ;

        return time;
    }


   /* public static boolean checkToken(final Context context, String error) {


        if(context==null)
        {
            //show dialog
            return false;
        }


        if (error.contains("failed") && !tokenDilogShown) {
            tokenDilogShown = true;
            new  AlertDialog.Builder(context).setMessage("Token Verification Failed").setIcon(R.drawable.ic_capsule_logo)
                    .setPositiveButton("Ok", (dialogInterface, i) -> {
                        NebrasApp.getNebrasApp().removeUser();
                        if(context instanceof HomeActivity){
                            context.startActivity(new Intent(context,SigninActivity.class));
                            ((Activity)context).finish();
                            return;

                        }

                        context.startActivity(new Intent(context,HomeActivity.class).putExtra(Constants.EXTRA_TOKEN_FAILED,true));
                        ((Activity)context).finish();



            }).setCancelable(false).setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {
                    tokenDilogShown = false;

                }
            }).show();





        }


        return error.contains("failed");


    }*/




    public static Boolean isSameTime(String dateStr) {
        String time = null;
        //2016-07-27 11:34:38

        String inputPattern = "yyyy-MM-dd HH:mm:ss", outputPattern = "dd";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.US);
        inputFormat.setTimeZone(TimeZone.getTimeZone("GMT+03:00"));
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.US);
        outputFormat.setTimeZone(TimeZone.getDefault());

        Date date = null;
        Date now= new Date();
        try {
            date = inputFormat.parse(dateStr);

        } catch (ParseException e) {
            e.printStackTrace();
        }


        Calendar mDate = Calendar.getInstance();
        mDate.setTime(date);
        long difference = mDate.getTime().getMinutes() - now.getMinutes();

        if (difference < 90) {
            return true;
        } else
        return false;
    }

  /*  public static void pickerDate(Context context, final Calendar myCalendar, final Button button) {
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub

                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                if(button.getId()==R.id.btn_start_from) {
                    button.setText(Utils.getFromatedStartTimeString(myCalendar.getTime()));
                    AddReminderActivity.startFrom = getFromatedStartTime(myCalendar.getTime());

                }else if(button.getId()== R.id.btn_duration){

                    button.setText(getDurationDaysString(myCalendar.getTime()));

                }
            }

        };


       DatePickerDialog datePickerDialog= new DatePickerDialog(context, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH));
       datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);


        datePickerDialog.show();

    }*/

    public static DatePickerDialog createDialogWithoutDateField(Context context, final Calendar myCalendar) {
        DatePickerDialog dpd = new DatePickerDialog(context, null, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH));
        try {
            java.lang.reflect.Field[] datePickerDialogFields = dpd.getClass().getDeclaredFields();
            for (java.lang.reflect.Field datePickerDialogField : datePickerDialogFields) {
                if (datePickerDialogField.getName().equals("mDatePicker")) {
                    datePickerDialogField.setAccessible(true);
                    DatePicker datePicker = (DatePicker) datePickerDialogField.get(dpd);
                    java.lang.reflect.Field[] datePickerFields = datePickerDialogField.getType().getDeclaredFields();
                    for (java.lang.reflect.Field datePickerField : datePickerFields) {
                        Log.i("test", datePickerField.getName());
                        if ("mDaySpinner".equals(datePickerField.getName())) {
                            datePickerField.setAccessible(true);
                            Object dayPicker = datePickerField.get(datePicker);
                            ((View) dayPicker).setVisibility(View.GONE);
                        }
                    }
                }
            }
        }
        catch (Exception ex) {
        }
        return dpd;
    }


    public static int getStatusBarHeight(Context context) {
        int height;

        Resources myResources = context.getResources();
        int idStatusBarHeight = myResources.getIdentifier(
                "status_bar_height", "dimen", "android");
        if (idStatusBarHeight > 0) {
            height = context.getResources().getDimensionPixelSize(idStatusBarHeight);

        }else{
            height = 0;

        }

        return height;
    }
    public static void showError(Context context, String errorMessage) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show();
    }

    public static void pickerTime(Context context, final Calendar myCalendar, final TextView button) {

        int hour = myCalendar.get(Calendar.HOUR_OF_DAY);
        int minute = myCalendar.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                String AM_PM ;
                if(selectedHour < 12) {
                    AM_PM = " AM";
                } else {
                    AM_PM = " PM";
                }
                button.setText(startTimeFormat().format(myCalendar.getTime()).substring(0,2) + ":" + selectedMinute + AM_PM );



            }
        }, hour, minute, false);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }
    public static SimpleDateFormat startTimeFormat(){
            return  new SimpleDateFormat("hh:00 a");
        }
    public static String getCurrentTimeString() {

        String inputPattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.US);
        inputFormat.setTimeZone(TimeZone.getDefault());
        String currentTimeString = inputFormat.format(new Date());
        return currentTimeString;
    }
    public static String getCurrentDateString() {

        String inputPattern = "yyyy-MM-dd";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.US);
        inputFormat.setTimeZone(TimeZone.getDefault());
        String currentTimeString = inputFormat.format(new Date());
        return currentTimeString;
    }
    public static String getFromatedStartTimeString(Date time) {
        String inputPattern = "yyyy-MM-dd HH:mm:ss",outputPattern = "yyyy-MM-dd";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.US);
        inputFormat.setTimeZone(TimeZone.getDefault());
        String currentTimeString = inputFormat.format(time);

        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.US);
        outputFormat.setTimeZone(TimeZone.getDefault());

        if (currentTimeString == null) {
            return "";
        }
        Calendar mDate = Calendar.getInstance();
        mDate.setTime(time);
        long difference = mDate.getTimeInMillis() - System.currentTimeMillis();
        long minutes = TimeUnit.MILLISECONDS.toMinutes(difference);
        long hours = TimeUnit.MILLISECONDS.toHours(difference);
        long days = TimeUnit.MILLISECONDS.toDays(difference);
        if (hours < 23) {
            currentTimeString = "Today";
            return currentTimeString;
        }else if(hours<47)
            currentTimeString = "Tomorrow";

        else currentTimeString =outputFormat.format(time) + "";
        return currentTimeString;
    }


    public static String getFromatedStartTime(Date time) {
        String inputPattern = "yyyy-MM-dd HH:mm:ss",outputPattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.US);
        inputFormat.setTimeZone(TimeZone.getDefault());
        String currentTimeString = inputFormat.format(time);




        return currentTimeString;
    }


    public static String getDurationDaysString(Date time) {
        String inputPattern = "yyyy-MM-dd HH:mm:ss",outputPattern = "yyyy-MM-dd";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.US);
        inputFormat.setTimeZone(TimeZone.getDefault());
        String currentTimeString = inputFormat.format(time);

        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.US);
        outputFormat.setTimeZone(TimeZone.getDefault());

        if (currentTimeString == null) {
            return "";
        }
        Calendar mDate = Calendar.getInstance();
        mDate.setTime(time);
        long difference = mDate.getTimeInMillis() - System.currentTimeMillis();
        long minutes = TimeUnit.MILLISECONDS.toMinutes(difference);
        long hours = TimeUnit.MILLISECONDS.toHours(difference);
        long days = TimeUnit.MILLISECONDS.toDays(difference);
        currentTimeString = String.valueOf(days + " Days");

        return currentTimeString;
    }

    public static String getDurationDays(Date time) {
        String inputPattern = "yyyy-MM-dd HH:mm:ss",outputPattern = "yyyy-MM-dd";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.US);
        inputFormat.setTimeZone(TimeZone.getDefault());
        String currentTimeString = inputFormat.format(time);

        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.US);
        outputFormat.setTimeZone(TimeZone.getDefault());

        if (currentTimeString == null) {
            return "";
        }
        Calendar mDate = Calendar.getInstance();
        mDate.setTime(time);
        long difference = mDate.getTimeInMillis() - System.currentTimeMillis();
        long minutes = TimeUnit.MILLISECONDS.toMinutes(difference);
        long hours = TimeUnit.MILLISECONDS.toHours(difference);
        long days = TimeUnit.MILLISECONDS.toDays(difference);
        currentTimeString = String.valueOf(days);
        return currentTimeString;
    }



    public static String getFromatedTimeString(Date time) {
        String inputPattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.US);
        inputFormat.setTimeZone(TimeZone.getDefault());
        String currentTimeString = inputFormat.format(time);

        return currentTimeString;
    }



    public static boolean isBeforeNow(String date) {


        String inputPattern = "yyyy-MM-dd", outputPattern = "yyyy-MM-dd";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.US);
        inputFormat.setTimeZone(TimeZone.getDefault());
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.getDefault());
        Date date1 = null;
        Date today = null;

        try {
            date1 = inputFormat.parse(date);
            today = inputFormat.parse(getCurrentDateString());

        } catch (ParseException e) {
            e.printStackTrace();
        }



        return date1.before(today);
    }
    public static int getScreenHeight(Context c) {
        if (screenHeight == 0) {
            WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            screenHeight = size.y;
        }

        return screenHeight;
    }

    public static int getScreenWidth(Context c) {
        if (screenWidth == 0) {
            WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            screenWidth = size.x;
        }

        return screenWidth;
    }

    public static String getDurationfromNow(String dateStr) {
        String time = null;
        //2016-07-27 11:34:38

        String inputPattern = "yyyy-MM-dd HH:mm:ss", outputPattern = "dd/MM/yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.US);
        //inputFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        inputFormat.setTimeZone(TimeZone.getDefault());

        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.US);
        outputFormat.setTimeZone(TimeZone.getDefault());

        Date date = null;
        try {
            date = inputFormat.parse(dateStr);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date == null) {
            return "";
        }
        Calendar mDate = Calendar.getInstance();
        mDate.setTime(date);
        long difference = System.currentTimeMillis() - mDate.getTimeInMillis();
        long minutes = TimeUnit.MILLISECONDS.toMinutes(difference);
        long hourss = TimeUnit.MILLISECONDS.toHours(difference);
        long days = TimeUnit.MILLISECONDS.toDays(difference);
        if (minutes < 60) {
            {
                if (minutes == 0) {
                    time = "Now";
                } else {
                    time = minutes + " Minutes Ago";
                }
            }
            return time;

        } else if (hourss < 24) {
            time = (hourss+1) + " Hours Ago";
            return time;

        } else if (hourss < 24 && hourss<48) {
            time = "Yesterday";
            return time;

        } else if (days >= 1 && days < 7) {
            time = (days) + " Days Ago ";
            return time;

        } else time = outputFormat.format(date) + "";

        return time;
    }


    public static String getFrormatedDayYear(String dateStr) {
        String time = null;
        //2016-07-27 11:34:38

        String inputPattern = "yyyy-MM-dd HH:mm:ss", outputPattern = "MMM yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.US);
        inputFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.US);
        outputFormat.setTimeZone(TimeZone.getDefault());

        Date date = null;
        try {
            date = inputFormat.parse(dateStr);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        time = outputFormat.format(date);

        return time;
    }




    public static String getDurationDays(String dateStr) {
        String time = null;
        //2016-07-27 11:34:38

        String inputPattern = "yyyy-MM-dd", outputPattern = "dd/MM/yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.US);
        inputFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.US);
        outputFormat.setTimeZone(TimeZone.getDefault());

        Date date = null;
        try {
            date = inputFormat.parse(dateStr);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date == null) {
            return "";
        }
        Calendar mDate = Calendar.getInstance();
        mDate.setTime(date);
        long difference = System.currentTimeMillis() - mDate.getTimeInMillis();
        long minutes = TimeUnit.MILLISECONDS.toMinutes(difference);
        long hourss = TimeUnit.MILLISECONDS.toHours(difference);
        long days = TimeUnit.MILLISECONDS.toDays(difference);
         if (hourss < 24) {
            time = "Today";
            return time;

        } else if (days > 1) {
            time = (days) + "";
            return time;

        } else time = outputFormat.format(date) + "";

        return time;
    }


    public static String getDurationNow(String dateStr) {
        String time = null;
        //2016-07-27 11:34:38

        String inputPattern = "yyyy-MM-dd HH:mm:ss", outputPattern = "dd/MM/yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.US);
        inputFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.US);
        outputFormat.setTimeZone(TimeZone.getDefault());

        Date date = null;
        try {
            date = inputFormat.parse(dateStr);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date == null) {
            return "";
        }
        Calendar mDate = Calendar.getInstance();
        mDate.setTime(date);
        long difference = System.currentTimeMillis() - mDate.getTimeInMillis();
        long minutes = TimeUnit.MILLISECONDS.toMinutes(difference);
        long hourss = TimeUnit.MILLISECONDS.toHours(difference);
        long days = TimeUnit.MILLISECONDS.toDays(difference);
        if (minutes < 60) {
            {
                if (minutes == 0) {
                    time = "Now";
                } else {
                    time = minutes + " Minutes Ago";
                }
            }
            return time;

        } else if (hourss < 24) {
            time = (hourss+1) + " Hours Ago";
            return time;

        } else if (hourss < 24 && hourss<48) {
            time = "Yesterday";
            return time;

        } else if (days >= 1 && days < 7) {
            time = (days) + " Days Ago ";
            return time;

        } else time = outputFormat.format(date) + "";

        return time;
    }

    public static long getDurationPerMinutesfromNow(String dateStr) {
        long time = 2;
        //2016-07-27 11:34:38

        String inputPattern = "yyyy-MM-dd HH:mm:ss", outputPattern = "dd/MM/yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.US);
        inputFormat.setTimeZone(TimeZone.getDefault());
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.US);
        outputFormat.setTimeZone(TimeZone.getDefault());

        Date date = null;
        try {
            date = inputFormat.parse(dateStr);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date == null) {
            return 20;
        }
        Calendar mDate = Calendar.getInstance();
        mDate.setTime(date);
        long difference = System.currentTimeMillis() - mDate.getTimeInMillis();
        long minutes = TimeUnit.MILLISECONDS.toMinutes(difference);
        long hourss = TimeUnit.MILLISECONDS.toHours(difference);
        long days = TimeUnit.MILLISECONDS.toDays(difference);

            time = minutes;
            return time;



    }


    public static Date getTimeFromString(String dateStr) {
        //2016-07-27 11:34:38

        String inputPattern = "yyyy-MM-dd",outputPattern = "yyyy-MM-dd";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.US);
        inputFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.US);
        outputFormat.setTimeZone(TimeZone.getDefault());

        Date date = null;
        try {
            if(dateStr.length()==0){
                date = outputFormat.parse(getCurrentTimeString());

            }else {
                date = outputFormat.parse(dateStr);
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }


        Calendar mDate = Calendar.getInstance();
        mDate.setTime(date);


        return date;



    }


    public static String[] ConvertStringToArray(String string) {
        return string.split(",");


    }
    public static String ConvertListToString(List<String> list){

        String listString = "";

        if(list.size()==1){
            listString =  list.get(0);
        }else {
            for (String s : list) {

                if(list.indexOf(s)==list.size()){
                    listString += s;
                }else {
                    listString += s + ",";

                }
            }
        }

        return listString;
    }




}

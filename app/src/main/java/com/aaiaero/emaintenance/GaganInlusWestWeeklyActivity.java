package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class GaganInlusWestWeeklyActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray={};//Copy
    private Spinner[] spinnerArray={};//Copy
    private String thisActivityName = "GaganInlusWestWeeklyActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gagan_inlus_west_weekly);
        //Define and Initialize all EditTexts serially here
        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16,
                editText17, editText18, editText19, editText20, editText21, editText22, editText23, editText24,editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32,
                editText33, editText34, editText35, editText36, editText37, editText38, editText39, editText40, editText41, editText42, editText43, editText44, editText45, editText46, editText47, editText48,
                editText49, editText50, editText51, editText52, editText53, editText54, editText55, editText56, editText57, editText58,editText59, editText60,editText61, editText62,editText63, editText64,
                editText65, editText66, editText67, editText68,editText69, editText70, editText71, editText72, editText73, editText74, editText75, editText76, editText77, editText78, editText79, editText80,
                editText81, editText82, editText83, editText84, editText85, editText86, editText87, editText88,editText89,editText90, editText91, editText92, editText93, editText94;

        editTextArray = new EditText[]{
                editText1 = (EditText) findViewById(R.id.editTextInlusWestWeeklyTime),
                editText2 = (EditText) findViewById(R.id.editTextInlusWestWeeklyClean),
                editText3 = (EditText) findViewById(R.id.editTextInlusWestWeeklyR1PS),
                editText4 = (EditText) findViewById(R.id.editTextInlusWestWeeklyR2PS),
                editText5 = (EditText) findViewById(R.id.editTextInlusWestWeeklyR3PS),
                editText6 = (EditText) findViewById(R.id.editTextInlusWestWeeklyR1WorkStatus),
                editText7 = (EditText) findViewById(R.id.editTextInlusWestWeeklyR2WorkStatus),
                editText8 = (EditText) findViewById(R.id.editTextInlusWestWeeklyR3WorkStatus),
                editText9 = (EditText) findViewById(R.id.editTextInlusWestWeeklyP1AlarmSW),
                editText10 = (EditText) findViewById(R.id.editTextInlusWestWeeklyP2AlarmSW),
                editText11 = (EditText) findViewById(R.id.editTextInlusWestWeeklyP3AlarmSW),
                editText12 = (EditText) findViewById(R.id.editTextInlusWestWeeklyP1TempSW),
                editText13 = (EditText) findViewById(R.id.editTextInlusWestWeeklyP2TempSW),
                editText14 = (EditText) findViewById(R.id.editTextInlusWestWeeklyP3TempSW),
                editText15 = (EditText) findViewById(R.id.editTextInlusWestWeeklyP1BattLED),
                editText16 = (EditText) findViewById(R.id.editTextInlusWestWeeklyP2BattLED),
                editText17 = (EditText) findViewById(R.id.editTextInlusWestWeeklyP3BattLED),
                editText18 = (EditText) findViewById(R.id.editTextInlusWestWeeklyP1FanFail),
                editText19 = (EditText) findViewById(R.id.editTextInlusWestWeeklyP2FanFail),
                editText20 = (EditText) findViewById(R.id.editTextInlusWestWeeklyP3FanFail),
                editText21 = (EditText) findViewById(R.id.editTextInlusWestWeeklyP1AlarmLED),
                editText22 = (EditText) findViewById(R.id.editTextInlusWestWeeklyP2AlarmLED),
                editText23 = (EditText) findViewById(R.id.editTextInlusWestWeeklyP3AlarmLED),
                editText24 = (EditText) findViewById(R.id.editTextInlusWestWeeklyExhaust),
                editText25 = (EditText) findViewById(R.id.editTextInlusWestWeeklyErrorMsg),

                editText26 = (EditText) findViewById(R.id.editTextInlusWestWeeklyLUSInt),
                editText27 = (EditText) findViewById(R.id.editTextInlusWestWeeklyC1Tx),
                editText28 = (EditText) findViewById(R.id.editTextInlusWestWeeklyC5Tx),
                editText29 = (EditText) findViewById(R.id.editTextInlusWestWeeklyRam),
                editText30 = (EditText) findViewById(R.id.editTextInlusWestWeeklyDCVolt),
                editText31 = (EditText) findViewById(R.id.editTextInlusWestWeeklyControlVolt),
                editText32 = (EditText) findViewById(R.id.editTextInlusWestWeeklyGPSStatus),
                editText33 = (EditText) findViewById(R.id.editTextInlusWestWeeklyGPSTime),
                editText34 = (EditText) findViewById(R.id.editTextInlusWestWeeklyACUTime),
                editText35 = (EditText) findViewById(R.id.editTextInlusWestWeeklySolUse),
                editText36 = (EditText) findViewById(R.id.editTextInlusWestWeeklyLockStatus),
                editText37 = (EditText) findViewById(R.id.editTextInlusWestWeeklyRxFreq),
                editText38 = (EditText) findViewById(R.id.editTextInlusWestWeeklyL1Status),
                editText39 = (EditText) findViewById(R.id.editTextInlusWestWeeklyL1Ops),
                editText40 = (EditText) findViewById(R.id.editTextInlusWestWeeklyL2Status),
                editText41 = (EditText) findViewById(R.id.editTextInlusWestWeeklyL2Ops),
                editText42 = (EditText) findViewById(R.id.editTextInlusWestWeeklyCStatus),
                editText43 = (EditText) findViewById(R.id.editTextInlusWestWeeklyCOps),
                editText44 = (EditText) findViewById(R.id.editTextInlusWestWeeklyBlower1),
                editText45 = (EditText) findViewById(R.id.editTextInlusWestWeeklyHVolt1),
                editText46 = (EditText) findViewById(R.id.editTextInlusWestWeeklyHCur1),
                editText47 = (EditText) findViewById(R.id.editTextInlusWestWeeklyBeamVolt1),
                editText48 = (EditText) findViewById(R.id.editTextInlusWestWeeklyBeamCur1),
                editText49 = (EditText) findViewById(R.id.editTextInlusWestWeeklyBodyCur1),
                editText50 = (EditText) findViewById(R.id.editTextInlusWestWeeklyAtt1),
                editText51 = (EditText) findViewById(R.id.editTextInlusWestWeeklyRefPower1),
                editText52 = (EditText) findViewById(R.id.editTextInlusWestWeeklyDiffTemp1),
                editText53 = (EditText) findViewById(R.id.editTextInlusWestWeeklyBlower2),
                editText54 = (EditText) findViewById(R.id.editTextInlusWestWeeklyHVolt2),
                editText55 = (EditText) findViewById(R.id.editTextInlusWestWeeklyHCur2),
                editText56 = (EditText) findViewById(R.id.editTextInlusWestWeeklyBeamVolt2),
                editText57 = (EditText) findViewById(R.id.editTextInlusWestWeeklyBeamCur2),
                editText58 = (EditText) findViewById(R.id.editTextInlusWestWeeklyBodyCur2),
                editText59 = (EditText) findViewById(R.id.editTextInlusWestWeeklyAtt2),
                editText60 = (EditText) findViewById(R.id.editTextInlusWestWeeklyRefPower2),
                editText61 = (EditText) findViewById(R.id.editTextInlusWestWeeklyDiffTemp2),
                editText62 = (EditText) findViewById(R.id.editTextInlusWestWeeklyMCStatus),
                editText63 = (EditText) findViewById(R.id.editTextInlusWestWeeklyMCMon),
                editText64 = (EditText) findViewById(R.id.editTextInlusWestWeeklyRemarks)};

        //Define and Initialize all Switches serially here


        //Define and Initialize all Spinners serially here


        //---------------------To Set View in Current Activity------------------

        TextView textView7 = (TextView) findViewById(R.id.textView7);
        textView7.setText("Name: " + PersonalDetailsActivity.naam);
        TextView textView8 = (TextView) findViewById(R.id.textView8);
        textView8.setText("Designation: " + PersonalDetailsActivity.design);
        TextView textView10 = (TextView) findViewById(R.id.textView118);
        textView10.setText("Emp No.: " + PersonalDetailsActivity.EmpID);
        TextView textView9 = (TextView) findViewById(R.id.textView9);
        textView9.setText("Location: " + MainActivity.latLong1);
        TextView textViewDate = (TextView) findViewById(R.id.textViewDate);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy HH:mm");
        String strData = sdf.format(calendar.getTime());
        textViewDate.setText(strData);

        Intent receivedIntent = getIntent();
        //now get the itemID we passed as an extra
        selectedID = receivedIntent.getIntExtra("id", -1); //NOTE: -1 is just the default value
        if (selectedID == -1) {

        } else {
            //now get the name we passed as an extra
            selectedName = receivedIntent.getStringExtra("name");
            String selectedEditTextData = receivedIntent.getStringExtra("editTextData");
            String selectedSwitchData = receivedIntent.getStringExtra("switchData");
            String selectedSpinnerData = receivedIntent.getStringExtra("spinnerData");
            //Log.i("received Data1 = ", selectedSwitchData);
            //Log.i("received Data2 = ", selectedSpinnerData);
            String[] seperatedData = myFunctions.seperateEditText(selectedEditTextData);
            String[] seperatedSwitchData = myFunctions.seperateSwitchData(selectedSwitchData);
            String[] seperatedSpinnerData = myFunctions.seperateSpinnerData(selectedSpinnerData);

            //Log.d("RxArr=",Arrays.toString(seperatedData));
            myFunctions.putData(seperatedData, editTextArray);
            myFunctions.putSwitchData(seperatedSwitchData, switchArray);
            myFunctions.putSpinnerData(seperatedSpinnerData, spinnerArray);
            //Log.i("received Data = ", selectedEditTextData);

        }

        Button signDocument = (Button) findViewById(R.id.button11) ;
        Button submitSchedule = (Button) findViewById(R.id.button10);

        submitSchedule.setVisibility(View.INVISIBLE);
        signDocument.setVisibility(View.VISIBLE);

        signDocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySignature.dialog_action(submitSchedule, signDocument);


            }
        });

        submitSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generatePDF();
            }
        });
        // Fixed for all activity-------------------------------------------------------------------
    }

    private void generatePDF(){

        // Fixed for all activity-------------------------------------------------------------------

        String outputEditText = myFunctions.getEditTextDataForPDF(editTextArray);

        String[] editTextDataForPDF = myFunctions.seperateEditText(outputEditText);

        //String outputSwitch = myFunctions.getSwitchStatusForPDF(switchArray);

        //String[] switchDataForPDF = myFunctions.seperateSwitchData(outputSwitch);

//        String outputSpinner = myFunctions.getSpinnerStatusForPDF(spinnerArray);
//
//        String[] spinnerDataForPDF = myFunctions.seperateSpinnerData(outputSpinner);

        PdfDocument myPdfdocument = new PdfDocument();

        Paint paint = new Paint();
        Paint titlePaint = new Paint();

        // Change below as per requirement-----------------------------------------------------------
        // crate a page description
        PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(723, 1024, 1).create();

        // start a page
        PdfDocument.Page myPage1 = myPdfdocument.startPage(myPageInfo1);
        Canvas canvas = myPage1.getCanvas();


        Bitmap bmp,scaledbmp;

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.inluswestweekly1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(11);

        int[] editTextXPixel = {590,460,451,514,575,451,514,575,451,514,575,451,514,575,451,514,575,451,514,575,451,514,575,460,
                460,460,460,460,460,460,460,460,460,460,460,460,460,460,460,460,460,460,460,460,460,460,460};
        int[] editTextYPixel = {135,181,227,227,227,242,242,242,274,274,274,290,290,290,304,304,304,321,321,321,336,336,336,375,
                397,427,444,459,474,530,557,612,627,659,674,704,720,751,767,797,812,844,859,891,905,921,937};

        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for(int i = 0; i < editTextXPixel.length; i++){
            canvas.drawText( editTextDataForPDF[i],editTextXPixel[i],editTextYPixel[i],titlePaint);
        }

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
        String strData = sdf.format(calendar.getTime());
        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(12);

        canvas.drawText(strData,556,119,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.inluswestweekly2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel2 = {465,465,465,465,465,465,465,465,465,465,465,465,465,465,465,465,60};
        int[] editTextYPixel2 = {101,116,133,147,163,193,209,224,239,254,271,286,301,317,348,364,450};

        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel.length],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }

        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 75, 525, paint);


        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------

        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Navigation/GAGAN/INLUSWest/Weekly/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Weekly GAGAN INLUS West " + strData + ".pdf"; // Change Here--------------------------
        String targetPdf = directory_path + fileName;
        File filePath = new File(targetPdf);
        try {
            myPdfdocument.writeTo(new FileOutputStream(filePath));
            //Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
            //done = true;
        } catch (IOException e) {
            Log.e("main", "error " + e.toString());
            Toast.makeText(this, "Something wrong: " + e.toString(), Toast.LENGTH_LONG).show();
        }
        myPdfdocument.close();
        String specificCode = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());// Change Here----------------------------
        //This function saves all the data to parse Server
        //myFunctions.saveToParse(String targetPdf, String fileName, String Equipment,String Schedule_Type,String EditTextData)
        myFunctions.saveToParse(targetPdf, fileName,"GAGAN","Weekly",outputEditText,MyFunctions.specificCode("w"),"outputSwitch", "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Weekly Maintenance of GAGAN INLUS West.",//Change Here-----------------------------
                "Maintenance Schedule is attached. Please verify.", targetPdf, fileName);


        myFunctions.toLogoutActivity();
    }

    //Copy this function in your activity completely without any change
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.sub_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Copy this function in your activity completely without any change
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()){

            case R.id.putInDB:
                final AlertDialog.Builder alert = new AlertDialog.Builder(this);
                View mView = getLayoutInflater().inflate(R.layout.custom_dialog,null);
                final EditText desiredFormName = (EditText)mView.findViewById(R.id.txt_input);
                Button btn_cancel = (Button)mView.findViewById(R.id.btn_cancel);
                Button btn_okay = (Button)mView.findViewById(R.id.btn_okay);
                alert.setView(mView);
                final AlertDialog alertDialog = alert.create();
                alertDialog.setCanceledOnTouchOutside(false);
                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                btn_okay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        View view = findViewById(R.id.putInDB);
                        String formName = desiredFormName.getText().toString();
                        myFunctions.addToDB(view ,editTextArray,switchArray,spinnerArray,formName, thisActivityName);
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
                return true;

            case R.id.deleteFromDB:
                View view1 = findViewById(R.id.deleteFromDB);
                new AlertDialog.Builder(this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Delete Alert")
                        .setMessage("Do you really want to delete this entry permanently from Local DB?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                myFunctions.deleteFromDB(view1, selectedID, selectedName);
                                Intent intent = new Intent(getApplicationContext(),ListDataActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;

            case R.id.showDB:
                Intent intent = new Intent(getApplicationContext(),ListDataActivity.class);
                startActivity(intent);
                return true;

            case R.id.logout:
                myFunctions.toLogoutActivity();
                return true;

            default:
                return false;
        }
    }

    //----At last don't forget to put an entry in Switch Case of ListDataActivity.java------------
}
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

public class LlzNormarc7000WeeklyActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray = {};//Copy
    private Spinner[] spinnerArray = {};//Copy
    private String thisActivityName = "LlzNormarc7000WeeklyActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llz_normarc7000_weekly);
        //Define and Initialize all EditTexts serially here
        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16,
                editText17, editText18, editText19, editText20, editText21, editText22, editText23, editText24,editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32,
                editText33, editText34, editText35, editText36, editText37, editText38, editText39, editText40, editText41, editText42, editText43, editText44, editText45, editText46, editText47, editText48,
                editText49, editText50, editText51, editText52, editText53, editText54, editText55, editText56, editText57, editText58,editText59, editText60,editText61, editText62,editText63, editText64,
                editText65, editText66, editText67, editText68,editText69, editText70, editText71, editText72, editText73, editText74, editText75, editText76, editText77, editText78, editText79, editText80,
                editText81, editText82, editText83, editText84;

        editTextArray = new EditText[]{
                editText1 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyStation),
                editText2 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyModel),
                editText3 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyRWY),
                editText4 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCat),
                editText5 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyFrequency),
                editText6 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyIdent),
                editText7 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyTimeObs),
                editText8 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyTimeILS),
                editText9 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyTime),
                editText10 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCourseTx1),
                editText11 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCourseTx2),
                editText12 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCourseShiftTx1),
                editText13 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCourseShiftTx2),
                editText14 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyDisSenTx1),
                editText15 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyDisSenTx2),
                editText16 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCLRSigTx1),
                editText17 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCLRSigTx2),
                editText18 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyRedPowerTx1),
                editText19 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyRedPowerTx2),
                editText20 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyTotalTimeTx1),
                editText21 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyTotalTimeTx2),
                editText22 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyUPSVolt1),
                editText23 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyUPSVolt2),
                editText24 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyUPSFreq1),
                editText25 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyUPSFreq2),
                editText26 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyBatteryVolt1),
                editText27 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyBatteryVolt2),

                editText28 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyDevCL1),
                editText29 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyDevCL2),
                editText30 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyDevSW901),
                editText31 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyDevSW902),
                editText32 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyDevSW1501),
                editText33 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyDevSW1502),
                editText34 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyDevRF1),
                editText35 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyDevRF2),
                editText36 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyDevDDM901),
                editText37 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyDevDDM902),
                editText38 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyDevDDM1501),
                editText39 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyDevDDM1502),
                editText40 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCRSPA1),
                editText41 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCRSPA2),
                editText42 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCRSCSB1),
                editText43 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCRSCSB2),
                editText44 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCRSSBO1),
                editText45 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCRSSBO2),
                editText46 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCRSPH1),
                editText47 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCRSPH2),
                editText48 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCLRPA1),
                editText49 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCLRPA2),
                editText50 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCLRCSB1),
                editText51 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCLRCSB2),
                editText52 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCLRSBO1),
                editText53 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCLRSBO2),
                editText54 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCLRPH1),
                editText55 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCLRPH2),
                editText56 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyRMS1),
                editText57 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyRMS2),
                editText58 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyRMSB1),
                editText59 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyRMSB2),
                editText60 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyPS11),
                editText61 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyPS12),
                editText62 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyPS21),
                editText63 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyPS22),
                editText64 = (EditText) findViewById(R.id.editTextLlzNormarcWeekly5PS11),
                editText65 = (EditText) findViewById(R.id.editTextLlzNormarcWeekly5PS12),
                editText66 = (EditText) findViewById(R.id.editTextLlzNormarcWeekly5PS21),
                editText67 = (EditText) findViewById(R.id.editTextLlzNormarcWeekly5PS22),
                editText68 = (EditText) findViewById(R.id.editTextLlzNormarcWeekly8PS11),
                editText69 = (EditText) findViewById(R.id.editTextLlzNormarcWeekly8PS12),
                editText70 = (EditText) findViewById(R.id.editTextLlzNormarcWeekly8PS21),
                editText71 = (EditText) findViewById(R.id.editTextLlzNormarcWeekly8PS22),
                editText72 = (EditText) findViewById(R.id.editTextLlzNormarcWeekly15PS11),
                editText73 = (EditText) findViewById(R.id.editTextLlzNormarcWeekly15PS12),
                editText74 = (EditText) findViewById(R.id.editTextLlzNormarcWeekly15PS21),
                editText75 = (EditText) findViewById(R.id.editTextLlzNormarcWeekly15PS22),
                editText76 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCLR1501),
                editText77 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCLR1502),
                editText78 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCLR901),
                editText79 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCLR902),
                editText80 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCOU1501),
                editText81 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCOU1502),
                editText82 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCOU901),
                editText83 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyCOU902),
                editText84 = (EditText) findViewById(R.id.editTextLlzNormarcWeeklyRemarks)};

        //Define and Initialize all Switches serially here
        Switch  switch1,switch2,switch3,switch4,switch5,switch6,switch7,switch8;
        switchArray = new Switch[]{
                switch1 = (Switch) findViewById(R.id.switchLlzNormarcWeeklyChangeOver),
                switch2 = (Switch) findViewById(R.id.switchLlzNormarcWeeklyControlFun),
                switch3 = (Switch) findViewById(R.id.switchLlzNormarcWeeklyCLIdent1),
                switch4 = (Switch) findViewById(R.id.switchLlzNormarcWeeklyCLIdent2),
                switch5 = (Switch) findViewById(R.id.switchLlzNormarcWeeklyCLRIdent1),
                switch6 = (Switch) findViewById(R.id.switchLlzNormarcWeeklyCLRIdent2),
                switch7 = (Switch) findViewById(R.id.switchLlzNormarcWeeklySelf1),
                switch8 = (Switch) findViewById(R.id.switchLlzNormarcWeeklySelf2)};

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

        String outputSwitch = myFunctions.getSwitchStatusForPDF(switchArray);

        String[] switchDataForPDF = myFunctions.seperateSwitchData(outputSwitch);

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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llznormarc7000weekly1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel = {152,574,124,218,353,490,465,465,465,375,475,405,491,405,491,405,491,405,491};
        int[] editTextYPixel = {145,145,165,165,165,165,205,222,240,378,378,585,585,660,660,715,715,800,800};

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

        canvas.drawText(strData,577,165,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llznormarc7000weekly2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel2 = {405,487,315,467,315,467,315,467,480,567,480,567,480,567,480,567,480,567,480,567,358,470,358,470,358,470,358,470,358,470,358,470,358,470,358,470};
        int[] editTextYPixel2 = {115,115,200,200,232,232,263,263,597,597,614,614,630,630,645,645,662,662,677,677,750,750,768,768,795,795,836,836,873,873,891,891,909,909,929,929};

        int[] switchXPixel = {455,455,375,490,375,490,375,490};
        int[] switchYPixel = {354,376,457,457,474,474,489,489};


        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel.length],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }
        for(int i = 0; i < switchXPixel.length; i++){
            canvas.drawText( switchDataForPDF[i],switchXPixel[i],switchYPixel[i],titlePaint);
        }
        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------
        //----------------------Page 3---------------------

        PdfDocument.PageInfo myPageInfo3 = new PdfDocument.PageInfo.Builder(723, 1024, 3).create();

        // start a page
        PdfDocument.Page myPage3 = myPdfdocument.startPage(myPageInfo3);

        canvas = myPage3.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llznormarc7000weekly3);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel3 = {348,465,348,465,348,465,348,465,348,465,348,465,348,465,348,465,348,465,348,465,348,465,348,465,348,465,348,465,100};
        int[] editTextYPixel3 = {153,153,183,183,221,221,248,248,275,275,299,299,326,326,351,351,377,377,405,405,430,430,457,457,483,483,510,510,550};


        for(int i = 0; i < editTextXPixel3.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel.length+editTextXPixel2.length],editTextXPixel3[i],editTextYPixel3[i],titlePaint);
        }

        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 100, 600, paint);

        myPdfdocument.finishPage(myPage3);

        //-------------------------End of Page 3-----------------


        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Navigation/LLZNormarc7000/Weekly/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Weekly LLZ Normarc " + strData + ".pdf"; // Change Here--------------------------
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
        myFunctions.saveToParse(targetPdf, fileName,"ILS","Weekly",outputEditText,MyFunctions.specificCode("w"),outputSwitch, "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Weekly Maintenance of Normarc LLZ done.",//Change Here-----------------------------
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
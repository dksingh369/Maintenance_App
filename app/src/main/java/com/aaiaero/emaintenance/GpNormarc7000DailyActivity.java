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

public class GpNormarc7000DailyActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray = {};//Copy
    private Spinner[] spinnerArray = {};//Copy
    private String thisActivityName = "GpNormarc7000DailyActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gp_normarc7000_daily);
        //Define and Initialize all EditTexts serially here
        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16,
                editText17, editText18, editText19, editText20, editText21, editText22, editText23, editText24,editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32,
                editText33, editText34, editText35, editText36, editText37, editText38, editText39, editText40, editText41, editText42, editText43, editText44, editText45, editText46, editText47, editText48,
                editText49, editText50, editText51, editText52, editText53, editText54, editText55, editText56, editText57, editText58,editText59, editText60,editText61, editText62,editText63, editText64,
                editText65, editText66, editText67, editText68,editText69, editText70, editText71, editText72, editText73, editText74, editText75, editText76, editText77, editText78, editText79, editText80,
                editText81, editText82, editText83, editText84, editText85, editText86, editText87, editText88,editText89,editText90, editText91, editText92, editText93, editText94, editText95, editText96, editText97, editText98;

        editTextArray = new EditText[]{
                editText1 = (EditText) findViewById(R.id.editTextGpNormarcDailyStation),
                editText2 = (EditText) findViewById(R.id.editTextGpNormarcDailyModel),
                editText3 = (EditText) findViewById(R.id.editTextGpNormarcDailyRWY),
                editText4 = (EditText) findViewById(R.id.editTextGpNormarcDailyCat),
                editText5 = (EditText) findViewById(R.id.editTextGpNormarcDailyFrequency),
                editText6 = (EditText) findViewById(R.id.editTextGpNormarcDailyRoomTemp),
                editText7 = (EditText) findViewById(R.id.editTextGpNormarcDailyHumidity),
                editText8 = (EditText) findViewById(R.id.editTextGpNormarcDailyMainsVoltage),
                editText9 = (EditText) findViewById(R.id.editTextGpNormarcDailyMainsFreq),
                editText10 = (EditText) findViewById(R.id.editTextGpNormarcDailyTxOnAir),
                editText11 = (EditText) findViewById(R.id.editTextGpNormarcDailyCLDDMMainMon1),
                editText12 = (EditText) findViewById(R.id.editTextGpNormarcDailyCLDDMMainMon2),
                editText13 = (EditText) findViewById(R.id.editTextGpNormarcDailyCLDDMStbMon1),
                editText14 = (EditText) findViewById(R.id.editTextGpNormarcDailyCLDDMStbMon2),
                editText15 = (EditText) findViewById(R.id.editTextGpNormarcDailyCLSDMMainMon1),
                editText16 = (EditText) findViewById(R.id.editTextGpNormarcDailyCLSDMMainMon2),
                editText17 = (EditText) findViewById(R.id.editTextGpNormarcDailyCLSDMStbMon1),
                editText18 = (EditText) findViewById(R.id.editTextGpNormarcDailyCLSDMStbMon2),
                editText19 = (EditText) findViewById(R.id.editTextGpNormarcDailyCLRFMainMon1),
                editText20 = (EditText) findViewById(R.id.editTextGpNormarcDailyCLRFMainMon2),
                editText21 = (EditText) findViewById(R.id.editTextGpNormarcDailyCLRFStbMon1),
                editText22 = (EditText) findViewById(R.id.editTextGpNormarcDailyCLRFStbMon2),
                editText23 = (EditText) findViewById(R.id.editTextGpNormarcDailyDSDDMMainMon1),
                editText24 = (EditText) findViewById(R.id.editTextGpNormarcDailyDSDDMMainMon2),
                editText25 = (EditText) findViewById(R.id.editTextGpNormarcDailyDSDDMStbMon1),
                editText26 = (EditText) findViewById(R.id.editTextGpNormarcDailyDSDDMStbMon2),
                editText27 = (EditText) findViewById(R.id.editTextGpNormarcDailyDSSDMMainMon1),
                editText28 = (EditText) findViewById(R.id.editTextGpNormarcDailyDSSDMMainMon2),
                editText29 = (EditText) findViewById(R.id.editTextGpNormarcDailyDSSDMStbMon1),
                editText30 = (EditText) findViewById(R.id.editTextGpNormarcDailyDSSDMStbMon2),
                editText31 = (EditText) findViewById(R.id.editTextGpNormarcDailyDSRFMainMon1),
                editText32 = (EditText) findViewById(R.id.editTextGpNormarcDailyDSRFMainMon2),
                editText33 = (EditText) findViewById(R.id.editTextGpNormarcDailyDSRFStbMon1),
                editText34 = (EditText) findViewById(R.id.editTextGpNormarcDailyDSRFStbMon2),
                editText35 = (EditText) findViewById(R.id.editTextGpNormarcDailyNFDDMMainMon1),
                editText36 = (EditText) findViewById(R.id.editTextGpNormarcDailyNFDDMMainMon2),
                editText37 = (EditText) findViewById(R.id.editTextGpNormarcDailyNFDDMStbMon1),
                editText38 = (EditText) findViewById(R.id.editTextGpNormarcDailyNFDDMStbMon2),
                editText39 = (EditText) findViewById(R.id.editTextGpNormarcDailyNFSDMMainMon1),
                editText40 = (EditText) findViewById(R.id.editTextGpNormarcDailyNFSDMMainMon2),
                editText41 = (EditText) findViewById(R.id.editTextGpNormarcDailyNFSDMStbMon1),
                editText42 = (EditText) findViewById(R.id.editTextGpNormarcDailyNFSDMStbMon2),
                editText43 = (EditText) findViewById(R.id.editTextGpNormarcDailyNFRFMainMon1),
                editText44 = (EditText) findViewById(R.id.editTextGpNormarcDailyNFRFMainMon2),
                editText45 = (EditText) findViewById(R.id.editTextGpNormarcDailyNFRFStbMon1),
                editText46 = (EditText) findViewById(R.id.editTextGpNormarcDailyNFRFStbMon2),
                editText47 = (EditText) findViewById(R.id.editTextGpNormarcDailyCLRDDMMainMon1),
                editText48 = (EditText) findViewById(R.id.editTextGpNormarcDailyCLRDDMMainMon2),
                editText49 = (EditText) findViewById(R.id.editTextGpNormarcDailyCLRDDMStbMon1),
                editText50 = (EditText) findViewById(R.id.editTextGpNormarcDailyCLRDDMStbMon2),
                editText51 = (EditText) findViewById(R.id.editTextGpNormarcDailyCLRSDMMainMon1),
                editText52 = (EditText) findViewById(R.id.editTextGpNormarcDailyCLRSDMMainMon2),
                editText53 = (EditText) findViewById(R.id.editTextGpNormarcDailyCLRSDMStbMon1),
                editText54 = (EditText) findViewById(R.id.editTextGpNormarcDailyCLRSDMStbMon2),
                editText55 = (EditText) findViewById(R.id.editTextGpNormarcDailyCLRRFMainMon1),
                editText56 = (EditText) findViewById(R.id.editTextGpNormarcDailyCLRRFMainMon2),
                editText57 = (EditText) findViewById(R.id.editTextGpNormarcDailyCLRRFStbMon1),
                editText58 = (EditText) findViewById(R.id.editTextGpNormarcDailyCLRRFStbMon2),
                editText59 = (EditText) findViewById(R.id.editTextGpNormarcDailyDfMon1),
                editText60 = (EditText) findViewById(R.id.editTextGpNormarcDailyDfMon2),
                editText61 = (EditText) findViewById(R.id.editTextGpNormarcDailySMPSPS1),
                editText62 = (EditText) findViewById(R.id.editTextGpNormarcDailySMPSPS2),
                editText63 = (EditText) findViewById(R.id.editTextGpNormarcDailyRemarks)};

        //Define and Initialize all Switches serially here
        Switch  switch1,switch2,switch3,switch4,switch5,switch6,switch7,switch8,switch9,switch10,switch11,switch12,
                switch13,switch14,switch15,switch16,switch17,switch18,switch19,switch20,switch21,switch22,switch23,switch24,switch25;
        switchArray = new Switch[]{
                switch1 = (Switch) findViewById(R.id.switchGpNormarcDailyRoomClean),
                switch2 = (Switch) findViewById(R.id.switchGpNormarcDailyStatusAc),
                switch3 = (Switch) findViewById(R.id.switchGpNormarcDailyStatusMast),
                switch4 = (Switch) findViewById(R.id.switchGpNormarcDailyEquipmentHoldsOnUps),
                switch5 = (Switch) findViewById(R.id.switchGpNormarcDailyStatusMonitorExe),
                switch6 = (Switch) findViewById(R.id.switchGpNormarcDailyStatusMonitorStandby),
                switch7 = (Switch) findViewById(R.id.switchGpNormarcDailyStatusNearField),
                switch8 = (Switch) findViewById(R.id.switchGpNormarcDailyStatusBirdSpike),
                switch9 = (Switch) findViewById(R.id.switchGpNormarcDailyStatusCriticalArea),
                switch10 = (Switch) findViewById(R.id.switchGpNormarcDailyRemoteStatusER),
                switch11 = (Switch) findViewById(R.id.switchGpNormarcDailyRemoteStatusAtc),
                switch12 = (Switch) findViewById(R.id.switchGpNormarcDailyParam),
                switch13 = (Switch) findViewById(R.id.switchGpNormarcDailyDisagr),
                switch14= (Switch) findViewById(R.id.switchGpNormarcDailyBatt),
                switch15 = (Switch) findViewById(R.id.switchGpNormarcDailyIdent),
                switch16 = (Switch) findViewById(R.id.switchGpNormarcDailyMaint),
                switch17 = (Switch) findViewById(R.id.switchGpNormarcDailyStandby),
                switch18 = (Switch) findViewById(R.id.switchGpNormarcDailyCourseTx1),
                switch19 = (Switch) findViewById(R.id.switchGpNormarcDailyCourseTx2),
                switch20 = (Switch) findViewById(R.id.switchGpNormarcDailyClearanceTx1),
                switch21 = (Switch) findViewById(R.id.switchGpNormarcDailyClearanceTx2),
                switch22 = (Switch) findViewById(R.id.switchGpNormarcDailyTxtoAirTx1),
                switch23 = (Switch) findViewById(R.id.switchGpNormarcDailyTxtoAirTx2),
                switch24 = (Switch) findViewById(R.id.switchGpNormarcDailyMainTx1),
                switch25 = (Switch) findViewById(R.id.switchGpNormarcDailyMainTx2)};

        //Define and Initialize all Spinners serially here

        // Fixed for all the activity---------------------------------------------------------------
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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.gpnormarc7000daily1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel = {153,591,129,227,364,555,555,555,555,555,340,421,502,584,340,421,502,584,340,421,502,584,340,421,502,584,340,421,502,584,340,421,502,584,
                340,421,502,584,340,421,502,584,340,421,502,584};
        int[] editTextYPixel = {150,150,169,169,169,295,318,340,373,415,698,698,698,698,733,733,733,733,760,760,760,760,785,785,785,785,815,815,815,815,843,843,843,843,
                871,871,871,871,908,908,908,908,938,938,938,938};

        int[] switchXPixel = {555,555,555,555,555,555,555,555,555,555,555};
        int[] switchYPixel = {242,258,274,393,433,445,468,493,520,541,555};


        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for(int i = 0; i < editTextXPixel.length; i++){
            canvas.drawText( editTextDataForPDF[i],editTextXPixel[i],editTextYPixel[i],titlePaint);
        }

        for(int i = 0; i < switchXPixel.length; i++){
            canvas.drawText( switchDataForPDF[i],switchXPixel[i],switchYPixel[i],titlePaint);
        }

    /*    for(int i = 0; i < spinnerDataForPDF.length; i++){
            canvas.drawText( spinnerDataForPDF[i],spinnerXPixel[i],spinnerYPixel[i],titlePaint);
        }
*/

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
        String strData = sdf.format(calendar.getTime());
        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(12);

        canvas.drawText(strData,561,169,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.gpnormarc7000daily2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel2 = {339,420,503,584,339,420,503,584,339,420,503,584,367,563};
        int[] editTextYPixel2 = {106,106,106,106,133,133,133,133,162,162,162,162,376,376};

        int[] switchXPixel2 = {380,380,380,380,380,375,480,375,480,375,480};
        int[] switchYPixel2 = {480,530,575,620,666,796,796,842,842,889,889};


        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel.length],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }

        for(int i = 0; i < switchXPixel2.length; i++){
            canvas.drawText( switchDataForPDF[i+switchXPixel.length],switchXPixel2[i],switchYPixel2[i],titlePaint);
        }

        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------
        //----------------------Page 3---------------------

        PdfDocument.PageInfo myPageInfo3 = new PdfDocument.PageInfo.Builder(723, 1024, 3).create();

        // start a page
        PdfDocument.Page myPage3 = myPdfdocument.startPage(myPageInfo3);

        canvas = myPage3.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.gpnormarc7000daily3);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel3 = {365,470};
        int[] editTextYPixel3 = {114,114};

        int[] switchXPixel3 = {455,564,88};
        int[] switchYPixel3 = {222,222,305};


        for(int i = 0; i < editTextXPixel3.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel2.length+editTextXPixel.length],editTextXPixel3[i],editTextYPixel3[i],titlePaint);
        }


        for(int i = 0; i < switchXPixel3.length; i++){
            canvas.drawText( switchDataForPDF[i+switchXPixel2.length+switchXPixel.length],switchXPixel3[i],switchYPixel3[i],titlePaint);
        }

        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 100, 385, paint);


        myPdfdocument.finishPage(myPage3);

        //-------------------------End of Page 3-----------------

        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Navigation/GPNormarc7000/Daily/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Daily GP Normarc " + strData + ".pdf"; // Change Here--------------------------
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
        myFunctions.saveToParse(targetPdf, fileName,"ILS","Daily",outputEditText,MyFunctions.specificCode("d"),outputSwitch, "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Daily Maintenance of Normarc GP done.",//Change Here-----------------------------
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
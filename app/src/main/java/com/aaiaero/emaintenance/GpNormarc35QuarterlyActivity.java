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

public class GpNormarc35QuarterlyActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray = {};//Copy
    private Spinner[] spinnerArray = {};//Copy
    private String thisActivityName = "GpNormarc35QuarterlyActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gp_normarc35_quarterly);
        //Define and Initialize all EditTexts serially here
        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16,
                editText17, editText18, editText19, editText20, editText21, editText22, editText23, editText24,editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32,
                editText33, editText34, editText35, editText36, editText37, editText38, editText39, editText40, editText41, editText42, editText43, editText44, editText45, editText46, editText47, editText48,
                editText49, editText50, editText51, editText52, editText53, editText54, editText55, editText56, editText57;

        editTextArray = new EditText[]{
                editText1 = (EditText) findViewById(R.id.editTextGpNormarc35QuarterlyStation),
                editText2 = (EditText) findViewById(R.id.editTextGpNormarc35QuarterlyRegion),
                editText3 = (EditText) findViewById(R.id.editTextGpNormarc35QuarterlyCat),
                editText4 = (EditText) findViewById(R.id.editTextGpNormarc35QuarterlyModel),
                editText5 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyCRFreqTx1),
                editText6 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyCRFreqTx2),
                editText7 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyCLRFreqTx1),
                editText8 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyCLRFreqTx2),
                editText9 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyToneFreq90Tx1),
                editText10 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyToneFreq90Tx2),
                editText11 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyToneFreq150Tx1),
                editText12 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyToneFreq150Tx2),
                editText13 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyCRCSBTx1),
                editText14 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyCRCSBTx2),
                editText15 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyCRSBOTx1),
                editText16 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyCRSBOTx2),
                editText17 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyCLRCSBTx1),
                editText18 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyCLRCSBTx2),
                editText19 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyCLRSBOTx1),
                editText20 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyCLRSBOTx2),
                editText21 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyCRPowerTx1),
                editText22 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyCRPowerTx2),
                editText23 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyCRDDMTx1),
                editText24 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyCRDDMTx2),
                editText25 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyCRSDMTx1),
                editText26 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyCRSDMTx2),
                editText27 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyCRRFTx1),
                editText28 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyCRRFTx2),
                editText29 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlySBOPowerTx1),
                editText30 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlySBOPowerTx2),
                editText31 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyDDMWidthTx1),
                editText32 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyDDMWidthTx2),
                editText33 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyCLRPowerTx1),
                editText34 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyCLRPowerTx2),
                editText35 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyCLRDDMTx1),
                editText36 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyCLRDDMTx2),
                editText37 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyBattTx1),
                editText38 = (EditText) findViewById(R.id.editTextLlzNormarc35QuarterlyBattTx2),
                editText39 = (EditText) findViewById(R.id.editTextGpNormarc35QuarterlySysER),
                editText40 = (EditText) findViewById(R.id.editTextGpNormarc35QuarterlyAntER),
                editText41 = (EditText) findViewById(R.id.editTextGpNormarc35QuarterlyMonER),
                editText42 = (EditText) findViewById(R.id.editTextGpNormarc35QuarterlyENV),
                editText43 = (EditText) findViewById(R.id.editTextGpNormarc35QuarterlyLPSER),
                editText44 = (EditText) findViewById(R.id.editTextGpNormarc35QuarterlySPDER),
                editText45 = (EditText) findViewById(R.id.editTextGpNormarc35QuarterlyRemarks)};

        //Define and Initialize all Switches serially here
        Switch  switch1,switch2;
        switchArray = new Switch[]{
                switch1 = (Switch) findViewById(R.id.switchGpNormarc35QuarterlyLPSLED),
                switch2 = (Switch) findViewById(R.id.switchGpNormarc35QuarterlySPDLED)};

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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.gpnormarc35quarterly1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel = {203,331,373,427,527,622,527,622,527,622,527,622,527,622,527,622,527,622,527,622,527,622,527,622,527,622,527,622,
                527,622,527,622,527,622,527,622,527,622};
        int[] editTextYPixel = {162,162,213,179,260,260,276,276,293,293,308,308,332,332,363,363,396,396,426,426,450,450,466,466,482,482,497,497,
                514,514,529,529,545,545,561,561,577,577};



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

        canvas.drawText(strData,602,162,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.gpnormarc35quarterly2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        int[] editTextXPixel2 = {490,490,490,490,490,490,118};
        int[] editTextYPixel2 = {171,205,239,273,307,373,440};

        int[] switchXPixel = {490,490};
        int[] switchYPixel = {345,412};

        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel.length],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }

        for(int i = 0; i < switchXPixel.length; i++){
            canvas.drawText( switchDataForPDF[i],switchXPixel[i],switchYPixel[i],titlePaint);
        }

        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 100, 490, paint);

        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------


        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Navigation/GPNormarc35/Quarterly/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Quarterly GP Normarc " + strData + ".pdf"; // Change Here--------------------------
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
        myFunctions.saveToParse(targetPdf, fileName,"ILS","Quarterly",outputEditText,MyFunctions.specificCode("q"),outputSwitch, "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Quarterly Maintenance of Normarc GP done.",//Change Here-----------------------------
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

package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
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

public class SurMssrNgoscoDailyActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray;//Copy
    private Spinner[] spinnerArray;//Copy

    private String thisActivityName = "SurMssrNgoscoDailyActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sur_mssr_ngosco_daily);


        @SuppressLint("UseSwitchCompatOrMaterialCode")

      /* All are serially numbered from 1. Total No.of, Edit texts = 49 (first 48 single line, 1 multiline), switches =10,
            spinners = 7. ,  textviews = 71, Buttons = 2
         */

                //Define and Initialize all EditTexts serially here
                EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10,
                editText11,editText12,editText13,editText14,editText15,editText16,editText17,editText18,editText19,editText20,
                editText21,editText22,editText23,editText24,editText25,editText26,editText27,editText28,editText29,editText30,
                editText31,editText32,editText33,editText34,editText35,editText36,editText37,editText38,editText39,editText40,
                editText41,editText42,editText43,editText44,editText45,editText46,editText47,editText48,editText49;




        editTextArray = new EditText[]{
                editText1 = (EditText) findViewById(R.id.editText1),
                editText2 = (EditText) findViewById(R.id.editText2),
                editText3 = (EditText) findViewById(R.id.editText3),
                editText4 = (EditText) findViewById(R.id.editText4),
                editText5 = (EditText) findViewById(R.id.editText5),
                editText6 = (EditText) findViewById(R.id.editText6),
                editText7 = (EditText) findViewById(R.id.editText7),
                editText8 = (EditText) findViewById(R.id.editText8),
                editText9 = (EditText) findViewById(R.id.editText9),
                editText10 = (EditText) findViewById(R.id.editText10),
                editText11 = (EditText) findViewById(R.id.editText11),
                editText12 = (EditText) findViewById(R.id.editText12),
                editText13 = (EditText) findViewById(R.id.editText13),
                editText14 = (EditText) findViewById(R.id.editText14),
                editText15 = (EditText) findViewById(R.id.editText15),
                editText16 = (EditText) findViewById(R.id.editText16),
                editText17 = (EditText) findViewById(R.id.editText17),
                editText18 = (EditText) findViewById(R.id.editText18),
                editText19 = (EditText) findViewById(R.id.editText19),
                editText20 = (EditText) findViewById(R.id.editText20),
                editText21 = (EditText) findViewById(R.id.editText21),
                editText22 = (EditText) findViewById(R.id.editText22),
                editText23 = (EditText) findViewById(R.id.editText23),
                editText24 = (EditText) findViewById(R.id.editText24),
                editText25 = (EditText) findViewById(R.id.editText25),
                editText26 = (EditText) findViewById(R.id.editText26),
                editText27 = (EditText) findViewById(R.id.editText27),
                editText28 = (EditText) findViewById(R.id.editText28),
                editText29 = (EditText) findViewById(R.id.editText29),
                editText30 = (EditText) findViewById(R.id.editText30),
                editText31 = (EditText) findViewById(R.id.editText31),
                editText32 = (EditText) findViewById(R.id.editText32),
                editText33 = (EditText) findViewById(R.id.editText33),
                editText34 = (EditText) findViewById(R.id.editText34),
                editText35 = (EditText) findViewById(R.id.editText35),
                editText36 = (EditText) findViewById(R.id.editText36),
                editText37 = (EditText) findViewById(R.id.editText37),
                editText38 = (EditText) findViewById(R.id.editText38),
                editText39 = (EditText) findViewById(R.id.editText39),
                editText40 = (EditText) findViewById(R.id.editText40),
                editText41 = (EditText) findViewById(R.id.editText41),
                editText42 = (EditText) findViewById(R.id.editText42),
                editText43 = (EditText) findViewById(R.id.editText43),
                editText44 = (EditText) findViewById(R.id.editText44),
                editText45 = (EditText) findViewById(R.id.editText45),
                editText46 = (EditText) findViewById(R.id.editText46),
                editText47 = (EditText) findViewById(R.id.editText47),
                editText48 = (EditText) findViewById(R.id.editText48),
                editText49 = (EditText) findViewById(R.id.editText49)};


        //Define and Initialize all Switches serially here
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch switch1,switch2,switch3,switch4,switch5,switch6,switch7,switch8,switch9,switch10;

        switchArray = new Switch[]{
                switch1 = (Switch) findViewById(R.id.switch1),
                switch2 = (Switch) findViewById(R.id.switch2),
                switch3 = (Switch) findViewById(R.id.switch3),
                switch4 = (Switch) findViewById(R.id.switch4),
                switch5 = (Switch) findViewById(R.id.switch5),
                switch6 = (Switch) findViewById(R.id.switch6),
                switch7 = (Switch) findViewById(R.id.switch7),
                switch8 = (Switch) findViewById(R.id.switch8),
                switch9 = (Switch) findViewById(R.id.switch9),
                switch10 = (Switch) findViewById(R.id.switch10)};



        //Define and Initialize all Spinners serially here
        Spinner spinner1,spinner2,spinner3,spinner4,spinner5,spinner6,spinner7;

        spinnerArray = new Spinner[]{
                spinner1 = (Spinner) findViewById(R.id.spinner1),
                spinner2 = (Spinner) findViewById(R.id.spinner2),
                spinner3 = (Spinner) findViewById(R.id.spinner3),
                spinner4 = (Spinner) findViewById(R.id.spinner4),
                spinner5 = (Spinner) findViewById(R.id.spinner5),
                spinner6 = (Spinner) findViewById(R.id.spinner6),
                spinner7 = (Spinner) findViewById(R.id.spinner7)};


        //---------------------To Set View in Current Activity------------------

        TextView Name = (TextView) findViewById(R.id.textView3);
        Name.setText("Name: " + PersonalDetailsActivity.naam);
        TextView Desig = (TextView) findViewById(R.id.textView4);
        Desig.setText("Designation: " + PersonalDetailsActivity.design);
        TextView EmpNo = (TextView) findViewById(R.id.textView5);
        EmpNo.setText("Emp No.: " + PersonalDetailsActivity.EmpID);
        TextView Location = (TextView) findViewById(R.id.textView6);
        Location.setText("Location: " + MainActivity.latLong1);

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

        Button signDocument = (Button) findViewById(R.id.button2) ;
        Button submitSchedule = (Button) findViewById(R.id.button1);

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

    }// End of OnCreate

    private void generatePDF(){

        // Fixed for all activity-------------------------------------------------------------------

        String outputEditText = myFunctions.getEditTextDataForPDF(editTextArray);

        String[] editTextDataForPDF = myFunctions.seperateEditText(outputEditText);

        String outputSwitch = myFunctions.getSwitchStatusForPDF(switchArray);

        String[] switchDataForPDF = myFunctions.seperateSwitchData(outputSwitch);

        String outputSpinner = myFunctions.getSpinnerStatusForPDF(spinnerArray);

        String[] spinnerDataForPDF = myFunctions.seperateSpinnerData(outputSpinner);

        PdfDocument myPdfdocument = new PdfDocument();

        Paint paint = new Paint();
        Paint titlePaint = new Paint();

        // Change below as per requirement-----------------------------------------------------------
        // crate a page description
        PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(723, 1023, 1).create();

        // initialising canvas & bitmap and start of page 1
        PdfDocument.Page myPage1 = myPdfdocument.startPage(myPageInfo1);
        Canvas canvas = myPage1.getCanvas();


        Bitmap bmp,scaledbmp;

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.mssrdaily1);

        //Bitmap decoded1 = getResizedBitmap(bmp,1000);

        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(13);
        paint.setTextAlign(Paint.Align.LEFT);

        //--------------------------------Change as per your requirement------------------------------------------------------
        //canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,210, false), 1325, 2720, paint);
        titlePaint.setTextSize(13);

        int[] editTextXPixel1 = {378,400,400,400,400};
        int[] editTextYPixel1 = {205,566,790,830,885};

        int[] switchXPixel1 = {400,400,400,400,400,400,400,400,400,400};
        int[] switchYPixel1 = {319,400,432,468,493,530,610,641,710,750};

        int[] spinnerXPixel1 = {400};
        int[] spinnerYPixel1 = {350};

        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for(int i = 0; i < editTextXPixel1.length; i++){
            canvas.drawText( editTextDataForPDF[i],editTextXPixel1[i],editTextYPixel1[i],titlePaint);
        }

        for(int i = 0; i < switchXPixel1.length; i++){
            canvas.drawText( switchDataForPDF[i],switchXPixel1[i],switchYPixel1[i],titlePaint);
        }

        for(int i = 0; i < spinnerXPixel1.length; i++){
            canvas.drawText( spinnerDataForPDF[i],spinnerXPixel1[i],spinnerYPixel1[i],titlePaint);
        }


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
        String strData = sdf.format(calendar.getTime());
        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(13);

        canvas.drawText(strData,572,206,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1----------------

        //---------------------start a Page 2---------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1023, 2).create();
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);
        canvas = myPage2.getCanvas();

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.mssrdaily2);

        //Bitmap decoded1 = getResizedBitmap(bmp,1000);

        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(13);
        paint.setTextAlign(Paint.Align.LEFT);

        //--------------------------------Change as per your requirement------------------------------------------------------

        titlePaint.setTextSize(13);

        int[] editTextXPixel2 = {400,400,400,400,400,400,400,400,400,400,
                400,400,400,400,400,400,400,400,400,400,
                400,400,400,400,400,400,400,400,400};

        int[] editTextYPixel2 = {130,150,174,198,222,246,273,304,325,350,
                375,400,425,450,475,500,527,552,577,602,
                627,679,710,740,770,800,832,870,900};


        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+ editTextXPixel1.length],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }




        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(13);


        myPdfdocument.finishPage(myPage2);


        //---------------------End of Page 2---------------

        //---------------------start a Page 3---------------

        PdfDocument.PageInfo myPageInfo3 = new PdfDocument.PageInfo.Builder(723, 1023, 3).create();
        PdfDocument.Page myPage3 = myPdfdocument.startPage(myPageInfo3);
        canvas = myPage3.getCanvas();


        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.mssrdaily3);

        //Bitmap decoded1 = getResizedBitmap(bmp,1000);

        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(13);
        paint.setTextAlign(Paint.Align.LEFT);

        //--------------------------------Change as per your requirement------------------------------------------------------
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 366, 728, paint);
        titlePaint.setTextSize(13);

        int[] editTextXPixel3 = {400,400,400,400,400,400,400,400,400,400,
                400,400,400,400,351};
        int[] editTextYPixel3 = {122,150,175,200,227,250,277,305,330,357,
                382,407,433,460,632};


        int[] spinnerXPixel3 = {400,400,400,400,400,400};
        int[] spinnerYPixel3 = {505,530,552,574,595,612};

        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for(int i = 0; i < editTextXPixel3.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel1.length+editTextXPixel2.length],editTextXPixel3[i],editTextYPixel3[i],titlePaint);
        }


        for(int i = 0; i < spinnerXPixel3.length; i++){
            canvas.drawText( spinnerDataForPDF[i+spinnerXPixel1.length],spinnerXPixel3[i],spinnerYPixel3[i],titlePaint);
        }

        canvas.drawText(strData,400,713,titlePaint);//Printing Date on PDF

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(13);

        myPdfdocument.finishPage(myPage3);

        //-------------------------End of Page 3-----------------



        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Surveillance/MSSR/Daily/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Daily MSSR " + strData + ".pdf"; // Change Here--------------------------
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
        myFunctions.saveToParse(targetPdf, fileName,"MSSR","Daily",outputEditText,MyFunctions.specificCode("d"),outputSwitch, outputSpinner);

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Daily Maintenance of NGOSCO MSSR done.",//Change Here-----------------------------
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



}
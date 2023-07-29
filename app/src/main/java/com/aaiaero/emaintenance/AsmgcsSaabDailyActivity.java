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

public class AsmgcsSaabDailyActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray={};//Copy
    private Spinner[] spinnerArray={};//Copy
    private String thisActivityName = "AsmgcsSaabDailyActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asmgcs_saab_daily);
        //Define and Initialize all EditTexts serially here
        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16,
                editText17, editText18, editText19,editText20, editText21, editText22, editText23, editText24, editText25, editText26, editText27,editText28, editText29, editText30, editText31, editText32, editText33, editText34, editText35,
                editText36, editText37,editText38, editText39, editText40, editText41, editText42, editText43, editText44, editText45,editText46, editText47, editText48, editText49, editText50, editText51, editText52, editText53,
                editText54, editText55, editText56, editText57, editText58, editText59, editText60, editText61, editText62, editText63,editText64,editText65, editText66, editText67,editText68, editText69, editText70, editText71, editText72, editText73, editText74, editText75,
                editText76, editText77,editText78, editText79, editText80, editText81, editText82, editText83, editText84, editText85,editText86, editText87, editText88, editText89, editText90, editText91, editText92, editText93,
                editText94, editText95, editText96, editText97, editText98, editText99, editText100, editText101, editText102, editText103,editText104, editText105,editText106, editText107, editText108, editText109, editText110, editText111, editText112, editText113,
                editText114, editText115, editText116, editText117;

        editTextArray =  new EditText[] { editText1 = (EditText) findViewById(R.id.editText2),
                editText2 = (EditText) findViewById(R.id.editText3),
                editText3 = (EditText) findViewById(R.id.editText4),
                editText4 = (EditText) findViewById(R.id.editText5),
                editText5 = (EditText) findViewById(R.id.editText6),
                editText6 = (EditText) findViewById(R.id.editText7),
                editText7 = (EditText) findViewById(R.id.editText8),
                editText8 = (EditText) findViewById(R.id.editText9),
                editText9 = (EditText) findViewById(R.id.editText10),
                editText10 =(EditText) findViewById(R.id.editText11),
                editText11 =(EditText)  findViewById(R.id.editText12),
                editText12 = (EditText) findViewById(R.id.editText13),
                editText13 =(EditText)  findViewById(R.id.editText14),
                editText14 = (EditText) findViewById(R.id.editText15),
                editText15 = (EditText) findViewById(R.id.editText16),
                editText16 = (EditText) findViewById(R.id.editText17),
                editText17 = (EditText) findViewById(R.id.editText18),
                editText18 = (EditText) findViewById(R.id.editText19),
                editText19 = (EditText) findViewById(R.id.editText20),
                editText20 = (EditText) findViewById(R.id.editText21),
                editText21 = (EditText) findViewById(R.id.editText22),
                editText22 = (EditText) findViewById(R.id.editText23),
                editText23 = (EditText) findViewById(R.id.editText24),
                editText24 = (EditText) findViewById(R.id.editText25),
                editText25 = (EditText) findViewById(R.id.editText26),
                editText26 = (EditText) findViewById(R.id.editText27),
                editText27 = (EditText) findViewById(R.id.editText28),
                editText28 =(EditText) findViewById(R.id.editText29),
                editText29 =(EditText)  findViewById(R.id.editText30),
                editText30 = (EditText) findViewById(R.id.editText31),
                editText31 =(EditText)  findViewById(R.id.editText32),
                editText32 = (EditText) findViewById(R.id.editText33),
                editText33 = (EditText) findViewById(R.id.editText34),
                editText34 = (EditText) findViewById(R.id.editText35),
                editText35 = (EditText) findViewById(R.id.editText36),
                editText36 = (EditText) findViewById(R.id.editText37),
                editText37 = (EditText) findViewById(R.id.editText38),
                editText38 = (EditText) findViewById(R.id.editText39),
                editText39 = (EditText) findViewById(R.id.editText40),
                editText40 = (EditText) findViewById(R.id.editText41),
                editText41 = (EditText) findViewById(R.id.editText42),
                editText42 = (EditText) findViewById(R.id.editText43),
                editText43 = (EditText) findViewById(R.id.editText44),
                editText44 = (EditText) findViewById(R.id.editText45),
                editText45 = (EditText) findViewById(R.id.editText46),
                editText46 =(EditText) findViewById(R.id.editText47),
                editText47 =(EditText)  findViewById(R.id.editText48),
                editText48 = (EditText) findViewById(R.id.editText49),
                editText49 =(EditText)  findViewById(R.id.editText50),
                editText50 = (EditText) findViewById(R.id.editText51),
                editText51 = (EditText) findViewById(R.id.editText52),
                editText52 = (EditText) findViewById(R.id.editText53),
                editText53 = (EditText) findViewById(R.id.editText54),
                editText54 = (EditText) findViewById(R.id.editText55),
                editText55 = (EditText) findViewById(R.id.editText56),
                editText56 = (EditText) findViewById(R.id.editText57),
                editText57 = (EditText) findViewById(R.id.editText58),
                editText58 = (EditText) findViewById(R.id.editText59),
                editText59 = (EditText) findViewById(R.id.editText60),
                editText60 = (EditText) findViewById(R.id.editText61),
                editText61 = (EditText) findViewById(R.id.editText62),
                editText62 = (EditText) findViewById(R.id.editText63),
                editText63 = (EditText) findViewById(R.id.editText64),
                editText64 = (EditText) findViewById(R.id.editText65),
                editText65 = (EditText) findViewById(R.id.editText66),
                editText66 = (EditText) findViewById(R.id.editText67),
                editText67 = (EditText) findViewById(R.id.editText68),
                editText68 = (EditText) findViewById(R.id.editText69),
                editText69 = (EditText) findViewById(R.id.editText70),
                editText70 = (EditText) findViewById(R.id.editText71),
                editText71 = (EditText) findViewById(R.id.editText72),
                editText72 = (EditText) findViewById(R.id.editText73),
                editText73 = (EditText) findViewById(R.id.editText74),
                editText74 = (EditText) findViewById(R.id.editText75),
                editText75 = (EditText) findViewById(R.id.editText76),
                editText76 = (EditText) findViewById(R.id.editText77),
                editText77 = (EditText) findViewById(R.id.editText78),
                editText78 =(EditText) findViewById(R.id.editText79),
                editText79 =(EditText)  findViewById(R.id.editText80),
                editText80 = (EditText) findViewById(R.id.editText81),
                editText81 =(EditText)  findViewById(R.id.editText82),
                editText82 = (EditText) findViewById(R.id.editText83),
                editText83 = (EditText) findViewById(R.id.editText84),
                editText84 = (EditText) findViewById(R.id.editText85),
                editText85 = (EditText) findViewById(R.id.editText86),
                editText86 = (EditText) findViewById(R.id.editText87),
                editText87 = (EditText) findViewById(R.id.editText88),
                editText88 = (EditText) findViewById(R.id.editText89),
                editText89 = (EditText) findViewById(R.id.editText90),
                editText90 = (EditText) findViewById(R.id.editText91),
                editText91 = (EditText) findViewById(R.id.editText92),
                editText92 = (EditText) findViewById(R.id.editText93),
                editText93 = (EditText) findViewById(R.id.editText94),
                editText94 = (EditText) findViewById(R.id.editText95),
                editText95 = (EditText) findViewById(R.id.editText96),
                editText96 =(EditText) findViewById(R.id.editText97),
                editText97 =(EditText)  findViewById(R.id.editText98),
                editText98 = (EditText) findViewById(R.id.editText99),
                editText99 =(EditText)  findViewById(R.id.editText100),
                editText100 = (EditText) findViewById(R.id.editText101),
                editText101 = (EditText) findViewById(R.id.editText102),
                editText102 = (EditText) findViewById(R.id.editText103),
                editText103 = (EditText) findViewById(R.id.editText104),
                editText104 = (EditText) findViewById(R.id.editText105),
                editText105 = (EditText) findViewById(R.id.editText106),
                editText106 = (EditText) findViewById(R.id.editText107),
                editText107 = (EditText) findViewById(R.id.editText108),
                editText108 = (EditText) findViewById(R.id.editText109),
                editText109 = (EditText) findViewById(R.id.editText110),
                editText110 = (EditText) findViewById(R.id.editText111),
                editText111 = (EditText) findViewById(R.id.editText112),
                editText112 = (EditText) findViewById(R.id.editText113),
                editText113 = (EditText) findViewById(R.id.editText114),
                editText114 = (EditText) findViewById(R.id.editText115),
                editText115 = (EditText) findViewById(R.id.editText116),
                editText116 = (EditText) findViewById(R.id.editText117),
                editText117 = (EditText) findViewById(R.id.editText118)};

        //Define and Initialize all Switches serially here

//Define and Initialize all Spinners serially here


//---------------------To Set View in Current Activity------------------
        TextView textView7 = (TextView) findViewById(R.id.textView1);
        textView7.setText("Name: " + PersonalDetailsActivity.naam);
        TextView textView8 = (TextView) findViewById(R.id.textView2);
        textView8.setText("Designation: " + PersonalDetailsActivity.design);
        TextView textView10 = (TextView) findViewById(R.id.textView3);
        textView10.setText("Emp No.: " + PersonalDetailsActivity.EmpID);
        TextView textView9 = (TextView) findViewById(R.id.textView4);
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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.asmgcssaabdaily1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel = {205,270,310,310,310,310,310,310,310,310,310,310,310,310,310,310,310,310};
        int[] editTextYPixel = {247,247,402,442,475,535,560,588,614,640,666,694,720,752,778,805,839,922};



        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for(int i = 0; i < editTextXPixel.length; i++){
            canvas.drawText( editTextDataForPDF[i],editTextXPixel[i],editTextYPixel[i],titlePaint);
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

        canvas.drawText(strData,397,247,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.asmgcssaabdaily2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel2 = {310,310,310,310,310,310,310,310,310,310,310,310,310,310,310,310,310,310,310};
        int[] editTextYPixel2 = {185,222,275,320,400,454,488,513,538,563,590,615,651,695,740,782,825,855,888};



        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+18],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }


        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------

        //----------------------Page 3---------------------

        PdfDocument.PageInfo myPageInfo3 = new PdfDocument.PageInfo.Builder(723, 1024, 3).create();

        // start a page
        PdfDocument.Page myPage3 = myPdfdocument.startPage(myPageInfo3);

        canvas = myPage3.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.asmgcssaabdaily3);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel3 = {310,310,310,310,310,310,310,310,310,310,310,310,310,310};
        int[] editTextYPixel3 = {185,227,267,305,342,385,422,463,503,547,591,643,693,744};



        for(int i = 0; i < editTextXPixel3.length; i++){
            canvas.drawText( editTextDataForPDF[i+37],editTextXPixel3[i],editTextYPixel3[i],titlePaint);
        }


        myPdfdocument.finishPage(myPage3);

        //-------------------------End of Page 3-----------------

        //----------------------Page 4---------------------

        PdfDocument.PageInfo myPageInfo4 = new PdfDocument.PageInfo.Builder(723, 1024, 4).create();

        // start a page
        PdfDocument.Page myPage4 = myPdfdocument.startPage(myPageInfo4);

        canvas = myPage4.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.asmgcssaabdaily4);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel4 = {120,160,120,160,120,160,120,160,120,160,120,160,120,160,120,160,120,160,120,160,120,160,120,160,120,160,120,160};
        int[] editTextYPixel4 = {294,294,332,332,370,370,410,410,450,450,490,490,525,525,565,565,600,600,640,640,680,680,720,720,760,760,898,885};



        for(int i = 0; i < editTextXPixel4.length; i++){
            canvas.drawText( editTextDataForPDF[i+51],editTextXPixel4[i],editTextYPixel4[i],titlePaint);
        }


        myPdfdocument.finishPage(myPage4);

        //-------------------------End of Page 4-----------------

        //----------------------Page 5---------------------

        PdfDocument.PageInfo myPageInfo5 = new PdfDocument.PageInfo.Builder(723, 1024, 5).create();

        // start a page
        PdfDocument.Page myPage5 = myPdfdocument.startPage(myPageInfo5);

        canvas = myPage5.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.asmgcssaabdaily5);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel5 = {120,160,245,245,245,245,245,245,245,245,245,245,245};
        int[] editTextYPixel5 = {215,200,415,455,493,531,570,611,650,688,728,767,902};



        for(int i = 0; i < editTextXPixel5.length; i++){
            canvas.drawText( editTextDataForPDF[i+79],editTextXPixel5[i],editTextYPixel5[i],titlePaint);
        }


        myPdfdocument.finishPage(myPage5);

        //-------------------------End of Page 5-----------------

        //----------------------Page 6---------------------

        PdfDocument.PageInfo myPageInfo6 = new PdfDocument.PageInfo.Builder(723, 1024, 6).create();

        // start a page
        PdfDocument.Page myPage6 = myPdfdocument.startPage(myPageInfo6);

        canvas = myPage6.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.asmgcssaabdaily6);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel6 = {245,245,245,245,245,245,245,245,245,245,245,245,245,245,245,245,245,245,245,245,245,245,245,245};
        int[] editTextYPixel6 = {190,227,255,290,320,350,383,420,457,493,527,562,590,618,645,672,698,723,746,772,796,820,850,886};



        for(int i = 0; i < editTextXPixel6.length; i++){
            canvas.drawText( editTextDataForPDF[i+92],editTextXPixel6[i],editTextYPixel6[i],titlePaint);
        }


        myPdfdocument.finishPage(myPage6);

        //-------------------------End of Page 6-----------------

        //----------------------Page 7---------------------

        PdfDocument.PageInfo myPageInfo7 = new PdfDocument.PageInfo.Builder(723, 1024, 7).create();

        // start a page
        PdfDocument.Page myPage7 = myPdfdocument.startPage(myPageInfo7);

        canvas = myPage7.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.asmgcssaabdaily7);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel7 = {35};
        int[] editTextYPixel7 = {250};



        for(int i = 0; i < editTextXPixel7.length; i++){
            canvas.drawText( editTextDataForPDF[i+116],editTextXPixel7[i],editTextYPixel7[i],titlePaint);
        }

        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);

        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,250,200, false), 430, 410, paint);
        myPdfdocument.finishPage(myPage7);

        //-------------------------End of Page 7-----------------



        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Surveillance/ASMGCS/SAAB/Daily/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Daily ASMGCS SAAB " + strData + ".pdf"; // Change Here--------------------------
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
        myFunctions.saveToParse(targetPdf, fileName,"Surveillance","Daily",outputEditText,MyFunctions.specificCode("d"),"outputSwitch", "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Daily Maintenance of SAAB done.",//Change Here-----------------------------
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
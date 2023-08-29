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

public class LlzNormarc35MonthlyActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray = {};//Copy
    private Spinner[] spinnerArray = {};//Copy
    private String thisActivityName = "LlzNormarc35MonthlyActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llz_normarc35_monthly);
        //Define and Initialize all EditTexts serially here
        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16, editText17, editText18,
                editText19, editText20, editText21, editText22, editText23, editText24,editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32, editText33, editText34, editText35, editText36,
                editText37, editText38, editText39, editText40, editText41, editText42, editText43, editText44, editText45, editText46, editText47, editText48, editText49, editText50, editText51, editText52, editText53, editText54,
                editText55, editText56, editText57, editText58,editText59, editText60,editText61, editText62,editText63, editText64, editText65, editText66, editText67, editText68,editText69, editText70, editText71, editText72,
                editText73, editText74, editText75, editText76, editText77, editText78, editText79, editText80, editText81, editText82, editText83, editText84, editText85, editText86, editText87, editText88,editText89,editText90,
                editText91, editText92, editText93, editText94,editText95, editText96, editText97, editText98,editText99, editText100, editText101, editText102, editText103, editText104, editText105, editText106, editText107, editText108,
                editText109, editText110, editText111, editText112, editText113, editText114, editText115, editText116, editText117, editText118, editText119, editText120, editText121, editText122, editText123, editText124,editText125,
                editText126, editText127, editText128, editText129, editText130, editText131, editText132, editText133, editText134, editText135, editText136, editText137, editText138, editText139, editText140, editText141, editText142,
                editText143, editText144, editText145, editText146, editText147, editText148, editText149, editText150, editText151, editText152, editText153, editText154, editText155, editText156, editText157, editText158,editText159,
                editText160,editText161, editText162,editText163, editText164, editText165, editText166, editText167, editText168,editText169, editText170, editText171;

        editTextArray = new EditText[]{
                editText1 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyStation),
                editText2 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyRegion),
                editText3 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX1ALCLDDM),
                editText4 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX2ALCLDDM),
                editText5 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX1ALCLDDM),
                editText6 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX2ALCLDDM),
                editText7 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX1ALCLSDM),
                editText8 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX2ALCLSDM),
                editText9 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX1ALCLSDM),
                editText10 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX2ALCLSDM),
                editText11 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX1ALCLRF),
                editText12 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX2ALCLRF),
                editText13 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX1ALCLRF),
                editText14 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX2ALCLRF),
                editText15 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX1ALDSDDM),
                editText16 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX2ALDSDDM),
                editText17 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX1ALDSDDM),
                editText18 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX2ALDSDDM),
                editText19 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX1ALNFDDM),
                editText20 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX2ALNFDDM),
                editText21 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX1ALNFDDM),
                editText22 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX2ALNFDDM),
                editText23 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX1ALDSSDM),
                editText24 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX2ALDSSDM),
                editText25 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX1ALDSSDM),
                editText26 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX2ALDSSDM),
                editText27 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX1ALCLRDDM),
                editText28 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX2ALCLRDDM),
                editText29 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX1ALCLRDDM),
                editText30 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX2ALCLRDDM),
                editText31 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX1ALCLRSDM),
                editText32 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX2ALCLRSDM),
                editText33 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX1ALCLRSDM),
                editText34 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX2ALCLRSDM),
                editText35 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX1ALCLRRF),
                editText36 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX2ALCLRRF),
                editText37 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX1ALCLRRF),
                editText38 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX2ALCLRRF),
                editText39 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX1MonDelay),
                editText40 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX2MonDelay),
                editText41 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX1MonDelay),
                editText42 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX2MonDelay),
                editText43 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX1NFDelay),
                editText44 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX2NFDelay),
                editText45 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX1NFDelay),
                editText46 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX2NFDelay),
                editText47 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX1IdentMon1CL),
                editText48 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX2IdentMon1CL),
                editText49 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX1IdentMon1CL),
                editText50 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX2IdentMon1CL),
                editText51 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX1IdentMon2CL),
                editText52 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX2IdentMon2CL),
                editText53 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX1IdentMon2CL),
                editText54 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX2IdentMon2CL),
                editText55 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX1IdentMon1CLR),
                editText56 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX2IdentMon1CLR),
                editText57 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX1IdentMon1CLR),
                editText58 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX2IdentMon1CLR),
                editText59 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX1IdentMon2CLR),
                editText60 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX2IdentMon2CLR),
                editText61 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX1IdentMon2CLR),
                editText62 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX2IdentMon2CLR),
                editText63 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX1Lamp),
                editText64 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX2Lamp),
                editText65 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX1Lamp),
                editText66 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX2Lamp),
                editText67 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX1Lightening),
                editText68 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX2Lightening),
                editText69 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX1Lightening),
                editText70 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX2Lightening),
                editText71 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX1Earthing),
                editText72 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyNSTX2Earthing),
                editText73 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX1Earthing),
                editText74 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyMSTX2Earthing),

                editText75 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyBatteryBD1),
                editText76 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyBatteryBD2),
                editText77 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyBatt10min1),
                editText78 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyBatt10min2),
                editText79 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyBatteryAD1),
                editText80 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyBatteryAD2),
                editText81 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyBatteryClean1),
                editText82 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyBatteryClean2),
                editText83 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyStatusCO12),
                editText84 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyDTSetCO12),
                editText85 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyDTObsCO12),
                editText86 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyStatusCO21),
                editText87 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyDTSetCO21),
                editText88 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyDTObsCO21),
                editText89 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyStatusCONF1),
                editText90 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyDTSetCONF1),
                editText91 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyDTObsCONF1),

                editText92 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon1CLDDM),
                editText93 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon2CLDDM),
                editText94 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon1CLDDM),
                editText95 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon2CLDDM),
                editText96 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon1CLSDM),
                editText97 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon2CLSDM),
                editText98 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon1CLSDM),
                editText99 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon2CLSDM),
                editText100 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon1CLRF),
                editText101 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon2CLRF),
                editText102 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon1CLRF),
                editText103 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon2CLRF),
                editText104 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon1DSDDM),
                editText105 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon2DSDDM),
                editText106 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon1DSDDM),
                editText107 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon2DSDDM),
                editText108 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon1DSSDM),
                editText109 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon2DSSDM),
                editText110 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon1DSSDM),
                editText111 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon2DSSDM),
                editText112 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon1DSRF),
                editText113 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon2DSRF),
                editText114 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon1DSRF),
                editText115 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon2DSRF),
                editText116 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon1NFDDM),
                editText117 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon2NFDDM),
                editText118 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon1NFDDM),
                editText119 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon2NFDDM),
                editText120 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon1NFSDM),
                editText121 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon2NFSDM),
                editText122 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon1NFSDM),
                editText123 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon2NFSDM),
                editText124 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon1NFRF),
                editText125 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon2NFRF),
                editText126 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon1NFRF),
                editText127 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon2NFRF),
                editText128 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon1CLRDDM),
                editText129 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon2CLRDDM),
                editText130 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon1CLRDDM),
                editText131 = (EditText)  findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon2CLRDDM),
                editText132 = (EditText)  findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon1CLRSDM),
                editText133 = (EditText)  findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon2CLRSDM),
                editText134 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon1CLRSDM),
                editText135 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon2CLRSDM),
                editText136 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon1CLRRF),
                editText137 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon2CLRRF),
                editText138 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon1CLRRF),
                editText139 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon2CLRRF),
                editText140 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon1DF),
                editText141 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon2DF),
                editText142 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon1DF),
                editText143 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon2DF),
                editText144 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon1CLIdent),
                editText145 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon2CLIdent),
                editText146 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon1CLIdent),
                editText147 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon2CLIdent),
                editText148 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon1CLRIdent),
                editText149 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon2CLRIdent),
                editText150 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon1CLRIdent),
                editText151 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon2CLRIdent),
                editText152 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon1Self),
                editText153 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX1Mon2Self),
                editText154 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon1Self),
                editText155 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyTX2Mon2Self),

                editText156 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyCRSTx1DDM),
                editText157 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyCRSTX2DDM),
                editText158 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyCRSTx1SDM),
                editText159 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyCRSTX2SDM),
                editText160 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyCRSTx1RF),
                editText161 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyCRSTX2RF),
                editText162 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyCLRTx1DDM),
                editText163 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyCLRTX2DDM),
                editText164 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyCLRTx1SDM),
                editText165 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyCLRTX2SDM),
                editText166 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyCLRTx1RF),
                editText167 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyCLRTX2RF),
                editText168 = (EditText) findViewById(R.id.editTextLlzNormarc35MonthlyRemarks)};

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

      //  String[] switchDataForPDF = myFunctions.seperateSwitchData(outputSwitch);

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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llznormarc35monthly1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel = {189,353,292,374,452,520,292,374,452,520,292,374,452,520,292,374,452,520,292,374,452,520,292,374,452,520,292,374,452,520,
                292,374,452,520,292,374,452,520,292,374,452,520,292,374,452,520,292,374,452,520,292,374,452,520,292,374,452,520,292,374,452,520,292,374,452,520,
                292,374,452,520,292,374,452,520,300,460,300,460,300,460,300,460,290,391,478,290,391,478,290,391,478};
        int[] editTextYPixel = {130,130,275,275,275,275,292,292,292,292,311,311,311,311,328,328,328,328,346,346,346,346,363,363,363,363,380,380,380,380,
                398,398,398,398,416,416,416,416,434,434,434,434,450,450,450,450,468,468,468,468,486,486,486,486,503,503,503,503,520,520,520,520,537,537,537,537,
                560,560,560,560,583,583,583,583,703,703,728,728,752,752,768,768,894,894,894,923,923,923,942,942,942};


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
        canvas.drawText(strData,515,130,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);

        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llznormarc35monthly2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel2 = {265,363,470,569,265,363,470,569,265,363,470,569,265,363,470,569,265,363,470,569,265,363,470,569,265,363,470,569,
                265,363,470,569,265,363,470,569,265,363,470,569,265,363,470,569,265,363,470,569,265,363,470,569,265,363,470,569,265,363,470,569,
                265,363,470,569,322,426,322,426,322,426,322,426,322,426,322,426,115};
        int[] editTextYPixel2 = {169,169,169,169,186,186,186,186,203,203,203,203,221,221,221,221,239,239,239,239,257,257,257,257,274,274,274,274,
                290,290,290,290,309,309,309,309,326,326,326,326,345,345,345,345,361,361,361,361,378,378,378,378,396,396,396,396,413,413,413,413,
                434,434,434,434,511,511,527,527,545,545,562,562,580,580,597,597,620};


        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel.length],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }

        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 100, 660, paint);

        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------

        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Navigation/LLZNormarc3513/Monthly/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Monthly LLZ Normarc 3513" + strData + ".pdf"; // Change Here--------------------------
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
        myFunctions.saveToParse(targetPdf, fileName,"ILS","Monthly",outputEditText,MyFunctions.specificCode("m"),"outputSwitch", "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Monthly Maintenance of Normarc 3513 LLZ done.",//Change Here-----------------------------
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
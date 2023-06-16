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

public class LlzNormarc7000SixActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray = {};//Copy
    private Spinner[] spinnerArray = {};//Copy
    private String thisActivityName = "LlzNormarc7000SixActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llz_normarc7000_six);
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
                editText160,editText161, editText162,editText163, editText164, editText165, editText166, editText167, editText168,editText169, editText170, editText171, editText172, editText173, editText174, editText175, editText176,
                editText177, editText178, editText179, editText180, editText181, editText182, editText183, editText184, editText185, editText186, editText187, editText188,editText189,editText190, editText191, editText192, editText193,
                editText194,editText195, editText196, editText197, editText198,editText199, editText200, editText201, editText202, editText203, editText204, editText205, editText206, editText207, editText208,editText209, editText210,
                editText211, editText212, editText213, editText214, editText215, editText216, editText217, editText218, editText219, editText220, editText221, editText222, editText223, editText224,editText225, editText226, editText227,
                editText228, editText229, editText230, editText231, editText232, editText233, editText234, editText235, editText236, editText237, editText238, editText239, editText240, editText241, editText242, editText243, editText244,
                editText245, editText246, editText247, editText248, editText249, editText250, editText251, editText252,editText253, editText254, editText255, editText256, editText257, editText258,editText259, editText260, editText261, editText262, editText263,
                editText264, editText265, editText266, editText267,editText268, editText269, editText270, editText271, editText272, editText273, editText274, editText275, editText276, editText277, editText278, editText279, editText280, editText281, editText282,
                editText283,editText284, editText285, editText286, editText287, editText288, editText289, editText290, editText291, editText292, editText293;

        editTextArray = new EditText[]{
                editText1 = (EditText)  findViewById(R.id.editTextLlzNormarcSixStation),
                editText2 = (EditText)  findViewById(R.id.editTextLlzNormarcSixModel),
                editText3 = (EditText)  findViewById(R.id.editTextLlzNormarcSixRWY),
                editText4 = (EditText)  findViewById(R.id.editTextLlzNormarcSixCat),
                editText5 = (EditText)  findViewById(R.id.editTextLlzNormarcSixFrequency),
                editText6 = (EditText)  findViewById(R.id.editTextLlzNormarcSixIdent),

                editText7 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1CLDDM),
                editText8 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1CLDDM),
                editText9 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1CLDDM),
                editText10 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2CLDDM),
                editText11 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2CLDDM),
                editText12 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2CLDDM),

                editText13 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1CLSDM),
                editText14 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1CLSDM),
                editText15 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1CLSDM),
                editText16 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2CLSDM),
                editText17 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2CLSDM),
                editText18 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2CLSDM),

                editText19 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1CLRF),
                editText20 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1CLRF),
                editText21 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1CLRF),
                editText22 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2CLRF),
                editText23 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2CLRF),
                editText24 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2CLRF),

                editText25 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1DSDDM),
                editText26 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1DSDDM),
                editText27 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1DSDDM),
                editText28 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2DSDDM),
                editText29 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2DSDDM),
                editText30 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2DSDDM),

                editText31 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1DSSDM),
                editText32 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1DSSDM),
                editText33 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1DSSDM),
                editText34 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2DSSDM),
                editText35 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2DSSDM),
                editText36 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2DSSDM),

                editText37 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1DSRF),
                editText38 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1DSRF),
                editText39 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1DSRF),
                editText40 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2DSRF),
                editText41 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2DSRF),
                editText42 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2DSRF),

                editText43 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1NFDDM),
                editText44 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1NFDDM),
                editText45 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1NFDDM),
                editText46 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2NFDDM),
                editText47  = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2NFDDM),
                editText48 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2NFDDM),

                editText49 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1NFSDM),
                editText50 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1NFSDM),
                editText51 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1NFSDM),
                editText52 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2NFSDM),
                editText53 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2NFSDM),
                editText54 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2NFSDM),

                editText55 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1NFRF),
                editText56 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1NFRF),
                editText57 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1NFRF),
                editText58 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2NFRF),
                editText59 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2NFRF),
                editText60 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2NFRF),

                editText61 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1CLRDDM),
                editText62 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1CLRDDM),
                editText63 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1CLRDDM),
                editText64 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2CLRDDM),
                editText65 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2CLRDDM),
                editText66 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2CLRDDM),

                editText67 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1CLRSDM),
                editText68 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1CLRSDM),
                editText69 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1CLRSDM),
                editText70 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2CLRSDM),
                editText71 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2CLRSDM),
                editText72 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2CLRSDM),

                editText73 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1CLRRF),
                editText74 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1CLRRF),
                editText75 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1CLRRF),
                editText76 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2CLRRF),
                editText77 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2CLRRF),
                editText78 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2CLRRF),

                editText79 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1Diff),
                editText80 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1Diff),
                editText81 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1Diff),
                editText82 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2Diff),
                editText83 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2Diff),
                editText84 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2Diff),

                editText85 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1CLIDMOD),
                editText86 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1CLIDMOD),
                editText87 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1CLIDMOD),
                editText88 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2CLIDMOD),
                editText89 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2CLIDMOD),
                editText90 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2CLIDMOD),

                editText91 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1CLRIDMOD),
                editText92 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1CLRIDMOD),
                editText93 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1CLRIDMOD),
                editText94 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2CLRIDMOD),
                editText95 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2CLRIDMOD),
                editText96 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2CLRIDMOD),

                editText97 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1CLIdent),
                editText98 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1CLIdent),
                editText99 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1CLIdent),
                editText100 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2CLIdent),
                editText101 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2CLIdent),
                editText102 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2CLIdent),

                editText103 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1CLRIdent),
                editText104 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1CLRIdent),
                editText105 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1CLRIdent),
                editText106 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2CLRIdent),
                editText107 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2CLRIdent),
                editText108 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2CLRIdent),

                editText109 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1DCO),
                editText110 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1DCO),
                editText111 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1DCO),
                editText112 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2DCO),
                editText113 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2DCO),
                editText114 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2DCO),

                editText115 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1DC1),
                editText116 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1DC1),
                editText117 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1DC1),
                editText118 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2DC1),
                editText119 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2DC1),
                editText120 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2DC1),

                editText121 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1DC2),
                editText122 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1DC2),
                editText123 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1DC2),
                editText124 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2DC2),
                editText125 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2DC2),
                editText126 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2DC2),

                editText127 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1DC3),
                editText128 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1DC3),
                editText129 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1DC3),
                editText130 = (EditText)  findViewById(R.id.editTextLlzNormarcSixLowMon2DC3),
                editText131 = (EditText)  findViewById(R.id.editTextLlzNormarcSixHighMon2DC3),
                editText132 = (EditText)  findViewById(R.id.editTextLlzNormarcSixWarnMon2DC3),

                editText133 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1SelfDDM),
                editText134 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1SelfDDM),
                editText135 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1SelfDDM),
                editText136 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2SelfDDM),
                editText137 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2SelfDDM),
                editText138 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2SelfDDM),

                editText139 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1SelfSDM),
                editText140 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1SelfSDM),
                editText141 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1SelfSDM),
                editText142 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2SelfSDM),
                editText143 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2SelfSDM),
                editText144 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2SelfSDM),

                editText145 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1SelfRF),
                editText146 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1SelfRF),
                editText147 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1SelfRF),
                editText148 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2SelfRF),
                editText149 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2SelfRF),
                editText150 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2SelfRF),

                editText151 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1ADDM),
                editText152 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1ADDM),
                editText153 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1ADDM),
                editText154 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2ADDM),
                editText155 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2ADDM),
                editText156 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2ADDM),

                editText157 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1ASDM),
                editText158 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1ASDM),
                editText159 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1ASDM),
                editText160 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2ASDM),
                editText161 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2ASDM),
                editText162 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2ASDM),

                editText163 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1ARF),
                editText164 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1ARF),
                editText165 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1ARF),
                editText166 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2ARF),
                editText167 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2ARF),
                editText168 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2ARF),

                editText169 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1BDDM),
                editText170 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1BDDM),
                editText171 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1BDDM),
                editText172 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2BDDM),
                editText173 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2BDDM),
                editText174 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2BDDM),

                editText175 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1BSDM),
                editText176 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1BSDM),
                editText177 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1BSDM),
                editText178 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2BSDM),
                editText179 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2BSDM),
                editText180 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2BSDM),

                editText181 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1BRF),
                editText182 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1BRF),
                editText183 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1BRF),
                editText184 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2BRF),
                editText185 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2BRF),
                editText186 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2BRF),

                editText187 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon1EXEAL),
                editText188 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon1EXEAL),
                editText189 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon1EXEAL),
                editText190 = (EditText) findViewById(R.id.editTextLlzNormarcSixLowMon2EXEAL),
                editText191 = (EditText) findViewById(R.id.editTextLlzNormarcSixHighMon2EXEAL),
                editText192 = (EditText) findViewById(R.id.editTextLlzNormarcSixWarnMon2EXEAL),

                editText193 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx1LowCRSPA),
                editText194 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx1HighCRSPA),
                editText195 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx2LowCRSPA),
                editText196 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx2HighCRSPA),
                editText197 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx1LowCRSCSB),
                editText198 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx1HighCRSCSB),
                editText199 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx2LowCRSCSB),
                editText200 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx2HighCRSCSB),
                editText201 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx1LowCRSSBO),
                editText202 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx1HighCRSSBO),
                editText203 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx2LowCRSSBO),
                editText204 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx2HighCRSSBO),
                editText205 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx1LowCRSPH),
                editText206 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx1HighCRSPH),
                editText207 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx2LowCRSPH),
                editText208 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx2HighCRSPH),
                editText209 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx1LowCLRPA),
                editText210 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx1HighCLRPA),
                editText211 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx2LowCLRPA),
                editText212 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx2HighCLRPA),
                editText213 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx1LowCLRCSB),
                editText214 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx1HighCLRCSB),
                editText215 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx2LowCLRCSB),
                editText216 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx2HighCLRCSB),
                editText217 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx1LowCLRSBO),
                editText218 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx1HighCLRSBO),
                editText219 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx2LowCLRSBO),
                editText220 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx2HighCLRSBO),
                editText221 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx1LowCLRPH),
                editText222 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx1HighCLRPH),
                editText223 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx2LowCLRPH),
                editText224 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx2HighCLRPH),
                editText225 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx1LowCLR150),
                editText226 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx1HighCLR150),
                editText227 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx2LowCLR150),
                editText228 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx2HighCLR150),
                editText229 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx1LowCLR90),
                editText230 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx1HighCLR90),
                editText231 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx2LowCLR90),
                editText232 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx2HighCLR90),
                editText233 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx1LowCOU150),
                editText234 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx1HighCOU150),
                editText235 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx2LowCOU150),
                editText236 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx2HighCOU150),
                editText237 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx1LowCOU90),
                editText238 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx1HighCOU90),
                editText239 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx2LowCOU90),
                editText240 = (EditText) findViewById(R.id.editTextLlzNormarcSixTx2HighCOU90),

                editText241 = (EditText) findViewById(R.id.editTextLlzNormarcSixPs1Low15),
                editText242 = (EditText) findViewById(R.id.editTextLlzNormarcSixPs1High15),
                editText243 = (EditText) findViewById(R.id.editTextLlzNormarcSixPs2Low15),
                editText244 = (EditText) findViewById(R.id.editTextLlzNormarcSixPs2High15),
                editText245 = (EditText) findViewById(R.id.editTextLlzNormarcSixPs1Low5),
                editText246 = (EditText) findViewById(R.id.editTextLlzNormarcSixPs1High5),
                editText247 = (EditText) findViewById(R.id.editTextLlzNormarcSixPs2Low5),
                editText248 = (EditText) findViewById(R.id.editTextLlzNormarcSixPs2High5),
                editText249 = (EditText) findViewById(R.id.editTextLlzNormarcSixPs1Low85),
                editText250 = (EditText) findViewById(R.id.editTextLlzNormarcSixPs1High85),
                editText251 = (EditText) findViewById(R.id.editTextLlzNormarcSixPs2Low85),
                editText252 = (EditText) findViewById(R.id.editTextLlzNormarcSixPs2High85),
                editText253 = (EditText) findViewById(R.id.editTextLlzNormarcSixPs1Low15V),
                editText254 = (EditText) findViewById(R.id.editTextLlzNormarcSixPs1High15V),
                editText255 = (EditText) findViewById(R.id.editTextLlzNormarcSixPs2Low15V),
                editText256 = (EditText) findViewById(R.id.editTextLlzNormarcSixPs2High15V),

                editText257 = (EditText) findViewById(R.id.editTextLlzNormarcSixObsMon15),
                editText258 = (EditText) findViewById(R.id.editTextLlzNormarcSixObsMon25),
                editText259 = (EditText) findViewById(R.id.editTextLlzNormarcSixObsMon1STS),
                editText260 = (EditText) findViewById(R.id.editTextLlzNormarcSixObsMon2STS),
                editText261 = (EditText) findViewById(R.id.editTextLlzNormarcSixObsMon1DSPPFO),
                editText262 = (EditText) findViewById(R.id.editTextLlzNormarcSixObsMon2DSPPFO),
                editText263 = (EditText) findViewById(R.id.editTextLlzNormarcSixObsMon1DSPERR),
                editText264 = (EditText) findViewById(R.id.editTextLlzNormarcSixObsMon2DSPERR),
                editText265 = (EditText) findViewById(R.id.editTextLlzNormarcSixObsMon1RST),
                editText266 = (EditText) findViewById(R.id.editTextLlzNormarcSixObsMon2RST),
                editText267 = (EditText) findViewById(R.id.editTextLlzNormarcSixObsMon1SyncERR),
                editText268 = (EditText) findViewById(R.id.editTextLlzNormarcSixObsMon2SyncERR),
                editText269 = (EditText) findViewById(R.id.editTextLlzNormarcSixObsMon115),
                editText270 = (EditText) findViewById(R.id.editTextLlzNormarcSixObsMon215),
                editText271 = (EditText) findViewById(R.id.editTextLlzNormarcSixObsMon115V),
                editText272 = (EditText) findViewById(R.id.editTextLlzNormarcSixObsMon215V),

                editText273 = (EditText) findViewById(R.id.editTextLlzNormarcSixSetTx1CRSRF),
                editText274 = (EditText) findViewById(R.id.editTextLlzNormarcSixSetTx2CRSRF),
                editText275 = (EditText) findViewById(R.id.editTextLlzNormarcSixSetTx1CRSBal),
                editText276 = (EditText) findViewById(R.id.editTextLlzNormarcSixSetTx2CRSBal),
                editText277 = (EditText) findViewById(R.id.editTextLlzNormarcSixSetTx1CRSSum),
                editText278 = (EditText) findViewById(R.id.editTextLlzNormarcSixSetTx2CRSSum),
                editText279 = (EditText) findViewById(R.id.editTextLlzNormarcSixSetTx1CRSIdent),
                editText280 = (EditText) findViewById(R.id.editTextLlzNormarcSixSetTx2CRSIdent),
                editText281 = (EditText) findViewById(R.id.editTextLlzNormarcSixSetTx1CLRRF),
                editText282 = (EditText) findViewById(R.id.editTextLlzNormarcSixSetTx2CLRRF),
                editText283 = (EditText) findViewById(R.id.editTextLlzNormarcSixSetTx1CLRBal),
                editText284 = (EditText) findViewById(R.id.editTextLlzNormarcSixSetTx2CLRBal),
                editText285 = (EditText) findViewById(R.id.editTextLlzNormarcSixSetTx1CLRSum),
                editText286 = (EditText) findViewById(R.id.editTextLlzNormarcSixSetTx2CLRSum),
                editText287 = (EditText) findViewById(R.id.editTextLlzNormarcSixSetTx1CLRIdent),
                editText288 = (EditText) findViewById(R.id.editTextLlzNormarcSixSetTx2CLRIdent),
                editText289 = (EditText) findViewById(R.id.editTextLlzNormarcSixSetTx1Morse),
                editText290 = (EditText) findViewById(R.id.editTextLlzNormarcSixSetTx2Morse),
                editText291 = (EditText) findViewById(R.id.editTextLlzNormarcSixSwitchTx1Morse),
                editText292 = (EditText) findViewById(R.id.editTextLlzNormarcSixSwitchTx2Morse),
                editText293 = (EditText) findViewById(R.id.editTextLlzNormarcSixRemarks)};

//Define and Initialize all Switches serially here

        Switch  switch1,switch2,switch3,switch4;
        switchArray = new Switch[]{
                switch1 = (Switch) findViewById(R.id.switchLlzNormarcSixSwitchTx190),
                switch2 = (Switch) findViewById(R.id.switchLlzNormarcSixSwitchTx290),
                switch3 = (Switch) findViewById(R.id.switchLlzNormarcSixSwitchTx1150),
                switch4 = (Switch) findViewById(R.id.switchLlzNormarcSixSwitchTx2150)};
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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llznormarc7000six1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(11);

        int[] editTextXPixel = {152,583,125,204,318,477,230,304,370,445,510,575,230,304,370,445,510,575,230,304,370,445,510,575,230,304,370,445,510,575,
                230,304,370,445,510,575,230,304,370,445,510,575,230,304,370,445,510,575,230,304,370,445,510,575,230,304,370,445,510,575,230,304,370,445,510,575,
                230,304,370,445,510,575,230,304,370,445,510,575,230,304,370,445,510,575,230,304,370,445,510,575,230,304,370,445,510,575,230,304,370,445,510,575,
                230,304,370,445,510,575,230,304,370,445,510,575,230,304,370,445,510,575,230,304,370,445,510,575,230,304,370,445,510,575,230,304,370,445,510,575,
                230,304,370,445,510,575,230,304,370,445,510,575};
        int[] editTextYPixel = {154,154,188,188,188,188,295,295,295,295,295,295,318,318,318,318,318,318,339,339,339,339,339,339,361,361,361,361,361,361,
                383,383,383,383,383,383,406,406,406,406,406,406,429,429,429,429,429,429,450,450,450,450,450,450,474,474,474,474,474,474,495,495,495,495,495,495,
                517,517,517,517,517,517,540,540,540,540,540,540,562,562,562,562,562,562,584,584,584,584,584,584,606,606,606,606,606,606,629,629,629,629,629,629,
                650,650,650,650,650,650,672,672,672,672,672,672,695,695,695,695,695,695,718,718,718,718,718,718,740,740,740,740,740,740,762,762,762,762,762,762,
                784,784,784,784,784,784,807,807,807,807,807,807};



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
        titlePaint.setTextSize(11);

        canvas.drawText(strData,566,188,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llznormarc7000six2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(11);

        int[] editTextXPixel2 = {266,326,388,455,515,575,266,326,388,455,515,575,266,326,388,455,515,575,266,326,388,455,515,575,266,326,388,455,515,575,
                266,326,388,455,515,575,266,326,388,455,515,575,277,370,463,552,277,370,463,552,277,370,463,552,277,370,463,552,277,370,463,552,277,370,463,552,
                277,370,463,552,277,370,463,552,277,370,463,552,277,370,463,552,277,370,463,552,277,370,463,552};
        int[] editTextYPixel2 = {191,191,191,191,191,191,214,214,214,214,214,214,237,237,237,237,237,237,257,257,257,257,257,257,281,281,281,281,281,281,
                303,303,303,303,303,303,326,326,326,326,326,326,509,509,509,509,551,551,551,551,589,589,589,589,622,622,622,622,698,698,698,698,725,725,725,725,
                751,751,751,751,784,784,784,784,845,845,845,845,870,870,870,870,899,899,899,899,925,925,925,925};

        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel.length],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }

        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------

        //----------------------Page 3---------------------

        PdfDocument.PageInfo myPageInfo3 = new PdfDocument.PageInfo.Builder(723, 1024, 3).create();

        // start a page
        PdfDocument.Page myPage3 = myPdfdocument.startPage(myPageInfo3);

        canvas = myPage3.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llznormarc7000six3);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(11);

        int[] editTextXPixel3 = {274,368,462,548,274,368,462,548,274,368,462,548,274,368,462,548,450,544,450,544,450,544,450,544,450,544,450,544,450,544,450,544,
                290,405,290,405,290,405,290,405,290,405,290,405,290,405,290,405,290,405};
        int[] editTextYPixel3 = {158,158,158,158,184,184,184,184,207,207,207,207,235,235,235,235,370,370,400,400,428,428,457,457,487,487,518,518,546,546,575,575,
                677,677,698,698,720,720,742,742,763,763,785,785,806,806,828,828,849,849};

        for(int i = 0; i < editTextXPixel3.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel.length+editTextXPixel2.length],editTextXPixel3[i],editTextYPixel3[i],titlePaint);
        }


        myPdfdocument.finishPage(myPage3);

        //-------------------------End of Page 3-----------------

        //----------------------Page 4---------------------

        PdfDocument.PageInfo myPageInfo4 = new PdfDocument.PageInfo.Builder(723, 1024, 4).create();

        // start a page
        PdfDocument.Page myPage4 = myPdfdocument.startPage(myPageInfo4);

        canvas = myPage4.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llznormarc7000six4);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(11);

        int[] editTextXPixel4 = {464,554,100};
        int[] editTextYPixel4 = {215,215,266};

        int[] switchXPixel5 = {464,554,464,554};
        int[] switchYPixel5 = {180,180,197,197};

        for(int i = 0; i < editTextXPixel4.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel.length+editTextXPixel2.length+editTextXPixel3.length],editTextXPixel4[i],editTextYPixel4[i],titlePaint);
        }

        for(int i = 0; i < switchXPixel5.length; i++){
            canvas.drawText( switchDataForPDF[i],switchXPixel5[i],switchYPixel5[i],titlePaint);
        }

        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 100, 325, paint);


        myPdfdocument.finishPage(myPage4);

        //-------------------------End of Page 4-----------------



        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Navigation/LLZNormarc7000/Six Monthly/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Six Monthly LLZ Normarc " + strData + ".pdf"; // Change Here--------------------------
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
        myFunctions.saveToParse(targetPdf, fileName,"ILS","SixMonthly",outputEditText,MyFunctions.specificCode("sm"),outputSwitch, "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Six Monthly Maintenance of Normarc LLZ done.",//Change Here-----------------------------
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
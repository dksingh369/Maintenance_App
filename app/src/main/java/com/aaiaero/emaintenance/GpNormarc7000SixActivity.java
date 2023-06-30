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

public class GpNormarc7000SixActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray = {};//Copy
    private Spinner[] spinnerArray = {};//Copy
    private String thisActivityName = "GpNormarc7000SixActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gp_normarc7000_six);
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
                editText1 = (EditText)  findViewById(R.id.editTextGpNormarcSixStation),
                editText2 = (EditText)  findViewById(R.id.editTextGpNormarcSixModel),
                editText3 = (EditText)  findViewById(R.id.editTextGpNormarcSixRWY),
                editText4 = (EditText)  findViewById(R.id.editTextGpNormarcSixCat),
                editText5 = (EditText)  findViewById(R.id.editTextGpNormarcSixFrequency),

                editText6 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon1CLDDM),
                editText7 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon1CLDDM),
                editText8 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon1CLDDM),
                editText9 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon2CLDDM),
                editText10 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon2CLDDM),
                editText11 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon2CLDDM),

                editText12 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon1CLSDM),
                editText13 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon1CLSDM),
                editText14 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon1CLSDM),
                editText15 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon2CLSDM),
                editText16 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon2CLSDM),
                editText17 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon2CLSDM),

                editText18 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon1CLRF),
                editText19 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon1CLRF),
                editText20 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon1CLRF),
                editText21 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon2CLRF),
                editText22 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon2CLRF),
                editText23 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon2CLRF),

                editText24 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon1DSDDM),
                editText25 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon1DSDDM),
                editText26 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon1DSDDM),
                editText27 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon2DSDDM),
                editText28 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon2DSDDM),
                editText29 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon2DSDDM),

                editText30 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon1DSSDM),
                editText31 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon1DSSDM),
                editText32 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon1DSSDM),
                editText33 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon2DSSDM),
                editText34 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon2DSSDM),
                editText35 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon2DSSDM),

                editText36 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon1DSRF),
                editText37 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon1DSRF),
                editText38 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon1DSRF),
                editText39 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon2DSRF),
                editText40 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon2DSRF),
                editText41 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon2DSRF),

                editText42 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon1NFDDM),
                editText43 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon1NFDDM),
                editText44 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon1NFDDM),
                editText45 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon2NFDDM),
                editText46  = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon2NFDDM),
                editText47 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon2NFDDM),

                editText48 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon1NFSDM),
                editText49 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon1NFSDM),
                editText50 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon1NFSDM),
                editText51 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon2NFSDM),
                editText52 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon2NFSDM),
                editText53 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon2NFSDM),

                editText54 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon1NFRF),
                editText55 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon1NFRF),
                editText56 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon1NFRF),
                editText57 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon2NFRF),
                editText58 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon2NFRF),
                editText59 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon2NFRF),

                editText60 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon1CLRDDM),
                editText61 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon1CLRDDM),
                editText62 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon1CLRDDM),
                editText63 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon2CLRDDM),
                editText64 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon2CLRDDM),
                editText65 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon2CLRDDM),

                editText66 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon1CLRSDM),
                editText67 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon1CLRSDM),
                editText68 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon1CLRSDM),
                editText69 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon2CLRSDM),
                editText70 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon2CLRSDM),
                editText71 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon2CLRSDM),

                editText72 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon1CLRRF),
                editText73 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon1CLRRF),
                editText74 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon1CLRRF),
                editText75 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon2CLRRF),
                editText76 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon2CLRRF),
                editText77 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon2CLRRF),

                editText78 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon1Diff),
                editText79 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon1Diff),
                editText80 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon1Diff),
                editText81 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon2Diff),
                editText82 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon2Diff),
                editText83 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon2Diff),

                editText84 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon1DCO),
                editText85 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon1DCO),
                editText86 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon1DCO),
                editText87 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon2DCO),
                editText88 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon2DCO),
                editText89 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon2DCO),

                editText90 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon1DC1),
                editText91 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon1DC1),
                editText92 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon1DC1),
                editText93 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon2DC1),
                editText94 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon2DC1),
                editText95 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon2DC1),

                editText96 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon1DC2),
                editText97 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon1DC2),
                editText98 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon1DC2),
                editText99 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon2DC2),
                editText100 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon2DC2),
                editText101 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon2DC2),

                editText102 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon1DC3),
                editText103 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon1DC3),
                editText104 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon1DC3),
                editText105 = (EditText)  findViewById(R.id.editTextGpNormarcSixLowMon2DC3),
                editText106 = (EditText)  findViewById(R.id.editTextGpNormarcSixHighMon2DC3),
                editText107 = (EditText)  findViewById(R.id.editTextGpNormarcSixWarnMon2DC3),

                editText108 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon1SelfDDM),
                editText109 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon1SelfDDM),
                editText110 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon1SelfDDM),
                editText111 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon2SelfDDM),
                editText112 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon2SelfDDM),
                editText113 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon2SelfDDM),

                editText114 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon1SelfSDM),
                editText115 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon1SelfSDM),
                editText116 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon1SelfSDM),
                editText117 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon2SelfSDM),
                editText118 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon2SelfSDM),
                editText119 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon2SelfSDM),

                editText120 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon1SelfRF),
                editText121 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon1SelfRF),
                editText122 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon1SelfRF),
                editText123 = (EditText) findViewById(R.id.editTextGpNormarcSixLowMon2SelfRF),
                editText124 = (EditText) findViewById(R.id.editTextGpNormarcSixHighMon2SelfRF),
                editText125 = (EditText) findViewById(R.id.editTextGpNormarcSixWarnMon2SelfRF),

                editText126 = (EditText) findViewById(R.id.editTextGpNormarcSixTx1LowCRSPA),
                editText127 = (EditText) findViewById(R.id.editTextGpNormarcSixTx1HighCRSPA),
                editText128 = (EditText) findViewById(R.id.editTextGpNormarcSixTx2LowCRSPA),
                editText129 = (EditText) findViewById(R.id.editTextGpNormarcSixTx2HighCRSPA),
                editText130 = (EditText) findViewById(R.id.editTextGpNormarcSixTx1LowCRSCSB),
                editText131 = (EditText) findViewById(R.id.editTextGpNormarcSixTx1HighCRSCSB),
                editText132 = (EditText) findViewById(R.id.editTextGpNormarcSixTx2LowCRSCSB),
                editText133 = (EditText) findViewById(R.id.editTextGpNormarcSixTx2HighCRSCSB),
                editText134 = (EditText) findViewById(R.id.editTextGpNormarcSixTx1LowCRSSBO),
                editText135 = (EditText) findViewById(R.id.editTextGpNormarcSixTx1HighCRSSBO),
                editText136 = (EditText) findViewById(R.id.editTextGpNormarcSixTx2LowCRSSBO),
                editText137 = (EditText) findViewById(R.id.editTextGpNormarcSixTx2HighCRSSBO),
                editText138 = (EditText) findViewById(R.id.editTextGpNormarcSixTx1LowCRSPH),
                editText139 = (EditText) findViewById(R.id.editTextGpNormarcSixTx1HighCRSPH),
                editText140 = (EditText) findViewById(R.id.editTextGpNormarcSixTx2LowCRSPH),
                editText141 = (EditText) findViewById(R.id.editTextGpNormarcSixTx2HighCRSPH),
                editText142 = (EditText) findViewById(R.id.editTextGpNormarcSixTx1LowCLRPA),
                editText143 = (EditText) findViewById(R.id.editTextGpNormarcSixTx1HighCLRPA),
                editText144 = (EditText) findViewById(R.id.editTextGpNormarcSixTx2LowCLRPA),
                editText145 = (EditText) findViewById(R.id.editTextGpNormarcSixTx2HighCLRPA),
                editText146 = (EditText) findViewById(R.id.editTextGpNormarcSixTx1LowCLRCSB),
                editText147 = (EditText) findViewById(R.id.editTextGpNormarcSixTx1HighCLRCSB),
                editText148 = (EditText) findViewById(R.id.editTextGpNormarcSixTx2LowCLRCSB),
                editText149 = (EditText) findViewById(R.id.editTextGpNormarcSixTx2HighCLRCSB),

                editText150 = (EditText) findViewById(R.id.editTextGpNormarcSixTx1LowCLR150),
                editText151 = (EditText) findViewById(R.id.editTextGpNormarcSixTx1HighCLR150),
                editText152 = (EditText) findViewById(R.id.editTextGpNormarcSixTx2LowCLR150),
                editText153 = (EditText) findViewById(R.id.editTextGpNormarcSixTx2HighCLR150),
                editText154 = (EditText) findViewById(R.id.editTextGpNormarcSixTx1LowCLR90),
                editText155 = (EditText) findViewById(R.id.editTextGpNormarcSixTx1HighCLR90),
                editText156 = (EditText) findViewById(R.id.editTextGpNormarcSixTx2LowCLR90),
                editText157 = (EditText) findViewById(R.id.editTextGpNormarcSixTx2HighCLR90),
                editText158 = (EditText) findViewById(R.id.editTextGpNormarcSixTx1LowCOU150),
                editText159 = (EditText) findViewById(R.id.editTextGpNormarcSixTx1HighCOU150),
                editText160 = (EditText) findViewById(R.id.editTextGpNormarcSixTx2LowCOU150),
                editText161 = (EditText) findViewById(R.id.editTextGpNormarcSixTx2HighCOU150),
                editText162 = (EditText) findViewById(R.id.editTextGpNormarcSixTx1LowCOU90),
                editText163 = (EditText) findViewById(R.id.editTextGpNormarcSixTx1HighCOU90),
                editText164 = (EditText) findViewById(R.id.editTextGpNormarcSixTx2LowCOU90),
                editText165 = (EditText) findViewById(R.id.editTextGpNormarcSixTx2HighCOU90),

                editText166 = (EditText) findViewById(R.id.editTextGpNormarcSixPs1Low15),
                editText167 = (EditText) findViewById(R.id.editTextGpNormarcSixPs1High15),
                editText168 = (EditText) findViewById(R.id.editTextGpNormarcSixPs2Low15),
                editText169 = (EditText) findViewById(R.id.editTextGpNormarcSixPs2High15),
                editText170 = (EditText) findViewById(R.id.editTextGpNormarcSixPs1Low5),
                editText171 = (EditText) findViewById(R.id.editTextGpNormarcSixPs1High5),
                editText172 = (EditText) findViewById(R.id.editTextGpNormarcSixPs2Low5),
                editText173 = (EditText) findViewById(R.id.editTextGpNormarcSixPs2High5),
                editText174 = (EditText) findViewById(R.id.editTextGpNormarcSixPs1Low85),
                editText175 = (EditText) findViewById(R.id.editTextGpNormarcSixPs1High85),
                editText176 = (EditText) findViewById(R.id.editTextGpNormarcSixPs2Low85),
                editText177 = (EditText) findViewById(R.id.editTextGpNormarcSixPs2High85),
                editText178 = (EditText) findViewById(R.id.editTextGpNormarcSixPs1Low15V),
                editText179 = (EditText) findViewById(R.id.editTextGpNormarcSixPs1High15V),
                editText180 = (EditText) findViewById(R.id.editTextGpNormarcSixPs2Low15V),
                editText181 = (EditText) findViewById(R.id.editTextGpNormarcSixPs2High15V),

                editText182 = (EditText) findViewById(R.id.editTextGpNormarcSixObsMon15),
                editText183 = (EditText) findViewById(R.id.editTextGpNormarcSixObsMon25),
                editText184 = (EditText) findViewById(R.id.editTextGpNormarcSixObsMon1STS),
                editText185 = (EditText) findViewById(R.id.editTextGpNormarcSixObsMon2STS),
                editText186 = (EditText) findViewById(R.id.editTextGpNormarcSixObsMon1DSPPFO),
                editText187 = (EditText) findViewById(R.id.editTextGpNormarcSixObsMon2DSPPFO),
                editText188 = (EditText) findViewById(R.id.editTextGpNormarcSixObsMon1DSPERR),
                editText189 = (EditText) findViewById(R.id.editTextGpNormarcSixObsMon2DSPERR),
                editText190 = (EditText) findViewById(R.id.editTextGpNormarcSixObsMon1RST),
                editText191 = (EditText) findViewById(R.id.editTextGpNormarcSixObsMon2RST),
                editText192 = (EditText) findViewById(R.id.editTextGpNormarcSixObsMon1SyncERR),
                editText193 = (EditText) findViewById(R.id.editTextGpNormarcSixObsMon2SyncERR),
                editText194 = (EditText) findViewById(R.id.editTextGpNormarcSixObsMon115),
                editText195 = (EditText) findViewById(R.id.editTextGpNormarcSixObsMon215),
                editText196 = (EditText) findViewById(R.id.editTextGpNormarcSixObsMon115V),
                editText197 = (EditText) findViewById(R.id.editTextGpNormarcSixObsMon215V),

                editText198 = (EditText) findViewById(R.id.editTextGpNormarcSixSetTx1CRSRF),
                editText199 = (EditText) findViewById(R.id.editTextGpNormarcSixSetTx2CRSRF),
                editText200 = (EditText) findViewById(R.id.editTextGpNormarcSixSetTx1CRSBal),
                editText201 = (EditText) findViewById(R.id.editTextGpNormarcSixSetTx2CRSBal),
                editText202 = (EditText) findViewById(R.id.editTextGpNormarcSixSetTx1CRSSum),
                editText203 = (EditText) findViewById(R.id.editTextGpNormarcSixSetTx2CRSSum),
                editText204 = (EditText) findViewById(R.id.editTextGpNormarcSixSetTx1CLRRF),
                editText205 = (EditText) findViewById(R.id.editTextGpNormarcSixSetTx2CLRRF),
                editText206 = (EditText) findViewById(R.id.editTextGpNormarcSixSetTx1CLRBal),
                editText207 = (EditText) findViewById(R.id.editTextGpNormarcSixSetTx2CLRBal),
                editText208 = (EditText) findViewById(R.id.editTextGpNormarcSixSetTx1CLRSum),
                editText209 = (EditText) findViewById(R.id.editTextGpNormarcSixSetTx2CLRSum),

                editText210 = (EditText) findViewById(R.id.editTextGpNormarcSixRemarks)};

//Define and Initialize all Switches serially here

        Switch  switch1,switch2,switch3,switch4;
        switchArray = new Switch[]{
                switch1 = (Switch) findViewById(R.id.switchGpNormarcSixSwitchTx190),
                switch2 = (Switch) findViewById(R.id.switchGpNormarcSixSwitchTx290),
                switch3 = (Switch) findViewById(R.id.switchGpNormarcSixSwitchTx1150),
                switch4 = (Switch) findViewById(R.id.switchGpNormarcSixSwitchTx2150)};
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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.gpnormarc7000six1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(11);

        int[] editTextXPixel = {150,569,123,208,350,227,290,354,423,485,550,227,290,354,423,485,550,227,290,354,423,485,550,227,290,354,423,485,550,
                227,290,354,423,485,550,227,290,354,423,485,550,227,290,354,423,485,550,227,290,354,423,485,550,227,290,354,423,485,550,227,290,354,423,485,550,
                227,290,354,423,485,550,227,290,354,423,485,550,227,290,354,423,485,550,227,290,354,423,485,550,227,290,354,423,485,550,227,290,354,423,485,550,
                227,290,354,423,485,550,227,290,354,423,485,550,227,290,354,423,485,550,227,290,354,423,485,550,278,373,470,548,278,373,470,548};
        int[] editTextYPixel = {165,165,182,182,182,300,300,300,300,300,300,321,321,321,321,321,321,343,343,343,343,343,343,367,367,367,367,367,367,
                387,387,387,387,387,387,410,410,410,410,410,410,431,431,431,431,431,431,454,454,454,454,454,454,477,477,477,477,477,477,499,499,499,499,499,499,
                521,521,521,521,521,521,543,543,543,543,543,543,567,567,567,567,567,567,588,588,588,588,588,588,609,609,609,609,609,609,631,631,631,631,631,631,
                655,655,655,655,655,655,685,685,685,685,685,685,716,716,716,716,716,716,737,737,737,737,737,737,859,859,859,859,884,884,884,884};



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

        canvas.drawText(strData,569,182,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.gpnormarc7000six2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(11);

        int[] editTextXPixel2 = {278,373,468,546,278,373,468,546,278,373,468,546,278,373,468,546,278,373,468,546,278,373,468,546,278,373,468,546,
                278,373,468,546,288,387,487,568,288,387,487,568,288,387,487,568,288,387,487,568,491,571,491,571,491,571,491,571,491,571,491,571,491,571,491,571};
        int[] editTextYPixel2 = {118,118,118,118,154,154,154,154,231,231,231,231,255,255,255,255,282,282,282,282,307,307,307,307,334,334,334,334,
                360,360,360,360,455,455,455,455,481,481,481,481,507,507,507,507,533,533,533,533,668,668,698,698,727,727,757,757,787,787,816,816,846,846,876,876};

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
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.gpnormarc7000six3);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(11);

        int[] editTextXPixel3 = {290,440,290,440,290,440,290,440,290,440,290,440,91};
        int[] editTextYPixel3 = {176,176,196,196,218,218,240,240,262,262,282,282,460};

        int[] switchXPixel5 = {480,565,480,565};
        int[] switchYPixel5 = {370,370,388,388};

        for(int i = 0; i < editTextXPixel3.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel.length+editTextXPixel2.length],editTextXPixel3[i],editTextYPixel3[i],titlePaint);
        }
        for(int i = 0; i < switchXPixel5.length; i++){
            canvas.drawText( switchDataForPDF[i],switchXPixel5[i],switchYPixel5[i],titlePaint);
        }

        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 100, 535, paint);


        myPdfdocument.finishPage(myPage3);

        //-------------------------End of Page 3-----------------


        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Navigation/GPNormarc7000/Six Monthly/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Six Monthly GP Normarc " + strData + ".pdf"; // Change Here--------------------------
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
                "Six Monthly Maintenance of Normarc GP done.",//Change Here-----------------------------
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
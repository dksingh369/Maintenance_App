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

public class LlzNormarc35DfrActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray= {};//Copy
    private Spinner[] spinnerArray={};//Copy
    private String thisActivityName = "LlzNormarc35DfrActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llz_normarc35_dfr);
        //Define and Initialize all EditTexts serially here
        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16,
                editText17, editText18, editText19, editText20, editText21, editText22, editText23, editText24,editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32,
                editText33, editText34, editText35, editText36, editText37, editText38, editText39, editText40, editText41, editText42, editText43, editText44, editText45, editText46, editText47, editText48,
                editText49, editText50, editText51, editText52, editText53, editText54, editText55, editText56, editText57, editText58,editText59, editText60,editText61, editText62,editText63, editText64,
                editText65, editText66, editText67, editText68,editText69, editText70, editText71, editText72, editText73, editText74, editText75, editText76, editText77, editText78, editText79, editText80,
                editText81, editText82, editText83, editText84, editText85, editText86, editText87, editText88,editText89,editText90, editText91, editText92, editText93, editText94,editText95, editText96, editText97, editText98,editText99,
                editText100, editText101, editText102, editText103, editText104, editText105, editText106, editText107, editText108,
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
                editText283,editText284, editText285, editText286, editText287, editText288, editText289, editText290, editText291, editText292, editText293, editText294, editText295, editText296, editText297, editText298, editText299, editText300, editText301,
                editText302, editText303, editText304, editText305, editText306, editText307, editText308,editText309, editText310, editText311, editText312, editText313, editText314, editText315, editText316, editText317, editText318, editText319, editText320,
                editText321, editText322, editText323, editText324,editText325, editText326, editText327, editText328, editText329, editText330, editText331, editText332, editText333, editText334, editText335, editText336, editText337, editText338, editText339,
                 editText340, editText341, editText342, editText343, editText344, editText345, editText346, editText347, editText348, editText349, editText350, editText351;

        editTextArray = new EditText[]{
                editText1 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrStation),
                editText2 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrRegion),

                editText3 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM14),
                editText4 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM14),
                editText5 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF14),
                editText6 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM14),
                editText7 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM14),
                editText8 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF14),

                editText9 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM13),
                editText10 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM13),
                editText11 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF13),
                editText12 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM13),
                editText13 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM13),
                editText14 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF13),

                editText15 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM12),
                editText16 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM12),
                editText17 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF12),
                editText18 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM12),
                editText19 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM12),
                editText20 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF12),

                editText21 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM11),
                editText22 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM11),
                editText23 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF11),
                editText24 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM11),
                editText25 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM11),
                editText26 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF11),

                editText27 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM10),
                editText28 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM10),
                editText29 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF10),
                editText30 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM10),
                editText31 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM10),
                editText32 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF10),

                editText33 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM09),
                editText34 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM09),
                editText35 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF09),
                editText36 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM09),
                editText37 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM09),
                editText38 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF09),

                editText39 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM08),
                editText40 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM08),
                editText41 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF08),
                editText42 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM08),
                editText43 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM08),
                editText44 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF08),

                editText45 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM07),
                editText46 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM07),
                editText47 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF07),
                editText48  = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM07),
                editText49 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM07),
                editText50 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF07),

                editText51 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM06),
                editText52 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM06),
                editText53 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF06),
                editText54 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM06),
                editText55 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM06),
                editText56 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF06),

                editText57 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM05),
                editText58 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM05),
                editText59 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF05),
                editText60 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM05),
                editText61 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM05),
                editText62 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF05),

                editText63 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM04),
                editText64 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM04),
                editText65 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF04),
                editText66 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM04),
                editText67 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM04),
                editText68 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF04),

                editText69 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM03),
                editText70 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM03),
                editText71 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF03),
                editText72 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM03),
                editText73 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM03),
                editText74 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF03),

                editText75 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM02),
                editText76 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM02),
                editText77 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF02),
                editText78 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM02),
                editText79 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM02),
                editText80 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF02),

                editText81 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM01),
                editText82 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM01),
                editText83 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF01),
                editText84 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM01),
                editText85 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM01),
                editText86 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF01),

                editText87 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDMCL),
                editText88 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDMCL),
                editText89 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RFCL),
                editText90 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDMCL),
                editText91 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDMCL),
                editText92 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RFCL),

                editText93 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM01D),
                editText94 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM01D),
                editText95 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF01D),
                editText96 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM01D),
                editText97 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM01D),
                editText98 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF01D),

                editText99 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM02D),
                editText100 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM02D),
                editText101 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF02D),
                editText102 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM02D),
                editText103 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM02D),
                editText104 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF02D),


                editText105 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM03D),
                editText106 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM03D),
                editText107 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF03D),
                editText108 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM03D),
                editText109 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM03D),
                editText110 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF03D),

                editText111 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM04D),
                editText112 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM04D),
                editText113 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF04D),
                editText114 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM04D),
                editText115 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM04D),
                editText116 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF04D),

                editText117 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM05D),
                editText118 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM05D),
                editText119 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF05D),
                editText120 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM05D),
                editText121 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM05D),
                editText122 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF05D),

                editText123 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM06D),
                editText124 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM06D),
                editText125 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF06D),
                editText126 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM06D),
                editText127 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM06D),
                editText128 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF06D),

                editText129 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM07D),
                editText130 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM07D),
                editText131 = (EditText)  findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF07D),
                editText132 = (EditText)  findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM07D),
                editText133 = (EditText)  findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM07D),
                editText134 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF07D),

                editText135 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM08D),
                editText136 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM08D),
                editText137 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF08D),
                editText138 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM08D),
                editText139 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM08D),
                editText140 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF08D),

                editText141 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM09D),
                editText142 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM09D),
                editText143 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF09D),
                editText144 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM09D),
                editText145 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM09D),
                editText146 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF09D),

                editText147 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM10D),
                editText148 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM10D),
                editText149 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF10D),
                editText150 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM10D),
                editText151 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM10D),
                editText152 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF10D),

                editText153 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM11D),
                editText154 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM11D),
                editText155 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF11D),
                editText156 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM11D),
                editText157 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM11D),
                editText158 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF11D),

                editText159 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM12D),
                editText160 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM12D),
                editText161 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF12D),
                editText162 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM12D),
                editText163 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM12D),
                editText164 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF12D),

                editText165 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM13D),
                editText166 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM13D),
                editText167 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF13D),
                editText168 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM13D),
                editText169 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM13D),
                editText170 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF13D),

                editText171 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1DDM14D),
                editText172 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1SDM14D),
                editText173 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx1RF14D),
                editText174 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1DDM14D),
                editText175 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1SDM14D),
                editText176 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx1RF14D),

                editText177 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM14),
                editText178 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM14),
                editText179 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF14),
                editText180 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM14),
                editText181 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM14),
                editText182 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF14),

                editText183 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM13),
                editText184 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM13),
                editText185 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF13),
                editText186 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM13),
                editText187 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM13),
                editText188 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF13),

                editText189 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM12),
                editText190 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM12),
                editText191 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF12),
                editText192 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM12),
                editText193 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM12),
                editText194 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF12),

                editText195 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM11),
                editText196 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM11),
                editText197 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF11),
                editText198 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM11),
                editText199 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM11),
                editText200 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF11),

                editText201 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM10),
                editText202 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM10),
                editText203 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF10),
                editText204 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM10),
                editText205 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM10),
                editText206 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF10),

                editText207 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM09),
                editText208 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM09),
                editText209 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF09),
                editText210 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM09),
                editText211 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM09),
                editText212 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF09),

                editText213 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM08),
                editText214 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM08),
                editText215 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF08),
                editText216 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM08),
                editText217 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM08),
                editText218 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF08),

                editText219 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM07),
                editText220 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM07),
                editText221 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF07),
                editText222  = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM07),
                editText223 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM07),
                editText224 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF07),

                editText225 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM06),
                editText226 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM06),
                editText227 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF06),
                editText228 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM06),
                editText229 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM06),
                editText230 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF06),

                editText231 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM05),
                editText232 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM05),
                editText233 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF05),
                editText234 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM05),
                editText235 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM05),
                editText236 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF05),

                editText237 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM04),
                editText238 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM04),
                editText239 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF04),
                editText240 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM04),
                editText241 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM04),
                editText242 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF04),

                editText243 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM03),
                editText244 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM03),
                editText245 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF03),
                editText246 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM03),
                editText247 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM03),
                editText248 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF03),

                editText249 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM02),
                editText250 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM02),
                editText251 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF02),
                editText252 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM02),
                editText253 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM02),
                editText254 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF02),

                editText255 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM01),
                editText256 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM01),
                editText257 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF01),
                editText258 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM01),
                editText259 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM01),
                editText260 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF01),

                editText261 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDMCL),
                editText262 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDMCL),
                editText263 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RFCL),
                editText264 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDMCL),
                editText265 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDMCL),
                editText266 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RFCL),

                editText267 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM01D),
                editText268 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM01D),
                editText269 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF01D),
                editText270 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM01D),
                editText271 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM01D),
                editText272 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF01D),

                editText273 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM02D),
                editText274 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM02D),
                editText275 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF02D),
                editText276 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM02D),
                editText277 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM02D),
                editText278 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF02D),

                editText279 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM03D),
                editText280 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM03D),
                editText281 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF03D),
                editText282 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM03D),
                editText283 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM03D),
                editText284 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF03D),

                editText285 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM04D),
                editText286 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM04D),
                editText287 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF04D),
                editText288 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM04D),
                editText289 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM04D),
                editText290 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF04D),

                editText291 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM05D),
                editText292 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM05D),
                editText293 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF05D),
                editText294 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM05D),
                editText295 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM05D),
                editText296 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF05D),

                editText297 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM06D),
                editText298 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM06D),
                editText299 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF06D),
                editText300 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM06D),
                editText301 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM06D),
                editText302 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF06D),

                editText303 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM07D),
                editText304 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM07D),
                editText305 = (EditText)  findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF07D),
                editText306 = (EditText)  findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM07D),
                editText307 = (EditText)  findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM07D),
                editText308 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF07D),

                editText309 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM08D),
                editText310 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM08D),
                editText311 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF08D),
                editText312 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM08D),
                editText313 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM08D),
                editText314 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF08D),

                editText315 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM09D),
                editText316 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM09D),
                editText317 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF09D),
                editText318 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM09D),
                editText319 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM09D),
                editText320 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF09D),

                editText321 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM10D),
                editText322 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM10D),
                editText323 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF10D),
                editText324 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM10D),
                editText325 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM10D),
                editText326 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF10D),

                editText327 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM11D),
                editText328 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM11D),
                editText329 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF11D),
                editText330 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM11D),
                editText331 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM11D),
                editText332 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF11D),

                editText333 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM12D),
                editText334 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM12D),
                editText335 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF12D),
                editText336 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM12D),
                editText337 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM12D),
                editText338 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF12D),

                editText339 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM13D),
                editText340 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM13D),
                editText341 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF13D),
                editText342 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM13D),
                editText343 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM13D),
                editText344 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF13D),

                editText345 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2DDM14D),
                editText346 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2SDM14D),
                editText347 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrNmlTx2RF14D),
                editText348 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2DDM14D),
                editText349 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2SDM14D),
                editText350 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrObsTx2RF14D),

                editText351 = (EditText) findViewById(R.id.editTextLlzNormarc35DfrRemarks)};

        //Define and Initialize all Switches serially here


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

       // String outputSwitch = myFunctions.getSwitchStatusForPDF(switchArray);

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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llznormarc35dfr1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(11);

        int[] editTextXPixel = {176,340,81,126,168,257,300,344,81,126,168,257,300,344,81,126,168,257,300,344,81,126,168,257,300,344,81,126,168,257,300,344,
                81,126,168,257,300,344,81,126,168,257,300,344,81,126,168,257,300,344,81,126,168,257,300,344,81,126,168,257,300,344,81,126,168,257,300,344,
                81,126,168,257,300,344,81,126,168,257,300,344,81,126,168,257,300,344,81,126,168,257,300,344,81,126,168,257,300,344,81,126,168,257,300,344,
                81,126,168,257,300,344,81,126,168,257,300,344,81,126,168,257,300,344,81,126,168,257,300,344,81,126,168,257,300,344,81,126,168,257,300,344,
                81,126,168,257,300,344,81,126,168,257,300,344,81,126,168,257,300,344,81,126,168,257,300,344,81,126,168,257,300,344,81,126,168,257,300,344,
                388,431,476,562,606,650,388,431,476,562,606,650,388,431,476,562,606,650,388,431,476,562,606,650,388,431,476,562,606,650,388,431,476,562,606,650,
                388,431,476,562,606,650,388,431,476,562,606,650,388,431,476,562,606,650,388,431,476,562,606,650,388,431,476,562,606,650,388,431,476,562,606,650,
                388,431,476,562,606,650,388,431,476,562,606,650,388,431,476,562,606,650,388,431,476,562,606,650,388,431,476,562,606,650,388,431,476,562,606,650,
                388,431,476,562,606,650,388,431,476,562,606,650,388,431,476,562,606,650,388,431,476,562,606,650,388,431,476,562,606,650,388,431,476,562,606,650,
                388,431,476,562,606,650,388,431,476,562,606,650,388,431,476,562,606,650,388,431,476,562,606,650,388,431,476,562,606,650,150};
        int[] editTextYPixel = {144,144,272,272,272,272,272,272,289,289,289,289,289,289,308,308,308,308,308,308,324,324,324,324,324,324,343,343,343,343,343,343,
                360,360,360,360,360,360,378,378,378,378,378,378,396,396,396,396,396,396,412,412,412,412,412,412,430,430,430,430,430,430,447,447,447,447,447,447,
                465,465,465,465,465,465,483,483,483,483,483,483,500,500,500,500,500,500,518,518,518,518,518,518,538,538,538,538,538,538,553,553,553,553,553,553,
                571,571,571,571,571,571,588,588,588,588,588,588,606,606,606,606,606,606,624,624,624,624,624,624,640,640,640,640,640,640,659,659,659,659,659,659,
                676,676,676,676,676,676,693,693,693,693,693,693,711,711,711,711,711,711,729,729,729,729,729,729,746,746,746,746,746,746,763,763,763,763,763,763,
                272,272,272,272,272,272,289,289,289,289,289,289,308,308,308,308,308,308,324,324,324,324,324,324,343,343,343,343,343,343,360,360,360,360,360,360,
                378,378,378,378,378,378,396,396,396,396,396,396,412,412,412,412,412,412,430,430,430,430,430,430,447,447,447,447,447,447,465,465,465,465,465,465,
                483,483,483,483,483,483,500,500,500,500,500,500,518,518,518,518,518,518,538,538,538,538,538,538,553,553,553,553,553,553,571,571,571,571,571,571,
                588,588,588,588,588,588,606,606,606,606,606,606,624,624,624,624,624,624,640,640,640,640,640,640,659,659,659,659,659,659,676,676,676,676,676,676,
                693,693,693,693,693,693,711,711,711,711,711,711,729,729,729,729,729,729,746,746,746,746,746,746,763,763,763,763,763,763,785};




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

        canvas.drawText(strData,523,140,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llznormarc35dfr2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        paint.setTextAlign(Paint.Align.LEFT);

        titlePaint.setTextSize(12);
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 100, 135, paint);
        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------

        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Navigation/LLZNormarc3513/DFR/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "DFR LLZ Normarc 3513" + strData + ".pdf"; // Change Here--------------------------
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
        myFunctions.saveToParse(targetPdf, fileName,"ILS","Daily",outputEditText,MyFunctions.specificCode("d"),"outputSwitch", "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "DFR Maintenance of Normarc 3513 LLZ done.",//Change Here-----------------------------
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
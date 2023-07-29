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

public class AsmgcsSaabMonthlyActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray={};//Copy
    private Spinner[] spinnerArray={};//Copy
    private String thisActivityName = "AsmgcsSaabMonthlyActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asmgcs_saab_monthly);
        //Define and Initialize all EditTexts serially here
        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16,
                editText17, editText18, editText19,editText20, editText21, editText22, editText23, editText24, editText25, editText26, editText27,editText28, editText29, editText30, editText31, editText32, editText33, editText34, editText35,
                editText36, editText37,editText38, editText39, editText40, editText41, editText42, editText43, editText44, editText45,editText46, editText47, editText48, editText49, editText50, editText51, editText52, editText53,
                editText54, editText55, editText56, editText57, editText58, editText59, editText60, editText61, editText62, editText63,editText64,editText65, editText66, editText67,editText68, editText69, editText70, editText71, editText72, editText73, editText74, editText75,
                editText76, editText77,editText78, editText79, editText80, editText81, editText82, editText83, editText84, editText85,editText86, editText87, editText88, editText89, editText90, editText91, editText92, editText93,
                editText94, editText95, editText96, editText97, editText98, editText99, editText100, editText101, editText102, editText103,editText104, editText105,editText106, editText107, editText108, editText109, editText110, editText111, editText112, editText113,
                editText114, editText115, editText116, editText117, editText118,editText119, editText120, editText121, editText122, editText123, editText124, editText125, editText126,
                editText127, editText128, editText129,editText130, editText131, editText132, editText133, editText134, editText135, editText136, editText137,editText138, editText139, editText140, editText141, editText142, editText143, editText144, editText145,
                editText146, editText147, editText148, editText149, editText150, editText151, editText152, editText153, editText154, editText155, editText156, editText157, editText158, editText159, editText160, editText161, editText162, editText163,editText164,
                editText165, editText166, editText167,editText168, editText169, editText170, editText171, editText172, editText173, editText174, editText175, editText176, editText177,editText178, editText179, editText180, editText181, editText182, editText183,
                editText184, editText185,editText186, editText187, editText188, editText189, editText190, editText191, editText192, editText193, editText194, editText195, editText196, editText197, editText198, editText199, editText200, editText201, editText202,
                editText203,editText204, editText205,editText206, editText207, editText208, editText209, editText210, editText211, editText212, editText213, editText214, editText215, editText216, editText217, editText218, editText219,editText220, editText221, editText222,
                editText223, editText224, editText225, editText226, editText227,editText228, editText229, editText230, editText231, editText232, editText233, editText234, editText235,
                editText236, editText237,editText238, editText239, editText240, editText241, editText242, editText243, editText244, editText245,editText246, editText247, editText248, editText249, editText250, editText251, editText252, editText253,
                editText254, editText255, editText256, editText257, editText258, editText259, editText260, editText261, editText262, editText263,editText264,editText265, editText266, editText267,editText268, editText269, editText270, editText271, editText272, editText273, editText274, editText275,
                editText276, editText277,editText278, editText279, editText280, editText281, editText282, editText283, editText284, editText285,editText286, editText287, editText288, editText289, editText290, editText291, editText292, editText293,
                editText294, editText295, editText296, editText297, editText298, editText299, editText300,editText301, editText302, editText303, editText304, editText305, editText306, editText307, editText308,editText309, editText310, editText311, editText312, editText313, editText314, editText315, editText316,
                editText317, editText318, editText319,editText320, editText321, editText322, editText323, editText324, editText325, editText326, editText327,editText328, editText329, editText330, editText331, editText332, editText333, editText334, editText335,
                editText336, editText337,editText338, editText339, editText340, editText341, editText342, editText343, editText344, editText345,editText346, editText347, editText348, editText349, editText350, editText351, editText352, editText353,
                editText354, editText355, editText356, editText357, editText358, editText359, editText360, editText361, editText362, editText363,editText364,editText365, editText366, editText367,editText368, editText369, editText370, editText371, editText372, editText373, editText374, editText375,
                editText376, editText377,editText378, editText379, editText380, editText381, editText382, editText383, editText384, editText385,editText386, editText387, editText388, editText389, editText390, editText391, editText392, editText393,
                editText394, editText395, editText396, editText397, editText398, editText399, editText400,editText401, editText402, editText403, editText404, editText405, editText406, editText407, editText408,editText409, editText410, editText411, editText412, editText413, editText414, editText415, editText416,
                editText417, editText418, editText419,editText420, editText421, editText422, editText423, editText424, editText425, editText426, editText427,editText428, editText429, editText430, editText431, editText432, editText433, editText434, editText435,
                editText436, editText437,editText438, editText439, editText440, editText441, editText442, editText443, editText444, editText445,editText446, editText447, editText448, editText449, editText450, editText451, editText452, editText453,
                editText454, editText455, editText456, editText457, editText458, editText459, editText460, editText461, editText462, editText463,editText464,editText465, editText466, editText467,editText468, editText469, editText470, editText471, editText472, editText473, editText474, editText475,
                editText476, editText477,editText478, editText479, editText480, editText481, editText482, editText483, editText484, editText485,editText486, editText487, editText488, editText489, editText490, editText491, editText492, editText493,
                editText494, editText495, editText496, editText497, editText498, editText499, editText500,editText501, editText502, editText503, editText504, editText505, editText506, editText507, editText508,editText509, editText510, editText511, editText512, editText513, editText514, editText515, editText516,
                editText517, editText518, editText519,editText520, editText521, editText522, editText523, editText524, editText525, editText526, editText527,editText528, editText529, editText530, editText531, editText532, editText533, editText534, editText535,
                editText536, editText537,editText538, editText539, editText540, editText541, editText542, editText543, editText544, editText545,editText546, editText547, editText548, editText549, editText550, editText551, editText552, editText553,
                editText554, editText555, editText556, editText557, editText558, editText559, editText560, editText561, editText562, editText563,editText564,editText565, editText566, editText567,editText568, editText569, editText570, editText571, editText572, editText573, editText574, editText575,
                editText576, editText577,editText578, editText579, editText580, editText581, editText582, editText583, editText584, editText585,editText586, editText587, editText588, editText589, editText590, editText591, editText592, editText593,
                editText594, editText595, editText596, editText597, editText598, editText599, editText600,editText601, editText602, editText603, editText604, editText605, editText606, editText607, editText608,editText609, editText610, editText611, editText612, editText613, editText614, editText615, editText616,
                editText617, editText618, editText619,editText620, editText621, editText622, editText623, editText624, editText625, editText626, editText627,editText628, editText629, editText630, editText631, editText632, editText633, editText634, editText635,
                editText636, editText637,editText638, editText639, editText640, editText641, editText642, editText643, editText644, editText645,editText646, editText647, editText648, editText649, editText650, editText651, editText652, editText653,
                editText654, editText655, editText656, editText657, editText658, editText659, editText660, editText661, editText662, editText663,editText664,editText665, editText666, editText667,editText668, editText669, editText670, editText671, editText672, editText673, editText674, editText675,
                editText676, editText677,editText678, editText679, editText680, editText681, editText682, editText683, editText684, editText685,editText686, editText687, editText688, editText689, editText690, editText691, editText692, editText693,
                editText694, editText695, editText696, editText697, editText698, editText699, editText700,editText701, editText702, editText703, editText704, editText705, editText706, editText707, editText708,editText709, editText710, editText711, editText712, editText713, editText714, editText715, editText716,
                editText717, editText718, editText719,editText720, editText721, editText722, editText723, editText724, editText725, editText726, editText727,editText728, editText729, editText730, editText731, editText732, editText733, editText734, editText735,
                editText736, editText737,editText738, editText739, editText740, editText741, editText742, editText743, editText744, editText745,editText746, editText747, editText748, editText749, editText750, editText751, editText752, editText753,
                editText754, editText755, editText756, editText757, editText758, editText759, editText760, editText761, editText762, editText763,editText764,editText765, editText766, editText767,editText768, editText769, editText770, editText771, editText772, editText773, editText774, editText775,
                editText776, editText777,editText778, editText779, editText780, editText781, editText782, editText783, editText784, editText785,editText786, editText787, editText788, editText789, editText790, editText791, editText792, editText793,
                editText794, editText795, editText796, editText797, editText798, editText799, editText800,editText801, editText802, editText803, editText804, editText805, editText806, editText807, editText808,editText809, editText810, editText811, editText812, editText813, editText814, editText815, editText816,
                editText817, editText818, editText819,editText820, editText821, editText822, editText823, editText824, editText825, editText826, editText827,editText828, editText829, editText830, editText831, editText832, editText833, editText834, editText835,
                editText836, editText837,editText838, editText839, editText840, editText841, editText842, editText843, editText844, editText845,editText846, editText847, editText848, editText849, editText850, editText851, editText852, editText853,
                editText854, editText855, editText856, editText857, editText858, editText859, editText860, editText861, editText862, editText863,editText864,editText865, editText866, editText867,editText868, editText869, editText870, editText871, editText872, editText873, editText874, editText875,
                editText876, editText877,editText878, editText879, editText880, editText881, editText882, editText883, editText884, editText885,editText886, editText887, editText888, editText889, editText890, editText891, editText892, editText893,
                editText894, editText895, editText896, editText897, editText898, editText899, editText900,editText901, editText902, editText903, editText904, editText905, editText906, editText907, editText908,editText909, editText910, editText911, editText912, editText913, editText914, editText915, editText916,
                editText917, editText918, editText919,editText920, editText921, editText922, editText923, editText924, editText925, editText926, editText927,editText928, editText929, editText930, editText931, editText932, editText933, editText934, editText935,
                editText936, editText937,editText938, editText939, editText940, editText941, editText942, editText943, editText944, editText945,editText946, editText947, editText948, editText949, editText950, editText951, editText952, editText953,
                editText954, editText955, editText956, editText957, editText958, editText959, editText960, editText961, editText962, editText963,editText964,editText965, editText966, editText967,editText968, editText969, editText970, editText971, editText972, editText973, editText974, editText975,
                editText976, editText977,editText978, editText979, editText980, editText981, editText982, editText983, editText984, editText985,editText986, editText987, editText988, editText989, editText990, editText991, editText992, editText993,
                editText994, editText995, editText996, editText997, editText998, editText999, editText1000,editText1001, editText1002, editText1003, editText1004, editText1005, editText1006, editText1007, editText1008,editText1009, editText1010, editText1011, editText1012, editText1013, editText1014, editText1015, editText1016,
                editText1017, editText1018,editText1019;

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
                editText117 = (EditText) findViewById(R.id.editText118),
                editText118 = (EditText) findViewById(R.id.editText119),
                editText119 = (EditText) findViewById(R.id.editText120),
                editText120 = (EditText) findViewById(R.id.editText121),
                editText121 = (EditText) findViewById(R.id.editText122),
                editText122 = (EditText) findViewById(R.id.editText123),
                editText123 = (EditText) findViewById(R.id.editText124),
                editText124 = (EditText) findViewById(R.id.editText125),
                editText125 = (EditText) findViewById(R.id.editText126),
                editText126 = (EditText) findViewById(R.id.editText127),
                editText127 = (EditText) findViewById(R.id.editText128),
                editText128 =(EditText) findViewById(R.id.editText129),
                editText129 =(EditText)  findViewById(R.id.editText130),
                editText130 = (EditText) findViewById(R.id.editText131),
                editText131 =(EditText)  findViewById(R.id.editText132),
                editText132 = (EditText) findViewById(R.id.editText133),
                editText133 = (EditText) findViewById(R.id.editText134),
                editText134 = (EditText) findViewById(R.id.editText135),
                editText135 = (EditText) findViewById(R.id.editText136),
                editText136 = (EditText) findViewById(R.id.editText137),
                editText137 = (EditText) findViewById(R.id.editText138),
                editText138 = (EditText) findViewById(R.id.editText139),
                editText139 = (EditText) findViewById(R.id.editText140),
                editText140 = (EditText) findViewById(R.id.editText141),
                editText141 = (EditText) findViewById(R.id.editText142),
                editText142 = (EditText) findViewById(R.id.editText143),
                editText143 = (EditText) findViewById(R.id.editText144),
                editText144 = (EditText) findViewById(R.id.editText145),
                editText145 = (EditText) findViewById(R.id.editText146),
                editText146 =(EditText) findViewById(R.id.editText147),
                editText147 =(EditText)  findViewById(R.id.editText148),
                editText148 = (EditText) findViewById(R.id.editText149),
                editText149 =(EditText)  findViewById(R.id.editText150),
                editText150 = (EditText) findViewById(R.id.editText151),
                editText151 = (EditText) findViewById(R.id.editText152),
                editText152 = (EditText) findViewById(R.id.editText153),
                editText153 = (EditText) findViewById(R.id.editText154),
                editText154 = (EditText) findViewById(R.id.editText155),
                editText155 = (EditText) findViewById(R.id.editText156),
                editText156 = (EditText) findViewById(R.id.editText157),
                editText157 = (EditText) findViewById(R.id.editText158),
                editText158 = (EditText) findViewById(R.id.editText159),
                editText159 = (EditText) findViewById(R.id.editText160),
                editText160 = (EditText) findViewById(R.id.editText161),
                editText161 = (EditText) findViewById(R.id.editText162),
                editText162 = (EditText) findViewById(R.id.editText163),
                editText163 = (EditText) findViewById(R.id.editText164),
                editText164 = (EditText) findViewById(R.id.editText165),
                editText165 = (EditText) findViewById(R.id.editText166),
                editText166 = (EditText) findViewById(R.id.editText167),
                editText167 = (EditText) findViewById(R.id.editText168),
                editText168 = (EditText) findViewById(R.id.editText169),
                editText169 = (EditText) findViewById(R.id.editText170),
                editText170 = (EditText) findViewById(R.id.editText171),
                editText171 = (EditText) findViewById(R.id.editText172),
                editText172 = (EditText) findViewById(R.id.editText173),
                editText173 = (EditText) findViewById(R.id.editText174),
                editText174 = (EditText) findViewById(R.id.editText175),
                editText175 = (EditText) findViewById(R.id.editText176),
                editText176 = (EditText) findViewById(R.id.editText177),
                editText177 = (EditText) findViewById(R.id.editText178),
                editText178 =(EditText) findViewById(R.id.editText179),
                editText179 =(EditText)  findViewById(R.id.editText180),
                editText180 = (EditText) findViewById(R.id.editText181),
                editText181 =(EditText)  findViewById(R.id.editText182),
                editText182 = (EditText) findViewById(R.id.editText183),
                editText183 = (EditText) findViewById(R.id.editText184),
                editText184 = (EditText) findViewById(R.id.editText185),
                editText185 = (EditText) findViewById(R.id.editText186),
                editText186 = (EditText) findViewById(R.id.editText187),
                editText187 = (EditText) findViewById(R.id.editText188),
                editText188 = (EditText) findViewById(R.id.editText189),
                editText189 = (EditText) findViewById(R.id.editText190),
                editText190 = (EditText) findViewById(R.id.editText191),
                editText191 = (EditText) findViewById(R.id.editText192),
                editText192 = (EditText) findViewById(R.id.editText193),
                editText193 = (EditText) findViewById(R.id.editText194),
                editText194 = (EditText) findViewById(R.id.editText195),
                editText195 = (EditText) findViewById(R.id.editText196),
                editText196 =(EditText) findViewById(R.id.editText197),
                editText197 =(EditText)  findViewById(R.id.editText198),
                editText198 = (EditText) findViewById(R.id.editText199),
                editText199 =(EditText)  findViewById(R.id.editText200),
                editText200 = (EditText) findViewById(R.id.editText201),
                editText201 = (EditText) findViewById(R.id.editText202),
                editText202 = (EditText) findViewById(R.id.editText203),
                editText203 = (EditText) findViewById(R.id.editText204),
                editText204 = (EditText) findViewById(R.id.editText205),
                editText205 = (EditText) findViewById(R.id.editText206),
                editText206 = (EditText) findViewById(R.id.editText207),
                editText207 = (EditText) findViewById(R.id.editText208),
                editText208 = (EditText) findViewById(R.id.editText209),
                editText209 = (EditText) findViewById(R.id.editText210),
                editText210 =(EditText) findViewById(R.id.editText211),
                editText211 =(EditText)  findViewById(R.id.editText212),
                editText212 = (EditText) findViewById(R.id.editText213),
                editText213 =(EditText)  findViewById(R.id.editText214),
                editText214 = (EditText) findViewById(R.id.editText215),
                editText215 = (EditText) findViewById(R.id.editText216),
                editText216 = (EditText) findViewById(R.id.editText217),
                editText217 = (EditText) findViewById(R.id.editText218),
                editText218 = (EditText) findViewById(R.id.editText219),
                editText219 = (EditText) findViewById(R.id.editText220),
                editText220 = (EditText) findViewById(R.id.editText221),
                editText221 = (EditText) findViewById(R.id.editText222),
                editText222 = (EditText) findViewById(R.id.editText223),
                editText223 = (EditText) findViewById(R.id.editText224),
                editText224 = (EditText) findViewById(R.id.editText225),
                editText225 = (EditText) findViewById(R.id.editText226),
                editText226 = (EditText) findViewById(R.id.editText227),
                editText227 = (EditText) findViewById(R.id.editText228),
                editText228 =(EditText) findViewById(R.id.editText229),
                editText229 =(EditText)  findViewById(R.id.editText230),
                editText230 = (EditText) findViewById(R.id.editText231),
                editText231 =(EditText)  findViewById(R.id.editText232),
                editText232 = (EditText) findViewById(R.id.editText233),
                editText233 = (EditText) findViewById(R.id.editText234),
                editText234 = (EditText) findViewById(R.id.editText235),
                editText235 = (EditText) findViewById(R.id.editText236),
                editText236 = (EditText) findViewById(R.id.editText237),
                editText237 = (EditText) findViewById(R.id.editText238),
                editText238 = (EditText) findViewById(R.id.editText239),
                editText239 = (EditText) findViewById(R.id.editText240),
                editText240 = (EditText) findViewById(R.id.editText241),
                editText241 = (EditText) findViewById(R.id.editText242),
                editText242 = (EditText) findViewById(R.id.editText243),
                editText243 = (EditText) findViewById(R.id.editText244),
                editText244 = (EditText) findViewById(R.id.editText245),
                editText245 = (EditText) findViewById(R.id.editText246),
                editText246 =(EditText) findViewById(R.id.editText247),
                editText247 =(EditText)  findViewById(R.id.editText248),
                editText248 = (EditText) findViewById(R.id.editText249),
                editText249 =(EditText)  findViewById(R.id.editText250),
                editText250 = (EditText) findViewById(R.id.editText251),
                editText251 = (EditText) findViewById(R.id.editText252),
                editText252 = (EditText) findViewById(R.id.editText253),
                editText253 = (EditText) findViewById(R.id.editText254),
                editText254 = (EditText) findViewById(R.id.editText255),
                editText255 = (EditText) findViewById(R.id.editText256),
                editText256 = (EditText) findViewById(R.id.editText257),
                editText257 = (EditText) findViewById(R.id.editText258),
                editText258 = (EditText) findViewById(R.id.editText259),
                editText259 = (EditText) findViewById(R.id.editText260),
                editText260 = (EditText) findViewById(R.id.editText261),
                editText261 = (EditText) findViewById(R.id.editText262),
                editText262 = (EditText) findViewById(R.id.editText263),
                editText263 = (EditText) findViewById(R.id.editText264),
                editText264 = (EditText) findViewById(R.id.editText265),
                editText265 = (EditText) findViewById(R.id.editText266),
                editText266 = (EditText) findViewById(R.id.editText267),
                editText267 = (EditText) findViewById(R.id.editText268),
                editText268 = (EditText) findViewById(R.id.editText269),
                editText269 = (EditText) findViewById(R.id.editText270),
                editText270 = (EditText) findViewById(R.id.editText271),
                editText271 = (EditText) findViewById(R.id.editText272),
                editText272 = (EditText) findViewById(R.id.editText273),
                editText273 = (EditText) findViewById(R.id.editText274),
                editText274 = (EditText) findViewById(R.id.editText275),
                editText275 = (EditText) findViewById(R.id.editText276),
                editText276 = (EditText) findViewById(R.id.editText277),
                editText277 = (EditText) findViewById(R.id.editText278),
                editText278 =(EditText) findViewById(R.id.editText279),
                editText279 =(EditText)  findViewById(R.id.editText280),
                editText280 = (EditText) findViewById(R.id.editText281),
                editText281 =(EditText)  findViewById(R.id.editText282),
                editText282 = (EditText) findViewById(R.id.editText283),
                editText283 = (EditText) findViewById(R.id.editText284),
                editText284 = (EditText) findViewById(R.id.editText285),
                editText285 = (EditText) findViewById(R.id.editText286),
                editText286 = (EditText) findViewById(R.id.editText287),
                editText287 = (EditText) findViewById(R.id.editText288),
                editText288 = (EditText) findViewById(R.id.editText289),
                editText289 = (EditText) findViewById(R.id.editText290),
                editText290 = (EditText) findViewById(R.id.editText291),
                editText291 = (EditText) findViewById(R.id.editText292),
                editText292 = (EditText) findViewById(R.id.editText293),
                editText293 = (EditText) findViewById(R.id.editText294),
                editText294 = (EditText) findViewById(R.id.editText295),
                editText295 = (EditText) findViewById(R.id.editText296),
                editText296 =(EditText) findViewById(R.id.editText297),
                editText297 =(EditText)  findViewById(R.id.editText298),
                editText298 = (EditText) findViewById(R.id.editText299),
                editText299 =(EditText)  findViewById(R.id.editText300),
                editText300 = (EditText) findViewById(R.id.editText301),
                editText301 = (EditText) findViewById(R.id.editText302),
                editText302 = (EditText) findViewById(R.id.editText303),
                editText303 = (EditText) findViewById(R.id.editText304),
                editText304 = (EditText) findViewById(R.id.editText305),
                editText305 = (EditText) findViewById(R.id.editText306),
                editText306 = (EditText) findViewById(R.id.editText307),
                editText307 = (EditText) findViewById(R.id.editText308),
                editText308 = (EditText) findViewById(R.id.editText309),
                editText309 = (EditText) findViewById(R.id.editText310),
                editText310 =(EditText) findViewById(R.id.editText311),
                editText311 =(EditText)  findViewById(R.id.editText312),
                editText312 = (EditText) findViewById(R.id.editText313),
                editText313 =(EditText)  findViewById(R.id.editText314),
                editText314 = (EditText) findViewById(R.id.editText315),
                editText315 = (EditText) findViewById(R.id.editText316),
                editText316 = (EditText) findViewById(R.id.editText317),
                editText317 = (EditText) findViewById(R.id.editText318),
                editText318 = (EditText) findViewById(R.id.editText319),
                editText319 = (EditText) findViewById(R.id.editText320),
                editText320 = (EditText) findViewById(R.id.editText321),
                editText321 = (EditText) findViewById(R.id.editText322),
                editText322 = (EditText) findViewById(R.id.editText323),
                editText323 = (EditText) findViewById(R.id.editText324),
                editText324 = (EditText) findViewById(R.id.editText325),
                editText325 = (EditText) findViewById(R.id.editText326),
                editText326 = (EditText) findViewById(R.id.editText327),
                editText327 = (EditText) findViewById(R.id.editText328),
                editText328 =(EditText) findViewById(R.id.editText329),
                editText329 =(EditText)  findViewById(R.id.editText330),
                editText330 = (EditText) findViewById(R.id.editText331),
                editText331 =(EditText)  findViewById(R.id.editText332),
                editText332 = (EditText) findViewById(R.id.editText333),
                editText333 = (EditText) findViewById(R.id.editText334),
                editText334 = (EditText) findViewById(R.id.editText335),
                editText335 = (EditText) findViewById(R.id.editText336),
                editText336 = (EditText) findViewById(R.id.editText337),
                editText337 = (EditText) findViewById(R.id.editText338),
                editText338 = (EditText) findViewById(R.id.editText339),
                editText339 = (EditText) findViewById(R.id.editText340),
                editText340 = (EditText) findViewById(R.id.editText341),
                editText341 = (EditText) findViewById(R.id.editText342),
                editText342 = (EditText) findViewById(R.id.editText343),
                editText343 = (EditText) findViewById(R.id.editText344),
                editText344 = (EditText) findViewById(R.id.editText345),
                editText345 = (EditText) findViewById(R.id.editText346),
                editText346 =(EditText) findViewById(R.id.editText347),
                editText347 =(EditText)  findViewById(R.id.editText348),
                editText348 = (EditText) findViewById(R.id.editText349),
                editText349 =(EditText)  findViewById(R.id.editText350),
                editText350 = (EditText) findViewById(R.id.editText351),
                editText351 = (EditText) findViewById(R.id.editText352),
                editText352 = (EditText) findViewById(R.id.editText353),
                editText353 = (EditText) findViewById(R.id.editText354),
                editText354 = (EditText) findViewById(R.id.editText355),
                editText355 = (EditText) findViewById(R.id.editText356),
                editText356 = (EditText) findViewById(R.id.editText357),
                editText357 = (EditText) findViewById(R.id.editText358),
                editText358 = (EditText) findViewById(R.id.editText359),
                editText359 = (EditText) findViewById(R.id.editText360),
                editText360 = (EditText) findViewById(R.id.editText361),
                editText361 = (EditText) findViewById(R.id.editText362),
                editText362 = (EditText) findViewById(R.id.editText363),
                editText363 = (EditText) findViewById(R.id.editText364),
                editText364 = (EditText) findViewById(R.id.editText365),
                editText365 = (EditText) findViewById(R.id.editText366),
                editText366 = (EditText) findViewById(R.id.editText367),
                editText367 = (EditText) findViewById(R.id.editText368),
                editText368 = (EditText) findViewById(R.id.editText369),
                editText369 = (EditText) findViewById(R.id.editText370),
                editText370 = (EditText) findViewById(R.id.editText371),
                editText371 = (EditText) findViewById(R.id.editText372),
                editText372 = (EditText) findViewById(R.id.editText373),
                editText373 = (EditText) findViewById(R.id.editText374),
                editText374 = (EditText) findViewById(R.id.editText375),
                editText375 = (EditText) findViewById(R.id.editText376),
                editText376 = (EditText) findViewById(R.id.editText377),
                editText377 = (EditText) findViewById(R.id.editText378),
                editText378 =(EditText) findViewById(R.id.editText379),
                editText379 =(EditText)  findViewById(R.id.editText380),
                editText380 = (EditText) findViewById(R.id.editText381),
                editText381 =(EditText)  findViewById(R.id.editText382),
                editText382 = (EditText) findViewById(R.id.editText383),
                editText383 = (EditText) findViewById(R.id.editText384),
                editText384 = (EditText) findViewById(R.id.editText385),
                editText385 = (EditText) findViewById(R.id.editText386),
                editText386 = (EditText) findViewById(R.id.editText387),
                editText387 = (EditText) findViewById(R.id.editText388),
                editText388 = (EditText) findViewById(R.id.editText389),
                editText389 = (EditText) findViewById(R.id.editText390),
                editText390 = (EditText) findViewById(R.id.editText391),
                editText391 = (EditText) findViewById(R.id.editText392),
                editText392 = (EditText) findViewById(R.id.editText393),
                editText393 = (EditText) findViewById(R.id.editText394),
                editText394 = (EditText) findViewById(R.id.editText395),
                editText395 = (EditText) findViewById(R.id.editText396),
                editText396 =(EditText) findViewById(R.id.editText397),
                editText397 =(EditText)  findViewById(R.id.editText398),
                editText398 = (EditText) findViewById(R.id.editText399),
                editText399 =(EditText)  findViewById(R.id.editText400),
                editText400 = (EditText) findViewById(R.id.editText401),
                editText401 = (EditText) findViewById(R.id.editText402),
                editText402 = (EditText) findViewById(R.id.editText403),
                editText403 = (EditText) findViewById(R.id.editText404),
                editText404 = (EditText) findViewById(R.id.editText405),
                editText405 = (EditText) findViewById(R.id.editText406),
                editText406 = (EditText) findViewById(R.id.editText407),
                editText407 = (EditText) findViewById(R.id.editText408),
                editText408 = (EditText) findViewById(R.id.editText409),
                editText409 = (EditText) findViewById(R.id.editText410),
                editText410 =(EditText) findViewById(R.id.editText411),
                editText411 =(EditText)  findViewById(R.id.editText412),
                editText412 = (EditText) findViewById(R.id.editText413),
                editText413 =(EditText)  findViewById(R.id.editText414),
                editText414 = (EditText) findViewById(R.id.editText415),
                editText415 = (EditText) findViewById(R.id.editText416),
                editText416 = (EditText) findViewById(R.id.editText417),
                editText417 = (EditText) findViewById(R.id.editText418),
                editText418 = (EditText) findViewById(R.id.editText419),
                editText419 = (EditText) findViewById(R.id.editText420),
                editText420 = (EditText) findViewById(R.id.editText421),
                editText421 = (EditText) findViewById(R.id.editText422),
                editText422 = (EditText) findViewById(R.id.editText423),
                editText423 = (EditText) findViewById(R.id.editText424),
                editText424 = (EditText) findViewById(R.id.editText425),
                editText425 = (EditText) findViewById(R.id.editText426),
                editText426 = (EditText) findViewById(R.id.editText427),
                editText427 = (EditText) findViewById(R.id.editText428),
                editText428 =(EditText) findViewById(R.id.editText429),
                editText429 =(EditText)  findViewById(R.id.editText430),
                editText430 = (EditText) findViewById(R.id.editText431),
                editText431 =(EditText)  findViewById(R.id.editText432),
                editText432 = (EditText) findViewById(R.id.editText433),
                editText433 = (EditText) findViewById(R.id.editText434),
                editText434 = (EditText) findViewById(R.id.editText435),
                editText435 = (EditText) findViewById(R.id.editText436),
                editText436 = (EditText) findViewById(R.id.editText437),
                editText437 = (EditText) findViewById(R.id.editText438),
                editText438 = (EditText) findViewById(R.id.editText439),
                editText439 = (EditText) findViewById(R.id.editText440),
                editText440 = (EditText) findViewById(R.id.editText441),
                editText441 = (EditText) findViewById(R.id.editText442),
                editText442 = (EditText) findViewById(R.id.editText443),
                editText443 = (EditText) findViewById(R.id.editText444),
                editText444 = (EditText) findViewById(R.id.editText445),
                editText445 = (EditText) findViewById(R.id.editText446),
                editText446 =(EditText) findViewById(R.id.editText447),
                editText447 =(EditText)  findViewById(R.id.editText448),
                editText448 = (EditText) findViewById(R.id.editText449),
                editText449 =(EditText)  findViewById(R.id.editText450),
                editText450 = (EditText) findViewById(R.id.editText451),
                editText451 = (EditText) findViewById(R.id.editText452),
                editText452 = (EditText) findViewById(R.id.editText453),
                editText453 = (EditText) findViewById(R.id.editText454),
                editText454 = (EditText) findViewById(R.id.editText455),
                editText455 = (EditText) findViewById(R.id.editText456),
                editText456 = (EditText) findViewById(R.id.editText457),
                editText457 = (EditText) findViewById(R.id.editText458),
                editText458 = (EditText) findViewById(R.id.editText459),
                editText459 = (EditText) findViewById(R.id.editText460),
                editText460 = (EditText) findViewById(R.id.editText461),
                editText461 = (EditText) findViewById(R.id.editText462),
                editText462 = (EditText) findViewById(R.id.editText463),
                editText463 = (EditText) findViewById(R.id.editText464),
                editText464 = (EditText) findViewById(R.id.editText465),
                editText465 = (EditText) findViewById(R.id.editText466),
                editText466 = (EditText) findViewById(R.id.editText467),
                editText467 = (EditText) findViewById(R.id.editText468),
                editText468 = (EditText) findViewById(R.id.editText469),
                editText469 = (EditText) findViewById(R.id.editText470),
                editText470 = (EditText) findViewById(R.id.editText471),
                editText471 = (EditText) findViewById(R.id.editText472),
                editText472 = (EditText) findViewById(R.id.editText473),
                editText473 = (EditText) findViewById(R.id.editText474),
                editText474 = (EditText) findViewById(R.id.editText475),
                editText475 = (EditText) findViewById(R.id.editText476),
                editText476 = (EditText) findViewById(R.id.editText477),
                editText477 = (EditText) findViewById(R.id.editText478),
                editText478 =(EditText) findViewById(R.id.editText479),
                editText479 =(EditText)  findViewById(R.id.editText480),
                editText480 = (EditText) findViewById(R.id.editText481),
                editText481 =(EditText)  findViewById(R.id.editText482),
                editText482 = (EditText) findViewById(R.id.editText483),
                editText483 = (EditText) findViewById(R.id.editText484),
                editText484 = (EditText) findViewById(R.id.editText485),
                editText485 = (EditText) findViewById(R.id.editText486),
                editText486 = (EditText) findViewById(R.id.editText487),
                editText487 = (EditText) findViewById(R.id.editText488),
                editText488 = (EditText) findViewById(R.id.editText489),
                editText489 = (EditText) findViewById(R.id.editText490),
                editText490 = (EditText) findViewById(R.id.editText491),
                editText491 = (EditText) findViewById(R.id.editText492),
                editText492 = (EditText) findViewById(R.id.editText493),
                editText493 = (EditText) findViewById(R.id.editText494),
                editText494 = (EditText) findViewById(R.id.editText495),
                editText495 = (EditText) findViewById(R.id.editText496),
                editText496 =(EditText) findViewById(R.id.editText497),
                editText497 =(EditText)  findViewById(R.id.editText498),
                editText498 = (EditText) findViewById(R.id.editText499),
                editText499 =(EditText)  findViewById(R.id.editText500),
                editText500 = (EditText) findViewById(R.id.editText501),
                editText501 = (EditText) findViewById(R.id.editText502),
                editText502 = (EditText) findViewById(R.id.editText503),
                editText503 = (EditText) findViewById(R.id.editText504),
                editText504 = (EditText) findViewById(R.id.editText505),
                editText505 = (EditText) findViewById(R.id.editText506),
                editText506 = (EditText) findViewById(R.id.editText507),
                editText507 = (EditText) findViewById(R.id.editText508),
                editText508 = (EditText) findViewById(R.id.editText509),
                editText509 = (EditText) findViewById(R.id.editText510),
                editText510 =(EditText) findViewById(R.id.editText511),
                editText511 =(EditText)  findViewById(R.id.editText512),
                editText512 = (EditText) findViewById(R.id.editText513),
                editText513 =(EditText)  findViewById(R.id.editText514),
                editText514 = (EditText) findViewById(R.id.editText515),
                editText515 = (EditText) findViewById(R.id.editText516),
                editText516 = (EditText) findViewById(R.id.editText517),
                editText517 = (EditText) findViewById(R.id.editText518),
                editText518 = (EditText) findViewById(R.id.editText519),
                editText519 = (EditText) findViewById(R.id.editText520),
                editText520 = (EditText) findViewById(R.id.editText521),
                editText521 = (EditText) findViewById(R.id.editText522),
                editText522 = (EditText) findViewById(R.id.editText523),
                editText523 = (EditText) findViewById(R.id.editText524),
                editText524 = (EditText) findViewById(R.id.editText525),
                editText525 = (EditText) findViewById(R.id.editText526),
                editText526 = (EditText) findViewById(R.id.editText527),
                editText527 = (EditText) findViewById(R.id.editText528),
                editText528 =(EditText) findViewById(R.id.editText529),
                editText529 =(EditText)  findViewById(R.id.editText530),
                editText530 = (EditText) findViewById(R.id.editText531),
                editText531 =(EditText)  findViewById(R.id.editText532),
                editText532 = (EditText) findViewById(R.id.editText533),
                editText533 = (EditText) findViewById(R.id.editText534),
                editText534 = (EditText) findViewById(R.id.editText535),
                editText535 = (EditText) findViewById(R.id.editText536),
                editText536 = (EditText) findViewById(R.id.editText537),
                editText537 = (EditText) findViewById(R.id.editText538),
                editText538 = (EditText) findViewById(R.id.editText539),
                editText539 = (EditText) findViewById(R.id.editText540),
                editText540 = (EditText) findViewById(R.id.editText541),
                editText541 = (EditText) findViewById(R.id.editText542),
                editText542 = (EditText) findViewById(R.id.editText543),
                editText543 = (EditText) findViewById(R.id.editText544),
                editText544 = (EditText) findViewById(R.id.editText545),
                editText545 = (EditText) findViewById(R.id.editText546),
                editText546 =(EditText) findViewById(R.id.editText547),
                editText547 =(EditText)  findViewById(R.id.editText548),
                editText548 = (EditText) findViewById(R.id.editText549),
                editText549 =(EditText)  findViewById(R.id.editText550),
                editText550 = (EditText) findViewById(R.id.editText551),
                editText551 = (EditText) findViewById(R.id.editText552),
                editText552 = (EditText) findViewById(R.id.editText553),
                editText553 = (EditText) findViewById(R.id.editText554),
                editText554 = (EditText) findViewById(R.id.editText555),
                editText555 = (EditText) findViewById(R.id.editText556),
                editText556 = (EditText) findViewById(R.id.editText557),
                editText557 = (EditText) findViewById(R.id.editText558),
                editText558 = (EditText) findViewById(R.id.editText559),
                editText559 = (EditText) findViewById(R.id.editText560),
                editText560 = (EditText) findViewById(R.id.editText561),
                editText561 = (EditText) findViewById(R.id.editText562),
                editText562 = (EditText) findViewById(R.id.editText563),
                editText563 = (EditText) findViewById(R.id.editText564),
                editText564 = (EditText) findViewById(R.id.editText565),
                editText565 = (EditText) findViewById(R.id.editText566),
                editText566 = (EditText) findViewById(R.id.editText567),
                editText567 = (EditText) findViewById(R.id.editText568),
                editText568 = (EditText) findViewById(R.id.editText569),
                editText569 = (EditText) findViewById(R.id.editText570),
                editText570 = (EditText) findViewById(R.id.editText571),
                editText571 = (EditText) findViewById(R.id.editText572),
                editText572 = (EditText) findViewById(R.id.editText573),
                editText573 = (EditText) findViewById(R.id.editText574),
                editText574 = (EditText) findViewById(R.id.editText575),
                editText575 = (EditText) findViewById(R.id.editText576),
                editText576 = (EditText) findViewById(R.id.editText577),
                editText577 = (EditText) findViewById(R.id.editText578),
                editText578 =(EditText) findViewById(R.id.editText579),
                editText579 =(EditText)  findViewById(R.id.editText580),
                editText580 = (EditText) findViewById(R.id.editText581),
                editText581 =(EditText)  findViewById(R.id.editText582),
                editText582 = (EditText) findViewById(R.id.editText583),
                editText583 = (EditText) findViewById(R.id.editText584),
                editText584 = (EditText) findViewById(R.id.editText585),
                editText585 = (EditText) findViewById(R.id.editText586),
                editText586 = (EditText) findViewById(R.id.editText587),
                editText587 = (EditText) findViewById(R.id.editText588),
                editText588 = (EditText) findViewById(R.id.editText589),
                editText589 = (EditText) findViewById(R.id.editText590),
                editText590 = (EditText) findViewById(R.id.editText591),
                editText591 = (EditText) findViewById(R.id.editText592),
                editText592 = (EditText) findViewById(R.id.editText593),
                editText593 = (EditText) findViewById(R.id.editText594),
                editText594 = (EditText) findViewById(R.id.editText595),
                editText595 = (EditText) findViewById(R.id.editText596),
                editText596 =(EditText) findViewById(R.id.editText597),
                editText597 =(EditText)  findViewById(R.id.editText598),
                editText598 = (EditText) findViewById(R.id.editText599),
                editText599 =(EditText)  findViewById(R.id.editText600),
                editText600 = (EditText) findViewById(R.id.editText601),
                editText601 = (EditText) findViewById(R.id.editText602),
                editText602 = (EditText) findViewById(R.id.editText603),
                editText603 = (EditText) findViewById(R.id.editText604),
                editText604 = (EditText) findViewById(R.id.editText605),
                editText605 = (EditText) findViewById(R.id.editText606),
                editText606 = (EditText) findViewById(R.id.editText607),
                editText607 = (EditText) findViewById(R.id.editText608),
                editText608 = (EditText) findViewById(R.id.editText609),
                editText609 = (EditText) findViewById(R.id.editText610),
                editText610 =(EditText) findViewById(R.id.editText611),
                editText611 =(EditText)  findViewById(R.id.editText612),
                editText612 = (EditText) findViewById(R.id.editText613),
                editText613 =(EditText)  findViewById(R.id.editText614),
                editText614 = (EditText) findViewById(R.id.editText615),
                editText615 = (EditText) findViewById(R.id.editText616),
                editText616 = (EditText) findViewById(R.id.editText617),
                editText617 = (EditText) findViewById(R.id.editText618),
                editText618 = (EditText) findViewById(R.id.editText619),
                editText619 = (EditText) findViewById(R.id.editText620),
                editText620 = (EditText) findViewById(R.id.editText621),
                editText621 = (EditText) findViewById(R.id.editText622),
                editText622 = (EditText) findViewById(R.id.editText623),
                editText623 = (EditText) findViewById(R.id.editText624),
                editText624 = (EditText) findViewById(R.id.editText625),
                editText625 = (EditText) findViewById(R.id.editText626),
                editText626 = (EditText) findViewById(R.id.editText627),
                editText627 = (EditText) findViewById(R.id.editText628),
                editText628 =(EditText) findViewById(R.id.editText629),
                editText629 =(EditText)  findViewById(R.id.editText630),
                editText630 = (EditText) findViewById(R.id.editText631),
                editText631 =(EditText)  findViewById(R.id.editText632),
                editText632 = (EditText) findViewById(R.id.editText633),
                editText633 = (EditText) findViewById(R.id.editText634),
                editText634 = (EditText) findViewById(R.id.editText635),
                editText635 = (EditText) findViewById(R.id.editText636),
                editText636 = (EditText) findViewById(R.id.editText637),
                editText637 = (EditText) findViewById(R.id.editText638),
                editText638 = (EditText) findViewById(R.id.editText639),
                editText639 = (EditText) findViewById(R.id.editText640),
                editText640 = (EditText) findViewById(R.id.editText641),
                editText641 = (EditText) findViewById(R.id.editText642),
                editText642 = (EditText) findViewById(R.id.editText643),
                editText643 = (EditText) findViewById(R.id.editText644),
                editText644 = (EditText) findViewById(R.id.editText645),
                editText645 = (EditText) findViewById(R.id.editText646),
                editText646 =(EditText) findViewById(R.id.editText647),
                editText647 =(EditText)  findViewById(R.id.editText648),
                editText648 = (EditText) findViewById(R.id.editText649),
                editText649 =(EditText)  findViewById(R.id.editText650),
                editText650 = (EditText) findViewById(R.id.editText651),
                editText651 = (EditText) findViewById(R.id.editText652),
                editText652 = (EditText) findViewById(R.id.editText653),
                editText653 = (EditText) findViewById(R.id.editText654),
                editText654 = (EditText) findViewById(R.id.editText655),
                editText655 = (EditText) findViewById(R.id.editText656),
                editText656 = (EditText) findViewById(R.id.editText657),
                editText657 = (EditText) findViewById(R.id.editText658),
                editText658 = (EditText) findViewById(R.id.editText659),
                editText659 = (EditText) findViewById(R.id.editText660),
                editText660 = (EditText) findViewById(R.id.editText661),
                editText661 = (EditText) findViewById(R.id.editText662),
                editText662 = (EditText) findViewById(R.id.editText663),
                editText663 = (EditText) findViewById(R.id.editText664),
                editText664 = (EditText) findViewById(R.id.editText665),
                editText665 = (EditText) findViewById(R.id.editText666),
                editText666 = (EditText) findViewById(R.id.editText667),
                editText667 = (EditText) findViewById(R.id.editText668),
                editText668 = (EditText) findViewById(R.id.editText669),
                editText669 = (EditText) findViewById(R.id.editText670),
                editText670 = (EditText) findViewById(R.id.editText671),
                editText671 = (EditText) findViewById(R.id.editText672),
                editText672 = (EditText) findViewById(R.id.editText673),
                editText673 = (EditText) findViewById(R.id.editText674),
                editText674 = (EditText) findViewById(R.id.editText675),
                editText675 = (EditText) findViewById(R.id.editText676),
                editText676 = (EditText) findViewById(R.id.editText677),
                editText677 = (EditText) findViewById(R.id.editText678),
                editText678 =(EditText) findViewById(R.id.editText679),
                editText679 =(EditText)  findViewById(R.id.editText680),
                editText680 = (EditText) findViewById(R.id.editText681),
                editText681 =(EditText)  findViewById(R.id.editText682),
                editText682 = (EditText) findViewById(R.id.editText683),
                editText683 = (EditText) findViewById(R.id.editText684),
                editText684 = (EditText) findViewById(R.id.editText685),
                editText685 = (EditText) findViewById(R.id.editText686),
                editText686 = (EditText) findViewById(R.id.editText687),
                editText687 = (EditText) findViewById(R.id.editText688),
                editText688 = (EditText) findViewById(R.id.editText689),
                editText689 = (EditText) findViewById(R.id.editText690),
                editText690 = (EditText) findViewById(R.id.editText691),
                editText691 = (EditText) findViewById(R.id.editText692),
                editText692 = (EditText) findViewById(R.id.editText693),
                editText693 = (EditText) findViewById(R.id.editText694),
                editText694 = (EditText) findViewById(R.id.editText695),
                editText695 = (EditText) findViewById(R.id.editText696),
                editText696 =(EditText) findViewById(R.id.editText697),
                editText697 =(EditText)  findViewById(R.id.editText698),
                editText698 = (EditText) findViewById(R.id.editText699),
                editText699 =(EditText)  findViewById(R.id.editText700),
                editText700 = (EditText) findViewById(R.id.editText701),
                editText701 = (EditText) findViewById(R.id.editText702),
                editText702 = (EditText) findViewById(R.id.editText703),
                editText703 = (EditText) findViewById(R.id.editText704),
                editText704 = (EditText) findViewById(R.id.editText705),
                editText705 = (EditText) findViewById(R.id.editText706),
                editText706 = (EditText) findViewById(R.id.editText707),
                editText707 = (EditText) findViewById(R.id.editText708),
                editText708 = (EditText) findViewById(R.id.editText709),
                editText709 = (EditText) findViewById(R.id.editText710),
                editText710 =(EditText) findViewById(R.id.editText711),
                editText711 =(EditText)  findViewById(R.id.editText712),
                editText712 = (EditText) findViewById(R.id.editText713),
                editText713 =(EditText)  findViewById(R.id.editText714),
                editText714 = (EditText) findViewById(R.id.editText715),
                editText715 = (EditText) findViewById(R.id.editText716),
                editText716 = (EditText) findViewById(R.id.editText717),
                editText717 = (EditText) findViewById(R.id.editText718),
                editText718 = (EditText) findViewById(R.id.editText719),
                editText719 = (EditText) findViewById(R.id.editText720),
                editText720 = (EditText) findViewById(R.id.editText721),
                editText721 = (EditText) findViewById(R.id.editText722),
                editText722 = (EditText) findViewById(R.id.editText723),
                editText723 = (EditText) findViewById(R.id.editText724),
                editText724 = (EditText) findViewById(R.id.editText725),
                editText725 = (EditText) findViewById(R.id.editText726),
                editText726 = (EditText) findViewById(R.id.editText727),
                editText727 = (EditText) findViewById(R.id.editText728),
                editText728 =(EditText) findViewById(R.id.editText729),
                editText729 =(EditText)  findViewById(R.id.editText730),
                editText730 = (EditText) findViewById(R.id.editText731),
                editText731 =(EditText)  findViewById(R.id.editText732),
                editText732 = (EditText) findViewById(R.id.editText733),
                editText733 = (EditText) findViewById(R.id.editText734),
                editText734 = (EditText) findViewById(R.id.editText735),
                editText735 = (EditText) findViewById(R.id.editText736),
                editText736 = (EditText) findViewById(R.id.editText737),
                editText737 = (EditText) findViewById(R.id.editText738),
                editText738 = (EditText) findViewById(R.id.editText739),
                editText739 = (EditText) findViewById(R.id.editText740),
                editText740 = (EditText) findViewById(R.id.editText741),
                editText741 = (EditText) findViewById(R.id.editText742),
                editText742 = (EditText) findViewById(R.id.editText743),
                editText743 = (EditText) findViewById(R.id.editText744),
                editText744 = (EditText) findViewById(R.id.editText745),
                editText745 = (EditText) findViewById(R.id.editText746),
                editText746 =(EditText) findViewById(R.id.editText747),
                editText747 =(EditText)  findViewById(R.id.editText748),
                editText748 = (EditText) findViewById(R.id.editText749),
                editText749 =(EditText)  findViewById(R.id.editText750),
                editText750 = (EditText) findViewById(R.id.editText751),
                editText751 = (EditText) findViewById(R.id.editText752),
                editText752 = (EditText) findViewById(R.id.editText753),
                editText753 = (EditText) findViewById(R.id.editText754),
                editText754 = (EditText) findViewById(R.id.editText755),
                editText755 = (EditText) findViewById(R.id.editText756),
                editText756 = (EditText) findViewById(R.id.editText757),
                editText757 = (EditText) findViewById(R.id.editText758),
                editText758 = (EditText) findViewById(R.id.editText759),
                editText759 = (EditText) findViewById(R.id.editText760),
                editText760 = (EditText) findViewById(R.id.editText761),
                editText761 = (EditText) findViewById(R.id.editText762),
                editText762 = (EditText) findViewById(R.id.editText763),
                editText763 = (EditText) findViewById(R.id.editText764),
                editText764 = (EditText) findViewById(R.id.editText765),
                editText765 = (EditText) findViewById(R.id.editText766),
                editText766 = (EditText) findViewById(R.id.editText767),
                editText767 = (EditText) findViewById(R.id.editText768),
                editText768 = (EditText) findViewById(R.id.editText769),
                editText769 = (EditText) findViewById(R.id.editText770),
                editText770 = (EditText) findViewById(R.id.editText771),
                editText771 = (EditText) findViewById(R.id.editText772),
                editText772 = (EditText) findViewById(R.id.editText773),
                editText773 = (EditText) findViewById(R.id.editText774),
                editText774 = (EditText) findViewById(R.id.editText775),
                editText775 = (EditText) findViewById(R.id.editText776),
                editText776 = (EditText) findViewById(R.id.editText777),
                editText777 = (EditText) findViewById(R.id.editText778),
                editText778 =(EditText) findViewById(R.id.editText779),
                editText779 =(EditText)  findViewById(R.id.editText780),
                editText780 = (EditText) findViewById(R.id.editText781),
                editText781 =(EditText)  findViewById(R.id.editText782),
                editText782 = (EditText) findViewById(R.id.editText783),
                editText783 = (EditText) findViewById(R.id.editText784),
                editText784 = (EditText) findViewById(R.id.editText785),
                editText785 = (EditText) findViewById(R.id.editText786),
                editText786 = (EditText) findViewById(R.id.editText787),
                editText787 = (EditText) findViewById(R.id.editText788),
                editText788 = (EditText) findViewById(R.id.editText789),
                editText789 = (EditText) findViewById(R.id.editText790),
                editText790 = (EditText) findViewById(R.id.editText791),
                editText791 = (EditText) findViewById(R.id.editText792),
                editText792 = (EditText) findViewById(R.id.editText793),
                editText793 = (EditText) findViewById(R.id.editText794),
                editText794 = (EditText) findViewById(R.id.editText795),
                editText795 = (EditText) findViewById(R.id.editText796),
                editText796 =(EditText) findViewById(R.id.editText797),
                editText797 =(EditText)  findViewById(R.id.editText798),
                editText798 = (EditText) findViewById(R.id.editText799),
                editText799 =(EditText)  findViewById(R.id.editText800),
                editText800 = (EditText) findViewById(R.id.editText801),
                editText801 = (EditText) findViewById(R.id.editText802),
                editText802 = (EditText) findViewById(R.id.editText803),
                editText803 = (EditText) findViewById(R.id.editText804),
                editText804 = (EditText) findViewById(R.id.editText805),
                editText805 = (EditText) findViewById(R.id.editText806),
                editText806 = (EditText) findViewById(R.id.editText807),
                editText807 = (EditText) findViewById(R.id.editText808),
                editText808 = (EditText) findViewById(R.id.editText809),
                editText809 = (EditText) findViewById(R.id.editText810),
                editText810 =(EditText) findViewById(R.id.editText811),
                editText811 =(EditText)  findViewById(R.id.editText812),
                editText812 = (EditText) findViewById(R.id.editText813),
                editText813 =(EditText)  findViewById(R.id.editText814),
                editText814 = (EditText) findViewById(R.id.editText815),
                editText815 = (EditText) findViewById(R.id.editText816),
                editText816 = (EditText) findViewById(R.id.editText817),
                editText817 = (EditText) findViewById(R.id.editText818),
                editText818 = (EditText) findViewById(R.id.editText819),
                editText819 = (EditText) findViewById(R.id.editText820),
                editText820 = (EditText) findViewById(R.id.editText821),
                editText821 = (EditText) findViewById(R.id.editText822),
                editText822 = (EditText) findViewById(R.id.editText823),
                editText823 = (EditText) findViewById(R.id.editText824),
                editText824 = (EditText) findViewById(R.id.editText825),
                editText825 = (EditText) findViewById(R.id.editText826),
                editText826 = (EditText) findViewById(R.id.editText827),
                editText827 = (EditText) findViewById(R.id.editText828),
                editText828 =(EditText) findViewById(R.id.editText829),
                editText829 =(EditText)  findViewById(R.id.editText830),
                editText830 = (EditText) findViewById(R.id.editText831),
                editText831 =(EditText)  findViewById(R.id.editText832),
                editText832 = (EditText) findViewById(R.id.editText833),
                editText833 = (EditText) findViewById(R.id.editText834),
                editText834 = (EditText) findViewById(R.id.editText835),
                editText835 = (EditText) findViewById(R.id.editText836),
                editText836 = (EditText) findViewById(R.id.editText837),
                editText837 = (EditText) findViewById(R.id.editText838),
                editText838 = (EditText) findViewById(R.id.editText839),
                editText839 = (EditText) findViewById(R.id.editText840),
                editText840 = (EditText) findViewById(R.id.editText841),
                editText841 = (EditText) findViewById(R.id.editText842),
                editText842 = (EditText) findViewById(R.id.editText843),
                editText843 = (EditText) findViewById(R.id.editText844),
                editText844 = (EditText) findViewById(R.id.editText845),
                editText845 = (EditText) findViewById(R.id.editText846),
                editText846 =(EditText) findViewById(R.id.editText847),
                editText847 =(EditText)  findViewById(R.id.editText848),
                editText848 = (EditText) findViewById(R.id.editText849),
                editText849 =(EditText)  findViewById(R.id.editText850),
                editText850 = (EditText) findViewById(R.id.editText851),
                editText851 = (EditText) findViewById(R.id.editText852),
                editText852 = (EditText) findViewById(R.id.editText853),
                editText853 = (EditText) findViewById(R.id.editText854),
                editText854 = (EditText) findViewById(R.id.editText855),
                editText855 = (EditText) findViewById(R.id.editText856),
                editText856 = (EditText) findViewById(R.id.editText857),
                editText857 = (EditText) findViewById(R.id.editText858),
                editText858 = (EditText) findViewById(R.id.editText859),
                editText859 = (EditText) findViewById(R.id.editText860),
                editText860 = (EditText) findViewById(R.id.editText861),
                editText861 = (EditText) findViewById(R.id.editText862),
                editText862 = (EditText) findViewById(R.id.editText863),
                editText863 = (EditText) findViewById(R.id.editText864),
                editText864 = (EditText) findViewById(R.id.editText865),
                editText865 = (EditText) findViewById(R.id.editText866),
                editText866 = (EditText) findViewById(R.id.editText867),
                editText867 = (EditText) findViewById(R.id.editText868),
                editText868 = (EditText) findViewById(R.id.editText869),
                editText869 = (EditText) findViewById(R.id.editText870),
                editText870 = (EditText) findViewById(R.id.editText871),
                editText871 = (EditText) findViewById(R.id.editText872),
                editText872 = (EditText) findViewById(R.id.editText873),
                editText873 = (EditText) findViewById(R.id.editText874),
                editText874 = (EditText) findViewById(R.id.editText875),
                editText875 = (EditText) findViewById(R.id.editText876),
                editText876 = (EditText) findViewById(R.id.editText877),
                editText877 = (EditText) findViewById(R.id.editText878),
                editText878 =(EditText) findViewById(R.id.editText879),
                editText879 =(EditText)  findViewById(R.id.editText880),
                editText880 = (EditText) findViewById(R.id.editText881),
                editText881 =(EditText)  findViewById(R.id.editText882),
                editText882 = (EditText) findViewById(R.id.editText883),
                editText883 = (EditText) findViewById(R.id.editText884),
                editText884 = (EditText) findViewById(R.id.editText885),
                editText885 = (EditText) findViewById(R.id.editText886),
                editText886 = (EditText) findViewById(R.id.editText887),
                editText887 = (EditText) findViewById(R.id.editText888),
                editText888 = (EditText) findViewById(R.id.editText889),
                editText889 = (EditText) findViewById(R.id.editText890),
                editText890 = (EditText) findViewById(R.id.editText891),
                editText891 = (EditText) findViewById(R.id.editText892),
                editText892 = (EditText) findViewById(R.id.editText893),
                editText893 = (EditText) findViewById(R.id.editText894),
                editText894 = (EditText) findViewById(R.id.editText895),
                editText895 = (EditText) findViewById(R.id.editText896),
                editText896 =(EditText) findViewById(R.id.editText897),
                editText897 =(EditText)  findViewById(R.id.editText898),
                editText898 = (EditText) findViewById(R.id.editText899),
                editText899 =(EditText)  findViewById(R.id.editText900),
                editText900 = (EditText) findViewById(R.id.editText901),
                editText901 = (EditText) findViewById(R.id.editText902),
                editText902 = (EditText) findViewById(R.id.editText903),
                editText903 = (EditText) findViewById(R.id.editText904),
                editText904 = (EditText) findViewById(R.id.editText905),
                editText905 = (EditText) findViewById(R.id.editText906),
                editText906 = (EditText) findViewById(R.id.editText907),
                editText907 = (EditText) findViewById(R.id.editText908),
                editText908 = (EditText) findViewById(R.id.editText909),
                editText909 = (EditText) findViewById(R.id.editText910),
                editText910 =(EditText) findViewById(R.id.editText911),
                editText911 =(EditText)  findViewById(R.id.editText912),
                editText912 = (EditText) findViewById(R.id.editText913),
                editText913 =(EditText)  findViewById(R.id.editText914),
                editText914 = (EditText) findViewById(R.id.editText915),
                editText915 = (EditText) findViewById(R.id.editText916),
                editText916 = (EditText) findViewById(R.id.editText917),
                editText917 = (EditText) findViewById(R.id.editText918),
                editText918 = (EditText) findViewById(R.id.editText919),
                editText919 = (EditText) findViewById(R.id.editText920),
                editText920 = (EditText) findViewById(R.id.editText921),
                editText921 = (EditText) findViewById(R.id.editText922),
                editText922 = (EditText) findViewById(R.id.editText923),
                editText923 = (EditText) findViewById(R.id.editText924),
                editText924 = (EditText) findViewById(R.id.editText925),
                editText925 = (EditText) findViewById(R.id.editText926),
                editText926 = (EditText) findViewById(R.id.editText927),
                editText927 = (EditText) findViewById(R.id.editText928),
                editText928 =(EditText) findViewById(R.id.editText929),
                editText929 =(EditText)  findViewById(R.id.editText930),
                editText930 = (EditText) findViewById(R.id.editText931),
                editText931 =(EditText)  findViewById(R.id.editText932),
                editText932 = (EditText) findViewById(R.id.editText933),
                editText933 = (EditText) findViewById(R.id.editText934),
                editText934 = (EditText) findViewById(R.id.editText935),
                editText935 = (EditText) findViewById(R.id.editText936),
                editText936 = (EditText) findViewById(R.id.editText937),
                editText937 = (EditText) findViewById(R.id.editText938),
                editText938 = (EditText) findViewById(R.id.editText939),
                editText939 = (EditText) findViewById(R.id.editText940),
                editText940 = (EditText) findViewById(R.id.editText941),
                editText941 = (EditText) findViewById(R.id.editText942),
                editText942 = (EditText) findViewById(R.id.editText943),
                editText943 = (EditText) findViewById(R.id.editText944),
                editText944 = (EditText) findViewById(R.id.editText945),
                editText945 = (EditText) findViewById(R.id.editText946),
                editText946 =(EditText) findViewById(R.id.editText947),
                editText947 =(EditText)  findViewById(R.id.editText948),
                editText948 = (EditText) findViewById(R.id.editText949),
                editText949 =(EditText)  findViewById(R.id.editText950),
                editText950 = (EditText) findViewById(R.id.editText951),
                editText951 = (EditText) findViewById(R.id.editText952),
                editText952 = (EditText) findViewById(R.id.editText953),
                editText953 = (EditText) findViewById(R.id.editText954),
                editText954 = (EditText) findViewById(R.id.editText955),
                editText955 = (EditText) findViewById(R.id.editText956),
                editText956 = (EditText) findViewById(R.id.editText957),
                editText957 = (EditText) findViewById(R.id.editText958),
                editText958 = (EditText) findViewById(R.id.editText959),
                editText959 = (EditText) findViewById(R.id.editText960),
                editText960 = (EditText) findViewById(R.id.editText961),
                editText961 = (EditText) findViewById(R.id.editText962),
                editText962 = (EditText) findViewById(R.id.editText963),
                editText963 = (EditText) findViewById(R.id.editText964),
                editText964 = (EditText) findViewById(R.id.editText965),
                editText965 = (EditText) findViewById(R.id.editText966),
                editText966 = (EditText) findViewById(R.id.editText967),
                editText967 = (EditText) findViewById(R.id.editText968),
                editText968 = (EditText) findViewById(R.id.editText969),
                editText969 = (EditText) findViewById(R.id.editText970),
                editText970 = (EditText) findViewById(R.id.editText971),
                editText971 = (EditText) findViewById(R.id.editText972),
                editText972 = (EditText) findViewById(R.id.editText973),
                editText973 = (EditText) findViewById(R.id.editText974),
                editText974 = (EditText) findViewById(R.id.editText975),
                editText975 = (EditText) findViewById(R.id.editText976),
                editText976 = (EditText) findViewById(R.id.editText977),
                editText977 = (EditText) findViewById(R.id.editText978),
                editText978 =(EditText) findViewById(R.id.editText979),
                editText979 =(EditText)  findViewById(R.id.editText980),
                editText980 = (EditText) findViewById(R.id.editText981),
                editText981 =(EditText)  findViewById(R.id.editText982),
                editText982 = (EditText) findViewById(R.id.editText983),
                editText983 = (EditText) findViewById(R.id.editText984),
                editText984 = (EditText) findViewById(R.id.editText985),
                editText985 = (EditText) findViewById(R.id.editText986),
                editText986 = (EditText) findViewById(R.id.editText987),
                editText987 = (EditText) findViewById(R.id.editText988),
                editText988 = (EditText) findViewById(R.id.editText989),
                editText989 = (EditText) findViewById(R.id.editText990),
                editText990 = (EditText) findViewById(R.id.editText991),
                editText991 = (EditText) findViewById(R.id.editText992),
                editText992 = (EditText) findViewById(R.id.editText993),
                editText993 = (EditText) findViewById(R.id.editText994),
                editText994 = (EditText) findViewById(R.id.editText995),
                editText995 = (EditText) findViewById(R.id.editText996),
                editText996 =(EditText) findViewById(R.id.editText997),
                editText997 =(EditText)  findViewById(R.id.editText998),
                editText998 = (EditText) findViewById(R.id.editText999),
                editText999 =(EditText)  findViewById(R.id.editText1000),
                editText1000 = (EditText) findViewById(R.id.editText1001),
                editText1001 = (EditText) findViewById(R.id.editText1002),
                editText1002 = (EditText) findViewById(R.id.editText1003),
                editText1003 = (EditText) findViewById(R.id.editText1004),
                editText1004 = (EditText) findViewById(R.id.editText1005),
                editText1005 = (EditText) findViewById(R.id.editText1006),
                editText1006 = (EditText) findViewById(R.id.editText1007),
                editText1007 = (EditText) findViewById(R.id.editText1008),
                editText1008 = (EditText) findViewById(R.id.editText1009),
                editText1009 = (EditText) findViewById(R.id.editText1010),
                editText1010 =(EditText) findViewById(R.id.editText1011),
                editText1011 =(EditText)  findViewById(R.id.editText1012),
                editText1012 = (EditText) findViewById(R.id.editText1013),
                editText1013 =(EditText)  findViewById(R.id.editText1014),
                editText1014 = (EditText) findViewById(R.id.editText1015),
                editText1015 = (EditText) findViewById(R.id.editText1016),
                editText1016 = (EditText) findViewById(R.id.editText1017),
                editText1017 = (EditText) findViewById(R.id.editText1018),
                editText1018 = (EditText) findViewById(R.id.editText1019),
                editText1019 = (EditText) findViewById(R.id.editText1020)};

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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.asmgcssaabmonthly1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel = {235,305,290,355,290,355,290,355,290,355,230,230,210,240,270,300,331,487,540,210,240,270,300,331,487,540,210,240,270,300,331,363,394,426,456,487,540,
                210,240,270,300,331,363,394,426,456,487,540,210,240,270,300,331,363,394,426,456,487,540};
        int[] editTextYPixel = {195,195,370,370,410,410,455,455,495,495,550,615,750,750,750,750,750,750,750,800,800,800,800,800,800,800,850,850,850,850,850,850,850,850,850,850,850,
                900,900,900,900,900,900,900,900,900,900,900,940,940,940,940,940,940,940,940,940,940,940};



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

        canvas.drawText(strData,435,195,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.asmgcssaabmonthly2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel2 = {250,325,250,325,250,325,250,325,250,325,250,325,250,325,100,140,171,206,245,294,373,421,463,517};
        int[] editTextYPixel2 = {295,295,340,340,395,395,440,440,495,495,540,540,595,595,880,880,880,880,880,880,880,880,880,880};



        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+59],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }


        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------

        //----------------------Page 3---------------------

        PdfDocument.PageInfo myPageInfo3 = new PdfDocument.PageInfo.Builder(723, 1024, 3).create();

        // start a page
        PdfDocument.Page myPage3 = myPdfdocument.startPage(myPageInfo3);

        canvas = myPage3.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.asmgcssaabmonthly3);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel3 = {215,315,400,215,315,400,215,315,400,215,315,400,215,315,400,215,315,400,215,315,400,215,315,400,215,315,400,215,315,400,215,315,400,215,315,400,215,315,400,215,315,400,215,315,400,215,315,400};
        int[] editTextYPixel3 = {385,385,385,415,415,415,445,445,445,475,475,475,505,505,505,535,535,535,565,565,565,595,595,595,625,625,625,655,655,655,685,685,685,715,715,715,745,745,745,775,775,775,805,805,805,835,835,835};



        for(int i = 0; i < editTextXPixel3.length; i++){
            canvas.drawText( editTextDataForPDF[i+83],editTextXPixel3[i],editTextYPixel3[i],titlePaint);
        }


        myPdfdocument.finishPage(myPage3);

        //-------------------------End of Page 3-----------------

        //----------------------Page 4---------------------

        PdfDocument.PageInfo myPageInfo4 = new PdfDocument.PageInfo.Builder(723, 1024, 4).create();

        // start a page
        PdfDocument.Page myPage4 = myPdfdocument.startPage(myPageInfo4);

        canvas = myPage4.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.asmgcssaabmonthly4);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel4 = {420,535,420,535,400,500,400,500,400,500,273,303,333,363,393,423,453,483,513,543,573,603,633,663,693,273,303,333,363,393,423,453,483,513,543,573,603,633,663,693};
        int[] editTextYPixel4 = {290,290,425,425,575,575,615,615,650,650,845,845,845,845,845,845,845,845,845,845,845,845,845,845,845,895,895,895,895,895,895,895,895,895,895,895,895,895,895,895};



        for(int i = 0; i < editTextXPixel4.length; i++){
            canvas.drawText( editTextDataForPDF[i+131],editTextXPixel4[i],editTextYPixel4[i],titlePaint);
        }


        myPdfdocument.finishPage(myPage4);

        //-------------------------End of Page 4-----------------

        //----------------------Page 5---------------------

        PdfDocument.PageInfo myPageInfo5 = new PdfDocument.PageInfo.Builder(723, 1024, 5).create();

        // start a page
        PdfDocument.Page myPage5 = myPdfdocument.startPage(myPageInfo5);

        canvas = myPage5.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.asmgcssaabmonthly5);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel5 = {273,303,333,363,393,423,453,483,513,543,573,603,633,663,693,273,303,333,363,393,423,453,483,513,543,573,603,633,663,693,273,303,333,363,393,423,453,483,513,543,573,603,633,663,693,
                273,303,333,363,393,423,453,483,513,543,573,603,633,663,693,273,303,333,363,393,423,453,483,513,543,573,603,633,663,693,273,303,333,363,393,423,453,483,513,543,573,603,633,663,693,
                273,303,333,363,393,423,453,483,513,543,573,603,633,663,693,273,303,333,363,393,423,453,483,513,543,573,603,633,663,693,273,303,333,363,393,423,453,483,513,543,573,603,633,663,693,
                273,303,333,363,393,423,453,483,513,543,573,603,633,663,693,273,303,333,363,393,423,453,483,513,543,573,603,633,663,693,273,303,333,363,393,423,453,483,513,543,573,603,633,663,693,
                273,303,333,363,393,423,453,483,513,543,573,603,633,663,693,273,303,333,363,393,423,453,483,513,543,573,603,633,663,693,273,303,333,363,393,423,453,483,513,543,573,603,633,663,693,
                273,303,333,363,393,423,453,483,513,543,573,603,633,663,693,330,360,390,420,450,480,510,540,570,600,630,660,690,330,360,390,420,450,480,510,540,570,600,630,660,690,
                330,360,390,420,450,480,510,540,570,600,630,660,690,330,360,390,420,450,480,510,540,570,600,630,660,690,330,360,390,420,450,480,510,540,570,600,630,660,690,
                330,360,390,420,450,480,510,540,570,600,630,660,690};
        int[] editTextYPixel5 = {188,188,188,188,188,188,188,188,188,188,188,188,188,188,188,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,270,270,270,270,270,270,270,270,270,270,270,270,270,270,270,
                298,298,298,298,298,298,298,298,298,298,298,298,298,298,298,328,328,328,328,328,328,328,328,328,328,328,328,328,328,328,358,358,358,358,358,358,358,358,358,358,358,358,358,358,358,
                388,388,388,388,388,388,388,388,388,388,388,388,388,388,388,415,415,415,415,415,415,415,415,415,415,415,415,415,415,415,445,445,445,445,445,445,445,445,445,445,445,445,445,445,445,
                467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,485,485,485,485,485,485,485,485,485,485,485,485,485,485,485,513,513,513,513,513,513,513,513,513,513,513,513,513,513,513,
                537,537,537,537,537,537,537,537,537,537,537,537,537,537,537,558,558,558,558,558,558,558,558,558,558,558,558,558,558,558,590,590,590,590,590,590,590,590,590,590,590,590,590,590,590,
                627,627,627,627,627,627,627,627,627,627,627,627,627,627,627,732,732,732,732,732,732,732,732,732,732,732,732,732,760,760,760,760,760,760,760,760,760,760,760,760,760,
                788,788,788,788,788,788,788,788,788,788,788,788,788,817,817,817,817,817,817,817,817,817,817,817,817,817,855,855,855,855,855,855,855,855,855,855,855,855,855,
                902,902,902,902,902,902,902,902,902,902,902,902,902};



        for(int i = 0; i < editTextXPixel5.length; i++){
            canvas.drawText( editTextDataForPDF[i+171],editTextXPixel5[i],editTextYPixel5[i],titlePaint);
        }


        myPdfdocument.finishPage(myPage5);

        //-------------------------End of Page 5-----------------

        //----------------------Page 6---------------------

        PdfDocument.PageInfo myPageInfo6 = new PdfDocument.PageInfo.Builder(723, 1024, 6).create();

        // start a page
        PdfDocument.Page myPage6 = myPdfdocument.startPage(myPageInfo6);

        canvas = myPage6.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.asmgcssaabmonthly6);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel6 = {330,360,390,420,450,480,510,540,570,600,630,660,690,330,360,390,420,450,480,510,540,570,600,630,660,690,330,360,390,420,450,480,510,540,570,600,630,660,690,
                330,360,390,420,450,480,510,540,570,600,630,660,690,330,360,390,420,450,480,510,540,570,600,630,660,690,330,360,390,420,450,480,510,540,570,600,630,660,690,
                330,360,390,420,450,480,510,540,570,600,630,660,690,330,360,390,420,450,480,510,540,570,600,630,660,690,330,360,390,420,450,480,510,540,570,600,630,660,690,
                330,360,390,420,450,480,510,540,570,600,630,660,690,330,360,390,420,450,480,510,540,570,600,630,660,690,330,360,390,420,450,480,510,540,570,600,630,660,690,
                330,360,390,420,450,480,510,540,570,600,630,660,690,330,360,390,420,450,480,510,540,570,600,630,660,690,90,160,230,300,425,500,570,635,90,160,230,300,425,500,570,635};
        int[] editTextYPixel6 = {200,200,200,200,200,200,200,200,200,200,200,200,200,258,258,258,258,258,258,258,258,258,258,258,258,258,287,287,287,287,287,287,287,287,287,287,287,287,287,
                315,315,315,315,315,315,315,315,315,315,315,315,315,344,344,344,344,344,344,344,344,344,344,344,344,344,372,372,372,372,372,372,372,372,372,372,372,372,372,
                412,412,412,412,412,412,412,412,412,412,412,412,412,457,457,457,457,457,457,457,457,457,457,457,457,457,513,513,513,513,513,513,513,513,513,513,513,513,513,
                541,541,541,541,541,541,541,541,541,541,541,541,541,570,570,570,570,570,570,570,570,570,570,570,570,570,630,630,630,630,630,630,630,630,630,630,630,630,630,
                663,663,663,663,663,663,663,663,663,663,663,663,663,691,691,691,691,691,691,691,691,691,691,691,691,691,905,905,905,905,905,905,905,905,929,929,929,929,929,929,929,929};



        for(int i = 0; i < editTextXPixel6.length; i++){
            canvas.drawText( editTextDataForPDF[i+489],editTextXPixel6[i],editTextYPixel6[i],titlePaint);
        }


        myPdfdocument.finishPage(myPage6);

        //-------------------------End of Page 6-----------------

        //----------------------Page 7---------------------

        PdfDocument.PageInfo myPageInfo7 = new PdfDocument.PageInfo.Builder(723, 1024, 7).create();

        // start a page
        PdfDocument.Page myPage7 = myPdfdocument.startPage(myPageInfo7);

        canvas = myPage7.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.asmgcssaabmonthly7);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel7 = {80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,
                80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,
                80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,
                80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,
                80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,415,495,565,630,80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,
                80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630};
        int[] editTextYPixel7 = {183,183,183,183,183,183,183,183,207,207,207,207,207,207,207,207,231,231,231,231,231,231,231,231,255,255,255,255,255,255,255,255,
                279,279,279,279,279,279,279,279,303,303,303,303,303,303,303,303,327,327,327,327,327,327,327,327,351,351,351,351,351,351,351,351,
                375,375,375,375,375,375,375,375,399,399,399,399,399,399,399,399,423,423,423,423,423,423,423,423,447,447,447,447,447,447,447,447,
                471,471,471,471,471,471,471,471,495,495,495,495,495,495,495,495,518,518,518,518,518,518,518,518,542,542,542,542,542,542,542,542,
                566,566,566,566,566,566,566,566,590,590,590,590,590,590,590,590,638,638,638,638,792,792,792,792,792,792,792,792,818,818,818,818,818,818,818,818,
                843,843,843,843,843,843,843,843,869,869,869,869,869,869,869,869,894,894,894,894,894,894,894,894,920,920,920,920,920,920,920,920};



        for(int i = 0; i < editTextXPixel7.length; i++){
            canvas.drawText( editTextDataForPDF[i+687],editTextXPixel7[i],editTextYPixel7[i],titlePaint);
        }

        myPdfdocument.finishPage(myPage7);

        //-------------------------End of Page 7-----------------

        //----------------------Page 8---------------------

        PdfDocument.PageInfo myPageInfo8 = new PdfDocument.PageInfo.Builder(723, 1024, 8).create();

        // start a page
        PdfDocument.Page myPage8 = myPdfdocument.startPage(myPageInfo8);

        canvas = myPage8.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.asmgcssaabmonthly8);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel8 = {80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,
                80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,
                80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,
                80,150,220,290,415,495,565,630,80,150,220,290,415,495,565,630,415,495,565,630,380,380,380,170,270,170,270,170,270};
        int[] editTextYPixel8 = {183,183,183,183,183,183,183,183,210,210,210,210,210,210,210,210,236,236,236,236,236,236,236,236,262,262,262,262,262,262,262,262,
                286,286,286,286,286,286,286,286,312,312,312,312,312,312,312,312,338,338,338,338,338,338,338,338,363,363,363,363,363,363,363,363,
                389,389,389,389,389,389,389,389,414,414,414,414,414,414,414,414,439,439,439,439,439,439,439,439,464,464,464,464,464,464,464,464,
                489,489,489,489,489,489,489,489,515,515,515,515,515,515,515,515,540,540,540,540,700,745,805,877,877,902,902,926,926};



        for(int i = 0; i < editTextXPixel8.length; i++){
            canvas.drawText( editTextDataForPDF[i+883],editTextXPixel8[i],editTextYPixel8[i],titlePaint);
        }

        myPdfdocument.finishPage(myPage8);

        //-------------------------End of Page 8-----------------

        //----------------------Page 8---------------------

        PdfDocument.PageInfo myPageInfo9 = new PdfDocument.PageInfo.Builder(723, 1024, 9).create();

        // start a page
        PdfDocument.Page myPage9 = myPdfdocument.startPage(myPageInfo9);

        canvas = myPage9.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.asmgcssaabmonthly9);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel9 = {170,270,170,270,375,485,375,485,375,485,45};
        int[] editTextYPixel9 = {185,185,213,213,275,275,308,308,337,337,390};



        for(int i = 0; i < editTextXPixel9.length; i++){
            canvas.drawText( editTextDataForPDF[i+1008],editTextXPixel9[i],editTextYPixel9[i],titlePaint);
        }

         titlePaint.setTextSize(12);
         paint.setTextAlign(Paint.Align.LEFT);

        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,250,200, false), 30, 430, paint);
        myPdfdocument.finishPage(myPage9);

        //-------------------------End of Page 9-----------------



        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Surveillance/ASMGCS/SAAB/Monthly/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Monthly ASMGCS SAAB " + strData + ".pdf"; // Change Here--------------------------
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
        myFunctions.saveToParse(targetPdf, fileName,"Surveillance","Monthly",outputEditText,MyFunctions.specificCode("m"),"outputSwitch", "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Monthly Maintenance of SAAB done.",//Change Here-----------------------------
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
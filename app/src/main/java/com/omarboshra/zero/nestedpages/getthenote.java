package com.omarboshra.zero.nestedpages;


import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.BackgroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.UnderlineSpan;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.abs;


public class getthenote extends AppCompatActivity {
    int bcc=Color.WHITE;
    String intrash=null;
    Menu menu;
    String trash=null;
    int dtype=0;
    int px;
    int lali=0;//first araylist index in trash
    Resources r;
    Intent back;
    EditText titleview;
    EditText noteview;
    ListView sub;
    String serial="0";
    String subnote="";
    String saved="";
    String del="";
    String add ="";
    String docadd ="";
    String gettitle;
    String s1;
    String s2;
    String repltext="";
    SpannableString DocIcon;
    SpannableString FolIcon;
    String backString;
    String cstacktitle="";
    String searchToken;
    SpannableString current;
    String onlyformats="";
    String Startingonlyformat="";
    int numberc=0;
    String  [] takenserial = new String [3] ;
    SpannedString left;
    SpannedString right;
    SpannedString allS;
    StringBuffer leftwordformat;
    SpannedString allVs;
    SpannedString textbefore;
    SpannedString tempbefore;
    SpanWatcher watcher;
    int cstart=0;
    int rlp=0;
    int rrp=0;
    int color = 0;
    int removal=0;
    int sp;
    int spanclick=0;
    int lastIndex=0;
    int indexOf=0;
    int selectionStart;
    int selectionEnd;
    int cutback=0;
    int swind,pos=0;
    int vpos=-1;
    int det =0;
    int tt=0;
    int col=0;
    int tagclick=2;
    int usageid =1;
    int edcl=0;
    int mnd=0;
    String maxr="";
    String maxr2="";
    int rep=0;
    int ndet=1;
    int spaceauto=-1;
    int temp=-1;
    int cd,ctd=0;
    int cdc=0;
    int pd=0;
    int nextintent=0;
    int holdtemp=-1;
    int snote=0;
    int acounter=0;
    int beforec;
    int afterc;
    int zeroc=0;
    ImageButton nosave;
    final Handler  handler = new Handler();
    final Handler  handler2 = new Handler();

    Button bold;
    Button itallic;
    Button underline;
    Button highlight;
    Button replacepage;
    Button sellectall;
    TextWatcher note;
    TextWatcher notesave;
    TextWatcher title;
    View v;
    View led;
    ScrollView  scv;
    View pastetoolbar;
    View view;
    View all;
    View  cyanbar;
    View  toppanel;
    String repeat="";
    String repserial="";
    String prevString="";
    Button  tag;
    Button Paste;
    Button  cancel;
    Button  highchoice;
    Cursor g;
    Cursor c;
    data db;
    SQLiteDatabase sql;
    ArrayAdapter<SpannedString> mainstring;
    InputMethodManager imm;
    EditText saveas;
    ImageButton background;
    ViewGroup.MarginLayoutParams params;
    ViewGroup.MarginLayoutParams params2;
    ViewGroup.MarginLayoutParams Listviewpara;
    CheckBox acb;
    CheckBox ccb;
    ViewGroup.LayoutParams paratitle;


    ArrayList<Integer> bcarray= new <Integer>ArrayList();
    ArrayList<SpannedString> shown = new <Spanned>ArrayList();
    ArrayList<String> suba = new <String>ArrayList();
    ArrayList <String> serialarray = new  <String> ArrayList() ;
    ArrayList <String> deletearray = new  <String> ArrayList() ;
    ArrayList <ArrayList> serlist = new  <ArrayList> ArrayList() ;
    ArrayList <ArrayList> salist = new  <ArrayList> ArrayList() ;
    ArrayList <String> similarityarray = new  <String> ArrayList() ;
    ArrayList <String> serialsimarray = new  <String> ArrayList() ;
    ArrayList <String> indeptharray = new  <String> ArrayList() ;
    ContentValues values = new ContentValues();





    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_getthenote);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        titleview = (EditText) findViewById(R.id.ttv);
        noteview = (EditText) findViewById(R.id.ntv);
        bold = (Button) findViewById(R.id.bold);
        itallic = (Button) findViewById(R.id.itaic);
        underline= (Button) findViewById(R.id.underline);
        highlight = (Button) findViewById(R.id.hi);
        highchoice = (Button) findViewById(R.id.hichoice);
        Button collapse = (Button) findViewById(R.id.cv);
        tag = (Button) findViewById(R.id.tag);
        sellectall= (Button) findViewById(R.id.selall);
        Paste = (Button) findViewById(R.id.paste);
        cancel = (Button) findViewById(R.id.cancel);
        Button  hidecyan = (Button) findViewById(R.id.hlb);
        replacepage = (Button) findViewById(R.id.rep);
        nosave = (ImageButton) findViewById(R.id.ns);
        v= findViewById(R.id.l2);
        scv= (ScrollView) findViewById(R.id.sv);
        led= findViewById(R.id.led);
        all= findViewById(R.id.all);
        pastetoolbar= findViewById(R.id.ptb);
        toppanel = findViewById(R.id.toppan);
        View mainlayout = findViewById(R.id.mv);//for side swap
        cyanbar= findViewById(R.id.cyanbar);
        noteview.requestFocus();
        background = (ImageButton) findViewById(R.id.background);
        sub = (ListView) findViewById(R.id.lvs);

        DocIcon = SpannableString.valueOf("✎");
        FolIcon = SpannableString.valueOf("❒");

        DocIcon.setSpan(new RelativeSizeSpan(1.9f), 0, DocIcon.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        FolIcon.setSpan(new RelativeSizeSpan(1.9f), 0, FolIcon.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

        titleview.setHint("Document Name");



        led.setVisibility(View.GONE);
        pastetoolbar.setVisibility(View.GONE);
        replacepage.setVisibility(View.GONE);
        toppanel.setVisibility(View.GONE);


        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        invalidateOptionsMenu();//to change menu titles


        if(getIntent().getExtras().containsKey("lm")) {
            Intent back = new Intent();

            vpos=getIntent().getIntExtra("vpos",-1);
            temp=getIntent().getIntExtra("temp",-1);
            holdtemp=getIntent().getIntExtra("holdtemp",-1);
            serialarray=getIntent().getStringArrayListExtra("tserialarray");
            takenserial[0]=getIntent().getStringExtra("takenserial");
            pos=getIntent().getIntExtra("pos",-1);

            if (getIntent().getExtras().containsKey("sw")) {
                switches(1);

            }else
            if (getIntent().getExtras().containsKey("mv")) {
                moveunder();

            }else
                lm(getIntent().getIntExtra("id",-1));
            back.putExtra("takens",takenserial[0]);
            back.putExtra("holdtemp",holdtemp);
            setResult(RESULT_OK,back);
            finish();
        }
        if(getIntent().getStringArrayExtra("tkns")!=null) {
            if (getIntent().getStringArrayExtra("tkns")[0] != null) {
                if (!getIntent().getStringArrayExtra("tkns")[0].isEmpty()) {

                    takenserial = getIntent().getStringArrayExtra("tkns");
                    pastetoolbar.setVisibility(View.VISIBLE);
//                    replacepage.setVisibility(View.VISIBLE);


                    if (getIntent().getIntExtra("cc", 0) != 0) {
                        cd = 1;
                        cdc = getIntent().getIntExtra("cc", 0);
                        if (cdc == 3) {
                            Paste.setText("Save as");
                        }
                    }
                    if (getIntent().getIntExtra("temp", -1) != -1) {
                        ctd = 1;
                        holdtemp = getIntent().getIntExtra("temp", -1);
                    }
                }
            }
        }


        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorDialogue(1);
            }
        });
        highchoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                colorDialogue(2);
            }
        });


        sellectall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(noteview.getSelectionStart()==0&&noteview.getSelectionEnd()==noteview.length()){
                    noteview.setSelection(noteview.length());
                }else{

                    Editable text = noteview.getText();
                    if (text.length() > 0) {
                        noteview.removeTextChangedListener(notesave);
                        text.replace(0, 1, text.subSequence(0, 1), 0, 1);
                        noteview.addTextChangedListener(notesave);
                        noteview.selectAll();
                    }
                    selectionStart=noteview.getSelectionStart();
                    selectionEnd=noteview.getSelectionEnd();
                }

            }
        });


        hidecyan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cyanbar.setVisibility(View.GONE);
            }
        });



        nosave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(!saved.equals("s")){
                    titleview.setText("");
                    noteview.setText("");
                    toppanel.setVisibility(View.VISIBLE);
                    imm.hideSoftInputFromWindow(noteview.getWindowToken(), 0);
                    onBackPressed();
                }else{
                    titleview.setText(gettitle);
                    onlyformats=Startingonlyformat;
                    noteview.setText(wsd(subnote,Startingonlyformat));
                    Toast.makeText(getthenote.this, "Page reverted", Toast.LENGTH_SHORT).show();
                }




            }
        });
        bold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serializationmanagment();
            }
        });
        itallic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serializationmanagment();
            }
        });
        underline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serializationmanagment();
            }
        });
        highlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = ((ColorDrawable) highchoice.getBackground()).getColor();
                serializationmanagment();
            }
        });
        tag.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if (tagclick == 0) {
                    noteview.setVisibility(View.GONE);
                    v.setBackgroundColor(Color.YELLOW);
                    shown = new <SpannedString>ArrayList();

                    db = new data(getthenote.this);
                    sql = db.getWritableDatabase();
                    c = sql.rawQuery("select * from " + data.Table2, null);
                    suba = new <String>ArrayList();
                    if (c.moveToFirst()) {

                        do {
                            String title = c.getString(c.getColumnIndex(data.title2));
                            String id2 = c.getString(c.getColumnIndex(data.id2));
                            int tagid = c.getInt(c.getColumnIndex(data.tagid));
                            int type= c.getInt(c.getColumnIndex(data.type));

                            if (tagid ==1 && serial.equals(id2)) {
                                suba.add(title);
                                ls(title,type);//spanning listitems
                            }
                        } while (c.moveToNext());
                    }
                    if(suba.size()==0){
                        Toast.makeText(getthenote.this, "Nothing bookmarked or Archived", Toast.LENGTH_SHORT).show();
                    }
                    mainstring = new ArrayAdapter<SpannedString>(getthenote.this, R.layout.maintemp, R.id.mtv, shown) {

                        public View getView(int position, View convertView, ViewGroup parent) {//for items color
                            View view = super.getView(position,convertView,parent);

                            FrameLayout fm = view.findViewById(R.id.fram);

                            fm.setBackgroundColor( ColorUtils.setAlphaComponent(bcarray.get(position), 127));


                            TextView textPart = view.findViewById(R.id.mtv);

                            textPart.setBackgroundColor(bcarray.get(position));

                            return  view;
                        }
                    };
                    sub.setAdapter(mainstring);

                    tagclick = 1;
                } else {
                    v.setBackgroundColor(getResources().getColor(R.color.Lightbrown));

                    inside();
                    tagclick = 0;

                }

            }
        });
        collapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(serial.equals("1")){//to opening in trash
                    return;
                }
                if (col == 0 &&noteview.getVisibility()==View.VISIBLE) {
                    col = 1;

                    noteview.setVisibility(View.GONE);
                    all.setVisibility(View.GONE);
                    selectionStart=noteview.getSelectionStart();


                } else {
                    if(led.getVisibility()==View.VISIBLE){
                        toppanel.setVisibility(View.VISIBLE);
                    }
                    all.setVisibility(View.VISIBLE);
                    noteview.setVisibility(View.VISIBLE);
                    noteview.setSelection(selectionStart);
                    col = 0;

                }
            }
        });



        if (getIntent().getExtras().containsKey("serial")) {
            serial = getIntent().getStringExtra("serial");
            similarityarray=getIntent().getStringArrayListExtra("p");
            serialsimarray=getIntent().getStringArrayListExtra("sa");
            touch();
            saved = "s";
            tagclick = 0;
            inside();
        }


        replacepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(takenserial[0].equals(serial)){
                    Toast.makeText(getthenote.this, "You are in the same page", Toast.LENGTH_SHORT).show();
                    return;
                }
                rep=2;
                if (sn(takenserial[1], similarityarray, serialsimarray) == 1) {
                    if(repserial.equals(takenserial[0])){

                    }else {
                        addnew(takenserial[1], similarityarray);
                        dialog();
                        return;
                    }
                }

                if(!add.equals("a")) {
                    if (!suba.isEmpty()) {
                        choicedialog();
                        return;
                    }
                }

                if(ctd==2||!saved.equals("s")) {
                    Toast.makeText(getthenote.this, "Cannot replace here", Toast.LENGTH_SHORT).show();
                }else
                    delete(serialarray, serial, rep);


            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cdc=0;
                cd=0;
                ctd=0;
                holdtemp=temp=-1;
                nextintent=0;
                Paste.setText("Paste");
                takenserial=new String [3] ;
                pastetoolbar.setVisibility(View.GONE);
                replacepage.setVisibility(View.GONE);

            }
        });
        Paste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                pd = 1;
                if (!titleview.getText().toString().isEmpty() || !noteview.getText().toString().isEmpty()) {
                    if (save(sql) == 1) {
                        dialog();
                        return;
                    }
                    if (ctd == 2) {
                        Toast.makeText(getthenote.this, "Cannot past in here", Toast.LENGTH_SHORT).show();
                        pd = 0;
                        return;
                    }

                    if (nextintent == 8) {//SAVE AS dialog//reinsertion
                        dialog();//
                        return;
                    }

                    if (rep == 0 && !add.equals("a")) {// IN SAME PLACE//
                        if (sn(takenserial[1], suba, serialarray) == 1) {
                            cstacktitle = "There is a similar page in the list";
                            repltext = "Replace page deleting its subpages";

                            addnew(takenserial[1], suba);
                            if (ctd == 1 && temp != -1) {
                                Toast.makeText(getthenote.this, "the Page is in same stack", Toast.LENGTH_SHORT).show();
                                pd = 0;
                                return;
                            } else
                                dialog();

                            return;

                        }
                    }


                    if(rep==3){
                        serial="";
                    }
                    if (ctd == 1) {
                        values.clear();
                        trch();//resetting trashed page
                        values.put(data.id2, serial);

                        sql.update(data.Table2, values, "serial=?", new String[]{takenserial[0]});
                        values.clear();
                        if(rep==0) {
                            Toast.makeText(getthenote.this, "pasted", Toast.LENGTH_SHORT).show();
                        }




                        inside();

                        temp=serialarray.indexOf(takenserial[0]);
                        holdtemp = temp;

                        pd = 0;



                        return;

                    }
                    if (cdc == 1) {//in hard copy
                        int j = 0;
                        indeptharray.add(takenserial[0]);

                        trch();//resetting trashed page
                        sql.update(data.Table2, values, "serial=?", new String[]{takenserial[0]});
                        values.clear();
                        reinsert(sql, 0);
                        c.moveToFirst();
                        c.moveToNext();

                        do {
                            String cid = c.getString(c.getColumnIndex(data.id2));
                            String serialn = c.getString(c.getColumnIndex(data.serial));
                            int cusageid = c.getInt(c.getColumnIndex(data.usageid));
                            String ctitle = c.getString(c.getColumnIndex(data.title2));
                            String cnote = c.getString(c.getColumnIndex(data.data2));
                            String conlyformate=c.getString(c.getColumnIndex(data.formats));
                            int ccolor=c.getInt(c.getColumnIndex(data.color));
                            int ctype=c.getInt(c.getColumnIndex(data.type));



                            if (cid.equals(indeptharray.get(j))) {
                                indeptharray.add(serialn);
                                values.clear();
                                g = sql.query(data.Table2, new String[]{"MAX(" + data.serial + ")"}, null, null, null, null, null);
                                g.moveToFirst();
                                values.put(data.id2, g.getString(0));
                                values.put(data.usageid, cusageid);
                                values.put(data.title2, ctitle);
                                values.put(data.data2, cnote);
                                values.put(data.formats, conlyformate);
                                values.put(data.color, ccolor);
                                values.put(data.type, ctype);
                                sql.insert(data.Table2, null, values);
                            }

                            if (c.moveToNext() == false) {
                                c.moveToFirst();
                                j++;
                            }
                        } while (j!=indeptharray.size());

                        indeptharray = new <String>ArrayList();


                    }

                    if (cdc == 2) {
                        reinsert(sql, 0);
                    }
                    if(rep==4){
                        sql.execSQL("UPDATE Table2 SET [id2] = '" + maxr2 + "' WHERE [id2] ='" + maxr + "'");

                        sql.execSQL("UPDATE Table2 SET [serial] = '" + maxr + "' WHERE [serial] ='" + g.getString(0) + "'");
                        sql.execSQL("UPDATE Table2 SET [id2] = '" + maxr + "' WHERE [id2] ='" + g.getString(0) + "'");

                    }
                    inside();
                    pd = 0;


                    return;


                }else
                    Toast.makeText(getthenote.this, "Page is empty", Toast.LENGTH_SHORT).show();
            }

        });

        sub.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                vpos=position;
                return false;
            }
        });
        sub.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(ctd==1&&temp==position){
                    ctd=2;
                    Toast.makeText(getthenote.this, "fel cut", Toast.LENGTH_SHORT).show();
                }
                if (swind == 1) {
                    pos = position;
                    trans(6);
                } else if (swind == 2) {
                    pos = position;
                    trans(5);
                } else {
                    db = new data(getthenote.this);
                    sql = db.getWritableDatabase();

                    if (save(sql) == 1) {
                        nextintent=5;
                        dialog();
                        return;
                    } else {


                        if(serial.equals("1")) {
                            intrash = trash;//get supertrashvariable
                        }

                        serial = serialarray.get(position);
                        del = "";
                        saved = "s";
                        getIntent().removeExtra("p");

                        similarityarray = suba;
                        serialsimarray = serialarray;
                        inside();
                    }

                }
            }


        });

        if (!getIntent().getExtras().containsKey("add")) {

            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        } else {
            tagclick = 0;
//            led.setVisibility(View.VISIBLE);
            toppanel.setVisibility(View.VISIBLE);
            similarityarray = getIntent().getStringArrayListExtra("a");
            serialsimarray=getIntent().getStringArrayListExtra("add");
            salist.add(similarityarray);
            serlist.add(serialsimarray);
            touch();
            titlewatcher();
            spanselection();
            notesave();
            wtch();
        }

        registerForContextMenu(sub);

    }

    private void serializationmanagment(){

        selection();
        if(!titleview.hasFocus()&&!noteview.getText().toString().isEmpty()&&!current.toString().isEmpty()) {

            int remainingsum = (indexOf - (lastIndex + 1));
            ArrayList<Integer> indexs = new ArrayList();

            String set = "", unset = "", f = "", sec = "", thrd = "", seq = "";

            if (bold.isPressed()) {
                seq = " " + "nh" + " " + "b" + " " + "ni" + " " + "nu" + " ";
                set = "b";
                unset = "nb";
                f = "nh";
                sec = "ni";
                thrd = "nu";
            } else if (itallic.isPressed()) {
                seq = " " + "nh" + " " + "nb" + " " + "i" + " " + "nu" + " ";
                set = "i";
                unset = "ni";
                f = "nh";
                sec = "nb";
                thrd = "nu";
            } else if (underline.isPressed()) {
                seq = " " + "nh" + " " + "nb" + " " + "ni" + " " + "u" + " ";
                set = "u";
                unset = "nu";
                f = "nh";
                sec = "ni";
                thrd = "nb";
            } else if (highlight.isPressed()) {
                seq = " " + color + " " + "nb" + " " + "ni" + " " + "nu" + " ";
                set = "-";
                unset = "nh";
                f = "nb";
                sec = "ni";
                thrd = "nu";
            }
            int sentenceselect = 0;
            int [] overlapindexs = new int[2];
            int wordoverlap=0;
            int firstleft=0;

            if (!onlyformats.isEmpty()) {
                String[] commas = onlyformats.split(",");

                int fcindex = 1;
                int fsi = 0, ssi, ci;
                int nonexistant = 0;
                int notset=0;
                StringBuffer nof = new StringBuffer(onlyformats);
                StringBuffer newFormat;
                Boolean setchoice =false;

                for(String r :commas){
                    int leftindex =Integer.parseInt(r.substring(r.indexOf(" ")+1,r.indexOf(" ",1)));
                    int rightindex =Integer.parseInt(r.substring(r.indexOf(" ",1)+1,r.indexOf(" ",r.indexOf(" ",1)+1)));

                    if(((leftindex >= (lastIndex + 1) && rightindex <= indexOf)||rightindex>indexOf&&leftindex<(indexOf)&&(lastIndex+1)<leftindex||rightindex>(lastIndex+1)&&rightindex<(indexOf)&&(lastIndex+1)>leftindex)&&r.contains(unset)){
                        notset++;

                    }
                    if(rightindex>indexOf&&leftindex<(indexOf)&&(lastIndex+1)<leftindex) {
                        Toast.makeText(this, "over", Toast.LENGTH_SHORT).show();
                        remainingsum =remainingsum- (indexOf - (leftindex));
                    }else if(rightindex>(lastIndex+1)&&rightindex<(indexOf)&&(lastIndex+1)>leftindex){
                        Toast.makeText(this, "over", Toast.LENGTH_SHORT).show();
                        remainingsum =remainingsum- ((rightindex) - (lastIndex+1));
                    }else if ((leftindex>=(lastIndex+1)&&rightindex<indexOf)||(leftindex>(lastIndex+1)&&rightindex<=indexOf)) {
                        Toast.makeText(this, "sentence", Toast.LENGTH_SHORT).show();
                        remainingsum=remainingsum-(rightindex-leftindex);
                    }

                }
                for (int b = 0; b < commas.length; b++) {
                    int leftindex =Integer.parseInt(commas[b].substring(commas[b].indexOf(" ")+1,commas[b].indexOf(" ",1)));
                    int rightindex =Integer.parseInt(commas[b].substring(commas[b].indexOf(" ",1)+1,commas[b].indexOf(" ",commas[b].indexOf(" ",1)+1)));

                    if(((rightindex>indexOf&&leftindex<(indexOf)&&(lastIndex+1)<leftindex||rightindex>(lastIndex+1)&&rightindex<(indexOf)&&(lastIndex+1)>leftindex))){



                        if(rightindex>indexOf&&leftindex<(indexOf)&&(lastIndex+1)<leftindex) {//le

                            if(!commas[b].contains(unset)&&(notset>0||remainingsum>0)){
                                right = new SpannedString(noteview.getText().subSequence(leftindex, noteview.length()));
                            }

                            if(overlapindexs[0]==0) {
                                overlapindexs[0] = (lastIndex + 1);
                            }
                            overlapindexs[1] = (indexOf-(indexOf - (leftindex)));


                            indexs.add(leftindex);
                            indexs.add(indexOf);
                        }else if(rightindex>(lastIndex+1)&&rightindex<(indexOf)&&(lastIndex+1)>leftindex){//r

                            if(!commas[b].contains(unset)&&(notset>0||remainingsum>0)){
                                left = new SpannedString(noteview.getText().subSequence(0, rightindex));
                            }
                            overlapindexs[0]=((lastIndex+1)+((rightindex) - (lastIndex+1)));

                            if(overlapindexs[1]==0) {
                                overlapindexs[1] = (indexOf);
                            }

                            indexs.add((lastIndex+1));
                            indexs.add(rightindex);
                        }

                    }else if ((leftindex>=(lastIndex+1)&&rightindex<indexOf)||(leftindex>(lastIndex+1)&&rightindex<=indexOf)) {
                        sentenceselect = 1;

//removed unnecessessary extentions
                        if(indexs.contains(leftindex)){//prevent spanning when words are stuck to one another
                            indexs.remove(indexs.size()-1);
                        }else
                            indexs.add(leftindex);
                        indexs.add(rightindex);
                    }

                }

                setchoice = remainingsum > 0 || notset > 0;


                for (int i = 0; i < commas.length; i++) {


                    ci = nof.indexOf(",", fcindex);

                    int leftindex = Integer.parseInt(nof.substring(fcindex, fsi = nof.indexOf(" ", fcindex)));
                    int rightindex = Integer.parseInt(nof.substring(fsi + 1, ssi = nof.indexOf(" ", fsi + 1)));
                    String Spancolor = nof.substring(ssi + 1, nof.indexOf(" ", ssi + 1));

                    if (leftindex >= (lastIndex + 1) && rightindex <= indexOf || leftindex <= (lastIndex + 1) && rightindex >= indexOf||(rightindex>indexOf&&leftindex<(indexOf)&&(lastIndex+1)<leftindex||rightindex>(lastIndex+1)&&rightindex<(indexOf)&&(lastIndex+1)>leftindex)) {


                        if((rightindex>indexOf&&leftindex<(indexOf)&&(lastIndex+1)<leftindex||rightindex>(lastIndex+1)&&rightindex<(indexOf)&&(lastIndex+1)>leftindex)){
                            wordoverlap=1;
                            if (commas[i].contains(unset)&&setchoice==true) {
                                if(rightindex>indexOf&&leftindex<(indexOf)&&(lastIndex+1)<leftindex){//from left part of word

//l

                                    nof = nof.replace(fcindex, fsi, String.valueOf(indexOf));
                                    newFormat = new StringBuffer(commas[i].replace(unset, highlight.isPressed() ? String.valueOf(color) : set) + ",");
                                    nof = new StringBuffer(TextUtils.concat(nof, newFormat.replace(newFormat.indexOf(" ", 1) + 1, newFormat.indexOf(" ", newFormat.indexOf(" ", 1) + 1), String.valueOf(indexOf))));

                                }else if(rightindex>(lastIndex+1)&&rightindex<(indexOf)&&(lastIndex+1)>leftindex){//from right part of word

                                    //r

                                    nof = nof.replace(fsi + 1, ssi, String.valueOf(lastIndex + 1));
                                    newFormat = new StringBuffer(commas[i].replace(unset, highlight.isPressed() ? String.valueOf(color) : set) + ",");
                                    nof = new StringBuffer(TextUtils.concat(nof, newFormat.replace(newFormat.indexOf(" ") + 1, newFormat.indexOf(" ", newFormat.indexOf(" ") + 1), String.valueOf(lastIndex + 1))));
                                }
                            }else if (commas[i].contains(" " +set)&&setchoice==false) {


                                if(rightindex>indexOf&&leftindex<(indexOf)&&(lastIndex+1)<leftindex){//from left part of word
                                    //l

                                    nof = nof.replace(fcindex, fsi, String.valueOf(indexOf));
                                    if (!commas[i].contains(f) || !commas[i].contains(sec) || !commas[i].contains(thrd)||highlight.isPressed() && !Spancolor.equals(String.valueOf(color))) {
                                        //left
                                        if (highlight.isPressed() && !Spancolor.equals(String.valueOf(color))) {
                                            newFormat = new StringBuffer(commas[i].replace(Spancolor, String.valueOf(color)) + ",");

                                        } else
                                            newFormat = new StringBuffer(commas[i].replace(highlight.isPressed() ? Spancolor : set, unset) + ",");
                                        nof = new StringBuffer(TextUtils.concat(nof, newFormat.replace(newFormat.indexOf(" ", 1) + 1, newFormat.indexOf(" ", newFormat.indexOf(" ", 1) + 1), String.valueOf(indexOf))));

                                    }
                                }else if(rightindex>(lastIndex+1)&&rightindex<(indexOf)&&(lastIndex+1)>leftindex) {//from right part of word

//r

                                    nof = nof.replace(fsi + 1, ssi, String.valueOf(lastIndex + 1));

                                    if (!commas[i].contains(f) || !commas[i].contains(sec) || !commas[i].contains(thrd)||highlight.isPressed() && !Spancolor.equals(String.valueOf(color))) {

                                        if (highlight.isPressed() && !Spancolor.equals(String.valueOf(color))) {
                                            newFormat = new StringBuffer(commas[i].replace(Spancolor, String.valueOf(color)) + ",");

                                        }else
                                            newFormat = new StringBuffer(commas[i].replace(highlight.isPressed() ? Spancolor : set, unset) + ",");
                                        //right
                                        nof = new StringBuffer(TextUtils.concat(nof, newFormat.replace(newFormat.indexOf(" ") + 1, newFormat.indexOf(" ", newFormat.indexOf(" ") + 1), String.valueOf(lastIndex + 1))));
                                    }

                                }
                            }

                        }else{


                            if (rightindex - leftindex < (indexOf - (lastIndex + 1))) {


                                if (commas[i].contains(unset)&&setchoice==true) {


                                    nof = nof.replace(nof.indexOf(unset, fcindex), nof.indexOf(unset, fcindex) + 2, highlight.isPressed() ? String.valueOf(color) : set);//here


                                } else if (highlight.isPressed() && !Spancolor.equals(String.valueOf(color))) {
                                    nof = nof.replace(nof.indexOf(Spancolor, fcindex), nof.indexOf(" ", ssi + 1), String.valueOf(color));

                                }else
                                if (commas[i].contains(" " + set)&&setchoice==false) {

                                    if (commas[i].contains(f) && commas[i].contains(sec) && commas[i].contains(thrd)) {
                                        nof = nof.replace(fcindex - 1, ci + 1, "");

                                        if(leftindex==0){//shifting after removing span
                                            left = new SpannedString(noteview.getText().toString().substring(leftindex,rightindex));
                                        }else  if(rightindex==noteview.length()){
                                            right = new SpannedString(noteview.getText().toString().substring(leftindex,rightindex));
                                        }
                                        continue;
                                    } else {


                                        nof = nof.replace(nof.indexOf(highlight.isPressed() ? Spancolor : set, fcindex), nof.indexOf(" ", nof.indexOf(highlight.isPressed() ? Spancolor : set, fcindex)), unset);


                                    }



                                }
                            } else {

                                if (commas[i].contains(unset)) {
                                    if (leftindex == lastIndex + 1 && rightindex == indexOf) {
                                        nof = nof.replace(nof.indexOf(unset, fcindex), nof.indexOf(unset, fcindex) + 2, highlight.isPressed() ? String.valueOf(color) : set);//hh

                                        ci = nof.indexOf(",", fcindex);
                                        fcindex = ci + 2;
                                        continue;
                                    }
                                    if ((rightindex - leftindex) > (indexOf - (lastIndex + 1))) {

                                        if (leftindex == lastIndex + 1) {
                                            //word select
                                            nof = nof.replace(fcindex, fsi, String.valueOf(indexOf));
                                            newFormat = new StringBuffer(commas[i].replace(unset, highlight.isPressed() ? String.valueOf(color) : set) + ",");
                                            nof = new StringBuffer(TextUtils.concat(nof, newFormat.replace(newFormat.indexOf(" ", 1) + 1, newFormat.indexOf(" ", newFormat.indexOf(" ", 1) + 1), String.valueOf(indexOf))));


                                        } else if (rightindex == indexOf) {

                                            nof = nof.replace(fsi + 1, ssi, String.valueOf(lastIndex + 1));
                                            newFormat = new StringBuffer(commas[i].replace(unset, highlight.isPressed() ? String.valueOf(color) : set) + ",");
                                            nof = new StringBuffer(TextUtils.concat(nof, newFormat.replace(newFormat.indexOf(" ") + 1, newFormat.indexOf(" ", newFormat.indexOf(" ") + 1), String.valueOf(lastIndex + 1))));



                                        } else if (leftindex < (lastIndex + 1) && rightindex > indexOf) {


                                            nof = nof.replace(fsi + 1, ssi, String.valueOf(lastIndex + 1));

                                            leftwordformat=new StringBuffer(commas[i]+",").replace(commas[i].indexOf(" ",1)+1,commas[i].indexOf(" ",commas[i].indexOf(" ",1)+1), String.valueOf(lastIndex + 1));
                                            firstleft=Integer.parseInt(commas[i].substring(commas[i].indexOf(" ")+1,commas[i].indexOf(" ",commas[i].indexOf(" ")+1)));

                                            nof = new StringBuffer(nof + commas[i].replaceFirst(String.valueOf(leftindex), String.valueOf(indexOf)) + ",");

                                            newFormat = new StringBuffer(commas[i].replace(unset, highlight.isPressed() ? String.valueOf(color) : set) + ",");
                                            newFormat = newFormat.replace(newFormat.indexOf(" ", 1) + 1, newFormat.indexOf(" ", newFormat.indexOf(" ", 1) + 1), String.valueOf(indexOf));
                                            newFormat = newFormat.replace(newFormat.indexOf(" ") + 1, newFormat.indexOf(" ", newFormat.indexOf(" ") + 1), String.valueOf(lastIndex + 1));
                                            nof = new StringBuffer(TextUtils.concat(nof, newFormat));//at middle

                                        }
                                    }
                                } else if (commas[i].contains(" " + set)) {

                                    if (leftindex == lastIndex + 1 && rightindex == indexOf) {

                                        if (highlight.isPressed() && !Spancolor.equals(String.valueOf(color))) {
                                            nof = nof.replace(nof.indexOf(Spancolor, fcindex), nof.indexOf(" ", ssi + 1), String.valueOf(color));

                                        } else if (commas[i].contains(f) && commas[i].contains(sec) && commas[i].contains(thrd)) {
                                            nof = nof.replace(fcindex - 1, ci + 1, "");



                                            continue;

                                        } else
                                            nof = nof.replace(nof.indexOf(highlight.isPressed() ? Spancolor : set, fcindex), nof.indexOf(" ", nof.indexOf(highlight.isPressed() ? Spancolor : set, fcindex)), unset);

                                    } else if ((rightindex - leftindex) > (indexOf - (lastIndex + 1))) {

                                        if (leftindex == lastIndex + 1) {

                                            nof = nof.replace(fcindex, fsi, String.valueOf(indexOf));
                                            if (!commas[i].contains(f) || !commas[i].contains(sec) || !commas[i].contains(thrd) || highlight.isPressed() && !Spancolor.equals(String.valueOf(color))) {
                                                //left
                                                if (highlight.isPressed() && !Spancolor.equals(String.valueOf(color))) {
                                                    newFormat = new StringBuffer(commas[i].replace(Spancolor, String.valueOf(color)) + ",");

                                                } else
                                                    newFormat = new StringBuffer(commas[i].replace(highlight.isPressed() ? Spancolor : set, unset) + ",");
                                                nof = new StringBuffer(TextUtils.concat(nof, newFormat.replace(newFormat.indexOf(" ", 1) + 1, newFormat.indexOf(" ", newFormat.indexOf(" ", 1) + 1), String.valueOf(indexOf))));
                                            }
                                        } else if (rightindex == indexOf) {


                                            nof = nof.replace(fsi + 1, ssi, String.valueOf(lastIndex + 1));

                                            if (!commas[i].contains(f) || !commas[i].contains(sec) || !commas[i].contains(thrd) || highlight.isPressed() && !Spancolor.equals(String.valueOf(color))) {

                                                if (highlight.isPressed() && !Spancolor.equals(String.valueOf(color))) {
                                                    newFormat = new StringBuffer(commas[i].replace(Spancolor, String.valueOf(color)) + ",");

                                                } else
                                                    newFormat = new StringBuffer(commas[i].replace(highlight.isPressed() ? Spancolor : set, unset) + ",");
                                                //right
                                                nof = new StringBuffer(TextUtils.concat(nof, newFormat.replace(newFormat.indexOf(" ") + 1, newFormat.indexOf(" ", newFormat.indexOf(" ") + 1), String.valueOf(lastIndex + 1))));
                                            }
                                        } else if (leftindex < (lastIndex + 1) && rightindex > indexOf) {


                                            nof = nof.replace(fsi + 1, ssi, String.valueOf(lastIndex + 1));
                                            leftwordformat = new StringBuffer(commas[i] + ",").replace(commas[i].indexOf(" ", 1) + 1, commas[i].indexOf(" ", commas[i].indexOf(" ", 1) + 1), String.valueOf(lastIndex + 1));
                                            firstleft = Integer.parseInt(commas[i].substring(commas[i].indexOf(" ") + 1, commas[i].indexOf(" ", commas[i].indexOf(" ") + 1)));

                                            nof = new StringBuffer(nof + commas[i].replaceFirst(String.valueOf(leftindex), String.valueOf(indexOf)) + ",");
                                            if (!commas[i].contains(f) || !commas[i].contains(sec) || !commas[i].contains(thrd) || highlight.isPressed() && !Spancolor.equals(String.valueOf(color))) {

                                                if (highlight.isPressed() && !Spancolor.equals(String.valueOf(color))) {
                                                    newFormat = new StringBuffer(commas[i].replace(Spancolor, String.valueOf(color)) + ",");

                                                } else
                                                    newFormat = new StringBuffer(commas[i].replace(highlight.isPressed() ? Spancolor : set, unset) + ",");
                                                //middle
                                                newFormat = newFormat.replace(newFormat.indexOf(" ", 1) + 1, newFormat.indexOf(" ", newFormat.indexOf(" ", 1) + 1), String.valueOf(indexOf));
                                                newFormat = newFormat.replace(newFormat.indexOf(" ") + 1, newFormat.indexOf(" ", newFormat.indexOf(" ") + 1), String.valueOf(lastIndex + 1));
                                                nof = new StringBuffer(TextUtils.concat(nof, newFormat));

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else
                        nonexistant++;

                    ci = nof.indexOf(",", fcindex);
                    fcindex = ci + 2;

                }
                if (sentenceselect == 1 && (remainingsum > 0)) {

                    if (indexs.size() == 0) {
                        nof = new StringBuffer(nof + " " + (lastIndex + 1) + " " + indexOf + seq + ",");
                        sentenceselect = 0;

                    } else {
                        Collections.sort(indexs);
                        if (indexs.get(0) > (lastIndex + 1)) {

                            nof = new StringBuffer(nof + " " + (lastIndex + 1) + " " + indexs.get(0) + seq + ",");


                        }

                        for (int h = 1; h <= indexs.size() - 1; h = h + 2) {

                            if (h == indexs.size()-1) {
                                if (indexs.get(h) < indexOf) {
                                    Toast.makeText(this, "sidesgift", Toast.LENGTH_SHORT).show();

                                    nof = new StringBuffer(nof + " " + indexs.get(h) + " " + indexOf + seq + ",");
                                }
                            } else
                                nof = new StringBuffer(nof + " " + indexs.get(h) + " " + indexs.get(h + 1) + seq + ",");
                        }


                    }
                }else
                if(wordoverlap==1&&remainingsum>0){
                    Toast.makeText(this, "remaining", Toast.LENGTH_SHORT).show();
                    nof = new StringBuffer(nof + " " + overlapindexs[0] + " " + overlapindexs[1] + seq + ",");
                }


                onlyformats = new String(nof);
                if (nonexistant == commas.length) {
                    onlyformats = onlyformats + " " + (lastIndex + 1) + " " + indexOf + seq + ",";
                }
            } else {
                onlyformats = " " + (lastIndex + 1) + " " + indexOf + seq + ",";
            }

            if (!onlyformats.isEmpty()) {

                int fcindex = 1;
                String[] commas = onlyformats.split(",");
                indexs = new ArrayList();

                for (int i = 0; i < commas.length; i++) {
                    String leftindex = onlyformats.substring(fcindex, onlyformats.indexOf(" ", fcindex));

                    indexs.add(Integer.parseInt(leftindex));

                    fcindex = onlyformats.indexOf(",", fcindex) + 2;
                }

                Collections.sort(indexs);
                fcindex = 1;
                int j = 0;
                String finalformat = "";

                for (int i = 0; i < commas.length; i++) {

                    String leftindex = onlyformats.substring(fcindex, onlyformats.indexOf(" ", fcindex));

                    if (indexs.get(j) == Integer.parseInt(leftindex)) {
                        finalformat = finalformat + commas[i] + ",";
                        j++;
                        onlyformats = onlyformats.replace(commas[i] + ",", "");
                        commas = onlyformats.split(",");
                        if (j == indexs.size()) {
                            break;
                        }
                        i = -1;
                        fcindex = 1;
                    } else
                        fcindex = onlyformats.indexOf(",", fcindex) + 2;
                }
                onlyformats = finalformat;
            }
//spanning

            SpannedString middle = SpannedString.valueOf("");
            String[] commas = onlyformats.split(",");
            int nonexist = 0;
            int fcindex=1;
            int fsi;
            int nextleft;
            if (!onlyformats.isEmpty()) {
                for (int i = 0; i < commas.length; i++) {

                    int leftindex = Integer.parseInt(onlyformats.substring(fcindex, fsi = onlyformats.indexOf(" ", fcindex)));
                    int rightindex = Integer.parseInt(onlyformats.substring(fsi + 1, onlyformats.indexOf(" ", fsi + 1)));

                    if ((sentenceselect == 1 || wordoverlap == 1) && (leftindex >= (lastIndex + 1) && rightindex <= indexOf)) {//inside sentence or overlap

                        middle = (SpannedString) TextUtils.concat(middle, wsd(noteview.getText().toString(), commas[i] + ",").subSequence(leftindex, rightindex));

                        if(i<commas.length-1&&(nextleft=Integer.parseInt(commas[i+1].substring(commas[i+1].indexOf(" ") + 1, commas[i+1].indexOf(" ", commas[i+1].indexOf(" ") + 1))))>rightindex){
                            middle = (SpannedString) TextUtils.concat(middle,noteview.getText().toString().substring(rightindex, nextleft));
                        }

                        fcindex = onlyformats.indexOf(",", fcindex) + 2;
                        continue;

                    }else if (leftindex == (lastIndex + 1) && rightindex == indexOf) {//selected word

                        middle = wsd(noteview.getText().toString(), commas[i] + ",");
                        middle = (SpannedString) middle.subSequence(lastIndex + 1, indexOf);
                        break;
                    } else
                        nonexist++;

                    fcindex = onlyformats.indexOf(",", fcindex) + 2;
                }
            }
            if (nonexist == commas.length || onlyformats.isEmpty()) {//all spans removed

                middle = SpannedString.valueOf(noteview.getText().toString());
                middle = (SpannedString) middle.subSequence(lastIndex + 1, indexOf);
            }


            if (right == null && left == null) {
                allS = new SpannedString( TextUtils.concat(middle));
            } else if (left == null) {
                allS = new SpannedString (TextUtils.concat(middle, right));
            } else if (right == null) {
                allS = new SpannedString(TextUtils.concat(left, middle));
            } else{

                if(leftwordformat!=null){

                    left=(SpannedString) TextUtils.concat(left.toString().equals(left.toString().substring(firstleft,(lastIndex+1)))?"":left.subSequence(0,firstleft),wsd(left.toString(),leftwordformat.toString()).subSequence(firstleft,(lastIndex+1)));
                }

                allS= new SpannedString(TextUtils.concat(left, middle,right));

            }



            Toast.makeText(getthenote.this, "Current word is :" + middle, Toast.LENGTH_SHORT).show();

            Toast.makeText(this, allS, Toast.LENGTH_SHORT).show();


            noteview.setText(allS);
            noteview.setSelection(indexOf);
            spanselection();
            Toast.makeText(getthenote.this, onlyformats, Toast.LENGTH_LONG).show();
        }
    }

    private void selection(){
        spanclick=1;


        selectionStart = noteview.getSelectionStart();
        selectionEnd = noteview.getSelectionEnd();



        lastIndex = selectionStart - 1;
        indexOf = selectionEnd;

        if (selectionStart < selectionEnd) {
            searchToken = noteview.getText().toString().substring(selectionStart, selectionEnd);
        } else {
            lastIndex = noteview.getText().toString().lastIndexOf(" ", selectionStart - 1);
            int lastIndex2 = noteview.getText().toString().lastIndexOf('\n', selectionStart - 1);
            if (lastIndex == -1 || lastIndex2 > lastIndex) {
                lastIndex = lastIndex2;
            }


            indexOf = noteview.getText().toString().indexOf(" ", lastIndex + 1);
            int indexOf2 = noteview.getText().toString().indexOf('\n', lastIndex + 1);
            if (indexOf == -1 || indexOf2 < indexOf && indexOf2 != -1) {
                indexOf = indexOf2;
            }


            searchToken = noteview.getText().toString().substring(lastIndex + 1, indexOf == -1 ? noteview.getText().toString().length() : indexOf);
        }
        if (lastIndex == -1) {
            left = null;
        } else
            left = new SpannedString(noteview.getText().subSequence(0, lastIndex + 1));
        try {
            right = new SpannedString(noteview.getText().subSequence(indexOf, noteview.length()));
        } catch (IndexOutOfBoundsException r) {
            right = null;
        }
        if(right!=null&&right.toString().isEmpty()){
            right = null;
        }



        current = new SpannableString(noteview.getText().subSequence(lastIndex + 1, indexOf == -1 ? indexOf = noteview.getText().toString().length() : indexOf));



    }
    private void reinsert(SQLiteDatabase sql,int choice){
        values.clear();
        trch();//resetting trashed page
        sql.execSQL("INSERT INTO " + data.Table2 + " ( " + data.title2 + " , " + data.usageid + " , " + data.id2+ " , " + data.formats+ " , " + data.data2 + " , " + data.color+ " , " + data.type+" ) " + " SELECT " + data.title2 + " , " + data.usageid + " , " + data.id2+ " , " + data.formats + " , " + data.data2 + " , " + data.color+ " , " + data.type+ " FROM " + data.Table2 + " WHERE serial= '" + takenserial[0] + "'");

        if(choice==1){
            values.put(data.title2, repeat);
        }

        g = sql.query(data.Table2, new String[]{"MAX(" + data.serial + ")"}, null, null, null, null, null);
        g.moveToFirst();
        maxr2=g.getString(0);
        values.put(data.id2, serial);

        sql.update(data.Table2, values, "serial=?", new String[]{maxr2});

        values.clear();
    }
    private void trch(){//resetting trashed page
        if(takenserial[2]!=null){
            values.clear();
            values.put(data.trash, (byte[]) null);
            values.put(data.tagid, 0);
        }
    }

    private void addnew(String gettitlen,ArrayList<String>x){
        int y = 1;
        String right="";
        String alll="";
        String allr="";
        ArrayList<Integer> allrights = new <Integer>ArrayList();
        for (int i = 0; i<x.size() ;i++) {
            for (int j = 0; j <x.get(i).length() ;j++) {

                if(x.get(i).equals(gettitlen)){
                    break;
                }
                if(gettitlen.length()-1>=j) {
                    if (x.get(i).charAt(j) == gettitlen.charAt(j)) {
                        alll = alll + x.get(i).charAt(j);
                    }else {
                        alll = "";
                        break;
                    }

                }else {

                    if (!alll.isEmpty()) {
                        allr = x.get(i).substring(alll.length());

                        alll="";
                        allr = allr.trim();
                        if (allr.charAt(0) == '(' && allr.charAt(allr.length() - 1) == ')') {
                            allr = allr.substring(1, allr.length() - 1);
                            for (int k = 0; k < allr.length(); k++) {
                                if (Character.isDigit(allr.charAt(k))) {
                                    right = right + allr.charAt(k);
                                } else{
                                    right="";
                                    break;
                                }

                            }
                        }
                        if (!right.isEmpty()) {
                            allrights.add(Integer.parseInt(right));
                            right="";
                        }

                    }

                    break;
                }

            }
        }
        if(!allrights.isEmpty()) {
            y = y + Collections.max(allrights);
        }
        repeat = gettitlen +" "+"("+y+")";
        allrights = new <Integer>ArrayList();
    }
    private void moveunder(){

        int s,c=0,i,inc=0;
        if(pos>vpos){
            s=pos;
            inc=-1;
            i=pos;
        }else{
            s=pos+1;
            inc=1;
            i=pos+1;
        }
        for(;c<s;c++){
            s1 = serialarray.get(vpos);
            s2 =serialarray.get(i);

            switches(0);

            i=i+inc;
        }

    }

    private void switches(int i){
        db = new data(this);
        sql = db.getWritableDatabase();

        if(i==1) {
            s1 = serialarray.get(vpos);
            s2 = serialarray.get(pos);
        }



        values.clear();

        values.put(data.serial,"0");
        sql.update(data.Table2, values, "serial=?", new String[]{s1});
        values.clear();
        values.put(data.id2,"0");
        sql.update(data.Table2, values, "id2=?", new String[]{s1});


        values.clear();
        values.put(data.serial,s1);
        sql.update(data.Table2, values, "serial=?", new String[]{s2});
        values.clear();
        values.put(data.id2,s1);
        sql.update(data.Table2, values, "id2=?", new String[]{s2});

        values.clear();
        values.put(data.serial,s2);
        sql.update(data.Table2, values, "serial=?", new String[]{"0"});
        values.clear();
        values.put(data.id2,s2);
        sql.update(data.Table2, values, "id2=?", new String[]{"0"});
        values.clear();

        if(vpos==temp) {
            takenserial[0] = s2;
            temp=serialarray.indexOf(s2);
        }
        holdtemp=temp;

    }
    private void lm(int id) {

        switch (id) {
            case 1:
                if (vpos != 0) {
                    s1 = serialarray.get(vpos);
                    s2 = serialarray.get(vpos - 1);
                    switches(0);

                } else
                    Toast.makeText(this, "page is at top", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                if (vpos != serialarray.size() - 1) {
                    s1 =serialarray.get(vpos);
                    s2 = serialarray.get(vpos + 1);
                    switches(0);

                } else
                    Toast.makeText(this, "page is at Bottom", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                if (vpos != 0) {
                    for (int i = 0; i < serialarray.size() - 1; i++) {
                        s1 = serialarray.get(vpos);
                        s2 = serialarray.get(i);
                        switches(0);

                    }
                } else
                    Toast.makeText(this, "page is at top", Toast.LENGTH_SHORT).show();
                break;
            default:
                if (vpos != serialarray.size() - 1) {
                    for (int i = serialarray.size() - 1; i > 0; i--) {
                        s1 =serialarray.get(vpos);
                        s2 = serialarray.get(i);
                        switches(0);
                    }
                } else
                    Toast.makeText(this, "page is at Bottom", Toast.LENGTH_SHORT).show();
        }
    }

    private void trans(int id){
        mnd=1;
        switch(id){
            case 5:
                switches(1);
                break;
            case 6:
                moveunder();
                break;
            default:
                lm(id);
        }
        inside();
        swind=0;
        mnd=0;

    }


    private void choicedialog(){

        final  Dialog c = new Dialog(this);
        c.setContentView(R.layout.copydialog);

        Button onepage = (Button)c.findViewById(R.id.one);
        Button allpages = (Button)c.findViewById(R.id.all);
        if(rep==2){
            onepage.setText("Replace this page only");
            allpages.setText("Replace this page and its subpages");
        }
        allpages.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(rep==2){

                    if(ctd==2) {
                        Toast.makeText(getthenote.this, "Cannot replace here", Toast.LENGTH_SHORT).show();
                    }else
                        delete(serialarray, serial, rep);
                }else
                    cdc=1;
                c.dismiss();
            }
        });
        c.show();
        c.setCanceledOnTouchOutside(false);
        if(rep==0) {
            c.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    if (cdc == 0) {
                        pastetoolbar.setVisibility(View.GONE);
                        replacepage.setVisibility(View.GONE);

                    }
                }
            });
        }
        onepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rep==2){
                    if(ctd==2) {
                        Toast.makeText(getthenote.this, "Cannot replace here", Toast.LENGTH_SHORT).show();
                    }else {
                        rep = 4;
                        delete(serialarray, serial, rep);
                    }
                }else
                    cdc=2;
                c.dismiss();
            }
        });
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contextmenu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {


        db = new data(getthenote.this);
        sql = db.getWritableDatabase();
        c = sql.rawQuery("select * from " + data.Table2, null);
        int id = item.getItemId();
        switch(id){
            case R.id.mvup :
                trans(1);
                break;
            case R.id.mvdn :
                trans(2);
                break;
            case R.id.mvtop :
                trans(3);
                break;
            case R.id.mvun :
                swind=1;
                Toast.makeText(this, "Choose page", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sww:
                swind=2;
                Toast.makeText(this, "Choose page", Toast.LENGTH_SHORT).show();
                break;
            case R.id.copy:
                copym(0);
                break;
            case R.id.cut:
                cutm(0);
                break;
            default:
                trans(4);

        }
        return super.onContextItemSelected(item);
    }
    public boolean onPrepareOptionsMenu(Menu menu) {//prepare menu convert title

        if(dtype==1) {
            menu.findItem(R.id.folder).setTitle("Convert into Document ✎");
        }else
            menu.findItem(R.id.folder).setTitle("Convert into Folder ❒");

        if(intrash!=null||trash!=null){
            menu=trashvs();//trash and intrash visability

        }

        return super.onPrepareOptionsMenu(menu);
    }
    public boolean onCreateOptionsMenu(Menu menu) {


        this.menu=menu;

        getMenuInflater().inflate(R.menu.options,menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        db = new data(getthenote.this);
        sql = db.getWritableDatabase();
        c = sql.rawQuery("select * from " + data.Table2, null);


        int id = item.getItemId();

        if (!titleview.getText().toString().isEmpty() || !noteview.getText().toString().isEmpty()||serial.equals("1")) {


            if (id == R.id.addsub) {

                resetfile();
                nextintent = 1;
                addsub(sql, imm);

            } else if (id == R.id.qs) {
                Intent s = new Intent();
                s.putExtra(Intent.EXTRA_TEXT, titleview.getText().toString());
                s.putExtra(Intent.EXTRA_TEXT, noteview.getText().toString());
                s.setAction(Intent.ACTION_SEND);
                s.setType("text/plain");
                startActivity(s);
            } else if (id == R.id.tagop) {
                nextintent = 2;
                bookmark(sql, c);
            }
            else if (id == R.id.cf) {
                nextintent = 4;
                clearformat(sql);
            } else if (id == R.id.copyp) {
                nextintent = 6;
                copym(nextintent);
            } else if (id == R.id.cutp) {
                nextintent = 7;
                cutm(nextintent);

            } else if (id == R.id.spa) {

                ctd = 0;
                cd = 0;
                holdtemp = temp = -1;
                nextintent = 8;
                cdc = 3;
                Toast.makeText(this, "Browse then click Save as", Toast.LENGTH_SHORT).show();
                Paste.setText("Save as");

                takenserial[0] = serial;
                takenserial[1] = (titleview.getText().toString());
                takenserial[2]=intrash;
                pastetoolbar.setVisibility(View.VISIBLE);
//                replacepage.setVisibility(View.VISIBLE);


            }
        }
        if (id == R.id.tc) {
            nextintent = 9;

            totrashcan();

        }
        if (id == R.id.search) {
            //search and restore inside trashcan

        }
        if (id == R.id.ml) {
            nextintent = 3;
            if((intrash!=null&&(trash == null || !trash.equals("T")))){//to go totrash can when in in trashcan
                Toast.makeText(this, trash, Toast.LENGTH_SHORT).show();
                totrashcan();
            }else{

                home(sql);
            }


        }else if (id == R.id.folder) {



            folderconv();

        }
        if (id == R.id.del) {
            if(add.equals("a")){
                serialarray= new <String>ArrayList();
            }
            if(saved.equals("s")||serial.equals("1")) {
                delete(serialarray, serial, 0);
            }
        }
        else if (id == R.id.edit) {
            //RESTORE TO BE ADDED
//todo make based on led
            if(toppanel.getVisibility()==View.GONE){
                resetfile();

//                led.setVisibility(View.VISIBLE);
                all.setVisibility(View.VISIBLE);
                toppanel.setVisibility(View.VISIBLE);
                if(dtype==1){
                    noteview.setVisibility(View.VISIBLE);


                }
                edcl=1;
            }else {
                led.setVisibility(View.GONE);
                all.setVisibility(View.GONE);
                toppanel.setVisibility(View.GONE);
                if(dtype==1){
                    noteview.setVisibility(View.GONE);
                }
                edcl=0;
            }

        }
        return super.onOptionsItemSelected(item);
    }
    private void cutm(int ni){

        if (save(sql) == 1)
        {
            dialog();
            return;
        }



        nextintent=0;
        if(ni==7){
            cd=0;
            ctd=2;
            temp=cutback;
            holdtemp=temp;
            takenserial[0]=(serial);
            takenserial[1]=(titleview.getText().toString());
            takenserial[2]=intrash;
        }else {
            cd=0;
            ctd=1;
            temp = vpos;
            holdtemp = temp;
            takenserial[0] = (serialarray.get(vpos));
            takenserial[1] = (suba.get(vpos));
            takenserial[2]=intrash;
        }
        Paste.setText("Paste");
        pastetoolbar.setVisibility(View.VISIBLE);
//        replacepage.setVisibility(View.VISIBLE);
        Toast.makeText(this, "Page cut", Toast.LENGTH_SHORT).show();
    }
    private void totrashcan(){

        if(add.equals("a")){//remove what the addsub added to remove similarity of trashcan text
            salist.remove(salist.get(salist.size()-1));
            serlist.remove(serlist.get(serlist.size()-1));
        }
        if (save(sql) == 1)
        {
            dialog();
            return;
        }
        similarityarray = suba;
        serialsimarray = serialarray;

        serial="1";
        tagclick = 0;
        inside();

    }
    private void copym(int ni){
        if (save(sql) == 1)// the already opened page
        {
            dialog();
            return;
        }

        ctd=0;
        cd=1;
        nextintent = 0;
        if(ni==6){
            takenserial[0]=(serial);
            takenserial[1]=(titleview.getText().toString());
            takenserial[2]=intrash;
            if(!suba.isEmpty()){
                choicedialog();
            }else
                cdc=2;
        }else {

            holdtemp = -1;
            takenserial[0] = (serialarray.get(vpos));
            takenserial[1] = (suba.get(vpos));
            takenserial[2]=intrash;
            g=sql.rawQuery("SELECT id2" + " FROM " + data.Table2 + " WHERE id2=?" ,new String [] {takenserial[0]});
            g.moveToFirst();
            if(g.getCount()>0){
                choicedialog();
            }else
                cdc=2;
        }
        Paste.setText("Paste");

        pastetoolbar.setVisibility(View.VISIBLE);
//        replacepage.setVisibility(View.VISIBLE);
        Toast.makeText(this, "Page copied", Toast.LENGTH_SHORT).show();
    }
    private void home(SQLiteDatabase sql){
        if(save(sql)==1){
            dialog();
            return;
        }
        Intent back = new Intent(getthenote.this, Main.class);
        if(ctd!=0||cd==1) {
            if(cd==1){
                back.putExtra("cc",cdc);
            }
            back.putExtra("temp", holdtemp);
            back.putExtra("tkenserial", takenserial);
        }
        back.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(back);
        finish();
        nextintent=0;
    }
    private void folderconv(){

        if(dtype==0) {
            dtype = 1;
            if(saved.equals("s")) {
                values.clear();
                values.put(data.type,1);
                sql.update(data.Table2, values, "serial=?", new String[]{serial});
            }

            typeswitch();

            Toast.makeText(this, "Coverted into folder", Toast.LENGTH_SHORT).show();
        }else{
            dtype = 0;
            if(saved.equals("s")) {
                values.clear();
                values.put(data.type, 0);
                sql.update(data.Table2, values, "serial=?", new String[]{serial});
            }
            typeswitch();

            Toast.makeText(this, "Coverted into Document", Toast.LENGTH_SHORT).show();

        }

    }
    private void bookmark(SQLiteDatabase sql,Cursor c){
        if (save(sql) == 1) {
            dialog();
            return;
        } else
            save(sql);



        tagclick = 0;
        values = new ContentValues();
        c.moveToFirst();
        do {
            String title = c.getString(c.getColumnIndex(data.title2));
            int tagid = c.getInt(c.getColumnIndex(data.tagid));

            if (title!=null&&title.equals(titleview.getText().toString())) {
                if (tagid == 1) {
                    values.put(data.tagid, 0);
                    sql.update(data.Table2, values, "serial=?", new String[]{serial});
                    Toast.makeText(this, "Un Bookmarked successfully", Toast.LENGTH_SHORT).show();
                    break;
                } else {
                    values.put(data.tagid, 1);//bookmark

                    if(intrash!=null) {//for archiving
                        Toast.makeText(this, "Archived successfully", Toast.LENGTH_SHORT).show();
                    }else
                        Toast.makeText(this, "Bookmarked successfully", Toast.LENGTH_SHORT).show();
                }
                sql.update(data.Table2, values, "serial=?", new String[]{serial});

                break;
            }
        } while (c.moveToNext());
        nextintent=0;

    }
    private void clearformat(SQLiteDatabase sql){
        if(save(sql)==1){
            dialog();
            return;
        }else
            save(sql);
        noteview.getText().clearSpans();
        onlyformats="";
        nextintent=0;
    }
    private void inside(){


        db = new data(getthenote.this);
        sql = db.getWritableDatabase();
        c = sql.rawQuery("select * from " + data.Table2, null);



        if(tagclick==0&&mnd==0) {
            led.setVisibility(View.GONE);
            toppanel.setVisibility(View.GONE);
            noteview.setVisibility(View.VISIBLE);
        }

        if(col==1&&mnd==0) {

            all.setVisibility(View.VISIBLE);
            col = 0;

        }

        del = "";
        add = "";
        snote=0;



        temp=-1;


        serialarray = new <String>ArrayList();
        suba = new <Spanned>ArrayList();
        shown = new <SpannedString>ArrayList();
        bcarray=new <Integer>ArrayList();
        int oldusageid = usageid;

        c.moveToFirst();


        do {
            String title = c.getString(c.getColumnIndex(data.title2));
            String idn = c.getString(c.getColumnIndex(data.id2));
            String datas = c.getString(c.getColumnIndex(data.data2));
            String serialn=c.getString(c.getColumnIndex(data.serial));
            String formatsn=c.getString(c.getColumnIndex(data.formats));
            String trashn= c.getString(c.getColumnIndex(data.trash));
            int color = c.getInt(c.getColumnIndex(data.color));
            int usageidn = c.getInt(c.getColumnIndex(data.usageid));
            int type = c.getInt(c.getColumnIndex(data.type));




            if (serialn.equals(serial)) {
                gettitle=title;
                subnote = datas;
                usageid = usageidn;
                onlyformats=formatsn;
                Startingonlyformat=formatsn;
                prevString=subnote;
                trash=trashn;


                bcc=color;
                dtype=type;
                noteview.setBackgroundColor(color);
                scv.setBackgroundColor(ColorUtils.setAlphaComponent(color, 127));

            }

            if (idn.equals(serial)) {


                ls(title,type);//spanning listitems

                suba.add(title.trim());
                serialarray.add(serialn);
                bcarray.add(color);
            }

        } while (c.moveToNext());

        typeswitch();//at visability between doc and folder

        if(intrash!=null||trash!=null) {
            if(serial.equals("1")) {//for easy return back

                if (getIntent().getExtras().containsKey("add")&&nextintent!=3) {
                    values.put(data.serial2,"f"+serial);

                }else
                    getIntent().removeExtra("p");

            }
            invalidateOptionsMenu();//restart onprepare
        }

        mainstring = new ArrayAdapter<SpannedString>(this, R.layout.maintemp, R.id.mtv, shown) {



            public View getView(int position, View convertView, ViewGroup parent) {//for items color
                View view = super.getView(position,convertView,parent);



                FrameLayout fm = view.findViewById(R.id.fram);

                fm.setBackgroundColor( ColorUtils.setAlphaComponent(bcarray.get(position), 127));


                TextView textPart = view.findViewById(R.id.mtv);

                textPart.setBackgroundColor(bcarray.get(position));

                return  view;
            }
        };
        sub.setAdapter(mainstring);

        if(pd==1){
            return;
        }
        if(ctd==2||ctd==1) {
            for (int i = 0; i < serialarray.size(); i++) {
                if (serialarray.get(i).equals(takenserial[0])) {
                    ctd=1;
                    temp=holdtemp;
                }
            }

        }

        if(tagclick==1||mnd==1){
            return;
        }



        if(usageid==0){

            if(oldusageid==1) {

                det = 0;

                wtch();
            }
        }else if (usageid==1){

            det = 1;
            noteview.removeTextChangedListener(note);

        }
        noteview.setCursorVisible(true);
        noteview.removeTextChangedListener(notesave);

        titleview.removeTextChangedListener(title);



        if(trash == null || !trash.equals("T")) {//prevent trash deletion
            noteview.setText(wsd(subnote, onlyformats));

            spanselection();
            titleview.setText(gettitle.trim());
        }
        if(nextintent!=3) {//prevent home extra addition

            for (int i = 0; i < serialsimarray.size(); i++) {//for removal of same page from prev stack
                if (serialsimarray.get(i).equals(serial)) {

                    similarityarray.remove(i);
                    serialsimarray.remove(i);
                    cutback = i;
                }

            }
            salist.add(similarityarray);
            serlist.add(serialsimarray);



            notesave();
            titlewatcher();

            values.clear();

            if (getIntent().getExtras().containsKey("p")) {
                values.put(data.serial2,"f"+serial);

            }else if(rep==3) {
                sql.execSQL("UPDATE Table3 SET [serial2] = '"+"f"+serial+"' WHERE [serial2] ='"+maxr+"'");
                return;
            }else
                values.put(data.serial2, serial);


            sql.insert(data.Table3, null, values);
        }
        values.clear();

    }
    private void addsub(SQLiteDatabase sql,InputMethodManager imm){

        del = "";
        if(serial.equals("1")){//to view menu intrash
            bcc=Color.WHITE;
            invalidateOptionsMenu();
        }else
        if (save(sql) == 1) {
            dialog();
            return;
        }



        similarityarray = suba;
        serialsimarray=serialarray;
        salist.add(similarityarray);
        serlist.add(serialsimarray);

        getIntent().removeExtra("p");


        getIntent().removeExtra("a");

        if (usageid == 1) {

            det = 0;

            wtch();
        }
      //  led.setVisibility(View.VISIBLE);
        toppanel.setVisibility(View.VISIBLE);
        noteview.setVisibility(View.VISIBLE);
        all.setVisibility(View.VISIBLE);
        noteview.setBackgroundColor(bcc);
        scv.setBackgroundColor(ColorUtils.setAlphaComponent(bcc, 127));

        onlyformats="";
        add = "a";
        saved = "";
        if(dtype==0||(trash!=null&&!trash.equals("T"))){//TO GET DOCSTART AT TRASH
            titleview.setHint("SubDocument Name");
        }else
            titleview.setHint("Document Name");
        dtype=0;
        noteview.setHint("AddText ✎..");
        noteview.setText("");
        titleview.setText("");
        noteview.requestFocus();
        sub.setAdapter(null);


        imm.showSoftInput(noteview, InputMethodManager.SHOW_IMPLICIT);

        if(!serial.equals("1")){//so it doesn't go over it before the trash
            nextintent=0;
        }

    }
    private void qd(SQLiteDatabase sql){
        sql.delete(data.Table2, "serial=?", new String[]{serial});
        sql.delete(data.Table3, "serial2=?", new String[]{serial});
    }
    private String [] cm(String gettitlen,String subnoten,SQLiteDatabase sql) {

        if(titleview.getText().toString().trim().isEmpty()){
            if(noteview.getText().toString().trim().isEmpty()){

                if(!getIntent().getExtras().containsKey("serial")) {
                    if(add.equals("a")){
                        return new String[]{"2"};
                    }else if(saved.equals("s")) {
                        qd(sql);
                        saved="";
                        return new String[]{"2"};
                    } else
                        return new String[]{"2"};
                }else{
                    if(add.equals("a")) {
                        if(saved.equals("s")) {

                            qd(sql);
                        }
                        return new String[]{"2"};
                    }else {
                        gettitlen = gettitle;
                        subnoten = subnote;
                        return new String[]{"0",gettitlen, subnoten};
                    }
                }

            }else {

                gettitlen = splitlines(noteview.getText().toString(), gettitlen);
            }
        }
        if (sn(gettitlen.trim(),similarityarray,serialsimarray) == 1) {//to prevent overwriting similarity check in trashcan

            if(snote==0) {
                Toast.makeText(getthenote.this, "Note has similar title", Toast.LENGTH_SHORT).show();
                addnew(gettitlen, similarityarray);
                snote=1;
            }


            gettitlen="Copy of ("+gettitlen+")";
            return new String[]{"1",gettitlen};
        } else
            return new String[]{"0", gettitlen};

    }
    private void deletedia(int sel){
        final  Dialog d = new Dialog(getthenote.this);
        d.setContentView(R.layout.deletedialogue);

        TextView head=(TextView)d.findViewById(R.id.dh);
        Button Yes = (Button)d.findViewById(R.id.dy);
        Button No = (Button)d.findViewById(R.id.dn);

        if(sel==2){//for restore
            if(!trash.equals("T")){
                head.setText("Restore?");
            }else
                head.setText("Restore All?");
        }else
        if((intrash!=null&&(trash == null || !trash.equals("T")))){
            head.setText("Sure you want to delete?");
        }
        d.setCanceledOnTouchOutside(false);
        d.show();

        Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                del = "d";
                delete(serialarray, serial, 0);
                d.dismiss();
            }
        });
        No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                d.dismiss();
            }
        });

    }
    private void delete(ArrayList<String> serialarray,String lserial,int lrep){

//todo make sure delete works rightaway
        if (del.equals("")&&lrep==0) {

         /*   if(trash!=null||intrash!=null){
                deletedia(1);
                return;
            }else
                del = "d";*/
            del = "d";
            Toast.makeText(getthenote.this, "click again to delete", Toast.LENGTH_SHORT).show();
        } else {
            del = "di";
/*
            if (del == "ds" || trash != null || intrash != null || (rep > 0)) {//conditions for auto delete)
*/

                if (cd == 1 || ctd > 0) {
                    if (serial.equals(takenserial[0])) {
                        cancel.performClick();

                    }
                }
                db = new data(getthenote.this);
                sql = db.getWritableDatabase();
                c = sql.rawQuery("select * from " + data.Table2, null);


                g = sql.query(data.Table2, new String[]{"MAX(" + data.serial + ")"}, null, null, null, null, null);
                g.moveToFirst();

                if (rep != 4) {
                    if (!serialarray.isEmpty()) {
                        int j = 0;

                        deletearray = serialarray;

                        c.moveToFirst();
                        c.moveToNext();

                        do {
                            String idn = c.getString(c.getColumnIndex(data.id2));
                            String serialn = c.getString(c.getColumnIndex(data.serial));

                            if (idn.equals(deletearray.get(j))) {
                                deletearray.add(serialn);
                            }
                            if (c.moveToNext() == false) {
                                c.moveToFirst();
                                j++;
                            }
                        } while (j != deletearray.size());


                        for (int i = 0; i < deletearray.size(); i++) {
                            if (lrep == 2) {
                                if (deletearray.get(i).equals(takenserial[0])) {

                                } else
                                    sql.delete(data.Table2, "serial=?", new String[]{deletearray.get(i)});
                            } else
                                sql.delete(data.Table2, "serial=?", new String[]{deletearray.get(i)});

                        }

                        deletearray = new <String>ArrayList();
                    }
                }
                maxr = lserial;

            sql.delete(data.Table2, "serial=?", new String[]{lserial});
//todo uncomment
         /*   if ((rep > 0) || (intrash != null && (trash != null ? !trash.equals("T") : true))) {
                    sql.delete(data.Table2, "serial=?", new String[]{lserial});
                }*/

                if (lrep == 4 && ctd == 1) {

                    sql.execSQL("UPDATE Table2 SET [id2] = '" + takenserial[0] + "' WHERE [id2] ='" + maxr + "'");
                }

                if (lrep != 0) {
                    Toast.makeText(getthenote.this, "Replaced", Toast.LENGTH_SHORT).show();
                    if (lrep == 1) {
                        return;
                    }

                } else
                    del = "df";

                Toast.makeText(getthenote.this, "Deleted", Toast.LENGTH_SHORT).show();
           /* } else {
                if ((getIntent().getExtras().containsKey("a") || add.equals("a")) && (titleview.getText().toString().isEmpty() && noteview.getText().toString().isEmpty())) {
                    Toast.makeText(getthenote.this, "Deleted", Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "through here", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                    return;
                }
                serialsimarray = new <String>ArrayList();
                similarityarray = new <String>ArrayList();

                c.moveToFirst();//get the intrash pages for comparison
                do {
                    String ts = c.getString(c.getColumnIndex(data.serial));
                    String tn = c.getString(c.getColumnIndex(data.title2));
                    String id = c.getString(c.getColumnIndex(data.id2));

                    if (id.equals("1")) {
                        serialsimarray.add(ts);
                        similarityarray.add(tn);
                    }
                } while (c.moveToNext());
                String tt = "";
                int sr = sn(tt = subnote.isEmpty() ? (noteview.getText().toString().isEmpty() ? titleview.getText().toString() : noteview.getText().toString()) : subnote, similarityarray, serialsimarray);

                Cursor v = sql.rawQuery("select * from " + data.Table3, null);
                v.moveToLast();
                values.clear();
                if (v.getString(v.getColumnIndex(data.serial2)).charAt(0) != 'f') {//if it has a super
                    v.moveToPrevious();
                    values.put(data.trash, v.getString(v.getColumnIndex(data.serial2)));//previous serial to trash for restoration
                }

                values.put(data.tagid, 0);//remove bookmarked
                values.put(data.id2, 1);


                if (sr == 1) {

                    addnew(tt, similarityarray);

                    values.put(data.title2, repeat);
                } else
                    values.put(data.title2, tt);
                sql.update(data.Table2, values, "serial=?", new String[]{serial});

                serialsimarray = new <String>ArrayList();
                similarityarray = new <String>ArrayList();

                Toast.makeText(getthenote.this, "Moved to TrashCan", Toast.LENGTH_SHORT).show();
            }*/

            onBackPressed();
        }

    }
    private int save(SQLiteDatabase sql) {

        if(del.equals("df")&&rep!=1||del.equals("di")){

            return 0;
        }

        values = new ContentValues();


        if(spanclick==0&&backString!=null) {

            if(acounter==0) {

                noteview.removeTextChangedListener(notesave);



                if (afterc > beforec) {

                    allVs= new SpannedString(allVs.subSequence(rlp,rrp));
                }else
                    allVs= (SpannedString) allVs.subSequence(rlp,rrp);

                if (rrp == noteview.length()) {

                    if (noteview.getText().toString().equals(allVs.toString())) {

                        noteview.setText(allVs);
                    } else
                        noteview.setText(new SpannedString(TextUtils.concat(textbefore.subSequence(0, rlp), allVs)));

                } else {

                    noteview.setText(new SpannedString(TextUtils.concat(textbefore.subSequence(0, rlp), allVs, textbefore.subSequence(selectionStart, textbefore.length()))));//text before has different indexes

                }


                removal=0;
                backString = null;
                allVs = new SpannedString("");
                rlp=0;
                rrp=0;
                spaceauto=-1;

                spanselection();
                noteview.addTextChangedListener(notesave);


                if (afterc >= beforec) {
                    noteview.setSelection(selectionEnd + (afterc - beforec));
                } else if (beforec >= afterc) {
                    noteview.setSelection(selectionEnd - (beforec - afterc));
                }
            }
        }

        String gettitlen = titleview.getText().toString();
        String subnoten = (noteview.getText().toString());



        if (saved.equals("s")) {
            if (!cm(gettitlen,subnoten,sql)[0].equals("2")) {

                if (cm(gettitlen,subnoten,sql).length>1) {

                    gettitlen = cm(gettitlen,subnoten,sql)[1];
                    if(cm(gettitlen,subnoten,sql).length==3) {
                        subnoten = cm(gettitlen, subnoten, sql)[2];
                    }
                }

                values.put(data.title2, gettitlen);
                values.put(data.data2, subnoten);
                values.put(data.usageid, det);
                values.put(data.formats, onlyformats);


                sql.update(data.Table2, values, "serial=?", new String[]{serial});

                saved = "s";
                usageid = det;

            }else
                return 2;

        } else if (add.equals("a") || getIntent().getExtras().containsKey("a")) {
            values = new ContentValues();

            if (!cm(gettitlen,subnoten,sql)[0].equals("2")) {

                if (cm(gettitlen,subnoten,sql).length>1) {

                    gettitlen = cm(gettitlen,subnoten,sql)[1];
                    if(cm(gettitlen,subnoten,sql).length==3) {
                        subnoten = cm(gettitlen, subnoten, sql)[2];
                    }
                }

                if (add.equals("a")) {
                    values.put(data.id2, serial);

                }


                values.put(data.usageid, det);
                values.put(data.title2, gettitlen);
                values.put(data.data2, subnoten);
                values.put(data.formats, onlyformats);
                values.put(data.color, bcc);
                values.put(data.type, dtype);

                sql.insert(data.Table2, null, values);

                g = sql.query(data.Table2, new String[]{"MAX(" + data.serial + ")"}, null, null, null, null, null);
                g.moveToFirst();

                serial = g.getString(0);
                saved = "s";



                values.clear();

                if (getIntent().getExtras().containsKey("add")) {
                    values.put(data.serial2, "f" + serial);
                    getIntent().removeExtra("add");
                } else
                    values.put(data.serial2, serial);

                sql.insert(data.Table3, null, values);

                usageid = det;

                values.clear();


            }else
                return 2;

        }
        gettitlen = titleview.getText().toString();
        if (cm(gettitlen, subnoten, sql).length==2&&cm(gettitlen, subnoten, sql)[0].equals("1")) {
            return 1;
        }
        return  0;
    }
    private int sn( String g,ArrayList <String> similarity,ArrayList <String> serialsimilarity){

        if (similarity==null||similarity.size() == 0||serial.equals("1"))  {
            return 0;
        }
        int i=0;
        do{
            if(g.equals(similarity.get(i))){
                repserial=serialsimilarity.get(i);

                return  1;
            }
            i++;
        }while (i<similarity.size());

        return 0;
    }
    private void wtch(){


        note=new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                ndet=1;

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String e = s.toString();


                det = 0;
                ndet=1;


                try {

                    e = splitlines(e, e);
                    if(titleview.getLineCount()<=4) {
                        if (e == null) {
                            titleview.setText(e);
                        } else
                            titleview.setText(e.trim());
                    }
                } catch (StringIndexOutOfBoundsException v) {
                    e = e + "\n";

                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        };
        noteview.addTextChangedListener(note);

    }
    private void titlewatcher(){


        title=(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                if(dtype==1&&noteview.getText().toString().isEmpty()&&titleview.getText().toString().isEmpty()){//because at folder convert user types automatically without touching
                    titleinitialize();
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String e = s.toString();

                if(ndet==0) {

                  //  led.setVisibility(View.VISIBLE);


                    if (e.contains("\n")) {

                        if (noteview.getText().toString().isEmpty()) {
                            titleview.setText(e.substring(0,e.length()-1));
                        } else
                            titleview.setText(splitlines(noteview.getText().toString(), e).trim());
                        noteview.requestFocus();

                    }


                }

                if(!titleview.getText().toString().isEmpty()) {
                    if (det == 1) {
                        db = new data(getthenote.this);
                        sql = db.getWritableDatabase();
                        save(sql);
                    }
                }
            }




            @Override
            public void afterTextChanged(Editable s) {


            }


        });
        titleview.addTextChangedListener(title);
    }
    private void touch(){

        sub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                resetfile();
                tt=0;
                return false;
            }
        });

        noteview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                resetfile();
                tt=0;


                return false;
            }
        });
        titleview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return titleinitialize();



            }
        });
    }
    private boolean titleinitialize(){
        det = 1;
        ndet=0;
        noteview.removeTextChangedListener(note);



        paratitle = titleview.getLayoutParams();
        paratitle.height = ViewGroup.LayoutParams.WRAP_CONTENT;

        titleview.setLayoutParams(paratitle);



        String b="";

        if (tt == 0) {

            titleview.requestFocus();
            titleview.selectAll();
            titleview.setSelectAllOnFocus(true);

            tt = 1;

            b=splitlines(noteview.getText().toString(),b);
            if(b!=null) {
                if (!b.equals(titleview.getText().toString())) {
                    Toast.makeText(getthenote.this, "Press enter to get first line", Toast.LENGTH_SHORT).show();
                }
            }

            return true;

        } else {



            return false;
        }
    }
    private void handler2(int zeroc){

        if(zeroc==0){
            handler.removeCallbacksAndMessages(null);
        }else {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    Toast.makeText(getthenote.this, "hndler executed", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getthenote.this, "start"+cstart, Toast.LENGTH_SHORT).show();
                    Toast.makeText(getthenote.this, "end"+selectionStart, Toast.LENGTH_SHORT).show();

                    String[] commas = onlyformats.split(",");
                    int fcindex = 1;
                    int fsi, ssi;

                    for (int h = 0; h < commas.length; h++) {

                        int leftindex = Integer.parseInt(onlyformats.substring(fcindex, fsi = onlyformats.indexOf(" ", fcindex)));
                        int rightindex = Integer.parseInt(onlyformats.substring(fsi + 1, ssi = onlyformats.indexOf(" ", fsi + 1)));

                        if(((leftindex>=(cstart)&&rightindex<selectionStart)||(leftindex>(cstart)&&rightindex<=selectionStart))){
                            onlyformats=onlyformats.replace(commas[h]+",","");
                            Toast.makeText(getthenote.this, "hndler executed", Toast.LENGTH_SHORT).show();
                            continue;
                        }
                        fcindex = onlyformats.indexOf(",", ssi) + 2;
                    }
                }
            }, 200);
        }
    }
    private void handler3(int zerocn) {

        if(zerocn==2) {
            handler2.removeCallbacksAndMessages(null);
        } else {

            handler2.postDelayed(new Runnable() {
                @Override
                public void run() {

                    zeroc = 0;

                }
            }, 200);
        }
    }
    public void notesave(){

        notesave=new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {



                if (spanclick==0) {
                    afterc = after;
                    cstart=start;

                    tempbefore=new SpannedString(noteview.getText());


                    if(sp==0){
                        selectionStart = noteview.getSelectionStart();
                        selectionEnd=selectionStart;
                    }
                }
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (spanclick==0) {
                    beforec = before;


                }

                numberc=s.length();
               // led.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {





                if (spanclick==0) {

                    if (!onlyformats.isEmpty()) {



                        String[] commas = onlyformats.split(",");
                        StringBuffer replacedformat;
                        int leftindex=0;
                        int rightindex =0;
                        int prevright=-1;

                        if (abs(afterc - beforec) > 0) {

                            if (prevString.length() != s.toString().length()){
                                if (textbefore == null) {
                                    textbefore = tempbefore;

                                }


                                if(afterc!=0&&s.toString().substring(cstart,selectionEnd+(afterc-beforec)).contains(" ")&&(afterc <= beforec || s.toString().charAt(selectionStart) != ' ')){//to detect autocorrected words with spaces

                                    spaceauto=1;//to directly insert it in resetting condition

                                }
                            }
                            if (acounter >= 1 && prevString.length() != s.toString().length()) {

                                if(zeroc==1){

                                    zeroc=0;

                                    handler2(zeroc);


                                }
                                acounter = 0;


                            }


                        }
                        if (abs(afterc - beforec) == 0) {

                            if (textbefore == null) {
                                textbefore = tempbefore;
                            }
                            if(zeroc==2){
                                handler3(2);
                                zeroc=0;
                                acounter++;
                            }else {
                                if (prevString.equals(s.toString())) {

                                    zeroc = 1;
                                    acounter++;
                                    handler2(zeroc);
                                } else {

                                    acounter = 0;
                                    handler3(0);
                                    zeroc = 2;
                                }
                            }

                        }


                        if (acounter == 0) {
                            StringBuffer nof = new StringBuffer(onlyformats);


                            int fcindex = 1;

                            int fsi, ssi;
                            allVs=new SpannedString(s.toString());

                            if(spaceauto>0){
                                resetm(s.toString());

                            }else {
                                for (int h = 0; h < commas.length; h++) {


                                    leftindex = Integer.parseInt(nof.substring(fcindex, fsi = nof.indexOf(" ", fcindex)));
                                    rightindex = Integer.parseInt(nof.substring(fsi + 1, ssi = nof.indexOf(" ", fsi + 1)));


                                    if ((selectionStart == selectionEnd && (rightindex <= selectionStart))) {//resetting of char spans
                                        /*prevent error in removal*/
                                        if ((leftindex >= 0 && (leftindex == 0 ? s.length() - 1 > rightindex && s.toString().charAt(rightindex) != ' ' : s.toString().charAt(leftindex - 1) != ' ' && ((beforec > afterc && selectionStart == rightindex && rightindex == leftindex + 1) || s.toString().charAt(leftindex) != ' '/*toprevent middle word from un span*/)) && (rightindex >= selectionStart || s.toString().charAt(rightindex - 1) != ' ')) || (rightindex < selectionStart && s.toString().charAt(rightindex - 1) != ' ' && (leftindex <= 0 || s.toString().charAt(leftindex) != ' '))) {


                                            int y = leftindex;
                                            while (--y >= 0 && !Character.isWhitespace(s.toString().charAt(y))) {

                                            }

                                            rlp = y + 1;//final left


                                            if (afterc > beforec) {
                                                rrp = selectionStart + (afterc - beforec);//added after-before so it works in added words in text autocorrect handler
                                            } else if ((beforec > afterc)) {
                                                rrp = selectionStart - 1;//selection start if the cursor is after right jndex with a char then backspaces
                                            } else
                                                rrp = selectionStart;//final right

                                            if (rightindex == selectionStart) {
                                                backString = "";
                                            } else if (afterc > beforec) {
                                                backString = s.toString().substring(rightindex, selectionStart);
                                            } else {

                                                backString = s.toString().substring(rightindex, selectionStart - 1);
                                            }

                                            if (!backString.contains(" ")) {
                                                if (leftindex + 1 != rightindex) {
                                                    if ((rrp == rightindex - 1) || (rrp == rightindex + (afterc - beforec) && afterc > beforec && s.toString().charAt(selectionStart) != ' ')) {//changing span according to shifts
                                                        replacedformat = new StringBuffer(commas[h]).replace(commas[h].indexOf(" ", 1) + 1, commas[h].indexOf(" ", commas[h].indexOf(" ", 1) + 1), String.valueOf(rrp));//right change

                                                    } else {

                                                        replacedformat = new StringBuffer(commas[h]);
                                                    }


                                                    allVs = wsd(s.toString(), replacedformat + ",");
                                                }
                                                if (afterc > beforec && commas.length - 1 > h && selectionStart >= Integer.parseInt(commas[h + 1].substring(commas[h + 1].indexOf(" ") + 1, commas[h + 1].indexOf(" ", 1))) && selectionStart < Integer.parseInt(commas[h + 1].substring(commas[h + 1].indexOf(" ", 1) + 1, commas[h + 1].indexOf(" ", commas[h + 1].indexOf(" ", 1) + 1))) && rrp != rightindex + (afterc - beforec) && s.toString().charAt(selectionStart) != ' ') {//after span that didn't enter current span prevent space so it enters second reset
                                                    replacedformat = new StringBuffer(commas[h + 1]).replace(commas[h + 1].indexOf(" ", 1) + 1, commas[h + 1].indexOf(" ", commas[h + 1].indexOf(" ", 1) + 1), String.valueOf(rrp));//right change
                                                    allVs = wsd(s.toString(), replacedformat + ",");
                                                }

                                            } else
                                                backString = null;


                                            Toast.makeText(getthenote.this, String.valueOf(backString), Toast.LENGTH_SHORT).show();


                                        }

                                    }

                                    if ((abs(afterc - beforec) == 0) && ((leftindex >= cstart && rightindex < selectionStart) || (leftindex > cstart && rightindex <= selectionStart))) {

                                    } else {


                                        if (selectionStart < selectionEnd) {
                                            if (selectionStart <= leftindex && rightindex <= selectionEnd) {


                                                if (afterc == 0) {
                                                    removal = 1;

                                                    nof = nof.replace(fcindex - 1, nof.indexOf(",", fsi) + 1, "");
                                                    continue;

                                                } else if ((afterc > beforec)) {
                                                    rightindex = rightindex + (afterc - beforec);
                                                    nof = nof.replace(fsi + 1, ssi, String.valueOf(rightindex));
                                                } else if ((beforec > afterc)) {//when adding a character

                                                    if(rightindex<selectionEnd){

                                                        nof = nof.replace(fcindex - 1, nof.indexOf(",", fsi) + 1, "");//removal
                                                        continue;


                                                    }else if(leftindex==selectionStart){
                                                        rightindex = rightindex - (beforec - afterc);
                                                    }else {
                                                        nof = nof.replace(fcindex - 1, nof.indexOf(",", fsi) + 1, "");//removal requires resetting
                                                        spaceauto=1;
                                                        resetm(s.toString());//reset
                                                        continue;
                                                    }
                                                    nof = nof.replace(fsi + 1, ssi, String.valueOf(rightindex));
                                                }
                                                fcindex = nof.indexOf(",", fcindex) + 2;
                                                continue;
                                            } else if (selectionStart <= leftindex && leftindex < selectionEnd) {
                                                leftindex = selectionStart;
                                                rightindex = rightindex + (afterc - beforec);
                                                nof = nof.replace(fcindex, fsi, String.valueOf(leftindex));
                                                nof = nof.replace(fsi + 1, ssi, String.valueOf(rightindex));
                                                fcindex = nof.indexOf(",", fcindex) + 2;
                                                continue;
                                            } else if (selectionStart > leftindex && selectionStart < rightindex && rightindex <= selectionEnd) {


                                                rightindex = rightindex + (afterc - beforec);



                                                nof = nof.replace(fsi + 1, ssi, String.valueOf(rightindex));
                                                fcindex = nof.indexOf(",", fcindex) + 2;
                                                continue;
                                            }

                                        } else if (selectionEnd == leftindex + 1 && beforec > afterc && rightindex == leftindex + 1) {
                                            removal = 1;

                                            nof = nof.replace(fcindex - 1, nof.indexOf(",", fsi) + 1, "");


                                            continue;
                                        }

                                        if (selectionEnd <= leftindex && afterc > beforec) {
                                            prevright = h > 0 ? Integer.parseInt(commas[h - 1].substring(commas[h - 1].indexOf(" ", 1) + 1, commas[h - 1].indexOf(" ", commas[h - 1].indexOf(" ", 1) + 1))) : -1;
                                            /*if something before it*/
                                            if (s.toString().charAt(selectionEnd) != '\n' && s.toString().charAt(selectionEnd) != ' ' && selectionEnd == leftindex && (selectionEnd <= 0 || !(h > 0 && prevright == leftindex)/*else just shift right*/)) {
                                                rightindex = rightindex + (afterc - beforec);
                                                nof = nof.replace(fsi + 1, ssi, String.valueOf(rightindex));
                                                prevright = -1;//to prevent from going to the first reset condition
                                            } else {

                                                leftindex = leftindex + (afterc - beforec);
                                                rightindex = rightindex + (afterc - beforec);
                                                nof = nof.replace(fsi + 1, ssi, String.valueOf(rightindex));
                                                nof = nof.replace(fcindex, fsi, String.valueOf(leftindex));
                                            }
                                        } else if (selectionEnd <= leftindex && beforec > afterc) {

                                            leftindex = leftindex - (beforec - afterc);
                                            rightindex = rightindex - (beforec - afterc);

                                            nof = nof.replace(fsi + 1, ssi, String.valueOf(rightindex));
                                            nof = nof.replace(fcindex, fsi, String.valueOf(leftindex));


                                        } else if (selectionEnd > leftindex && selectionEnd < rightindex) {
                                            if (afterc > beforec) {
                                                rightindex = rightindex + (afterc - beforec);
                                            } else
                                                rightindex = rightindex - (beforec - afterc);

                                            nof = nof.replace(fsi + 1, ssi, String.valueOf(rightindex));
                                        } else if (selectionStart == rightindex && afterc > beforec && s.toString().charAt(selectionStart) != ' ' && s.toString().charAt(selectionStart - 1) != ' ' && s.toString().charAt(selectionEnd) != '\n') {

                                            Toast.makeText(getthenote.this, "shifted", Toast.LENGTH_SHORT).show();

                                            rightindex = rightindex + (afterc - beforec);
                                            nof = nof.replace(fsi + 1, ssi, String.valueOf(rightindex));

                                        } else if (selectionStart == rightindex && beforec > afterc) {
                                            rightindex = rightindex - (beforec - afterc);
                                            nof = nof.replace(fsi + 1, ssi, String.valueOf(rightindex));
                                        }


                                        if (leftindex > 0/*leftwasalreadyadded*/ && afterc > beforec && ((!commas[h].contains("nh") && ((selectionEnd == leftindex - 1 && s.toString().charAt(selectionEnd) == ' ') || (selectionEnd == leftindex && s.toString().charAt(selectionEnd + 1) == ' ' && s.toString().charAt(selectionEnd - 1) != ' ')/*when back has char right span must extend if left has space*/)) || (selectionEnd == leftindex - 1 &&s.toString().charAt(selectionEnd) != ' '&& h > 0 && prevright == leftindex - 1))) {//for highlght and span with a previousspan only
                                            Toast.makeText(getthenote.this, "reset", Toast.LENGTH_SHORT).show();
                                            backString = "";

                                            if (h > 0 && prevright == leftindex - 1) {
                                                rlp = Integer.parseInt(commas[h - 1].substring(1, commas[h - 1].indexOf(" ", 1)));
                                                rrp = leftindex;

                                                replacedformat = new StringBuffer(commas[h - 1].replaceFirst(" " + prevright, " " + leftindex));


                                            } else {
                                                rlp = leftindex - 1;
                                                rrp = leftindex;

                                                if (s.toString().charAt(selectionEnd + 1) == ' ' && s.toString().charAt(selectionEnd - 1) != ' ') {/*when back has char right span must extend if left has space*/
                                                    rrp = leftindex + 1;
                                                    replacedformat = new StringBuffer(commas[h]);
                                                } else
                                                    replacedformat = new StringBuffer();


                                            }

                                            allVs = wsd(s.toString(), replacedformat + ",");
                                        } else if (leftindex < selectionStart && rightindex > selectionStart && s.toString().charAt(selectionStart) == ' ') {//for splits
                                            String rf = "";
                                            StringBuffer formfill = new StringBuffer(commas[h] + ",");


                                            String restright = nof.substring(nof.toString().indexOf(",", fcindex) + 1, nof.length());
                                            nof = new StringBuffer(nof.substring(0, fcindex - 1) + (rf = new String(formfill.replace(formfill.indexOf(" ", 1) + 1, formfill.indexOf(" ", formfill.indexOf(" ", 1) + 1), String.valueOf(selectionStart)))));

                                            formfill.replace(formfill.indexOf(" ", 1) + 1, formfill.indexOf(" ", formfill.indexOf(" ", 1) + 1), String.valueOf(rightindex));
                                            nof = new StringBuffer(nof.toString() + formfill.replace(formfill.indexOf(" ") + 1, formfill.indexOf(" ", formfill.indexOf(" ") + 1), String.valueOf(selectionStart + 1)));
                                            fcindex = nof.length() + 1;

                                            nof = new StringBuffer(nof + restright);
                                            backString = "";

                                            allVs = wsd(s.toString(), rf);
                                            rlp = leftindex;
                                            rrp = selectionStart + 1;
                                            continue;
                                        }


                                        fcindex = nof.indexOf(",", ssi) + 2;
                                    }
                                }
                            }
                            onlyformats = new String(nof);




                        }





                        Toast.makeText(getthenote.this, onlyformats, Toast.LENGTH_SHORT).show();
                    }
                }else{

                    if (spanclick==2) {
                        spanclick=1;
                    }else
                        spanclick=0;
                    afterc=0;
                    beforec=0;
                    backString=null;
                    tempbefore=new SpannedString(noteview.getText());
                    textbefore=tempbefore;
                }




                db = new data(getthenote.this);
                sql = db.getWritableDatabase();
                save(sql);//save


                sp=0;

                if(!onlyformats.isEmpty()) {

                    if (abs(afterc - beforec) > 0) {
                        acounter++;


                        textbefore = null;


                    }

                    prevString=s.toString();

                }

            }

        };
        noteview.addTextChangedListener(notesave);
    }
    private String splitlines(String sp,String res){
        String[] lines = sp.split("\n");
        for (int i = 0; i < lines.length; i++) {
            if (!lines[i].isEmpty()) {
                res = lines[i];
                return res;
            }
        }
        return null;
    }
    private void simcheck(ArrayList <String> x,ArrayList <String> y){
        for(int i =0;i<x.size();i++){
            if(x.get(i).equals(titleview.getText().toString())){
                x.remove(i);
                y.remove(i);
            }
        }
    }
    private void spanselection(){


        watcher = new SpanWatcher() {
            @Override
            public void onSpanAdded(final Spannable text, final Object what,
                                    final int start, final int end) {

                handler();
            }

            @Override
            public void onSpanRemoved(final Spannable text, final Object what,
                                      final int start, final int end) {

            }

            @Override
            public void onSpanChanged(final Spannable text, final Object what,
                                      final int ostart, final int oend, final int nstart, final int nend) {

                handler();

            }
        };

        noteview.getText().setSpan(watcher, 0, noteview.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);



    }
    private void handler(){

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (noteview.hasSelection()) {
                    sp = 1;
                 //   led.setVisibility(View.VISIBLE);
                    selectionStart = noteview.getSelectionStart();

                    selectionEnd = noteview.getSelectionEnd();


                } else{//to get the new selection before changing highlightcolor
                    sp = 0;
                    selectionStart=noteview.getSelectionStart();
                    selectionEnd=selectionStart;
                }

            }
        }, 200);


    }
    private void dialog(){

        db = new data(getthenote.this);
        if(nextintent==1){
            imm.showSoftInput(noteview, InputMethodManager.HIDE_NOT_ALWAYS);
        }



        final SQLiteDatabase sql = db.getWritableDatabase();
        c = sql.rawQuery("select * from " + data.Table2, null);
        final  Dialog d = new Dialog(getthenote.this);
        d.setContentView(R.layout.dialog);

        TextView sdt=(TextView)d.findViewById(R.id.sdt);
        Button replace = (Button)d.findViewById(R.id.rep);
        Button addx = (Button)d.findViewById(R.id.addx);
        saveas = (EditText)d.findViewById(R.id.sa);
        Button save = (Button)d.findViewById(R.id.save);
        Button dontsave = (Button)d.findViewById(R.id.ds);
        Button ok = (Button)d.findViewById(R.id.ok);

        saveas.performClick();
        saveas.setFocusable(true);
        saveas.requestFocus();

        d.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);


        if(!cstacktitle.isEmpty()) {
            dontsave.setVisibility(View.GONE);
            sdt.setText(cstacktitle);
            replace.setText(repltext);
            ok.setText("Don't paste here");

        }else if(nextintent==8){

            replace .setVisibility(View.GONE);
            sdt.setVisibility(View.GONE);
            ok.setVisibility(View.GONE);
            addx.setVisibility(View.GONE);
        }else{
            sdt.setText("Your page has as similar title in previous stack !");
            replace.setText("Replace previous page deleting its subpages");
        }

        addx.setText("Save as "+repeat);

        d.setCanceledOnTouchOutside(false);
        d.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                pd=0;
                rep=0;
                d.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
                imm.hideSoftInputFromWindow(noteview.getWindowToken(), 0);
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cstacktitle="";
                d.dismiss();
            }
        });
        d.show();
        dontsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(add.equals("a")||getIntent().getExtras().containsKey("a")) {
                    noteview.setText("");
                }
                else
                    nosave.performClick();
                d.dismiss();
                switchafter(sql,c);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!cstacktitle.isEmpty()||nextintent==8) {
                    cstacktitle="";
                    if (sn(saveas.getText().toString(), suba, serialarray) == 1) {
                        Toast.makeText(getthenote.this, "There is another similar title", Toast.LENGTH_SHORT).show();
                        dialog();
                        d.dismiss();
                        return;
                    }
                    repeat=saveas.getText().toString();
                    reinsert(sql,1);
                    inside();
                    pd = 0;
                    d.dismiss();
                    return;
                }else{
                    if (sn(saveas.getText().toString(), similarityarray, serialsimarray) == 1) {
                        Toast.makeText(getthenote.this, "There is another similar title", Toast.LENGTH_SHORT).show();
                        dialog();
                        d.dismiss();
                        return;
                    }
                    titleview.setText(saveas.getText().toString());
                }

                det=1;
                save(sql);
                switchafter(sql,c);
                d.dismiss();
            }
        });
        addx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cstacktitle.isEmpty()) {
                    titleview.setText(repeat);
                    d.dismiss();
                }else {
                    reinsert(sql, 1);
                    inside();
                    pd=0;
                    d.dismiss();
                    cstacktitle="";
                    return;
                }
                det=1;
                save(sql);
                switchafter(sql,c);

            }
        });
        replace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rep=1;

                ArrayList <String> repserialarray = new  <String> ArrayList() ;
                c.moveToFirst();

                do {
                    String idn = c.getString(c.getColumnIndex(data.id2));
                    String serialn=c.getString(c.getColumnIndex(data.serial));

                    if (idn.equals(repserial)) {
                        repserialarray.add(serialn);
                    }


                } while (c.moveToNext());


                if(!cstacktitle.isEmpty()){
                    if(repserial==takenserial[0]){
                        d.dismiss();
                        return;
                    }
                    reinsert(sql,0);
                    delete(repserialarray,repserial,rep);
                    rep=0;
                    inside();
                    pd=0;
                    d.dismiss();
                    cstacktitle="";
                }else {
                    simcheck(similarityarray, serialsimarray);
                    delete(repserialarray, repserial, rep);
                    save(sql);
                    d.dismiss();
                    rep = 0;
                    switchafter(sql, c);
                }






            }
        });
    }

    private  void switchafter(SQLiteDatabase sql,Cursor c ){
        if(pd==1){
            Paste.performClick();
            nextintent=0;
            return;
        }
        switch (nextintent){
            case 1:
                addsub(sql,imm);
                break;
            case 2:
                bookmark(sql,c);
                break;
            case 3:
                home(sql);
                break;
            case 4:
                clearformat(sql);
                break;
            case 5:
                sub.performItemClick(null, pos,pos);
                break;
            case 6:
                copym(nextintent);
                break;
            case 7:
                cutm(nextintent);
                break;
            case 8:
                sub.performItemClick(null, pos,pos);
                break;
            case 9:
                totrashcan();
                break;
            default:
                onBackPressed();
                break;
        }

    }

    public void onBackPressed() {

        db = new data(getthenote.this);
        sql = db.getWritableDatabase();



        led.setVisibility(View.GONE);
        toppanel.setVisibility(View.GONE);



        if(!cyanbar.isShown()&&del.isEmpty()) {
            cyanbar.setVisibility(View.VISIBLE);
            return;
        }
        back = new Intent(getthenote.this, Main.class);

        bi();

        back.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        if (getIntent().getExtras().containsKey("a")&&((intrash==null)||serial.equals("1"))) {//for in trash navigation



            if (save(sql) == 1) {
                dialog();
                return;
            } else
                save(sql);

            bi();


            startActivity(back);
            finish();

        } else {


            char start = ' ';


            Cursor v = sql.rawQuery("select * from " + data.Table3, null);
            c = sql.rawQuery("select * from " + data.Table2, null);


            v.moveToLast();
            if (!add.equals("a")) {
                start = v.getString(v.getColumnIndex(data.serial2)).charAt(0);

                if (start == ('f') && rep == 2 || start == ('f') && rep == 4) {
                    rep = 3;
                    rpm();
                    return;
                }
                if (getIntent().getExtras().containsKey("s") && start == ('f')) {
                    if (save(sql) == 1) {
                        dialog();
                        return;
                    }

                    bi();


                    startActivity(back);
                    finish();
                    return;
                } else if (start == ('f')) {
                    back = new Intent(getthenote.this, Main.class);
                    if (save(sql) == 1) {
                        dialog();
                        return;
                    } else
                        save(sql);
                    bi();


                    startActivity(back);
                    finish();
                    return;
                }
            }


            if (v.moveToPrevious() && !add.equals("a")) {

                if (save(sql) == 1) {
                    dialog();
                    return;
                } else if (save(sql) == 0) {
                    sql.delete(data.Table3, "serial2=?", new String[]{serial});
                }

            } else {
                if (save(sql) == 0) {
                    sql.delete(data.Table3, "serial2=?", new String[]{serial});

                } else if (save(sql) == 1) {
                    dialog();
                    return;
                } else if (!saved.equals("s")) {
                    v.moveToNext();
                }

            }

            serial = v.getString(v.getColumnIndex(data.serial2));

            int oldusageid = usageid;


            serialarray = new <String>ArrayList();//positioned afterr back so it doesn't affect list adapter pg49
            suba = new <String>ArrayList();
            shown = new <SpannedString>ArrayList();
            bcarray = new <Integer>ArrayList();

            c.moveToFirst();
            do {
                String datas = c.getString(c.getColumnIndex(data.data2));
                String titlesubs = c.getString(c.getColumnIndex(data.title2));
                String idn = c.getString(c.getColumnIndex(data.id2));
                String serialn = c.getString(c.getColumnIndex(data.serial));
                String formatsn = c.getString(c.getColumnIndex(data.formats));
                String trashn = c.getString(c.getColumnIndex(data.trash));
                int usageidn = c.getInt(c.getColumnIndex(data.usageid));
                int color = c.getInt(c.getColumnIndex(data.color));
                int type = c.getInt(c.getColumnIndex(data.type));

                if (serial.charAt(0) == ('f')) {
                    serial = serial.substring(1);
                }
                if (serialn.equals(serial)) {
                    if (trashn==null&&trash!=null&&trash.equals("T")) {//to remove intrash when out of trash


                        intrash = null;
                        tag.setText("★ View/hide");
                        invalidateOptionsMenu();//restart onprepare
                    }
                    trash = trashn;
                    gettitle = titlesubs;
                    subnote = datas;
                    usageid = usageidn;
                    onlyformats = formatsn;
                    Startingonlyformat = formatsn;
                    prevString = subnote;
                    bcc = color;
                    dtype = type;
                    noteview.setBackgroundColor(color);
                    scv.setBackgroundColor(ColorUtils.setAlphaComponent(color, 127));

                }
                if (idn.equals(serial)) {
                    ls(titlesubs, type);//spanning listitems

                    suba.add(titlesubs.trim());
                    serialarray.add(serialn);
                    bcarray.add(color);
                }


            } while (c.moveToNext());


            if (serial.equals("1")) {


                invalidateOptionsMenu();//restart onprepare
            }


            if (usageid == 0) {

                if (oldusageid == 1) {

                    det = 0;

                    wtch();
                }

            } else if (usageid == 1) {

                det = 1;
                noteview.removeTextChangedListener(note);

            }
            noteview.removeTextChangedListener(notesave);
            titleview.removeTextChangedListener(title);
            noteview.setCursorVisible(true);


            if (trash == null || !trash.equals("T")) {//prevent trash deletion
                noteview.setText(wsd(subnote, onlyformats));
                spanselection();
                titleview.setText(gettitle.trim());
            }

            if (serlist.size() != 0 || salist.size() != 0) {
                serlist.remove(serlist.size() - 1);
                salist.remove(salist.size() - 1);


                similarityarray = salist.get(salist.size() - 1);
                serialsimarray = serlist.get(serlist.size() - 1);
            }



            del = "";
            add = "";
            saved = "s";
            tagclick = 0;
            snote = 0;
            temp = -1;

            notesave();
            titlewatcher();
            typeswitch();//at visability between doc and folder

            mainstring = new ArrayAdapter<SpannedString>(this, R.layout.maintemp, R.id.mtv, shown) {

                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position,convertView,parent);



                    FrameLayout fm = view.findViewById(R.id.fram);

                    fm.setBackgroundColor( ColorUtils.setAlphaComponent(bcarray.get(position), 127));


                    TextView textPart = view.findViewById(R.id.mtv);

                    textPart.setBackgroundColor(bcarray.get(position));

                    return  view;
                }
            };
            sub.setAdapter(mainstring);

            if ((ctd == 2 || ctd == 1)) {// in case of copy or cut

                for (int i = 0; i < serialarray.size(); i++) {
                    if (serialarray.get(i).equals(takenserial[0])) {
                        ctd = 1;
                        temp = holdtemp;

                    }
                }
            }
            if (rep == 2||rep == 4) {
                rpm();
            }



        }
    }
    private void colorDialogue(int dec){

        final Dialog hc = new Dialog(getthenote.this);

        final int decs = dec;
        hc.setContentView(R.layout.backgrounddialog);

        hc.getWindow().getDecorView().setBackgroundResource(android.R.color.transparent);

        Button yellow = (Button) hc.findViewById(R.id.yellow);
        Button lightblue = (Button) hc.findViewById(R.id.lightblue);
        Button lightgreen = (Button) hc.findViewById(R.id.lightgreen);
        Button red = (Button) hc.findViewById(R.id.red);
        Button white = (Button) hc.findViewById(R.id.white);
        Button lightpurpel= (Button) hc.findViewById(R.id.lightpurpel);
        Button lightorang = (Button) hc.findViewById(R.id.lightorange);
        Button pink = (Button) hc.findViewById(R.id.pink);
        acb= (CheckBox) hc.findViewById(R.id.checkBox);
        ccb= (CheckBox) hc.findViewById(R.id.checkBox2);
        hc.show();
        hc.setCanceledOnTouchOutside(true);

        if(decs==2||serialarray.size()==0){
            ccb.setVisibility(View.GONE);
            acb.setVisibility(View.GONE);
        }

        hc.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                imm.showSoftInput(noteview, InputMethodManager.SHOW_IMPLICIT);
            }
        });
        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                colorset(Color.YELLOW,decs);

                hc.dismiss();
            }
        });
        lightblue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                colorset(getResources().getColor(R.color.Lightblue),decs);

                hc.dismiss();
            }
        });

        lightgreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                colorset(getResources().getColor(R.color.Lightgreen),decs);

                hc.dismiss();
            }
        });

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                colorset(getResources().getColor(R.color.redishh),decs);

                hc.dismiss();
            }
        });
        white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                colorset(Color.WHITE,decs);

                hc.dismiss();
            }
        });
        lightpurpel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                colorset(getResources().getColor(R.color.Lightpurpel),decs);

                hc.dismiss();
            }
        });

        lightorang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                colorset(getResources().getColor(R.color.Lightorange),decs);

                hc.dismiss();
            }
        });

        pink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                colorset(getResources().getColor(R.color.pink),decs);

                hc.dismiss();
            }
        });
    }
    private void colorset(int type,int dec ){

        if(dec==1){
            noteview.setBackgroundColor(bcc=type);
            scv.setBackgroundColor(ColorUtils.setAlphaComponent(type, 127));

            if(saved.equals("s")) {

                values.clear();
                values.put(data.color, bcc);
                sql.update(data.Table2, values, "serial=?", new String[]{serial});


                if(acb.isChecked()||ccb.isChecked()) {
                    int j = 0;

                    indeptharray.add(serial);


                    c.moveToFirst();
                    c.moveToNext();
                    do {


                        String cid = c.getString(c.getColumnIndex(data.id2));
                        String serialn = c.getString(c.getColumnIndex(data.serial));


                        if (cid.equals(indeptharray.get(j))) {
                            if(acb.isChecked()) {
                                indeptharray.add(serialn);
                            }
                            sql.update(data.Table2, values, "serial=?", new String[]{serialn});
                        }

                        if (c.moveToNext() == false) {
                            c.moveToFirst();
                            j++;
                        }
                    } while (j != indeptharray.size());

                    indeptharray = new <String>ArrayList();
                    mnd=1;
                    inside();
                    mnd=0;
                }

            }
        }else {
            highchoice.setBackgroundColor(type);
            highlight.setBackgroundColor(type);

            noteview.setSelection(selectionStart, selectionEnd);

        }

    }
    private void resetfile(){
        r = getResources();
        px =(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 44, r.getDisplayMetrics());


        LinearLayout.LayoutParams Params1 = new  LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, px,2.0f);
        titleview.setLayoutParams(Params1);

        tt=0;
    }
    private SpannedString wsd(String text,String onlyformats){
        SpannedString sp = new SpannedString((text));
        if(backString==null&&spanclick==0) {



            int h = sp.length();

            // loop back to the first non-whitespace character
            while (--h >= 0 && Character.isWhitespace(sp.charAt(h))) {
            }

            sp = (SpannedString) sp.subSequence(0, h + 1);
        }else
        if(backString!=null){
            sp=allVs;
        }
        allS=sp;

        if(!onlyformats.isEmpty()){
            Toast.makeText(this, "here", Toast.LENGTH_SHORT).show();
            int fcindex=1;
            int fsi=0,ssi=0,ic,ib,ii,iu;
            SpannedString sleft;
            SpannedString sright;
            String[] commas = onlyformats.split(",");

            for(int i=0;i<commas.length;i++){

                int leftindex=Integer.parseInt(onlyformats.substring(fcindex,fsi=onlyformats.indexOf(" ",fcindex)));
                int rightindex=Integer.parseInt(onlyformats.substring(fsi+1,ssi=onlyformats.indexOf(" ",fsi+1)));

                String  color=onlyformats.substring(ssi+1,ic=onlyformats.indexOf(" ",ssi+1));
                String  bold=onlyformats.substring(ic+1,ib=onlyformats.indexOf(" ",ic+1));
                String  itallic=onlyformats.substring(ib+1,ii=onlyformats.indexOf(" ",ib+1));
                String  underline=onlyformats.substring(ii+1,iu=onlyformats.indexOf(",",ii+1));

                fcindex=iu+2;
                SpannableString toformat;

                if(spaceauto==1){
                    if(leftindex>=cstart&&leftindex<(selectionEnd+(afterc-beforec))){
                        toformat = new SpannableString(sp.subSequence(leftindex, rightindex));
                    }else
                        continue;

                }
                toformat = new SpannableString(sp.subSequence(leftindex, rightindex));


                if(color.charAt(0)=='-') {
                    toformat.setSpan((new BackgroundColorSpan(Integer.parseInt(color))), 0, toformat.length(), 0);
                }
                if(bold.charAt(0)=='b') {
                    toformat.setSpan(new android.text.style.StyleSpan(Typeface.BOLD), 0, toformat.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                }
                if(itallic.charAt(0)=='i') {
                    toformat.setSpan(new android.text.style.StyleSpan(Typeface.ITALIC), 0, toformat.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                }
                if(underline.charAt(0)=='u') {
                    toformat.setSpan((new UnderlineSpan()), 0, toformat.length(), 0);
                }



                if (leftindex == 0) {
                    sleft = null;
                } else
                    sleft = (SpannedString) allS.subSequence(0, leftindex);
                try {
                    sright = (SpannedString) allS.subSequence(rightindex, allS.length());
                } catch (StringIndexOutOfBoundsException r) {
                    sright = null;
                }

                if (sright == null && sleft == null) {
                    allS = (SpannedString) TextUtils.concat(toformat);
                } else if (sleft == null) {
                    allS = (SpannedString) TextUtils.concat(toformat, sright);
                } else if (sright == null) {
                    allS = (SpannedString) TextUtils.concat(sleft, toformat);
                } else
                    allS = (SpannedString) TextUtils.concat(sleft, toformat, sright);



            }



        }
        sp=allS;
        return sp;
    }
    private void typeswitch(){
        if(dtype==1){//AT VISABILITY
            noteview.setHint("(Optional folder description)");


            if(saved.equals("s")||all.getVisibility()==View.GONE){//in addition HIDE the title if saved
                led.setVisibility(View.GONE);
                all.setVisibility(View.GONE);
                noteview.setVisibility(View.GONE);

            }

            titleview.requestFocus();
            titleview.setHint("Folder name");
        }else {
            titleview.setHint("Document title");
            noteview.setHint("AddText ✎..");
            noteview.setVisibility(View.VISIBLE);
            titleview.setVisibility(View.VISIBLE);
            noteview.requestFocus();
        }
    }
    private void bi(){
        back.putExtra("cc", cdc);
        back.putExtra("temp", holdtemp);
        back.putExtra("tkns", takenserial);
    }
    private void resetm(String s){
        allVs= wsd(s,(""));
        rlp=cstart;
        rrp=selectionEnd+(afterc-beforec);
        backString="";
    }
    private void rpm(){
        Paste.performClick();
        if(ctd==1) {
            sub.performItemClick(null, temp,temp);
        }else if (cd==1) {
            serial = maxr2;
            inside();
        }
        rep = 0;
    }
    private void ls(String title,int type){

        SpannableString vct=new SpannableString(TextUtils.concat(type==0?DocIcon:FolIcon,title.trim()));
        vct.setSpan(new RelativeSizeSpan(1f), 0, (type==0?DocIcon+title.trim():FolIcon+title.trim()).length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

        shown.add(new SpannedString(vct));
    }
    private Menu trashvs(){
        if(serial.equals("1")&&nextintent != 1) {//VISABILITY for trash can


            if(nextintent==3&&!getIntent().getExtras().containsKey("add")){//came using home

                similarityarray = salist.get(lali);//to get last back
                serialsimarray = serlist.get(lali);//



                Cursor v = sql.rawQuery("select * from " + data.Table3, null);



                int ct=lali;
                int s= salist.size()-1;
                for(;ct<s;ct++) {

                    v.moveToPosition(((ct+1)));
                    String ts = v.getString(v.getColumnIndex(data.serial2));
                    sql.delete(data.Table3, "serial2=?", new String[]{ts});

                    salist.remove(lali+1);
                    serlist.remove(lali+1);
                }

            }else
                lali=salist.size()-1;

            led.setVisibility(View.GONE);
            toppanel.setVisibility(View.GONE);
            noteview.setVisibility(View.GONE);
            all.setVisibility(View.GONE);


            imm.hideSoftInputFromWindow(noteview.getWindowToken(), 0);//after addusb hie keyboard


            menu.findItem(R.id.folder).setVisible(false);//hide right list
            menu.findItem(R.id.tagop).setVisible(false);//
            menu.findItem(R.id.cutp).setVisible(false);//
            menu.findItem(R.id.copyp).setVisible(false);//
            menu.findItem(R.id.qs).setVisible(false);//
            menu.findItem(R.id.cf).setVisible(false);//
            menu.findItem(R.id.spa).setVisible(false);//
            menu.findItem(R.id.tc).setVisible(false);//

            tag.setText("▦ View/hide");

            if (intrash!=null){
                menu.removeItem((int)('s'));//to remove INTRASH search
            }
            menu.findItem(R.id.edit).setIcon(getResources().getDrawable(R.drawable.restore));//changing the edit icon;


        }else if(nextintent == 1||intrash.equals("T")){//pages inside trashcan
            typeswitch();

            if(menu.findItem((int) ('s'))==null) {
                menu.add(0, (int) ('s'), Menu.NONE, "Search/Findϙ");//adding the search in list
            }
            menu.findItem(R.id.edit).setIcon(getResources().getDrawable(R.drawable.edit));
            menu.findItem(R.id.search).setIcon(getResources().getDrawable(R.drawable.restore));


            menu.findItem(R.id.folder).setVisible(true);//view right list
            menu.findItem(R.id.tagop).setVisible(true);//
            menu.findItem(R.id.cutp).setVisible(true);//
            menu.findItem(R.id.copyp).setVisible(true);//
            menu.findItem(R.id.qs).setVisible(true);//
            menu.findItem(R.id.cf).setVisible(true);//
            menu.findItem(R.id.spa).setVisible(true);//

            menu.findItem(R.id.tagop).setTitle("Archive/UnArchive ▦");



        }
        nextintent = 0;
        return  menu;
    }

}


























package com.omarboshra.zero.nestedpages;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main extends AppCompatActivity {
    Button add;
    ListView mainlist;
    int tagclick=0;
    int temp;
    String [] gettaken= new String [2];
    int cc;
    int vpos=0;
    int holdtemp2=-1;
    int holdtemp=-1;
    int swind=0;
    int cd,ctd=0;
    String  [] takenserial = new String [3] ;
    SpannableString DocIcon;
    SpannableString  FolIcon;
    View pastetoolbar;
    int pos;
    ArrayList<SpannedString> shown = new <SpannedString>ArrayList();
    String icon;
    String [] x= new String [2];
    ArrayList<Integer> bcarray= new <Integer>ArrayList();
    ArrayList <String> maintext = new  <String> ArrayList() ;
    ArrayList <String> serialarray = new  <String> ArrayList() ;
    ArrayAdapter <SpannedString> mainstring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        mainlist = (ListView)findViewById(R.id.ml);

        DocIcon = SpannableString.valueOf("✎");
        FolIcon = SpannableString.valueOf("❒");

        DocIcon.setSpan(new RelativeSizeSpan(1.9f), 0, DocIcon.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        FolIcon.setSpan(new RelativeSizeSpan(1.9f), 0, FolIcon.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);


        android.support.v7.app.ActionBar menu= getSupportActionBar();

        menu.setTitle((Html.fromHtml("<font color=\"#000000\">"+"<big>"+"<b>"+"N"+"</b>"+"</big>"+"<n>"+"ested"+"<b>"+"<i>"+"P"+"</i>"+"</b>"+"ages"+"</n>")));
        menu.setDisplayShowHomeEnabled(true);
        menu.setLogo(R.mipmap.mainicon);
        menu.setDisplayUseLogoEnabled(true);


        data db = new data(Main.this);
        SQLiteDatabase sql = db.getWritableDatabase();
        Cursor c = sql.rawQuery("select * from " + data.Table2, null);
        if(c.getCount()==0) {
            ContentValues values = new ContentValues();//adding the trashcan

            values.put(data.trash, "T");
            sql.insert(data.Table2, null, values);
        }
        sql.delete(data.Table3, null, null);

        pastetoolbar= findViewById(R.id.ptb);//Hiding pastoolbar by default
        pastetoolbar.setVisibility(View.GONE);

        mlq();

        if(getIntent().getExtras()!=null){

            gettaken = getIntent().getStringArrayExtra("tkns");
            holdtemp2 = getIntent().getIntExtra("temp",-1);
            cc=getIntent().getIntExtra("cc",0);
        }
        add = (Button)findViewById(R.id.adn);





        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent tonote = new Intent (Main.this,getthenote.class);
                tonote.putExtra("add",serialarray);
                tonote.putExtra("a",maintext);
                tonote.putExtra("tkns", gettaken );
                tonote.putExtra("temp", holdtemp2 );
                tonote.putExtra("cc", cc );
                tonote.putExtra("s","");

                tonote.putExtra("tknshere", takenserial );


                startActivity(tonote);


            }
        });
        mainlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(ctd==1&&temp==position){
                    ctd=2;
                    Toast.makeText(Main.this, "fel cut", Toast.LENGTH_SHORT).show();
                }
                if (swind == 1) {
                    pos = position;
                    transfers(6);

                } else if (swind == 2) {
                    pos = position;
                    transfers(5);

                }else {
                    String serial = serialarray.get(position);
                    Intent i = new Intent(Main.this, getthenote.class);
                    i.putExtra("serial", serial);
                    i.putExtra("p", maintext);
                    i.putExtra("sa", serialarray);
                    i.putExtra("tkns", gettaken);
                    i.putExtra("cc", cc);
                    i.putExtra("temp", holdtemp2);

                    i.putExtra("tknshere", takenserial);

                    startActivity(i);
                    finish();
                }

            }
        });

        mainlist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                vpos=position;
                return false;
            }
        });
        registerForContextMenu(mainlist);
    }

    private void transfers(int id){
        Intent mar = new Intent(this,getthenote.class);
        mar.putExtra("lm","");
        if(id==5){
            mar.putExtra("sw","");
        }else if(id==6){
            mar.putExtra("mv","");
        }
        mar.putExtra("pos",pos);
        mar.putExtra("vpos",vpos);
        mar.putExtra("tserialarray",serialarray);
        mar.putExtra("takenserial",takenserial[0]);
        mar.putExtra("temp",temp);
        mar.putExtra("holdtemp",holdtemp);
        mar.putExtra("id",id);
        startActivityForResult(mar,1);
        swind=0;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode ==RESULT_OK){
            mlq();
            takenserial[0]=getIntent().getStringExtra("takens");
            holdtemp=getIntent().getIntExtra("holdtemp",-1);
        }
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contextmenu,menu);

        super.onCreateContextMenu(menu, v, menuInfo);
        MenuItem copyItem= menu.getItem(0);
        MenuItem cutItem= menu.getItem(1);
        copyItem.setVisible(false);
        cutItem.setVisible(false);
    }

    public boolean onContextItemSelected(MenuItem item) {


        data db = new data(Main.this);
        SQLiteDatabase sql = db.getWritableDatabase();
        Cursor c = sql.rawQuery("select * from " + data.Table2, null);
        int id = item.getItemId();
        switch(id){
            case R.id.mvup :

                transfers(1);




                break;
            case R.id.mvdn :

                transfers(2);



                break;
            case R.id.mvtop :

                transfers(3);




                break;
            case R.id.mvun :
                swind=1;
                Toast.makeText(this, "Choose page", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sww:
                swind=2;
                Toast.makeText(this, "Choose page", Toast.LENGTH_SHORT).show();
                break;

                //todo add cut copy
        /*    case R.id.copy:
                ctd=0;
                cd=1;
                takenserial[0]=(serialarray.get(vpos));
                takenserial[1]=(maintext.get(vpos));

                //copy method

                pastetoolbar.setVisibility(View.VISIBLE);




                Toast.makeText(this, "Page copied", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cut:
                cd=0;
                ctd=1;

                temp=vpos;
                holdtemp=temp;
                takenserial[0]=(serialarray.get(vpos));
                takenserial[1]=(maintext.get(vpos));
                pastetoolbar.setVisibility(View.VISIBLE);



                Toast.makeText(this, "Page cut", Toast.LENGTH_SHORT).show();
                break;*/
            default:

                transfers(4);




                Toast.makeText(this, "bottom", Toast.LENGTH_SHORT).show();



        }
        return super.onContextItemSelected(item);
    }

    private void mlq(){
        data db = new data(Main.this);
        SQLiteDatabase sql = db.getWritableDatabase();
        Cursor c = sql.rawQuery("select * from "+data.Table2,null);
        shown = new <SpannedString>ArrayList();
        serialarray= new <String>ArrayList();
        maintext= new <String>ArrayList();
        bcarray=new <String>ArrayList();
        if(c.moveToFirst()) {
            do {
                String title = c.getString(c.getColumnIndex(data.title2));
                String idn= c.getString(c.getColumnIndex(data.id2));
                String serial= c.getString(c.getColumnIndex(data.serial));
                String trash= c.getString(c.getColumnIndex(data.trash));
                int color = c.getInt(c.getColumnIndex(data.color));
                int type = c.getInt(c.getColumnIndex(data.type));

                if(idn.isEmpty()&&trash==null) {
                    maintext.add(title.trim());
                    serialarray.add(serial);

                    ls(title,type);//spanning listitems

                    bcarray.add(color);
                }

            } while (c.moveToNext());

        }

        mainstring = new ArrayAdapter <SpannedString>(this,R.layout.maintemp,R.id.mtv,shown){
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position,convertView,parent);

                FrameLayout fm = view.findViewById(R.id.fram);

                fm.setBackgroundColor( ColorUtils.setAlphaComponent(bcarray.get(position), 127));


                TextView textPart = view.findViewById(R.id.mtv);

                textPart.setBackgroundColor(bcarray.get(position));
                return  view;
            }
        };
        mainlist.setAdapter(mainstring);


    }
    private void ls(String title,int type){

        SpannableString vct=new SpannableString(TextUtils.concat(type==0?DocIcon:FolIcon,title.trim()));

        shown.add(new SpannedString(vct));
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainoptions,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        data db = new data(Main.this);
        SQLiteDatabase sql = db.getWritableDatabase();
        Cursor c = sql.rawQuery("select * from " + data.Table2, null);
        shown = new <SpannedString>ArrayList();
        int id = item.getItemId();


        if (id == R.id.tagm) {

            if(tagclick==0) {

                maintext= new <String>ArrayList();
                if (c.moveToFirst()) {

                    do {
                        String title = c.getString(c.getColumnIndex(data.title2));
                        String id2 = c.getString(c.getColumnIndex(data.id2));
                        int tagid = c.getInt(c.getColumnIndex(data.tagid));
                        int type = c.getInt(c.getColumnIndex(data.type));

                        if (tagid > 0 && id2.isEmpty()) {
                            maintext.add(title);

                            ls(title,type);//spanning listitems
                        }

                    } while (c.moveToNext());
                }
                mainstring = new ArrayAdapter <SpannedString>(Main.this,R.layout.maintemp,R.id.mtv,shown){
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View view = super.getView(position,convertView,parent);

                        FrameLayout fm = view.findViewById(R.id.fram);

                        fm.setBackgroundColor( ColorUtils.setAlphaComponent(bcarray.get(position), 127));


                        TextView textPart = view.findViewById(R.id.mtv);

                        textPart.setBackgroundColor(bcarray.get(position));

                        return  view;
                    }
                };
                mainlist.setAdapter(mainstring);
                tagclick = 1;

            }else {
                mlq();
                tagclick = 0;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}

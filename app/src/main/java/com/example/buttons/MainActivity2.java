package com.example.buttons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {

    ListView mlistview;


   String[] Cocktailname={"Agulone","Bluebeery-lemonade","Sazerac","Honey-Lavender-Lemonade","Kiwi-Lemonade","Rum old fashion"};
   String[] Cocktailbeschreibung={"Schmeckt sehr  asdfasd asdf sdgdsg asdgdsfsd dsgdsg gdsfg gregarg rdsfgv rhedgadrg reghae rhrhe raeh aerhg aerre azr hdfh ser","Hmm lecker","Absolut Geilomat","Oh Lavendel","Was schon wieder ohne Alk?","Aaaah endlich Alk"};
   Integer[] Cocktailbild={R.drawable.agulone, R.drawable.bluebeery_lemonade,R.drawable.sazerac,R.drawable.honey_lavender_lemonade,R.drawable.kiwi_lemonade,R.drawable.rum_old_fashioned};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mlistview = (ListView) findViewById(R.id.listview_unsere_rezepte);

        CustomAdaptor customAdaptor=new CustomAdaptor();
        mlistview.setAdapter(customAdaptor);
        mlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if (position==0) {
                    Intent inCocktailactivity= new Intent(view.getContext(),AguloneActivity.class);
                    startActivityForResult(inCocktailactivity,0);
                }

                if (position==1) {
                    Intent inCocktailactivity= new Intent(view.getContext(),BluebeerylemonadeActivity.class);
                    startActivityForResult(inCocktailactivity,1);

                }

                if (position==2) {
                    Intent inCocktailactivity= new Intent(view.getContext(),SazeracActivity.class);
                    startActivityForResult(inCocktailactivity,2);
                }

                if (position==3) {
                    Intent inCocktailactivity= new Intent(view.getContext(),honeylavenderlemonadeActivity.class);
                    startActivityForResult(inCocktailactivity,3);
                }
                if (position==4) {
                    Intent inCocktailactivity= new Intent(view.getContext(),kiwilemonadeActivity.class);
                    startActivityForResult(inCocktailactivity,4);
                }


                if (position==5) {
                    Intent inCocktailactivity= new Intent(view.getContext(),rumoldfashionActivity.class);
                    startActivityForResult(inCocktailactivity,5);
                }
            }
        });






            }



    class CustomAdaptor extends BaseAdapter{


        @Override
        public int getCount() {
            return Cocktailbild.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view= getLayoutInflater().inflate(R.layout.layout_cocktailliste,null);

            ImageView mImageView= view.findViewById(R.id.imageView);
            TextView mTextView= view.findViewById(R.id.textView_Cocktailname);
            TextView mTextView2= view.findViewById(R.id.textView_Cocktailbeschreibung);


            mImageView.setImageResource(Cocktailbild[position]);
            mTextView.setText(Cocktailname[position]);
            mTextView2.setText(Cocktailbeschreibung[position]);
            return view;
        }
    }

}
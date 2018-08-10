package com.example.rakesh.locate_hdfc_atm;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Atm> arrayList;
    MyAdapter m;
    Intent intent;

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayList.size();
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
        public View getView(final int position, View convertView, ViewGroup parent) {
            // 1. get data from sourse array list based on position
            Atm atm = arrayList.get(position);
            int no = atm.getNo();
            String add = atm.getAdd();
            String locality = atm.getLocality();
            String city = atm.getCity();
            final String phoneno = atm.getPhoneno();
            final double lat = atm.getLat();
            final double lon = atm.getLon();

            // 2. Load row xml and all its views
            View view = getLayoutInflater().inflate(R.layout.row,null);
            TextView textView1 = view.findViewById(R.id.textView1);
            TextView textView2 = view.findViewById(R.id.textView2);
            TextView textView3 = view.findViewById(R.id.textView3);
            TextView textView4 = view.findViewById(R.id.textView4);

            ImageView imageView1 = view.findViewById(R.id.call);
            ImageView imageView2 = view.findViewById(R.id.locate);

            // 3. display data on above views
            textView1.setText(""+no+".");
            textView2.setText(add);
            textView3.setText(locality);
            textView4.setText(city);

            imageView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneno));
                    startActivity(intent);
                }
            });


            imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String add = arrayList.get(position).getAdd();

                  // String coord = String.format(Locale.ENGLISH, "%.7f,%.7f", lat, lon);
                    Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                    intent.putExtra("lat",lat);
                    intent.putExtra("lon",lon);
                    intent.putExtra("add",add);

                    startActivity(intent);

                }
            });

            // 4. return row.xml
            return view;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        arrayList  = new ArrayList <Atm>();

        Atm atm1 = new Atm(1,"HGS, Gold Hill Sq Bldg, Hosur Rd","Bommanahalli","Banglore","8061606161",12.9155651,77.6232327);

        Atm atm2 = new Atm(2,"7th Sector, HSR Layout, Roopena Agrahara","Bommanahalli","Banglore","8888477248",12.9103276,77.6264183);

        Atm atm3 = new Atm(3,"NGR Layout","Bommanahalli","Banglore","8061606161",12.9095658,77.6194978);

        Atm atm4 = new Atm(4,"18th Cross Rd, Rajiv Gandhi Nagar, Muneswara Nagar","Bommanahalli","Banglore","8061606161",12.9111122,77.6294573);

        Atm atm5 = new Atm(5,"Canara Bldg, Begur","Bommanahalli","Banglore","8061606161",12.9047232,77.6273298);

        Atm atm6 = new Atm(6,"10th Cross St","Bommanahalli","Banglore","8061606161",12.9036134,77.6261922);

        Atm atm7 = new Atm(7,"674, 9th Main Rd, Sector 7","HSR Layout","Banglore","8061606161",12.9090478,77.6350423);

        Atm atm8 = new Atm(8,"150, 9th Main Rd","HSR Layout","Banglore","8061606161",12.9131253,77.6352899);

        Atm atm9 = new Atm(9,"Teacher's Colony, Jakkasandra, 1st Block ","Koramangala","Banglore","8061606161",12.9179678,77.6317829);

        Atm atm10 = new Atm(10,"Mantri Sarovar, 7th St, Sector 4","HSR Layout","Banglore","8061606161",12.9189369,77.6426062);

        arrayList.add(atm1);
        arrayList.add(atm2);
        arrayList.add(atm3);
        arrayList.add(atm4);
        arrayList.add(atm5);
        arrayList.add(atm6);
        arrayList.add(atm7);
        arrayList.add(atm8);
        arrayList.add(atm9);
        arrayList.add(atm10);

        m = new MyAdapter();
        listView.setAdapter(m);
    }

    public void locate(View view){
        Toast.makeText(this, "locating", Toast.LENGTH_SHORT).show();
    }

}

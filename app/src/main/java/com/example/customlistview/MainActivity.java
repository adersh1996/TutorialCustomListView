package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView list;
    String[] mobiles = {"samsung", "nokia", "mi", "apple", "vivo", "oneplus", "oppo", "moto", "lenovo", "lg", "htc", "sony", "iqoo"};
    int[] images = {R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list = findViewById(R.id.list);
        listAdapter adapter = new listAdapter();
        list.setAdapter(adapter);
    }

    class listAdapter extends BaseAdapter {
        LayoutInflater inflater;

        @Override
        public int getCount() {
            return mobiles.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listitem, null);
            TextView name = convertView.findViewById(R.id.listitemtext);
            ImageView image = convertView.findViewById(R.id.listitemimage);
            name.setText(mobiles[position]);
            image.setImageResource(images[position]);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, mobiles[position], Toast.LENGTH_SHORT).show();
                }
            });
            return convertView;
        }
    }
}
package eu.long1.spacetablayoutdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import eu.long1.spacetablayoutdemo.R;
import eu.long1.spacetablayoutdemo.bean.Berita;

/**
 * Created by putra on 2/25/17.
 */

public class AdapterBerita extends BaseAdapter {

    private Context context;
    private ArrayList<Berita> list;

    private TextView tanggal;
    private TextView judul;
    private TextView isi;
    private LinearLayout llytLayout;
    public AdapterBerita(Context context, ArrayList<Berita> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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
        convertView = LayoutInflater.from(context).inflate(R.layout.filter, parent, false);

        tanggal = (TextView) convertView.findViewById(R.id.tanggal);
        judul = (TextView) convertView.findViewById(R.id.judul);
        isi = (TextView) convertView.findViewById(R.id.isi);
        llytLayout = (LinearLayout) convertView.findViewById(R.id.llyt_layout);

        tanggal.setText(list.get(position).getTanggal());
        judul.setText(list.get(position).getJudul());
        isi.setText(list.get(position).getIsi());

        llytLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "asdf", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
